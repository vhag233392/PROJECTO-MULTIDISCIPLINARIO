import java.util.ArrayList;
import java.util.List;

public class Inventario {
    public List<Producto> productos;


    public Inventario() {
        this.productos = new ArrayList<>();
        // Agrege productos preestablecidos al inventario de una vez, ya que no agregaremos mas y tampoco eliminaremos estos
        this.productos.add(new Producto("Mesas", 500));
        this.productos.add(new Producto("Sillas", 1000));
        this.productos.add(new Producto("Carpas", 100));
        this.productos.add(new Producto("Manteles", 500));
    }
    //Metodo para modificar la cantidad de un producto (equalsIgnoreCase es para comparar dos cadenas de texto tipo String e ignorar las diferencias de minusculas y mayusculas)
    public void modificarCantidad(String nombreProducto, int nuevaCantidad, int opcion) {
        if (opcion==1) {
            for (Producto producto : productos) {
                if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                    int sumar= producto.getCantidad();
                    if(nuevaCantidad > sumar){
                        System.out.println("Incapaz de actualizar");
                        return;
                    }else{ 
                    producto.setCantidad(sumar-nuevaCantidad);
                    System.out.println("Producto encontrado y cantidad actualizada.");
                    return;
                    }
                }
        }
    }
        if (opcion==2) {
            for (Producto producto : productos) {
                if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                    int sumar= producto.getCantidad();
                    producto.setCantidad(nuevaCantidad+sumar);
                    System.out.println("Producto encontrado y cantidad actualizada.");
                    return;
                }
        }
        
        }
        System.out.println("Producto no encontrado."); // Impresion de depuracion(para saber si se realizo correctamente la actualizacion)
    }
   
    public void actualizarInventario(String nombreProducto, int cantidadSolicitada) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                producto.setCantidad(producto.getCantidad() - cantidadSolicitada);
                break;
            }
        }
    }
       
    public void restarCantidad(String nombreProducto, int cantidad) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                int cantidadExistente = producto.getCantidad();
                producto.setCantidad(cantidadExistente - cantidad);
                return;
            }
        }
        System.out.println("Producto no encontrado en el inventario.");
    }
    // se utilizara para cuando se elimine una renta
    public void sumarCantidad(String nombreProducto, int cantidad) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                int cantidadExistente = producto.getCantidad();
                producto.setCantidad(cantidadExistente + cantidad);
                return;
            }
        }
        System.out.println("Producto no encontrado en el inventario.");
    }   
    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void consultarInventario() {
        System.out.println("--------------------------------------------------");
        System.out.println("|            INVENTARIO DE LA EMPRESA            |");
        System.out.println("--------------------------------------------------");
        System.out.printf("| %-20s | %-8s |\n", "Producto", "Cantidad");
        System.out.println("--------------------------------------------------");
        for (Producto producto : productos) {
            System.out.printf("| %-20s | %-8d |\n", producto.getNombre(), producto.getCantidad());
        }
        System.out.println("--------------------------------------------------");
    }
}