/**
 * Created by Siclait on 12/7/16.
 */
package JSONTemplates;

public class Greeting {

    // Attributes
    private final long id;
    private final String content;

    // Constructor
    public Greeting(long id, String content){
        this.id = id;
        this.content = content;
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
