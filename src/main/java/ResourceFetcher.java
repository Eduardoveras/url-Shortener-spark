import JSONTools.GeoLocation;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class ResourceFetcher {

    public static String getDescription(String url) {

        String Descripcion = "http://api.screenshotmachine.com/?key=4c2f50&size=E&format=JPG&cacheLimit=0&timeout=0&cacheLimit=14&url=" + url;

            return Descripcion;
    }

    public static String getQrCodeURL(String url) {

        String TheUrl = "http://api.qrserver.com/v1/create-qr-code/?data=" + url + "&size=150x150&color=0-0-0&bgcolor=FFFFFF&format=png";
            return TheUrl;
    }


    public static String json_to_java(String ip)  {

        String URL = "http://ipinfo.io/"+ ip +"/country";

        Document doc = null;
        try {
            doc = Jsoup.connect(URL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String country_code = doc.data();
        return country_code;
    }


    public static String flag(String ip) {

        String link_flag= "https://ipfind.co/flags?ip="+ip+"&auth=d9cec36e-01af-4d43-9452-e5cb08eab33e";

        return link_flag;
    }
    //public static String getCountryFromIP(String ip) return "Dom Rep";

    public static GeoLocation GetCoordinates(String ip){

        String url = "http://ip-api.com/json/" + ip;
        System.out.println(ip);
        GeoLocation geo = null;

        try {
            System.out.println("\n\nPING!");
            String resource = Jsoup.connect(url).get().data();
            System.out.println("\n\nResource: " + resource);
            JSONObject obj = new JSONObject(resource);

            geo = new GeoLocation(obj.getJSONObject("longitude").toString(), obj.getJSONObject("latitude").toString());

        } catch (IOException exp){
            System.out.println("\n\nIO Resource ERROR --> " + exp.getMessage());
        } catch (Exception exp){
            System.out.println("\n\n General Resource ERROR --> " +  exp.getMessage());
        }

        return geo;
    }

}