/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Vostro 5502
 */
import java.time.LocalDateTime;
public class Articles {
    //bai viet
    private int id;
    private int author;
    private String dateWritten;
    private String keyword;
    private float star;
    private String title;
    private String discription;
    private int views;
    private boolean status;
    private String img;
    private String authorName;

    public Articles() {
    }

    public Articles(int id, int author, String dateWritten, String place,
            float star, String title, String discription, int views, 
            boolean status, String img, String authorName) {
        this.id = id;
        this.author = author;
        this.dateWritten = dateWritten;
        this.keyword = place;
        this.star = star;
        this.title = title;
        this.discription = discription;
        this.views = views;
        this.status = status;
        this.img=img;
        this.authorName=authorName;
    }

    public Articles(int author, String dateWritten, String keyword, String title, String discription, String img) {
        this.author = author;
        this.dateWritten = dateWritten;
        this.keyword = keyword;
        this.title = title;
        this.discription = discription;
        this.img = img;
    }
    
    

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    
    

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    public int getId() {
        return id;
    }

    public int getAuthor() {
        return author;
    }

    public String getDateWritten() {
        return dateWritten;
    }

    public String getKeyword() {
        return keyword;
    }

    public float getStar() {
        return star;
    }

    public String getTitle() {
        return title;
    }

    public String getDiscription() {
        return discription;
    }

    public int getViews() {
        return views;
    }

    public boolean isStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public void setDateWritten(String dateWritten) {
        this.dateWritten = dateWritten;
    }

    public void setKeyword(String place) {
        this.keyword = place;
    }

    public void setStar(float star) {
        this.star = star;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
