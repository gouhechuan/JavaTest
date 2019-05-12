import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class HelloServlet extends GenericServlet {

    public int vcount=0;

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //servletRequest.getContentLength();
        vcount++;
        OutputStream opt= servletResponse.getOutputStream();
        opt.write((vcount+" ").getBytes());

    }
}
