package AdicionalFotos.Condicion;

import AdicionalFotos.Fotografia;

/**
 * Clase abstracta que representa una condición o criterio
 * para evaluar si una fotografía cumple ciertos requisitos.
 *
 * Esta clase sirve como base para implementar diferentes tipos
 * de condiciones que se pueden aplicar a objetos Fotografia.
 */
public abstract class Condicion {

    /**
     * Método abstracto que debe ser implementado para definir
     * si una fotografía cumple con la condición específica.
     *
     * @param fotografia La fotografía a evaluar.
     * @return true si la fotografía cumple la condición, false en caso contrario.
     */
    public abstract boolean cumple(Fotografia fotografia);
}
