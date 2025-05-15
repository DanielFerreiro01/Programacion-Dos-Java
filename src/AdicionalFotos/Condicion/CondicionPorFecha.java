package AdicionalFotos.Condicion;

import AdicionalFotos.Fotografia;
import java.time.LocalDate;

/**
 * Condición que verifica si la fecha de la fotografía
 * se encuentra dentro de un rango (inclusive).
 */
public class CondicionPorFecha extends Condicion {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    /**
     * Constructor que define el rango de fechas.
     *
     * @param fechaInicio Fecha inicial del rango.
     * @param fechaFin Fecha final del rango.
     */
    public CondicionPorFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    /**
     * Evalúa si la fecha de la fotografía está dentro del rango.
     *
     * @param fotografia Fotografía a evaluar.
     * @return true si la fecha está entre fechaInicio y fechaFin (inclusive).
     */
    @Override
    public boolean cumple(Fotografia fotografia) {
        LocalDate fechaFoto = fotografia.getFecha();
        return (fechaFoto.isEqual(fechaInicio) || fechaFoto.isAfter(fechaInicio))
                && (fechaFoto.isEqual(fechaFin) || fechaFoto.isBefore(fechaFin));
    }
}
