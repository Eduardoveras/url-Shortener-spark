/**
 * Created by Siclait on 13/7/16.
 */
package JSONTemplates;

public class Data {

    // Attributes
    private final long id;
    private final String type;
    private final  String content;

    // Constructor
    public Data(long id, String type, String content){

        this.id = id;
        this.type = type;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}
