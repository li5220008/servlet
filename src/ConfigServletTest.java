import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by free on 14-2-22.
 */
public class ConfigServletTest extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("Servlet名称为：" + getServletConfig().getServletName() + "<br/>");
        Enumeration e = getServletConfig().getInitParameterNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            String value = getInitParameter(key);
            out.println("&nbsp&sbsp key:"+key+"="+value+"<br/>");
        }
        out.println("</html>");
    }
}
