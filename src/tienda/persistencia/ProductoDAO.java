package tienda.persistencia;

import java.util.ArrayList;
import tienda.entidades.Producto;

public final class ProductoDAO extends DAO {
//metodo para guardar un producto en la base de datos    

    public void guardarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar un producto");
            }
            String sql = "INSERT INTO producto (nombre, precio, codigo_fabricante)"
                    + "VALUES ('" + producto.getNombre() + "'," + producto.getPrecio() + "," + producto.getCodigoFabricante() + ");";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
//metodo para editar un producto de la base de datos seleccionandolo por el codigo

    public void editarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe ingresar un producto");
            }
            String sql = "UPDATE producto SET "
                    + "nombre = '" + producto.getNombre() + "', precio = " + producto.getPrecio() + ", codigo_fabricante = "
                    + producto.getCodigoFabricante() + " WHERE codigo = " + producto.getCodigo() + ";";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
//metodo para listar el nombre de todos los productos de la tabla producto
//me devuelve un ArrayList con todos los productos para poder imprimirlos

    public ArrayList<Producto> listaProductos() throws Exception {
        try {
            //creo la sentencia sql que trae solo los nombres y consulto la base con el metodo heredado de DAO. Esto me crea la variable resultado.
            String sql = "SELECT nombre FROM producto;";
            consultarBase(sql);
            //creo un producto null para reutilizar luego y un arraylist que llenare luego
            Producto producto = null;
            ArrayList<Producto> listaProductos = new ArrayList();
            //hago un while que vaya corriendo de uno en uno las filas hasta que ya no queden y voy llenando el obj producto con la info de cada columna.
            //luego agrego ese objeto producto a la lista y van quedando todos guardados alli
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));

                listaProductos.add(producto);
            }
            //desconecto la base de datos. no puedo hacerlo antes porque perderia la info guardada en el resulset...
            //...en el DAO pusimos que el metodo desconectar vacie el resultset tambien en caso de tener data
            desconectarBase();
            //devuelvo la lista
            return listaProductos;
        } catch (Exception e) {
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }

    //metodo para mostrar nombre y precio de todos los productos de la tabla producto
    public ArrayList<Producto> listaProductosNombreYPrecio() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM producto;";
            consultarBase(sql);

            Producto producto = null;
            ArrayList<Producto> listaProductosNombreYPrecio = new ArrayList();

            while (resultado.next()) {
                producto = new Producto();

                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));

                listaProductosNombreYPrecio.add(producto);
            }
            return listaProductosNombreYPrecio;
        } catch (Exception e) {
            desconectarBase();
            throw new Exception("error de sistema");
        }
    }

    public ArrayList<Producto> listaProductosPreciosFiltrados() throws Exception {
        try {
            String sql = "SELECT * FROM producto"
                    + "WHERE precio BETWEEN 120 and 200;";
            consultarBase(sql);

            Producto producto = null;
            ArrayList<Producto> listaProductosPreciosFiltrados = new ArrayList();

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));

                listaProductosPreciosFiltrados.add(producto);
            }
            return listaProductosPreciosFiltrados;
        } catch (Exception e) {
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
}
