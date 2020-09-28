package ImageHoster.model;

import javax.persistence.*;
import java.time.LocalDate;

@SuppressWarnings("ALL")
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "text", columnDefinition = "TEXT")
    private String text;

    @Column(name = "created_date")
    private LocalDate createdDate;

    //The 'comments' table is mapped to 'users' table with Many:One mapping
    //One comments can have only one user but one user can have multiple comments
    //FetchType is EAGER
    @ManyToOne(fetch = FetchType.EAGER)
    //Apply Foreign Key to User Model
    private User user;

    //The 'comments' table is mapped to 'images' table with Many:One mapping
    //One comments can have only one images but one image can have multiple comments
    //FetchType is EAGER
    @ManyToOne(fetch = FetchType.EAGER)
    //Apply Foreign Key to Image Model
    private Image image;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}