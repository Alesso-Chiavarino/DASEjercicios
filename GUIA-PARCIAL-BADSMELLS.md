# Guía para el 2º parcial de DAS: Bad Smells y Refactorización

Fuente: `Ejs/M1-5-Apunte-sobre-Refactorizacion-v1.5.pdf` (Pastarini) + ejercicios de `Ejs/`.

---

## 1. Formato del parcial (según las Consignas)

- **Ej 1**: "identifique los bad smells, refactorice manteniendo la funcionalidad, justifique".
- **Ej 2**: a veces te **dicen cuál es el smell** (ej.: "contiene el bad smell *Intermediario*"). Ahí te piden identificarlo, aplicar las refactorizaciones que correspondan y **justificar cada cambio** (cómo elimina el smell y cómo mejora el diseño).
- **NOTA**: el `main` se puede cambiar, pero **el comportamiento observable (lo que se imprime) no puede cambiar**.
- En algunos ejercicios el `Run` dice `// NO CONSIDERAR PARA REFACTORIZAR`.

### Plantilla para responder cada hallazgo

```
Bad smell: <nombre en español (nombre en inglés)>
Dónde:     <Clase.método / atributos>
Por qué:   <síntoma concreto en ESTE código + principio que viola (SRP, encapsulamiento, OCP, cohesión)>
Refactorización: <nombre Fowler, p. ej. Move Method + Inline Class>
Justificación: <qué mejora: menos acoplamiento, sin duplicación, más cohesión, extensible…>
```

Usá **los nombres del apunte**: los smells en español con el inglés entre paréntesis y las refactorizaciones con el nombre de Fowler.

---

## 2. Teoría clave (preguntas típicas)

- **Refactorizar** (Fowler): modificar la estructura interna para que sea más fácil de entender y modificar, **sin alterar el comportamiento observable**. El término viene de Opdyke (1992).
- **Qué NO es refactorizar**: no es buscar ni corregir errores (si encontrás uno, dejás de refactorizar y pasás a corregir), no es optimizar el rendimiento y no es agregar funcionalidad.
- **Regla de los tres strikes**: la 1ª vez lo hacés, la 2ª duplicás y la 3ª refactorizás.
- **Cuándo refactorizar**: al agregar funcionalidad, al corregir una falla o en una revisión de código (pair programming).
- **Cuándo NO**: si el código directamente no funciona (conviene reescribirlo) o si la entrega está cerca.
- **Pruebas automáticas**: son imprescindibles. Se corren antes de refactorizar, se refactoriza y se vuelven a correr.
- **Proceso (Wampler)**: 1) revisar código y diseño, 2) aplicar una refactorización por vez, 3) correr las pruebas después de cada una, 4) repetir.
- **Heurísticas**: no agregar funcionalidad mientras refactorizás, usar estrictamente las pruebas y aplicar muchas refactorizaciones simples.
- **Ventajas**: mejora la calidad, el desarrollo es más eficiente, permite un diseño evolutivo, facilita la comprensión, ayuda a encontrar errores, evita reescribir y hace programar más rápido.
- **Desventajas**: cambios de interfaces (cuando hay código que no podés modificar) y bases de datos (por el acoplamiento al esquema).
- **Formato de una refactorización**: nombre, resumen, motivación, mecanismo y ejemplo.

---

## 3. Los 23 bad smells: cómo detectarlos y qué aplicar

| # | Bad smell | Señal para detectarlo en el código | Refactorizaciones típicas (tabla del apunte) |
|---|---|---|---|
| 1 | **Atributo temporal** (Temporary Field) | Atributos que solo se usan en algunos métodos, a veces `null`, del tipo `xxxTemporal` o `limpiarConfiguracion()` | Extract Class, Introduce Null Object |
| 2 | **Cadena de mensajes** (Message Chains) | `a.getB().getC().hacer()` | Hide Delegate |
| 3 | **Cambio divergente** (Divergent Change) | Una clase cambia por muchos motivos distintos (UI + red + lógica) | Extract Class |
| 4 | **Cambio en cadena** (Shotgun Surgery) | Un cambio chico obliga a tocar muchas clases | Move Method, Move Field, Inline Class |
| 5 | **Clase de datos** (Data Class) | Solo atributos y getters/setters (o atributos públicos), sin lógica | Move Method, Encapsulate Field, Encapsulate Collection |
| 6 | **Código muerto** (Dead Code) | Parámetros, métodos o atributos que no se usan, o condiciones que siempre dan igual | Inline Class, Collapse Hierarchy, Remove Parameter |
| 7 | **Clase grande** (Large Class) | Muchos atributos y responsabilidades (viola SRP) | Extract Class, Extract Subclass, Extract Interface, Replace Data Value with Object |
| 8 | **Clase perezosa** (Lazy Class) | Una clase que casi no aporta nada | Inline Class, Collapse Hierarchy |
| 9 | **Comentarios** (Comments) | Comentarios que explican bloques de código: ese bloque debería ser un método | Extract Method, Introduce Assertion |
| 10 | **Código duplicado** (Duplicated Code) | El mismo bloque (directo) o la misma lógica escrita distinta (sutil) | Extract Method, Extract Class, Pull Up Method, Form Template Method |
| 11 | **Envidia de características** (Feature Envy) | Un método usa más datos de OTRA clase que de la suya | Move Method, Move Field, Extract Method |
| 12 | **Estructuras de agrupación condicional** (Switch Statements) | `switch` o `if/else` sobre un "tipo" (String o int), muchas veces repetido en varios lugares (viola OCP) | Replace Conditional with Polymorphism, Replace Type Code with Subclasses o State/Strategy, Replace Parameter with Explicit Methods, Introduce Null Object |
| 13 | **Generalidad especulativa** (Speculative Generality) | Código "por si acaso" que no se usa (interfaces, parámetros, `equals` sin usar) | Collapse Hierarchy, Inline Class, Remove Parameter, Rename Method |
| 14 | **Grupos de datos** (Data Clumps) | Los mismos 3 o 4 datos viajan siempre juntos (params o atributos) | Extract Class, Introduce Parameter Object, Preserve Whole Object |
| 15 | **Intermediario** (Middle Man) | Una clase que solo delega a otra | Remove Middle Man, Inline Method, Replace Delegation with Inheritance |
| 16 | **Intimidad inadecuada** (Inappropriate Intimacy) | Una clase toca atributos no privados de otra (`obj.campo = …`) | Move Method, Move Field, Change Bidirectional Association to Unidirectional, Replace Inheritance with Delegation, Hide Delegate |
| 17 | **Jerarquías paralelas** (Parallel Inheritance Hierarchies) | Cada subclase nueva en A obliga a crear otra en B | Move Method, Move Field |
| 18 | **Legado rechazado** (Refused Bequest) | La subclase hereda cosas que no usa o que no tienen sentido para ella ("X **no es un** Y") | Replace Inheritance with Delegation (composición) |
| 19 | **Lista de parámetros larga** (Long Parameter List) | Métodos o constructores con muchos parámetros | Replace Parameter with Method, Introduce Parameter Object, Preserve Whole Object |
| 20 | **Método largo** (Long Method) | Un método que hace varias cosas (legado de la programación estructurada) | Extract Method, Replace Temp with Query, Replace Method with Method Object, Decompose Conditional |
| 21 | **Obsesión primitiva** (Primitive Obsession) | Usar `String`, `int` o `char[][]` para conceptos con comportamiento (tipo, categoría, tablero) | Replace Data Value with Object, Extract Class, Introduce Parameter Object, Replace Array with Object, Replace Type Code with Class, Subclasses o State/Strategy |
| 22 | **Clases alternativas con diferentes interfaces** (Alternative Classes with Different Interfaces) | Dos clases que hacen lo mismo con distintos nombres o firmas | Rename Method, Move Method, Add Parameter, Parameterize Method, Extract Superclass |
| 23 | **Biblioteca de clases incompleta** (Incomplete Library Class) | Te falta un método en una clase de una librería que no podés modificar | Introduce Foreign Method, Introduce Local Extension |

> **Truco**: también vale nombrar **Números mágicos**, que el apunte resuelve con *Replace Magic Number with Symbolic Constant* (no está en la lista de 23, pero la refactorización está en el catálogo).

### Refactorizaciones que más vas a usar (resumen + mecanismo corto)

- **Extract Method**: crear un método con un nombre que exprese la intención, mover el código, pasar como parámetros las variables que se leen y reemplazar el bloque por la llamada.
- **Inline Method / Inline Class**: lo inverso. Absorbés un método o una clase que no aporta nada.
- **Move Method / Move Field**: llevar el método o el atributo a la clase cuyos datos más usa.
- **Extract Class**: una clase hace el trabajo de dos. Creás la nueva, la vinculás y movés campos y métodos.
- **Replace Temp with Query**: una variable temporal pasa a ser un método (`getAvailableBalance()`).
- **Replace Conditional with Polymorphism**: cada rama pasa a ser una subclase que sobrescribe el método, y el de la superclase queda abstracto.
- **Replace Type Code with Class / Subclasses / State-Strategy**: un "código de tipo" (String o int) pasa a ser una clase, un `enum` o subclases.
- **Replace Inheritance with Delegation**: la subclase deja de heredar y pasa a *tener* un objeto de la otra clase.
- **Remove Middle Man**: el cliente llama directo al delegado y se borran los métodos que solo delegan.
- **Hide Delegate**: lo inverso. `a.getB().hacer()` pasa a ser `a.hacer()`. Si se abusa, genera Intermediario.
- **Encapsulate Field / Encapsulate Collection**: atributos `private` y acceso por métodos (`add`/`remove` en vez de devolver la lista).
- **Introduce Parameter Object / Preserve Whole Object**: pasar un objeto en vez de N parámetros.
- **Decompose Conditional / Consolidate Conditional Expression / Consolidate Duplicate Conditional Fragments**: sacar la condición a un método, unir condiciones que dan igual y mover fuera del if el código repetido en todas las ramas.
- **Remove Control Flag**: reemplazar un booleano `fin` por `break` o `return`.
- **Replace Parameter with Explicit Methods**: `setValue("height", v)` pasa a ser `setHeight(v)`. **Ojo**: lo inverso (meter un `String tipo` + `switch`) **genera** el smell 12.

---

## 4. Análisis de cada ejercicio

### 4.1 `super` (con consigna oficial)

**ej1 · `CalcularMiCarrito`**

| Smell | Dónde / por qué | Refactorización |
|---|---|---|
| **Atributo temporal** | `porcentajePromoTemporal`, `cuotasTemporales` e `impuestoExtraTemporal`: nullables, se "configuran" y se "limpian" y no forman parte del estado real del carrito | Extract Class (`CondicionesCompra`/`Promocion` con valores por defecto 0 y 1) o Introduce Null Object (sin `null`) |
| **Código duplicado** | `totalEfectivo` y `totalTarjeta` repiten subtotal, descuentos e impuestos | Extract Method: `calcularSubtotal`, `calcularDescuentos`, `calcularImpuestos`. Además `totalTarjeta = totalEfectivo + recargoTarjeta` |
| **Método largo** | Cada `total*` hace 4 cosas | Extract Method |
| **Números mágicos** | `10000`, `0.05`, `0.21`, `0.08`, `0.02`, `3`, `100.0` | Replace Magic Number with Symbolic Constant |
| **Obsesión primitiva** | Ítems como `List<String>` + una sola `cantidad` para todos | Replace Data Value with Object (`ItemCarrito`) (opcional) |
| **Agrupación condicional** (opcional) | Medio de pago resuelto con dos métodos y un `if` de cuotas | Strategy/polimorfismo: `MedioPago` → `Efectivo`, `Tarjeta(cuotas)` |
| Nombre | La clase se llama con un verbo (`CalcularMiCarrito`) | Rename (`Carrito`) |

> ⚠️ **Comportamiento observable**: en el `main` la promo "se arrastra" del caso 2 al 3 y `limpiarConfiguracion()` la borra. Si pasás la configuración como objeto, el `main` nuevo tiene que reproducir eso. Al extraer los cálculos **mantené el orden de las operaciones** (`subtotal - desc + imp + recargo`) para que los `double` impresos no cambien en los últimos decimales.

**ej2 · Intermediario (te lo dicen)**

- **Intermediario**: `GestorCliente.obtenerNombre/Dni/Puntos/Categoria` solo delegan en `Cliente`, así que la clase es un puente innecesario.
  - **Remove Middle Man**: `Run` y `PedidoService` usan `Cliente` directamente (`calcularTotal(items, Cliente cliente)`).
  - **Move Method**: `sumarPuntos` y `aplicaDescuentoPrefer` usan solo datos de `Cliente` (es *Envidia de características*), así que pasan a `Cliente`.
  - **Inline Class**: `GestorCliente` queda vacía y se elimina.
- Efecto colateral bueno: `Cliente` deja de ser una **Clase de datos**. Además `setPuntos` se reemplaza por `sumarPuntos` y `setCategoria` no se usa (es *Código muerto*), así que aplicás **Remove Setting Method**.
- Opcional: `categoria` como `String` `"ORO"`/`"PLATA"` (Obsesión primitiva) → **Replace Type Code with Class** (`enum Categoria`).
- Justificación: menos acoplamiento y menos clases, y el comportamiento queda donde están los datos (cohesión).

### 4.2 `peluqueria` (con consigna oficial)

**ej1 · `Peluquero extends Turno`**

| Smell | Dónde / por qué | Refactorización |
|---|---|---|
| **Legado rechazado** | Un peluquero **no es un** turno. El constructor de 3 parámetros rellena el turno con `"N/A"` y `"0000-00-00"` | Replace Inheritance with Delegation: `Turno` se **asocia** con un `Peluquero` |
| **Lista de parámetros larga** | Constructor de 8 parámetros | Se resuelve al separar las clases |
| **Envidia de características** | `Peluquero.toString()` usa casi todo de `Turno` | Move Method a `Turno` (`mostrarDatosTurno`) |
| **Grupos de datos** | `nombreCliente` + `telefonoCliente` | Extract Class `Cliente` *(tu resuelto no lo hace)* |
| **Intimidad inadecuada** | Atributos de `Turno` sin `private` | Encapsulate Field |
| **Números mágicos** | `0.10` de comisión | Constante |
| **Obsesión primitiva** | `fecha` y `hora` como `String` | Opcional: `LocalDate`/`LocalTime` |

> 🐛 **Bug en el original**: el constructor de 8 parámetros recibe `salari` (con un typo) y hace `this.salario = salario;`, o sea, se asigna el campo a sí mismo y **el salario siempre queda en 0**. Lo comprobé: el original imprime `Salario: 0.0` y `Pago mensual de Marcelo: 8000.0`, mientras que tu resuelto imprime `200000.0` y `208000.0`. **Cambiaste el comportamiento observable.** Según el apunte, *refactorizar no es corregir errores*: en el parcial **mencionalo explícitamente** ("se detectó un error; se corrige por separado de la refactorización") para que no te lo cuenten como que rompiste el comportamiento.

**ej2 · `Gestor` + `Notificador`**: tu archivo `BADSMELLS` solo lista *Lista de parámetros larga*. Faltan los más importantes:

| Smell | Dónde / por qué | Refactorización |
|---|---|---|
| **Obsesión primitiva** (el más fuerte) | **8 listas paralelas** (`nombresClientes`, `telefonosClientes`, …, `turnosFinalizados`) que en realidad representan un `Turno` | Replace Array with Object / Extract Class: `List<Turno>`, con `Turno` que tenga `Cliente`, `Peluquero`, fecha, hora, monto y finalizado |
| **Grupos de datos** | `(nombreCliente, telefonoCliente, nombrePeluquero, especialidadPeluquero)` en **todos** los métodos | Introduce Parameter Object (`Cliente`, `Peluquero`) |
| **Lista de parámetros larga** | `registrarTurno` y `actualizarTurno` (7 parámetros), `Notificador.*` (6 parámetros) | Introduce Parameter Object / Preserve Whole Object (`notificador.enviarRecordatorio(turno)`) |
| **Código duplicado** | El mismo `for` de búsqueda se repite 4 veces. En `Notificador`, las líneas de Cliente y Peluquero están repetidas | Extract Method `buscarTurno(...)` / `imprimirPersonas(turno)` |
| **Código muerto** | En `enviarEncuesta`, el `if` externo ya exige `turnosFinalizados.get(i)`, así que la condición interna `(... isBefore(hoy)) \|\| turnosFinalizados.get(i)` **siempre es true**: `convertirFechaAReal`, `LocalDate.now()` y el `set(i, true)` sobran | Eliminarlo (Remove Dead Code / simplificar el condicional); el comportamiento no cambia |
| **Método largo** | `actualizarTurno`, `enviarEncuesta` | Extract Method |
| **Clase grande / Cambio divergente** | `Gestor` guarda, busca, aplica reglas de negocio, notifica y parsea fechas | Extract Class + Move Method (por ejemplo, `turno.finalizar()` y `turno.puedeActualizarse()`) |

> ⚠️ **Tu `Notificador` del resuelto va en la dirección contraria**: `enviarNotificacion(String tipo, …)` con `switch (tipo)` **introduce** el smell *Estructuras de agrupación condicional*. Es lo opuesto a *Replace Parameter with Explicit Methods*: los dos métodos explícitos (`enviarRecordatorio` y `enviarEncuesta`) estaban bien. Además ese `switch` no tiene `break` (el caso `"encuesta"` cae en `"recordatorio"`) y `this.pintarPersonas()` **no compila** porque le faltan los 4 argumentos.
>
> Reglas que hay que mantener: `actualizarTurno` crea el turno si no existe ("upsert") y no deja actualizar un turno finalizado.

### 4.3 `arrastrar`

| Smell | Dónde / por qué | Refactorización |
|---|---|---|
| **Intimidad inadecuada** *(sí es un bad smell)* | `App` lee y modifica `shape.x`, `shape.y`, `shape.shape1` y `shape.shape2` directamente | Encapsulate Field + Move Method: `shapeItem.moverA(dx, dy)` |
| **Código duplicado** | La elección aleatoria de figura está en `paint` y en `mouseDragged`, y `this.shape.paint(g, rs, c)` aparece en las dos ramas | Extract Method `elegirFigura()` + Consolidate Duplicate Conditional Fragments |
| **Atributo temporal** | `Color c` solo se usa dentro de `paint` | Pasarlo a variable local |
| **Agrupación condicional / Obsesión primitiva** | `if (... % 2 == 0) shape1 else shape2`, aunque ambas son `RectangularShape` | Guardarlas en un array o lista y elegir con `random.nextInt(n)`, sin `if` |
| **Envidia / parámetros innecesarios** | `ShapeItem.paint(g, shape, c)` e `isInside(shape, e)` reciben la figura que el propio `ShapeItem` ya tiene | Remove Parameter |
| Algoritmo enrevesado | `if (cond) return true; return false;` y `nextInt(256) % 2 == 0` | Substitute Algorithm: `return shape.contains(...)`, `random.nextBoolean()` |
| **Números mágicos / nombres** | `256`, `500`, `100`; `shape1`/`shape2` | Constantes; Rename Field (`rectangulo`, `elipse`) |

> ⚠️ Tu resuelto **no compila** (`selectedShape` es variable local del constructor y `shape` ya no existe) y **cambia el comportamiento**: elige la figura una sola vez, cuando el original sortea figura y color en *cada* repintado. Para el parcial, mantené la aleatoriedad tal cual.

### 4.4 `factura`

- **Clase de datos + Intimidad inadecuada**: `Entrada` tiene solo atributos `public` y `Factura` los asigna uno por uno (`e.tarifa = …`). `Tarifa.costo` es `public`. Se resuelve con **Encapsulate Field**, un constructor y Move Method.
- **Agrupación condicional + Obsesión primitiva**: `Tarifa.getDescuento()` hace `if/else` sobre `tipo` (`"NORMAL"`, `"NIÑOS"`, `"JUBILADOS"`). Se resuelve con **Replace Type Code with Class** (un `enum TipoTarifa` con su descuento) o con subclases o polimorfismo.
- **Grupos de datos / Lista de parámetros larga**: `apellidoCliente`, `nombreCliente` y `docCliente` van juntos, así que corresponde **Extract Class `Cliente`**. Lo mismo con `horaDesde` + `horaHasta` (`RangoHorario`).
- **Método largo**: `mostrarFactura` imprime encabezado, cliente y entradas y además suma el total. Se aplica **Extract Method** y **Replace Temp with Query** (`calcularTotal()` en vez de acumular `totalPagar` mientras imprime). Los separadores `****` repetidos van a un método o constante.
- **Código muerto / Generalidad especulativa**: `Tarifa.equals` no se usa en ningún lado (`getTarifa` compara con `getTipo().equals`) y además está sin `hashCode`.
- `getTarifa` devuelve `null` y `addEntrada` hace `return` en silencio: se puede aplicar **Introduce Null Object**.
- Nombre confuso: `getCosto()` en realidad devuelve el costo *con* descuento, mientras que el campo `costo` es el costo sin descuento. Se aplica **Rename Method** (`getCostoFinal`).

### 4.5 `mis-ventas`

- **Código duplicado**: el `if/else` de envío de `MisVentas.calcularTotalDeUnaVenta` es igual a `Venta.calcularEnvio()`, así que basta con llamar al método que ya existe.
- **Envidia de características**: `calcularTotalDeUnaVenta(venta)` usa solo datos de `Venta`. Se aplica **Move Method** y queda `venta.calcularTotal()`.
- **Agrupación condicional** (repetida 3 veces sobre `tipoVenta`) + **Obsesión primitiva** (`String`): se aplica **Replace Type Code with Subclasses / State-Strategy** o un `enum TipoVenta(descuento, envio)`. Si mañana aparece un tipo nuevo, hoy hay que tocar 3 lugares (viola OCP).
- **Clase de datos + Intimidad inadecuada**: `Producto` tiene atributos `public` y `Venta` y `MisVentas` acceden a `p.cantidad * p.precio`. Se aplica **Encapsulate Field** + **Move Method** (`producto.getSubtotal()`, `producto.toString()`).
- `getProductos()` expone la lista interna, lo que pide **Encapsulate Collection**.

### 4.6 `partidos` (leer el `LEEME.txt`)

- **Legado rechazado**: `Jugador extends Equipo`, y un jugador **no es un** equipo (hereda `goles` y `compareTo`). Se aplica **Replace Inheritance with Delegation** o simplemente se quita la herencia.
- **Atributo en la clase equivocada**: `goles` está en `Equipo`, así que si un equipo juega dos partidos, se pisan. Se aplica **Move Field** a `Partido` (`golesLocal`, `golesVisitante`).
- **Intimidad inadecuada / Clase de datos**: `Fechas` toca `partido.local`, `partido.elegido` y `equipo.goles` directamente.
- **Código duplicado**: "crear un `Partido` temporal + buscarlo con un `for`" se repite en `informarGolesPartido` y `elegirJugadorPartido`. Se aplica **Extract Method** `buscarPartido(...)` y se crea un constructor de `Partido`.
- **Grupos de datos**: `(fecha, local, visitante)` aparece en todos los métodos, así que corresponde **Introduce Parameter Object**.
- **Envidia de características**: `mostrarPartidos` formatea los datos de `Partido`, así que pasa a `Partido.toString()`.
- **Mal uso de interfaz**: `compareTo` se usa como `equals` (devuelve solo 0 o 1), compara `Date` con `==` y no mira al visitante. Se aplica **Rename Method / Substitute Algorithm** (`esMismoPartido` o `equals`). `Comparable` no se usa para ordenar, lo que es **Generalidad especulativa**.
- Además: `partido.local = local;` reasigna lo mismo. `Fechas` es Singleton pero con constructor público, y el nombre de la clase no representa lo que guarda (Rename).

### 4.7 `personas`

- **Legado rechazado**: `Alumno extends Docente`, y un alumno no es un docente (hereda `cargo` y `nroLegDocente`). Corresponde `Alumno extends Persona`.
- **Push Down Field**: `nroLegAlumno` y `nroLegDocente` están en `Persona`. Hay que bajarlos a `Alumno` y `Docente`.
- **Código muerto**: el parámetro `nroLegPersonal` del constructor de `Persona` nunca se usa, así que se aplica **Remove Parameter**.
- **Lista de parámetros larga**: constructores de 7 y 9 parámetros.
- **Clases de datos**: `Cargo`, `Carrera`, `TipoDocumento` y `Matricula` tienen solo getters y setters.
- **Atributo en la clase equivocada**: `nroDocumento` está en `TipoDocumento` (el *tipo*), cuando es dato de la persona. Corresponde Extract Class `Documento(tipo, numero)` o Move Field.
- **Intimidad inadecuada**: atributos `protected` (`nroLegAlumno`, `carrera`) usados en las subclases.
- Nombres: `CodCarrera` con mayúscula y sufijos redundantes (`carrera.getNomCarrera()`), que se resuelven con Rename Field/Method. `duracionCarrera` como `String` es Obsesión primitiva.

### 4.8 `chat`

- **Intimidad inadecuada**: `ControlCliente` y `ClienteChat` usan `panel.textField`, `panel.boton`, `panel.textArea` y `panel.socket` (atributos de paquete).
- **Cambio divergente**: `PanelCliente` (vista) guarda el `Socket` (red). Se aplica **Move Field** a `ControlCliente` o a una clase `Conexion`.
- **Código duplicado + Clase de datos**: hay dos clases internas `Cliente` (en el cliente y en el servidor) con solo `public dataInput/dataOutput`. Se aplica **Extract Class `Conexion`** con `enviar(String)` y `recibir()`.
- **Envidia de características**: `ControlCliente.addActionListener`, `addTexto` y `getTexto` trabajan sobre el panel, así que corresponde **Move Method** a `PanelCliente`.
- **Números mágicos duplicados**: el puerto `5557` aparece en cliente y servidor, y también `"localhost"` y `500`. Corresponde una constante compartida.
- Constructores que hacen todo (`ServidorChat` corre el loop infinito en el constructor): **Extract Method**.

### 4.9 `figuras`

- **Obsesión primitiva / Grupos de datos**: `shape1..4` + `color1..4` en paralelo. Se aplica **Extract Class `Figura(shape, color)`** + `List<Figura>`.
- **Código duplicado**: el `if/else if` de `mouseClicked` y los 4 bloques `setColor`/`fill` pasan a ser un loop. **Ojo**: con `else if` solo se pinta la primera figura que coincide, así que el loop necesita `break`.
- `random` vive en `App` pero solo lo usa `ShapesPanel`, así que se aplica **Move Field**.
- **Números mágicos**: `100`, `110`, `212`, `256`.

### 4.10 `ta-te-ti`

- **Método largo**: todo está en `main` (es el ejemplo de manual de "legado de la programación estructurada"). Se aplica **Extract Method**: `inicializarTablero`, `mostrarTablero`, `pedirJugada`, `cambiarTurno`.
- **Código duplicado**: el loop que imprime el tablero aparece 2 veces, hay dos `if (jugador1)` seguidos y en `gano()` la misma comparación de 3 casillas se repite 4 veces (Extract Method `lineaCompleta(a, b, c)`).
- **Obsesión primitiva**: `char[][]` con `'-'`, `'X'` y `'O'`, y los jugadores como `String p1/p2`. Se aplica **Replace Array with Object** (`Tablero`) y **Extract Class** `Jugador(nombre, ficha)`.
- **Remove Control Flag**: el booleano `fin`.
- **Introduce Explaining Variable**: `gano(tablero)` se llama dos veces seguidas.
- **Números mágicos** (`3`) y nombres pobres (`c`, `p1`, `in`): constantes y Rename.

---

## 5. Checklist rápido para el examen

1. **Herencia**: ¿"X es un Y" tiene sentido? Si no, es **Legado rechazado** y se resuelve con delegación o composición. (Aparece en peluquería, partidos y personas.)
2. **Atributos públicos o de paquete** que otra clase toca: **Intimidad inadecuada** + Encapsulate Field.
3. **Clases con solo getters y setters**: **Clase de datos**. Buscá qué lógica de afuera usa esos datos y aplicá Move Method.
4. **`if/else` o `switch` sobre un `String` de tipo**: **Agrupación condicional** + **Obsesión primitiva**. Se resuelve con `enum`, subclases o polimorfismo.
5. **El mismo bloque en dos lugares**: **Código duplicado** + Extract Method.
6. **Los mismos 3 o 4 parámetros en todos lados**: **Grupos de datos** + **Lista de parámetros larga**. Se resuelve con Introduce Parameter Object.
7. **Un método que usa datos de otra clase**: **Envidia de características** + Move Method.
8. **Una clase que solo delega**: **Intermediario** + Remove Middle Man / Inline Class.
9. **Atributos `null` o "temporales"** que se configuran y se limpian: **Atributo temporal**.
10. **Listas o arrays paralelos**: Replace Array with Object.
11. **Parámetros o métodos sin uso, o condiciones que siempre dan igual**: **Código muerto**.
12. **Antes de entregar**: ¿el `main` imprime **exactamente lo mismo**? ¿Compila? Si encontraste un bug, **decilo aparte** y no lo mezcles con la refactorización.
