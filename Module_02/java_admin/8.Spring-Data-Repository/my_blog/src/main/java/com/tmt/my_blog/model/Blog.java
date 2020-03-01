package com.tmt.my_blog.model;
import javax.persistence.*;


@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idBlog;
    private String Title;

    @ManyToOne(targetEntity = User.class)
    private User user;

    public Blog() {
    }

    public Blog(String title, User users) {
        Title = title;
        this.user =  users;
    }

    public Long getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(Long idBlog) {
        this.idBlog = idBlog;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}