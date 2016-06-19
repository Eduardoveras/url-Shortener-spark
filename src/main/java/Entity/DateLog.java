/**
 * Created by Siclait on 19/6/16.
 */

package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class DateLog implements Serializable {

    private static final long serialVersionUID = 1L;

    // Attributes
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name ="DATE")
    private Date date;

    @ManyToOne
    private URL url;

    // Constructors
    public DateLog(){

    }

    public DateLog(URL url){

        this.setUrl(url);

        java.util.Date utilDate = new java.util.Date();
        this.setDate(new Date(utilDate.getTime()));

    }

    public DateLog(Integer id, URL url){

        this.setId(id);
        this.setUrl(url);

        java.util.Date utilDate = new java.util.Date();
        this.setDate(new Date(utilDate.getTime()));

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
}
