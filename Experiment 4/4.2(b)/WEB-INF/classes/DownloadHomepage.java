import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.net.URL; 
import jakarta.servlet.ServletException; 
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
public class DownloadHomepage extends HttpServlet { 
protected void doGet(HttpServletRequest request, HttpServletResponse response)  
throws ServletException, IOException { 
String targetUrl = "http://www.gmail.com"; 
        URL url = new URL(targetUrl); 
        BufferedReader reader = new BufferedReader(new 
InputStreamReader(url.openStream())); 
 
        response.setContentType("text/html"); 
 
        String line; 
        while ((line = reader.readLine()) != null) { 
            response.getWriter().println(line); 
        } 
        reader.close(); 
    } 
} 