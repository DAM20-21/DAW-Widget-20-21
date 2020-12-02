package perez_martin_miguel;

import java.util.ArrayList;

public class Utilidad {

    /**
     * metodo que retorna un array de aleatorios que usaremos en nuestra nueva
     * ventana para, consiguir palabras al azar a traves de esta array.
     * 
     * @return ale
     */
    public static int[] aleatorio(ArrayList<String> palabras) {
        Cronometro crono = new Cronometro();

        int tamaño = crono.getSegundos()/5;

        int[] ale = new int[tamaño];
        int i = 0;

        ale[i] = (int) (Math.random() * palabras.size());

        /**
         * recorremos el array y comparamos una posicion con la anterior y si son
         * iguales volvemos a la posicion anterior, y generamos un aleatorio y vovemos a
         * comprobar.
         */
        for (i = 1; i < ale.length; i++) {
            ale[i] = (int) (Math.random() * palabras.size());
            for (int j = 0; j < i; j++) {
                if (ale[i] == ale[j]) {
                    i--;
                }
            }
        }
        return ale;
    }
}
