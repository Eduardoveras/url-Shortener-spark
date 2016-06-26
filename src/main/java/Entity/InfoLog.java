/**
 * Created by Siclait on 19/6/16.
 */

package Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class InfoLog implements Serializable {

    private static final long serialVersionUID = 1L;

    // Attributes
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column(name ="DATE")
    private Date date;

    @ManyToOne
    private URL url;

    @Column(name = "PREVIEWURL")
    private String previewURL;

    // TODO: Add new columns for browser, country, etc
    @Column(name = "BROWSER", nullable = false)
    private String browser;

    @Column(name = "OS", nullable = false)
    private String OS;

    @Column(name = "COUNTRY", nullable = false)
    private String country;



    // Constructors
    public InfoLog(){

    }

    public InfoLog(URL url){

        this.setUrl(url);

        java.util.Date utilDate = new java.util.Date();
        this.setDate(new Date(utilDate.getTime()));

    }

    public InfoLog(URL url, String browser, String OS, String country, String previewURL){

        this.setUrl(url);

        java.util.Date utilDate = new java.util.Date();
        this.setDate(new Date(utilDate.getTime()));

        this.setBrowser(browser);
        this.setOS(OS);
        this.setCountry(country);
        this.setPreviewURL(previewURL);
    }

    public InfoLog(Integer id, URL url, String browser, String OS, String country, String previewURL){

        this.setId(id);
        this.setUrl(url);

        java.util.Date utilDate = new java.util.Date();
        this.setDate(new Date(utilDate.getTime()));

        this.setBrowser(browser);
        this.setOS(OS);
        this.setCountry(country);
        this.setPreviewURL(previewURL);
    }

    // Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
    }
}
