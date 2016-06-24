import Entity.URL;
import com.google.api.client.json.Json;

import java.io.InputStream;

public class ResourceFetcher {

    public static String getDescription(String url) {

        String Descripcion = "http://api.screenshotmachine.com/?key=4c2f50&size=E&format=JPG&cacheLimit=0&timeout=200&url=" + url;

            return "Descripcion";
    }

    public static String getQrCodeURL(String url) {

        String TheUrl = "http://api.qrserver.com/v1/create-qr-code/?data=" + url + "&size=150x150&color=0-0-0&bgcolor=FFFF00&format=png";
            return "TheUrl";
    }

    public static String url_ip(String ip) {

        String Country = "http://api.db-ip.com/v2/7496a2baeeff5630344751043641127d7b0cf062/" + ip;
        return "url_ip";
    }
/*
    public static String getcontry(String url_ip){

        URL url = new  URL(url_ip);
        try (InputStream is = url.openStream();
             JsonReader rdr = Json.createReader(is)) {
            JsonObject obj = rdr.readObject();
            JsonArray results = obj.getJsonArray("data");
            for (JsonObject result : results.getValuesAs(JsonObject.class)) {
                System.out.print(result.getJsonObject("from").getString("name"));
                System.out.print(": ");
                System.out.println(result.getString("message", ""));
                System.out.println("-----------");
            }
        }

*/

}