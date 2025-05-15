# Álbum Fotográfico Java

Este proyecto implementa un sistema para gestionar álbumes y fotografías utilizando Java, basado en el patrón de diseño **Composite** y que incorpora un sistema flexible de **condiciones** para filtrar y gestionar las fotografías.

---

## 📋 Descripción

El proyecto simula una estructura jerárquica de elementos fotográficos:

- `Fotografia`: representa una fotografía individual con título, fecha, peso y lista de personas asociadas.
- `AlbumFotografico`: representa un álbum que puede contener múltiples elementos fotográficos (fotografías o álbumes).
- `AlbumRestringido`: una variante de álbum que impone un límite máximo de elementos al agregar nuevos.
- `Condicion`: clase abstracta para definir condiciones que pueden evaluar fotografías para filtrarlas o para decidir ciertas operaciones (como si una fotografía cumple o no un criterio).
- Implementaciones concretas de `Condicion`:
  - `CondicionAnd`, `CondicionOr`, `CondicionNot`: combinan condiciones con lógica booleana AND, OR, NOT.
  - `CondicionPorFecha`: evalúa si la fotografía está dentro de un rango de fechas.
  - `CondicionPorPersona`: evalúa si la fotografía incluye a una persona específica.
  - `CondicionPorPeso`: evalúa si la fotografía excede un peso mínimo.

Estas condiciones permiten, por ejemplo, crear álbumes o listas de fotografías que cumplan ciertos filtros definidos dinámicamente.

---

## 📐 Patrón de Diseño Utilizado: Composite

Se emplea el **patrón Composite** para tratar uniformemente objetos individuales (`Fotografia`) y compuestos (`AlbumFotografico`):

- La clase abstracta `ElementoFotografico` define la interfaz común.
- `Fotografia` actúa como objeto hoja.
- `AlbumFotografico` funciona como composite, conteniendo elementos hijos y aplicando operaciones recursivas.
- `AlbumRestringido` extiende `AlbumFotografico` y restringe la cantidad de elementos permitidos.

Además, se utiliza el patrón **Specification** para las clases de condiciones, que permiten filtrar o validar fotografías según criterios flexibles y combinables.

---

## ⚙️ Detalles Técnicos

- Lenguaje: Java
- Uso de paquetes para organizar clases (`AdicionalFotos`, `AdicionalFotos.Condicion`).
- Clases abstractas y polimorfismo para elementos fotográficos y condiciones.
- Uso de `ArrayList` para manejar colecciones.
- Ordenamiento personalizado de álbumes mediante comparadores.
- Condiciones que implementan lógica booleana y filtros específicos.

---

## 🛠️ Cómo ejecutar

1. Clonar o descargar el repositorio.
2. Abrir el proyecto en IntelliJ IDEA o tu IDE favorito.
3. Ejecutar la clase `Main` incluida para ver un ejemplo de uso.

---

## ▶️ Ejemplo de salida esperada

```text
Álbum común:
- Cantidad de elementos: 3
- Peso total: 350
- Personas: [Martín, Lucía, Sofía]

Álbum restringido:
- Cantidad de elementos: 2
- Peso total: 200
- Personas: [Martín, Lucía, Sofía]

Condiciones para foto1:
Cumple condición fecha: true
Cumple condición persona: true
Cumple condición peso: true
Cumple condición AND (persona y peso): true
Cumple condición OR (persona o fecha): true
Cumple condición NOT (no persona): false

Condiciones para foto2:
Cumple condición fecha: false
Cumple condición persona: false
Cumple condición peso: true
Cumple condición AND (persona y peso): false
Cumple condición OR (persona o fecha): false
Cumple condición NOT (no persona): true

Condiciones para foto3:
Cumple condición fecha: false
Cumple condición persona: true
Cumple condición peso: false
Cumple condición AND (persona y peso): false
Cumple condición OR (persona o fecha): true
Cumple condición NOT (no persona): false

Process finished with exit code 0

