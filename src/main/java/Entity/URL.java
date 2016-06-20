/**
 * Created by Eduardo veras on 19-Jun-16.
 * Edited by Siclait on 19-Jun-16
 */
package Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class URL implements Serializable {

    private static final long serialVersionUID = 1L;

    // Attributes
    @Id
    @Column(name = "SHORT")
    private String shortURL;

    @Column(name = "ORIGINAL")
    private String originalURL;

    @ManyToOne  // @Column not allowed in many to one relationship
    private User user;

    // Constructor
    public URL() {

    }

    public URL(String originalURL, User user) {

        this.setOriginalURL(originalURL);
        this.setShortURL(UUID.randomUUID().toString().split("-")[0]);
        this.setUser(user);

    }

    public URL(String shortURL, String originalURL, User user) {

        this.setOriginalURL(originalURL);
        this.setShortURL(shortURL);
        this.setUser(user);

    }

    // Getters & Setters
    public String getShortURL() {
        return shortURL;
    }

    public void setShortURL(String shortURL) {
        this.shortURL = shortURL;
    }

    public String getOriginalURL() {
        return originalURL;
    }

    public void setOriginalURL(String originalURL) {
        this.originalURL = originalURL;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
