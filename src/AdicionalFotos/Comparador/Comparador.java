package AdicionalFotos.Comparador;

import AdicionalFotos.ElementoFotografico;

import java.util.Comparator;

/**
 * Comparador personalizado para ordenar elementos fotográficos.
 * Primero ordena por fecha (de forma ascendente),
 * y si las fechas son iguales, ordena por peso (ascendente).
 */
public class Comparador implements Comparator<ElementoFotografico> {

    /**
     * Compara dos elementos fotográficos según su fecha y peso.
     *
     * @param e1 Primer elemento a comparar.
     * @param e2 Segundo elemento a comparar.
     * @return Valor negativo si e1 < e2, positivo si e1 > e2, cero si son iguales.
     */
    @Override
    public int compare(ElementoFotografico e1, ElementoFotografico e2) {
        int dateComparison = e1.getFecha().compareTo(e2.getFecha());
        if (dateComparison != 0) {
            return dateComparison;  // Ordena por fecha si son distintas
        }
        // Si las fechas son iguales, compara por peso
        return Integer.compare(e1.getPeso(), e2.getPeso());
    }
}
