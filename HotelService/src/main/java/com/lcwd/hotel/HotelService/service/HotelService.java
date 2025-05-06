package com.lcwd.hotel.HotelService.service;

import com.lcwd.hotel.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {

    //create
    Hotel create(Hotel hotel);
    List<Hotel> getAll();
    Hotel getHotel(String Id);
}
