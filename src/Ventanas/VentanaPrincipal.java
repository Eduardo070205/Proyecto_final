package Ventanas;

import Recursos.Elementos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends Elementos implements ActionListener {

    JMenu menuPacientes, menuDoctores, menuTrabajadores;

    JMenuItem altasPacientes, bajasPacientes, cambiosPacientes, consultasPacientes;

    JMenuItem altasDoctores, bajasDoctores, cambiosDoctores, consultasDoctores;

    JMenuItem altasTrabajadores, bajasTrabajadores, cambiosTrabajadores, consultasTrabajadores;

    JLabel logo;

    JInternalFrame internalAltasPa, internalBajasPa, internalCambiosPa, internalConsultasPa;

    JInternalFrame internalAltasDo, internalBajasDo, internalCambiosDo, internalConsultasDo;

    JInternalFrame internalAltasTra, internalBajasTra, internalCambiosTra, internalConsultasTra;

    JInternalFrame internalAjustes;

    JButton btnAjustes, btnSesion, btnRecargar;

    JTextField cajaNumPaciente, cajaNombrePaciente, cajaApePatPaciente, cajaApeMatPAciente, cajaCalleNumeroPaciente, cajaColoniaPaciente, cajaCPPaciente, cajaEstadoPaciente, cajaTelefonoPaciente;

    JComboBox<Short> comboDiaNacPaciente, comboMesNacPaciente, comboAñoNacPaciente, comboDiaIngrPaciente, comboMesIngrPaciente, comboAñoIngrPaciente;

    JComboBox<String> comboEstadoCivilPaciente;

    JRadioButton radioHombre, radioMujer, radioNoBinario;

    JPanel panelAltasPa;

    String[] colores;

    JPanel panelAltasDiseño = new JPanel();

    public  VentanaPrincipal(){

        ButtonGroup bgSexo = new ButtonGroup();

        getContentPane().setLayout(null);

        getContentPane().setBackground(Color.decode("#ffffff"));

        setDefaultCloseOperation(HIDE_ON_CLOSE);

        setTitle("Menú Principal");

        setSize(1200, 900);

        setLocationRelativeTo(null);

        setVisible(true);

        JMenuBar barraMenu = new JMenuBar();

        menuPacientes = new JMenu("Pacientes");

        altasPacientes = new JMenuItem("Agregar");

        altasPacientes.addActionListener(this);



        menuPacientes.add(altasPacientes);

        bajasPacientes = new JMenuItem("Eliminar");

        menuPacientes.add(bajasPacientes);

        cambiosPacientes = new JMenuItem("Modificar");

        menuPacientes.add(cambiosPacientes);

        consultasPacientes = new JMenuItem("Buscar");

        menuPacientes.add(consultasPacientes);

        menuDoctores = new JMenu("Doctores");

        altasDoctores = new JMenuItem("Agregar");

        menuDoctores.add(altasDoctores);

        bajasDoctores = new JMenuItem("Eliminar");

        menuDoctores.add(bajasDoctores);

        cambiosDoctores = new JMenuItem("Modificar");

        menuDoctores.add(cambiosDoctores);

        consultasDoctores = new JMenuItem("Buscar");

        menuDoctores.add(consultasDoctores);

        menuTrabajadores = new JMenu("Trabajadores");

        altasTrabajadores= new JMenuItem("Agregar");

        menuTrabajadores.add(altasTrabajadores);

        bajasTrabajadores = new JMenuItem("Eliminar");

        menuTrabajadores.add(bajasTrabajadores);

        cambiosTrabajadores = new JMenuItem("Modificar");

        menuTrabajadores.add(cambiosTrabajadores);

        consultasTrabajadores = new JMenuItem("Buscar");

        menuTrabajadores.add(consultasTrabajadores);

        barraMenu.add(menuPacientes);

        barraMenu.add(menuDoctores);

        barraMenu.add(menuTrabajadores);

        setJMenuBar(barraMenu);

        logo = new JLabel(asignarImagen("./img/Hospital.png", 180, 150));

        asignarPosicion(logo, 0,30,180,180);

        JToolBar toolbar = new JToolBar("");

        btnRecargar = new JButton(asignarImagen("./img/refresh.png", 20, 20));

        toolbar.add(btnRecargar);

        btnSesion = new JButton(asignarImagen("./img/sesion.png", 20, 20));

        btnSesion.addActionListener(this);

        toolbar.add(btnSesion);

        btnAjustes = new JButton(asignarImagen("./img/settings.png", 20, 20));

        internalAjustes = new JInternalFrame();

        internalAjustes.setSize(200, 200);

        JPanel panelAjustes = new JPanel();

        panelAjustes.setLayout(null);

        ButtonGroup bgTema = new ButtonGroup();

        JLabel txtTema = new JLabel("Tema:");

        agregarAlPanel(txtTema, panelAjustes, 10, 10, 50, 20);

        JRadioButton radioClaro = new JRadioButton("Claro");

        bgTema.add(radioClaro);

        radioClaro.setSelected(true);

        radioClaro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(radioClaro.isSelected()){

                    getContentPane().setBackground(Color.decode("#ffffff"));

                    panelAltasDiseño.setBackground(Color.decode("#a3d1e3"));


                }

            }
        });

        agregarAlPanel(radioClaro, panelAjustes, 10, 40, 70, 20);

        JRadioButton radioOscuro = new JRadioButton("Oscuro");

        bgTema.add(radioOscuro);

        agregarAlPanel(radioOscuro, panelAjustes, 100, 40, 100, 20);

        caracteristicasInternal(internalAjustes);

        internalAjustes.add(panelAjustes);

        internalAjustes.setBounds(100, 30, 200, 200);

        btnAjustes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                internalAjustes.setVisible(true);

            }
        });

        toolbar.add(btnAjustes);

        asignarPosicion(toolbar, 0, 0, 1200, 30);

        JDesktopPane desktopPaneInternals = new JDesktopPane();

        internalAltasPa = new JInternalFrame();

        internalAltasPa.setSize(900, 800);

        panelAltasDiseño.setLayout(null);

        panelAltasDiseño.setBounds(0,0,900, 200);

        panelAltasDiseño.setBackground(Color.decode("#a3d1e3"));

        panelAltasPa = new JPanel();

        panelAltasPa.setBounds(0,200,900, 800);

        panelAltasPa.setLayout(null);

        JLabel txtTitulo = new JLabel("Agregrar un Paciente");

        txtTitulo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));

        agregarAlPanel(txtTitulo, panelAltasDiseño, 50, 40, 200, 40);

        agregarAlPanel(panelAltasDiseño, panelAltasPa, 0,0,900,100);

        JLabel txtNumPaciente = new JLabel("Numero de Paciente:");

        agregarAlPanel(txtNumPaciente, panelAltasPa, 10, 120, 150, 20);

        cajaNumPaciente = new JTextField();

        agregarAlPanel(cajaNumPaciente, panelAltasPa,160, 120, 100, 20);

        JLabel txtNombrePaciente = new JLabel("Nombre:");

        agregarAlPanel(txtNombrePaciente, panelAltasPa, 10, 150, 60, 20);

        cajaNombrePaciente = new JTextField();

        agregarAlPanel(cajaNombrePaciente, panelAltasPa, 70, 150, 150, 20);

        JLabel txtApePatPaciente = new JLabel("Apellido Paterno:");

        agregarAlPanel(txtApePatPaciente, panelAltasPa, 220, 150, 100, 20);

        cajaApePatPaciente = new JTextField();

        agregarAlPanel(cajaApePatPaciente, panelAltasPa, 320, 150, 150, 20);

        JLabel txtApeMatPaciente = new JLabel("Apellido Materno:");

        agregarAlPanel(txtApeMatPaciente, panelAltasPa, 480, 150, 100, 20);

        cajaApeMatPAciente = new JTextField();

        agregarAlPanel(cajaApeMatPAciente, panelAltasPa, 580, 150, 150, 20);

        JLabel txtCallePaciente = new JLabel("Calle y Número del Paciente:");

        agregarAlPanel(txtCallePaciente, panelAltasPa, 10, 180, 170, 20);

        cajaCalleNumeroPaciente = new JTextField();

        agregarAlPanel(cajaCalleNumeroPaciente, panelAltasPa, 180, 180, 150, 20);

        JLabel txtColoniaPaciente = new JLabel("Colonia:");

        agregarAlPanel(txtColoniaPaciente, panelAltasPa, 340, 180, 60, 20);

        cajaColoniaPaciente = new JTextField();

        agregarAlPanel(cajaColoniaPaciente, panelAltasPa, 400, 180, 100, 20);

        JLabel txtxCPPaciente = new JLabel("Código Postal:");

        agregarAlPanel(txtxCPPaciente, panelAltasPa, 510, 180, 100, 20);

        cajaCPPaciente = new JTextField();

        agregarAlPanel(cajaCPPaciente, panelAltasPa, 610, 180, 50, 20);

        JLabel txtEstadoPaciente = new JLabel("Estado:");

        agregarAlPanel(txtEstadoPaciente, panelAltasPa, 670, 180, 60, 20);

        cajaEstadoPaciente = new JTextField();

        agregarAlPanel(cajaEstadoPaciente, panelAltasPa, 730, 180, 100, 20);

        JLabel txtTelefonoPacientes = new JLabel("Telefono:");

        agregarAlPanel(txtTelefonoPacientes, panelAltasPa, 10, 210, 60, 20);

        cajaTelefonoPaciente = new JTextField();

        agregarAlPanel(cajaTelefonoPaciente, panelAltasPa, 70, 210, 100, 20);

        JLabel txtxFechaNacPaciente = new JLabel("Fecha de nacimiento");

        agregarAlPanel(txtxFechaNacPaciente, panelAltasPa, 10, 240, 120, 20);

        JLabel txtDiaNacPaciente = new JLabel("Dia:");

        agregarAlPanel(txtDiaNacPaciente, panelAltasPa, 10, 260, 30, 20);

        comboDiaNacPaciente = new JComboBox<>();

        for(int i = 1; i <= 30; i++){

            comboDiaNacPaciente.addItem((short)i);

        }

        agregarAlPanel(comboDiaNacPaciente, panelAltasPa, 40, 260, 50, 20);

        JLabel txtMesNacPaciente = new JLabel("Mes:");

        agregarAlPanel(txtMesNacPaciente, panelAltasPa, 100, 260, 30, 20);

        comboMesNacPaciente = new JComboBox<>();

        for(int i = 1; i <= 12; i++){

            comboMesNacPaciente.addItem((short)i);

        }

        agregarAlPanel(comboMesNacPaciente, panelAltasPa, 130, 260, 50, 20);

        JLabel txtAñoNacPaciente = new JLabel("Año:");

        agregarAlPanel(txtAñoNacPaciente, panelAltasPa, 190, 260, 30, 20);

        comboAñoNacPaciente = new JComboBox<>();

        for(int i = 2025; i >= 1900; i--){

            comboAñoNacPaciente.addItem((short)i);

        }

        agregarAlPanel(comboAñoNacPaciente, panelAltasPa, 220, 260, 70, 20);

        JLabel txtSexoPaciente = new JLabel("Sexo:");

        agregarAlPanel(txtSexoPaciente, panelAltasPa, 10, 290, 40, 20);

        radioHombre = new JRadioButton("Hombre");

        bgSexo.add(radioHombre);

        agregarAlPanel(radioHombre, panelAltasPa, 50, 290, 80, 20);

        radioMujer = new JRadioButton("Mujer");

        bgSexo.add(radioMujer);

        agregarAlPanel(radioMujer, panelAltasPa, 130, 290, 80, 20);

        radioNoBinario = new JRadioButton("No Binario");

        bgSexo.add(radioNoBinario);

        agregarAlPanel(radioNoBinario, panelAltasPa, 210, 290, 100, 20);

        JLabel txtEstadoCivil = new JLabel("Estado civil:");

        agregarAlPanel(txtEstadoCivil, panelAltasPa, 10, 320, 100, 20);

        comboEstadoCivilPaciente = new JComboBox<>();

        comboEstadoCivilPaciente.addItem("Soltero");

        comboEstadoCivilPaciente.addItem("Casado");

        comboEstadoCivilPaciente.addItem("Viudo");

        comboEstadoCivilPaciente.addItem("Divorciado");

        comboEstadoCivilPaciente.addItem("Separado");

        comboEstadoCivilPaciente.addItem("Concubinato");

        agregarAlPanel(comboEstadoCivilPaciente, panelAltasPa, 110, 320, 100, 20);

        JLabel txtxFechaIngrPaciente = new JLabel("Fecha de ingreso");

        agregarAlPanel(txtxFechaIngrPaciente, panelAltasPa, 10, 350, 120, 20);

        JLabel txtDiaIngrPaciente = new JLabel("Dia:");

        agregarAlPanel(txtDiaIngrPaciente, panelAltasPa, 10, 370, 30, 20);

        comboDiaIngrPaciente = new JComboBox<>();

        for(int i = 1; i <= 30; i++){

            comboDiaIngrPaciente.addItem((short)i);

        }

        agregarAlPanel(comboDiaIngrPaciente, panelAltasPa, 40, 370, 50, 20);

        JLabel txtMesIngrPaciente = new JLabel("Mes:");

        agregarAlPanel(txtMesIngrPaciente, panelAltasPa, 100, 370, 30, 20);

        comboMesIngrPaciente = new JComboBox<>();

        for(int i = 1; i <= 12; i++){

            comboMesIngrPaciente.addItem((short)i);

        }

        agregarAlPanel(comboMesIngrPaciente, panelAltasPa, 130, 370, 50, 20);

        JLabel txtAñoIngrPaciente = new JLabel("Año:");

        agregarAlPanel(txtAñoIngrPaciente, panelAltasPa, 190, 370, 30, 20);

        comboAñoIngrPaciente = new JComboBox<>();

        for(int i = 2025; i >= 2010; i--){

            comboAñoIngrPaciente.addItem((short)i);

        }

        agregarAlPanel(comboAñoIngrPaciente, panelAltasPa, 220, 370, 70, 20);











        //internalAltasPa.add(panelAltasDiseño);



        internalAltasPa.add(panelAltasPa);

        internalAltasPa.setTitle("Altas");

        internalAjustes.setTitle("Ajustes");

        caracteristicasInternal(internalAltasPa);

        desktopPaneInternals.add(internalAltasPa);

        desktopPaneInternals.add(internalAjustes);

        asignarPosicion(desktopPaneInternals, 200, 30, 1000, 850);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object componente = e.getSource();

        if(componente == altasPacientes){

            internalAltasPa.setVisible(true);

        }

        if(componente == btnSesion){

            int respuesta = JOptionPane.showConfirmDialog(this, "¿Estás seguro de cerrar la sesión?");

            if(respuesta == JOptionPane.YES_OPTION){

                SwingUtilities.invokeLater(new Runnable() { //Siemnpre agregar ese codigo

                    @Override
                    public void run() {

                        new VentanaLogin();

                    }
                });

                this.dispose();

            }

        }

    }
}
