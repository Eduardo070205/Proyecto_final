package Controlador;

import ConexionBD.ConexionBD;
import Modelo.Paciente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PacienteDAO {

    ConexionBD con = ConexionBD.getInstancia();


    //=========================== ALTAS ============================


    public boolean agregarPaciente(Paciente paciente){

        String sql = "INSERT INTO Pacientes(Num_Paciente , Nombre , Apellido_Paterno , Apellido_Materno , Calle_Numero , Colonia , Codigo_Postal , Estado , Telefono , Fecha_Nacimieto , Sexo , Estado_Civil , Fecha_Ingreso ) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        return con.ejecutarInstruccionLMD(sql,

                paciente.getNumPaciente(),

                paciente.getNombre(),

                paciente.getApePat(),

                paciente.getApeMat(),

                paciente.getCalleNumero(),

                paciente.getColonia(),

                paciente.getCp(),

                paciente.getEstado(),

                paciente.getTelefono(),

                paciente.getFechaNac(),

                paciente.getSexo(),

                paciente.getEstadoCivil(),

                paciente.getFechaIngreso()
        );

    }

    //================================== BAJAS ===============================

    public boolean elimniarPaciente(String numPaciente){

        String sql = "DELETE FROM Pacientes WHERE Num_Paciente = ?";

        return con.ejecutarInstruccionLMD(sql, numPaciente);

    }

    public boolean editarPaciente(Paciente paciente){

        String sql = "UPDATE Pacientes SET Nombre = ?, Apellido_Paterno = ?, Apellido_Materno = ?, Calle_Numero = ?, Colonia = ?, Codigo_Postal = ?, Estado = ?, Telefono = ?, Fecha_Nacimieto = ?, Sexo = ?, Estado_Civil = ?, Fecha_Ingreso = ? WHERE Num_Paciente = ?";

        return con.ejecutarInstruccionLMD(sql,

                paciente.getNombre(),

                paciente.getApePat(),

                paciente.getApeMat(),

                paciente.getCalleNumero(),

                paciente.getColonia(),

                paciente.getCp(),

                paciente.getEstado(),

                paciente.getTelefono(),

                paciente.getFechaNac(),

                paciente.getSexo(),

                paciente.getEstadoCivil(),

                paciente.getFechaIngreso(),

                paciente.getNumPaciente()
        );

    }




}
