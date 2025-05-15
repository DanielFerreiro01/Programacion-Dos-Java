import AdicionalFotos.AlbumFotografico;
import AdicionalFotos.AlbumRestringido;
import AdicionalFotos.Fotografia;
import AdicionalFotos.Condicion.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Crear fotos
        Fotografia foto1 = new Fotografia("Foto en la playa", LocalDate.of(2024, 1, 10), "F001", 120);
        foto1.addPersona("Martín");
        foto1.addPersona("Lucía");

        Fotografia foto2 = new Fotografia("Foto en la montaña", LocalDate.of(2024, 3, 5), "F002", 150);
        foto2.addPersona("Sofía");

        Fotografia foto3 = new Fotografia("Foto en el bosque", LocalDate.of(2024, 2, 20), "F003", 80);
        foto3.addPersona("Martín");
        foto3.addPersona("Sofía");

        // Álbum común (sin restricciones)
        AlbumFotografico albumComun = new AlbumFotografico("Vacaciones", LocalDate.of(2024, 5, 1));
        albumComun.addElementoFotografico(foto1);
        albumComun.addElementoFotografico(foto2);
        albumComun.addElementoFotografico(foto3);

        // Álbum restringido (máximo 200 de peso)
        AlbumRestringido albumRestringido = new AlbumRestringido("Selección liviana", LocalDate.of(2024, 5, 2));
        albumRestringido.addElementoFotografico(foto1);  // peso 120, entra
        albumRestringido.addElementoFotografico(foto2);  // peso 150, NO entra porque excede 200
        albumRestringido.addElementoFotografico(foto3);  // peso 80, entra (120+80=200)

        // Mostrar resultados álbumes
        System.out.println("Álbum común:");
        System.out.println("- Cantidad de elementos: " + albumComun.cantidadElementos());
        System.out.println("- Peso total: " + albumComun.getPeso());
        System.out.println("- Personas: " + albumComun.getListadoPersonas());
        System.out.println();

        System.out.println("Álbum restringido:");
        System.out.println("- Cantidad de elementos: " + albumRestringido.cantidadElementos());
        System.out.println("- Peso total: " + albumRestringido.getPeso());
        System.out.println("- Personas: " + albumRestringido.getListadoPersonas());
        System.out.println();

        // Pruebas con condiciones
        Condicion condFecha = new CondicionPorFecha(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 2, 15));
        Condicion condPersona = new CondicionPorPersona("Martín");
        Condicion condPeso = new CondicionPorPeso(100);

        // Combinaciones
        Condicion condAnd = new CondicionAnd(condPersona, condPeso);
        Condicion condOr = new CondicionOr(condPersona, condFecha);
        Condicion condNot = new CondicionNot(condPersona);

        // Probar condiciones con foto1, foto2 y foto3
        System.out.println("Condiciones para foto1:");
        System.out.println("Cumple condición fecha: " + condFecha.cumple(foto1));
        System.out.println("Cumple condición persona: " + condPersona.cumple(foto1));
        System.out.println("Cumple condición peso: " + condPeso.cumple(foto1));
        System.out.println("Cumple condición AND (persona y peso): " + condAnd.cumple(foto1));
        System.out.println("Cumple condición OR (persona o fecha): " + condOr.cumple(foto1));
        System.out.println("Cumple condición NOT (no persona): " + condNot.cumple(foto1));
        System.out.println();

        System.out.println("Condiciones para foto2:");
        System.out.println("Cumple condición fecha: " + condFecha.cumple(foto2));
        System.out.println("Cumple condición persona: " + condPersona.cumple(foto2));
        System.out.println("Cumple condición peso: " + condPeso.cumple(foto2));
        System.out.println("Cumple condición AND (persona y peso): " + condAnd.cumple(foto2));
        System.out.println("Cumple condición OR (persona o fecha): " + condOr.cumple(foto2));
        System.out.println("Cumple condición NOT (no persona): " + condNot.cumple(foto2));
        System.out.println();

        System.out.println("Condiciones para foto3:");
        System.out.println("Cumple condición fecha: " + condFecha.cumple(foto3));
        System.out.println("Cumple condición persona: " + condPersona.cumple(foto3));
        System.out.println("Cumple condición peso: " + condPeso.cumple(foto3));
        System.out.println("Cumple condición AND (persona y peso): " + condAnd.cumple(foto3));
        System.out.println("Cumple condición OR (persona o fecha): " + condOr.cumple(foto3));
        System.out.println("Cumple condición NOT (no persona): " + condNot.cumple(foto3));
    }
}
