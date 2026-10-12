# USIL – Programación Orientada a Objetos I · Semana 09

## Relaciones entre clases: del diagrama UML al código Java

Código que acompaña la sesión de **asociación, agregación y composición**.
Cada carpeta es un proyecto independiente con su propio `Main.java`.
Estos ejemplos acompañan la **explicación de la clase** (diapositivas *Relación de Asociación*): primero revisa el diagrama y la explicación, y luego el código.

## Del diagrama al código (resumen)

| En el diagrama UML | En Java |
|---|---|
| Multiplicidad `1` | un atributo: `private Direccion direccion;` |
| Multiplicidad `0..1` | igual, pero puede valer `null` |
| Multiplicidad `*` o `1..*` | una lista: `private ArrayList<Persona> empleados;` |
| Navegabilidad `→` | solo la clase de origen guarda la referencia |
| Agregación `◇` | la parte **llega por parámetro** (se crea afuera) |
| Composición `◆` | el todo **hace el `new`** de la parte |

---

## Ejemplo01 · Asociación 1 a 1: `Cliente` – `Direccion`

El cliente conoce su dirección; la dirección no conoce al cliente.

```mermaid
classDiagram
    class Cliente {
        -String nombre
        -Direccion direccion
    }
    class Direccion {
        -String calle
        -String distrito
    }
    Cliente "1" --> "1" Direccion : vive
```

📁 [`Ejemplo01`](Ejemplo01)

## Ejemplo02 · Asociación 1 a muchos: `Empresa` – `Persona`

La lista de empleados vive en la clase del lado "uno" (`Empresa`).

```mermaid
classDiagram
    class Empresa {
        -String nombre
        -ArrayList~Persona~ empleados
        +contratar(Persona p)
    }
    class Persona {
        -String nombre
    }
    Empresa "1" --> "*" Persona : emplea
```

📁 [`Ejemplo02`](Ejemplo02)

## Ejemplo03 · Agregación: `Sala` – `Mesa`

La mesa **existe por sí sola** y puede estar en varias salas. La `Sala` no hace `new Mesa`: la recibe por parámetro.

```mermaid
classDiagram
    class Sala {
        -String nombre
        -ArrayList~Mesa~ mesas
        +agregarMesa(Mesa m)
    }
    class Mesa {
        -String material
    }
    Sala "1" o-- "*" Mesa
```

📁 [`Ejemplo03`](Ejemplo03)

## Ejemplo04 · Composición: `Edificio` – `Piso`

El piso **no existe sin el edificio**: el `Edificio` hace el `new Piso(...)` en su constructor.

```mermaid
classDiagram
    class Edificio {
        -String nombre
        -ArrayList~Piso~ pisos
    }
    class Piso {
        -int numero
    }
    Edificio "1" *-- "1..*" Piso
```

📁 [`Ejemplo04`](Ejemplo04)

## Ejemplo05 · Clase de asociación: `EquipoFutbol`

La relación entre `Futbolista` y `LigaFutbol` guarda información propia (nombre y ciudad del equipo), por eso se convierte en una clase. En el diagrama de clases del curso, `EquipoFutbol` se une con una línea punteada a la asociación; aquí se muestra con líneas punteadas hacia las dos clases que relaciona.

```mermaid
classDiagram
    class Futbolista {
        -String nombre
        -int numero
    }
    class LigaFutbol {
        -String nombre
    }
    class EquipoFutbol {
        -String nombre
        -String ciudad
    }
    Futbolista "*" -- "1" LigaFutbol
    EquipoFutbol .. Futbolista
    EquipoFutbol .. LigaFutbol
```

📁 [`Ejemplo05`](Ejemplo05)

---

## Ejercicios

| Carpeta | Ejercicio | Qué debes hacer |
|---|---|---|
| [`Ejercicio01`](Ejercicio01) | `Biblioteca` – `Libro` | Completar los 4 `TODO` de `Biblioteca` |
| [`Ejercicio02`](Ejercicio02) | `Estudiante` – `Curso` (0 a 8) | Escribir `inscribir` y `mostrarCursos`; el curso 9 se rechaza |
| [`Ejercicio03`](Ejercicio03) | Caso Blog | Diseñar el diagrama y completar las clases |

```mermaid
classDiagram
    class Biblioteca {
        -String nombre
        -ArrayList~Libro~ libros
    }
    class Libro {
        -String titulo
        -String autor
    }
    Biblioteca "1" --> "*" Libro : tiene

    class Estudiante {
        -String nombre
        -ArrayList~Curso~ cursos
    }
    class Curso {
        -String nombre
    }
    Estudiante --> "0..8" Curso : cursa
```

> `Ejercicio02` no compila hasta que escribas `inscribir` y `mostrarCursos`: es lo esperado.

**Pista para decidir entre agregación y composición:** ¿qué pasa con la parte cuando desaparece el todo? ¿Dónde está el `new`?
