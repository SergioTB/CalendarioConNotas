/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package versionPro;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Sergio Tineo
 */
public class BuscarNotas {
    
    private List<String> lista;
    
    private Date date = null;
    
    public BuscarNotas(Date d){
        this.lista = new ArrayList<String>() {};
        date = d;
        
    }
    
    public void leerFichero(){
        String linea = "";
        String dia = Integer.toString(date.getD().getDay());
        String mes = Integer.toString(date.getM().getMonth());
        String anyo = Integer.toString(date.getY().getYear());
        
        try {
			//Primero leo y abro el fichero
			BufferedReader br = new BufferedReader(new FileReader("bd.txt"));
			
			//Voy linea por linea buscando los dias
			while((linea = br.readLine()) != null){
				StringTokenizer st = new StringTokenizer(linea, ";");
				
				String da = st.nextToken();
				String m = st.nextToken();
				String a = st.nextToken();
				String texto = st.nextToken();
                                
                                if(dia.equals(da) && mes.equals(m) && anyo.equals(a)){
                                    lista.add(texto);
                                }
			}
                        
			br.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No se ha encontrado el fichero bd.txt", "Error",JOptionPane.ERROR_MESSAGE);
                        
                        File fichero = new File("bd.txt");
                        try {
                            if (fichero.createNewFile()){
                                JOptionPane.showMessageDialog(null, "Se ha creado el fichero bd.txt\nYa puedes añadir anotaciones", "Informacion",JOptionPane.INFORMATION_MESSAGE);
                            }else{
                                JOptionPane.showMessageDialog(null, "No ha sido posible crear el fichero bd.txt", "Error",JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error durante la creacion fichero bd.txt", "Error",JOptionPane.ERROR_MESSAGE);
                        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al leer el fichero bd.txt", "Error",JOptionPane.ERROR_MESSAGE);
		}
    }
    

    public List<String> getLista() {
        return lista;
    }
    
    public void agregarLinea(String linea){

        try
        {
            FileWriter fichero = new FileWriter("bd.txt", true);
            PrintWriter pw = new PrintWriter(fichero);

            pw.println(date.getD().getDay()+";"+date.getM().getMonth()+";"+date.getY().getYear()+";"+linea);
            
            fichero.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
