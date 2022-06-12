package tienda.servicios;

import java.util.Scanner;

public class ServicioMenu {

   ServicioProducto sp = new ServicioProducto();
   ServicioFabricante sf = new ServicioFabricante();


    public ServicioMenu() {
    }

    public void opciones() throws Exception {
        try {
            Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("ingrese la opcion que desea realizar");
        System.out.println("1. Lista el nombre de todos los productos que hay en la tabla producto");
        System.out.println("2. Lista los nombres y los precios de todos los productos de la tabla producto");
        System.out.println("3. Listar aquellos productos que su precio esté entre 120 y 202.");
        System.out.println("4. Buscar y listar todos los Portátiles de la tabla producto.");
        System.out.println("5. Listar el nombre y el precio del producto más barato");
        System.out.println("6. Ingresar un producto a la base de datos");
        System.out.println("7. Ingresar un fabricante a la base de datos");
        System.out.println("8. Editar un producto con datos a elección.");
        int num = leer.nextInt();
        switch (num) {
            case 1:
                System.out.println("falata programar");
                break;
            case 2:
                System.out.println("falata programar");
                break;
            case 3:
                System.out.println("falata programar");
                break;
            case 4:
                System.out.println("falata programar");
                break;
            case 5:
                System.out.println("falata programar");
                break;
            case 6:
                sp.guardarProducto();
                break;
            case 7:
                System.out.println("falata programar");
                break;
            case 8:
                sp.editarProducto();
                break;

        }
        } catch (Exception e) {
            throw new Exception("error en el menu");
        }
        
    }
}
