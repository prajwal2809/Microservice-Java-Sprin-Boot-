package com.lcwd.hotel.HotelService.service.impl;

import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import com.lcwd.hotel.HotelService.entities.Hotel;
import com.lcwd.hotel.HotelService.exception.ResourceNotFoundException;
import com.lcwd.hotel.HotelService.repositories.HotelRepository;
import com.lcwd.hotel.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel create(Hotel hotel) {

        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        List<Hotel> hotelList = hotelRepository.findAll();
        return  hotelList;
    }

    @Override
    public Hotel getHotel(String Id) {
        Hotel hotel = hotelRepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException("hotel with given id not found !!"));
        return hotel;
    }
}
