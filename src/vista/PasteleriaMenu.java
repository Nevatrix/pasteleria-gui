package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import biblioteca.LE;
import controlador.PasteleriaController;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Usuario; // Solo para tomar de referencia

public class PasteleriaMenu extends JFrame {
    
    PasteleriaController controlador;

    public PasteleriaMenu() {
        initComponents();
        controlador = new PasteleriaController();
        controlador.cargarPedidosDesdeArchivo("pedidos.dat");
        setIconImage(new ImageIcon(getClass().getResource("/logo.png")).getImage());
    }
    
    public interface MenuSelectionListener {
        void onTipoPastelSelected(String tipoPastel, double precioTipo);
        void onTamañoPastelSelected(String tamañoPastel, double precioTamaño);
        void onAdicionalSelected(String adicionales, double precioAdicionales);
    }

    private void initComponents() {
        setTitle("PASTELERIA MATE - MENÚ PRINCIPAL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 400));
        setResizable(false); // No permitir maximizar
        setLayout(new GridLayout(6, 1));

        // Panel para centrar el JLabel
        JPanel panel = new JPanel(new GridBagLayout());
        JLabel label = new JLabel("SELECCIONA UNA OPCIÓN");
        panel.add(label);
        
        // Agregar el panel al centro del JFrame
        add(panel, BorderLayout.CENTER);

        JButton btn1 = new JButton("INGRESAR PEDIDO");
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción 1
                setVisible(false);
                ingresarPedido();
            }
        });
        add(btn1);

        JButton btn2 = new JButton("MODIFICAR DATOS");
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción 2
                setVisible(false);
                modificarDatosMenu();
            }
        });
        add(btn2);

        JButton btn3 = new JButton("BUSCAR PEDIDO");
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción 3
                setVisible(false);
                busquedaPedido();
            }
        });
        add(btn3);

        JButton btn4 = new JButton("ELIMINAR PEDIDO");
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción 4
                setVisible(false);
                eliminarPedido();
            }
        });
        add(btn4);

        JButton btn5 = new JButton("VISUALIZAR PEDIDOS");
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción 5
                setVisible(false);
                mostrarDatosPedidosActivos();
            }
        });
        add(btn5);

        pack();
        setLocationRelativeTo(null); // Centrar la ventana
    }
    
    public void tipoPastelMenu(MenuSelectionListener listener){
        JFrame frame = new JFrame("Tipo de Pastel");
        frame.setIconImage(new ImageIcon(getClass().getResource("/logo.png")).getImage());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setResizable(false);

        frame.setLayout(new GridLayout(7, 1));
        
        // Panel para centrar el JLabel
        JPanel panel = new JPanel(new GridBagLayout());
        JLabel label = new JLabel("TIPO DE PASTEL");
        panel.add(label);
        
        // Agregar el panel al centro del JFrame
        frame.add(panel, BorderLayout.CENTER);

        JButton btnVainilla = new JButton("VAINILLA S/70");
        btnVainilla.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción Vainilla
                listener.onTipoPastelSelected("VAINILLA", 70);
                frame.dispose();
            }
        });
        frame.add(btnVainilla);

        JButton btnNaranja = new JButton("NARANJA S/75");
        btnNaranja.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listener.onTipoPastelSelected("NARANJA", 75);
                frame.dispose();
            }
        }); 
        frame.add(btnNaranja);

        JButton btnChocolate = new JButton("CHOCOLATE S/80");
        btnChocolate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listener.onTipoPastelSelected("CHOCOLATE", 80);
                frame.dispose();
            }
        });
        frame.add(btnChocolate);

        JButton btnFresa = new JButton("FRESA S/80");
        btnFresa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listener.onTipoPastelSelected("FRESA", 80);
                frame.dispose();
            }
        });
        frame.add(btnFresa);

        JButton btnMarmoleado = new JButton("MARMOLEADO S/75");
        btnMarmoleado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listener.onTipoPastelSelected("MARMOLEADO", 75);
                frame.dispose();   
            }
        });
        frame.add(btnMarmoleado);

        JButton btnZanahoria = new JButton("ZANAHORIA S/80");
        btnZanahoria.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listener.onTipoPastelSelected("ZANAHORIA", 80);
                frame.dispose();
            }
        });
        frame.add(btnZanahoria);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public void tamañoPastelMenu(MenuSelectionListener listener) {
        
        JFrame frame = new JFrame("Tamaño de Pastel");
        frame.setIconImage(new ImageIcon(getClass().getResource("/logo.png")).getImage());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setResizable(false);

        frame.setLayout(new GridLayout(4, 1));

        JLabel label = new JLabel("TAMAÑO DE PASTEL", SwingConstants.CENTER);
        frame.add(label);

        JButton btnPequeño = new JButton("Pequeño");
        btnPequeño.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               listener.onTamañoPastelSelected("PEQUEÑO", 0.5);
               frame.dispose();
            }
        });
        frame.add(btnPequeño);

        JButton btnMediano = new JButton("Mediano");
        btnMediano.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               listener.onTamañoPastelSelected("MEDIANO", 1);
               frame.dispose();
            }
        });
        frame.add(btnMediano);

        JButton btnGrande = new JButton("Grande");
        btnGrande.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               listener.onTamañoPastelSelected("GRANDE", 2);
               frame.dispose();
            }
        });
        frame.add(btnGrande);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public void adicionalesPastelMenu(MenuSelectionListener listener) {
        JFrame frame = new JFrame("Adicionales del Pastel");
        frame.setIconImage(new ImageIcon(getClass().getResource("/logo.png")).getImage());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setResizable(false);

        frame.setLayout(new GridLayout(6, 1));

        JLabel label = new JLabel("ADICIONAL PASTEL", SwingConstants.CENTER);
        frame.add(label);

        JButton btnPecanas = new JButton("PECANAS S/10");
        btnPecanas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               listener.onAdicionalSelected("PECANAS", 10);
               frame.dispose();
            }
        });
        frame.add(btnPecanas);

        JButton btnRalladuraChocolate = new JButton("RALLADURA DE CHOCOLATE S/5");
        btnRalladuraChocolate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listener.onAdicionalSelected("RALLADURA DE CHOCOLATE", 5);
                frame.dispose();
            }
        });
        frame.add(btnRalladuraChocolate);

        JButton btnFresas = new JButton("FRESAS S/8");
        btnFresas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listener.onAdicionalSelected("FRESAS", 8);
                frame.dispose();
            }
        });
        frame.add(btnFresas);

        JButton btnMalvaviscos = new JButton("MALVAVISCOS S/3");
        btnMalvaviscos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listener.onAdicionalSelected("MALVAVISCOS", 3);
                frame.dispose();
            }
        });
        frame.add(btnMalvaviscos);

        JButton btnNoAgregar = new JButton("NO AGREGAR");
        btnNoAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listener.onAdicionalSelected("-", 0);
                frame.dispose();
            }
        });
        frame.add(btnNoAgregar);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }



    
    public Usuario ingresarUsuario(){
        long dni;
        String nombre;
        long telefono;
        int pos;
        
        Usuario usuariotmp;
        
        do {            
            dni = LE.leerLong("Ingrese su DNI");
            if (dni<10000000 || dni>99999999) {
            LE.mostrarError("Ingresa un dni valido");
            }
        } while (dni<10000000 || dni>99999999);
    
        pos = controlador.buscarUsuario(dni);
        
        if (pos > -1) {
            usuariotmp = controlador.asignarUsuario(pos);
            return usuariotmp;
        } else{
            do {
                nombre=LE.leerString("Ingrese su nombre");
                if (!nombre.matches("[A-Za-z ]+") || nombre.length() < 2
                        || nombre.length() > 100) {
                    LE.mostrarError("Ingresa un nombre valido");
                }
            } while (!nombre.matches("[A-Za-z ]+") || nombre.length() < 2
                        || nombre.length() > 100);
            
            do {                
                telefono=LE.leerLong("Ingrese su número de telefono");
                if (telefono<900000000 || telefono>999999999) {
                    LE.mostrarError("Ingrese un número valido");
                }
            } while (telefono<900000000 || telefono>999999999);
            
            usuariotmp = new Usuario(dni, nombre, telefono);
            return usuariotmp;
        }
    }
    

    public void ingresarPedido() {
        Usuario usuariotmp = ingresarUsuario();
        
        ingresarTipoPastel(usuariotmp);
    }

    private void ingresarTipoPastel(Usuario usuario) {
        tipoPastelMenu(new MenuSelectionListener() {
            @Override
            public void onTipoPastelSelected(String tipoPastel, double precioTipo) {
                ingresarTamañoPastel(usuario, tipoPastel, precioTipo);
            }

            @Override
            public void onTamañoPastelSelected(String tamañoPastel, double precioTamaño) {
                // No se usa en esta etapa
            }

            @Override
            public void onAdicionalSelected(String adicionales, double precioAdicionales) {
                // No se usa en esta etapa
            }
        });
    }

    private void ingresarTamañoPastel(Usuario usuario, String tipoPastel, double precioTipo) {
        tamañoPastelMenu(new MenuSelectionListener() {
            @Override
            public void onTipoPastelSelected(String tipoPastel, double precioTipo) {
                // No se usa en esta etapa
            }

            @Override
            public void onTamañoPastelSelected(String tamañoPastel, double precioTamaño) {
                ingresarAdicionalesPastel(usuario, tipoPastel, precioTipo, tamañoPastel, precioTamaño);
            }

            @Override
            public void onAdicionalSelected(String adicionales, double precioAdicionales) {
                // No se usa en esta etapa
            }
        });
    }

    private void ingresarAdicionalesPastel(Usuario usuario, String tipoPastel, double precioTipo, String tamañoPastel, double precioTamaño) {
        adicionalesPastelMenu(new MenuSelectionListener() {
            @Override
            public void onTipoPastelSelected(String tipoPastel, double precioTipo) {
                // No se usa en esta etapa
            }

            @Override
            public void onTamañoPastelSelected(String tamañoPastel, double precioTamaño) {
                // No se usa en esta etapa
            }

            @Override
            public void onAdicionalSelected(String adicionales, double precioAdicionales) {
                controlador.agregarPedidos(tipoPastel, tamañoPastel, adicionales, precioTipo, precioTamaño, precioAdicionales, usuario);
                //initComponents();
                controlador.guardarPedidosEnArchivo("pedidos.dat");
                String resumen = "RESUMEN"
                                +"\n----------------------------------"
                                +"\n·TIPO: "+tipoPastel
                                +"\n·TAMAÑO: "+tamañoPastel
                                +"\n·ADICIONAL: "+adicionales
                                +"\n----------------------------------"
                                +"\nCLIENTE: "+usuario.getNombre()
                                +"\nTOTAL: S/."+((precioTipo * precioTamaño) + precioAdicionales);
                LE.mostrarInformacion(resumen);
                SwingUtilities.invokeLater(() -> setVisible(true));
            }
        });
    }

    private void modificarDatosMenu(){
        JFrame frame = new JFrame("Modificar Datos");
        frame.setIconImage(new ImageIcon(getClass().getResource("/logo.png")).getImage());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setResizable(false);

        frame.setLayout(new GridLayout(3, 1));

        JLabel label = new JLabel("MODIFICAR DATOS", SwingConstants.CENTER);
        frame.add(label);

        JButton btnUsuario = new JButton("MODIFICAR USUARIO");
        btnUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarUsuario();
                frame.dispose();
            }
        });
        frame.add(btnUsuario);

        JButton btnPedido = new JButton("MODIFICAR PEDIDO");
        btnPedido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarPedido();
                frame.dispose();
            }
        });
        frame.add(btnPedido);
        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private void modificarUsuario(){
        long dni = LE.leerLong("Ingrese el DNI del usuario a modificar");
        int pos = controlador.buscarUsuario(dni);
        
        String nombre;
        long telefono;
        
        if (pos>-1){
            
            do {
                nombre=LE.leerString("Ingrese su nombre");
                if (!nombre.matches("[A-Za-z ]+") || nombre.length() < 2
                        || nombre.length() > 100) {
                    LE.mostrarError("Ingresa un nombre valido");
                }
            } while (!nombre.matches("[A-Za-z ]+") || nombre.length() < 2
                        || nombre.length() > 100);
            
            do {                
                telefono=LE.leerLong("Ingrese su número de telefono");
                if (telefono<900000000 || telefono>999999999) {
                    LE.mostrarError("Ingrese un número valido");
                }
            } while (telefono<900000000 || telefono>999999999);
            
            controlador.modificarUsuario(dni, nombre, telefono);
            LE.mostrarInformacion("Usuario modificado correctamente");
            
            SwingUtilities.invokeLater(() -> setVisible(true));
        } else {
            LE.mostrarError("El usuario no existe");
            SwingUtilities.invokeLater(() -> setVisible(true));
        }
    }
    
    private void modificarPedidoMenu(int pos) {
        JFrame frame = new JFrame("Modificar Pedido");
        frame.setIconImage(new ImageIcon(getClass().getResource("/logo.png")).getImage());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setResizable(false);

        frame.setLayout(new GridLayout(4, 1));

        JLabel label = new JLabel("MODIFICAR PEDIDO", SwingConstants.CENTER);
        frame.add(label);

        JButton btnTipo = new JButton("Modificar Tipo");
        btnTipo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarTipoPastel(pos);
                frame.dispose();
            }
        });
        frame.add(btnTipo);

        JButton btnTamaño = new JButton("Modificar Tamaño");
        btnTamaño.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarTamañoPastel(pos);
                frame.dispose();
            }
        });
        frame.add(btnTamaño);

        JButton btnAdicionales = new JButton("Modificar Adicional");
        btnAdicionales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarAdicionalPastel(pos);
                frame.dispose();
            }
        });
        frame.add(btnAdicionales);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private void modificarPedido(){
        int numPedido = LE.leerInt("Ingrese el numero de pedido a modificar");
        int pos = controlador.busquedaPedido(numPedido);
        
        if (pos > -1) {
            modificarPedidoMenu(pos);
        } else {
            LE.mostrarError("No existe el pedido");
            SwingUtilities.invokeLater(() -> setVisible(true));
        }
    }
    
    private void modificarTipoPastel(int pos) {
        tipoPastelMenu(new MenuSelectionListener() {
            @Override
            public void onTipoPastelSelected(String tipoPastel, double precioTipo) {
                controlador.modificarTipoPedido(pos , tipoPastel, precioTipo);
                LE.mostrarInformacion("Tipo de pastel modificado exitosamente.");
                SwingUtilities.invokeLater(() -> setVisible(true));
            }
            
            @Override
            public void onTamañoPastelSelected(String tamañoPastel, double precioTamaño) {
                // No se usa en esta etapa
            }

            @Override
            public void onAdicionalSelected(String adicionales, double precioAdicionales) {
                // No se usa en esta etapa
            }

            // Resto de los métodos no utilizados en esta etapa
        });
    }

    private void modificarTamañoPastel(int pos) {
        tamañoPastelMenu(new MenuSelectionListener() {
            @Override
            public void onTipoPastelSelected(String tipoPastel, double precioTipo) {
                // No se usa en esta etapa
            }
            
            @Override
            public void onTamañoPastelSelected(String tamañoPastel, double precioTamaño) {
                controlador.modificarTamañoPedido(pos, tamañoPastel, precioTamaño);
                LE.mostrarInformacion("Tamaño de pastel modificado exitosamente.");
                SwingUtilities.invokeLater(() -> setVisible(true));
            }
            
            @Override
            public void onAdicionalSelected(String adicionales, double precioAdicionales) {
                // No se usa en esta etapa
            }

            // Resto de los métodos no utilizados en esta etapa
        });
    }

    private void modificarAdicionalPastel(int pos) {
        adicionalesPastelMenu(new MenuSelectionListener() {
            @Override
            public void onTipoPastelSelected(String tipoPastel, double precioTipo) {
                // No se usa en esta etapa
            }
            
            @Override
            public void onTamañoPastelSelected(String tamañoPastel, double precioTamaño) {
                // No se usa en esta etapa
            }
            
            @Override
            public void onAdicionalSelected(String adicionales, double precioAdicionales) {
                controlador.modificarAdicionalesPedido(pos, adicionales, precioAdicionales);
                LE.mostrarInformacion("Adicional de pastel modificado exitosamente.");
                SwingUtilities.invokeLater(() -> setVisible(true));
            }

            // Resto de los métodos no utilizados en esta etapa
        });
    }
    
    private void busquedaPedido(){
        int numPedido = LE.leerInt("Ingrese el numero de pedido");
        int pos = controlador.busquedaPedido(numPedido);
        
        if (pos > -1) {
            String resumen = controlador.obtenerPedido(numPedido);
            LE.mostrarInformacion(resumen);
            SwingUtilities.invokeLater(() -> setVisible(true));
        } else {
            LE.mostrarError("No existe el pedido");
            SwingUtilities.invokeLater(() -> setVisible(true));
        }
    }
    
    private void eliminarPedido(){
        int numPedido = LE.leerInt("Ingrese el numero de pedido que desea eliminar");
        int pos = controlador.busquedaPedido(numPedido);
        
        if (pos > -1) {
            controlador.eliminarPedido(pos);
            LE.mostrarInformacion("Pedido borrado exitosamente");
            SwingUtilities.invokeLater(() -> setVisible(true));
        } else {
            LE.mostrarError("No existe el pedido");
            SwingUtilities.invokeLater(() -> setVisible(true));
        }
    }
    
    
    private void mostrarDatosPedidosActivos() {
        String[][] datos = controlador.obtenerDatosPedidosActivos();
        mostrarDatos(datos);
        SwingUtilities.invokeLater(() -> setVisible(true));
    }
    
    private void mostrarDatos(String[][] datos) {
        // Fila donde irán la información de las columnas
        String[] columnas = {"Nº Pedido", "Tipo Pastel", "Tamaño Pastel", "Adicional Pastel", "Precio", "DNI", "Nombre", "Teléfono"};

        // Asignación de la tabla
        DefaultTableModel model = new DefaultTableModel(datos, columnas);
        JTable tabla = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabla); // Agregar scroll a la tabla

        // Inicialización del panel donde irá la tabla
        JPanel panelTabla = new JPanel(new BorderLayout());
        panelTabla.add(scrollPane, BorderLayout.CENTER);

        // Inicialización del TextField donde irá la búsqueda
        JTextField campoBusqueda = new JTextField();
        campoBusqueda.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String textoBusqueda = campoBusqueda.getText();
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
                tabla.setRowSorter(sorter);
                sorter.setRowFilter(RowFilter.regexFilter(textoBusqueda));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String textoBusqueda = campoBusqueda.getText();
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
                tabla.setRowSorter(sorter);
                sorter.setRowFilter(RowFilter.regexFilter(textoBusqueda));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String textoBusqueda = campoBusqueda.getText();
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
                // Filtrar filas
                tabla.setRowSorter(sorter);
                sorter.setRowFilter(RowFilter.regexFilter(textoBusqueda));
                // Filtrar según lo que diga el TextField
            }
        });

        // Inicializar el panel que contendrá el textfield
        JPanel panelBusqueda = new JPanel(new BorderLayout());
        panelBusqueda.add(campoBusqueda, BorderLayout.CENTER);

        // Divisor de panel
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelTabla, panelBusqueda);
        splitPane.setDividerLocation(400); // Dividir en 400px

        // Muestra de la tabla
        JOptionPane.showMessageDialog(null, splitPane, "Información de Pedidos", JOptionPane.PLAIN_MESSAGE);
    }
}
