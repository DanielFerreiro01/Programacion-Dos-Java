package AdicionalFotos.Condicion;

import AdicionalFotos.Fotografia;

/**
 * Representa una condición compuesta que combina dos condiciones
 * usando la operación lógica AND.
 *
 * Una fotografía cumple esta condición si cumple ambas condiciones internas.
 */
public class CondicionAnd extends Condicion {
    private Condicion c1;
    private Condicion c2;

    /**
     * Constructor que recibe dos condiciones a combinar.
     *
     * @param c1 Primera condición.
     * @param c2 Segunda condición.
     */
    public CondicionAnd(Condicion c1, Condicion c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    /**
     * Evalúa si la fotografía cumple ambas condiciones.
     *
     * @param fotografia La fotografía a evaluar.
     * @return true si cumple ambas condiciones, false en caso contrario.
     */
    @Override
    public boolean cumple(Fotografia fotografia) {
        return c1.cumple(fotografia) && c2.cumple(fotografia);
    }
}
