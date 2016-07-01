/**
 * Created by Eduardo veras on 19-Jun-16.
 * Edited by Siclait on 19-Jun-16
 */

import Entity.*;
import Service.*;
import org.h2.tools.Server;

import javax.persistence.PersistenceException;
import java.sql.*;
import java.sql.Date;
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
            UserORMService.GetInstance().Create(new User("guest", "guest", "guest", "", false));

            System.out.println("Admins created successfully!\n");
        }
        else
            System.out.println("\n\nUser Database already configured!\n");

        List<URL> urls = FetchAllURL();

        if(urls.size() == 0)
        {
            System.out.println("Registering admin urls");

            URLORMService.GetInstance().Create(new URL("http://facebook.com", FetchUser("admin"), ResourceFetcher.getDescription("http://facebook.com"), ResourceFetcher.getQrCodeURL("http://facebook.com")));
            URLORMService.GetInstance().Create(new URL("http://fb.com", FetchUser("admin"), ResourceFetcher.getDescription("http://fb.com"), ResourceFetcher.getQrCodeURL("http://fb.com")));
            URLORMService.GetInstance().Create(new URL("http://youtube.com", FetchUser("admin"), ResourceFetcher.getDescription("http://youtube.com"), ResourceFetcher.getQrCodeURL("http://youtube.com")));
            URLORMService.GetInstance().Create(new URL("http://wikipedia.com", FetchUser("admin"), ResourceFetcher.getDescription("http://wikipedia.com"), ResourceFetcher.getQrCodeURL("http://wikipedia.com")));

            System.out.println("Success!");
        }
        else
            System.out.println("\nURL Database already configured!\n");

        DeleteShortURL("a2fafd21");

        // Browsers
        Map<String, Float> browsers = FetchURLDataByBrowser("a613c7b3");

        ArrayList<String> log = FetchAllBrowser();

        for (String b:
             log) {
            System.out.println(b + ": " + browsers.get(b).toString() + "%");
        }

        System.out.println("\n\n");
        // OS
        browsers = FetchURLDataByOS("a613c7b3");

        log = FetchAllOS();

        for (String b:
                log) {
            System.out.println(b + ": " + browsers.get(b).toString() + "%");
        }

        System.out.println("\n\n");
        // Countries
        browsers = FetchURLDataByCountry("a613c7b3");

        log = FetchAllCountries();

        for (String b:
                log) {
            System.out.println(b + ": " + browsers.get(b).toString() + "%");
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
            System.out.println(shortURL);
            System.out.println(browser);
            System.out.println(OS);
            System.out.println(country);
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
        {
            System.out.println("\n\nRemoving admin ...");

            User user = UserORMService.GetInstance().Find(username);

            user.setAdmin(false);

            UserORMService.GetInstance().Edit(user);

            System.out.println("Admin powers removed successfully!\n");
        }
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

    public static ArrayList<String> FetchAllCountries(){
        ArrayList<String> countries = new ArrayList<>();

        List<InfoLog> archives = FetchAllData();

        for (InfoLog data:
             archives) {
            if(!IsDataIncluded(data.getCountry(), countries))
                countries.add(data.getCountry());
        }

        return countries;
    }

    public static ArrayList<String> FetchAllBrowser(){
        ArrayList<String> browsers = new ArrayList<>();

        List<InfoLog> archives = FetchAllData();

        for (InfoLog data:
                archives) {
            if(!IsDataIncluded(data.getBrowser(), browsers))
                browsers.add(data.getBrowser());
        }

        return browsers;
    }

    public static ArrayList<String> FetchAllOS(){
        ArrayList<String> os = new ArrayList<>();

        List<InfoLog> archives = FetchAllData();

        for (InfoLog data:
                archives) {
            if(!IsDataIncluded(data.getOS(), os))
                os.add(data.getOS());
        }

        return os;
    }

    private static String FetchShortURL(String originalURL, String username){

        return URLORMService.ShowShortURLForUser(originalURL, username);
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
    public static boolean CreateNewShortURL(String original, String username, String browser, String OS, String ip){

        try{

            if(CheckUserURLEntry(original, username)){
                System.out.println("\n\nThis URL has already been registered by " + username);
                return false;
            }

            URLORMService.GetInstance().Create(new URL(original, UserORMService.GetInstance().Find(username), ResourceFetcher.getDescription(original), ResourceFetcher.getQrCodeURL(original)));

        } catch (PersistenceException exp){
            System.out.println("\n\nShort URL is already created: Possible Algorithm ERROR!\n");
            return false;
        } finally{

            if(CompileInfoLogData(FetchShortURL(original, username), browser, OS, "Dominican Republic"/* ResourceFetcher.json_to_java(ip) */))
                System.out.println("\n\nInfoLog Updated Successfully!\n");
            return true;
        }
    }

    public static boolean DeleteShortURL(String shortURL){

        try{

            List<InfoLog> log = InfoLogORMService.FindShortURLInstance(shortURL);

            for (InfoLog i:
                 log) {
                InfoLogORMService.GetInstance().Delete(i);
            }

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

    public static List<URL> FetchAllURLForUser(String username){

        ArrayList<URL> userURL = new ArrayList<>();

        return URLORMService.FindUserURL(username);
    }

    public static Integer HowManyClicks(String shortURL){

        return InfoLogORMService.FindShortURLInstance(shortURL).size();
    }

    // Data Related Functions
    // To be used everytime a user uses a shortURL
    public static void TriggerForEveryUse(String shortURL, String browser, String OS, String ip){

        if(CompileInfoLogData(shortURL, browser, OS, "Dominican Republic"))
            System.out.println("\n\nInfoLog Updated Successfully!\n");

    }

    public static Map<Date, Integer> FetchURLDataByDate(String url){

        ArrayList<String> log = new ArrayList<>();
        List<InfoLog> data = InfoLogORMService.FindShortURLInstance(url);

        Map<Date, Integer> pair = new HashMap<>();

        for (InfoLog info:
                data) {
            if(!IsDataIncluded(info.getDate().toString(), log)){
                log.add(info.getDate().toString());
                pair.put(info.getDate(), 1);
            }
            else {
                Integer bubble = pair.remove(info.getDate());

                pair.put(info.getDate(), bubble + 1);
            }
        }

        return pair;
    }

    public static Set<Date> ShowDateMapLegend(Map<Date, Integer> map){

        ArrayList<Date> legend = new ArrayList<>();

        return map.keySet();
    }

    public static Map<String, Float> FetchURLDataByBrowser(String url){

        ArrayList<String> log = FetchAllBrowser();
        Map<String, Float> browsers = new HashMap<>();

        Float count = 0f;

        for (String browser:
             log) {
            Float bubble = 1f * InfoLogORMService.HowManyTimesUsedByBrowser(url, browser);
            count += bubble;
            browsers.put(browser, bubble);
        }

        for (String browser:
                log) {
            Float bubble = browsers.remove(browser);
            browsers.put(browser, (bubble / count) * 100);
        }

        return browsers;
    }

    public static Map<String, Float> FetchURLDataByOS(String url){

        ArrayList<String> log = FetchAllOS();
        Map<String, Float> OS = new HashMap<>();

        Float count = 0f;

        for (String os:
                log) {
            Float bubble = 1f * InfoLogORMService.HowManyTimesUsedByOS(url, os);
            count += bubble;
            OS.put(os, bubble);
        }

        for (String os:
                log) {
            Float bubble = OS.remove(os);
            OS.put(os, (bubble / count) * 100);
        }

        return OS;
    }

    public static Map<String, Float> FetchURLDataByCountry(String url){

        ArrayList<String> log = FetchAllCountries();
        Map<String, Float> countries = new HashMap<>();

        Float count = 0f;

        for (String country:
                log) {
            Float bubble = 1f * InfoLogORMService.HowManyTimesUsedByCountry(url, country);
            count += bubble;
            countries.put(country, bubble);
        }

        for (String country:
                log) {
            Float bubble = countries.remove(country);
            countries.put(country, (bubble / count) * 100);
        }

        return countries;
    }
}
