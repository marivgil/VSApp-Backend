package service.dto;

import java.util.List;

public class ReceptionCenterDTO {

    private String name;
    private String surname;
    private String location;
    private String phone;
    private List<LocationDTO> nearbyLocations;
    private String mail;

    public ReceptionCenterDTO(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<LocationDTO> getNearbyLocations() {
        return nearbyLocations;
    }

    public void setNearbyLocations(List<LocationDTO> nearbyLocations) {
        this.nearbyLocations = nearbyLocations;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
