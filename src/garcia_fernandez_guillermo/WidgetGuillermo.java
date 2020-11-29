package garcia_fernandez_guillermo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase que realiza todas las operaciones de traducción de las palabras
 * Tiene una referencia a la ventana principal que se le pasa por constructor
 *  @author Guillermo García Fernández
 */
public class WidgetGuillermo {
    
    VentanaPrincipal ventana;

    WidgetGuillermo(VentanaPrincipal ventana){
        this.ventana = ventana;
    }

    /**
     * Lee el fichero diccionario para buscar la palabra que se le ha
     * introducido mediante el JTextField texto e introduce en el JTextField resultado
     * la palabra traducida 
     */
    public void traducirPalabras (){
        try{
            boolean salir = false;
            String lineaAux;
            String lineaEscritura = "";
            String[] palabras = new String[2];
            BufferedReader brTraduccion = new BufferedReader(new FileReader("src/garcia_fernandez_guillermo/diccionario.txt"));
            while((lineaAux = brTraduccion.readLine()) != null || salir == false){
                if (lineaAux.contains(ventana.getTexto().getText()))
                    palabras = lineaAux.split(":");
                    lineaEscritura = palabras[1];
                    salir = true;
            }
            brTraduccion.close();
            ventana.getResultado().setText(lineaEscritura);
        }catch(IOException e){
            System.out.println("Error en la E/S");
        }
    }

    /**
     * Método que lee el fichero diccionario e introduce en el JTextArea
     * del diálogo todas las palabras españolas disponibles para traducir
     */
    public void mostrarPalabrasDisponibles(){
        try{
            ArrayList<String> palabras = new ArrayList<>();
            String lineaAux;
            String[] palEspañol = new String[2];
            BufferedReader brPalabrasDisponibles = new BufferedReader(new FileReader("src/garcia_fernandez_guillermo/diccionario.txt"));
            while((lineaAux = brPalabrasDisponibles.readLine()) != null){
                palEspañol = lineaAux.split(":");
                palabras.add(palEspañol[0]);
            }
            brPalabrasDisponibles.close();
            for (int i = 0; i < palabras.size(); i++){
                ventana.getTextoPalDisponibles().append(palabras.get(i) + "\n");
            }
        }catch(IOException e){
            System.out.println("Error en la E/S");
        }
    }
}
