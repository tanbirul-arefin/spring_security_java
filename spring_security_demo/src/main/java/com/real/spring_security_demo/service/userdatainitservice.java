//package com.real.spring_security_demo.service;
//
//import com.real.spring_security_demo.model.user;
//import com.real.spring_security_demo.repository.userrepository;
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import org.apache.catalina.User;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RequiredArgsConstructor
//@Configuration
//
//public class userdatainitservice {
//    private final userrepository userrepository;
//
//    @PostConstruct
//    public void init(){
//        List<user> users = new ArrayList<>();
//        users.add(new User(1, "abc", "123"));
//
//    }
//}

package com.real.spring_security_demo.service;

import com.real.spring_security_demo.model.user;
import com.real.spring_security_demo.repository.userrepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Configuration
public class userdatainitservice {

    private final userrepository userrepository;

    @PostConstruct
    public void init() {
        List<user> Users = new ArrayList<>();

        // পাসওয়ার্ডের আগে {noop} যুক্ত করা হয়েছে
        Users.add(new user(1, "abc", "123"));
        Users.add(new user(2, "def", "456"));
        Users.add(new user(3, "ghf", "789"));

        userrepository.saveAll(Users);

        System.out.println("Data successfully saved to database!");
    }
}