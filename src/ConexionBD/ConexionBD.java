package ConexionBD;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ConexionBD {

    private static ConexionBD instancia;

    private Connection conexion;

    private PreparedStatement pstm;

    private ResultSet rs;

    String mensaje;

    private ConexionBD() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String URL = "jdbc:mysql://localhost:3306/BD_Hospital_Topicos_Proyecto_Final";

            conexion = DriverManager.getConnection(URL, "root", "Eduardo10");

            System.out.println("Casi soy ingeniero inmortal");

        } catch (ClassNotFoundException e) {

            System.out.println("Error en el conector o Driver");

            throw new RuntimeException(e);

        } catch (SQLException e) {

            System.out.println("Error en la conexion a MySQL");

            throw new RuntimeException(e);

        }

    }

    public static ConexionBD getInstancia() {

        if (instancia == null) {

            instancia = new ConexionBD();

        }

        return instancia;

    }

    public Connection getConexion() {

        return conexion;

    }

    public boolean ejecutarInstruccionLMD(String sql, Object... parametros){

        boolean res = false;

        try {

            pstm = conexion.prepareStatement(sql);

            for (int i = 0; i < parametros.length; i++) {

                pstm.setObject(i + 1, parametros[i]);

            }

            if(pstm.executeUpdate() >= 1){
                res = true;
            }

        } catch (SQLException e) {

            if (e instanceof SQLIntegrityConstraintViolationException) {

                mensaje = "Error, Número de paciente repetido";

            }

            System.out.println("Error en la ejecucion de la instruccion SQL jajajaja");
        }

        return res;

    }

    public void mostrarError(Component padre) {

        JOptionPane.showMessageDialog(padre, mensaje, "Error", JOptionPane.ERROR_MESSAGE);

    }

    public ResultSet ejecutarInstruccionSQL(String sql, Object... parametros){

        rs = null;

        try {

            pstm = conexion.prepareStatement(sql);

            for (int i = 0; i < parametros.length; i++) {

                pstm.setObject(i + 1, parametros[i]);

            }

            rs = pstm.executeQuery();

        } catch (SQLException e) {

            System.out.println("Error en la ejecucion de la instruccion SQL");

        }

        return rs;

    }


    public static void main(String[] arg){

        System.out.println("Magia magia con INTELLIJ");

        new ConexionBD();

    }

}
