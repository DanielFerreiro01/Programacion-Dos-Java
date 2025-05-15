package AdicionalFotos;

import AdicionalFotos.Comparador.Comparador;
import AdicionalFotos.Condicion.Condicion;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase que representa un álbum fotográfico que puede contener múltiples elementos fotográficos.
 * Implementa el patrón Composite permitiendo que un álbum contenga tanto fotografías individuales
 * como otros álbumes (elementos compuestos).
 */
public class AlbumFotografico extends ElementoFotografico {
    // Lista de elementos fotográficos que contiene el álbum (pueden ser fotografías o álbumes)
    protected ArrayList<ElementoFotografico> album;

    /**
     * Constructor que inicializa un álbum con título y fecha.
     *
     * @param titulo Título del álbum.
     * @param fecha  Fecha de creación del álbum.
     */
    public AlbumFotografico(String titulo, LocalDate fecha) {
        super(titulo, fecha);
        this.album = new ArrayList<>();
    }

    /**
     * Agrega un nuevo elemento fotográfico al álbum.
     * Luego ordena los elementos según el criterio definido en Comparador.
     *
     * @param elemento Elemento fotográfico a agregar.
     */
    public void addElementoFotografico(ElementoFotografico elemento) {
        album.add(elemento);
        album.sort(new Comparador());
    }

    /**
     * Calcula el peso total del álbum sumando el peso de todos sus elementos.
     *
     * @return Peso total del álbum.
     */
    @Override
    public int getPeso() {
        int suma = 0;
        for (ElementoFotografico elemento : album) {
            suma += elemento.getPeso();
        }
        return suma;
    }

    /**
     * Calcula la cantidad total de fotografías contenidas en el álbum.
     * Si hay álbumes anidados, cuenta recursivamente sus fotografías.
     *
     * @return Cantidad total de fotografías en el álbum.
     */
    @Override
    public int cantidadElementos() {
        int suma = 0;
        for (ElementoFotografico elemento : album) {
            suma += elemento.cantidadElementos();
        }
        return suma;
    }

    /**
     * Obtiene un listado único de todas las personas presentes en las fotografías del álbum.
     *
     * @return Lista sin duplicados de nombres de personas en el álbum.
     */
    @Override
    public ArrayList<String> getListadoPersonas() {
        ArrayList<String> resultado = new ArrayList<>();
        for (ElementoFotografico elemento : album) {
            ArrayList<String> aux = elemento.getListadoPersonas();
            for (String persona : aux) {
                if (!resultado.contains(persona)) {
                    resultado.add(persona);
                }
            }
        }
        return resultado;
    }

    /**
     * Genera una copia restringida del álbum que solo incluye los elementos que cumplen una condición dada.
     * La copia también es un álbum fotográfico con los mismos atributos pero filtrado según la condición.
     *
     * @param condicion Condición que deben cumplir los elementos para incluirse en la copia.
     * @return Copia del álbum con solo los elementos que cumplen la condición, o null si no hay elementos que cumplan.
     */
    @Override
    public ElementoFotografico copiaRestringida(Condicion condicion) {
        AlbumFotografico copia = new AlbumFotografico(this.getTitulo(), this.getFecha());
        boolean agrego = false;
        for (ElementoFotografico elemento : album) {
            ElementoFotografico copiaHijo = elemento.copiaRestringida(condicion);
            if (copiaHijo != null) {
                copia.addElementoFotografico(copiaHijo);
                agrego = true;
            }
        }
        if (agrego) {
            return copia;
        } else {
            return null;
        }
    }
}
