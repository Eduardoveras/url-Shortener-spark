import com.google.api.client.extensions.appengine.http.UrlFetchTransport;
import com.google.api.client.googleapis.extensions.appengine.auth.oauth2.AppIdentityCredential;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.urlshortener.Urlshortener;
import com.google.api.services.urlshortener.UrlshortenerScopes;
import com.google.api.services.urlshortener.model.Url;
import com.google.api.services.urlshortener.model.UrlHistory;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ResourceFetcher {

    public static String getDescription(String url)
    {
        //CHECK: http://screenshotmachine.com/apiguide.php


        return "Descripcion";
    }

    public static String getQrCodeURL(String url)
    {
        return "TheUrl";
    }


    public class UrlShortenerSample extends HttpServlet {

    private static final long serialVersionUID = 1L;

    static Urlshortener newUrlshortener() {
        AppIdentityCredential credential =
                new AppIdentityCredential(Arrays.asList(UrlshortenerScopes.URLSHORTENER));
        return new Urlshortener.Builder(new UrlFetchTransport(), new JacksonFactory(), credential)
                .build();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Urlshortener shortener = newUrlshortener();
        UrlHistory history = shortener.url().list().execute();
        resp.setContentType("text/html");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(resp.getOutputStream()));
        writer.append("<html><body><form action=\".\" method=\"post\">Long Url: "
                + "<input name=\"longUrl\" type=\"text\" /><input type=\"submit\" /></form><table><tr>"
                + "<th>Original</th><th>Shortened</th></tr>");
        if (history.getItems() != null) {
            for (Url oneShortened : history.getItems()) {
                writer.append("<tr><td>");
                writer.append(oneShortened.getLongUrl()).append("</td><td><a href=\"").append(
                        oneShortened.getId());
                writer.append("\">").append(oneShortened.getId());
                writer.append("</a></td></tr>");
            }
        }
        writer.append("</table></body></html>");
        writer.flush();
        resp.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String longUrl = req.getParameter("longUrl");
        Urlshortener shortener = newUrlshortener();
        Url toInsert = new Url().setLongUrl(longUrl);
        try {
            shortener.url().insert(toInsert).execute();
        } catch (GoogleJsonResponseException e) {
            resp.sendError(404, e.getMessage());
        }
        resp.sendRedirect("/");
    }
}