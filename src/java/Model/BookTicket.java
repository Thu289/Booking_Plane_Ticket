/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Vostro 5502
 */
public class BookTicket {
    int account, ticket, amount;
    String date;

    public BookTicket() {
    }

    public BookTicket(int account, int ticket, int amount, String date) {
        this.account = account;
        this.ticket = ticket;
        this.amount = amount;
        this.date = date;
    }

    public int getAccount() {
        return account;
    }

    public int getTicket() {
        return ticket;
    }

    public int getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}
