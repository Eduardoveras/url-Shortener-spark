/**
 * Created by Siclait on 19/6/16.
 */
package Service;

import Entity.DateLog;

public class DateLogORMService extends GenericORMService<DateLog>{

    private DateLogORMService instance;

    private DateLogORMService(){
        super(DateLog.class);
    }

    public DateLogORMService GetInstance(){

        if(instance == null)
            instance = new DateLogORMService();

        return instance;
    }
}
