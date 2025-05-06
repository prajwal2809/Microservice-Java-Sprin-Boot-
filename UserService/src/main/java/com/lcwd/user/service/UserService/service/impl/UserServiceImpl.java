package com.lcwd.user.service.UserService.service.impl;

import com.lcwd.user.service.UserService.entities.Hotel;
import com.lcwd.user.service.UserService.entities.Rating;
import com.lcwd.user.service.UserService.entities.User;
import com.lcwd.user.service.UserService.exception.ResourceNotFoundException;
import com.lcwd.user.service.UserService.external.services.HotelService;
import com.lcwd.user.service.UserService.repositories.UserRepository;
import com.lcwd.user.service.UserService.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

//    @Autowired
//    private Logger logger;
    @Override
    public User saveUser(User user) {

        String  randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);

    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {

        User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id is not found on server !!: "+ userId)) ;

        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+ user.getUserId(), Rating[].class);
        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
      //  System.out.println(ratingsOfUser);
        user.setRatings(ratings);
        List<Rating> ratingList = ratings.stream().map(rating -> {
            System.out.println("this is hotel id we are getting from rating ->" + rating.getHotelId());
          //  Hotel hotel = restTemplate.getForObject("http://HOTELSERVICE/hotels/" + rating.getHotelId(), Hotel.class);

       //     System.out.println("here we r getting hotel info" + hotel);
          //  rating.setHotel(hotel);
            rating.setHotel(hotelService.getHotel(rating.getHotelId()));

            return rating; // Return the enriched rating
        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return  user;
    }

    @Override
    public void deleteUser(String userId) {

        userRepository.deleteById(userId);

    }

    @Override
    public void updateUser(String userId,User user) {


     //   System.out.println("here we are printing user id under update api " + user.getUserId());
        user.setUserId(userId);
        System.out.println("Updating user with ID: " + user.getUserId());
        Optional<User> user1 = userRepository.findById(user.getUserId());
        if(user1.isPresent()){

            User existingUser = user1.get();
            existingUser.setName(user.getName());
            existingUser.setAbout(user.getAbout());
            existingUser.setEmail(user.getEmail());
            existingUser.setAbout(user.getAbout());

            userRepository.save(existingUser);

        }else{
            throw new ResourceNotFoundException("User not found with ID: " + user.getUserId());
        }

    }
}
