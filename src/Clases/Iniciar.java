/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import static java.awt.Frame.MAXIMIZED_BOTH;
import java.sql.SQLException;
import javax.swing.JFrame;
import Formularios.Menu;

/**
 *
 * @author juan
 */
public class Iniciar extends JFrame{
    public static void main(String[] args) throws SQLException {
        Menu m = new Menu();m.setVisible(true); m.setExtendedState(MAXIMIZED_BOTH);
        m.setLocationRelativeTo(null);
//       JOptionPane.showMessageDialog(null, m);
       /* JFrame m = new JFrame();
        Prueba c = new Prueba();
        m.add(c); m.setVisible(true);m.setSize(780, 600); m.setResizable(false);
     m.setLocationRelativeTo(null);*/
    }
}
