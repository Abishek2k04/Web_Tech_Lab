import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Downloaddata extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String targetUrl = "http://www.gmail.com";
        URL url = new URL(targetUrl);
        URLConnection connection = url.openConnection();

        // Get metadata
        long dateMillis = connection.getDate();
        long expirationMillis = connection.getExpiration();
        long lastModifiedMillis = connection.getLastModified();
        long contentLength = connection.getContentLengthLong();
        String contentType = connection.getContentType();

        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            // Print metadata
            out.println("<html><head><title>Homepage with Metadata</title></head><body>");
            out.println("<h2>Metadata of homepage: " + targetUrl + "</h2>");

            out.println("<b>Date:</b> " + 
                (dateMillis != 0 ? sdf.format(new Date(dateMillis)) : "Not available") + "<br>");
            out.println("<b>Content Type:</b> " + contentType + "<br>");
            out.println("<b>Expiration Date:</b> " + 
                (expirationMillis != 0 ? sdf.format(new Date(expirationMillis)) : "Not available") + "<br>");
            out.println("<b>Last Modified:</b> " + 
                (lastModifiedMillis != 0 ? sdf.format(new Date(lastModifiedMillis)) : "Not available") + "<br>");
            out.println("<b>Content Length:</b> " + contentLength + " bytes<br><hr>");

            // Print homepage content
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    out.println(line);
                }
            }

            out.println("</body></html>");
        }
    }
}
