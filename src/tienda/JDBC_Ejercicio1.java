package tienda;

import tienda.servicios.ServicioMenu;
import tienda.servicios.ServicioProducto;

public class JDBC_Ejercicio1 {

    public static void main(String[] args) throws Exception {
        ServicioMenu sm = new ServicioMenu();
        ServicioProducto sp = new ServicioProducto();
        
        try {
        sm.opciones();
            
        } catch (Exception e) {
            throw new Exception("Error en el main");
        }

    }
}
