package AdicionalFotos.Condicion;

import AdicionalFotos.Fotografia;

/**
 * Representa una condición lógica OR que combina dos condiciones.
 *
 * Una fotografía cumple esta condición si cumple al menos una
 * de las dos condiciones internas.
 */
public class CondicionOr extends Condicion {
    private Condicion c1;
    private Condicion c2;

    /**
     * Constructor que recibe dos condiciones a combinar con OR.
     *
     * @param c1 Primera condición.
     * @param c2 Segunda condición.
     */
    public CondicionOr(Condicion c1, Condicion c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    /**
     * Evalúa si la fotografía cumple al menos una de las dos condiciones.
     *
     * @param fotografia La fotografía a evaluar.
     * @return true si alguna condición se cumple, false si ninguna se cumple.
     */
    @Override
    public boolean cumple(Fotografia fotografia) {
        return c1.cumple(fotografia) || c2.cumple(fotografia);
    }
}
