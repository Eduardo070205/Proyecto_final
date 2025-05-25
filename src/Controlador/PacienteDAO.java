package Controlador;

import ConexionBD.ConexionBD;
import Modelo.Paciente;

import java.sql.Connection;

public class PacienteDAO {

    ConexionBD con = ConexionBD.getInstancia();


    //=========================== ALTAS ============================


    public boolean agregarPaciente(Paciente paciente){

        String sql = "INSERT INTO Pacientes VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        return con.ejecutarInstruccionLMD(sql, paciente.getNumPaciente(), paciente.getNombre(), paciente.getApePat(), paciente.getApeMat(), paciente.getCalleNumero(), paciente.getColonia(), paciente.getCp(), paciente.getEstado(), paciente.getTelefono(), paciente.getFechaNac(), paciente.getSexo(), paciente.getEstadoCivil(), paciente.getFechaIngreso());

    }

    //================================== BAJAS ===============================

    public boolean elimniarPaciente(String numPaciente){
        
        String sql = "DELETE FROM Pacientes WHERE Num_Paciente = ?";

        return con.ejecutarInstruccionLMD(sql, numPaciente);

    }


}
