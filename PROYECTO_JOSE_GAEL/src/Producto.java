import java.util.Scanner;
public class Producto {
    private String nombre;
    private int cantidad;
    
    Scanner scanner= new Scanner(System.in);
    
    public Producto(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void actualizarCantidad(Inventario inventario){
        System.out.println("----> Actualizar Inventario <----");
       System.out.println("Eliga una opción: ");
       System.out.println("1. Mobiliario dañado/extraviado \n 2. Mobiliario nuevo");
       int actualizar= Usuario.leerEntero();
       switch (actualizar) {
        case 1:
        System.out.println("Ingrese el nombre del producto que desea disminuir por perdida: ");
        String nombreProducto=scanner.nextLine();
        System.out.println("Ingresa la cantidad a disminuir del inventario: ");
        int nuevaCantidad= Usuario.leerEntero();
        while (nuevaCantidad<=0) {
            System.out.println("La cantidad no puede ser negativa o 0, por favor ingrese nuevamente la cantidad");
            nuevaCantidad=Usuario.leerEntero();
        }
        int opcion=1;
        inventario.modificarCantidad(nombreProducto, nuevaCantidad, opcion);
            break;
        case 2:
        System.out.println("Ingrese el nombre del producto que desea aumentar su cantidad: ");
        nombreProducto=scanner.nextLine();
        System.out.println("Ingresa la cantidad para agregar al inventario: ");
        nuevaCantidad= Usuario.leerEntero();
        while (nuevaCantidad<=0) {
            System.out.println("La cantidad no puede ser negativa o 0, por favor ingrese nuevamente la cantidad");
            nuevaCantidad=Usuario.leerEntero();
        }
        opcion=2;
        inventario.modificarCantidad(nombreProducto, nuevaCantidad, opcion);
            break;
        default:
            break;
       }
       
    }

    public void verificarDisponibilidad(Inventario inventario, int cantidad, String nombreProducto){
        for (Producto producto : inventario.getProductos()) {
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                if (producto.getCantidad() >= cantidad) {
                    System.out.println("Hay suficientes " + producto.getNombre() + " en el inventario.");
                    setCantidad(2);
                } else {
                    System.out.println("No hay suficientes " + producto.getNombre() + " en el inventario.");
                    setCantidad(1);
                }
                return;
            }
        }
        System.out.println("Producto '" + nombreProducto + "' no encontrado en el inventario.");
    }
}