package AdicionalFotos.Condicion;

import AdicionalFotos.Fotografia;

/**
 * Representa una condición lógica NOT que invierte el resultado
 * de otra condición.
 *
 * Una fotografía cumple esta condición si NO cumple la condición interna.
 */
public class CondicionNot extends Condicion {
    private Condicion c1;

    /**
     * Constructor que recibe la condición a negar.
     *
     * @param c1 Condición a invertir.
     */
    public CondicionNot(Condicion c1) {
        this.c1 = c1;
    }

    /**
     * Evalúa si la fotografía NO cumple la condición interna.
     *
     * @param fotografia La fotografía a evaluar.
     * @return true si la condición interna NO se cumple, false en caso contrario.
     */
    @Override
    public boolean cumple(Fotografia fotografia) {
        return !c1.cumple(fotografia);
    }
}
