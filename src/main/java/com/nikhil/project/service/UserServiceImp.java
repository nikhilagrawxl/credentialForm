package com.nikhil.project.service;

import com.nikhil.project.dao.BankDetailsRepository;
import com.nikhil.project.dao.KycRepository;
import com.nikhil.project.dao.UserAddressRepository;
import com.nikhil.project.dao.UserRepository;
import com.nikhil.project.entity.BankDetails;
import com.nikhil.project.entity.Kyc;
import com.nikhil.project.entity.User;
import com.nikhil.project.entity.UserAddress;
import com.nikhil.project.response.SignupMessage;
import com.nikhil.project.response.VerificationMessage;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class UserServiceImp implements UserService{
    private static final Logger logger = LogManager.getLogger(UserServiceImp.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAddressRepository userAddressRepository;
    @Autowired
    private KycRepository kycRepository;
    @Autowired
    private BankDetailsRepository bankDetailsRepository;

    //    @Autowired
//    public UserServiceImp(UserRepository theUserRepository){
//        userRepository=theUserRepository;
//    }
    @Transactional
    @Override
    public SignupMessage signUp(User theUser, UserAddress theUserAddress, Kyc theKyc, BankDetails theBankDetails) {
        logger.info("Signup request received for user: {}", theUser.getFullName());
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String message;
        int otp;
        User user=new User(
                theUser.getFullName(),
                theUser.getRole(),
                theUser.getPassword(),
                theUser.getMobileNo(),
                theUser.isVerify()
        );
        User userSaved= userRepository.save(user);
        UserAddress userAddress=new UserAddress(
                userSaved,
                theUserAddress.getStreetAddress(),
                theUserAddress.getCity(),
                theUserAddress.getState(),
                theUserAddress.getPostalCode(),
                theUserAddress.getCountry()
        );
        executor.execute(() -> userAddressRepository.save(userAddress));
//        userAddressRepository.save(userAddress);

        Kyc kyc=new Kyc(
                userSaved,
                theKyc.getAadharNumber()
        );
        Kyc savedKyc = kycRepository.save(kyc);
//        kycRepository.save(kyc);
        BankDetails bankDetails=new BankDetails(
                userSaved,
                theBankDetails.getAccountNumber(),
                theBankDetails.getIfscCode(),
                savedKyc.getAadharNumber(),
                savedKyc
        );
        executor.execute(() -> bankDetailsRepository.save(bankDetails));
//        bankDetailsRepository.save(bankDetails);
        message = "User created successfully";
        otp=1234;
        logger.debug("User created successfully: {}", userSaved);
        return new SignupMessage(message, true, otp);
    }

    @Override
    public List<User> findAll() {
        try {
            return userRepository.findAll();
        }
        catch (Exception e){
            String message;
            message = "Something error occurred!!!";
            System.out.println(message);
        }
        return null;
    }

    @Override
    public User findById(int theId) {
        try {
            Optional<User> result = userRepository.findById(theId);
            User theUser=null;
            if(result.isPresent()){
                theUser=result.get();
            }
            else{
                // We didn't find the employee
                throw new RuntimeException("Did not find user id: "+theId);
            }
            return theUser;
        }
        catch (Exception e){
            String message;
            message = "Something error occurred!!!";
            System.out.println(message);
        }
        return null;
    }

    @Override
    public User findByName(String fullName) {
        User user=userRepository.findByFullName(fullName);
        return user;
    }

    @Override
    public List<User> logIn(String fullName, String password) {
        // Perform authentication logic (verify credentials, etc.)
        // Assuming this works and returns the authenticated user:
        User user = userRepository.findByFullNameAndPassword(fullName, password);

        // Retrieve user role from the authenticated user object
        User.Role role = user.getRole();
        int id= user.getId();

        // Construct message based on role
        List<User> theUserss = new ArrayList<>();
        switch (role) {
            case ADMIN:
//                message = "Welcome back, Admin!";
                theUserss=findAll();
                break;
            case DEFAULT:
//                message = "Hi " + user.getFullName() + ", happy to see you!";
                User usr=findById(id);
                theUserss.add(usr);
                break;
            default:
//                message = "Login successful!"; // Fallback for unknown roles
        }
        return theUserss;
//        return new LoginMessage(message, true);
    }

    @Override
    public VerificationMessage updateUser(User theUser) {
        theUser.setVerify(true);
        userRepository.save(theUser);
        String message="Verification Successfull";
        return new VerificationMessage(message,true);
    }

    @Override
    public User findByNo(String num) {
        User user=userRepository.findByMobileNo(num);
        return user;
    }
}
