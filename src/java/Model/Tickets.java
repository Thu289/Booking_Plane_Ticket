/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDateTime;

/**
 *
 * @author Vostro 5502
 */
public class Tickets {
    private int supplierId;
    private int id;
    private int type;
    private String bookTime;
    private String departure;
    private String destination;
    private int price;
    private int max_site;
    private int bookedSite;
    private String license_plate;
    private String firmName;
    private int remainSite;
    private boolean status;

    public Tickets() {
    }

    public Tickets(int id, int type, String bookTime, String departure, String destination, int price, int max_site, int bookedSite, String license_plate) {
        this.id = id;
        this.type = type;
        this.bookTime = bookTime;
        this.departure = departure;
        this.destination = destination;
        this.price = price;
        this.max_site = max_site;
        this.bookedSite = bookedSite;
        this.license_plate=license_plate;
    }

    public Tickets(int supplierId, int id, int type, String bookTime, String departure, String destination, int price, String license_plate, String firmName, int remainSite, boolean  status) {
        this.supplierId = supplierId;
        this.id = id;
        this.type = type;
        this.bookTime = bookTime;
        this.departure = departure;
        this.destination = destination;
        this.price = price;
        this.license_plate = license_plate;
        this.firmName = firmName;
        this.remainSite = remainSite;
        this.status=status;
    }

    public Tickets(int type, String bookTime, String departure, String destination, int price, int max_site, boolean status) {
        this.type = type;
        this.bookTime = bookTime;
        this.departure = departure;
        this.destination = destination;
        this.price = price;
        this.max_site = max_site;
        this.status = status;
    }
    
    

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public int getRemainSite() {
        return remainSite;
    }

    public void setRemainSite(int remainSite) {
        this.remainSite = remainSite;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public String getBookTime() {
        return bookTime;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public int getPrice() {
        return price;
    }

    public int getMax_site() {
        return max_site;
    }

    public int getBookedSite() {
        return bookedSite;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setBookTime(String bookTime) {
        this.bookTime = bookTime;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setMax_site(int max_site) {
        this.max_site = max_site;
    }

    public void setBookedSite(int bookedSite) {
        this.bookedSite = bookedSite;
    }
    
    
}
