package com.lcwd.user.service.UserService.controller;

import com.lcwd.user.service.UserService.entities.User;
import com.lcwd.user.service.UserService.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    //crate

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){

        User user1 = userService.saveUser(user);
        return  ResponseEntity.status(HttpStatus.CREATED).body(user1);

    }

    int retryCount=0;


    // single user get
    @GetMapping("/{userId}")
  //  @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
  //  @Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){

        System.out.println("retry is : " + retryCount);
        retryCount+=1;
        User user = userService.getUser(userId);

        //fetch rating of the above user from RATING services
         //http://localhost:8083/ratings/users/ddeaffb0-7f1d-4808-8bd5-1962b44ba706

        return ResponseEntity.ok(user);
    }

    // creating fallback method for circuitbreaker

    public ResponseEntity<User> ratingHotelFallback(String userId,Exception ex){

        System.out.println("Fallback is executed because service is down : "+ ex.getMessage());
        User user = new User();

        user.setName("test name");
        user.setEmail("test email");
        user.setAbout("test about");
        user.setUserId("test1232");

        return new ResponseEntity<>(user,HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){

        List<User> allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }

    // delete the user
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId){

        userService.deleteUser(userId);
      //  return ResponseEntity.status(HttpStatus.OK)
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
    }

    // update the user

//    @PutMapping
//    public ResponseEntity<User> updateUser(@RequestBody User user){
//
//        System.out.println("Incoming user ID: " + user.getUserId());
//        userService.updateUser(user);
//        return  ResponseEntity.status(HttpStatus.OK).body(user  );
//
//    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody User user) {
      //  user.setUserId(userId); // manually set it
        userService.updateUser(userId,user);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

}
