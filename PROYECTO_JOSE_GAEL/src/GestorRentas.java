
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class GestorRentas {
    private Inventario inventario;
    private Renta renta;
    private Cliente cliente;
    private Producto producto;
    Scanner sc= new Scanner(System.in);
    public Map<Integer,Renta> rentas = new HashMap<>();

    public GestorRentas(Inventario inventario, Renta renta, Cliente cliente, Producto producto) {
        this.inventario = inventario;
        this.renta= renta;
        this.cliente=cliente;
        this.producto=producto;
    }
 
    public Map<Integer,Renta> getRentas(){
        return rentas;
    }

    public void crearRenta(){

        System.out.println("Ingresa la cantidad de sillas a rentar[$31]: ");
        int cantidadSillas = Usuario.leerEntero();
   
        while (cantidadSillas < 0) {
            System.out.println(" La cantidad de sillas no puede ser negativa, por favor ingrese nuevamente la cantidad de sillas[$31]: ");
            cantidadSillas=Usuario.leerEntero();
        }
        //disponibilidad
        producto.verificarDisponibilidad(inventario, cantidadSillas, "Sillas");
        if(producto.getCantidad() ==1) {
            System.out.println("Ingresa una cantidad valida para realizar la renta o dejelo con 0 si se cancela el pedido");
            cantidadSillas= Usuario.leerEntero();
        }
        int sillasPrecioTotal = (cantidadSillas*31);
        System.out.println("Ingresa la cantidad de mesas a rentar[$200]: ");
        int cantidadMesas = Usuario.leerEntero();
        while (cantidadMesas < 0) {
            System.out.println(" La cantidad de mesas no puede ser negativa, por favor ingrese nuevamente la cantidad de mesas[$200]: ");
            cantidadMesas= Usuario.leerEntero();
        }
        producto.verificarDisponibilidad(inventario, cantidadMesas, "Mesas");
        if(producto.getCantidad() ==1) {
            System.out.println("Ingresa una cantidad valida para realizar la renta o dejelo con 0 si se cancela el pedido");
            cantidadMesas= Usuario.leerEntero();
        }
        int mesasPrecioTotal = (cantidadMesas*200);

        System.out.println("Ingresa la cantidad de carpas a rentar[$1200]: ");
        int cantidadCarpas = Usuario.leerEntero();
        while (cantidadCarpas < 0) {
            System.out.println(" La cantidad de carpas no puede ser negativa, por favor ingrese nuevamente la cantidad de carpas[$1200]: ");
            cantidadCarpas= Usuario.leerEntero();
        }
        producto.verificarDisponibilidad(inventario, cantidadCarpas, "Carpas");
        if(producto.getCantidad() ==1) {
            System.out.println("Ingresa una cantidad valida para realizar la renta o dejelo con 0 si se cancela el pedido");
            cantidadCarpas= Usuario.leerEntero();
        }
        int carpasPrecioTotal = (cantidadCarpas*1200);

        System.out.println("Ingresa la cantidad de manteles a rentar[$11]: ");
        int cantidadManteles = Usuario.leerEntero();
        while (cantidadManteles < 0) {
            System.out.println(" La cantidad de manteles no pueder ser negativa, por favor ingrese nuevamente la cantidad de manteles[$11]: ");
            cantidadManteles= Usuario.leerEntero();
        }
        producto.verificarDisponibilidad(inventario, cantidadManteles, "Manteles");
        if(producto.getCantidad() ==1) {
            System.out.println("Ingresa una cantidad valida para realizar la renta o dejelo con 0 si se cancela el pedido");
            cantidadManteles= Usuario.leerEntero();
        }
        int mantelesPrecioTotal = (cantidadManteles*11);
        System.out.println("Ingresa la fecha de entrega de la renta (YYYY-MM-DD): ");
        String fechaEntrega = sc.next();
        double costoTotalCliente = (sillasPrecioTotal+mesasPrecioTotal+mantelesPrecioTotal+carpasPrecioTotal);
        Renta nuevaRenta = new Renta(cantidadSillas, cantidadMesas, cantidadCarpas, cantidadManteles, fechaEntrega, costoTotalCliente);

        inventario.restarCantidad("Carpas", nuevaRenta.getCantidadCarpas());
        inventario.restarCantidad("Sillas", nuevaRenta.getCantidadSillas());
        inventario.restarCantidad("Mesas", nuevaRenta.getCantidadMesas());
        inventario.restarCantidad("Manteles", nuevaRenta.getCantidadManteles()); 
        int id= cliente.getIdCliente();
        rentas.put(id,nuevaRenta);
        renta.setIdRenta(id);
     
        System.out.println("La renta fue aguardada con el id: " + renta.getIdRenta());
        System.out.println("Costo Total "+costoTotalCliente + "$");
        System.out.println("-----------------");
    }

    public void modificarRenta(){

        System.out.println("----> Modificar Renta <----");
        System.out.print("Ingrese ID de la renta para modificar: ");
        int idRentaMod = Usuario.leerEntero();
        while (idRentaMod <= 0) {
            System.out.println("El ID no puede ser negativo, por favor ingreselo nuevamnete: ");
            idRentaMod= Usuario.leerEntero();
        }

        if(rentas.containsKey(idRentaMod)){
            Renta rentaMod = rentas.get(idRentaMod);
            System.out.println("Aplicarlo a: \n 1.- Sillas \n 2.- Mesas \n 3.-Manteles \n 4.-Carpas ");
            int elementoACambiar = Usuario.leerEntero();
            System.out.println("1.- Agregar mobiliario 2.- Disminuir mobiliario");
            int optModRenta = Usuario.leerEntero();
            switch (elementoACambiar) {
                case 1:
                switch (optModRenta) {
                    case 1:
                    System.out.println("¿Cuantos Mobiliarios Desea Agregar?");
                    int cantidadACambiar = Usuario.leerEntero();
                    while (cantidadACambiar<= 0) {
                    System.out.println("La cantidad no puede ser negativa, por favor vuelva a ingresarla: ");
                    cantidadACambiar= Usuario.leerEntero();
                    }
                    producto.verificarDisponibilidad(inventario, cantidadACambiar, "Sillas");
                        if(producto.getCantidad() ==1) {
                            System.out.println("Ingresa una cantidad valida para realizar la renta o dejelo con 0 si se finaliza la modificación");
                            cantidadACambiar= Usuario.leerEntero();
                        }
                        if(cantidadACambiar > inventario.productos.get(0).getCantidad() || cantidadACambiar < 0){
                            System.out.println("Incapaz de Modificar");
                            System.out.println("-----------------");
                            break;
                        }
                        else{
                            rentaMod.setCantidadSillas(cantidadACambiar + rentaMod.getCantidadSillas());
                            inventario.restarCantidad("Sillas", cantidadACambiar);
                            rentaMod.setCostoTotalCliente((cantidadACambiar*31)+rentaMod.getCostoTotalCliente());
                            System.out.println("Modificación realizada con exíto.");
                            //al momento de modificar renta tambien cambia la cantidad a pagar              
                            break;
                        }              
                    case 2:
                    System.out.println("¿Cuantos Mobiliarios Desea Disminuir?");
                    cantidadACambiar = Usuario.leerEntero();
                    while (cantidadACambiar<= 0) {
                        System.out.println("La cantidad no puede ser negativa, por favor vuelva a ingresarla: ");
                        cantidadACambiar= Usuario.leerEntero();
                    }
                    if(cantidadACambiar > inventario.productos.get(0).getCantidad() || cantidadACambiar < 0 || cantidadACambiar > rentaMod.getCantidadSillas()){
                        
                        System.out.println("Incapaz de Modificar");
                        System.out.println("-----------------");
                        break;
                    }
                    else{
                        rentaMod.setCantidadSillas(rentaMod.getCantidadSillas() - cantidadACambiar);
                        inventario.sumarCantidad("Sillas", cantidadACambiar);
                        rentaMod.setCostoTotalCliente(rentaMod.getCostoTotalCliente()-(cantidadACambiar*31));
                        System.out.println("Modificación realizada con exíto.");
                        //al momento de modificar renta tambien cambia la cantidad a pagar              
                        break;
                    }
                    default:
                        break;
                }             
                    break;
                case 2:
                switch (optModRenta) {
                    case 1:
                    System.out.println("¿Cuantos Mobiliarios Desea Agregar?");
                    int cantidadACambiar = Usuario.leerEntero();
                    while (cantidadACambiar<= 0) {
                    System.out.println("La cantidad no puede ser negativa, por favor vuelva a ingresarla: ");
                    cantidadACambiar= Usuario.leerEntero();
                    }
                    producto.verificarDisponibilidad(inventario, cantidadACambiar, "Mesas");
                        if(producto.getCantidad() ==1) {
                            System.out.println("Ingresa una cantidad valida para realizar la renta o dejelo con 0 si se finaliza la modificación");
                            cantidadACambiar= Usuario.leerEntero();
                        }
                        if(cantidadACambiar > inventario.productos.get(1).getCantidad() || cantidadACambiar < 0){
                            System.out.println("Incapaz de Modificar");
                            System.out.println("-----------------");
                            break;
                            
                        }
                        else{
                            rentaMod.setCantidadMesas(cantidadACambiar + rentaMod.getCantidadMesas());
                            inventario.restarCantidad("Mesas", cantidadACambiar);
                            rentaMod.setCostoTotalCliente((cantidadACambiar*200)+rentaMod.getCostoTotalCliente());
                            System.out.println("Modificación realizada con exíto.");
                            //al momento de modificar renta tambien cambia la cantidad a pagar              
                            break;
                        }   
                    case 2:
                    System.out.println("¿Cuantos Mobiliarios Desea Disminuir?");
                    cantidadACambiar = Usuario.leerEntero();
                    while (cantidadACambiar<= 0) {
                        System.out.println("La cantidad no puede ser negativa, por favor vuelva a ingresarla: ");
                        cantidadACambiar= Usuario.leerEntero();
                    }
                    if(cantidadACambiar > inventario.productos.get(1).getCantidad() || cantidadACambiar < 0 || cantidadACambiar > rentaMod.getCantidadMesas()){
                        
                            System.out.println("Incapaz de Modificar");
                            System.out.println("-----------------");
                            break;     
                    }
                    else{
                        rentaMod.setCantidadMesas(rentaMod.getCantidadMesas() - cantidadACambiar);
                        inventario.sumarCantidad("Mesas", cantidadACambiar);
                        rentaMod.setCostoTotalCliente(rentaMod.getCostoTotalCliente()-(cantidadACambiar*200));
                        System.out.println("Modificación realizada con exíto.");
                        //al momento de modificar renta tambien cambia la cantidad a pagar              
                        break;
                    }
                        
                
                    default:
                        break;
                }      
                    break;
                case 3:
                switch (optModRenta) {
                    case 1:
                    System.out.println("¿Cuantos Mobiliarios Desea Agregar?");
                    int cantidadACambiar = Usuario.leerEntero();
                    while (cantidadACambiar<= 0) {
                    System.out.println("La cantidad no puede ser negativa, por favor vuelva a ingresarla: ");
                    cantidadACambiar= Usuario.leerEntero();
                    }
                    producto.verificarDisponibilidad(inventario, cantidadACambiar, "Manteles");
                        if(producto.getCantidad() ==1) {
                            System.out.println("Ingresa una cantidad valida para realizar la renta o dejelo con 0 si se finaliza la modificación");
                            cantidadACambiar= Usuario.leerEntero();
                        }
                        if(cantidadACambiar > inventario.productos.get(2).getCantidad() || cantidadACambiar < 0){
                            System.out.println("Incapaz de Modificar");
                            System.out.println("-----------------");
                            break;
                            
                        }
                        else{
                            rentaMod.setCantidadManteles(cantidadACambiar + rentaMod.getCantidadManteles());
                            inventario.restarCantidad("Manteles", cantidadACambiar);
                            rentaMod.setCostoTotalCliente((cantidadACambiar*11)+rentaMod.getCostoTotalCliente());
                            System.out.println("Modificación realizada con exíto.");
                            //al momento de modificar renta tambien cambia la cantidad a pagar              
                            break;
                        }

                        
                        
                    case 2:
                    System.out.println("¿Cuantos Mobiliarios Desea Disminuir?");
                    cantidadACambiar = Usuario.leerEntero();
                    while (cantidadACambiar<= 0) {
                        System.out.println("La cantidad no puede ser negativa, por favor vuelva a ingresarla: ");
                        cantidadACambiar= Usuario.leerEntero();
                    }
                    if(cantidadACambiar > inventario.productos.get(2).getCantidad() || cantidadACambiar < 0 || cantidadACambiar > rentaMod.getCantidadManteles()){
                        if (cantidadACambiar > rentaMod.getCantidadManteles()) {
                            System.out.println("Incapaz de Modificar");
                            System.out.println("-----------------");
                            break;
                            }
                    }
                    else{
                        rentaMod.setCantidadManteles(rentaMod.getCantidadManteles() - cantidadACambiar);
                        inventario.sumarCantidad("Manteles", cantidadACambiar);
                        rentaMod.setCostoTotalCliente(rentaMod.getCostoTotalCliente()-(cantidadACambiar*11));
                        System.out.println("Modificación realizada con exíto.");
                        //al momento de modificar renta tambien cambia la cantidad a pagar              
                        break;
                    }
                    default:
                        break;
                }  
                    break;
                case 4:
                switch (optModRenta) {
                    case 1:
                    System.out.println("¿Cuantos Mobiliarios Desea Agregar?");
                    int cantidadACambiar = Usuario.leerEntero();
                    while (cantidadACambiar<= 0) {
                    System.out.println("La cantidad no puede ser negativa, por favor vuelva a ingresarla: ");
                    cantidadACambiar= Usuario.leerEntero();
                    }
                    producto.verificarDisponibilidad(inventario, cantidadACambiar, "Carpas");
                        if(producto.getCantidad() ==1) {
                            System.out.println("Ingresa una cantidad valida para realizar la renta o dejelo con 0 si se finaliza la modificación");
                            cantidadACambiar= Usuario.leerEntero();
                        }
                        if(cantidadACambiar > inventario.productos.get(3).getCantidad() || cantidadACambiar < 0){
                            System.out.println("Incapaz de Modificar");
                            System.out.println("-----------------");
                            break;
                            
                        }
                        else{
                            rentaMod.setCantidadCarpas(cantidadACambiar + rentaMod.getCantidadCarpas());
                            inventario.restarCantidad("Carpas", cantidadACambiar);
                            rentaMod.setCostoTotalCliente((cantidadACambiar*1200)+rentaMod.getCostoTotalCliente());
                            System.out.println("Modificación realizada con exíto.");
                            //al momento de modificar renta tambien cambia la cantidad a pagar              
                            break;
                        }  
                    case 2:
                    System.out.println("¿Cuantos Mobiliarios Desea Disminuir?");
                    cantidadACambiar = Usuario.leerEntero();
                    while (cantidadACambiar<= 0) {
                        System.out.println("La cantidad no puede ser negativa, por favor vuelva a ingresarla: ");
                        cantidadACambiar= Usuario.leerEntero();
                    }
                    if(cantidadACambiar > inventario.productos.get(3).getCantidad() || cantidadACambiar < 0 || cantidadACambiar > rentaMod.getCantidadCarpas()){
                        if (cantidadACambiar > rentaMod.getCantidadCarpas()) {
                            System.out.println("Incapaz de Modificar");
                            System.out.println("-----------------");
                            break;
                            }
                    }
                    else{
                        rentaMod.setCantidadCarpas(rentaMod.getCantidadCarpas() - cantidadACambiar);
                        inventario.sumarCantidad("Carpas", cantidadACambiar);
                        rentaMod.setCostoTotalCliente(rentaMod.getCostoTotalCliente()-(cantidadACambiar*1200));
                        System.out.println("Modificación realizada con exíto.");
                        //al momento de modificar renta tambien cambia la cantidad a pagar              
                        break;
                    }
                    default:
                        break;
                } 
                    break;
                default:
                    break;
            }
        }
        else{
            System.out.println("[NO HUBO RESULTADOS]");
        }

    }
    
    public void finalizarRenta(int idRentaEliminar) {
        boolean encontrado = false;
        if (rentas.containsKey(idRentaEliminar)) {
            Renta rentaEliminada = rentas.get(idRentaEliminar);
                // Actualizar el inventario sumando la cantidad de productos de la renta eliminada
                inventario.sumarCantidad("Carpas", rentaEliminada.getCantidadCarpas());
                inventario.sumarCantidad("Sillas", rentaEliminada.getCantidadSillas());
                inventario.sumarCantidad("Mesas", rentaEliminada.getCantidadMesas());
                inventario.sumarCantidad("Manteles", rentaEliminada.getCantidadManteles());
                encontrado = true;
                System.out.println("Renta cancelada con éxito .");
                String fechaEntrega= " Entregado ";
                System.out.println("-----------------");
                int cantidadSillas=0;
                int cantidadMesas=0;
                int cantidadCarpas=0;
                int cantidadManteles=0;
                int costoTotalCliente=0;
                Renta nuevaRenta = new Renta(cantidadSillas, cantidadMesas, cantidadCarpas, cantidadManteles, fechaEntrega, costoTotalCliente);
                rentas.put(idRentaEliminar, nuevaRenta);
            }
            if (!encontrado) {
                System.out.println("No se encontró la renta con el ID " + idRentaEliminar);
            }
        }
        
    public void seguimientoRentas(){
        // Aqui primero verificamos si el mapa 'rentas' está vacío
        if (rentas.isEmpty()) {
        System.out.println("Aun no hay rentas establecidas");
         } else {
    // Si no está vacío, entonces iteramos sobre los alquileres
        for (Integer idRenta : rentas.keySet()) {
           Renta renta = rentas.get(idRenta);
           System.out.println("Id de la Renta " + (idRenta) + ":");
           System.out.println("  Sillas: " + renta.getCantidadSillas());
           System.out.println("  Mesas: " + renta.getCantidadMesas());
           System.out.println("  Carpas: " + renta.getCantidadCarpas());
           System.out.println("  Manteles: " + renta.getCantidadManteles());
           System.out.println("  Fecha de entrega (Estado del pedido): " + renta.getFechaDeEntrega());
           System.out.println("  Costo Total De La Renta: " + renta.getCostoTotalCliente() + "$");
           System.out.println("-----------------");
        }
      }
    }
}