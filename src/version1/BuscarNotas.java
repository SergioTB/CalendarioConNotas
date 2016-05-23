/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        int dia = date.getD().getDay();
        int mes = date.getM().getMonth();
        int anyo = date.getY().getYear();
        
        try {
			//Primero leo y abro el fichero
			BufferedReader br = new BufferedReader(new FileReader("bd.txt"));
			
			//Voy linea por linea buscando los dias
			while((linea = br.readLine()) != null){
				StringTokenizer st = new StringTokenizer(linea, ";");
				
				int da = Integer.parseInt(st.nextToken());
				int m = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				String texto = st.nextToken();
                                
                                if(dia == da && mes == m && anyo == a){
                                    lista.add(texto);
                                }
			}
			
                       
			br.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Fichero no encontrado");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Error al leer el fichero");
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
