public class Reportes {
    private int reporteAdmin;
    private int reporteEmpleado;
    
    public Reportes(int reporteEmpleado,int reporteAdmin) {
        this.reporteEmpleado = reporteEmpleado;
        this.reporteAdmin = reporteAdmin;
    }

    public int getReporteAdmin() {
        return reporteAdmin;
    }

    public int getReporteEmpleado() {
        return reporteEmpleado;
    }

    public void setReporteAdmin(int reporteAdmin){
        this.reporteAdmin = reporteAdmin;
    }

    public void setReporteEmpleado(int reporteEmpleado){
        this.reporteEmpleado = reporteEmpleado;
    }

    public void reportesDelDia(Renta renta, Apartado apartado){
        System.out.println("----> Reportes del día <----");
        renta.mostrarDatos();
        apartado.mostrarDatos();
 
    }
}
