/**
 * Created by Eduardo veras on 19-Jun-16.
 * Edited by Siclait on 19-Jun-16
 */

import Entity.*;
import Service.*;
import org.h2.tools.Server;

import javax.persistence.PersistenceException;
import java.sql.SQLException;
import java.util.*;

public class DatabaseManager {

    // Singleton Constructor
    private DatabaseManager(){

    }

    public static void BootDataBase(){

        Server server = null;
        try {
            server = Server.createTcpServer("-tcpAllowOthers").start();
        } catch (SQLException e) {
            System.out.println("FAILED TO START SERVER, CLOSE H2 IF YOU HAVE IT OPENED");
            e.printStackTrace();
        }

        List<User> users = FetchAllUsers();

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
            System.out.println("\n\nUser Database already configured!\n");

        List<URL> urls = FetchAllURL();

        if(urls.size() == 0)
        {
            System.out.println("Registering admin urls");

            URLORMService.GetInstance().Create(new URL("http://facebook.com", FetchUser("admin")));
            URLORMService.GetInstance().Create(new URL("http://fb.com", FetchUser("admin")));
            URLORMService.GetInstance().Create(new URL("http://youtube.com", FetchUser("admin")));
            URLORMService.GetInstance().Create(new URL("http://wikipedia.com", FetchUser("admin")));

            System.out.println("Success!");
        }
        else
            System.out.println("\nURL Database already configured!\n");

        urls = FetchAllURLForUser("admin");

        for (URL u:
             urls) {
            System.out.println(u.getShortURL() + " " + u.getUser().getUsername());
        }
    }

    /*
     * Database root Commands : Security/Authentification
     * Admin and Server only
     */
    public static boolean CheckUserCredentials(String username, String password){

        User user = UserORMService.GetInstance().Find(username);

        if(user == null) // User does not exist
            return false;
        else if(user.getPassword().equals(password)) // Password Correct
            return true;
        else // Password Incorrect
            return false;
    }

    public static boolean CheckUserCredentials(String username){

        User user = UserORMService.GetInstance().Find(username);

        if(user == null) // User does not exist
            return false;
        else
            return user.isAdmin();
    }

    private static boolean CheckUserURLEntry(String originalURL, String username){

        List<URL> urls = FetchAllURLForUser(username);

        for (URL url:
             urls) {
            if(url.getOriginalURL().equals(originalURL))
                return true;
        }

        System.out.println("\n\nThis URL has not yet been registered by " + username);
        return false;
    }

    private static boolean CompileInfoLogData(String shortURL, String browser, String OS, String country){

        try{

            InfoLogORMService.GetInstance().Create(new InfoLog(URLORMService.GetInstance().Find(shortURL), browser, OS, country));
            return true;
        } catch (Exception exp){
            System.out.println("\n\nERROR! --> Processing InfoLog error\n\n");
            return false;
        }
    }

    // Exclusive to Admin
    public static void MakeAdmin(String username){

        if(!CheckUserCredentials(username)) {

            System.out.println("\n\nMaking new Admin ...");

            User user = UserORMService.GetInstance().Find(username);

            user.setAdmin(true);

            UserORMService.GetInstance().Edit(user);

            System.out.println("Admin created successfully!\n");
        }
        else
            System.out.println("\n\nUser, " + username + ", is already an Administrator!\n");
    }

    private static List<InfoLog> FetchAllData(){
        return InfoLogORMService.GetInstance().FindAll();
    }

    private static boolean IsDataIncluded(String data, ArrayList<String> dataList){

        if(dataList.size() == 0)
            return false;

        for (String d:
             dataList) {
            if(data.equals(d))
                return true;
        }

        return false;
    }

    private static ArrayList<String> FetchAllCountries(){
        ArrayList<String> countries = new ArrayList<>();

        List<InfoLog> archives = FetchAllData();

        for (InfoLog data:
             archives) {
            if(!IsDataIncluded(data.getCountry(), countries))
                countries.add(data.getCountry());
        }

        return countries;
    }

    // Exclusive to Admin
    public static Map<String, Integer> FetchAllCountryData(){
        ArrayList<String> log = new ArrayList<>();
        Map<String, Integer> countries = new HashMap<>();

        List<InfoLog> archives = FetchAllData();

        for (InfoLog data:
                archives) {
            if(!IsDataIncluded(data.getCountry(), log)){
                log.add(data.getCountry());
                countries.put(data.getCountry(), 1);
            }
            else{
                Integer bubble = countries.remove(data.getCountry());

                countries.put(data.getCountry(), bubble + 1);
            }
        }

        return countries;
    }

    private static ArrayList<String> FetchAllBrowser(){
        ArrayList<String> browsers = new ArrayList<>();

        List<InfoLog> archives = FetchAllData();

        for (InfoLog data:
                archives) {
            if(!IsDataIncluded(data.getBrowser(), browsers))
                browsers.add(data.getBrowser());
        }

        return browsers;
    }

    // Exclusive to Admin
    public static Map<String, Integer> FetchAllBrowserData(){
        ArrayList<String> log = new ArrayList<>();
        Map<String, Integer> browsers = new HashMap<>();

        List<InfoLog> archives = FetchAllData();

        for (InfoLog data:
                archives) {
            if(!IsDataIncluded(data.getBrowser(), log)){
                log.add(data.getBrowser());
                browsers.put(data.getBrowser(), 1);
            }
            else{
                Integer bubble = browsers.remove(data.getBrowser());

                browsers.put(data.getBrowser(), bubble + 1);
            }
        }

        return browsers;
    }

    private static ArrayList<String> FetchAllOS(){
        ArrayList<String> os = new ArrayList<>();

        List<InfoLog> archives = FetchAllData();

        for (InfoLog data:
                archives) {
            if(!IsDataIncluded(data.getOS(), os))
                os.add(data.getOS());
        }

        return os;
    }

    // Exclusive to Admin
    public static Map<String, Integer> FetchAllOSData(){
        ArrayList<String> log = new ArrayList<>();
        Map<String, Integer> OS = new HashMap<>();

        List<InfoLog> archives = FetchAllData();

        for (InfoLog data:
                archives) {
            if(!IsDataIncluded(data.getOS(), log)){
                log.add(data.getOS());
                OS.put(data.getOS(), 1);
            }
            else{
                Integer bubble = OS.remove(data.getOS());

                OS.put(data.getOS(), bubble + 1);
            }
        }

        return OS;
    }

    private static String FetchShortURL(String originalURL, String username){

        List<URL> urls = FetchAllURL();

        for (URL url:
                urls) {
            if(url.getOriginalURL().equals(originalURL) && url.getUser().getUsername().equals(username))
                return url.getShortURL();
        }

        return null;
    }

    // Exclusive too Admin
    public static List<URL> FetchAllURL(){

        return URLORMService.GetInstance().FindAll();
    }

    // Exclusive to Admin
    public static List<User> FetchAllUsers(){

        return UserORMService.GetInstance().FindAll();
    }

    public static User FetchUser(String username){

        return UserORMService.GetInstance().Find(username);
    }

    // User Related Functions
    public static boolean CreateNewUser(String username, String firstName, String lastName, String password){

        try {

            UserORMService.GetInstance().Create(new User(username, firstName, lastName, password, false));
            return true;
        } catch (PersistenceException exp){
            System.out.println("User, " + username + ", already exist\n\n");
            return false;
        }
    }

    // Used for general user
    public static boolean DeleteUserAccount(String username){

        try{

            UserORMService.GetInstance().Delete(UserORMService.GetInstance().Find(username));
            return true;
        } catch (Exception exp){
            System.out.println("This user does not exist\n\n");
            return false;
        }
    }

    // TODO: Add change user password function

    // URL Related Functions
    public static boolean CreateNewShortURL(String original, String username, String browser, String OS, String country){

        try{

            if(CheckUserURLEntry(original, username)){
                System.out.println("\n\nThis URL has already been registered by " + username);
                return false;
            }

            URLORMService.GetInstance().Create(new URL(original, UserORMService.GetInstance().Find(username)));

        } catch (PersistenceException exp){
            System.out.println("\n\nShort URL is already created: Possible Algorithm ERROR!\n");
            return false;
        } finally{

            if(CompileInfoLogData(FetchShortURL(original, username), browser, OS, country))
                System.out.println("\n\nInfoLog Updated Successfully!\n");
            return true;
        }
    }

    public static boolean DeleteShortURL(String shortURL){

        try{

            URLORMService.GetInstance().Delete(URLORMService.GetInstance().Find(shortURL));
            return true;
        } catch (Exception exp){
            System.out.println("\n\nThis short url does not exist\n");
            return false;
        }
    }

    public static String FetchOriginalURL(String shortURL){

        try{

            URL shURL = URLORMService.GetInstance().Find(shortURL);
            return shURL.getOriginalURL();
        } catch (Exception exp){
            System.out.println("\n\nThis short url does not exist\n");
            return null;
        }
    }

    public static ArrayList<URL> FetchAllURLForUser(String username){

        ArrayList<URL> userURL = new ArrayList<>();


        List<URL> urls = URLORMService.GetInstance().FindAll();
        if (!urls.isEmpty())
        {

            for (URL url: urls) {
                System.out.println("antexxx");

                //THIS PART IS FAILING
                String datauser = UserORMService.GetInstance().Find(username).getUsername();
                System.out.println("THE USER ISSSSSSSSSSS:  "+datauser);


                if(url.getUser().getUsername().equals(datauser))
                {
                    System.out.println("adentro");
                    userURL.add(url);
                }
                System.out.println("depue");

            }
        }


        return userURL;
    }

    // Data Related Functions
    // To be used everytime a user uses a shortURL
    public static void TriggerForEveryUse(String shortURL, String browser, String OS, String country){

        if(CompileInfoLogData(shortURL, browser, OS, country))
            System.out.println("\n\nInfoLog Updated Successfully!\n");

    }
}
