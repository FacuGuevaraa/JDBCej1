package tienda.servicios;

import java.util.Scanner;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;

public class ServicioProducto {

    public ProductoDAO dao;

    public ServicioProducto() {
        this.dao = new ProductoDAO();
    }

//metodo para guardar un nuevo producto en la base de datos
    public void guardarProducto() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        try {
            System.out.println("ingrese el nombre del producto");
            String nombre = leer.next();
            System.out.println("ingrese el precio del producto");
            double precio = leer.nextDouble();
            System.out.println("ingrese el codigo del fabricante");
            int codigoFabricante = leer.nextInt();

            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(codigoFabricante);
            dao.guardarProducto(producto);
        } catch (Exception e) {
            throw new Exception("Error en el servicioProducto - guardarProducto");
        }
    }
//metodo para editar un producto ya creado    

    public void editarProducto() throws Exception {
        try {
            Scanner leer = new Scanner(System.in).useDelimiter("\n");
            System.out.println("ingrese el codigo del producto que desea modificar");
            int codigo = leer.nextInt();
            System.out.println("ingrese el nuevo nombre del producto");
            String nombre = leer.next();
            System.out.println("ingrese el nuevo precio del producto");
            double precio = leer.nextDouble();
            System.out.println("ingrese el nuevo codigo del fabricante");
            int codigoFabricante = leer.nextInt();

            Producto producto = new Producto(codigo, nombre, precio, codigoFabricante);
            dao.editarProducto(producto);
        } catch (Exception e) {
            throw new Exception("error en servicioProducto - editarProducto");
        }

    }
}
