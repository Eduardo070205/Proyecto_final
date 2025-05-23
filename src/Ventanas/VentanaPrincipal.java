package Ventanas;

import Recursos.Elementos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class VentanaPrincipal extends Elementos implements ActionListener {

    JTable tabla, tablaB, tablaM;

    byte numDias = 1;

    LocalDateTime fechaHoy = LocalDateTime.now();

    JMenu menuPacientes, menuDoctores, menuTrabajadores;

    JMenuItem altasPacientes, bajasPacientes, cambiosPacientes, consultasPacientes;

    JMenuItem altasDoctores, bajasDoctores, cambiosDoctores, consultasDoctores;

    JMenuItem altasTrabajadores, bajasTrabajadores, cambiosTrabajadores, consultasTrabajadores;

    JLabel logo;

    JInternalFrame internalAltasPa, internalBajasPa, internalCambiosPa, internalConsultasPa;

    JInternalFrame internalAltasDo, internalBajasDo, internalCambiosDo, internalConsultasDo;

    JInternalFrame internalAltasTra, internalBajasTra, internalCambiosTra, internalConsultasTra;

    JInternalFrame internalAjustes;

    //================================ ALTAS =====================================================

    JButton btnAjustes, btnSesion, btnRecargar, btnEnviar, btnRestaurar, btnCancelar;

    JTextField cajaNumPaciente, cajaNombrePaciente, cajaApePatPaciente, cajaApeMatPAciente, cajaCalleNumeroPaciente, cajaColoniaPaciente, cajaCPPaciente, cajaEstadoPaciente, cajaTelefonoPaciente;

    JComboBox<Short> comboDiaNacPaciente, comboMesNacPaciente, comboAñoNacPaciente, comboDiaIngrPaciente, comboMesIngrPaciente, comboAñoIngrPaciente;

    JComboBox<String> comboEstadoCivilPaciente;

    JRadioButton radioHombre, radioMujer, radioNoBinario;

    //======================================= BAJAS ==================================================

    JButton btnBorrarB, btnRestaurarB, btnCancelarB, btnBuscarB;

    JTextField cajaNumPacienteB, cajaNombrePacienteB, cajaApePatPacienteB, cajaApeMatPAcienteB, cajaCalleNumeroPacienteB, cajaColoniaPacienteB, cajaCPPacienteB, cajaEstadoPacienteB, cajaTelefonoPacienteB;

    JComboBox<Short> comboDiaNacPacienteB, comboMesNacPacienteB, comboAñoNacPacienteB, comboDiaIngrPacienteB, comboMesIngrPacienteB, comboAñoIngrPacienteB;

    JComboBox<String> comboEstadoCivilPacienteB;

    JRadioButton radioHombreB, radioMujerB, radioNoBinarioB;

    //================================ MODIFICACIONES =============================================

    JButton btnGuardarM, btnRestaurarM, btnCancelarM, btnBuscarM;

    JTextField cajaNumPacienteM, cajaNombrePacienteM, cajaApePatPacienteM, cajaApeMatPAcienteM, cajaCalleNumeroPacienteM, cajaColoniaPacienteM, cajaCPPacienteM, cajaEstadoPacienteM, cajaTelefonoPacienteM;

    JComboBox<Short> comboDiaNacPacienteM, comboMesNacPacienteM, comboAñoNacPacienteM, comboDiaIngrPacienteM, comboMesIngrPacienteM, comboAñoIngrPacienteM;

    JComboBox<String> comboEstadoCivilPacienteM;

    JRadioButton radioHombreM, radioMujerM, radioNoBinarioM;


    //========================================= CONSULTAS ==========================================

    JButton btnBuscarC, btnRestaurarC, btnCancelarC;

    JTextField cajaNumPacienteC, cajaNombrePacienteC, cajaApePatPacienteC, cajaApeMatPAcienteC, cajaCalleNumeroPacienteC, cajaColoniaPacienteC, cajaCPPacienteC, cajaEstadoPacienteC, cajaTelefonoPacienteC;

    JComboBox<Short> comboDiaNacPacienteC, comboMesNacPacienteC, comboAñoNacPacienteC, comboDiaIngrPacienteC, comboMesIngrPacienteC, comboAñoIngrPacienteC;

    JComboBox<String> comboEstadoCivilPacienteC;

    JRadioButton radioHombreC, radioMujerC, radioNoBinarioC;

    //=============================================================================================

    JPanel panelAltasPa, panelBajasPa, panelModificacionesPa, panelConsultasPa;

    ButtonGroup bgSexo = new ButtonGroup();

    ButtonGroup bgSexoB = new ButtonGroup();

    ButtonGroup bgSexoM = new ButtonGroup();

    ButtonGroup bgSexoC = new ButtonGroup();

    JPanel panelAltasDiseño = new JPanel();

    JPanel panelBajasDiseño = new JPanel();

    JPanel panelModificacionesDiseño = new JPanel();

    JPanel panelConsultasDiseño = new JPanel();

    public  VentanaPrincipal(){

        JDesktopPane desktopPaneInternals = new JDesktopPane();

        getContentPane().setLayout(null);

        getContentPane().setBackground(Color.decode("#737895"));

        setDefaultCloseOperation(HIDE_ON_CLOSE);

        setTitle("Menú Principal");

        setSize(1200, 900);

        setLocationRelativeTo(null);

        setVisible(true);

        desktopPaneInternals.setBackground(Color.decode("#e7eaf3"));

        JMenuBar barraMenu = new JMenuBar();

        menuPacientes = new JMenu("Pacientes");

        altasPacientes = new JMenuItem("Agregar");

        altasPacientes.addActionListener(this);



        menuPacientes.add(altasPacientes);

        bajasPacientes = new JMenuItem("Eliminar");

        bajasPacientes.addActionListener(this);

        menuPacientes.add(bajasPacientes);

        cambiosPacientes = new JMenuItem("Modificar");

        cambiosPacientes.addActionListener(this);

        menuPacientes.add(cambiosPacientes);

        consultasPacientes = new JMenuItem("Buscar");

        consultasPacientes.addActionListener(this);

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

                    getContentPane().setBackground(Color.decode("#737895"));

                    panelAltasDiseño.setBackground(Color.decode("#a3d1e3"));

                    panelAltasPa.setBackground(Color.decode("#feffe9"));

                    panelBajasDiseño.setBackground(Color.decode("#a3d1e3"));

                    panelBajasPa.setBackground(Color.decode("#feffe9"));

                    panelModificacionesDiseño.setBackground(Color.decode("#a3d1e3"));

                    panelModificacionesPa.setBackground(Color.decode("#feffe9"));

                    panelConsultasDiseño.setBackground(Color.decode("#a3d1e3"));

                    panelConsultasPa.setBackground(Color.decode("#feffe9"));

                    desktopPaneInternals.setBackground(Color.decode("#e7eaf3"));

                }

            }
        });

        agregarAlPanel(radioClaro, panelAjustes, 10, 40, 70, 20);

        JRadioButton radioOscuro = new JRadioButton("Oscuro");

        bgTema.add(radioOscuro);

        radioOscuro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(radioOscuro.isSelected()){

                    getContentPane().setBackground(Color.decode("#4f536b"));

                    toolbar.setBackground(Color.decode("#4f536b"));

                    panelAltasDiseño.setBackground(Color.decode("#4f6199"));

                    panelAltasPa.setBackground(Color.decode("#959595"));

                    panelBajasDiseño.setBackground(Color.decode("#4f6199"));

                    panelBajasPa.setBackground(Color.decode("#959595"));

                    panelModificacionesDiseño.setBackground(Color.decode("#4f6199"));

                    panelModificacionesPa.setBackground(Color.decode("#959595"));

                    panelConsultasDiseño.setBackground(Color.decode("#4f6199"));

                    panelConsultasPa.setBackground(Color.decode("#959595"));

                    desktopPaneInternals.setBackground(Color.decode("#737895"));


                }

            }
        });

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


        internalAjustes.setTitle("Ajustes");

        internalAltasPa = new JInternalFrame();

        internalAltasPa.setSize(900, 800);

        //============================================ ALTAS ===========================================

        panelAltasDiseño.setLayout(null);

        panelAltasDiseño.setBounds(0,0,900, 200);

        panelAltasDiseño.setBackground(Color.decode("#a3d1e3"));

        panelAltasPa = new JPanel();

        panelAltasPa.setBounds(0,200,900, 800);

        panelAltasPa.setBackground(Color.decode("#feffe9"));

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

        JLabel txtAñoNacPaciente = new JLabel("Año:");

        agregarAlPanel(txtAñoNacPaciente, panelAltasPa, 10, 260, 30, 20);

        comboAñoNacPaciente = new JComboBox<>();

        for(int i = 2025; i >= 1900; i--){

            comboAñoNacPaciente.addItem((short)i);

        }

        agregarAlPanel(comboAñoNacPaciente, panelAltasPa, 40, 260, 70, 20);

        comboAñoNacPaciente.setSelectedItem((short)fechaHoy.getYear());

        JLabel txtMesNacPaciente = new JLabel("Mes:");

        agregarAlPanel(txtMesNacPaciente, panelAltasPa, 120, 260, 30, 20);

        comboMesNacPaciente = new JComboBox<>();


        for(int i = 1; i <= 12; i++){

            comboMesNacPaciente.addItem((short)i);

        }

        agregarAlPanel(comboMesNacPaciente, panelAltasPa, 150, 260, 50, 20);

        comboMesNacPaciente.setSelectedItem((short)fechaHoy.getMonthValue());

        comboMesNacPaciente.addActionListener(this);

        short mesSeleccionado = Short.parseShort(comboMesNacPaciente.getSelectedItem().toString());

        if(mesSeleccionado == 1 || mesSeleccionado == 3 || mesSeleccionado == 5 || mesSeleccionado == 7 || mesSeleccionado == 8 || mesSeleccionado == 10 || mesSeleccionado == 12){

            numDias = 31;

        } else if (mesSeleccionado == 2) {

            short año = Short.parseShort(comboAñoNacPaciente.getSelectedItem().toString());

            if ((año % 4 == 0 && año % 100 != 0) || (año % 100 == 0 && año % 400 == 0)){

                numDias = 29;

            }else{

                numDias = 28;

            }

        }else {

            numDias = 30;

        }

        JLabel txtDiaNacPaciente = new JLabel("Dia:");

        agregarAlPanel(txtDiaNacPaciente, panelAltasPa, 210, 260, 30, 20);


        comboDiaNacPaciente = new JComboBox<>();

        //comboDiaNacPaciente.setEnabled(false);


        for(int i = 1; i <= numDias; i++){

            comboDiaNacPaciente.addItem((short)i);

        }

        agregarAlPanel(comboDiaNacPaciente, panelAltasPa, 240, 260, 50, 20);

        comboDiaNacPaciente.setSelectedItem((short)fechaHoy.getDayOfMonth());




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

        JLabel txtAñoIngrPaciente = new JLabel("Año:");

        agregarAlPanel(txtAñoIngrPaciente, panelAltasPa, 10, 370, 30, 20);

        comboAñoIngrPaciente = new JComboBox<>();

        for(int i = 2025; i >= 1900; i--){

            comboAñoIngrPaciente.addItem((short)i);

        }

        agregarAlPanel(comboAñoIngrPaciente, panelAltasPa, 40, 370, 70, 20);

        comboAñoIngrPaciente.setSelectedItem((short)fechaHoy.getYear());

        JLabel txtMesIngrPaciente = new JLabel("Mes:");

        agregarAlPanel(txtMesIngrPaciente, panelAltasPa, 120, 370, 30, 20);

        comboMesIngrPaciente = new JComboBox<>();


        for(int i = 1; i <= 12; i++){

            comboMesIngrPaciente.addItem((short)i);

        }

        agregarAlPanel(comboMesIngrPaciente, panelAltasPa, 150, 370, 50, 20);

        comboMesIngrPaciente.setSelectedItem((short)fechaHoy.getMonthValue());

        comboMesIngrPaciente.addActionListener(this);

        mesSeleccionado = Short.parseShort(comboMesIngrPaciente.getSelectedItem().toString());

        if(mesSeleccionado == 1 || mesSeleccionado == 3 || mesSeleccionado == 5 || mesSeleccionado == 7 || mesSeleccionado == 8 || mesSeleccionado == 10 || mesSeleccionado == 12){

            numDias = 31;

        } else if (mesSeleccionado == 2) {

            short año = Short.parseShort(comboAñoIngrPaciente.getSelectedItem().toString());

            if ((año % 4 == 0 && año % 100 != 0) || (año % 100 == 0 && año % 400 == 0)){

                numDias = 29;

            }else{

                numDias = 28;

            }

        }else {

            numDias = 30;

        }

        JLabel txtDiaIngrPaciente = new JLabel("Dia:");

        agregarAlPanel(txtDiaIngrPaciente, panelAltasPa, 210, 370, 30, 20);


        comboDiaIngrPaciente = new JComboBox<>();

        //comboDiaNacPaciente.setEnabled(false);


        for(int i = 1; i <= numDias; i++){

            comboDiaIngrPaciente.addItem((short)i);

        }

        agregarAlPanel(comboDiaIngrPaciente, panelAltasPa, 240, 370, 50, 20);

        comboDiaIngrPaciente.setSelectedItem((short)fechaHoy.getDayOfMonth());

        btnEnviar = new JButton("Enviar");

        agregarAlPanel(btnEnviar, panelAltasPa, 200, 450, 100, 30);

        btnRestaurar = new JButton("Restaurar");

        agregarAlPanel(btnRestaurar, panelAltasPa, 400, 450, 100, 30);

        btnCancelar = new JButton("Cancelar");

        agregarAlPanel(btnCancelar, panelAltasPa, 600, 450, 100, 30);

        tabla = new JTable();

        JScrollPane scrollPane = new JScrollPane(tabla);

        scrollPane.setBackground(Color.decode("#d2e2f1"));

        agregarAlPanel(scrollPane, panelAltasPa, 10, 500, 850, 200);

        internalAltasPa.add(panelAltasPa);

        internalAltasPa.setTitle("Altas");

        caracteristicasInternal(internalAltasPa);

        //================================================= BAJAS ======================================


        panelBajasDiseño.setLayout(null);

        panelBajasDiseño.setBounds(0,0,900, 200);

        panelBajasDiseño.setBackground(Color.decode("#a3d1e3"));

        panelBajasPa = new JPanel();

        panelBajasPa.setBounds(0,200,900, 800);

        panelBajasPa.setBackground(Color.decode("#feffe9"));

        panelBajasPa.setLayout(null);

        JLabel txtTituloB = new JLabel("Eliminar un Paciente");

        txtTituloB.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));

        agregarAlPanel(txtTituloB, panelBajasDiseño, 50, 40, 200, 40);

        agregarAlPanel(panelBajasDiseño, panelBajasPa, 0,0,900,100);

        JLabel txtNumPacienteB = new JLabel("Numero de Paciente:");

        agregarAlPanel(txtNumPacienteB, panelBajasPa, 10, 120, 150, 20);

        cajaNumPacienteB = new JTextField();

        agregarAlPanel(cajaNumPacienteB, panelBajasPa,160, 120, 100, 20);

        JLabel txtNombrePacienteB = new JLabel("Nombre:");

        agregarAlPanel(txtNombrePacienteB, panelBajasPa, 10, 150, 60, 20);

        cajaNombrePacienteB = new JTextField();

        cajaNombrePacienteB.setEditable(false);

        agregarAlPanel(cajaNombrePacienteB, panelBajasPa, 70, 150, 150, 20);

        JLabel txtApePatPacienteB = new JLabel("Apellido Paterno:");

        agregarAlPanel(txtApePatPacienteB, panelBajasPa, 220, 150, 100, 20);

        cajaApePatPacienteB = new JTextField();

        cajaApePatPacienteB.setEditable(false);

        agregarAlPanel(cajaApePatPacienteB, panelBajasPa, 320, 150, 150, 20);

        JLabel txtApeMatPacienteB = new JLabel("Apellido Materno:");

        agregarAlPanel(txtApeMatPacienteB, panelBajasPa, 480, 150, 100, 20);

        cajaApeMatPAcienteB = new JTextField();

        cajaApeMatPAcienteB.setEditable(false);

        agregarAlPanel(cajaApeMatPAcienteB, panelBajasPa, 580, 150, 150, 20);

        JLabel txtCallePacienteB = new JLabel("Calle y Número del Paciente:");

        agregarAlPanel(txtCallePacienteB, panelBajasPa, 10, 180, 170, 20);

        cajaCalleNumeroPacienteB = new JTextField();

        cajaCalleNumeroPacienteB.setEditable(false);

        agregarAlPanel(cajaCalleNumeroPacienteB, panelBajasPa, 180, 180, 150, 20);

        JLabel txtColoniaPacienteB = new JLabel("Colonia:");

        agregarAlPanel(txtColoniaPacienteB, panelBajasPa, 340, 180, 60, 20);

        cajaColoniaPacienteB = new JTextField();

        cajaColoniaPacienteB.setEditable(false);

        agregarAlPanel(cajaColoniaPacienteB, panelBajasPa, 400, 180, 100, 20);

        JLabel txtxCPPacienteB = new JLabel("Código Postal:");

        agregarAlPanel(txtxCPPacienteB, panelBajasPa, 510, 180, 100, 20);

        cajaCPPacienteB = new JTextField();

        cajaCPPacienteB.setEditable(false);

        agregarAlPanel(cajaCPPacienteB, panelBajasPa, 610, 180, 50, 20);

        JLabel txtEstadoPacienteB = new JLabel("Estado:");

        agregarAlPanel(txtEstadoPacienteB, panelBajasPa, 670, 180, 60, 20);

        cajaEstadoPacienteB = new JTextField();

        cajaEstadoPacienteB.setEditable(false);

        agregarAlPanel(cajaEstadoPacienteB, panelBajasPa, 730, 180, 100, 20);

        JLabel txtTelefonoPacientesB = new JLabel("Telefono:");

        agregarAlPanel(txtTelefonoPacientesB, panelBajasPa, 10, 210, 60, 20);

        cajaTelefonoPacienteB = new JTextField();

        cajaTelefonoPacienteB.setEditable(false);

        agregarAlPanel(cajaTelefonoPacienteB, panelBajasPa, 70, 210, 100, 20);

        JLabel txtxFechaNacPacienteB = new JLabel("Fecha de nacimiento");

        agregarAlPanel(txtxFechaNacPacienteB, panelBajasPa, 10, 240, 120, 20);

        JLabel txtDiaNacPacienteB = new JLabel("Dia:");

        agregarAlPanel(txtDiaNacPacienteB, panelBajasPa, 10, 260, 30, 20);

        comboDiaNacPacienteB = new JComboBox<>();

        comboDiaNacPacienteB.setEnabled(false);

        for(int i = 1; i <= 30; i++){

            comboDiaNacPacienteB.addItem((short)i);

        }

        agregarAlPanel(comboDiaNacPacienteB, panelBajasPa, 40, 260, 50, 20);

        JLabel txtMesNacPacienteB = new JLabel("Mes:");

        agregarAlPanel(txtMesNacPacienteB, panelBajasPa, 100, 260, 30, 20);

        comboMesNacPacienteB = new JComboBox<>();

        comboMesNacPacienteB.setEnabled(false);

        for(int i = 1; i <= 12; i++){

            comboMesNacPacienteB.addItem((short)i);

        }

        agregarAlPanel(comboMesNacPacienteB, panelBajasPa, 130, 260, 50, 20);

        JLabel txtAñoNacPacienteB = new JLabel("Año:");

        agregarAlPanel(txtAñoNacPacienteB, panelBajasPa, 190, 260, 30, 20);

        comboAñoNacPacienteB = new JComboBox<>();

        comboAñoNacPacienteB.setEnabled(false);

        for(int i = 2025; i >= 1900; i--){

            comboAñoNacPacienteB.addItem((short)i);

        }

        agregarAlPanel(comboAñoNacPacienteB, panelBajasPa, 220, 260, 70, 20);

        JLabel txtSexoPacienteB = new JLabel("Sexo:");

        agregarAlPanel(txtSexoPacienteB, panelBajasPa, 10, 290, 40, 20);

        radioHombreB = new JRadioButton("Hombre");

        radioHombreB.setEnabled(false);

        bgSexoB.add(radioHombreB);

        agregarAlPanel(radioHombreB, panelBajasPa, 50, 290, 80, 20);

        radioMujerB = new JRadioButton("Mujer");

        radioMujerB.setEnabled(false);

        bgSexoB.add(radioMujerB);

        agregarAlPanel(radioMujerB, panelBajasPa, 130, 290, 80, 20);

        radioNoBinarioB = new JRadioButton("No Binario");

        radioNoBinarioB.setEnabled(false);

        bgSexoB.add(radioNoBinarioB);

        agregarAlPanel(radioNoBinarioB, panelBajasPa, 210, 290, 100, 20);

        JLabel txtEstadoCivilB = new JLabel("Estado civil:");

        agregarAlPanel(txtEstadoCivilB, panelBajasPa, 10, 320, 100, 20);

        comboEstadoCivilPacienteB = new JComboBox<>();

        comboEstadoCivilPacienteB.setEnabled(false);

        comboEstadoCivilPacienteB.addItem("Soltero");

        comboEstadoCivilPacienteB.addItem("Casado");

        comboEstadoCivilPacienteB.addItem("Viudo");

        comboEstadoCivilPacienteB.addItem("Divorciado");

        comboEstadoCivilPacienteB.addItem("Separado");

        comboEstadoCivilPacienteB.addItem("Concubinato");

        agregarAlPanel(comboEstadoCivilPacienteB, panelBajasPa, 110, 320, 100, 20);

        JLabel txtxFechaIngrPacienteB = new JLabel("Fecha de ingreso");

        agregarAlPanel(txtxFechaIngrPacienteB, panelBajasPa, 10, 350, 120, 20);

        JLabel txtDiaIngrPacienteB = new JLabel("Dia:");

        agregarAlPanel(txtDiaIngrPacienteB, panelBajasPa, 10, 370, 30, 20);

        comboDiaIngrPacienteB = new JComboBox<>();

        comboDiaIngrPacienteB.setEnabled(false);

        for(int i = 1; i <= 30; i++){

            comboDiaIngrPacienteB.addItem((short)i);

        }

        agregarAlPanel(comboDiaIngrPacienteB, panelBajasPa, 40, 370, 50, 20);

        JLabel txtMesIngrPacienteB = new JLabel("Mes:");

        agregarAlPanel(txtMesIngrPacienteB, panelBajasPa, 100, 370, 30, 20);

        comboMesIngrPacienteB = new JComboBox<>();

        comboMesIngrPacienteB.setEnabled(false);

        for(int i = 1; i <= 12; i++){

            comboMesIngrPacienteB.addItem((short)i);

        }

        agregarAlPanel(comboMesIngrPacienteB, panelBajasPa, 130, 370, 50, 20);

        JLabel txtAñoIngrPacienteB = new JLabel("Año:");

        agregarAlPanel(txtAñoIngrPacienteB, panelBajasPa, 190, 370, 30, 20);

        comboAñoIngrPacienteB = new JComboBox<>();

        comboAñoIngrPacienteB.setEnabled(false);

        for(int i = 2025; i >= 2010; i--){

            comboAñoIngrPacienteB.addItem((short)i);

        }

        agregarAlPanel(comboAñoIngrPacienteB, panelBajasPa, 220, 370, 70, 20);

        btnBuscarB = new JButton("Buscar");

        agregarAlPanel(btnBuscarB, panelBajasPa, 100, 450, 100, 30);

        btnBorrarB = new JButton("Borrar");

        agregarAlPanel(btnBorrarB, panelBajasPa, 250, 450, 100, 30);

        btnRestaurarB = new JButton("Restaurar");

        agregarAlPanel(btnRestaurarB, panelBajasPa, 400, 450, 100, 30);

        btnCancelarB = new JButton("Cancelar");

        agregarAlPanel(btnCancelarB, panelBajasPa, 550, 450, 100, 30);

        tablaB = new JTable();

        JScrollPane scrollPaneB = new JScrollPane(tabla);

        scrollPaneB.setBackground(Color.decode("#d2e2f1"));

        agregarAlPanel(scrollPaneB, panelBajasPa, 10, 500, 850, 200);

        internalBajasPa = new JInternalFrame();

        internalBajasPa.setSize(900, 800);

        internalBajasPa.add(panelBajasPa);

        internalBajasPa.setTitle("Bajas");

        caracteristicasInternal(internalBajasPa);


        //============================================== MODIFICACIONES ================================

        panelModificacionesDiseño.setLayout(null);

        panelModificacionesDiseño.setBounds(0,0,900, 200);

        panelModificacionesDiseño.setBackground(Color.decode("#a3d1e3"));

        panelModificacionesPa = new JPanel();

        panelModificacionesPa.setBounds(0,200,900, 800);

        panelModificacionesPa.setBackground(Color.decode("#feffe9"));

        panelModificacionesPa.setLayout(null);

        JLabel txtTituloM = new JLabel("Modificar un Paciente");

        txtTituloM.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));

        agregarAlPanel(txtTituloM, panelModificacionesDiseño, 50, 40, 300, 40);

        agregarAlPanel(panelModificacionesDiseño, panelModificacionesPa, 0,0,900,100);

        JLabel txtNumPacienteM = new JLabel("Numero de Paciente:");

        agregarAlPanel(txtNumPacienteM, panelModificacionesPa, 10, 120, 150, 20);

        cajaNumPacienteM = new JTextField();

        agregarAlPanel(cajaNumPacienteM, panelModificacionesPa,160, 120, 100, 20);

        JLabel txtNombrePacienteM = new JLabel("Nombre:");

        agregarAlPanel(txtNombrePacienteM, panelModificacionesPa, 10, 150, 60, 20);

        cajaNombrePacienteM = new JTextField();

        agregarAlPanel(cajaNombrePacienteM, panelModificacionesPa, 70, 150, 150, 20);

        JLabel txtApePatPacienteM = new JLabel("Apellido Paterno:");

        agregarAlPanel(txtApePatPacienteM, panelModificacionesPa, 220, 150, 100, 20);

        cajaApePatPacienteM = new JTextField();

        agregarAlPanel(cajaApePatPacienteM, panelModificacionesPa, 320, 150, 150, 20);

        JLabel txtApeMatPacienteM = new JLabel("Apellido Materno:");

        agregarAlPanel(txtApeMatPacienteM, panelModificacionesPa, 480, 150, 100, 20);

        cajaApeMatPAcienteM = new JTextField();

        agregarAlPanel(cajaApeMatPAcienteM, panelModificacionesPa, 580, 150, 150, 20);

        JLabel txtCallePacienteM = new JLabel("Calle y Número del Paciente:");

        agregarAlPanel(txtCallePacienteM, panelModificacionesPa, 10, 180, 170, 20);

        cajaCalleNumeroPacienteM = new JTextField();

        agregarAlPanel(cajaCalleNumeroPacienteM, panelModificacionesPa, 180, 180, 150, 20);

        JLabel txtColoniaPacienteM = new JLabel("Colonia:");

        agregarAlPanel(txtColoniaPacienteM, panelModificacionesPa, 340, 180, 60, 20);

        cajaColoniaPacienteM = new JTextField();

        agregarAlPanel(cajaColoniaPacienteM, panelModificacionesPa, 400, 180, 100, 20);

        JLabel txtxCPPacienteM = new JLabel("Código Postal:");

        agregarAlPanel(txtxCPPacienteM, panelModificacionesPa, 510, 180, 100, 20);

        cajaCPPacienteM = new JTextField();

        agregarAlPanel(cajaCPPacienteM, panelModificacionesPa, 610, 180, 50, 20);

        JLabel txtEstadoPacienteM = new JLabel("Estado:");

        agregarAlPanel(txtEstadoPacienteM, panelModificacionesPa, 670, 180, 60, 20);

        cajaEstadoPacienteM = new JTextField();

        agregarAlPanel(cajaEstadoPacienteM, panelModificacionesPa, 730, 180, 100, 20);

        JLabel txtTelefonoPacientesM = new JLabel("Telefono:");

        agregarAlPanel(txtTelefonoPacientesM, panelModificacionesPa, 10, 210, 60, 20);

        cajaTelefonoPacienteM = new JTextField();

        agregarAlPanel(cajaTelefonoPacienteM, panelModificacionesPa, 70, 210, 100, 20);

        JLabel txtxFechaNacPacienteM = new JLabel("Fecha de nacimiento");

        agregarAlPanel(txtxFechaNacPacienteM, panelModificacionesPa, 10, 240, 120, 20);

        JLabel txtDiaNacPacienteM = new JLabel("Dia:");

        agregarAlPanel(txtDiaNacPacienteM, panelModificacionesPa, 10, 260, 30, 20);

        comboDiaNacPacienteM = new JComboBox<>();

        for(int i = 1; i <= 30; i++){

            comboDiaNacPacienteM.addItem((short)i);

        }

        agregarAlPanel(comboDiaNacPacienteM, panelModificacionesPa, 40, 260, 50, 20);

        JLabel txtMesNacPacienteM = new JLabel("Mes:");

        agregarAlPanel(txtMesNacPacienteM, panelModificacionesPa, 100, 260, 30, 20);

        comboMesNacPacienteM = new JComboBox<>();



        for(int i = 1; i <= 12; i++){

            comboMesNacPacienteM.addItem((short)i);

        }

        agregarAlPanel(comboMesNacPacienteM, panelModificacionesPa, 130, 260, 50, 20);

        JLabel txtAñoNacPacienteM = new JLabel("Año:");

        agregarAlPanel(txtAñoNacPacienteM, panelModificacionesPa, 190, 260, 30, 20);

        comboAñoNacPacienteM = new JComboBox<>();

        for(int i = 2025; i >= 1900; i--){

            comboAñoNacPacienteM.addItem((short)i);

        }

        agregarAlPanel(comboAñoNacPacienteM, panelModificacionesPa, 220, 260, 70, 20);

        JLabel txtSexoPacienteM = new JLabel("Sexo:");

        agregarAlPanel(txtSexoPacienteM, panelModificacionesPa, 10, 290, 40, 20);

        radioHombreM = new JRadioButton("Hombre");

        bgSexoM.add(radioHombreM);

        agregarAlPanel(radioHombreM, panelModificacionesPa, 50, 290, 80, 20);

        radioMujerM = new JRadioButton("Mujer");

        bgSexoM.add(radioMujerM);

        agregarAlPanel(radioMujerM, panelModificacionesPa, 130, 290, 80, 20);

        radioNoBinarioM = new JRadioButton("No Binario");

        bgSexoM.add(radioNoBinarioM);

        agregarAlPanel(radioNoBinarioM, panelModificacionesPa, 210, 290, 100, 20);

        JLabel txtEstadoCivilM = new JLabel("Estado civil:");

        agregarAlPanel(txtEstadoCivilM, panelModificacionesPa, 10, 320, 100, 20);

        comboEstadoCivilPacienteM = new JComboBox<>();

        comboEstadoCivilPacienteM.addItem("Soltero");

        comboEstadoCivilPacienteM.addItem("Casado");

        comboEstadoCivilPacienteM.addItem("Viudo");

        comboEstadoCivilPacienteM.addItem("Divorciado");

        comboEstadoCivilPacienteM.addItem("Separado");

        comboEstadoCivilPacienteM.addItem("Concubinato");

        agregarAlPanel(comboEstadoCivilPacienteM, panelModificacionesPa, 110, 320, 100, 20);

        JLabel txtxFechaIngrPacienteM = new JLabel("Fecha de ingreso");

        agregarAlPanel(txtxFechaIngrPacienteM, panelModificacionesPa, 10, 350, 120, 20);

        JLabel txtDiaIngrPacienteM = new JLabel("Dia:");

        agregarAlPanel(txtDiaIngrPacienteM, panelModificacionesPa, 10, 370, 30, 20);

        comboDiaIngrPacienteM = new JComboBox<>();

        for(int i = 1; i <= 30; i++){

            comboDiaIngrPacienteM.addItem((short)i);

        }

        agregarAlPanel(comboDiaIngrPacienteM, panelModificacionesPa, 40, 370, 50, 20);

        JLabel txtMesIngrPacienteM = new JLabel("Mes:");

        agregarAlPanel(txtMesIngrPacienteM, panelModificacionesPa, 100, 370, 30, 20);

        comboMesIngrPacienteM = new JComboBox<>();

        for(int i = 1; i <= 12; i++){

            comboMesIngrPacienteM.addItem((short)i);

        }

        agregarAlPanel(comboMesIngrPacienteM, panelModificacionesPa, 130, 370, 50, 20);

        JLabel txtAñoIngrPacienteM = new JLabel("Año:");

        agregarAlPanel(txtAñoIngrPacienteM, panelModificacionesPa, 190, 370, 30, 20);

        comboAñoIngrPacienteM = new JComboBox<>();

        for(int i = 2025; i >= 2010; i--){

            comboAñoIngrPacienteM.addItem((short)i);

        }

        agregarAlPanel(comboAñoIngrPacienteM, panelModificacionesPa, 220, 370, 70, 20);

        btnBuscarM = new JButton("Buscar");

        agregarAlPanel(btnBuscarM, panelModificacionesPa, 100, 450, 100, 30);

        btnGuardarM = new JButton("Guardar");

        agregarAlPanel(btnGuardarM, panelModificacionesPa, 250, 450, 100, 30);

        btnRestaurarM = new JButton("Restaurar");

        agregarAlPanel(btnRestaurarM, panelModificacionesPa, 400, 450, 100, 30);

        btnCancelarM = new JButton("Cancelar");

        agregarAlPanel(btnCancelarM, panelModificacionesPa, 550, 450, 100, 30);

        tablaM = new JTable();

        JScrollPane scrollPaneM = new JScrollPane(tabla);

        scrollPaneM.setBackground(Color.decode("#d2e2f1"));

        agregarAlPanel(scrollPaneM, panelModificacionesPa, 10, 500, 850, 200);

        internalCambiosPa = new JInternalFrame();

        internalCambiosPa.setSize(900, 800);

        internalCambiosPa.add(panelModificacionesPa);

        internalCambiosPa.setTitle("Modificaciones");

        caracteristicasInternal(internalCambiosPa);


        //======================================================== CONSULTAS =============================


        panelConsultasDiseño.setLayout(null);

        panelConsultasDiseño.setBounds(0,0,900, 200);

        panelConsultasDiseño.setBackground(Color.decode("#a3d1e3"));

        panelConsultasPa = new JPanel();

        panelConsultasPa.setBounds(0,200,900, 800);

        panelConsultasPa.setBackground(Color.decode("#feffe9"));

        panelConsultasPa.setLayout(null);

        JLabel txtTituloC = new JLabel("Buscar un Paciente");

        txtTituloC.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));

        agregarAlPanel(txtTituloC, panelConsultasDiseño, 50, 40, 200, 40);

        agregarAlPanel(panelConsultasDiseño, panelConsultasPa, 0,0,900,100);

        JLabel txtNumPacienteC = new JLabel("Numero de Paciente:");

        agregarAlPanel(txtNumPacienteC, panelConsultasPa, 10, 120, 150, 20);

        cajaNumPacienteC = new JTextField();

        agregarAlPanel(cajaNumPacienteC, panelConsultasPa,160, 120, 100, 20);

        JLabel txtNombrePacienteC = new JLabel("Nombre:");

        agregarAlPanel(txtNombrePacienteC, panelConsultasPa, 10, 150, 60, 20);

        cajaNombrePacienteC = new JTextField();

        agregarAlPanel(cajaNombrePacienteC, panelConsultasPa, 70, 150, 150, 20);

        JLabel txtApePatPacienteC = new JLabel("Apellido Paterno:");

        agregarAlPanel(txtApePatPacienteC, panelConsultasPa, 220, 150, 100, 20);

        cajaApePatPacienteC = new JTextField();

        agregarAlPanel(cajaApePatPacienteC, panelConsultasPa, 320, 150, 150, 20);

        JLabel txtApeMatPacienteC = new JLabel("Apellido Materno:");

        agregarAlPanel(txtApeMatPacienteC, panelConsultasPa, 480, 150, 100, 20);

        cajaApeMatPAcienteC = new JTextField();

        agregarAlPanel(cajaApeMatPAcienteC, panelConsultasPa, 580, 150, 150, 20);

        JLabel txtCallePacienteC = new JLabel("Calle y Número del Paciente:");

        agregarAlPanel(txtCallePacienteC, panelConsultasPa, 10, 180, 170, 20);

        cajaCalleNumeroPacienteC = new JTextField();

        agregarAlPanel(cajaCalleNumeroPacienteC, panelConsultasPa, 180, 180, 150, 20);

        JLabel txtColoniaPacienteC = new JLabel("Colonia:");

        agregarAlPanel(txtColoniaPacienteC, panelConsultasPa, 340, 180, 60, 20);

        cajaColoniaPacienteC = new JTextField();

        agregarAlPanel(cajaColoniaPacienteC, panelConsultasPa, 400, 180, 100, 20);

        JLabel txtxCPPacienteC = new JLabel("Código Postal:");

        agregarAlPanel(txtxCPPacienteC, panelConsultasPa, 510, 180, 100, 20);

        cajaCPPacienteC = new JTextField();

        agregarAlPanel(cajaCPPacienteC, panelConsultasPa, 610, 180, 50, 20);

        JLabel txtEstadoPacienteC = new JLabel("Estado:");

        agregarAlPanel(txtEstadoPacienteC, panelConsultasPa, 670, 180, 60, 20);

        cajaEstadoPacienteC = new JTextField();

        agregarAlPanel(cajaEstadoPacienteC, panelConsultasPa, 730, 180, 100, 20);

        JLabel txtTelefonoPacientesC = new JLabel("Telefono:");

        agregarAlPanel(txtTelefonoPacientesC, panelConsultasPa, 10, 210, 60, 20);

        cajaTelefonoPacienteC = new JTextField();

        agregarAlPanel(cajaTelefonoPacienteC, panelConsultasPa, 70, 210, 100, 20);

        JLabel txtxFechaNacPacienteC = new JLabel("Fecha de nacimiento");

        agregarAlPanel(txtxFechaNacPacienteC, panelConsultasPa, 10, 240, 120, 20);

        JLabel txtDiaNacPacienteC = new JLabel("Dia:");

        agregarAlPanel(txtDiaNacPacienteC, panelConsultasPa, 10, 260, 30, 20);

        comboDiaNacPacienteC = new JComboBox<>();

        for(int i = 1; i <= 30; i++){

            comboDiaNacPacienteC.addItem((short)i);

        }

        agregarAlPanel(comboDiaNacPacienteC, panelConsultasPa, 40, 260, 50, 20);

        JLabel txtMesNacPacienteC = new JLabel("Mes:");

        agregarAlPanel(txtMesNacPacienteC, panelConsultasPa, 100, 260, 30, 20);

        comboMesNacPacienteC = new JComboBox<>();



        for(int i = 1; i <= 12; i++){

            comboMesNacPacienteC.addItem((short)i);

        }

        agregarAlPanel(comboMesNacPacienteC, panelConsultasPa, 130, 260, 50, 20);

        JLabel txtAñoNacPacienteC = new JLabel("Año:");

        agregarAlPanel(txtAñoNacPacienteC, panelConsultasPa, 190, 260, 30, 20);

        comboAñoNacPacienteC = new JComboBox<>();

        for(int i = 2025; i >= 1900; i--){

            comboAñoNacPacienteC.addItem((short)i);

        }

        agregarAlPanel(comboAñoNacPacienteC, panelConsultasPa, 220, 260, 70, 20);

        JLabel txtSexoPacienteC = new JLabel("Sexo:");

        agregarAlPanel(txtSexoPacienteC, panelConsultasPa, 10, 290, 40, 20);

        radioHombreC = new JRadioButton("Hombre");

        bgSexoC.add(radioHombreC);

        agregarAlPanel(radioHombreC, panelConsultasPa, 50, 290, 80, 20);

        radioMujerC = new JRadioButton("Mujer");

        bgSexoC.add(radioMujerC);

        agregarAlPanel(radioMujerC, panelConsultasPa, 130, 290, 80, 20);

        radioNoBinarioC = new JRadioButton("No Binario");

        bgSexoC.add(radioNoBinarioC);

        agregarAlPanel(radioNoBinarioC, panelConsultasPa, 210, 290, 100, 20);

        JLabel txtEstadoCivilC = new JLabel("Estado civil:");

        agregarAlPanel(txtEstadoCivilC, panelConsultasPa, 10, 320, 100, 20);

        comboEstadoCivilPacienteC = new JComboBox<>();

        comboEstadoCivilPacienteC.addItem("Soltero");

        comboEstadoCivilPacienteC.addItem("Casado");

        comboEstadoCivilPacienteC.addItem("Viudo");

        comboEstadoCivilPacienteC.addItem("Divorciado");

        comboEstadoCivilPacienteC.addItem("Separado");

        comboEstadoCivilPacienteC.addItem("Concubinato");

        agregarAlPanel(comboEstadoCivilPacienteC, panelConsultasPa, 110, 320, 100, 20);

        JLabel txtxFechaIngrPacienteC = new JLabel("Fecha de ingreso");

        agregarAlPanel(txtxFechaIngrPacienteC, panelConsultasPa, 10, 350, 120, 20);

        JLabel txtDiaIngrPacienteC = new JLabel("Dia:");

        agregarAlPanel(txtDiaIngrPacienteC, panelConsultasPa, 10, 370, 30, 20);

        comboDiaIngrPacienteC = new JComboBox<>();

        for(int i = 1; i <= 30; i++){

            comboDiaIngrPacienteC.addItem((short)i);

        }

        agregarAlPanel(comboDiaIngrPacienteC, panelConsultasPa, 40, 370, 50, 20);

        JLabel txtMesIngrPacienteC = new JLabel("Mes:");

        agregarAlPanel(txtMesIngrPacienteC, panelConsultasPa, 100, 370, 30, 20);

        comboMesIngrPacienteC = new JComboBox<>();

        for(int i = 1; i <= 12; i++){

            comboMesIngrPacienteC.addItem((short)i);

        }

        agregarAlPanel(comboMesIngrPacienteC, panelConsultasPa, 130, 370, 50, 20);

        JLabel txtAñoIngrPacienteC = new JLabel("Año:");

        agregarAlPanel(txtAñoIngrPacienteC, panelConsultasPa, 190, 370, 30, 20);

        comboAñoIngrPacienteC = new JComboBox<>();

        for(int i = 2025; i >= 2010; i--){

            comboAñoIngrPacienteC.addItem((short)i);

        }

        agregarAlPanel(comboAñoIngrPacienteC, panelConsultasPa, 220, 370, 70, 20);

        btnBuscarC = new JButton("Buscar");

        agregarAlPanel(btnBuscarC, panelConsultasPa, 200, 450, 100, 30);

        btnRestaurarC = new JButton("Restaurar");

        agregarAlPanel(btnRestaurarC, panelConsultasPa, 400, 450, 100, 30);

        btnCancelarC = new JButton("Cancelar");

        agregarAlPanel(btnCancelarC, panelConsultasPa, 600, 450, 100, 30);

        tabla = new JTable();

        JScrollPane scrollPaneC = new JScrollPane(tabla);

        scrollPaneC.setBackground(Color.decode("#d2e2f1"));

        agregarAlPanel(scrollPaneC, panelConsultasPa, 10, 500, 850, 200);

        internalConsultasPa = new JInternalFrame();

        internalConsultasPa.setSize(900, 800);

        internalConsultasPa.add(panelConsultasPa);

        internalConsultasPa.setTitle("Consultas");

        caracteristicasInternal(internalConsultasPa);



        //==============================================================================================


        desktopPaneInternals.add(internalConsultasPa);

        desktopPaneInternals.add(internalCambiosPa);

        desktopPaneInternals.add(internalBajasPa);

        desktopPaneInternals.add(internalAltasPa);

        desktopPaneInternals.add(internalAjustes);

        asignarPosicion(desktopPaneInternals, 200, 30, 1000, 850);

    }



    @Override
    public void actionPerformed(ActionEvent e) {

        Object componente = e.getSource();

        if(componente == altasPacientes){

            internalCambiosPa.setVisible(false);

            internalBajasPa.setVisible(false);

            internalConsultasPa.setVisible(false);

            internalAltasPa.setVisible(true);

        }

        if(componente == bajasPacientes){

            internalAltasPa.setVisible(false);

            internalBajasPa.setVisible(false);

            internalConsultasPa.setVisible(false);

            internalBajasPa.setVisible(true);


        }

        if(componente == cambiosPacientes){

            internalAltasPa.setVisible(false);

            internalBajasPa.setVisible(false);

            internalConsultasPa.setVisible(false);

            internalCambiosPa.setVisible(true);

        }

        if(componente == comboMesNacPaciente){

            short mesSeleccionado = Short.parseShort(comboMesNacPaciente.getSelectedItem().toString());

            if(mesSeleccionado == 1 || mesSeleccionado == 3 || mesSeleccionado == 5 || mesSeleccionado == 7 || mesSeleccionado == 8 || mesSeleccionado == 10 || mesSeleccionado == 12){

                numDias = 31;

            } else if (mesSeleccionado == 2) {

                short año = Short.parseShort(comboAñoNacPaciente.getSelectedItem().toString());

                if ((año % 4 == 0 && año % 100 != 0) || (año % 100 == 0 && año % 400 == 0)){

                    numDias = 29;

                }else{

                    numDias = 28;

                }

            }else {

                numDias = 30;

            }

            comboDiaNacPaciente.removeAllItems();

            for(int i = 1; i <= numDias; i++){

                comboDiaNacPaciente.addItem((short)i);

            }

        }

        if(componente == comboMesIngrPaciente){

            short mesSeleccionado = Short.parseShort(comboMesIngrPaciente.getSelectedItem().toString());

            if(mesSeleccionado == 1 || mesSeleccionado == 3 || mesSeleccionado == 5 || mesSeleccionado == 7 || mesSeleccionado == 8 || mesSeleccionado == 10 || mesSeleccionado == 12){

                numDias = 31;

            } else if (mesSeleccionado == 2) {

                short año = Short.parseShort(comboAñoIngrPaciente.getSelectedItem().toString());

                if ((año % 4 == 0 && año % 100 != 0) || (año % 100 == 0 && año % 400 == 0)){

                    numDias = 29;

                }else{

                    numDias = 28;

                }

            }else {

                numDias = 30;

            }

            comboDiaIngrPaciente.removeAllItems();

            for(int i = 1; i <= numDias; i++){

                comboDiaIngrPaciente.addItem((short)i);

            }

        }

        if(componente == consultasPacientes){

            internalAltasPa.setVisible(false);

            internalBajasPa.setVisible(false);

            internalCambiosPa.setVisible(false);

            internalConsultasPa.setVisible(true);


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


