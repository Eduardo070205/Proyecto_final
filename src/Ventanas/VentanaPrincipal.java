package Ventanas;

import ConexionBD.ConexionBD;
import Controlador.PacienteDAO;
import Modelo.Paciente;
import Modelo.ResultSetTableModel;
import Recursos.Elementos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VentanaPrincipal extends Elementos implements ActionListener, KeyListener {

    JTable tabla, tablaB, tablaM, tablaC;

    byte numDias = 1;

    ConexionBD con = ConexionBD.getInstancia();

    PacienteDAO pacienteDAO = new PacienteDAO();

    LocalDateTime fechaHoy = LocalDateTime.now();

    JMenu menuPacientes, menuDoctores, menuTrabajadores;

    JMenuItem altasPacientes, bajasPacientes, cambiosPacientes, consultasPacientes;

    JMenuItem altasDoctores, bajasDoctores, cambiosDoctores, consultasDoctores;

    JMenuItem altasTrabajadores, bajasTrabajadores, cambiosTrabajadores, consultasTrabajadores;

    JLabel logo;

    JInternalFrame internalAltasPa, internalBajasPa, internalCambiosPa, internalConsultasPa;



    JInternalFrame internalAjustes, internalTrabajando;

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

    JRadioButton radionombre, radioApePat, radioApeMat, radioColonia, radioCP, radioEstado, radioFechaNac, radioFechaIngreso, radioEstadoCivil, radioSexo, radioTodos;

    ArrayList<JRadioButton> radiosConsultas = new ArrayList<>();

    //=============================================================================================

    JPanel panelAltasPa, panelBajasPa, panelModificacionesPa, panelConsultasPa;

    ButtonGroup bgSexo = new ButtonGroup();

    ButtonGroup bgSexoB = new ButtonGroup();

    ButtonGroup bgSexoM = new ButtonGroup();

    ButtonGroup bgSexoC = new ButtonGroup();

    ButtonGroup bgConsultas = new ButtonGroup();

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

        altasDoctores.addActionListener(this);

        menuDoctores.add(altasDoctores);

        bajasDoctores = new JMenuItem("Eliminar");

        bajasDoctores.addActionListener(this);

        menuDoctores.add(bajasDoctores);

        cambiosDoctores = new JMenuItem("Modificar");

        cambiosDoctores.addActionListener(this);

        menuDoctores.add(cambiosDoctores);

        consultasDoctores = new JMenuItem("Buscar");

        consultasDoctores.addActionListener(this);

        menuDoctores.add(consultasDoctores);

        menuTrabajadores = new JMenu("Trabajadores");

        altasTrabajadores= new JMenuItem("Agregar");

        altasTrabajadores.addActionListener(this);

        menuTrabajadores.add(altasTrabajadores);

        bajasTrabajadores = new JMenuItem("Eliminar");

        bajasTrabajadores.addActionListener(this);

        menuTrabajadores.add(bajasTrabajadores);

        cambiosTrabajadores = new JMenuItem("Modificar");

        cambiosTrabajadores.addActionListener(this);

        menuTrabajadores.add(cambiosTrabajadores);

        consultasTrabajadores = new JMenuItem("Buscar");

        consultasTrabajadores.addActionListener(this);

        menuTrabajadores.add(consultasTrabajadores);

        internalTrabajando = new JInternalFrame();

        internalTrabajando.setSize(1000, 800);

        JPanel panelTrabajando = new JPanel();

        panelTrabajando.setLayout(null);

        panelTrabajando.setBounds(0,0,1000,800);

        JLabel trabajando = new JLabel(asignarImagen("./img/trabajando.jpg", 800, 600));

        agregarAlPanel(trabajando, panelTrabajando, 100, 100, 800, 600);

        internalTrabajando.add(panelTrabajando);

        caracteristicasInternal(internalTrabajando);


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

                    toolbar.setBackground(Color.decode("#e7eaf3"));

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

        toolbar.setBackground(Color.decode("#e7eaf3"));

        toolbar.add(btnAjustes);

        asignarPosicion(toolbar, 0, 0, 1200, 30);

        JPanel panelFondo = new JPanel();

        panelFondo.setBounds(0,0,1000, 800);

        panelFondo.setLayout(null);

        JLabel fondo = new JLabel(asignarImagen("./img/fondo.jpg", 600, 600));

        agregarAlPanel(fondo, panelFondo, 200, 100, 600, 600);

        internalAjustes.setTitle("Ajustes");

        internalAltasPa = new JInternalFrame();

        internalAltasPa.setSize(1000, 800);

        //============================================ ALTAS ===========================================

        panelAltasDiseño.setLayout(null);

        panelAltasDiseño.setBounds(0,0,1000, 200);

        panelAltasDiseño.setBackground(Color.decode("#a3d1e3"));

        panelAltasPa = new JPanel();

        panelAltasPa.setBounds(0,200,1000, 800);

        panelAltasPa.setBackground(Color.decode("#feffe9"));

        panelAltasPa.setLayout(null);

        JLabel txtTitulo = new JLabel("Agregrar un Paciente");

        txtTitulo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));

        agregarAlPanel(txtTitulo, panelAltasDiseño, 50, 40, 200, 40);

        JLabel imagenAltas = new JLabel(asignarImagen("./img/altas.png", 80, 80));

        agregarAlPanel(imagenAltas, panelAltasDiseño, 900, 10, 80, 80);

        agregarAlPanel(panelAltasDiseño, panelAltasPa, 0,0,1000,100);

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

        comboEstadoCivilPaciente.addItem("Elegir");

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




        for(int i = 1; i <= numDias; i++){

            comboDiaIngrPaciente.addItem((short)i);

        }

        agregarAlPanel(comboDiaIngrPaciente, panelAltasPa, 240, 370, 50, 20);

        comboDiaIngrPaciente.setSelectedItem((short)fechaHoy.getDayOfMonth());

        btnEnviar = new JButton("Enviar");

        btnEnviar.addActionListener(this);

        agregarAlPanel(btnEnviar, panelAltasPa, 200, 450, 100, 30);

        btnRestaurar = new JButton("Restaurar");

        btnRestaurar.addActionListener(this);

        agregarAlPanel(btnRestaurar, panelAltasPa, 400, 450, 100, 30);

        btnCancelar = new JButton("Cancelar");

        btnCancelar.addActionListener(this);

        agregarAlPanel(btnCancelar, panelAltasPa, 600, 450, 100, 30);

        tabla = new JTable();

        actualizarTabla(tabla);

        JScrollPane scrollPane = new JScrollPane(tabla);

        scrollPane.setBackground(Color.decode("#d2e2f1"));

        agregarAlPanel(scrollPane, panelAltasPa, 0, 500, 980, 200);

        internalAltasPa.add(panelAltasPa);

        internalAltasPa.setTitle("Altas");

        caracteristicasInternal(internalAltasPa);

        //================================================= BAJAS ======================================


        panelBajasDiseño.setLayout(null);

        panelBajasDiseño.setBounds(0,0,1000, 200);

        panelBajasDiseño.setBackground(Color.decode("#a3d1e3"));

        panelBajasPa = new JPanel();

        panelBajasPa.setBounds(0,200,1000, 800);

        panelBajasPa.setBackground(Color.decode("#feffe9"));

        panelBajasPa.setLayout(null);

        JLabel txtTituloB = new JLabel("Eliminar un Paciente");

        txtTituloB.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));

        JLabel imagenBajas = new JLabel(asignarImagen("./img/bajas.png", 80, 80));

        agregarAlPanel(imagenBajas, panelBajasDiseño, 900, 10, 80, 80);

        agregarAlPanel(txtTituloB, panelBajasDiseño, 50, 40, 200, 40);

        agregarAlPanel(panelBajasDiseño, panelBajasPa, 0,0,1000,100);

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

        comboEstadoCivilPacienteB.addItem("Elegir");

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

        btnBuscarB.addActionListener(this);

        agregarAlPanel(btnBuscarB, panelBajasPa, 100, 450, 100, 30);

        btnBorrarB = new JButton("Borrar");

        btnBorrarB.addActionListener(this);

        agregarAlPanel(btnBorrarB, panelBajasPa, 250, 450, 100, 30);

        btnRestaurarB = new JButton("Restaurar");

        btnRestaurarB.addActionListener(this);

        agregarAlPanel(btnRestaurarB, panelBajasPa, 400, 450, 100, 30);

        btnCancelarB = new JButton("Cancelar");

        btnCancelarB.addActionListener(this);

        agregarAlPanel(btnCancelarB, panelBajasPa, 550, 450, 100, 30);

        tablaB = new JTable();

        actualizarTabla(tablaB);

        JScrollPane scrollPaneB = new JScrollPane(tablaB);

        scrollPaneB.setBackground(Color.decode("#d2e2f1"));

        agregarAlPanel(scrollPaneB, panelBajasPa, 0, 500, 980, 200);

        internalBajasPa = new JInternalFrame();

        internalBajasPa.setSize(1000, 800);

        internalBajasPa.add(panelBajasPa);

        internalBajasPa.setTitle("Bajas");

        caracteristicasInternal(internalBajasPa);


        //============================================== MODIFICACIONES ================================

        panelModificacionesDiseño.setLayout(null);

        panelModificacionesDiseño.setBounds(0,0,1000, 200);

        panelModificacionesDiseño.setBackground(Color.decode("#a3d1e3"));

        panelModificacionesPa = new JPanel();

        panelModificacionesPa.setBounds(0,200,1000, 800);

        panelModificacionesPa.setBackground(Color.decode("#feffe9"));

        panelModificacionesPa.setLayout(null);

        JLabel txtTituloM = new JLabel("Modificar un Paciente");

        txtTituloM.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));

        JLabel imagenModificaciones = new JLabel(asignarImagen("./img/editar.png", 80, 80));

        agregarAlPanel(imagenModificaciones, panelModificacionesDiseño, 900, 10, 80, 80);

        agregarAlPanel(txtTituloM, panelModificacionesDiseño, 50, 40, 300, 40);

        agregarAlPanel(panelModificacionesDiseño, panelModificacionesPa, 0,0,1000,100);

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

        JLabel txtAñoNacPacienteM = new JLabel("Año:");

        agregarAlPanel(txtAñoNacPacienteM, panelModificacionesPa, 10, 260, 30, 20);

        comboAñoNacPacienteM = new JComboBox<>();

        for(int i = 2025; i >= 1900; i--){

            comboAñoNacPacienteM.addItem((short)i);

        }

        agregarAlPanel(comboAñoNacPacienteM, panelModificacionesPa, 40, 260, 70, 20);

        comboAñoNacPacienteM.setSelectedItem((short)fechaHoy.getYear());

        JLabel txtMesNacPacienteM = new JLabel("Mes:");

        agregarAlPanel(txtMesNacPacienteM, panelModificacionesPa, 120, 260, 30, 20);

        comboMesNacPacienteM = new JComboBox<>();


        for(int i = 1; i <= 12; i++){

            comboMesNacPacienteM.addItem((short)i);

        }

        agregarAlPanel(comboMesNacPacienteM, panelModificacionesPa, 150, 260, 50, 20);

        comboMesNacPacienteM.setSelectedItem((short)fechaHoy.getMonthValue());

        comboMesNacPacienteM.addActionListener(this);

        short mesSeleccionadoM = Short.parseShort(comboMesNacPacienteM.getSelectedItem().toString());

        if(mesSeleccionadoM == 1 || mesSeleccionadoM == 3 || mesSeleccionadoM == 5 || mesSeleccionadoM == 7 || mesSeleccionadoM == 8 || mesSeleccionadoM == 10 || mesSeleccionadoM == 12){

            numDias = 31;

        } else if (mesSeleccionadoM == 2) {

            short año = Short.parseShort(comboAñoNacPacienteM.getSelectedItem().toString());

            if ((año % 4 == 0 && año % 100 != 0) || (año % 100 == 0 && año % 400 == 0)){

                numDias = 29;

            }else{

                numDias = 28;

            }

        }else {

            numDias = 30;

        }

        JLabel txtDiaNacPacienteM = new JLabel("Dia:");

        agregarAlPanel(txtDiaNacPacienteM, panelModificacionesPa, 210, 260, 30, 20);


        comboDiaNacPacienteM = new JComboBox<>();




        for(int i = 1; i <= numDias; i++){

            comboDiaNacPacienteM.addItem((short)i);

        }

        agregarAlPanel(comboDiaNacPacienteM, panelModificacionesPa, 240, 260, 50, 20);

        comboDiaNacPacienteM.setSelectedItem((short)fechaHoy.getDayOfMonth());

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

        comboEstadoCivilPacienteM.addItem("Elegir");

        comboEstadoCivilPacienteM.addItem("Soltero");

        comboEstadoCivilPacienteM.addItem("Casado");

        comboEstadoCivilPacienteM.addItem("Viudo");

        comboEstadoCivilPacienteM.addItem("Divorciado");

        comboEstadoCivilPacienteM.addItem("Separado");

        comboEstadoCivilPacienteM.addItem("Concubinato");

        agregarAlPanel(comboEstadoCivilPacienteM, panelModificacionesPa, 110, 320, 100, 20);

        JLabel txtxFechaIngrPacienteM = new JLabel("Fecha de ingreso");

        agregarAlPanel(txtxFechaIngrPacienteM, panelModificacionesPa, 10, 350, 120, 20);

        JLabel txtAñoIngrPacienteM = new JLabel("Año:");

        agregarAlPanel(txtAñoIngrPacienteM, panelModificacionesPa, 10, 370, 30, 20);

        comboAñoIngrPacienteM = new JComboBox<>();

        for(int i = 2025; i >= 1900; i--){

            comboAñoIngrPacienteM.addItem((short)i);

        }

        agregarAlPanel(comboAñoIngrPacienteM, panelModificacionesPa, 40, 370, 70, 20);

        comboAñoIngrPacienteM.setSelectedItem((short)fechaHoy.getYear());

        JLabel txtMesIngrPacienteM = new JLabel("Mes:");

        agregarAlPanel(txtMesIngrPacienteM, panelModificacionesPa, 120, 370, 30, 20);

        comboMesIngrPacienteM = new JComboBox<>();


        for(int i = 1; i <= 12; i++){

            comboMesIngrPacienteM.addItem((short)i);

        }

        agregarAlPanel(comboMesIngrPacienteM, panelModificacionesPa, 150, 370, 50, 20);

        comboMesIngrPacienteM.setSelectedItem((short)fechaHoy.getMonthValue());

        comboMesIngrPacienteM.addActionListener(this);

        short mesSeleccionadoMm = Short.parseShort(comboMesNacPacienteM.getSelectedItem().toString());

        if(mesSeleccionadoMm == 1 || mesSeleccionadoMm == 3 || mesSeleccionadoMm == 5 || mesSeleccionadoMm == 7 || mesSeleccionadoMm == 8 || mesSeleccionadoMm == 10 || mesSeleccionadoMm == 12){

            numDias = 31;

        } else if (mesSeleccionadoMm == 2) {

            short año = Short.parseShort(comboAñoIngrPacienteM.getSelectedItem().toString());

            if ((año % 4 == 0 && año % 100 != 0) || (año % 100 == 0 && año % 400 == 0)){

                numDias = 29;

            }else{

                numDias = 28;

            }

        }else {

            numDias = 30;

        }

        JLabel txtDiaIngrPacienteM = new JLabel("Dia:");

        agregarAlPanel(txtDiaIngrPacienteM, panelModificacionesPa, 210, 370, 30, 20);


        comboDiaIngrPacienteM = new JComboBox<>();


        for(int i = 1; i <= numDias; i++){

            comboDiaIngrPacienteM.addItem((short)i);

        }

        agregarAlPanel(comboDiaIngrPacienteM, panelModificacionesPa, 240, 370, 50, 20);

        comboDiaIngrPacienteM.setSelectedItem((short)fechaHoy.getDayOfMonth());

        btnBuscarM = new JButton("Buscar");

        btnBuscarM.addActionListener(this);

        agregarAlPanel(btnBuscarM, panelModificacionesPa, 100, 450, 100, 30);

        btnGuardarM = new JButton("Guardar");

        btnGuardarM.addActionListener(this);

        agregarAlPanel(btnGuardarM, panelModificacionesPa, 250, 450, 100, 30);

        btnRestaurarM = new JButton("Restaurar");

        btnRestaurarM.addActionListener(this);

        agregarAlPanel(btnRestaurarM, panelModificacionesPa, 400, 450, 100, 30);

        btnCancelarM = new JButton("Cancelar");

        btnCancelarM.addActionListener(this);

        agregarAlPanel(btnCancelarM, panelModificacionesPa, 550, 450, 100, 30);

        tablaM = new JTable();

        actualizarTabla(tablaM);

        JScrollPane scrollPaneM = new JScrollPane(tablaM);

        scrollPaneM.setBackground(Color.decode("#d2e2f1"));

        agregarAlPanel(scrollPaneM, panelModificacionesPa, 0, 500, 980, 200);

        internalCambiosPa = new JInternalFrame();

        internalCambiosPa.setSize(1000, 800);

        internalCambiosPa.add(panelModificacionesPa);

        internalCambiosPa.setTitle("Modificaciones");

        caracteristicasInternal(internalCambiosPa);


        //======================================================== CONSULTAS =============================


        panelConsultasDiseño.setLayout(null);

        panelConsultasDiseño.setBounds(0,0,1000, 200);

        panelConsultasDiseño.setBackground(Color.decode("#a3d1e3"));

        panelConsultasPa = new JPanel();

        panelConsultasPa.setBounds(0,200,1000, 800);

        panelConsultasPa.setBackground(Color.decode("#feffe9"));

        panelConsultasPa.setLayout(null);

        JLabel txtTituloC = new JLabel("Buscar un Paciente");

        txtTituloC.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));

        JLabel imagenConsultas = new JLabel(asignarImagen("./img/consultar.png", 80, 80));

        agregarAlPanel(imagenConsultas, panelConsultasDiseño, 900, 10, 80, 80);

        agregarAlPanel(txtTituloC, panelConsultasDiseño, 50, 40, 200, 40);

        agregarAlPanel(panelConsultasDiseño, panelConsultasPa, 0,0,1000,100);


        radioTodos = new JRadioButton("Todos");

        bgConsultas.add(radioTodos);

        radiosConsultas.add((radioTodos));

        agregarAlPanel(radioTodos, panelConsultasPa,10, 120, 100, 20);

        radionombre = new JRadioButton("Nombre");

        bgConsultas.add(radionombre);

        radiosConsultas.add((radionombre));

        agregarAlPanel(radionombre, panelConsultasPa, 10, 150, 100, 20);

        cajaNombrePacienteC = new JTextField();

        agregarAlPanel(cajaNombrePacienteC, panelConsultasPa, 110, 150, 150, 20);

        radioApePat = new JRadioButton("Apellido parteno");

        bgConsultas.add(radioApePat);

        radiosConsultas.add((radioApePat));

        agregarAlPanel(radioApePat, panelConsultasPa, 270, 150, 120, 20);

        cajaApePatPacienteC = new JTextField();

        agregarAlPanel(cajaApePatPacienteC, panelConsultasPa, 400, 150, 150, 20);

        radioApeMat = new JRadioButton("Apellido materno");

        bgConsultas.add(radioApeMat);

        radiosConsultas.add((radioApeMat));

        agregarAlPanel(radioApeMat, panelConsultasPa, 560, 150, 120, 20);

        cajaApeMatPAcienteC = new JTextField();

        agregarAlPanel(cajaApeMatPAcienteC, panelConsultasPa, 690, 150, 150, 20);

        radioColonia = new JRadioButton("Colonia");

        bgConsultas.add(radioColonia);

        radiosConsultas.add((radioColonia));

        agregarAlPanel(radioColonia, panelConsultasPa, 10, 180, 100, 20);

        cajaColoniaPacienteC = new JTextField();

        agregarAlPanel(cajaColoniaPacienteC, panelConsultasPa, 120, 180, 100, 20);

        radioCP = new JRadioButton("Código postal");

        bgConsultas.add(radioCP);

        radiosConsultas.add((radioCP));

        agregarAlPanel(radioCP, panelConsultasPa, 230, 180, 120, 20);

        cajaCPPacienteC = new JTextField();

        agregarAlPanel(cajaCPPacienteC, panelConsultasPa, 360, 180, 50, 20);

        radioEstado = new JRadioButton("Estado");

        bgConsultas.add(radioEstado);

        radiosConsultas.add((radioEstado));

        agregarAlPanel(radioEstado, panelConsultasPa, 420, 180, 80, 20);

        cajaEstadoPacienteC = new JTextField();

        agregarAlPanel(cajaEstadoPacienteC, panelConsultasPa, 510, 180, 100, 20);

        radioFechaNac = new JRadioButton("Fecha de nacimiento");

        radioFechaNac.addActionListener(this);

        bgConsultas.add(radioFechaNac);

        radiosConsultas.add(radioFechaNac);

        agregarAlPanel(radioFechaNac, panelConsultasPa, 10, 230, 150, 20);

        JLabel txtAñoNacPacienteC = new JLabel("Año:");

        agregarAlPanel(txtAñoNacPacienteC, panelConsultasPa, 10, 260, 30, 20);

        comboAñoNacPacienteC = new JComboBox<>();

        for(int i = 2025; i >= 1900; i--){

            comboAñoNacPacienteC.addItem((short)i);

        }

        agregarAlPanel(comboAñoNacPacienteC, panelConsultasPa, 40, 260, 70, 20);

        comboAñoNacPacienteC.setSelectedItem((short)fechaHoy.getYear());

        JLabel txtMesNacPacienteC = new JLabel("Mes:");

        agregarAlPanel(txtMesNacPacienteC, panelConsultasPa, 120, 260, 30, 20);

        comboMesNacPacienteC = new JComboBox<>();


        for(int i = 1; i <= 12; i++){

            comboMesNacPacienteC.addItem((short)i);

        }

        agregarAlPanel(comboMesNacPacienteC, panelConsultasPa, 150, 260, 50, 20);

        comboMesNacPacienteC.setSelectedItem((short)fechaHoy.getMonthValue());

        comboMesNacPacienteC.addActionListener(this);

        short mesSeleccionadoC = Short.parseShort(comboMesNacPacienteC.getSelectedItem().toString());

        if(mesSeleccionadoC == 1 || mesSeleccionadoC == 3 || mesSeleccionadoC == 5 || mesSeleccionadoC == 7 || mesSeleccionadoC == 8 || mesSeleccionadoC == 10 || mesSeleccionadoC == 12){

            numDias = 31;

        } else if (mesSeleccionadoC == 2) {

            short año = Short.parseShort(comboAñoNacPacienteC.getSelectedItem().toString());

            if ((año % 4 == 0 && año % 100 != 0) || (año % 100 == 0 && año % 400 == 0)){

                numDias = 29;

            }else{

                numDias = 28;

            }

        }else {

            numDias = 30;

        }

        JLabel txtDiaNacPacienteC = new JLabel("Dia:");

        agregarAlPanel(txtDiaNacPacienteC, panelConsultasPa, 210, 260, 30, 20);


        comboDiaNacPacienteC = new JComboBox<>();

        //comboDiaNacPaciente.setEnabled(false);


        for(int i = 1; i <= numDias; i++){

            comboDiaNacPacienteC.addItem((short)i);

        }

        agregarAlPanel(comboDiaNacPacienteC, panelConsultasPa, 240, 260, 50, 20);

        comboDiaNacPacienteC.setSelectedItem((short)fechaHoy.getDayOfMonth());


        radioSexo = new JRadioButton("Sexo");

        bgConsultas.add(radioSexo);

        radiosConsultas.add((radioSexo));

        agregarAlPanel(radioSexo, panelConsultasPa, 10, 290, 60, 20);

        radioHombreC = new JRadioButton("Hombre");

        bgSexoC.add(radioHombreC);



        agregarAlPanel(radioHombreC, panelConsultasPa, 80, 290, 80, 20);

        radioMujerC = new JRadioButton("Mujer");

        bgSexoC.add(radioMujerC);

        agregarAlPanel(radioMujerC, panelConsultasPa, 160, 290, 80, 20);

        radioNoBinarioC = new JRadioButton("No Binario");

        bgSexoC.add(radioNoBinarioC);

        agregarAlPanel(radioNoBinarioC, panelConsultasPa, 240, 290, 100, 20);

        radioEstadoCivil = new JRadioButton("Estado civil");

        bgConsultas.add(radioEstadoCivil);

        radiosConsultas.add((radioEstadoCivil));

        agregarAlPanel(radioEstadoCivil, panelConsultasPa, 10, 320, 100, 20);

        comboEstadoCivilPacienteC = new JComboBox<>();

        comboEstadoCivilPacienteC.addItem("Elegir");

        comboEstadoCivilPacienteC.addItem("Soltero");

        comboEstadoCivilPacienteC.addItem("Casado");

        comboEstadoCivilPacienteC.addItem("Viudo");

        comboEstadoCivilPacienteC.addItem("Divorciado");

        comboEstadoCivilPacienteC.addItem("Separado");

        comboEstadoCivilPacienteC.addItem("Concubinato");

        agregarAlPanel(comboEstadoCivilPacienteC, panelConsultasPa, 110, 320, 100, 20);

        radioFechaIngreso= new JRadioButton("Fecha de ingreso");

        radioFechaIngreso.addActionListener(this);

        bgConsultas.add(radioFechaIngreso);

        radiosConsultas.add(radioFechaIngreso);

        agregarAlPanel(radioFechaIngreso, panelConsultasPa, 10, 350, 150, 20);

        JLabel txtAñoIngrPacienteC = new JLabel("Año:");

        agregarAlPanel(txtAñoIngrPacienteC, panelConsultasPa, 10, 380, 30, 20);

        comboAñoIngrPacienteC = new JComboBox<>();

        for(int i = 2025; i >= 1900; i--){

            comboAñoIngrPacienteC.addItem((short)i);

        }

        agregarAlPanel(comboAñoIngrPacienteC, panelConsultasPa, 40, 380, 70, 20);

        comboAñoIngrPacienteC.setSelectedItem((short)fechaHoy.getYear());

        JLabel txtMesIngrPacienteC = new JLabel("Mes:");

        agregarAlPanel(txtMesIngrPacienteC, panelConsultasPa, 120, 380, 30, 20);

        comboMesIngrPacienteC = new JComboBox<>();

        for(int i = 1; i <= 12; i++){

            comboMesIngrPacienteC.addItem((short)i);

        }

        agregarAlPanel(comboMesIngrPacienteC, panelConsultasPa, 150, 380, 50, 20);

        comboMesIngrPacienteC.setSelectedItem((short)fechaHoy.getMonthValue());

        comboMesIngrPacienteC.addActionListener(this);

        mesSeleccionadoC = Short.parseShort(comboMesIngrPacienteC.getSelectedItem().toString());

        if(mesSeleccionadoC == 1 || mesSeleccionadoC == 3 || mesSeleccionadoC == 5 || mesSeleccionadoC == 7 || mesSeleccionadoC == 8 || mesSeleccionadoC == 10 || mesSeleccionadoC == 12){

            numDias = 31;

        } else if (mesSeleccionadoC == 2) {

            short año = Short.parseShort(comboAñoIngrPacienteC.getSelectedItem().toString());

            if ((año % 4 == 0 && año % 100 != 0) || (año % 100 == 0 && año % 400 == 0)){

                numDias = 29;

            }else{

                numDias = 28;

            }

        }else {

            numDias = 30;

        }

        JLabel txtDiaIngrPacienteC = new JLabel("Dia:");

        agregarAlPanel(txtDiaIngrPacienteC, panelConsultasPa, 210, 380, 30, 20);


        comboDiaIngrPacienteC = new JComboBox<>();




        for(int i = 1; i <= numDias; i++){

            comboDiaIngrPacienteC.addItem((short)i);

        }

        agregarAlPanel(comboDiaIngrPacienteC, panelConsultasPa, 240, 380, 50, 20);

        comboDiaIngrPacienteC.setSelectedItem((short)fechaHoy.getDayOfMonth());

        btnBuscarC = new JButton("Buscar");

        btnBuscarC.addActionListener(this);

        agregarAlPanel(btnBuscarC, panelConsultasPa, 200, 450, 100, 30);

        btnRestaurarC = new JButton("Restaurar");

        btnRestaurarC.addActionListener(this);

        agregarAlPanel(btnRestaurarC, panelConsultasPa, 400, 450, 100, 30);

        btnCancelarC = new JButton("Cancelar");

        btnCancelarC.addActionListener(this);

        agregarAlPanel(btnCancelarC, panelConsultasPa, 600, 450, 100, 30);

        tablaC = new JTable();

        actualizarTabla(tablaC);

        JScrollPane scrollPaneC = new JScrollPane(tablaC);

        scrollPaneC.setBackground(Color.decode("#d2e2f1"));

        agregarAlPanel(scrollPaneC, panelConsultasPa, 0, 500, 980, 200);

        internalConsultasPa = new JInternalFrame();

        internalConsultasPa.setSize(1000, 800);

        internalConsultasPa.add(panelConsultasPa);

        internalConsultasPa.setTitle("Consultas");

        caracteristicasInternal(internalConsultasPa);

        radioTodos.setSelected(true);

        radioTodos.addActionListener(this);

        radionombre.addActionListener(this);

        radioApePat.addActionListener(this);

        radioApeMat.addActionListener(this);

        radioColonia.addActionListener(this);

        radioCP.addActionListener(this);

        radioEstado.addActionListener(this);

        radioSexo.addActionListener(this);

        radioEstadoCivil.addActionListener(this);

        //=============================================================================================


        cajaNumPaciente.addKeyListener(this);

        cajaNombrePaciente.addKeyListener(this );

        cajaApePatPaciente.addKeyListener(this);

        cajaApeMatPAciente.addKeyListener(this);

        cajaCPPaciente.addKeyListener(this);

        cajaEstadoPaciente.addKeyListener(this);

        cajaTelefonoPaciente.addKeyListener(this);

        comboEstadoCivilPaciente.addKeyListener(this);



        cajaNumPacienteB.addKeyListener(this);

        cajaNombrePacienteB.addKeyListener(this );

        cajaApePatPacienteB.addKeyListener(this);

        cajaApeMatPAcienteB.addKeyListener(this);

        cajaCPPacienteB.addKeyListener(this);

        cajaEstadoPacienteB.addKeyListener(this);

        cajaTelefonoPacienteB.addKeyListener(this);

        comboEstadoCivilPacienteB.addKeyListener(this);



        cajaNumPacienteM.addKeyListener(this);

        cajaNombrePacienteM.addKeyListener(this );

        cajaApePatPacienteM.addKeyListener(this);

        cajaApeMatPAcienteM.addKeyListener(this);

        cajaCPPacienteM.addKeyListener(this);

        cajaEstadoPacienteM.addKeyListener(this);

        cajaTelefonoPacienteM.addKeyListener(this);

        comboEstadoCivilPacienteM.addKeyListener(this);



        //cajaNumPacienteC.addKeyListener(this);

        cajaNombrePacienteC.addKeyListener(this );

        cajaApePatPacienteC.addKeyListener(this);

        cajaApeMatPAcienteC.addKeyListener(this);

        cajaCPPacienteC.addKeyListener(this);

        cajaEstadoPacienteC.addKeyListener(this);

        //cajaTelefonoPacienteC.addKeyListener(this);

        comboEstadoCivilPacienteC.addKeyListener(this);

        radioHombre.setSelected(true);

        radioHombreB.setSelected(true);

        radioHombreM.setSelected(true);

        radioHombreC.setSelected(true);

        //==============================================================================================

        desktopPaneInternals.add(panelFondo);

        desktopPaneInternals.add(internalTrabajando);

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


        if(componente == btnEnviar){

            if(validacion(cajaNumPaciente, cajaNombrePaciente, cajaApePatPaciente, cajaApeMatPAciente, cajaCalleNumeroPaciente, cajaColoniaPaciente, cajaCPPaciente, cajaEstadoPaciente, cajaTelefonoPaciente, comboEstadoCivilPaciente)){

                String mes = comboMesNacPaciente.getSelectedItem().toString();

                String dia = comboDiaNacPaciente.getSelectedItem().toString();

                if(mes.length() == 1){

                    mes = "0" + mes;

                }

                if(dia.length() == 1){

                    dia = "0" + dia;

                }

                String mes2 = comboMesIngrPaciente.getSelectedItem().toString();

                String dia2 = comboDiaIngrPaciente.getSelectedItem().toString();

                if(mes2.length() == 1){

                    mes2 = "0" + mes2;

                }

                if(dia2.length() == 1){

                    dia2 = "0" + dia2;

                }

                String fechaNac = comboAñoNacPaciente.getSelectedItem() + "-" + mes + "-" + dia;

                String fechaIngreso = comboAñoIngrPaciente.getSelectedItem() + "-" + mes2 + "-" + dia2;

                String sexo = "";

                if(radioHombre.isSelected()){

                    sexo = "Hombre";

                }

                if(radioMujer.isSelected()){

                    sexo = "Mujer";

                }

                if(radioNoBinario.isSelected()){

                    sexo = "No binario";

                }

                if(validarFecha(Integer.parseInt(dia), Integer.parseInt(mes), Integer.parseInt(comboAñoNacPaciente.getSelectedItem().toString())) && validarFecha(Integer.parseInt(dia2), Integer.parseInt(mes2), Integer.parseInt(comboAñoIngrPaciente.getSelectedItem().toString()))){

                    Paciente paciente = new Paciente(

                            cajaNumPaciente.getText().toString(),

                            cajaNombrePaciente.getText().toString(),

                            cajaApePatPaciente.getText().toString(),

                            cajaApeMatPAciente.getText().toString(),

                            cajaCalleNumeroPaciente.getText().toString(),

                            cajaColoniaPaciente.getText().toString(),

                            cajaCPPaciente.getText().toString(),

                            cajaEstadoPaciente.getText().toString(),

                            cajaTelefonoPaciente.getText().toString(),

                            fechaNac,

                            sexo,

                            comboEstadoCivilPaciente.getSelectedItem().toString(),

                            fechaIngreso

                    );

                    if(pacienteDAO.agregarPaciente(paciente)){

                        actualizarTabla(tabla);

                        JOptionPane.showMessageDialog(this, "Registro agregado correctamente");

                    }else{

                        JOptionPane.showMessageDialog(this, "Error en la Insercción");

                        con.mostrarError(this);


                    }

                }else {

                    JOptionPane.showMessageDialog(this, "Error en las fechas");

                }


            }else{

                JOptionPane.showMessageDialog(this, "Existen csampos Vacios");

            }


        }



        if(componente == btnBuscarB){

            String sql = "SELECT * FROM Pacientes WHERE Num_Paciente = ?";

            ResultSet rs = con.ejecutarInstruccionSQL(sql, cajaNumPacienteB.getText());

            try {

                rs.next();

                cajaNombrePacienteB.setText(rs.getString(2));

                cajaApePatPacienteB.setText(rs.getString(3));

                cajaApeMatPAcienteB.setText(rs.getString(4));

                cajaCalleNumeroPacienteB.setText(rs.getString(5));

                cajaColoniaPacienteB.setText(rs.getString(6));

                cajaCPPacienteB.setText(rs.getString(7));

                cajaEstadoPacienteB.setText(rs.getString(8));

                cajaTelefonoPacienteB.setText(rs.getString(9));

                String fechaNac = rs.getString(10);

                String [] partesFechaNac = fechaNac.split("-");

                comboAñoNacPacienteB.setSelectedItem(Short.parseShort(partesFechaNac[0]));

                comboMesNacPacienteB.setSelectedItem(Short.parseShort(partesFechaNac[1]));

                comboDiaNacPacienteB.setSelectedItem(Short.parseShort(partesFechaNac[2]));

                String sexo = rs.getString(11);

                if(sexo.equals("Hombre")){

                    radioHombreB.setSelected(true);

                }

                if(sexo.equals("Mujer")){

                    radioMujerB.setSelected(true);

                }

                if(sexo.equals("No binario")){

                    radioNoBinarioB.setSelected(true);

                }

                comboEstadoCivilPacienteB.setSelectedItem(String.valueOf(rs.getString(12)));

                String fechaIngreso = rs.getString(10);

                String [] partesFechaIngreso = fechaIngreso.split("-");

                comboAñoIngrPacienteB.setSelectedItem(Short.parseShort(partesFechaIngreso[0]));

                comboMesIngrPacienteB.setSelectedItem(Short.parseShort(partesFechaIngreso[1]));

                comboDiaIngrPacienteB.setSelectedItem(Short.parseShort(partesFechaIngreso[2]));

            } catch (SQLException er) {

                throw new RuntimeException(er);

            }

        }

        if(componente == btnRestaurar){

            restablecer(cajaNumPaciente, cajaNombrePaciente, cajaApePatPaciente, cajaApeMatPAciente, cajaCalleNumeroPaciente, cajaColoniaPaciente, cajaCPPaciente, cajaEstadoPaciente, cajaTelefonoPaciente, comboDiaNacPaciente, comboMesNacPaciente, comboAñoNacPaciente, comboDiaIngrPaciente, comboMesIngrPaciente, comboAñoIngrPaciente, comboEstadoCivilPaciente, radioHombre);

        }

        if(componente == btnCancelar){

            int respuesta = JOptionPane.showConfirmDialog(this, "¿Quieres Salir sin guardar el registro?");

            if(respuesta == JOptionPane.YES_OPTION){

                internalAltasPa.setVisible(false);

                restablecer(cajaNumPaciente, cajaNombrePaciente, cajaApePatPaciente, cajaApeMatPAciente, cajaCalleNumeroPaciente, cajaColoniaPaciente, cajaCPPaciente, cajaEstadoPaciente, cajaTelefonoPaciente,  comboEstadoCivilPaciente, radioHombre, radioMujer, radioNoBinario);

                comboAñoNacPaciente.setSelectedItem((short)fechaHoy.getYear());

                comboMesNacPaciente.setSelectedItem((short)fechaHoy.getMonthValue());

                comboDiaNacPaciente.setSelectedItem((short)fechaHoy.getDayOfMonth());

                comboAñoIngrPaciente.setSelectedItem((short)fechaHoy.getYear());

                comboMesIngrPaciente.setSelectedItem((short)fechaHoy.getMonthValue());

                comboDiaIngrPaciente.setSelectedItem((short)fechaHoy.getDayOfMonth());

            }



        }


        if(componente == btnBorrarB){

            int respuesta = JOptionPane.showConfirmDialog(this, "¿Estas seguro de eliminar el registro?");

            if(respuesta == JOptionPane.YES_OPTION){

                if(pacienteDAO.elimniarPaciente(cajaNumPacienteB.getText().toString())){

                    actualizarTabla(tablaB);

                    JOptionPane.showMessageDialog(this, "Registro eliminado con exito");

                }else{

                    JOptionPane.showMessageDialog(this, "El registro no se pudo eliminar");

                }

            }

        }

        if(componente == btnRestaurarB){

            restablecer(cajaNumPacienteB, cajaNombrePacienteB, cajaApePatPacienteB, cajaApeMatPAcienteB, cajaCalleNumeroPacienteB, cajaColoniaPacienteB, cajaCPPacienteB, cajaEstadoPacienteB, cajaTelefonoPacienteB, comboDiaNacPacienteB, comboMesNacPacienteB, comboAñoNacPacienteB, comboDiaIngrPacienteB, comboMesIngrPacienteB, comboAñoIngrPacienteB, comboEstadoCivilPacienteB, radioHombreB);

        }

        if(componente == btnCancelarB){


            internalBajasPa.setVisible(false);

            restablecer(cajaNumPacienteB, cajaNombrePacienteB, cajaApePatPacienteB, cajaApeMatPAcienteB, cajaCalleNumeroPacienteB, cajaColoniaPacienteB, cajaCPPacienteB, cajaEstadoPacienteB, cajaTelefonoPacienteB,  comboEstadoCivilPacienteB, radioHombreB, radioMujerB, radioNoBinarioB);

            comboAñoNacPacienteB.setSelectedItem((short)fechaHoy.getYear());

            comboMesNacPacienteB.setSelectedItem((short)fechaHoy.getMonthValue());

            comboDiaNacPacienteB.setSelectedItem((short)fechaHoy.getDayOfMonth());

            comboAñoIngrPacienteB.setSelectedItem((short)fechaHoy.getYear());

            comboMesIngrPacienteB.setSelectedItem((short)fechaHoy.getMonthValue());

            comboDiaIngrPacienteB.setSelectedItem((short)fechaHoy.getDayOfMonth());

        }


        if(componente == btnGuardarM){

            if(validacion(cajaNombrePacienteM, cajaApePatPacienteM, cajaApeMatPAcienteM, cajaCalleNumeroPacienteM, cajaColoniaPacienteM, cajaCPPacienteM, cajaEstadoPacienteM, cajaTelefonoPacienteM, comboEstadoCivilPacienteM)){

                String mes = comboMesNacPacienteM.getSelectedItem().toString();

                String dia = comboDiaNacPacienteM.getSelectedItem().toString();

                if(mes.length() == 1){

                    mes = "0" + mes;

                }

                if(dia.length() == 1){

                    dia = "0" + dia;

                }

                String mes2 = comboMesIngrPacienteM.getSelectedItem().toString();

                String dia2 = comboDiaIngrPacienteM.getSelectedItem().toString();

                if(mes2.length() == 1){

                    mes2 = "0" + mes2;

                }

                if(dia2.length() == 1){

                    dia2 = "0" + dia2;

                }

                String fechaNac = comboAñoNacPacienteM.getSelectedItem() + "-" + mes + "-" + dia;

                String fechaIngreso = comboAñoIngrPacienteM.getSelectedItem() + "-" + mes2 + "-" + dia2;

                String sexo = "";

                if(radioHombreM.isSelected()){

                    sexo = "Hombre";

                }

                if(radioMujerM.isSelected()){

                    sexo = "Mujer";

                }

                if(radioNoBinarioM.isSelected()){

                    sexo = "No binario";

                }

                Paciente paciente = new Paciente(

                        cajaNumPacienteM.getText().toString(),

                        cajaNombrePacienteM.getText().toString(),

                        cajaApePatPacienteM.getText().toString(),

                        cajaApeMatPAcienteM.getText().toString(),

                        cajaCalleNumeroPacienteM.getText().toString(),

                        cajaColoniaPacienteM.getText().toString(),

                        cajaCPPacienteM.getText().toString(),

                        cajaEstadoPacienteM.getText().toString(),

                        cajaTelefonoPacienteM.getText().toString(),

                        fechaNac,

                        sexo,

                        comboEstadoCivilPacienteM.getSelectedItem().toString(),

                        fechaIngreso

                );

                int respuesta = JOptionPane.showConfirmDialog(this, "¿Quieres guardar los cambios?");

                if(respuesta == JOptionPane.YES_OPTION){

                    if(pacienteDAO.editarPaciente(paciente)){

                        actualizarTabla(tablaC);

                        JOptionPane.showMessageDialog(this, "Registro modificado correctamente");

                    }else{

                        JOptionPane.showMessageDialog(this, "Error en la modificacion");

                    }


                }

            }





        }

        if(componente == btnBuscarM){

            String sql = "SELECT * FROM Pacientes WHERE Num_Paciente = ?";

            ResultSet rs = con.ejecutarInstruccionSQL(sql, cajaNumPacienteM.getText());

            try {

                rs.next();

                cajaNombrePacienteM.setText(rs.getString(2));

                cajaApePatPacienteM.setText(rs.getString(3));

                cajaApeMatPAcienteM.setText(rs.getString(4));

                cajaCalleNumeroPacienteM.setText(rs.getString(5));

                cajaColoniaPacienteM.setText(rs.getString(6));

                cajaCPPacienteM.setText(rs.getString(7));

                cajaEstadoPacienteM.setText(rs.getString(8));

                cajaTelefonoPacienteM.setText(rs.getString(9));

                String fechaNac = rs.getString(10);

                String [] partesFechaNac = fechaNac.split("-");

                comboAñoNacPacienteM.setSelectedItem(Short.parseShort(partesFechaNac[0]));

                comboMesNacPacienteM.setSelectedItem(Short.parseShort(partesFechaNac[1]));

                comboDiaNacPacienteM.setSelectedItem(Short.parseShort(partesFechaNac[2]));

                String sexo = rs.getString(11);

                if(sexo.equals("Hombre")){

                    radioHombreM.setSelected(true);

                }

                if(sexo.equals("Mujer")){

                    radioMujerM.setSelected(true);

                }

                if(sexo.equals("No binario")){

                    radioNoBinarioM.setSelected(true);

                }

                comboEstadoCivilPacienteM.setSelectedItem(String.valueOf(rs.getString(12)));

                String fechaIngreso = rs.getString(10);

                String [] partesFechaIngreso = fechaIngreso.split("-");

                comboAñoIngrPacienteM.setSelectedItem(Short.parseShort(partesFechaIngreso[0]));

                comboMesIngrPacienteM.setSelectedItem(Short.parseShort(partesFechaIngreso[1]));

                comboDiaIngrPacienteM.setSelectedItem(Short.parseShort(partesFechaIngreso[2]));

            } catch (SQLException er) {

                throw new RuntimeException(er);

            }

        }

        if(componente == btnRestaurarM){

            restablecer(cajaNumPacienteM, cajaNombrePacienteM, cajaApePatPacienteM, cajaApeMatPAcienteM, cajaCalleNumeroPacienteM, cajaColoniaPacienteM, cajaCPPacienteM, cajaEstadoPacienteM, cajaTelefonoPacienteM, comboDiaNacPacienteM, comboMesNacPacienteM, comboAñoNacPacienteM, comboDiaIngrPacienteM, comboMesIngrPacienteM, comboAñoIngrPacienteM, comboEstadoCivilPacienteM, radioHombreM);

        }

        if(componente == btnCancelarM){

            int respuesta = JOptionPane.showConfirmDialog(this, "¿Quieres salir?, si no has guardado los cambios se perderan");

            if(respuesta == JOptionPane.YES_OPTION){

                internalCambiosPa.setVisible(false);

                restablecer(cajaNumPacienteM, cajaNombrePacienteM, cajaApePatPacienteM, cajaApeMatPAcienteM, cajaCalleNumeroPacienteM, cajaColoniaPacienteM, cajaCPPacienteM, cajaEstadoPacienteM, cajaTelefonoPacienteM,  comboEstadoCivilPacienteM, radioHombreM, radioMujerM, radioNoBinarioM);

                comboAñoNacPacienteM.setSelectedItem((short)fechaHoy.getYear());

                comboMesNacPacienteM.setSelectedItem((short)fechaHoy.getMonthValue());

                comboDiaNacPacienteM.setSelectedItem((short)fechaHoy.getDayOfMonth());

                comboAñoIngrPacienteM.setSelectedItem((short)fechaHoy.getYear());

                comboMesIngrPacienteM.setSelectedItem((short)fechaHoy.getMonthValue());

                comboDiaIngrPacienteM.setSelectedItem((short)fechaHoy.getDayOfMonth());

            }



        }

        if(componente == btnBuscarC){

            if(radioTodos.isSelected()){

                actualizarTabla(tablaC);

            }else{

                actualizarTablaFiltro(tablaC);

            }


        }

        if(componente == btnRestaurarC){

            restablecer(cajaNombrePacienteC, cajaApePatPacienteC, cajaApeMatPAcienteC, cajaColoniaPacienteC, cajaCPPacienteC, cajaEstadoPacienteC, comboEstadoCivilPacienteC, radioHombreC);

        }

        if(componente == btnCancelarC){

            internalConsultasPa.setVisible(false);

            restablecer(cajaNombrePacienteC, cajaApePatPacienteC, cajaApeMatPAcienteC, cajaColoniaPacienteC, cajaCPPacienteC, cajaEstadoPacienteC, comboEstadoCivilPacienteC, radioHombreC, radioMujerC, radioNoBinarioC);


        }

        Component[] componentes = panelConsultasPa.getComponents();

        int j = 0;

        for (Component comp : componentes) {


            if(comp instanceof JRadioButton){

                if(comp == radiosConsultas.get(j)){

                    comp.setEnabled(true);

                    j++;

                }else{

                    comp.setEnabled(false);

                }

            }else if(comp instanceof JButton){

                comp.setEnabled(true);

            }else{

                comp.setEnabled(false);

            }

        }

        if (componente == radionombre || radionombre.isSelected()) {

            cajaNombrePacienteC.setEnabled(true);

        } else if (componente == radioApePat || radioApePat.isSelected()) {

            cajaApePatPacienteC.setEnabled(true);

        } else if (componente == radioApeMat || radioApeMat.isSelected()) {

            cajaApeMatPAcienteC.setEnabled(true);

        } else if (componente == radioColonia || radioColonia.isSelected()) {

            cajaColoniaPacienteC.setEnabled(true);

        } else if (componente == radioCP || radioCP.isSelected()) {

            cajaCPPacienteC.setEnabled(true);

        } else if (componente == radioEstado || radioEstado.isSelected()) {

            cajaEstadoPacienteC.setEnabled(true);

        }else if (componente == radioEstadoCivil || radioEstadoCivil.isSelected()) {

            comboEstadoCivilPacienteC.setEnabled(true);

        }else if(componente == radioSexo || radioSexo.isSelected()){

            radioHombreC.setEnabled(true);

            radioMujerC.setEnabled(true);

            radioNoBinarioC.setEnabled(true);

        }else if(componente == radioFechaIngreso || radioFechaIngreso.isSelected()){

            comboDiaIngrPacienteC.setEnabled(true);

            comboMesIngrPacienteC.setEnabled(true);

            comboAñoIngrPacienteC.setEnabled(true);

        }else if(componente == radioFechaNac || radioFechaNac.isSelected()){

            comboDiaNacPacienteC.setEnabled(true);

            comboMesNacPacienteC.setEnabled(true);

            comboAñoNacPacienteC.setEnabled(true);

        }else if(componente == radioTodos || radioTodos.isSelected()){

            actualizarTabla(tablaC);

        }

        if(componente == altasDoctores || componente == altasTrabajadores || componente == bajasDoctores || componente == bajasTrabajadores || componente == cambiosDoctores || componente == cambiosTrabajadores || componente == consultasDoctores || componente == consultasTrabajadores){

            internalAltasPa.setVisible(false);

            internalBajasPa.setVisible(false);

            internalCambiosPa.setVisible(false);

            internalConsultasPa.setVisible(false);

            internalTrabajando.setVisible(true);

        }

        if(componente == altasPacientes){

            internalCambiosPa.setVisible(false);

            internalBajasPa.setVisible(false);

            internalConsultasPa.setVisible(false);

            internalTrabajando.setVisible(false);

            internalAltasPa.setVisible(true);

        }

        if(componente == bajasPacientes){

            internalAltasPa.setVisible(false);

            internalBajasPa.setVisible(false);

            internalConsultasPa.setVisible(false);

            internalTrabajando.setVisible(false);

            internalBajasPa.setVisible(true);


        }

        if(componente == cambiosPacientes){

            internalAltasPa.setVisible(false);

            internalBajasPa.setVisible(false);

            internalConsultasPa.setVisible(false);

            internalTrabajando.setVisible(false);

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

        if(componente == comboMesNacPacienteM){

            short mesSeleccionado = Short.parseShort(comboMesNacPacienteM.getSelectedItem().toString());

            if(mesSeleccionado == 1 || mesSeleccionado == 3 || mesSeleccionado == 5 || mesSeleccionado == 7 || mesSeleccionado == 8 || mesSeleccionado == 10 || mesSeleccionado == 12){

                numDias = 31;

            } else if (mesSeleccionado == 2) {

                short año = Short.parseShort(comboAñoNacPacienteM.getSelectedItem().toString());

                if ((año % 4 == 0 && año % 100 != 0) || (año % 100 == 0 && año % 400 == 0)){

                    numDias = 29;

                }else{

                    numDias = 28;

                }

            }else {

                numDias = 30;

            }

            comboDiaNacPacienteM.removeAllItems();

            for(int i = 1; i <= numDias; i++){

                comboDiaNacPacienteM.addItem((short)i);

            }

        }

        if(componente == comboMesIngrPacienteM){

            short mesSeleccionado = Short.parseShort(comboMesIngrPacienteM.getSelectedItem().toString());

            if(mesSeleccionado == 1 || mesSeleccionado == 3 || mesSeleccionado == 5 || mesSeleccionado == 7 || mesSeleccionado == 8 || mesSeleccionado == 10 || mesSeleccionado == 12){

                numDias = 31;

            } else if (mesSeleccionado == 2) {

                short año = Short.parseShort(comboAñoIngrPacienteM.getSelectedItem().toString());

                if ((año % 4 == 0 && año % 100 != 0) || (año % 100 == 0 && año % 400 == 0)){

                    numDias = 29;

                }else{

                    numDias = 28;

                }

            }else {

                numDias = 30;

            }

            comboDiaIngrPacienteM.removeAllItems();

            for(int i = 1; i <= numDias; i++){

                comboDiaIngrPacienteM.addItem((short)i);

            }

        }

        if(componente == comboMesNacPacienteC){

            short mesSeleccionado = Short.parseShort(comboMesNacPacienteC.getSelectedItem().toString());

            if(mesSeleccionado == 1 || mesSeleccionado == 3 || mesSeleccionado == 5 || mesSeleccionado == 7 || mesSeleccionado == 8 || mesSeleccionado == 10 || mesSeleccionado == 12){

                numDias = 31;

            } else if (mesSeleccionado == 2) {

                short año = Short.parseShort(comboAñoNacPacienteC.getSelectedItem().toString());

                if ((año % 4 == 0 && año % 100 != 0) || (año % 100 == 0 && año % 400 == 0)){

                    numDias = 29;

                }else{

                    numDias = 28;

                }

            }else {

                numDias = 30;

            }

            comboDiaNacPacienteC.removeAllItems();

            for(int i = 1; i <= numDias; i++){

                comboDiaNacPacienteC.addItem((short)i);

            }

        }

        if(componente == comboMesIngrPacienteC){

            short mesSeleccionado = Short.parseShort(comboMesIngrPacienteC.getSelectedItem().toString());

            if(mesSeleccionado == 1 || mesSeleccionado == 3 || mesSeleccionado == 5 || mesSeleccionado == 7 || mesSeleccionado == 8 || mesSeleccionado == 10 || mesSeleccionado == 12){

                numDias = 31;

            } else if (mesSeleccionado == 2) {

                short año = Short.parseShort(comboAñoIngrPacienteC.getSelectedItem().toString());

                if ((año % 4 == 0 && año % 100 != 0) || (año % 100 == 0 && año % 400 == 0)){

                    numDias = 29;

                }else{

                    numDias = 28;

                }

            }else {

                numDias = 30;

            }

            comboDiaIngrPacienteC.removeAllItems();

            for(int i = 1; i <= numDias; i++){

                comboDiaIngrPacienteC.addItem((short)i);

            }

        }

        if(componente == consultasPacientes){

            internalAltasPa.setVisible(false);

            internalBajasPa.setVisible(false);

            internalCambiosPa.setVisible(false);

            internalTrabajando.setVisible(false);

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

    public void actualizarTablaFiltro(JTable tabla) {

        new Thread(() -> {

            String consultaBase = "SELECT * FROM Pacientes";

            String condicion = "";

            Object valor = null;

            if (radionombre.isSelected()) {

                condicion = " WHERE Nombre = ?";

                valor = cajaNombrePacienteC.getText();

            } else if (radioApePat.isSelected()) {

                condicion = " WHERE Apellido_Paterno = ?";

                valor = cajaApePatPacienteC.getText();

            } else if (radioApeMat.isSelected()) {

                condicion = " WHERE Apellido_Materno = ?";

                valor = cajaApeMatPAcienteC.getText();

            } else if (radioColonia.isSelected()) {

                condicion = " WHERE Colonia = ?";

                valor = cajaColoniaPacienteC.getText();

            } else if (radioCP.isSelected()) {

                condicion = " WHERE Codigo_Postal = ?";

                valor = cajaCPPacienteC.getText();

            } else if (radioEstado.isSelected()) {

                condicion = " WHERE Estado = ?";

                valor = cajaEstadoPacienteC.getText();

            } else if (radioSexo.isSelected()) {

                if (radioHombreC.isSelected()) {

                    valor = "Hombre";

                } else if (radioMujerC.isSelected()) {

                    valor = "Mujer";

                } else if (radioNoBinarioC.isSelected()) {

                    valor = "No binario";

                }

                condicion = " WHERE Sexo = ?";

            } else if (radioEstadoCivil.isSelected()) {

                condicion = " WHERE Estado_Civil = ?";

                valor = comboEstadoCivilPacienteC.getSelectedItem().toString();

            } else if (radioFechaNac.isSelected()) {

                String mes = comboMesNacPacienteC.getSelectedItem().toString();

                String dia = comboDiaNacPacienteC.getSelectedItem().toString();

                if (mes.length() == 1){

                    mes = "0" + mes;

                }

                if (dia.length() == 1){

                    dia = "0" + dia;

                }

                valor = comboAñoNacPacienteC.getSelectedItem() + "-" + mes + "-" + dia;

                condicion = " WHERE Fecha_Nacimieto = ?";

            } else if (radioFechaIngreso.isSelected()) {

                String mes = comboMesIngrPacienteC.getSelectedItem().toString();

                String dia = comboDiaIngrPacienteC.getSelectedItem().toString();

                if (mes.length() == 1){

                    mes = "0" + mes;

                }

                if (dia.length() == 1){

                    dia = "0" + dia;

                }

                valor = comboAñoIngrPacienteC.getSelectedItem() + "-" + mes + "-" + dia;

                condicion = " WHERE Fecha_Ingreso = ?";

            }

            String consultaFinal = consultaBase + condicion;

            try {

                Connection con = ConexionBD.getInstancia().getConexion();

                PreparedStatement ps = con.prepareStatement(consultaFinal);

                if (valor != null) {

                    ps.setObject(1, valor);

                }

                ResultSet rs = ps.executeQuery();

                ResultSetMetaData meta = rs.getMetaData();

                int columnas = meta.getColumnCount();

                DefaultTableModel modelo = new DefaultTableModel();

                for (int i = 1; i <= columnas; i++) {

                    modelo.addColumn(meta.getColumnName(i));

                }

                while (rs.next()) {

                    Object[] fila = new Object[columnas];

                    for (int i = 1; i <= columnas; i++) {

                        fila[i - 1] = rs.getObject(i);

                    }

                    modelo.addRow(fila);

                }

                tabla.setModel(modelo);

            } catch (SQLException e) {

                JOptionPane.showMessageDialog(this, "Error al cargar los datos");

            }

        }).start();

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getSource() == cajaNumPaciente || e.getSource() == cajaNumPacienteB || e.getSource() == cajaNumPacienteM || e.getSource() == cajaNumPacienteC){

            if((e.getKeyCode() >= 48 && e.getKeyCode() <= 57) || e.getKeyCode() == 8 || e.getKeyCode() == 20 || e.getKeyCode() == 16 || e.getKeyCode() == 17 || e.getKeyCode() == 18){



            }else{

                JOptionPane.showMessageDialog(this, "Solo puedes ingresar numeros");

                cajaNumPaciente.setText("");

                cajaNumPacienteB.setText("");

                cajaNumPacienteM.setText("");

                //cajaNumPacienteC.setText("");


            }

        }


        if(e.getSource() == cajaNombrePaciente || e.getSource() == cajaApePatPaciente || e.getSource() == cajaApeMatPAciente || e.getSource() == cajaEstadoPaciente){

            if((e.getKeyCode() >= 65 && e.getKeyCode() <= 90) || (e.getKeyCode() >= 97 && e.getKeyCode() <= 122) || e.getKeyCode() == 32 || e.getKeyCode() == 8 || e.getKeyCode() == 20 || e.getKeyCode() == 16 || e.getKeyCode() == 17 || e.getKeyCode() == 18){



            }else{

                JOptionPane.showMessageDialog(this, "Solo puedes ingresar letras: ");

                if(e.getSource() == cajaNombrePaciente){

                    cajaNombrePaciente.setText("");

                }

                if(e.getSource() == cajaApePatPaciente){

                    cajaApePatPaciente.setText("");

                }

                if(e.getSource() == cajaApeMatPAciente){

                    cajaApeMatPAciente.setText("");

                }

                if(e.getSource() == cajaEstadoPaciente){

                    cajaEstadoPaciente.setText("");

                }

            }

        }

        if(e.getSource() == cajaNombrePacienteB || e.getSource() == cajaApePatPacienteB || e.getSource() == cajaApeMatPAcienteB || e.getSource() == cajaEstadoPacienteB){

            if((e.getKeyCode() >= 65 && e.getKeyCode() <= 90) || (e.getKeyCode() >= 97 && e.getKeyCode() <= 122) || e.getKeyCode() == 32 || e.getKeyCode() == 8 || e.getKeyCode() == 20 || e.getKeyCode() == 16 || e.getKeyCode() == 17 || e.getKeyCode() == 18){



            }else{

                JOptionPane.showMessageDialog(this, "Solo puedes ingresar letras: ");

                if(e.getSource() == cajaNombrePacienteB){

                    cajaNombrePacienteB.setText("");

                }

                if(e.getSource() == cajaApePatPacienteB){

                    cajaApePatPacienteB.setText("");

                }

                if(e.getSource() == cajaApeMatPAcienteB){

                    cajaApeMatPAcienteB.setText("");

                }

                if(e.getSource() == cajaEstadoPacienteB){

                    cajaEstadoPacienteB.setText("");

                }

            }

        }

        if(e.getSource() == cajaNombrePacienteM || e.getSource() == cajaApePatPacienteM || e.getSource() == cajaApeMatPAcienteM || e.getSource() == cajaEstadoPacienteM){

            if((e.getKeyCode() >= 65 && e.getKeyCode() <= 90) || (e.getKeyCode() >= 97 && e.getKeyCode() <= 122) || e.getKeyCode() == 32 || e.getKeyCode() == 8 || e.getKeyCode() == 20 || e.getKeyCode() == 16 || e.getKeyCode() == 17 || e.getKeyCode() == 18){



            }else{

                JOptionPane.showMessageDialog(this, "Solo puedes ingresar letras: ");

                if(e.getSource() == cajaNombrePacienteM){

                    cajaNombrePacienteM.setText("");

                }

                if(e.getSource() == cajaApePatPacienteM){

                    cajaApePatPacienteM.setText("");

                }

                if(e.getSource() == cajaApeMatPAcienteM){

                    cajaApeMatPAcienteM.setText("");

                }

                if(e.getSource() == cajaEstadoPacienteM){

                    cajaEstadoPacienteM.setText("");

                }

            }

        }

        if(e.getSource() == cajaNombrePacienteC || e.getSource() == cajaApePatPacienteC || e.getSource() == cajaApeMatPAcienteC || e.getSource() == cajaEstadoPacienteC){

            if((e.getKeyCode() >= 65 && e.getKeyCode() <= 90) || (e.getKeyCode() >= 97 && e.getKeyCode() <= 122) || e.getKeyCode() == 32 || e.getKeyCode() == 8 || e.getKeyCode() == 20 || e.getKeyCode() == 16 || e.getKeyCode() == 17 || e.getKeyCode() == 18){



            }else{

                JOptionPane.showMessageDialog(this, "Solo puedes ingresar letras: ");

                if(e.getSource() == cajaNombrePacienteC){

                    cajaNombrePacienteC.setText("");

                }

                if(e.getSource() == cajaApePatPacienteC){

                    cajaApePatPacienteC.setText("");

                }

                if(e.getSource() == cajaApeMatPAcienteC){

                    cajaApeMatPAcienteC.setText("");

                }

                if(e.getSource() == cajaEstadoPacienteC){

                    cajaEstadoPacienteC.setText("");

                }

            }

        }


        if(e.getSource() == cajaCPPaciente || e.getSource() == cajaTelefonoPaciente ){

            if((e.getKeyCode() >= 48 && e.getKeyCode() <= 57) || e.getKeyCode() == 8 || e.getKeyCode() == 20 || e.getKeyCode() == 16 || e.getKeyCode() == 17 || e.getKeyCode() == 18){



            }else{

                JOptionPane.showMessageDialog(this, "Solo puedes ingresar numeros");

                if(e.getSource() == cajaCPPaciente){

                    cajaCPPaciente.setText("");

                }

                if(e.getSource() == cajaTelefonoPaciente){

                    cajaTelefonoPaciente.setText("");

                }


            }

        }

        if(e.getSource() == cajaCPPacienteM || e.getSource() == cajaTelefonoPacienteM ){

            if((e.getKeyCode() >= 48 && e.getKeyCode() <= 57) || e.getKeyCode() == 8 || e.getKeyCode() == 20 || e.getKeyCode() == 16 || e.getKeyCode() == 17 || e.getKeyCode() == 18){



            }else{

                JOptionPane.showMessageDialog(this, "Solo puedes ingresar numeros");

                if(e.getSource() == cajaCPPacienteM){

                    cajaCPPacienteM.setText("");

                }

                if(e.getSource() == cajaTelefonoPacienteM){

                    cajaTelefonoPacienteM.setText("");

                }


            }

        }

        if(e.getSource() == cajaCPPacienteC ){

            if((e.getKeyCode() >= 48 && e.getKeyCode() <= 57) || e.getKeyCode() == 8 || e.getKeyCode() == 20 || e.getKeyCode() == 16 || e.getKeyCode() == 17 || e.getKeyCode() == 18){



            }else{

                JOptionPane.showMessageDialog(this, "Solo puedes ingresar numeros");

                if(e.getSource() == cajaCPPacienteC){

                    cajaCPPacienteC.setText("");

                }


            }

        }


    }
}


