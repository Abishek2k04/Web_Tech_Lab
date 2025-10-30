import java.io.*; 
import jakarta.servlet.*; 
import jakarta.servlet.http.*; 
public class URLServlet extends HttpServlet { 
protected void service(HttpServletRequest req, HttpServletResponse res) throws 
ServletException, IOException { 
int calledCount = 0; 
res.setContentType("text/html"); 
PrintWriter out = res.getWriter(); 
out.println("<html><body>"); 
out.println("<h3>URLServlet</h3>"); 
out.println("<p>Servlet URL Rewriting Example:</p>"); 
calledCount = getReqURLInt(req, "calledCount"); 
out.println("<p>The value of the url-parm calledCount received in the request: "); 
if (calledCount == 0) { 
out.println("null - value not received</p>"); 
} else { 
out.println(calledCount + "</p>"); 
} 
calledCount++; // Increment count 
out.println("<p>The value of the url-parm calledCount sent back: " + calledCount + 
"</p>"); 
// Encode URL to maintain session and add the calledCount parameter in rewriting URL 
String urlWithParams = res.encodeURL("URLServlet?calledCount=" + calledCount); 
// Provide a hyperlink to reload with updated calledCount parameter 
out.println("<a href=\"" + urlWithParams + "\">Click to reload</a>"); 
out.println("</body></html>"); 
out.close(); 
} 
public int getReqURLInt(HttpServletRequest req, String name) { 
int val = 0; 
String param = req.getParameter(name); 
if (param != null) { 
try { 
val = Integer.parseInt(param); 
} catch (NumberFormatException e) { 
val = 0; 
} 
} 
return val; 
} 
}