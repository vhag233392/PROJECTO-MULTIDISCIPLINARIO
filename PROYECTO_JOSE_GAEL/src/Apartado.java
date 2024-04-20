public class Apartado extends Servicios{
    private int idApartado;
    private Double costoApartado;
    private int cantidadSillas;
    private int cantidadMesas;
    private int cantidadCarpas;
    private int cantidadManteles;
    private double costoTotalCliente;
    private GestorApartados apartados;

    public double getCostoTotalCliente() {
        return costoTotalCliente;
    }

    public void setCostoTotalCliente(double costoTotalCliente) {
        this.costoTotalCliente = costoTotalCliente;
    }
   
    public Apartado(String fechaDeEntrega, int cantidadSillas, int cantidadMesas, int cantidadCarpas, int cantidadManteles, double costoTotalCliente){
        super(fechaDeEntrega);
        this.cantidadSillas = cantidadSillas;
        this.cantidadMesas = cantidadMesas;
        this.cantidadCarpas = cantidadCarpas;
        this.cantidadManteles = cantidadManteles;
        this.costoTotalCliente = costoTotalCliente;
    }
    //para reportes
    public Apartado(String fechaDeEntrega, GestorApartados apartados){
        super(fechaDeEntrega);
        this.apartados=apartados;
    }

    public Apartado(String fechaDeEntrega) {
        super(fechaDeEntrega);
    }

    public int getIdApartado(){
        return idApartado;
    }

    public void setIdApartado(int idApartado){
        this.idApartado=idApartado;
    }
    
    public Double getCostoApartado(){
        return costoApartado;
    }

    public void setCostoApartado(Double costoApartado){
        this.costoApartado=costoApartado;
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

    public void mostrarDatos(){
        if (apartados != null) {
            if(apartados.getApartados().size() > 0)
            System.out.println("Número de apartados realizados: " + apartados.getApartados().size());
            else{
                System.out.println("No se ha realizado ningun apartado hoy.");
            }
        } else {
            System.out.println("No se ha realizado ningun apartado hoy. :)");
        };
    }
}
