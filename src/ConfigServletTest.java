import javax.servlet.ServletConfig;
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
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;UTF-8");
        PrintWriter out = resp.getWriter();
        //out.println("<meta http-equiv='content-type' content='text/html;charset=UTF-8'>");
        out.println("<html>");
        out.println("Servlet名称为：" + getServletConfig().getServletName() + "<br/>");
        out.println("下面是为servlet设置的初始化参数：" + "<br/>");
        Enumeration e = getServletConfig().getInitParameterNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            String value = getInitParameter(key);
            out.println("&nbsp &nbsp key:" + key + "=" + value + "<br/>");
        }
        String realPath = getServletContext().getRealPath("/");
        out.println("当前WEB应用程序的本地目录为" + realPath + "<br>");
        out.println("</html>");
    }
}
