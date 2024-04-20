import java.util.ArrayList;
import java.util.Scanner;
public class Cliente {
  
    private String nombre;
    private int contacto; 
    private String direccion;
    private int idCliente=0;
    private String correoElectronico;
    // esta clase es clave para rentar y apartar los objetos (mesas, sillas,etc).
    private ArrayList<Cliente> clientes= new ArrayList<>();
    Scanner sc= new Scanner(System.in);
    
    public Cliente(String nombre, int contacto, String direccion, String correoElectronico) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.direccion = direccion;
        this.correoElectronico=correoElectronico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public int getIdCliente(){
        return idCliente;
    }

    public void setIdCliente(int idCliente){
        this.idCliente= idCliente;
    }

    public String getCorreoElectronico(){
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico){
        this.correoElectronico=correoElectronico;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public void registrarCliente(){
           idCliente++;

           System.out.println("Ingresar datos del cliente: ");
           System.out.println("Ingresa su nombre: ");
           nombre= sc.nextLine();
           System.out.println("Ingresa su contacto (Numero tel.) ");
           contacto= Usuario.leerEntero();
           System.out.println("Ingresa su direccion: ");
           direccion= sc.nextLine();
           System.out.println("Ingresa su correo Electronico: ");
           correoElectronico= sc.nextLine();
           // instancia de un objeto y asignacion de referencia, asi se le conoce a esto ya que implementa una instancia nueva dentro del proceso de aguardar el cliente
           clientes.add(new Cliente(nombre, contacto, direccion, correoElectronico));
           System.out.println("Se registro exitosamente con el id: " + idCliente);
        
    }

    public void consultarCliente(int idConsulta, GestorRentas gestorRentas, GestorApartados gestorApartados) {
        if (!clientes.isEmpty() && idConsulta >= 1 && idConsulta <= clientes.size()) {
            Cliente clienteConsultado = clientes.get(idConsulta - 1);
        System.out.println("¿Que deseas visualizar? ");
        System.out.println("1. Ver datos del Cliente \n 2. Ver datos del pedido");
        int option=Usuario.leerEntero();
        if (option==1) {
            
            if (clienteConsultado != null) {
                System.out.println("----> Datos del cliente <----");
                System.out.println("Nombre: " + clienteConsultado.getNombre());
                System.out.println("Contacto: " + clienteConsultado.getContacto());
                System.out.println("Dirección: " + clienteConsultado.getDireccion());
                System.out.println("Correo Electrónico: " + clienteConsultado.getCorreoElectronico());
            } else {
                System.out.println("Cliente no encontrado");
            }
        }if(option==2){ 
            if (!gestorRentas.getRentas().isEmpty() && gestorRentas.getRentas().containsKey(idConsulta)) {
                Renta renta = gestorRentas.getRentas().get(idConsulta);
                System.out.println("----> Datos del pedido <----");
                System.out.println(" Cliente: " +clienteConsultado.getNombre());
                System.out.println("  Sillas: " + renta.getCantidadSillas());
                System.out.println("  Mesas: " + renta.getCantidadMesas());
                System.out.println("  Carpas: " + renta.getCantidadCarpas());
                System.out.println("  Manteles: " + renta.getCantidadManteles());
                System.out.println("  Fecha de entrega: " + renta.getFechaDeEntrega());
                System.out.println("  Costo Total De La Renta: " + renta.getCostoTotalCliente() + "$");
                System.out.println("-----------------");
            }
    
            if (!gestorApartados.getApartados().isEmpty() && gestorApartados.getApartados().containsKey(idConsulta)) {
                Apartado apartado = gestorApartados.getApartados().get(idConsulta);
                System.out.println("  Sillas: " + apartado.getCantidadSillas());
                System.out.println("  Mesas: " + apartado.getCantidadMesas());
                System.out.println("  Carpas: " + apartado.getCantidadCarpas());
                System.out.println("  Manteles: " + apartado.getCantidadManteles());
                System.out.println("  Fecha de entrega: " + apartado.getFechaDeEntrega());
                System.out.println("  Costo Total Del apartado: " + apartado.getCostoTotalCliente() + "$");
                System.out.println("-----------------");
            }
          }
          if(option !=1 && option !=2){
            System.out.println("Opción invalida");
          }
        } else {
            System.out.println("No hay clientes registrados o el ID de cliente no existe.");
        }
    }
    
}

