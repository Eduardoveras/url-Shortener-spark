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

    @Column(name = "PREVIEWURL")
    private String previewURL;

    @Column(name = "QRURL")
    private String qrURL;

    @Column(name = "LATITUDE")
    private String latitude;

    @Column(name = "LONGITUDE")
    private String longitude;

    @ManyToOne  // @Column not allowed in many to one relationship
    private User user;

    // Constructor
    public URL() {

    }

    public URL(String originalURL, User user, String previewURL, String qrURL, String longitude, String latitude) {

        this.setOriginalURL(originalURL);
        this.setShortURL(UUID.randomUUID().toString().split("-")[0]);
        this.setUser(user);
        this.setPreviewURL(previewURL);
        this.setQrURL(qrURL);
        this.setLongitude(longitude);
        this.setLatitude(latitude);

    }

    public URL(String shortURL, String originalURL, User user, String previewURL, String qrURL, String longitude, String latitude) {

        this.setOriginalURL(originalURL);
        this.setShortURL(shortURL);
        this.setUser(user);
        this.setPreviewURL(previewURL);
        this.setQrURL(qrURL);
        this.setLongitude(longitude);
        this.setLatitude(latitude);

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

    public String getPreviewURL() {
        return previewURL;
    }

    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
    }

    public String getQrURL() {
        return qrURL;
    }

    public void setQrURL(String qrURL) {
        this.qrURL = qrURL;
    }

    public String getLatitude() { return latitude; }

    public void setLatitude(String latitude) { this.latitude = latitude; }

    public String getLongitude() { return longitude; }

    public void setLongitude(String longitude) { this.longitude = longitude; }
}
