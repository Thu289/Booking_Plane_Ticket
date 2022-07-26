/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Vostro 5502
 */
public class LicensePlate {
    private int id, firm, maxSite;
    private String name;

    public LicensePlate() {
    }

    public LicensePlate(int id, String name, int firm, int maxSite) {
        this.id = id;
        this.firm = firm;
        this.maxSite = maxSite;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getFirm() {
        return firm;
    }

    public int getMaxSite() {
        return maxSite;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirm(int firm) {
        this.firm = firm;
    }

    public void setMaxSite(int maxSite) {
        this.maxSite = maxSite;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
