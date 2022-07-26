/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Vostro 5502
 */
public class Cart {
    int id;
    Account a;
    Tickets t;
    int quantity;
    String bookTime;
    int ticketId;

    public Cart() {
    }

    public Cart(Account a, Tickets t) {
        this.a = a;
        this.t = t;
    }

    public Cart(int quantity, String bookTime, int ticketId) {
        this.quantity = quantity;
        this.bookTime = bookTime;
        this.ticketId = ticketId;
    }
    
    

    public Cart(Tickets t, int quantity) {
        this.t = t;
        this.quantity = quantity;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }
    
    

    public int getId() {
        return id;
    }

    public Account getA() {
        return a;
    }

    public Tickets getT() {
        return t;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getBookTime() {
        return bookTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setA(Account a) {
        this.a = a;
    }

    public void setT(Tickets t) {
        this.t = t;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setBookTime(String bookTime) {
        this.bookTime = bookTime;
    }

    public Cart(Account a, Tickets t, int quantity) {
        this.a = a;
        this.t = t;
        this.quantity = quantity;
    }

    public Cart(int id, Account a, Tickets t, int quantity) {
        this.id = id;
        this.a = a;
        this.t = t;
        this.quantity = quantity;
    }
    
    
}
