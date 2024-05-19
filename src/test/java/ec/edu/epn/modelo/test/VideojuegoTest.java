package ec.edu.epn.modelo.test;

import ec.edu.epn.modelo.entidad.Videojuego;
import ec.edu.epn.modelo.persistencia.VideojuegoDAO;
import ec.edu.epn.modelo.services.BaseDeDatos;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

//Cual usamos el org.junit...
//o
//org.junit.jupiter.api

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class VideojuegoTest {


  /*  @BeforeClass
    public static void setUp() {
        String tituloEntrante = "GTA V";
        Double precioVideojuego = 20.00;
        String desarrolladorVideojuego = "Jorman Chuquer";
        VideojuegoDAO videojuegoDAO = Mockito.mock(VideojuegoDAO.class);

    }

   */
/*
    @Test
    public void testBuscarVideojuegoPorTitulo() {
        System.out.println(videojuegoDAO.getVideojuegoByTitulo("GTA V").toString());
        assertNotNull(videojuegoDAO.getVideojuegoByTitulo("GTA V"));
    }

    @Test
    public void testBuscarVideojuegoPorRangoDePrecio() {
        assertNotNull(videojuegoDAO.getVideojuegosByRangoDePrecio(15.00, 25.00));
    }


    @Test
    public void testBuscarVideojuegoPorDesarrollador() {
        System.out.println(videojuegoDAO.getVideojuegoByDesarrollador("Jorman Chuquer"));
        assertNotNull(videojuegoDAO.getVideojuegoByDesarrollador("Jorman Chuquer"));
    }

 */

    @Test
    public void testWithMockBuscarVideojuegoPorTitulo() {
        String tituloEntrante = "GTA V";
        Double precioVideojuego = 20.00;
        String desarrolladorVideojuego = "Jorman Chuquer";
        VideojuegoDAO videojuegoDAO = Mockito.mock(VideojuegoDAO.class);
        // Crear una lista de videojuegos para simular lo que retornaría la base de datos
        List<Videojuego> videojuegos = new ArrayList<>();
        videojuegos.add(new Videojuego(tituloEntrante, desarrolladorVideojuego, precioVideojuego));
        // Definir el comportamiento del mock
        Mockito.when(videojuegoDAO.getVideojuegoByTitulo(tituloEntrante)).thenReturn(videojuegos);
        // Llamada del metodo que vamos a probar
        List<Videojuego> resultado = videojuegoDAO.getVideojuegoByTitulo(tituloEntrante);
        assertNotNull(resultado);
        // Verificar que el método getVideojuegoByTitulo fue llamado con los argumentos correctos
        Mockito.verify(videojuegoDAO).getVideojuegoByTitulo(tituloEntrante);
    }

/*
    @Test
    public void testWithMockBuscarVideojuegoPorDesarrollador() {
        int idVideojuego = 1;
        String tituloVideojuego = "GTA V";
        Double precioVideojuego = 20.00;
        String desarrolladorEntrante = "Jorman Chuquer";

        VideojuegoDAO videojuegoDAO = Mockito.mock(VideojuegoDAO.class);

        // Definir el comportamiento del mock
        Mockito.when(videojuegoDAO.getVideojuegoByDesarrollador(desarrolladorEntrante)).thenReturn((List<Videojuego>) new Videojuego(tituloVideojuego, desarrolladorEntrante,precioVideojuego));

        // Llamada del metodo que vamos a probar
        // Verificar el resultado
        assertNotNull(videojuegoDAO.getVideojuegoByDesarrollador(desarrolladorEntrante));

        // Verificar que el método getVideojuegoByTitulo fue llamado con los argumentos correctos
        Mockito.verify(videojuegoDAO).getVideojuegoByDesarrollador(desarrolladorEntrante);
    }

 */


}
