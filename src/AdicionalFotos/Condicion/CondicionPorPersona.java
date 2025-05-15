package AdicionalFotos.Condicion;

import AdicionalFotos.Fotografia;

/**
 * Condición que verifica si una fotografía contiene
 * a una persona específica en su lista de personas asociadas.
 */
public class CondicionPorPersona extends Condicion {
    private String persona;

    /**
     * Constructor que recibe la persona que se quiere buscar.
     *
     * @param persona Nombre de la persona a buscar en la fotografía.
     */
    public CondicionPorPersona(String persona){
        this.persona = persona;
    }

    /**
     * Evalúa si la fotografía contiene a la persona especificada.
     *
     * @param fotografia Fotografía a evaluar.
     * @return true si la lista de personas incluye la persona buscada.
     */
    @Override
    public boolean cumple(Fotografia fotografia){
        return fotografia.getListadoPersonas().contains(persona);
    }
}
