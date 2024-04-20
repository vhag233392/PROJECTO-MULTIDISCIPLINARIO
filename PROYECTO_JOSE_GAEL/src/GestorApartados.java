//import java.util.ArrayList;
//import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
public class GestorApartados {
   
    Scanner sc= new Scanner(System.in);
    public Map<Integer,Apartado> apartados = new HashMap<>();
    private Inventario inventario;
    private Apartado apartado;
    private Cliente cliente;
    private Producto producto;

    public GestorApartados(Inventario inventario, Apartado apartado, Cliente cliente, Producto producto){
        this.inventario=inventario;
        this.apartado=apartado;
        this.cliente=cliente;
        this.producto= producto;
    }

    public Map<Integer,Apartado> getApartados(){
        return apartados;
    }
    
    public void setApartados(Map<Integer,Apartado> apartados){
        this.apartados=apartados;
    }
    public void crearApartado(){
        System.out.println("Ingresa la fecha en la que se hara entrega (con 7 dias de anticipacion ) ");
        String fechaEntrega = sc.next();
        
        System.out.println("Ingresa la cantidad de Sillas [$31]: ");
        int cantidadSillas= Usuario.leerEntero();
        while (cantidadSillas < 0) {
            System.out.println(" La cantidad de sillas no puede ser negativa, por favor ingrese nuevamente la cantidad de sillas[$31]: ");
            cantidadSillas=Usuario.leerEntero();
        }
        producto.verificarDisponibilidad(inventario, cantidadSillas, "Sillas");
        if(producto.getCantidad() ==1) {
            System.out.println("Ingresa una cantidad valida para realizar el apartado o dejelo con 0 si se cancela el pedido");
            cantidadSillas= Usuario.leerEntero();
        }
        int sillasPrecioTotal = (cantidadSillas*31);
        System.out.println("Ingresa la cantidad de mesas [$200]: ");
        int cantidadMesas= Usuario.leerEntero();
        while (cantidadMesas < 0) {
            System.out.println(" La cantidad de mesas no puede ser negativa, por favor ingrese nuevamente la cantidad de mesas[$200]: ");
            cantidadMesas= Usuario.leerEntero();
        }
        producto.verificarDisponibilidad(inventario, cantidadMesas, "Mesas");
        if(producto.getCantidad() ==1) {
            System.out.println("Ingresa una cantidad valida para realizar el apartado o dejelo con 0 si se cancela el pedido");
            cantidadMesas= Usuario.leerEntero();
        }
        int mesasPrecioTotal = (cantidadMesas*200);
        System.out.println("Ingresa la cantidad de carpas [$1200]: ");
        int cantidadCarpas= Usuario.leerEntero();
        while (cantidadCarpas < 0) {
            System.out.println(" La cantidad de carpas no puede ser negativa, por favor ingrese nuevamente la cantidad de carpas[$1200]: ");
            cantidadCarpas= Usuario.leerEntero();
        }
        producto.verificarDisponibilidad(inventario, cantidadCarpas, "Carpas");
        if(producto.getCantidad() ==1) {
            System.out.println("Ingresa una cantidad valida para realizar el apartado o dejelo con 0 si se cancela el pedido");
            cantidadCarpas= Usuario.leerEntero();
        }
        int carpasPrecioTotal = (cantidadCarpas*1200);
        System.out.println("Ingresa la cantidad de manteles [$11]: ");
        int cantidadManteles= Usuario.leerEntero();
        while (cantidadManteles < 0) {
            System.out.println(" La cantidad de manteles no pueder ser negativa, por favor ingrese nuevamente la cantidad de manteles[$11]: ");
            cantidadManteles= Usuario.leerEntero();
            
        }
        producto.verificarDisponibilidad(inventario, cantidadManteles, "Manteles");
        if(producto.getCantidad() ==1) {
            System.out.println("Ingresa una cantidad valida para realizar el apartado o dejelo con 0 si se cancela el pedido");
            cantidadManteles= Usuario.leerEntero();
        }
        int mantelesPrecioTotal = (cantidadManteles*11);

        double costoTotalCliente = (sillasPrecioTotal+mesasPrecioTotal+mantelesPrecioTotal+carpasPrecioTotal);
        Apartado apartadoNuevo = new Apartado(fechaEntrega, cantidadSillas, cantidadMesas, cantidadCarpas, cantidadManteles, costoTotalCliente);
        
        inventario.restarCantidad("Carpas", apartadoNuevo.getCantidadCarpas());
        inventario.restarCantidad("Sillas", apartadoNuevo.getCantidadSillas());
        inventario.restarCantidad("Mesas", apartadoNuevo.getCantidadMesas());
        inventario.restarCantidad("Manteles", apartadoNuevo.getCantidadManteles());
        //apartados.add(apartadoNuevo);
        int id= cliente.getIdCliente();
        apartados.put(id,apartadoNuevo);
        apartado.setIdApartado(id);
        System.out.println("El apartado fue aguardado con el id: " + apartado.getIdApartado() );
        System.out.println("Costo Total: "+costoTotalCliente);
        System.out.println("-----------------");
    }

    public void finalizarApartado(int indice){
        boolean encontrado = false;
        
        if(apartados.containsKey(indice)){

        Apartado rentaEliminada = apartados.get(indice);
        // Actualizar el inventario sumando la cantidad de productos de la renta eliminada
        inventario.sumarCantidad("Carpas", rentaEliminada.getCantidadCarpas());
        inventario.sumarCantidad("Sillas", rentaEliminada.getCantidadSillas());
        inventario.sumarCantidad("Mesas", rentaEliminada.getCantidadMesas());
        inventario.sumarCantidad("Manteles", rentaEliminada.getCantidadManteles());
        encontrado = true;
        System.out.println("Se cancelo el apartado con exito. ");
        String fechaDeEntrega= " Entregado ";
        System.out.println("-----------------");
        int cantidadSillas=0;
        int cantidadMesas=0;
        int cantidadCarpas=0;
        int cantidadManteles=0;
        double costoTotalCliente = 0;
        Apartado apartadoNuevo = new Apartado(fechaDeEntrega, cantidadSillas, cantidadMesas, cantidadCarpas, cantidadManteles, costoTotalCliente);
        apartados.put(indice, apartadoNuevo );
         }
         if (!encontrado) {
            System.out.println("No se encontro ningun apartado con el ID " + indice);
        }
    }

    public void modificarApartado(){

        System.out.println("----> Modificar Apartado <----");
        System.out.print("Ingrese ID del apartado para modificar: ");
        int idApartadoMod = Usuario.leerEntero();
        while (idApartadoMod <= 0) {
            System.out.println("El ID no puede ser negativo, por favor ingreselo nuevamnete: ");
            idApartadoMod= Usuario.leerEntero();
        }
        if(apartados.containsKey(idApartadoMod)){
        Apartado apartadoMod = apartados.get(idApartadoMod);

        System.out.println("Aplicarlo a: \n 1.- Sillas \n 2.- Mesas \n 3.-Manteles \n 4.-Carpas ");
        int elementoACambiar = Usuario.leerEntero();
        System.out.println("1.- Agregar 2.- Disminuir");
        int optModApartado = Usuario.leerEntero();  

        switch (elementoACambiar) {
            case 1:
                switch (optModApartado) {
                    case 1:
                    System.out.println("Cuantas Desea Agregar?");
                    int cantidadACambiar = Usuario.leerEntero();
                    while (cantidadACambiar<= 0) {
                        System.out.println("La cantidad no puede ser negativa, por favor vuelva a ingresarla: ");
                        cantidadACambiar= Usuario.leerEntero();
                    }
                    producto.verificarDisponibilidad(inventario, cantidadACambiar, "Sillas");
                        if(producto.getCantidad() ==1) {
                            System.out.println("Ingresa una cantidad valida para realizar el apartado o dejelo con 0 si se cancela el pedido");
                            cantidadACambiar= Usuario.leerEntero();
                        }
                        if(cantidadACambiar > inventario.productos.get(0).getCantidad() || cantidadACambiar < 0){
                            System.out.println("Incapaz de Modificar");
                            System.out.println("-----------------");
                            break;
                        }
                        else{
                            apartadoMod.setCantidadSillas(cantidadACambiar + apartadoMod.getCantidadSillas());
                            inventario.restarCantidad("Sillas", cantidadACambiar);
                            apartadoMod.setCostoTotalCliente((cantidadACambiar*31)+apartadoMod.getCostoTotalCliente());  
                            System.out.println("Modificación realizada con exíto.");          
                            break;
                        }
                        
                    case 2:
                    System.out.println("¿Cuantas Desea Disminuir?");
                    cantidadACambiar = Usuario.leerEntero();
                    while (cantidadACambiar<= 0) {
                    System.out.println("La cantidad no puede ser negativa, por favor vuelva a ingresarla: ");
                    cantidadACambiar= Usuario.leerEntero();
                }

                if(cantidadACambiar > inventario.productos.get(0).getCantidad() || cantidadACambiar < 0 || cantidadACambiar > apartadoMod.getCantidadSillas()){
                    System.out.println("Incapaz de Modificar");
                    System.out.println("-----------------");

                    break;
                }
                else{
                    apartadoMod.setCantidadSillas(apartadoMod.getCantidadSillas() - cantidadACambiar);
                    inventario.sumarCantidad("Sillas", cantidadACambiar);
                    apartadoMod.setCostoTotalCliente(apartadoMod.getCostoTotalCliente()-(cantidadACambiar*31));
                    System.out.println("Modificación realizada con exíto.");         
                    break;
                }
                    default:
                        break;
                }
                
                break;
            case 2:
            switch (optModApartado) {
                
                case 1:
                System.out.println("Cuantas Desea Agregar?");
                int cantidadACambiar = Usuario.leerEntero();
                while (cantidadACambiar<= 0) {
                    System.out.println("La cantidad no puede ser negativa, por favor vuelva a ingresarla: ");
                    cantidadACambiar= Usuario.leerEntero();
                }
                if(cantidadACambiar > inventario.productos.get(1).getCantidad() || cantidadACambiar < 0){
                    System.out.println("Incapaz de Modificar");
                    System.out.println("-----------------");

                    break;
                    
                }
                else{
                    apartadoMod.setCantidadMesas(apartadoMod.getCantidadMesas() - cantidadACambiar);
                    inventario.sumarCantidad("Mesas", cantidadACambiar);
                    apartadoMod.setCostoTotalCliente(apartadoMod.getCostoTotalCliente()-(cantidadACambiar*200));
                    System.out.println("Modificación realizada con exíto.");         
                    break;
                }     
                case 2:
                System.out.println("¿Cuantas Desea Disminuir?");
                cantidadACambiar = Usuario.leerEntero();
                while (cantidadACambiar<= 0) {
                    System.out.println("La cantidad no puede ser negativa, por favor vuelva a ingresarla: ");
                    cantidadACambiar= Usuario.leerEntero();
                }
                if(cantidadACambiar > inventario.productos.get(1).getCantidad() || cantidadACambiar < 0 || cantidadACambiar > apartadoMod.getCantidadMesas()){
                    System.out.println("Incapaz de Modificar");
                    System.out.println("-----------------");
                    break; 
                }
                else{
                    apartadoMod.setCantidadMesas(apartadoMod.getCantidadMesas() - cantidadACambiar);
                    inventario.sumarCantidad("Mesas", cantidadACambiar);
                    apartadoMod.setCostoTotalCliente(apartadoMod.getCostoTotalCliente()-(cantidadACambiar*200));
                    System.out.println("Modificación realizada con exíto.");         
                    break;
                }
                default:
                    break;
            }
                break;
            case 3:
            switch (optModApartado) {
                case 1:
                System.out.println("Cuantas Desea Agregar?");
                int cantidadACambiar = Usuario.leerEntero();
                while (cantidadACambiar<= 0) {
                    System.out.println("La cantidad no puede ser negativa, por favor vuelva a ingresarla: ");
                    cantidadACambiar= Usuario.leerEntero();
                }
                    break;
                case 2:
                System.out.println("¿Cuantas Desea Disminuir?");
                cantidadACambiar = Usuario.leerEntero();
                while (cantidadACambiar<= 0) {
                    System.out.println("La cantidad no puede ser negativa, por favor vuelva a ingresarla: ");
                    cantidadACambiar= Usuario.leerEntero();
                }

                if(cantidadACambiar > inventario.productos.get(2).getCantidad() || cantidadACambiar < 0 || cantidadACambiar > apartadoMod.getCantidadManteles()){
                    System.out.println("Incapaz de Modificar");
                    System.out.println("-----------------");

                    break;   
                }
                else{
                    apartadoMod.setCantidadManteles(apartadoMod.getCantidadManteles() - cantidadACambiar);
                    inventario.sumarCantidad("Manteles", cantidadACambiar);
                    apartadoMod.setCostoTotalCliente(apartadoMod.getCostoTotalCliente()-(cantidadACambiar*11));
                    System.out.println("Modificación realizada con exíto.");             
                    break;
                }
                default:
                    break;
            }
                break;
            case 4:
            switch (optModApartado) {
                case 1:
                System.out.println("Cuantas Desea Agregar?");
                int cantidadACambiar = Usuario.leerEntero();
                while (cantidadACambiar<= 0) {
                    System.out.println("La cantidad no puede ser negativa, por favor vuelva a ingresarla: ");
                    cantidadACambiar= Usuario.leerEntero();
                }
                producto.verificarDisponibilidad(inventario, cantidadACambiar, "Carpas");
                        if(producto.getCantidad() ==1) {
                        System.out.println("Ingresa una cantidad valida para realizar el apartado o dejelo con 0 si se cancela el pedido");
                        cantidadACambiar= Usuario.leerEntero();
                         }
                        if(cantidadACambiar > inventario.productos.get(3).getCantidad() || cantidadACambiar < 0){
                            System.out.println("Incapaz de Modificar");
                            System.out.println("-----------------");
                            break;
                        }
                        else{
                            apartadoMod.setCantidadCarpas(cantidadACambiar + apartadoMod.getCantidadCarpas());
                            inventario.restarCantidad("Carpas", cantidadACambiar);
                            apartadoMod.setCostoTotalCliente((cantidadACambiar*1200)+apartadoMod.getCostoTotalCliente());
                            System.out.println("Modificación realizada con exíto.");         
                            break;
                        }
                case 2:
                System.out.println("¿Cuantas Desea Disminuir?");
                cantidadACambiar = Usuario.leerEntero();
                while (cantidadACambiar<= 0) {
                    System.out.println("La cantidad no puede ser negativa, por favor vuelva a ingresarla: ");
                    cantidadACambiar= Usuario.leerEntero();
                }
                if(cantidadACambiar > inventario.productos.get(3).getCantidad() || cantidadACambiar < 0 || cantidadACambiar > apartadoMod.getCantidadCarpas()){
                    System.out.println("Incapaz de Modificar");
                    System.out.println("-----------------");
                    break;
                }
                else{
                    apartadoMod.setCantidadCarpas(apartadoMod.getCantidadCarpas() - cantidadACambiar);
                    inventario.sumarCantidad("Carpas", cantidadACambiar);
                    apartadoMod.setCostoTotalCliente(apartadoMod.getCostoTotalCliente() -(cantidadACambiar*1200));             
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
            System.out.println("[NO HUBO RESULTADO]");
        }
    }

    public void seguimientoApartados(){ 
        if(apartados.isEmpty()){
            System.out.println("Aun no hay apartados establecidos");
        }else{ 
        for (Integer idApartado: apartados.keySet()) {
            Apartado apartado = apartados.get(idApartado);
            System.out.println("Id del Apartado: " + (idApartado) + ":"); 
            System.out.println("  Sillas: " + apartado.getCantidadSillas());
            System.out.println("  Mesas: " + apartado.getCantidadMesas());
            System.out.println("  Carpas: " + apartado.getCantidadCarpas());
            System.out.println("  Manteles: " + apartado.getCantidadManteles());
            System.out.println("  Fecha de entrega (Estado del pedido): " + apartado.getFechaDeEntrega());
            System.out.println("  Costo Total Del Apartado: "+apartado.getCostoTotalCliente() + "$");
            System.out.println("-----------------");   
        }
      }
    }
}                          