/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version1;

/**
 *
 * @author Sergio Tineo
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Ventana vista = new Ventana();
        Controlador ctr = new Controlador(vista);
        vista.setControlador(ctr);
        vista.setVisible(true);
    }
    
}
