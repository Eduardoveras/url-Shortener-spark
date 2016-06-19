/**
 * Created by Eduardo veras on 19-Jun-16.
 * Edited by Siclait on 19-Juu-16
 */

import Entity.*;
import Service.*;

import java.util.List;

public class DatabaseManager {

    // Singleton Constructor
    private DatabaseManager(){

    }

    public static void BootDataBase(){

        List<User> users = UserORMService.GetInstance().FindAll();

        if(users.size() == 0)
        {
            System.out.println("\n\nCreating Admins ...");

            UserORMService.GetInstance().Create(new User("admin", "Administrator", "The", "admin", true));
            UserORMService.GetInstance().Create(new User("Wardo", "Eduardo", "Veras", "1234", true));
            UserORMService.GetInstance().Create(new User("EmmJ", "Emmanuel", "Jaquez", "1234", true));
            UserORMService.GetInstance().Create(new User("Djsiclait", "Djidjelly", "Siclait", "1234", true));

            System.out.println("Admins created successfully!\n");
        }
        else
            System.out.println("\n\nDatabase already created!\n");

    }

    // Database root Commands : Security/Authentification
    // Admin and Server only
    public static boolean CheckUserCredentials(String option){ return false; }

    public static void MakeAdmin(){ }

    public static void DeleteUser(){ }

    public static void FetchAllUsers(){ }

    // User Related Functions
    public static void CreateNewUser(String username, String firstName, String lastName, String password){

        UserORMService.GetInstance().Create(new User(username, firstName, lastName, password, false));
    }

    public static void DeleteUserAccount(String username){

        UserORMService.GetInstance().Delete(UserORMService.GetInstance().Find(username));
    }

    // TODO: Add change user password function

}
