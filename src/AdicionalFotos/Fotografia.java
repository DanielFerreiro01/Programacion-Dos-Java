package AdicionalFotos;

import AdicionalFotos.Condicion.Condicion;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase que representa una fotografía individual en el sistema.
 * Implementa ElementoFotografico para integrarse en la estructura Composite.
 * Cada fotografía tiene un ID único, un peso (por ejemplo, tamaño en KB),
 * una lista de personas que aparecen en la foto, un título y una fecha.
 */
public class Fotografia extends ElementoFotografico {
    // Identificador único de la fotografía
    private final String ID;

    // Peso de la fotografía (puede representar tamaño, peso físico, etc.)
    private int peso;

    // Lista de nombres de personas que aparecen en la fotografía
    private ArrayList<String> listaPersonas;

    /**
     * Constructor principal de Fotografia.
     *
     * @param titulo     Título o descripción de la fotografía.
     * @param fecha      Fecha en la que fue tomada la fotografía.
     * @param ID         Identificador único de la fotografía.
     * @param peso       Peso o tamaño asociado a la fotografía.
     */
    public Fotografia(String titulo, LocalDate fecha, String ID, int peso) {
        super(titulo, fecha);
        this.ID = ID;
        this.peso = peso;
        this.listaPersonas = new ArrayList<>();
    }

    /**
     * Constructor que recibe una lista inicial de personas asociadas a la fotografía.
     * Se crea una copia de la lista para evitar aliasing externo.
     *
     * @param titulo        Título o descripción de la fotografía.
     * @param fecha         Fecha en la que fue tomada la fotografía.
     * @param ID            Identificador único de la fotografía.
     * @param peso          Peso o tamaño asociado a la fotografía.
     * @param listaPersonas Lista inicial de personas en la fotografía.
     */
    public Fotografia(String titulo, LocalDate fecha, String ID, int peso, ArrayList<String> listaPersonas) {
        super(titulo, fecha);
        this.ID = ID;
        this.peso = peso;
        this.listaPersonas = new ArrayList<>(listaPersonas);
    }

    /**
     * Obtiene el ID único de la fotografía.
     *
     * @return ID de la fotografía.
     */
    public String getID() {
        return ID;
    }

    /**
     * Devuelve el peso de la fotografía.
     * Implementa el método abstracto de ElementoFotografico.
     *
     * @return peso de la fotografía.
     */
    @Override
    public int getPeso() {
        return this.peso;
    }

    /**
     * Cantidad de elementos que representa esta instancia.
     * En el caso de una fotografía individual siempre es 1.
     *
     * @return número 1.
     */
    @Override
    public int cantidadElementos() {
        return 1;
    }

    /**
     * Agrega una persona a la lista de personas que aparecen en la fotografía.
     * Solo la agrega si no está ya en la lista para evitar duplicados.
     *
     * @param persona Nombre de la persona a agregar.
     */
    public void addPersona(String persona) {
        if (!this.listaPersonas.contains(persona)) {
            this.listaPersonas.add(persona);
        }
    }

    /**
     * Obtiene una copia de la lista de personas asociadas a la fotografía.
     * Devuelve una nueva lista para proteger la encapsulación.
     *
     * @return lista de personas en la fotografía.
     */
    @Override
    public ArrayList<String> getListadoPersonas() {
        return new ArrayList<>(listaPersonas);
    }

    /**
     * Genera una copia restringida de esta fotografía en base a una condición.
     * Si la fotografía cumple la condición, se devuelve una nueva instancia igual.
     * Si no, devuelve null indicando que no cumple el criterio.
     *
     * @param condicion Condición a evaluar para la copia.
     * @return copia restringida o null si no cumple la condición.
     */
    @Override
    public ElementoFotografico copiaRestringida(Condicion condicion) {
        if (condicion.cumple(this)) {
            return new Fotografia(
                    this.getTitulo(), this.getFecha(), this.getID(), this.getPeso(), this.getListadoPersonas()
            );
        } else {
            return null;
        }
    }
}
