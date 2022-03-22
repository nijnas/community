package cn.hdu.community.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "user", indexes = {
        @Index(name = "user_email_UNIQUE", columnList = "user_email", unique = true)
})
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Column(name = "user_email", length = 45)
    private String userEmail;

    @Column(name = "user_password", length = 45)
    private String userPassword;

    @Column(name = "user_name", length = 45)
    private String userName;

    @Column(name = "user_url")
    private String userUrl;

    @Column(name = "user_created")
    @CreatedDate
    private Date userCreated;

    @Column(name = "user_activated")
    private Date userActivated;

    public Date getUserActivated() {
        return userActivated;
    }

    public void setUserActivated(Date userActivated) {
        this.userActivated = userActivated;
    }

    public Date getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(Date userCreated) {
        this.userCreated = userCreated;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}