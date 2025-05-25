package ConexionBD;

import java.sql.*;

public class ConexionBD {

    private Connection conexion;

    private PreparedStatement pstm;

    private ResultSet rs;

    public ConexionBD() {

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

    public static void main(String[] arg){

        System.out.println("Magia magia con INTELLIJ");

        new ConexionBD();

    }

}
