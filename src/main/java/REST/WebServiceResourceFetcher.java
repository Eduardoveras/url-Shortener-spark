/**
 * Created by Siclait on 12/7/16.
 */
package REST;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class WebServiceResourceFetcher {

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


}