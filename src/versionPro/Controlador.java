/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package versionPro;

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
            crearFecha();
            if(date != null){
                date.increment();
                ventana.setAnyo(Integer.toString(date.getY().getYear()));
                ventana.setMes(Integer.toString(date.getM().getMonth()));
                ventana.setDia(Integer.toString(date.getD().getDay()));
                mostrarNotas();
            }else{
                JOptionPane.showMessageDialog(null, "No se introdujo fecha", "Error",JOptionPane.ERROR_MESSAGE);
            }
        }else if(e.getActionCommand().equals("AGREGAR")){
            crearFecha();
            if(date != null){
                BuscarNotas notas = new BuscarNotas(date);
                notas.agregarLinea(ventana.getTexto());
                mostrarNotas();
                ventana.resetTexto2();
            }
        }
    }
    
    private void mostrarNotas(){
        ventana.resetTexto();
        if(date != null){
                BuscarNotas notas = new BuscarNotas(date);
                notas.leerFichero();
                if(notas.getLista() != null && !notas.getLista().isEmpty()){
                    for(String str : notas.getLista()){
                        ventana.setTexto(str + "\n");
                    }
                }
        } 
    }
    
    private void crearFecha(){
             if(!ventana.getAnyo().equals("") && !ventana.getDia().equals("") && !ventana.getMes().equals("")){
                try{
                    if(Integer.parseInt(ventana.getAnyo()) > 0 && Integer.parseInt(ventana.getMes()) > 0 && Integer.parseInt(ventana.getDia()) > 0){
                        Year y = new Year(Integer.parseInt(ventana.getAnyo()));
                        if(Integer.parseInt(ventana.getMes()) <= 12){
                            Month m = new Month(Integer.parseInt(ventana.getMes()), y);
                            if(Integer.parseInt(ventana.getDia()) <= m.getMonthSize()){
                                Day d = new Day(Integer.parseInt(ventana.getDia()), m);
                                date = new Date(d, m, y);
                            }else{
                                y = null;
                                m = null;
                                JOptionPane.showMessageDialog(null, "Ese mes no tiene tantos dias", "Error",JOptionPane.ERROR_MESSAGE);
                            }
                        }else{
                            y = null;
                            JOptionPane.showMessageDialog(null, "Solo existen 12 meses", "Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                         JOptionPane.showMessageDialog(null, "Alguno de los valores de la fecha son negativos", "Error",JOptionPane.ERROR_MESSAGE);
                    }
                }catch(NumberFormatException error){
                    JOptionPane.showMessageDialog(null, "Fecha introducida no valida", "Error",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                 JOptionPane.showMessageDialog(null, "No se introdujo fecha", "Error",JOptionPane.ERROR_MESSAGE);
             }
    }
    
}
