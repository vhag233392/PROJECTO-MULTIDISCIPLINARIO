abstract class Servicios {
    
    protected String fechaDeEntrega;

    public Servicios(String fechaDeEntrega){
      this.fechaDeEntrega=fechaDeEntrega;
    }

    public void mostrarDatos(Cliente clientes) {
      if(clientes != null){ 
        if(clientes.getClientes().size() >0)
      System.out.println("Total de clientes que han levantado pedidos: " +clientes.getClientes().size());
      else{
        System.out.println("No se ah registrado ningun pedido el día de hoy. ");
      }
      }
    else{
      System.out.println("No se ah registrado ningun pedido el día de hoy. :)");
    }
  } 
}