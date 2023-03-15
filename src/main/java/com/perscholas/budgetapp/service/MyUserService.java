package com.perscholas.budgetapp.service;

import com.perscholas.budgetapp.dao.MyUserRepository;
import com.perscholas.budgetapp.models.Budget;
import com.perscholas.budgetapp.models.MyUser;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional(rollbackOn = SQLException.class)
public class MyUserService {

    MyUserRepository userRepository;

    @Autowired
    public MyUserService(MyUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public MyUser authenticateUser(MyUser myUser)  {
        Optional<MyUser> myUserOptional = this.userRepository.findByEmailAllIgnoreCase(myUser.getEmail());
        if (myUserOptional.isPresent() && myUserOptional.get().getPassword().equals(myUser.getPassword())) {
            return myUserOptional.get();
        } else {
            return null;
        }
    }

    public MyUser saveUser(MyUser myUser) {
        return this.userRepository.save(myUser);
    }
}