/**
 * Created by Siclait on 19/7/16.
 */
package JSONTools;

public class GeoLocation {

    // attributes
    private String longitude;
    private String latitude;

    // Constructor
    public GeoLocation(String longitude, String latitude){
        this.setLongitude(longitude);
        this.setLatitude(latitude);
    }

    // Getters & Setter
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
