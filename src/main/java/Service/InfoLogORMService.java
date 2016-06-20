/**
 * Created by Siclait on 19/6/16.
 */
package Service;

import Entity.InfoLog;

public class InfoLogORMService extends GenericORMService<InfoLog>{

    private static InfoLogORMService instance;

    private InfoLogORMService(){
        super(InfoLog.class);
    }

    public static InfoLogORMService GetInstance(){

        if(instance == null)
            instance = new InfoLogORMService();

        return instance;
    }
}
