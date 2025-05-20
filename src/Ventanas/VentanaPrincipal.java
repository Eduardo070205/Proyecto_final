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

    JButton btnAjustes, btnSesion, btnRecargar;

    JTextField cajaNumPaciente, cajaNombrePaciente, cajaApePatPaciente, cajaApeMatPAciente, cajaCalleNumeroPaciente, cajaColoniaPaciente, cajaCPPaciente, cajaEstadoPaciente, cajaTelefono;

    JComboBox<Short> comboDiaNacPaciente, comboMesNacPaciente, comboAñoNacPaciente, comboDiaIngrPaciente, comboMesIngrPaciente, comboAñoIngrPaciente;

    JComboBox<String>comboSexoPaciente, comboEstadoCivilPaciente;

    JPanel panelAltasPa;

    public  VentanaPrincipal(){

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

        btnAjustes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                getContentPane().setBackground(Color.darkGray);

            }
        });

        toolbar.add(btnAjustes);

        asignarPosicion(toolbar, 0, 0, 1200, 30);

        JDesktopPane desktopPaneInternals = new JDesktopPane();

        internalAltasPa = new JInternalFrame();

        internalAltasPa.setSize(900, 800);

        internalAltasPa.setDefaultCloseOperation(HIDE_ON_CLOSE);

        panelAltasPa = new JPanel();

        panelAltasPa.setLayout(null);

        JLabel txtNumPaciente = new JLabel("Numero de Paciente:");

        agregarAlPanel(txtNumPaciente, panelAltasPa, 10, 20, 150, 20);

        cajaNumPaciente = new JTextField();

        agregarAlPanel(cajaNumPaciente, panelAltasPa,160, 20, 100, 20);

        JLabel txtNombrePaciente = new JLabel("Nombre:");

        agregarAlPanel(txtNombrePaciente, panelAltasPa, 10, 50, 60, 20);

        cajaNombrePaciente = new JTextField();

        agregarAlPanel(cajaNombrePaciente, panelAltasPa, 70, 50, 150, 20);

        JLabel txtApePatPaciente = new JLabel("Apellido Paterno:");

        agregarAlPanel(txtApePatPaciente, panelAltasPa, 220, 50, 100, 20);

        cajaApePatPaciente = new JTextField();

        agregarAlPanel(cajaApePatPaciente, panelAltasPa, 320, 50, 150, 20);

        JLabel txtApeMatPaciente = new JLabel("Apellido Materno:");

        agregarAlPanel(txtApeMatPaciente, panelAltasPa, 480, 50, 100, 20);

        cajaApeMatPAciente = new JTextField();

        agregarAlPanel(cajaApeMatPAciente, panelAltasPa, 580, 50, 150, 20);

        JLabel txtCallePaciente = new JLabel("Calle y Número del Paciente:");

        agregarAlPanel(txtCallePaciente, panelAltasPa, 10, 80, 170, 20);

        cajaCalleNumeroPaciente = new JTextField();

        agregarAlPanel(cajaCalleNumeroPaciente, panelAltasPa, 180, 80, 150, 20);

        JLabel txtColoniaPaciente = new JLabel("Colonia:");

        agregarAlPanel(txtColoniaPaciente, panelAltasPa, 340, 80, 60, 20);

        cajaColoniaPaciente = new JTextField();

        agregarAlPanel(cajaColoniaPaciente, panelAltasPa, 400, 80, 100, 20);

        JLabel txtxCPPaciente = new JLabel("Código Postal:");

        agregarAlPanel(txtxCPPaciente, panelAltasPa, 510, 80, 100, 20);

        cajaCPPaciente = new JTextField();

        agregarAlPanel(cajaCPPaciente, panelAltasPa, 610, 80, 50, 20);

        JLabel txtEstadoPaciente = new JLabel("Estado:");

        agregarAlPanel(txtEstadoPaciente, panelAltasPa, 670, 80, 60, 20);

        cajaEstadoPaciente = new JTextField();

        agregarAlPanel(cajaEstadoPaciente, panelAltasPa, 730, 80, 100, 20);


        panelAltasPa.setBounds(0,0,900, 800);

        internalAltasPa.add(panelAltasPa);

        internalAltasPa.setTitle("Altas");

        caracteristicasInternal(internalAltasPa);

        desktopPaneInternals.add(internalAltasPa);

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
