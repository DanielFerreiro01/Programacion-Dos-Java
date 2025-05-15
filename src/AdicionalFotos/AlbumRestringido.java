package AdicionalFotos;

import java.time.LocalDate;

/**
 * Clase que representa un álbum fotográfico con restricción de peso.
 * Extiende AlbumFotografico y limita el peso total de las fotografías que puede contener.
 * Solo permite agregar un nuevo elemento si la suma del peso actual y el peso del nuevo
 * no supera un límite máximo (200).
 */
public class AlbumRestringido extends AlbumFotografico {

    /**
     * Constructor que inicializa el álbum restringido con título y fecha.
     *
     * @param titulo Título del álbum restringido.
     * @param fecha  Fecha de creación del álbum.
     */
    public AlbumRestringido(String titulo, LocalDate fecha) {
        super(titulo, fecha);
    }

    /**
     * Agrega un elemento fotográfico al álbum solo si el peso total no supera 200.
     *
     * @param elemento Elemento fotográfico a agregar.
     */
    @Override
    public void addElementoFotografico(ElementoFotografico elemento) {
        int nuevoPeso = elemento.getPeso();
        int pesoActual = this.getPeso();

        // Solo agrega el elemento si el peso total queda dentro del límite permitido
        if (pesoActual + nuevoPeso <= 200) {
            super.addElementoFotografico(elemento);
        }
    }
}
