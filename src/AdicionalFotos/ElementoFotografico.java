package AdicionalFotos;

import AdicionalFotos.Condicion.Condicion;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase abstracta que representa un elemento fotográfico genérico.
 * Sirve como base para objetos que pueden ser fotografías individuales
 * o álbumes que contienen múltiples elementos fotográficos.
 * Define la interfaz común para todas las operaciones sobre elementos fotográficos.
 */
public abstract class ElementoFotografico {
    // Título o descripción del elemento fotográfico
    private String titulo;

    // Fecha asociada al elemento fotográfico (por ejemplo, fecha de la foto o creación del álbum)
    private LocalDate fecha;

    /**
     * Constructor que inicializa el título y la fecha del elemento.
     *
     * @param titulo Título o descripción del elemento fotográfico.
     * @param fecha  Fecha asociada al elemento.
     */
    public ElementoFotografico(String titulo, LocalDate fecha) {
        this.titulo = titulo;
        this.fecha = fecha;
    }

    /**
     * Obtiene el título del elemento fotográfico.
     *
     * @return título del elemento.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Obtiene la fecha asociada al elemento fotográfico.
     *
     * @return fecha del elemento.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Método abstracto que debe ser implementado por las subclases para
     * devolver el peso total del elemento fotográfico.
     * En el caso de una fotografía será su peso, y en un álbum la suma de pesos.
     *
     * @return peso total del elemento.
     */
    public abstract int getPeso();

    /**
     * Método abstracto que debe ser implementado por las subclases para
     * devolver la cantidad total de elementos fotográficos que contiene.
     * Para una fotografía es 1, para un álbum la suma de todos los elementos.
     *
     * @return cantidad de elementos fotográficos contenidos.
     */
    public abstract int cantidadElementos();

    /**
     * Método abstracto para obtener la lista de personas asociadas al elemento.
     * En una fotografía devuelve las personas que aparecen.
     * En un álbum la combinación de todas las personas en sus elementos.
     *
     * @return lista de nombres de personas asociadas.
     */
    public abstract ArrayList<String> getListadoPersonas();

    /**
     * Método abstracto que genera una copia del elemento restringida
     * según una condición dada.
     * En caso de no cumplir la condición puede devolver null.
     *
     * @param condicion condición para filtrar elementos.
     * @return copia restringida del elemento o null si no cumple.
     */
    public abstract ElementoFotografico copiaRestringida(Condicion condicion);

}
