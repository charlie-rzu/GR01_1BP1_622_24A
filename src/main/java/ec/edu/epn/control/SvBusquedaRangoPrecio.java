package ec.edu.epn.control;

import ec.edu.epn.modelo.persistencia.VideojuegoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SvBusquedaRangoPrecio", value = "/SvBusquedaRangoPrecio")
public class SvBusquedaRangoPrecio extends HttpServlet {
    VideojuegoDAO videojuegoDAO = new VideojuegoDAO();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String filtro = request.getParameter("tipoFiltro");
        //videojuegoDAO.getVideojuegoByTitulo(filtro);


        if ("titulo".equals(filtro)) {
            String titulo = request.getParameter("titulo");
            System.out.println(titulo);
            videojuegoDAO.getVideojuegoByTitulo(filtro);
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}
