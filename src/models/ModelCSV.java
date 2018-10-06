/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Jose Felix
 */
public class ModelCSV {
    private String path="C:\\archivos\\base.CSV";
    private String nombre = "";
    private String email = "";
    private String texto = "";
    private String row;
    private int fila = 0;
    private int posicion = 0;
    ArrayList <String> acumulador = new ArrayList <String>();
    
    
    /**
     * permite leer archivos
     * @param path almacena la ubicacion de los archivos
     */
    
    public void readFile(){
        try{
                
            try (FileReader file = new FileReader(path); BufferedReader bufferedReader = new BufferedReader(file)){
                while ((row = bufferedReader.readLine()) != null){    
                    acumulador.add(row);
                }
                bufferedReader.close();
            } 
        }catch (FileNotFoundException err) {
            System.err.println("Archivo no encontrado: " + err.getMessage());       
        } catch (IOException err) {
            System.err.println("Error en operación I/O: " + err.getMessage());
        }
    }
    /**
     * permite moverse al primer reguistro del csv
     */
    public void primeroRegistro(){
            String lista = acumulador.get(fila);
            String datos [] = lista.split(",");
            posicion = fila;
            nombre = datos[0];
            email = datos[1];
    }
    /**
     * permite moverse un reguistro antes del csv
     */
    public void anteriorRegistro(){
        if (posicion > 0){
            posicion = posicion -1;
            String lista = acumulador.get(posicion);
            String datos [] = lista.split(",");
            nombre = datos[0];
            email = datos[1];
        }
    }
    /**
     * permite moverse al siguiente reguistro del csv
     */
    public void siguienteRegistro(){
        if (posicion < (acumulador.size()-1)){
            posicion = posicion + 1;
            String lista = acumulador.get(posicion);
            String datos [] = lista.split(",");
            nombre = datos[0];
            email = datos[1];
        }
        
    }
    /**
     * permite moverse al ultimo reguistro del csv
     */
    public void ultimoRegistro(){
        int ultimo = (acumulador.size()-1);
        String lista = acumulador.get(ultimo);
        String datos [] = lista.split(",");
        posicion = ultimo;
        nombre = datos[0];
        email = datos[1];    
    }
    
    

    
    /**
     * permite escribir y guardar el archivo en el archivo
     * @param path almacena la ubicacion del archivo
     * @param message almacena lo que se va a guardar en el archivo
     */
    public void writeFile (String path, String texto) {
        try {
            File archivo = new File(path); 
            FileWriter filewriter = new FileWriter(archivo, true); 
            
            try (PrintWriter printwriter = new PrintWriter(filewriter) ) { 
                printwriter.println(texto);
                printwriter.close();
            }
        }
        catch (FileNotFoundException err) { 
            System.err.println("Archivo no encontrado: " + err.getMessage());
        }
        catch (IOException err) { 
            System.err.println("Error en operación I/O: " + err.getMessage());
        }
    }
    public void leerRegistros(){
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    
}
