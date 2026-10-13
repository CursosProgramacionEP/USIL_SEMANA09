# USIL – Programación Orientada a Objetos I · Semana 09

## Relaciones entre clases: del diagrama UML al código Java

Código que acompaña la sesión de **asociación, agregación y composición**.
Cada carpeta es un proyecto independiente con su propio `Main.java`.
Estos ejemplos acompañan la **explicación de la clase** (diapositivas *Relación de Asociación*): primero revisa el diagrama y la explicación, y luego el código.

👉 **Prácticas de clase paso a paso:** [`EJERCICIOS_CLASE.md`](EJERCICIOS_CLASE.md)

## Del diagrama al código (resumen)

| En el diagrama UML | En Java |
|---|---|
| Multiplicidad `1` | un atributo: `private Direccion direccion;` |
| Multiplicidad `0..1` | igual, pero puede valer `null` |
| Multiplicidad `*` o `1..*` | una lista: `private ArrayList<Persona> empleados;` |
| Navegabilidad `→` | solo la clase de origen guarda la referencia |
| Agregación `◇` | la parte **llega por parámetro** (se crea afuera) |
| Composición `◆` | el todo **hace el `new`** de la parte |

**Cómo leer los diagramas:** `-` es atributo privado, `+` es constructor o método público. Cada diagrama muestra **todas** las clases con los mismos atributos, constructores y métodos que tiene el código de su carpeta.

---

## Ejemplo01 · Asociación 1 a 1: `Cliente` – `Direccion`

El cliente conoce su dirección; la dirección no conoce al cliente.

```mermaid
classDiagram
    class Cliente {
        -String nombre
        -Direccion direccion
        +Cliente(String nombre, Direccion direccion)
        +mostrar() void
    }
    class Direccion {
        -String calle
        -String distrito
        +Direccion(String calle, String distrito)
        +getCalle() String
        +getDistrito() String
    }
    Cliente "1" --> "1" Direccion : vive en
```

📁 [`Ejemplo01`](Ejemplo01)

## Ejemplo02 · Asociación 1 a muchos: `Empresa` – `Persona`

La lista de empleados vive en la clase del lado "uno" (`Empresa`).

```mermaid
classDiagram
    class Empresa {
        -String nombre
        -ArrayList~Persona~ empleados
        +Empresa(String nombre)
        +contratar(Persona p) void
        +mostrarEmpleados() void
    }
    class Persona {
        -String nombre
        +Persona(String nombre)
        +getNombre() String
    }
    Empresa "1" --> "*" Persona : empleados
```

📁 [`Ejemplo02`](Ejemplo02)

## Ejemplo03 · Agregación: `Sala` – `Mesa`

La mesa **existe por sí sola** y puede estar en varias salas. La `Sala` no hace `new Mesa`: la recibe por parámetro.

```mermaid
classDiagram
    class Sala {
        -String nombre
        -ArrayList~Mesa~ mesas
        +Sala(String nombre)
        +agregarMesa(Mesa m) void
        +mostrar() void
    }
    class Mesa {
        -String material
        +Mesa(String material)
        +getMaterial() String
    }
    Sala "*" o-- "*" Mesa : mesas
```

📁 [`Ejemplo03`](Ejemplo03)

## Ejemplo04 · Composición: `Edificio` – `Piso`

El piso **no existe sin el edificio**: el `Edificio` hace el `new Piso(...)` dentro de su constructor (con un `for`). Por eso el constructor recibe la `cantidadPisos`, no los pisos.

```mermaid
classDiagram
    class Edificio {
        -String nombre
        -ArrayList~Piso~ pisos
        +Edificio(String nombre, int cantidadPisos)
        +mostrar() void
    }
    class Piso {
        -int numero
        +Piso(int numero)
        +getNumero() int
    }
    Edificio "1" *-- "1..*" Piso : pisos
```

📁 [`Ejemplo04`](Ejemplo04)

## Ejemplo05 · Clase de asociación: `EquipoFutbol`

La relación entre `Futbolista` y `LigaFutbol` guarda información propia (nombre y ciudad del equipo), por eso se convierte en una clase. En el diagrama de clases del curso, `EquipoFutbol` se une con una línea punteada a la asociación; aquí se dibuja con líneas punteadas hacia las dos clases que relaciona. En el código, `EquipoFutbol` guarda una referencia a cada una (`futbolista` y `liga`) además de sus propios datos.

```mermaid
classDiagram
    class Futbolista {
        -String nombre
        -int numero
        +Futbolista(String nombre, int numero)
        +getNombre() String
        +getNumero() int
    }
    class LigaFutbol {
        -String nombre
        +LigaFutbol(String nombre)
        +getNombre() String
    }
    class EquipoFutbol {
        -Futbolista futbolista
        -LigaFutbol liga
        -String nombre
        -String ciudad
        +EquipoFutbol(Futbolista futbolista, LigaFutbol liga, String nombre, String ciudad)
        +mostrar() void
    }
    Futbolista "*" -- "1" LigaFutbol : juega en
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

### Ejercicio01 · `Biblioteca` – `Libro`

En amarillo mental: lo que ya está escrito es `Libro` y el esqueleto de `Biblioteca`; tú completas el atributo `libros`, su creación y los métodos `agregarLibro` y `listarLibros`.

```mermaid
classDiagram
    class Biblioteca {
        -String nombre
        -ArrayList~Libro~ libros
        +Biblioteca(String nombre)
        +agregarLibro(Libro l) void
        +listarLibros() void
    }
    class Libro {
        -String titulo
        -String autor
        +Libro(String titulo, String autor)
        +getTitulo() String
        +getAutor() String
    }
    Biblioteca "1" --> "*" Libro : libros
```

### Ejercicio02 · `Estudiante` – `Curso` (0 a 8)

Un estudiante cursa de 0 a 8 cursos: la lista debe rechazar el curso número 9.

```mermaid
classDiagram
    class Estudiante {
        -String nombre
        -ArrayList~Curso~ cursos
        +Estudiante(String nombre)
        +inscribir(Curso c) boolean
        +mostrarCursos() void
    }
    class Curso {
        -String nombre
        +Curso(String nombre)
        +getNombre() String
    }
    Estudiante "*" --> "0..8" Curso : cursa
```

### Ejercicio03 · Caso Blog

Aquí **el diagrama lo diseñas tú**. Estas son las clases y los atributos que ya tienen los archivos; faltan las relaciones (¿asociación, agregación o composición?), sus multiplicidades, los constructores y los métodos que indican los `TODO`.

```mermaid
classDiagram
    class Usuario {
        -String email
        +Usuario(String email)
        +getEmail() String
    }
    class Blog {
        -String titulo
        -String fechaCreacion
    }
    class Post {
        -String texto
        -String fecha
    }
    class Comentario {
        -String texto
        -String fecha
    }
```

> `Ejercicio02` y `Ejercicio03` no compilan hasta que completes lo que piden los `TODO`: es lo esperado.

**Pista para decidir entre agregación y composición:** ¿qué pasa con la parte cuando desaparece el todo? ¿Dónde está el `new`?
