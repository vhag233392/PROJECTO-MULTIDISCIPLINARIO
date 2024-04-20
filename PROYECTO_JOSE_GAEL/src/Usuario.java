import java.util.InputMismatchException;
import java.util.Scanner;
class Usuario {
    
    private static Scanner scanner = new Scanner(System.in);
    //polimorfismo
    private Administrador usuario1= new Administrador();
    private Empleados usuario2= new Empleados();

    public void InicioSesion(){
    String usuarioAdmin = "admin";
    int pinAdmin = 777;

    String usuarioEmpleado = "empleado";
    int pinEmpleado1 = 1234;
    int pinEmpleado2 = 4321;

    boolean usuarioValido = false;
    boolean contraseñaValida = false;

    while (!usuarioValido || !contraseñaValida) {
        System.out.println("Inicie sesión");
        System.out.println("Usuario:");
        String usuario = scanner.nextLine();
        System.out.println("Contraseña");
        int pin = leerEntero();
        scanner.nextLine(); // Consumir el salto de línea

        if (usuario.equals(usuarioAdmin) && pin == pinAdmin) {
            System.out.println("----> Bienvenido Administrador  <----");
            usuario1.verMenuAdmin();
            usuarioValido = true;
            contraseñaValida = true;
        } else if (usuario.equals(usuarioEmpleado) && (pin == pinEmpleado1 || pin == pinEmpleado2)) {
            System.out.println("----> Bienvenido empleado <----");
            usuario2.verMenuEmpleado();
            usuarioValido = true;
            contraseñaValida = true;
        } else {
            System.out.println("Usuario y/o contraseña incorrecta");
            System.out.println("¿Desea volver a intentarlo? (s/n)");
            String retry = scanner.nextLine();
            if (!retry.equalsIgnoreCase("s")) {
                System.out.println("¡Hasta luego! ");
                break; // Salir del bucle si el usuario decide no volver a intentarlo
            }
        }
     }
     cerrarSesion();
    }

   public void cerrarSesion(){
    System.out.println("Sesión cerrada, ¡Hasta luego! ");
   }
// para excepciones
   public static int leerEntero() {
    int numero = 0;
    boolean entradaValida = false;
    do {
        try {
            numero = scanner.nextInt();
            entradaValida = true;
        } catch (InputMismatchException e) {
            System.out.println("Error: Debes ingresar un número valido.");
            scanner.nextLine(); 
        }
    } while (!entradaValida);

    return numero;
 }
}
