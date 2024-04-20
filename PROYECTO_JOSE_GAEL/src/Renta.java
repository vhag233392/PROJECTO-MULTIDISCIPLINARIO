import java.util.List;
public class Renta extends Servicios{
    private Cliente cliente;
    private Double costoRenta;
    private int cantidadSillas;
    private int cantidadMesas;
    private int cantidadCarpas;
    private int cantidadManteles;
    private int idRenta;
    private double costoTotalCliente;
    private GestorRentas rentas;
     
    public Renta(Cliente cliente, String fechaDeEntrega, Double costoRenta, int idRenta) {
        super(fechaDeEntrega);
        this.cliente = cliente;
        this.costoRenta = costoRenta;
        this.idRenta= idRenta;
    }
    
    public Renta(int cantidadSillas, int cantidadMesas, int cantidadCarpas, int cantidadManteles, String fechaDeEntrega, double costoTotalCliente) {
        super(fechaDeEntrega);
        this.cantidadSillas = cantidadSillas;
        this.cantidadMesas = cantidadMesas;
        this.cantidadCarpas = cantidadCarpas;
        this.cantidadManteles = cantidadManteles;
        this.costoTotalCliente = costoTotalCliente;
        
    }
// para reportes
    public Renta(String fechaDeEntrega, GestorRentas rentas, Cliente cliente){
        super(fechaDeEntrega);
        this.rentas=rentas;
        this.cliente=cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Double getCostoRenta() {
        return costoRenta;
    }

    public double getCostoTotalCliente(){
        return costoTotalCliente;
    }

    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setCostoRenta(Double costoRenta) {
        this.costoRenta = costoRenta;
    }
    
    public int getCantidadSillas() {
        return cantidadSillas;
    }

    public void setCantidadSillas(int cantidadSillas) {
        this.cantidadSillas = cantidadSillas;
    }

    public int getCantidadMesas() {
        return cantidadMesas;
    }

    public void setCantidadMesas(int cantidadMesas) {
        this.cantidadMesas = cantidadMesas;
    }

    public int getCantidadCarpas() {
        return cantidadCarpas;
    }

    public void setCantidadCarpas(int cantidadCarpas) {
        this.cantidadCarpas = cantidadCarpas;
    }

    public int getCantidadManteles() {
        return cantidadManteles;
    }

    public void setCantidadManteles(int cantidadManteles) {
        this.cantidadManteles = cantidadManteles;
    }

    public String getFechaDeEntrega() {
        return fechaDeEntrega;
    }

    public void setFechaDeEntrega(String fechaDeEntrega) {
        this.fechaDeEntrega = fechaDeEntrega;
    }

    public void setCostoTotalCliente(double costoTotalCliente){
        this.costoTotalCliente = costoTotalCliente;
    }

    public int getIdRenta(){
        return idRenta;
    }

    public void setIdRenta(int idRenta){
        this.idRenta=idRenta;
    }
  public void mostrarDatos(){
    mostrarDatos(cliente);
    if(rentas != null){
        if(rentas.getRentas().size() > 0)
        System.out.println("Número de rentas realizados: "+ rentas.getRentas().size());
        else{
            System.out.println("No se ah realizado ninguna renta hoy. ");
        }
    }else{
        System.out.println("No se ah realizado ninguna renta hoy. :)");
    }
  }
}
