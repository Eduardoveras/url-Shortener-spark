import java.util.UUID;

/**
 * Created by Eduardo veras on 19-Jun-16.
 */
public class URL {

    public String id;
    public String originalUrl;

    public URL() {
    }

    public URL(String originalUrl) {
        this.originalUrl = originalUrl;
        this.id = UUID.randomUUID().toString().split("-")[0];
    }
}
