import Ventanas.VentanaLogin;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() { //Siemnpre agregar ese codigo

            @Override
            public void run() {

                new VentanaLogin();

            }
        });

    }

}
