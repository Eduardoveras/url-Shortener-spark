/**
 * Created by Guest on 19/6/16.
 */

package Service;

import Entity.User;

public class UserORMService extends GenericORMService<User>{

    private static UserORMService instance;

    private UserORMService(){
        super(User.class);
    }

    public static UserORMService GetInstance(){
        if(instance == null)
            instance = new UserORMService();

        return instance;
    }
}
