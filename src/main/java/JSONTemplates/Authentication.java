/**
 * Created by Siclait on 12/7/16.
 */
package JSONTemplates;

public class Authentication {

    //Attributes
    private final long id;
    private final boolean verified;

    // Constructure
    public Authentication(long id, boolean verified){

        this.id = id;
        this.verified = verified;
    }

    // Getters
    public long getId() {
        return id;
    }

    public boolean isVerified() {
        return verified;
    }
}
