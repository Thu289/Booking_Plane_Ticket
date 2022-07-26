/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Vostro 5502
 */
public class Comment {
    int id;
    int authorId;
    String author;
    int article;
    String date;
    int star;
    String description;
    int comId;

    public Comment() {
    }

    public Comment(int id, int authorId, String author, int article, String date, int star, String description, int comId) {
        this.id = id;
        this.authorId = authorId;
        this.author = author;
        this.article = article;
        this.date = date;
        this.star = star;
        this.description = description;
        this.comId = comId;
    }
    
    

    public Comment(int id, int authorId, String author, int article, String date, int star, String description) {
        this.id = id;
        this.authorId=authorId;
        this.author = author;
        this.article = article;
        this.date = date;
        this.star = star;
        this.description = description;
    }

    public Comment(String author, int article, String date, int star, String description) {
        this.author = author;
        this.article = article;
        this.date = date;
        this.star = star;
        this.description = description;
    }

    public Comment(int id, String author, int article, String date, int star, String description) {
        this.id = id;
        this.author = author;
        this.article = article;
        this.date = date;
        this.star = star;
        this.description = description;
    }
    
    

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
    
    

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public int getArticle() {
        return article;
    }

    public String getDate() {
        return date;
    }

    public int getStar() {
        return star;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setArticle(int article) {
        this.article = article;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
