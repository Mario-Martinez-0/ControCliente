
package web;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{
    
    //Con este codigo vamos a traer todos los clientes que tenemos en clase ClienteDaoJDBC
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cliente> clientes = new ClienteDaoJDBC().listar();//esto trae todos los clientes que esten el la base de datos
        System.out.println("clientes = " + clientes);//esto muestra todos los valores que tenemos en la base de datos
        request.setAttribute("clieentes", clientes);
        request.getRequestDispatcher("clientes.jsp").forward(request, response);
    }
    
}
