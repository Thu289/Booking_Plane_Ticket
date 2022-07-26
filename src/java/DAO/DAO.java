/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Account;
import Model.Articles;
import Model.BookTicket;
import Model.Cart;
import Model.Comment;
import Model.Firm;
import Model.LicensePlate;
import Model.Tickets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Vostro 5502
 */
public class DAO {
    
    private Connection con;
    private String status="ok";

    public DAO() {
        try {
            con = new DBContext().getConnection();
        } catch (Exception e) {
            status="Error when connecting to sql"+e.getMessage();
    }
    }
    
    public void addAccount(Account a){
        String sql="insert into Account_HE150889 values (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, a.getUsername());
            ps.setString(2, a.getPassword());
            ps.setString(3, a.getPhone());
            ps.setString(4, a.getEmail());
            ps.setString(5, a.getAddress());
            ps.setString(6, a.getRole());
            ps.setBoolean(7, a.isStatus());
            ps.setString(8, a.getNote());
            ps.setBoolean(9, a.isGender());
            ps.setDate(10, java.sql.Date.valueOf(a.getDob()));
            ps.execute();
        } catch (Exception e) {
            status="Error insert account"+e.getMessage();
        }
    }
    
    public void deleteAcc(int id){
        String sql="delete from Account_HE150889 where id=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            status="Error when deleting account"+e.getMessage();
        }
    }
    
    public ArrayList<Account> getAccount(){
        ArrayList<Account> listAccount=new ArrayList<Account>();
        String sql="select * from account_he150889";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                listAccount.add(new Account(
                        rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4), 
                        rs.getString(5), 
                        rs.getString(6), 
                        rs.getString(7), 
                        rs.getBoolean(8), 
                        rs.getString(9),
                        rs.getBoolean(10),
                        rs.getDate(11).toString()));
            }
        } catch (Exception e) {
            status="Error when load list account"+e.getMessage();
        }
        return listAccount;
    }
    
    public ArrayList<Account> getSupplier(){
        ArrayList<Account> listSupplier=new ArrayList<Account>();
        String sql="select a.*, f.name\n" +
"from Account_HE150889 a inner join Firm_HE150889 f on a.id=f.id\n" +
"where role='supplier' and status=1";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                listSupplier.add(new Account(
                        rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4), 
                        rs.getString(5), 
                        rs.getString(6), 
                        rs.getString(7), 
                        rs.getBoolean(8), 
                        rs.getString(9),
                        rs.getBoolean(10),
                        rs.getDate(11).toString(),
                        rs.getString(12)));
            }
        } catch (Exception e) {
            status="Error when load list account"+e.getMessage();
        }
        return listSupplier;
    }
    
    public ArrayList<Account> getSupplierCensor(){
        ArrayList<Account> listSupplier=new ArrayList<Account>();
        String sql="select a.*, f.name\n" +
"from Account_HE150889 a left outer join Firm_HE150889 f on a.id=f.id\n" +
"where role='supplier' and status=0";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                listSupplier.add(new Account(
                        rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4), 
                        rs.getString(5), 
                        rs.getString(6), 
                        rs.getString(7), 
                        rs.getBoolean(8), 
                        rs.getString(9),
                        rs.getBoolean(10),
                        rs.getDate(11).toString(),
                        rs.getString(12)));
            }
        } catch (Exception e) {
            status="Error when load list account"+e.getMessage();
        }
        return listSupplier;
    }
    
    public void updateStatus(int id, int status){
        String sql="update Account_HE150889 set status=? where id=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, status);
            ps.setInt(2, id);
            ps.execute();
        } catch (Exception e) {
        }
    }
    
    public ArrayList<Articles> getArticles(){
        ArrayList<Articles> listArticle=new ArrayList<>();
        String sql="select a.*, ac.username from Articles_HE150889 a inner join Account_HE150889 ac on a.author=ac.id";
         try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                listArticle.add(new Articles(
                        rs.getInt(1), 
                        rs.getInt(2), 
                        rs.getString(3), 
                        rs.getString(4), 
                        rs.getFloat(5), 
                        rs.getString(6), 
                        rs.getString(7), 
                        rs.getInt(8), 
                        rs.getBoolean(9),
                        rs.getString(10),
                        rs.getString(11)));
            }
        } catch (Exception e) {
            status="Error when load list articles"+e.getMessage();
        }
        return listArticle;
    }
    
    public ArrayList<Comment> getListComment(int articleId){
        ArrayList<Comment> listComment=new ArrayList<>();
        String sql="select c.id, a.id, a.username, c.articles, c.date, c.star, c.description, c.idcom\n" +
"from Comment_HE150889 c inner join Account_HE150889 a on c.author=a.id\n" +
"where c.articles=?";
         try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, articleId);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                listComment.add(new Comment(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDate(5).toString(),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
            status="Error when load list comment"+e.getMessage();
        }
        return listComment;
    }
    
    public void addComment(int authorId, int article, int star, String description, int comId){
        if (description.equals("") || description==null) return;
        String sql="insert into Comment_HE150889 values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, article);
            ps.setInt(2, authorId);
            ps.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
            ps.setInt(4, star);
            ps.setString(5, description);
            ps.setInt(6, comId);
            ps.execute();
        } catch (Exception e) {
            status="Error insert comment"+e.getMessage();
        }
    }
    
    public void deleteComment(int id){
        String sql="delete from Comment_HE150889 where id=?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            status="Error delete comment"+e.getMessage();
        }
    }
    
    public  void updateComment(int id, String descript, int star){
        String sql="update Comment_HE150889 set star=?, description=? where id="+id;
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, star);
            ps.setString(2, descript);
            ps.execute();
        } catch (Exception e) {
            status="Error update comment"+e.getMessage();
        }
    }
    
    public ArrayList<Tickets> getListTicket(){
        ArrayList<Tickets> listTicket=new ArrayList<>();
        String sql="select a.id, t.id, t.type, t.departure, t.destination, t.date, t.price, \n" +
"l.licensePlate, f.name, l.max_site-t.bookedSite as remainSeat, t.status\n" +
"from Ticket_HE150889 t \n" +
"inner join LicensePlate_HE150889 l on t.licensePlate=l.id\n" +
"inner join Firm_HE150889 f on f.id=l.firm\n" +
"inner join Account_HE150889 a on a.id=f.id";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                listTicket.add(new Tickets(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(6),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getBoolean(11))
                );
            }
        } catch (Exception e) {
            status="Error when getting list ticket"+e.getMessage();
        }
        
        return listTicket;
    }
    
    public void updateAccount(Account a){
        String sql="update Account_HE150889 \n" +
"set username=?, phone=?, email=?, address=?, gender=? where id=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, a.getUsername());
            ps.setString(2, a.getPhone());
            ps.setString(3, a.getEmail());
            ps.setString(4, a.getAddress());
            ps.setInt(5, a.isGender()?1:0);
            ps.setInt(6, a.getId());
            ps.execute();
        } catch (Exception e) {
            status="Error when updating account"+e.getMessage();
        }
    }
    
    public void updateArtView(int id, int view){
        String sql="update Articles_HE150889 set views=? where id=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, view);
            ps.setInt(2, id);
            ps.execute();
        } catch (Exception e) {
            status="Error when update view"+e.getMessage();
        }
    }
    
    public void deleteArticle(int id){
        String sql="delete from Articles_HE150889 where id=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            status="Error when deleting article"+e.getMessage();
        }
    }
    
    public void updateStatusArt(int id, int statusArt){
        String sql="update Articles_HE150889 set status=? where id=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, statusArt);
            ps.setInt(2, id);
            ps.execute();
        } catch (Exception e) {
            status="Error when updating status of article"+e.getMessage();
        }
    }
    
    public void addArticle(Articles a){
        String sql="insert into Articles_HE150889(author, date, keyword, title, description, image, status)\n" +
"values (?,?,?,?,?,?,1)";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, a.getAuthor());
            ps.setDate(2, java.sql.Date.valueOf(a.getDateWritten()));
            ps.setString(3, a.getKeyword());
            ps.setString(4, a.getTitle());
            ps.setString(5, a.getDiscription());
            ps.setString(6, a.getImg());
            ps.execute();
        } catch (Exception e) {
            status="error when adding article"+e.getMessage();
        }
    }
    
    public void addFirm(Firm f){
        String sql="insert into Firm_HE150889 values (?,?, ?)";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, f.getId());
            ps.setString(3, f.getName());
            ps.setString(2, f.getType());
            ps.execute();
        } catch (Exception e) {
            status="Error when adding firm"+e.getMessage();
        }
    }
    
    public ArrayList<Firm> getListFirm(){
        ArrayList<Firm> listFirm=new ArrayList<>();
        String sql="select * from Firm_HE150889";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                listFirm.add(new Firm(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)));
            }
        } catch (Exception e) {
            status="Error when getting list firm"+e.getMessage();
        }
        return listFirm;
    }
    
    public void addLicensePlate(int firm, String name, int site){
        String sql="insert into LicensePlate_HE150889 values (?, ?, ?)";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, firm);
            ps.setInt(3, site);
            ps.execute();
        } catch (Exception e) {
            status="Error when adding license plate"+e.getMessage();
        }
    }
    
    public void addTicket(Tickets t){
        String sql="insert into Ticket_HE150889 values "
                + "(?, CAST (? as datetime),?,?,?,?,?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, t.getType());
            ps.setString(2, t.getBookTime());
            ps.setString(3, t.getDeparture());
            ps.setString(4, t.getDestination());
            ps.setInt(5, t.getPrice());
            ps.setInt(6, 0);
            ps.setInt(7, 1);
            ps.setInt(8, 1);
            ps.execute();
        } catch (Exception e) {
            status="Error when adding ticket"+e.getMessage();
        }
    }
    
    public ArrayList<LicensePlate> getListLicense(){
        ArrayList<LicensePlate> listLP=new ArrayList<>();
        String sql="select * from LicensePlate_HE150889";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                listLP.add(new LicensePlate(rs.getInt(1),
                        rs.getString(2), 
                        rs.getInt(3), 
                        rs.getInt(4)));
            }
        } catch (Exception e) {
            status="Error when getting list license plate"+e.getMessage();
        }
        return listLP;
    }
    
    public void updatePassword(int id, String pass){
        String sql="update Account_HE150889 set password=? where id=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setInt(2, id);
            ps.execute();
        } catch (Exception e) {
            status="Error when updating password"+e.getMessage();
        }
    }
    
    public void updateTicket(int id, int quantity){
        String sql="update Ticket_HE150889 set bookedSite=?+(select bookedSite from Ticket_HE150889 where id=?) where id=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, quantity);
            ps.setInt(2, id);
            ps.setInt(3, id);
            ps.execute();
        } catch (Exception e) {
            status="error when updating ticket"+e.getMessage();
        }
    }
    
    public void addOrder(Cart c){
        String sql="insert into BookTicket_HE150889 values (?,?,?, CAST(? as datetime))";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, c.getA().getId());
            ps.setInt(2, c.getT().getId());
            ps.setInt(3, c.getQuantity());
            ps.setString(4, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")).toString());
            ps.execute();
        } catch (Exception e) {
            status="Error when insert order"+e.getMessage();
        }
    }
    
    public ArrayList<BookTicket> getListBookTicket(int accId){
        ArrayList<BookTicket> listB=new ArrayList<>();
        String sql="select * from BookTicket_HE150889 where customer=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
             ps.setInt(1, accId);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                listB.add(new BookTicket(rs.getInt(1), 
                        rs.getInt(2), 
                        rs.getInt(3), 
                        rs.getString(4)));
            }
        } catch (Exception e) {
        }
        
        return listB;
    }
}
