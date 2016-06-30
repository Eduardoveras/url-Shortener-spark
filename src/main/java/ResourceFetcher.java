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

       String country_code = "http://ipinfo.io/"+ ip +"/country";


        return country_code;
    }

    public static String flag(String ip) {

        String link_flag= "https://ipfind.co/flags?ip="+ip+"&auth=d9cec36e-01af-4d43-9452-e5cb08eab33e";

        return link_flag;
    }
    //public static String getCountryFromIP(String ip) return "Dom Rep";


}