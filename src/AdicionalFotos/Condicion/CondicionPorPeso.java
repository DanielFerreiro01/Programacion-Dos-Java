package AdicionalFotos.Condicion;

import AdicionalFotos.Fotografia;

/**
 * Condición que evalúa si el peso de una fotografía
 * es mayor que un valor mínimo especificado.
 */
public class CondicionPorPeso extends Condicion {
    private int peso;

    /**
     * Constructor que establece el peso mínimo para cumplir la condición.
     *
     * @param peso Peso mínimo que debe superar la fotografía para cumplir la condición.
     */
    public CondicionPorPeso(int peso) {
        this.peso = peso;
    }

    /**
     * Verifica si el peso de la fotografía es mayor al peso mínimo.
     *
     * @param fotografia Fotografía a evaluar.
     * @return true si el peso de la fotografía es mayor que el peso mínimo, false en caso contrario.
     */
    @Override
    public boolean cumple(Fotografia fotografia) {
        return fotografia.getPeso() > peso;
    }
}
