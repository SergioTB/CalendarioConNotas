/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Sergio Tineo
 */
public class Controlador implements ActionListener{
    
    private Ventana ventana;
    private Date date = null;
    
    public Controlador(Ventana v){
        ventana = v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("BUSCAR")){
            
            crearFecha();
            mostrarNotas();

        }else if(e.getActionCommand().equals("SIGUIENTE")){
            
                date.increment();
                ventana.setAnyo(Integer.toString(date.getY().getYear()));
                ventana.setMes(Integer.toString(date.getM().getMonth()));
                ventana.setDia(Integer.toString(date.getD().getDay()));
                mostrarNotas();

        }else if(e.getActionCommand().equals("AGREGAR")){
            
                BuscarNotas notas = new BuscarNotas(date);
                notas.agregarLinea(ventana.getTexto());
                mostrarNotas();
                ventana.resetTexto2();
            
        }
    }
    
    public void mostrarNotas(){
        ventana.resetTexto();

                BuscarNotas notas = new BuscarNotas(date);
                notas.leerFichero();
                if(notas.getLista() != null){
                    for(String str : notas.getLista()){
                        ventana.setTexto(str + "\n");
                    }
                }
        
    }
    
    public void crearFecha(){
                    Year y = new Year(Integer.parseInt(ventana.getAnyo()));
                    Month m = new Month(Integer.parseInt(ventana.getMes()), y);
                    Day d = new Day(Integer.parseInt(ventana.getDia()), m);
                    date = new Date(d, m, y);
                
    }
    
}
