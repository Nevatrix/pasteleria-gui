
package controlador;

import model.PedidoCompleto;
import model.Usuario;
import java.io.*;

public class PasteleriaController {
    private PedidoCompleto[] pedidos;
    private int contador;

    public PasteleriaController() {
        pedidos = new PedidoCompleto[10];
        contador=0;
    }
    
    public Usuario agregarUsuario(long dni, String nombre, long telefono){
        Usuario usuariotmp;
        usuariotmp = new Usuario(dni, nombre, telefono);
        return usuariotmp;
    }
    
    public Usuario asignarUsuario(int pos){
        Usuario usuariotmp;
        usuariotmp = pedidos[pos].getUsuario();
        return usuariotmp;
    }
    
    public void agregarPedidos(String tipoPastel, String tamañoPastel, 
            String adicionalesPastel, double precioTipo, double precioTamaño, 
            double precioAdicionales, Usuario usuario){
        
        aumentar();
        
        PedidoCompleto pedidotmp;
        pedidotmp = new PedidoCompleto(adicionalesPastel, precioAdicionales, contador+1, tipoPastel, tamañoPastel, precioTipo, precioTamaño, 0, false, usuario);
        pedidotmp.calcularPrecioTotal();
        pedidos[contador]=pedidotmp;
        contador++;
    }

    public int buscarUsuario(long dni){
        for (int i = 0; i < contador; i++) {
            if (pedidos[i].getUsuario().getDni() == dni ) {
                return i;
            }
        }
        return -1;
    }
    
    public int busquedaPedido(int numPedido){
        for (int i = 0; i < contador; i++) {
            if (pedidos[i].getNumPedido() == numPedido && !pedidos[i].isBorrado()) {
                return i;
            }
        }
        return -1;
    }
    
    public String obtenerPedido(int numPedido){
        String pedido;
        int pos = numPedido-1;
        
        pedido = "VENTA"
                +"\n----------------------------------"
                +"\n·TIPO: "+pedidos[pos].getTipoPastel()
                +"\n·TAMAÑO: "+pedidos[pos].getTamañoPastel()
                +"\n·ADICIONAL: "+pedidos[pos].getAdicionalesPastel()
                +"\n----------------------------------"
                +"\nCLIENTE: "+pedidos[pos].getUsuario().getNombre()
                +"\nTOTAL: S/."+pedidos[pos].getPrecioTotal();
        
        return pedido;
    }
    
    public PedidoCompleto obtenerPedidoCompleto(int pos){
        
        PedidoCompleto pedido;
        pedido = pedidos[pos];
        
        return pedido;
    }
    
    
    public void eliminarPedido(int pos){
       pedidos[pos].setBorrado(true);
    }
    
    public void modificarUsuario(long dni, String nombre, long telefono){
        for (int i = 0; i < contador; i++) {
            if(dni == pedidos[i].getUsuario().getDni()){
                Usuario usuarionew = new Usuario(dni, nombre, telefono);
                
                pedidos[i].setUsuario(usuarionew);
            }
        }
        guardarPedidosEnArchivo("pedidos.dat");
    }

    public void modificarTipoPedido(int pos, String tipoPastel, double precioTipo){
        pedidos[pos].setTipoPastel(tipoPastel);
        pedidos[pos].setPrecioTipo(precioTipo);
        pedidos[pos].calcularPrecioTotal();
        guardarPedidosEnArchivo("pedidos.dat");
    }
    
    public void modificarTamañoPedido(int pos, String tamañoPastel, double precioTamaño){
        pedidos[pos].setTamañoPastel(tamañoPastel);
        pedidos[pos].setPrecioTamaño(precioTamaño);
        pedidos[pos].calcularPrecioTotal();
        guardarPedidosEnArchivo("pedidos.dat");
    }
    
    public void modificarAdicionalesPedido(int pos, String adicionalPastel, double precioAdicional){
        pedidos[pos].setAdicionalesPastel(adicionalPastel);
        pedidos[pos].setPrecioAdicionales(precioAdicional);
        pedidos[pos].calcularPrecioTotal();
        guardarPedidosEnArchivo("pedidos.dat");
    }

    public void aumentar(){
        if (pedidos.length == contador) {
            PedidoCompleto datostmp[] = new PedidoCompleto[pedidos.length + 3];
            for (int i = 0; i < contador; i++) {
                datostmp[i] = pedidos[i];
            }
            pedidos = datostmp;
        }
    }
    
    
    public String[][] obtenerDatosPedidosActivos() {
        int cantidadPedidosActivos = 0;

        // Ciclo para saber cuántos pedidos están activos
        for (int i = 0; i < contador; i++) {
            if (pedidos[i].isBorrado() == false) {
                cantidadPedidosActivos++;
            }
        }

        String[][] datos = new String[cantidadPedidosActivos][8];
        int fila = 0;

        for (int i = 0; i < contador; i++) {
            if (!pedidos[i].isBorrado()) {
                datos[fila][0] = String.valueOf(pedidos[i].getNumPedido());
                datos[fila][1] = pedidos[i].getTipoPastel();
                datos[fila][2] = pedidos[i].getTamañoPastel();
                datos[fila][3] = pedidos[i].getAdicionalesPastel();
                datos[fila][4] = String.valueOf(pedidos[i].getPrecioTotal());
                datos[fila][5] = String.valueOf(pedidos[i].getUsuario().getDni());
                datos[fila][6] = pedidos[i].getUsuario().getNombre();
                datos[fila][7] = String.valueOf(pedidos[i].getUsuario().getTelefono());
                fila++;
            }
        }

        return datos;
    }
    
    public void guardarPedidosEnArchivo(String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeInt(contador); // Guardar la cantidad de pedidos
            for (int i = 0; i < contador; i++) {
                outputStream.writeObject(pedidos[i]); // Guardar cada pedido
            }
            System.out.println("Pedidos guardados en el archivo: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void cargarPedidosDesdeArchivo(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            int cantidadPedidos = inputStream.readInt(); // Leer la cantidad de pedidos
            pedidos = new PedidoCompleto[cantidadPedidos];
            for (int i = 0; i < cantidadPedidos; i++) {
                pedidos[i] = (PedidoCompleto) inputStream.readObject(); // Leer cada pedido
            }
            contador = cantidadPedidos;
            System.out.println("Pedidos cargados desde el archivo: " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }




    
}
