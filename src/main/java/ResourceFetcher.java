import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

public class ResourceFetcher {

    public static String getDescription(String url) {

        String Descripcion = "http://api.screenshotmachine.com/?key=4c2f50&size=E&format=JPG&cacheLimit=0&timeout=0&cacheLimit=14&url=" + url;

            return Descripcion;
    }

    public static String getQrCodeURL(String url) {

        String TheUrl = "http://api.qrserver.com/v1/create-qr-code/?data=" + url + "&size=150x150&color=0-0-0&bgcolor=FFFF00&format=png";
            return TheUrl;
    }


    public static String json_to_java(String ip){


        String Country_url = "http://api.db-ip.com/v2/7496a2baeeff5630344751043641127d7b0cf062/" + ip;

                try {
                    String genreJson = IOUtils.toString(new URL(Country_url));
                    JSONObject genreJsonObject = (JSONObject) JSONValue.parseWithException(genreJson);

                    // get the data
                    JSONArray countryName;
                    countryName = (JSONArray) genreJsonObject.get("countryName");
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }

                return Country_url;

    }





    public static String flag(String ip) {

        String link_flag= "https://ipfind.co/flags?ip="+ip+"&auth=d9cec36e-01af-4d43-9452-e5cb08eab33e";

        return link_flag;
    }
    public static String getCountryFromIP(String ip)
    {
        return "Dom Rep";
    }


}