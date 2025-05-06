package com.lcwd.user.service.UserService.entities;

import jakarta.persistence.Id;

public class Hotel {

    @Id
    private String Id;
    private String name;
    private String location;
    private String about;


    public void setAbout(String about) {
        this.about = about;
    }

    public String getAbout() {
        return about;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
