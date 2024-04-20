import java.util.Scanner;

public class Administrador {
    private static Scanner scanner = new Scanner(System.in);    
    Cliente cliente= new Cliente(null, 0, null, null);
    private Renta renta= new Renta(null, null, null, 0);
    private Apartado apartado= new Apartado(null);
    private Inventario inventario = new Inventario(); // Instancia de Inventario a nivel de clase
    private  Producto producto = new Producto("", 0); // Instancia genérica de Producto
    private GestorApartados gestorApartado = new GestorApartados(inventario, apartado, cliente, producto);
    private GestorRentas gestorRenta = new GestorRentas(inventario, renta, cliente,producto);
    Reportes report = new Reportes(0,0);
    Apartado apart = new Apartado("fechaDeEntrega", gestorApartado);
    Renta rent = new Renta(null, gestorRenta,cliente);
    
    public void verMenuAdmin(){
        int adm =0 ;
        adm++;
        report.setReporteAdmin(adm);
        int opcion;  
        int option; 
        do {
            System.out.println("-----------------------------------");
            System.out.println("El siguiente menú es del Administrador:\nElija una Opción: ");
            System.out.println("1.Inventario  \n 2.Pedidos \n" + //
            "3.Clientes \n 4.Administracion  \n" + "5.Cerrar Sesión");
        opcion= Usuario.leerEntero();
        switch (opcion) {
            case 1:
                System.out.println("----> Inventario  <----");
                       System.out.println("Eliga una opción: ");
                       System.out.println("1. Consultar Inventario \n 2. Actualizar Inventario");
                       opcion=Usuario.leerEntero();
                       switch (opcion) {
                        case 1:
                        inventario.consultarInventario();
                            break;
                        case 2:
                        producto.actualizarCantidad(inventario);
                            break;
                        default:
                        System.out.println("Opción invalida");
                            break;
                       }
                break;
            //
            case 2:
            System.out.println("----> Pedidos <----");
            System.out.println("Elige una opción del menú");
            System.out.println(" 1. Levantar pedido \n 2. Modificar Renta \n 3. Finalizar Renta \n 4. Modificar Apartado \n 5. Finalizar Apartado \n 6. Seguimiento de RENTA/APARTADO");
            option=Usuario.leerEntero();
            switch (option) {
                //
                case 1:
                cliente.registrarCliente();
                System.out.println(" Desea realizar 1.Renta o 2.apartado?");
                int options = Usuario.leerEntero();
                while (options != 1 && options != 2) {
                    System.out.println(" Opción invalida, por favor seleccione una opción correcta, 1.Renta o 2.apartado ");
                    options= Usuario.leerEntero();
                }
                switch (options) {
                   case 1:
                   gestorRenta.crearRenta();
                       break;
                   case 2:
                   gestorApartado.crearApartado();
                        break;
                   default:
                   System.out.println(" ERROR");
                       break;
                }
                    break;
                case 2:
                gestorRenta.modificarRenta();
                       break;
                case 3:
                System.out.println("----> Finalizar Renta <----");
                System.out.println("Ingresa el id de la Renta a finalizar: ");
                int idRentaFinalizar = Usuario.leerEntero();
                gestorRenta.finalizarRenta(idRentaFinalizar);
                       break;
                case 4:
                gestorApartado.modificarApartado();
                       break;
                case 5:
                System.out.println("----> Finalizar Apartado <----");
                System.out.println("Ingresa el id del Apartado a finalizar: ");
                int indice= Usuario.leerEntero();
                gestorApartado.finalizarApartado(indice);
                      break;
                case 6:
                System.out.println("----> Seguimiento <----");
                System.out.println("Eliga una opción: ");
                System.out.println("\n 1.- Seguimineto de Rentas \n 2.- Seguimiento de Apartado");
                int opcionSeguimiento = Usuario.leerEntero();
                if(opcionSeguimiento > 2 || opcionSeguimiento < 1){
                    System.out.println("Opción No Valida");
                }
                if(opcionSeguimiento == 1){
                   gestorRenta.seguimientoRentas(); 
                }
                if(opcionSeguimiento == 2){
                    gestorApartado.seguimientoApartados();
                }  
                 break;
                default:
                System.out.println("Opción invalida");
                    break;
            }
            break;
            //
            case 3:
             System.out.println("----> Clientes <----");
             System.out.println("Eliga una opción: ");
             System.out.println("1. Consultar Cliente ");
             opcion=Usuario.leerEntero();
             if(opcion==1){
                System.out.print("Ingrese el ID del cliente a consultar: ");
                int idConsulta = Usuario.leerEntero();
                cliente.consultarCliente(idConsulta, gestorRenta, gestorApartado);
             }else{
               System.out.println("Opción invalida");
             }
           
            break;
            //
            case 4:
            System.out.println("----> Administración <----");
            System.out.println("Eliga una opción: ");
            System.out.println("1. Ver Reportes del día");
            opcion= Usuario.leerEntero();
            if (opcion==1) {
                report.reportesDelDia(rent,apart);
            }else{
                System.out.println("Opción invalida");
            }

            break;
            case 5:
            //Cerrando Sesión tukutuku
            break;
            default:
                break;
        }
    } while (opcion != 5);
    
  }
}
