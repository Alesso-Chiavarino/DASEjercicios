# Guía de Bad Smells — dónde buscar cada uno en el proyecto

Esta guía sirve para encontrar rápido cada *bad smell* de la clase de Refactorización, ver **dónde está** en el código de ejemplo y **qué refactorización** se aplicó.

- Cada ejemplo tiene dos carpetas: `original/` (con el smell) y `refact/` (ya refactorizado).
- Ruta base de todos los ejemplos: `src/main/java/ar/edu/ubp/das/`
- Las explicaciones de la refactorización también están comentadas al final de cada `refact/Run.java`.
- Algunos smells **no tienen ejemplo en el proyecto**. Para esos hay un mini ejemplo en esta guía.

**Contenido**
- **Parte 1 — Bad smells:** dónde está cada uno en el proyecto, por qué es un problema y cómo se refactorizó.
- **[Parte 2 — Catálogo de refactorizaciones](#parte-2--catálogo-de-refactorizaciones-con-ejemplos):** cada refactorización con código antes/después, cuándo usarla y qué smell resuelve. Al final, pasos para refactorizar seguro y atajos de IntelliJ.
- **[Parte 3 — Lo que agrega el apunte de la cátedra](#parte-3--lo-que-agrega-el-apunte-de-la-cátedra):** la tabla oficial smell → refactorizaciones (comparada con los ejemplos), la teoría del apunte y las refactorizaciones que faltaban. Donde el apunte propone otra refactorización que el ejemplo, la Parte 1 lo marca con 📘.

---

## Índice rápido

| # | Smell | Ejemplo | Qué buscar | Refactorización |
|---|---|---|---|---|
| 1 | [Temporary Field](#1-temporary-field-atributo-temporal) | `ejemplo01` | Atributo que solo tiene sentido después de llamar a cierto método | Replace Temp with Query |
| 2 | [Message Chains](#2-message-chains-cadena-de-mensajes) | `ejemplo02` | `a.getB().getC().algo()` | Hide Delegate |
| 3 | [Divergent Change](#3-divergent-change-cambio-divergente) | `ejemplo03` | **Una** clase que cambia por **muchos** motivos | Extract Class |
| 4 | [Shotgun Surgery](#4-shotgun-surgery-cambio-en-cadena) | `ejemplo04` | **Un** cambio obliga a tocar **muchas** clases | Extract Class / Move Method |
| 5 | [Data Class](#5-data-class-clase-de-datos) | `ejemplo05` | Clase con solo getters/setters, la lógica está afuera | Move Method + Encapsulate Field |
| 6 | [Dead Code](#6-dead-code-código-muerto) | *(se ve en `ejemplo04`)* | Métodos, atributos o clases que nadie usa | Eliminar |
| 7 | [Large Class](#7-large-class-clase-grande) | *(sin ejemplo)* | Clase enorme con atributos agrupables por tema | Extract Class |
| 8 | [Lazy Class](#8-lazy-class-clase-perezosa) | *(sin ejemplo)* | Clase que hace tan poco que no justifica existir | Inline Class / Collapse Hierarchy |
| 9 | [Comments](#9-comments-comentarios) | *(sin ejemplo)* | Comentarios que explican **qué** hace un código confuso | Extract Method / Rename |
| 10 | [Duplicated Code](#10-duplicated-code-código-duplicado) | *(se ve en `ejemplo04`)* | La misma lógica en más de un lugar | Extract Method / Pull Up / Extract Class |
| 11 | [Feature Envy](#11-feature-envy-envidia-de-características) | `ejemplo06` | Método que usa más datos de otra clase que de la suya | Move Method |
| 12 | [Switch Statements](#12-switch-statements) | `ejemplo07` | `switch` / `if-else` según el **tipo** de algo | Replace Conditional with Polymorphism |
| 13 | [Speculative Generality](#13-speculative-generality-generalidad-especulativa) | *(sin ejemplo)* | Código "por si acaso" que nadie usa hoy | Collapse Hierarchy / Remove Parameter / Inline Class |
| 14 | [Data Clumps](#14-data-clumps-grupo-de-datos) | `ejemplo08` | Los mismos datos siempre viajando juntos | Extract Class |
| 15 | [Middleman](#15-middleman-intermediario) | `ejemplo09` | Clase que solo hace `return otro.algo()` | Remove Middle Man |
| 16 | [Inappropriate Intimacy](#16-inappropriate-intimacy-intimidad-inadecuada) | `ejemplo10` | `otroObjeto.atributo` (acceso directo a atributos ajenos) | Encapsulate Field |
| 17 | [Parallel Inheritance](#17-parallel-inheritance-hierarchies-jerarquías-paralelas) | `ejemplo11` | Dos jerarquías con subclases "gemelas" | Replace Inheritance with Delegation |
| 18 | [Refused Bequest](#18-refused-bequest-legado-rechazado) | `ejemplo12` | Subclase que hereda cosas que no usa o no le corresponden | Push Down Field/Method |
| 19 | [Long Parameter List](#19-long-parameter-list-lista-de-parámetros-larga) | `ejemplo13` | Métodos/constructores con 4+ parámetros | Introduce Parameter Object / Replace Data Value with Object |
| 20 | [Long Method](#20-long-method-método-largo) | *(se ve en `ejemplo13`)* | Método que hace varias cosas mezcladas | Extract Method |
| 21 | [Primitive Obsession](#21-primitive-obsession-obsesión-primitiva) | `ejemplo14` | `String`/`int` para conceptos con reglas (teléfono, dirección) | Replace Primitive with Object |
| 22 | [Alternative Classes with Different Interfaces](#22-alternative-classes-with-different-interfaces) | `ejemplo15` | Clases que hacen lo mismo con métodos de distinto nombre | Rename Method + Extract Interface |
| 23 | [Incomplete Library Class](#23-incomplete-library-class-biblioteca-incompleta) | *(sin ejemplo)* | Lógica que "completa" una clase externa, repetida | Herencia / Decorador / Adaptador |

---

## 1. Temporary Field (atributo temporal)

**Idea:** un atributo debería describir al objeto **siempre**. Si solo tiene sentido después de llamar a cierto método, es una cuenta intermedia disfrazada de atributo.

**Dónde mirar:**
- Smell: [`ejemplo01/original/Pedido.java`](src/main/java/ar/edu/ubp/das/ejemplo01/original/Pedido.java) → atributo `totalConDescuento`
- Refactor: [`ejemplo01/refact/Pedido.java`](src/main/java/ar/edu/ubp/das/ejemplo01/refact/Pedido.java)

**El problema:**
- `imprimirFactura()` depende de que antes se haya llamado a `calcularDescuento()` (orden oculto).
- Usa `totalConDescuento > 0` para saber "si hubo descuento": con un descuento del 100% el total queda en 0 y la factura dice **"sin descuento"**. Error.

**Refactorización:** *Replace Temp with Query*. Se elimina el atributo y el total se calcula como variable local dentro de `imprimirFactura(double descuento)`.

> 📘 **Apunte de la cátedra:** *Extract Class* (llevar el atributo y los métodos que lo usan a una clase propia) e *Introduce Null Object*. Ver [Parte 3](#31-tabla-oficial-bad-smell--refactorizaciones).

**Cómo detectarlo:** ¿este atributo tiene sentido apenas creo el objeto? Si la respuesta es "solo después de llamar a X", es temporal.

---

## 2. Message Chains (cadena de mensajes)

**Idea:** hablá solo con tus "conocidos directos", no con los amigos de tus amigos (Ley de Demeter).

**Dónde mirar:**
- Smell: [`ejemplo02/original/Pedido.java`](src/main/java/ar/edu/ubp/das/ejemplo02/original/Pedido.java) → `imprimirCliente()` hace `cliente.getDireccion().getCalle()`, `.getNroCalle()`, `.getCiudad()`
- Refactor: [`ejemplo02/refact/Direccion.java`](src/main/java/ar/edu/ubp/das/ejemplo02/refact/Direccion.java) (`getDireccionCompleta()`), [`ejemplo02/refact/Cliente.java`](src/main/java/ar/edu/ubp/das/ejemplo02/refact/Cliente.java) (`getDireccion()` devuelve el texto), [`ejemplo02/refact/Pedido.java`](src/main/java/ar/edu/ubp/das/ejemplo02/refact/Pedido.java)

**El problema:** `Pedido` conoce la estructura interna de `Cliente` **y** de `Direccion`. Si `Direccion` cambia, se rompe `Pedido`.

**Refactorización:** *Hide Delegate*. `Cliente` ofrece directamente lo que `Pedido` necesita y esconde que existe `Direccion`.

**Cómo detectarlo:** más de un punto seguido de getters: `a.getB().getC()...`

> Detalle: en el refactor `nroCalle` pasó de `String` a `int`. No tiene que ver con el smell.

---

## 3. Divergent Change (cambio divergente)

**Idea:** una clase debería tener **un solo motivo para cambiar** (SRP).

**Dónde mirar:**
- Smell: [`ejemplo03/original/Empleado.java`](src/main/java/ar/edu/ubp/das/ejemplo03/original/Empleado.java) → mezcla `calcularSalarioTotal()` (negocio), `generarInforme()` (presentación) y `guardarEmpleado()` (persistencia)
- Refactor: [`ejemplo03/refact/Empleado.java`](src/main/java/ar/edu/ubp/das/ejemplo03/refact/Empleado.java), [`EmpleadoReporteGenerator.java`](src/main/java/ar/edu/ubp/das/ejemplo03/refact/EmpleadoReporteGenerator.java), [`EmpleadoRepository.java`](src/main/java/ar/edu/ubp/das/ejemplo03/refact/EmpleadoRepository.java)

**El problema:** `Empleado` cambia si cambia el cálculo del sueldo, si cambia el formato del informe **o** si cambia la base de datos. Tres motivos sin relación.

**Refactorización:** *Extract Class*. Cada responsabilidad pasa a su propia clase.

**Cómo detectarlo:** ¿por cuántos motivos distintos podría tener que modificar esta clase? Si son 2 o más sin relación entre sí, es Divergent Change.

> Detalle: en el refactor, `guardarEmpleado()` no recibe el empleado como parámetro. Es una simplificación del ejemplo.

---

## 4. Shotgun Surgery (cambio en cadena)

**Idea:** un cambio de negocio debería tocar **un solo lugar**. Es el **opuesto** de Divergent Change.

**Dónde mirar:**
- Smell: [`ejemplo04/original/Empleado.java`](src/main/java/ar/edu/ubp/das/ejemplo04/original/Empleado.java) y [`ejemplo04/original/RRHH.java`](src/main/java/ar/edu/ubp/das/ejemplo04/original/RRHH.java)
  - `salario * 0.05 * añosTrabajados` está en las **dos** clases
  - `añosTrabajados * 2` (vacaciones) está en las **dos** clases
  - `registrarAumento` en `Empleado`, `registrarPromocion` en `RRHH` (lógica de registro partida)
- Refactor: [`BonificacionesService.java`](src/main/java/ar/edu/ubp/das/ejemplo04/refact/BonificacionesService.java), [`VacacionesService.java`](src/main/java/ar/edu/ubp/das/ejemplo04/refact/VacacionesService.java), [`RegistroService.java`](src/main/java/ar/edu/ubp/das/ejemplo04/refact/RegistroService.java), [`RRHH.java`](src/main/java/ar/edu/ubp/das/ejemplo04/refact/RRHH.java)

**El problema:** si la bonificación pasa al 7%, hay que cambiarla en dos clases. Si te olvidás de una, **no hay error**: el sistema calcula dos valores distintos para lo mismo.

**Refactorización:** *Extract Class*. Cada regla de negocio queda en **una** clase de servicio y todos la usan.

> 📘 **Apunte de la cátedra:** *Move Method*, *Move Field*, *Inline Class* (juntar en un solo lugar lo que está desparramado).

**Cómo detectarlo:** si cambia esta regla, ¿cuántas clases tengo que abrir? Pista: los mismos números o fórmulas repetidos en clases distintas.

| | Divergent Change | Shotgun Surgery |
|---|---|---|
| Síntoma | **Una** clase, **muchos** motivos de cambio | **Un** motivo, **muchas** clases a cambiar |
| Problema | Demasiadas cosas juntas | Una cosa desparramada |
| Solución | Separar | Juntar |

---

## 5. Data Class (clase de datos)

**Idea:** un objeto guarda sus datos **y sabe qué hacer con ellos**. Si solo tiene getters y setters, la lógica termina afuera.

**Dónde mirar:**
- Smell: [`ejemplo05/original/CuentaBancaria.java`](src/main/java/ar/edu/ubp/das/ejemplo05/original/CuentaBancaria.java) → solo `get`/`set`, con un `setSaldo()` público
- Refactor: [`ejemplo05/refact/CuentaBancaria.java`](src/main/java/ar/edu/ubp/das/ejemplo05/refact/CuentaBancaria.java) → `depositar()` y `retirar()` con validación, sin setters

**El problema:**
- Cada clase que quiera retirar plata tiene que escribir la validación (lógica dispersa y duplicada).
- `cuenta.setSaldo(-50000)` compila: los atributos son `private` pero el setter anula esa protección.

**Refactorización:** *Move Method* (la lógica entra a la clase) + *Encapsulate Field* (se sacan los setters).

**Cómo detectarlo:** solo getters/setters, y en otras clases aparece `x.setAlgo(x.getAlgo() + ...)`.

> Matiz: no toda clase de datos es mala (por ejemplo, objetos para transportar datos entre capas). El smell aparece cuando la clase representa algo **con reglas propias**.

---

## 6. Dead Code (código muerto)

**Idea:** si no se usa, se borra. Git guarda el historial.

**Dónde mirar (no tiene ejemplo propio, pero aparece en el ejemplo 4):**
- [`ejemplo04/original/Empleado.java`](src/main/java/ar/edu/ubp/das/ejemplo04/original/Empleado.java) → `calcularBonificacion()` y `calcularDiasVacaciones()` **nunca se llaman**. `RRHH` hace la cuenta por su lado.

**El problema:**
- Confunde: parece que la bonificación se calcula en `Empleado`, pero la que vale es la de `RRHH`.
- Alguien puede "corregir" el método muerto (cambiar 0.05 por 0.07) y creer que arregló algo.

**Formas típicas:** métodos o clases sin uso, variables o parámetros ignorados, código después de un `return`, `if (false)`, **código comentado** "por las dudas".

**Refactorización:** eliminarlo.

> 📘 **Apunte de la cátedra:** *Inline Class*, *Collapse Hierarchy*, *Remove Parameter* (según si lo muerto es una clase, una jerarquía o un parámetro).

**Cómo detectarlo:** en IntelliJ el código sin uso aparece en **gris**. Clic derecho → *Find Usages*.

---

## 7. Large Class (clase grande)

**Idea:** una clase enorme casi siempre está haciendo el trabajo de varias.

**Sin ejemplo en el proyecto.** Mini ejemplo:

```java
public class Tienda {
    private List<Producto> productos; private Map<String,Integer> stock;   // inventario
    private List<Cliente> clientes;   private Map<Cliente,Integer> puntos; // clientes
    private List<Venta> ventas;       private double totalVendidoHoy;      // ventas
    private String servidorMail;      private String rutaBaseDatos;        // config

    public void agregarProducto(...) {}  public void sumarPuntos(...) {}
    public void registrarVenta(...) {}   public void enviarMailPromocion(...) {}
    public void generarReporteMensual(...) {}  public void guardarEnBaseDeDatos(...) {}
    // ... 40 métodos más
}
```

**El problema:** rompe SRP, cuesta entenderla, es fácil romper algo y **genera otros smells** (Divergent Change, Duplicated Code, Long Method).

**Refactorización:** *Extract Class*. Cada grupo de atributos con sus métodos pasa a su propia clase (`Inventario`, `GestorClientes`, `RegistroVentas`, `ServicioMail`, `TiendaRepository`…).

**Cómo detectarlo:** ¿puedo agrupar sus atributos por tema? ¿Hay métodos que solo usan uno de esos grupos?

| | Large Class | Divergent Change |
|---|---|---|
| Lo notás… | **Mirando** la clase (es enorme) | **Cambiando** la clase (por motivos distintos) |
| Solución | Extract Class | Extract Class |

---

## 8. Lazy Class (clase perezosa)

**Idea:** cada clase tiene un costo. Si hace casi nada, sobra. Es el **opuesto** de Large Class.

**Sin ejemplo en el proyecto.** Mini ejemplo:

```java
public class CalculadoraIVA {
    public double calcular(double monto) { return monto * 0.21; }
}
// Solo la usa Factura → mejor poner esa línea directamente en Factura.
```

**De dónde sale:** quedó vacía después de refactorizar, se creó "por si crece" (ver Speculative Generality), o la funcionalidad se recortó.

**Refactorización:** *Inline Class* (meter su contenido en quien la usa) o *Collapse Hierarchy* (si es una subclase que no agrega nada).

**Ojo, chica ≠ perezosa:** [`ejemplo14/refact/Telefono.java`](src/main/java/ar/edu/ubp/das/ejemplo14/refact/Telefono.java) es muy chica pero **no** es Lazy Class, porque garantiza que no exista un teléfono inválido.

**Cómo detectarlo:** si borro esta clase y paso su contenido a quien la usa, ¿pierdo algo? Si no, es perezosa.

---

## 9. Comments (comentarios)

**Idea:** los comentarios no son malos. Huele mal cuando hacen falta para entender **qué** hace el código: son "desodorante" sobre código poco claro.

**Sin ejemplo en el proyecto.** Mini ejemplo:

```java
// ❌ Antes
public double calcular(Pedido p) {
    // sumo los precios
    double t = 0; for (Producto x : p.getProductos()) t += x.getPrecio();
    // si tiene más de 5 años, 10% de descuento
    if (p.getCliente().getAntiguedad() > 5) t = t * 0.9;
    // le sumo el IVA
    return t * 1.21;
}

// ✅ Después
public double calcularTotalConIVA(Pedido pedido) {
    double subtotal = sumarPrecios(pedido);
    double conDescuento = aplicarDescuentoPorAntiguedad(subtotal, pedido.getCliente());
    return agregarIVA(conDescuento);
}
```

**El problema:** el comentario tapa un problema de diseño, se desactualiza (el compilador no lo revisa) y repite lo que ya dice el código.

**Refactorización:** *Extract Method* (el comentario pasa a ser el nombre del método), *Rename*, constantes con nombre.

**Comentarios que SÍ suman:** los que explican **por qué** se tomó una decisión, advertencias, Javadoc de API pública.

**Cómo detectarlo:** tapá el comentario. ¿Se entiende el código igual? Si no, el problema es el código.

---

## 10. Duplicated Code (código duplicado)

**Idea:** cada pieza de lógica en **un solo lugar** (DRY: *Don't Repeat Yourself*).

**Dónde mirar (sin ejemplo propio, pero aparece en el ejemplo 4):**
- [`ejemplo04/original/Empleado.java`](src/main/java/ar/edu/ubp/das/ejemplo04/original/Empleado.java) y [`ejemplo04/original/RRHH.java`](src/main/java/ar/edu/ubp/das/ejemplo04/original/RRHH.java) → la misma fórmula `salario * 0.05 * años` en ambas.

**Tipos:**
- **Directa:** el mismo código copiado.
- **Sutil:** código que se ve distinto pero hace lo mismo (un `for` en una clase y un `stream` en otra, ambos sumando precios).

**Refactorización según dónde esté la duplicación:**

| Dónde | Refactorización |
|---|---|
| Misma clase | Extract Method |
| Subclases hermanas | Pull Up Method |
| Clases sin relación | Extract Class (como `BonificacionesService` en ej. 4) |
| Parecido pero no igual | Form Template Method |

**Ojo:** `iva = monto * 0.21` y `recargoTarjeta = monto * 0.21` **no** son duplicación: son conceptos distintos que coinciden por casualidad.

**Cómo detectarlo:** si cambia la regla, ¿tengo que tocar todos esos lugares? Si sí, es duplicación.

---

## 11. Feature Envy (envidia de características)

**Idea:** un método debería trabajar con los datos de **su** clase. Si usa más los de otra, está en la clase equivocada.

**Dónde mirar:**
- Smell: [`ejemplo06/original/Pedido.java`](src/main/java/ar/edu/ubp/das/ejemplo06/original/Pedido.java) → `calcularDescuento()` usa `cliente.getAntiguedad()` (x2) y `cliente.getEmail()`; de `Pedido` solo usa `montoTotal`
- Refactor: [`ejemplo06/refact/Cliente.java`](src/main/java/ar/edu/ubp/das/ejemplo06/refact/Cliente.java) (`calcularDescuento(double montoTotal)`), [`ejemplo06/refact/Pedido.java`](src/main/java/ar/edu/ubp/das/ejemplo06/refact/Pedido.java) (`aplicarDescuento()`)

**El problema:** baja cohesión, acoplamiento con `Cliente`, y si otra clase necesita el descuento, lo va a copiar.

**Refactorización:** *Move Method*. Fijate que en el refactor el método usa `antiguedad` y `email` directamente (atributos propios).

**Relación con Data Class:** el `Cliente` original era una Data Class y `Pedido` tenía Feature Envy sobre él. Un *Move Method* arregla los dos.

**Cómo detectarlo:** contá cuántos `otro.getAlgo()` usa vs. cuántos atributos propios.

> Detalle: en `ejemplo06/original/Run.java` el resultado de `calcularDescuento()` se descarta y se imprime `getMontoTotal()`. O sea, imprime el monto **sin** descuento. Es un descuido del ejemplo.

---

## 12. Switch Statements

**Idea:** un `switch` según el **tipo** obliga a modificarlo cada vez que aparece un tipo nuevo, y suele repetirse en varios lugares.

**Dónde mirar:**
- Smell: [`ejemplo07/original/Calculadora.java`](src/main/java/ar/edu/ubp/das/ejemplo07/original/Calculadora.java) → `switch (tipoOperacion)` con `"suma"`, `"resta"`, etc.
- Refactor: [`Operacion.java`](src/main/java/ar/edu/ubp/das/ejemplo07/refact/Operacion.java) (interfaz), [`Suma.java`](src/main/java/ar/edu/ubp/das/ejemplo07/refact/Suma.java), [`Resta.java`](src/main/java/ar/edu/ubp/das/ejemplo07/refact/Resta.java), [`Multiplicacion.java`](src/main/java/ar/edu/ubp/das/ejemplo07/refact/Multiplicacion.java), [`Division.java`](src/main/java/ar/edu/ubp/das/ejemplo07/refact/Division.java), [`Calculadora.java`](src/main/java/ar/edu/ubp/das/ejemplo07/refact/Calculadora.java)

**El problema:**
- Agregar una operación obliga a **modificar** `Calculadora` (rompe Abierto/Cerrado).
- Si el mismo `switch` aparece en varios lugares → Shotgun Surgery.
- `calcular("sumaa", ...)` compila y explota en ejecución.

**Refactorización:** *Replace Conditional with Polymorphism*. Cada `case` pasa a ser una clase que implementa `Operacion`. Agregar `Potencia` = crear una clase nueva, sin tocar nada existente.

**¿Para qué la interfaz?** Es un **contrato** (la "ficha del enchufe"): garantiza que todo lo que sea `Operacion` tiene `ejecutar()`. Sin ella, `Calculadora` no tendría un tipo común para recibir y volvería a necesitar `if/instanceof`.

**Ojo:** un `switch` único que no se repite y no crece (días de la semana, una fábrica) está bien.

---

## 13. Speculative Generality (generalidad especulativa)

**Idea:** no programar para un futuro imaginado (YAGNI: *You Aren't Gonna Need It*).

**Sin ejemplo en el proyecto.** Mini ejemplo:

```java
// Hoy solo se exporta a PDF, pero "por si acaso"...
public abstract class ExportadorBase {                    // un solo hijo
    public abstract void exportar(Reporte r, String formato, boolean comprimir,
                                  String idioma, int version);   // parámetros que siempre valen lo mismo
    protected void antesDeExportar() { }                  // hook que nadie usa
}
public interface ConfigurableExportador { void configurar(Map<String,Object> o); }  // una sola implementación, vacía

// Lo que realmente hace falta:
public class ExportadorPDF { public void exportar(Reporte r) { ... } }
```

**Refactorización:** *Collapse Hierarchy*, *Inline Class*, *Remove Parameter*, borrar métodos sin uso.

**¿Y `Operacion` del ejemplo 7?** Está justificada: tiene 4 implementaciones **hoy** y resuelve un problema real.

**Diferencia con Dead Code:** el código muerto se usó alguna vez; la generalidad especulativa **nunca** se usó.

**Cómo detectarlo:** interfaces/abstractas con una sola implementación, parámetros siempre iguales, métodos vacíos, nombres muy genéricos (`ManagerBase`).

---

## 14. Data Clumps (grupo de datos)

**Idea:** datos que **siempre viajan juntos** forman una unidad y deberían ser una clase.

**Dónde mirar:**
- Smell: [`ejemplo08/original/Cliente.java`](src/main/java/ar/edu/ubp/das/ejemplo08/original/Cliente.java) → `calle, nroCalle, ciudad, codigoPostal, pais` en atributos, en el constructor, en `actualizarDireccion(...)` y en `mostrarInformacion()`
- Refactor: [`ejemplo08/refact/Direccion.java`](src/main/java/ar/edu/ubp/das/ejemplo08/refact/Direccion.java), [`ejemplo08/refact/Cliente.java`](src/main/java/ar/edu/ubp/das/ejemplo08/refact/Cliente.java)

**El problema:** se repite en cada clase que tenga dirección; con 5 `String` seguidos es fácil invertir el orden (compila igual); la lógica de la dirección no tiene dónde vivir.

**Refactorización:** *Extract Class*. Constructor de 7 → 3 parámetros; `actualizarDireccion` de 5 → 1.

**Prueba de Fowler:** sacá uno de los datos. ¿Los demás siguen teniendo sentido solos? Si no, es un grupo.

---

## 15. Middleman (intermediario)

**Idea:** una clase que solo pasa pedidos a otra, sin agregar nada, sobra.

**Dónde mirar:**
- Smell: [`ejemplo09/original/ClienteEngine.java`](src/main/java/ar/edu/ubp/das/ejemplo09/original/ClienteEngine.java) → `getNombreCliente()` y `getEmailCliente()` solo hacen `return cliente.getX()`
- Refactor: [`ejemplo09/refact/Pedido.java`](src/main/java/ar/edu/ubp/das/ejemplo09/refact/Pedido.java) → usa `Cliente` directamente; `ClienteEngine` se eliminó

**El problema:** clase sin valor que hay que mantener; cada dato nuevo de `Cliente` exige un método nuevo en el intermediario.

**Refactorización:** *Remove Middle Man*.

**Relación con Message Chains (son opuestos):**

| Message Chains | Middleman |
|---|---|
| Muy poca delegación | Demasiada delegación |
| Solución: Hide Delegate | Solución: Remove Middle Man |

Aplicar Hide Delegate de más termina creando un Middleman.

**Ojo:** un intermediario está bien si **agrega algo** (valida, controla permisos, registra, cachea, traduce).

---

## 16. Inappropriate Intimacy (intimidad inadecuada)

**Idea:** una clase no se mete en los datos internos de otra; los **pide** por métodos públicos.

**Dónde mirar:**
- Smell: [`ejemplo10/original/Cliente.java`](src/main/java/ar/edu/ubp/das/ejemplo10/original/Cliente.java) → `nombre` y `email` **sin `private`** (acceso de paquete)
- Smell: [`ejemplo10/original/Pedido.java`](src/main/java/ar/edu/ubp/das/ejemplo10/original/Pedido.java) → `cliente.nombre`, `cliente.email`
- Refactor: [`ejemplo10/refact/Cliente.java`](src/main/java/ar/edu/ubp/das/ejemplo10/refact/Cliente.java) (atributos `private` + getters), [`ejemplo10/refact/Pedido.java`](src/main/java/ar/edu/ubp/das/ejemplo10/refact/Pedido.java)

**El problema:** si `Cliente` cambia cómo guarda sus datos, se rompe `Pedido`; además cualquiera puede hacer `cliente.email = "..."` sin control.

**Refactorización:** *Encapsulate Field*.

> 📘 **Apunte de la cátedra:** *Move Method*, *Move Field*, *Change Bidirectional Association to Unidirectional*, *Replace Inheritance with Delegation*, *Hide Delegate*. El ejemplo 10 es el caso más simple; el apunte apunta a clases que se conocen demasiado entre sí. Ver [Parte 3](#31-tabla-oficial-bad-smell--refactorizaciones).

**¿Por qué un getter si devuelve lo mismo?** Porque es una "puerta" que controla `Cliente`: puede cambiar por dentro (por ejemplo, `return nombre + " " + apellido`) sin que `Pedido` se entere, y sin setter nadie puede escribir.

| Smell | Qué pasa |
|---|---|
| Inappropriate Intimacy | `cliente.nombre` (acceso directo al atributo) |
| Message Chains | `cliente.getDireccion().getCalle()` (cadena) |
| Feature Envy | Un método usa más datos ajenos que propios |

---

## 17. Parallel Inheritance Hierarchies (jerarquías paralelas)

**Idea:** si cada subclase nueva en un árbol obliga a crear su "gemela" en otro árbol, los dos representan lo mismo dos veces.

**Dónde mirar:**
- Smell (jerarquía 1): [`Empleado.java`](src/main/java/ar/edu/ubp/das/ejemplo11/original/Empleado.java), [`EmpleadoTiempoCompleto.java`](src/main/java/ar/edu/ubp/das/ejemplo11/original/EmpleadoTiempoCompleto.java), [`EmpleadoTiempoParcial.java`](src/main/java/ar/edu/ubp/das/ejemplo11/original/EmpleadoTiempoParcial.java)
- Smell (jerarquía 2): [`EstrategiaPago.java`](src/main/java/ar/edu/ubp/das/ejemplo11/original/EstrategiaPago.java), [`PagoTiempoCompleto.java`](src/main/java/ar/edu/ubp/das/ejemplo11/original/PagoTiempoCompleto.java), [`PagoTiempoParcial.java`](src/main/java/ar/edu/ubp/das/ejemplo11/original/PagoTiempoParcial.java)
- Refactor: [`ejemplo11/refact/Empleado.java`](src/main/java/ar/edu/ubp/das/ejemplo11/refact/Empleado.java) (tiene una `EstrategiaPago`), [`ejemplo11/refact/EstrategiaPago.java`](src/main/java/ar/edu/ubp/das/ejemplo11/refact/EstrategiaPago.java) (ahora interfaz)

```
      Empleado                      EstrategiaPago
      /      \                       /         \
EmpTiempo  EmpTiempo           PagoTiempo   PagoTiempo
Completo   Parcial              Completo     Parcial
```

**El problema:** todo se agrega de a dos; el `3000` y el `1500` están escritos dos veces; no queda claro cuál es la versión válida.

**Refactorización:** *Replace Inheritance with Delegation*. El empleado **tiene** una estrategia de pago ("tiene un" en vez de "es un"). Además permite cambiar la forma de pago en ejecución.

> 📘 **Apunte de la cátedra:** *Move Method*, *Move Field*. La idea es que una jerarquía referencie a la otra (lo que hace el ejemplo) y después mover métodos y atributos hasta que una jerarquía desaparezca.

> El refactor del ejemplo quedó **a medias**: `EmpleadoTiempoCompleto` y `EmpleadoTiempoParcial` siguen existiendo (ya sin lógica, solo eligen la estrategia). El paso final sería eliminarlas y crear `new Empleado("X", new PagoTiempoCompleto())`.

---

## 18. Refused Bequest (legado rechazado)

**Idea:** la subclase hereda **todo** del padre. Si recibe cosas que no le sirven o no le corresponden, la herencia está mal armada.

**Dónde mirar:**
- Smell: [`ejemplo12/original/Persona.java`](src/main/java/ar/edu/ubp/das/ejemplo12/original/Persona.java) → `salario` está en el padre
- Smell: [`ejemplo12/original/Alumno.java`](src/main/java/ar/edu/ubp/das/ejemplo12/original/Alumno.java) → `super(nombre, edad, 0)` (el `0` de relleno es la señal)
- Refactor: [`ejemplo12/refact/Persona.java`](src/main/java/ar/edu/ubp/das/ejemplo12/refact/Persona.java), [`ejemplo12/refact/Empleado.java`](src/main/java/ar/edu/ubp/das/ejemplo12/refact/Empleado.java) (ahora tiene `salario`), [`ejemplo12/refact/Alumno.java`](src/main/java/ar/edu/ubp/das/ejemplo12/refact/Alumno.java)

**El problema:** un alumno "tiene salario 0", que es falso en el dominio y genera errores silenciosos (por ejemplo, baja el promedio de sueldos).

**Refactorización:** *Push Down Field / Method* (el ejemplo lo llama "Pull Down Field", el nombre oficial es **Push Down**). Si la subclase en realidad no "es un" tipo del padre: *Replace Inheritance with Delegation*.

> 📘 **Apunte de la cátedra:** solo *Replace Inheritance with Delegation* (el caso fuerte, donde la subclase no es realmente un tipo del padre).

**Versión fuerte:** `Pinguino extends Ave` y sobreescribe `volar()` para tirar `UnsupportedOperationException`.

**Cómo detectarlo:** valores de relleno (`0`, `null`, `""`) en el `super(...)`, métodos heredados sobreescritos vacíos o con excepción.

---

## 19. Long Parameter List (lista de parámetros larga)

**Idea:** muchos parámetros = difícil de usar, fácil de equivocarse, y casi siempre faltan objetos.

**Dónde mirar:**
- Smell: [`ejemplo13/original/Pedido.java`](src/main/java/ar/edu/ubp/das/ejemplo13/original/Pedido.java) → constructor con **9 parámetros**, incluyendo **3 listas paralelas** (`productos`, `cantidades`, `preciosUnitarios`)
- Refactor: [`ejemplo13/refact/Cliente.java`](src/main/java/ar/edu/ubp/das/ejemplo13/refact/Cliente.java), [`ejemplo13/refact/Producto.java`](src/main/java/ar/edu/ubp/das/ejemplo13/refact/Producto.java), [`ejemplo13/refact/Pedido.java`](src/main/java/ar/edu/ubp/das/ejemplo13/refact/Pedido.java) → constructor de 3 parámetros

**El problema:** la llamada no se entiende sola; 5 `String` seguidos se pueden invertir sin error; las listas paralelas se desalinean si se ordena o se agrega en una sola.

**Refactorización:** *Introduce Parameter Object* (`Cliente`) + *Replace Data Value with Object* (`Producto`).

> El `Cliente` refactorizado todavía tiene `direccionEntrega`, `ciudadEntrega`, `codigoPostalEntrega` sueltos: es un **Data Clump** pendiente. El paso siguiente sería extraer `Direccion` (como en el ejemplo 8).

**Guía:** 0–2 ideal, 3 aceptable, 4 o más → sospechar.

---

## 20. Long Method (método largo)

**Idea:** un método hace **una sola cosa**. Si es largo, hace varias mezcladas.

**Dónde mirar (sin ejemplo propio, pero sirve el ejemplo 13):**
- [`ejemplo13/refact/Pedido.java`](src/main/java/ar/edu/ubp/das/ejemplo13/refact/Pedido.java) → `mostrarDetallePedido()` muestra el cliente, la dirección y los productos, **calcula el total** (mezclado dentro del `for` que imprime) y muestra el pago.

**El problema:** cuesta entenderlo; el cálculo del total **no se puede reutilizar** ni probar porque está atrapado entre `println`.

**Refactorización:** *Extract Method*:

```java
public void mostrarDetallePedido() {
    mostrarCliente();
    mostrarProductos();
    System.out.println("Método de pago: " + metodoPago);
    System.out.println("Total a pagar: " + calcularTotal());
}
public double calcularTotal() { ... }   // reutilizable y testeable
```

También: *Replace Temp with Query*, *Decompose Conditional*, *Introduce Explaining Variable*.

**Regla de oro:** si un bloque necesita un comentario, ese bloque es un método y el comentario es su nombre.

**Cómo detectarlo:** comentarios que separan bloques, al describirlo usás "y", cálculos mezclados con impresión, mucha indentación, no entra en pantalla.

---

## 21. Primitive Obsession (obsesión primitiva)

**Idea:** usar `String`/`int`/`double` para conceptos con reglas propias. Esos conceptos merecen su clase.

**Dónde mirar:**
- Smell: [`ejemplo14/original/Persona.java`](src/main/java/ar/edu/ubp/das/ejemplo14/original/Persona.java) → `String telefono`, `String direccion`, y `validarTelefono()` suelto
- Smell: [`ejemplo14/original/Run.java`](src/main/java/ar/edu/ubp/das/ejemplo14/original/Run.java) → la validación queda en manos del que usa la clase
- Refactor: [`ejemplo14/refact/Telefono.java`](src/main/java/ar/edu/ubp/das/ejemplo14/refact/Telefono.java) (valida en el constructor), [`ejemplo14/refact/Direccion.java`](src/main/java/ar/edu/ubp/das/ejemplo14/refact/Direccion.java), [`ejemplo14/refact/Persona.java`](src/main/java/ar/edu/ubp/das/ejemplo14/refact/Persona.java)

**El problema:**
- Se pueden crear personas con teléfonos inválidos: validar es opcional.
- En `original/Run.java` la condición está **invertida** (`if (persona.validarTelefono()) throw ...`): tira error con un teléfono **válido**. Muestra bien el riesgo de dejar la validación afuera.
- La dirección como un solo `String` obliga a cortar texto para sacar la ciudad.

**Refactorización:** *Replace Primitive with Object*. Un `Telefono` inválido **no puede existir**.

**Otros casos típicos:** dinero como `double`, email como `String`, fechas como `String`, tipos como `int` (1=admin, 2=user).

**Diferencia con Data Clumps:** Data Clumps = varios primitivos que van juntos. Primitive Obsession = puede ser **uno solo** con reglas.

---

## 22. Alternative Classes with Different Interfaces

**Idea:** clases que sirven para lo mismo pero con métodos de distinto nombre no se pueden usar de forma intercambiable. ("Interfaz" acá = la forma de hablarle a la clase.)

**Dónde mirar:**
- Smell: [`ejemplo15/original/EnvioMaritimo.java`](src/main/java/ar/edu/ubp/das/ejemplo15/original/EnvioMaritimo.java) → `calcularTarifa(...)`
- Smell: [`ejemplo15/original/EnvioTerrestre.java`](src/main/java/ar/edu/ubp/das/ejemplo15/original/EnvioTerrestre.java) → `calcularCosto(...)`
- Refactor: [`ejemplo15/refact/ServicioEnvio.java`](src/main/java/ar/edu/ubp/das/ejemplo15/refact/ServicioEnvio.java) (interfaz con `calcularCostoEnvio`), [`EnvioMaritimo.java`](src/main/java/ar/edu/ubp/das/ejemplo15/refact/EnvioMaritimo.java), [`EnvioTerrestre.java`](src/main/java/ar/edu/ubp/das/ejemplo15/refact/EnvioTerrestre.java)

**El problema:** hay que recordar cómo se llama en cada una, y no se pueden recorrer juntas en una lista sin `instanceof` (vuelve el Switch Statements).

**Refactorización:** *Rename Method* + *Extract Interface* (el ejemplo lo llama "Introduce Interface").

> 📘 **Apunte de la cátedra:** *Rename Method*, *Move Method*, *Add Parameter*, *Parameterize Method*, *Extract Superclass* (sigue la edición de 1999 del libro de Fowler; hoy, si no comparten código, lo habitual es una interfaz).

**No es Duplicated Code:** la lógica es distinta (0.5/0.2 vs 0.8/0.5). Lo que se unifica es el **nombre**, no la cuenta.

> Detalle: el comentario de `refact/Run.java` dice "EnvioAereo" pero el código usa `EnvioTerrestre`. Es un error de tipeo.

---

## 23. Incomplete Library Class (biblioteca incompleta)

**Idea:** a una clase que no es tuya (Java o una librería) le falta algo y no la podés modificar. El smell es resolverlo con código suelto repetido.

**Sin ejemplo en el proyecto.** Mini ejemplo del problema:

```java
// LocalDate no tiene esDiaHabil() → esto termina copiado en Facturacion, Envios, Turnos...
if (fecha.getDayOfWeek() != DayOfWeek.SATURDAY
    && fecha.getDayOfWeek() != DayOfWeek.SUNDAY
    && !feriados.contains(fecha)) { ... }
```

> 📘 **Apunte de la cátedra:** *Introduce Foreign Method* (un método suelto en tu clase, si falta poco) e *Introduce Local Extension* (subclase o envoltorio, si falta mucho). Son los nombres de Fowler para las soluciones de abajo.

**Soluciones (según la clase):**

```java
// 1) Herencia: solo si la clase NO es final
public class ListaProductos extends ArrayList<Producto> {
    public double calcularTotal() { ... }
}

// 2) Decorador: envolver y agregar (sirve aunque la clase sea final, como LocalDate)
public class Fecha {
    private LocalDate fecha;
    public boolean esDiaHabil() { ... }
}

// 3) Adaptador: traducir una librería a la interfaz que tu código espera
public class EnvioCorreoExterno implements ServicioEnvio {
    private CorreoExternoAPI api = new CorreoExternoAPI();
    public double calcularCostoEnvio(double peso, double distancia) {
        return api.cotizar(peso, distancia);
    }
}
```

| Solución | Cuándo |
|---|---|
| Herencia | La clase no es `final`; agregar métodos ("es un") |
| Decorador | Clase `final` o no querés heredar; **agregar** comportamiento ("tiene un") |
| Adaptador | Hace lo que necesitás pero con otra forma; **traducir** |

**¿El adaptador no es un Middleman?** No, porque **agrega** algo: traduce entre dos formas incompatibles.

---

## Resumen: pares que se suelen confundir

| Este… | …vs. este | Diferencia clave |
|---|---|---|
| Divergent Change | Shotgun Surgery | Una clase/muchos motivos vs. un motivo/muchas clases |
| Large Class | Lazy Class | Hace demasiado vs. hace casi nada |
| Message Chains | Middleman | Poca delegación vs. demasiada delegación |
| Data Class | Feature Envy | Tiene datos sin lógica vs. tiene lógica sin datos (se arreglan juntos con Move Method) |
| Dead Code | Speculative Generality | Se usó y dejó de usarse vs. nunca se usó |
| Data Clumps | Primitive Obsession | Varios datos juntos vs. un dato con reglas propias |
| Duplicated Code | Alternative Classes | Misma lógica repetida vs. mismo propósito con distinto nombre |
| Inappropriate Intimacy | Feature Envy | Accede directo a atributos vs. usa demasiado a otra clase (aunque sea con getters) |

## Resumen: refactorización → smells que resuelve

| Refactorización | Smells |
|---|---|
| Extract Class | Divergent Change, Shotgun Surgery, Large Class, Data Clumps, Duplicated Code |
| Extract Method | Long Method, Comments, Duplicated Code |
| Move Method | Feature Envy, Data Class, Shotgun Surgery |
| Encapsulate Field | Data Class, Inappropriate Intimacy |
| Hide Delegate | Message Chains |
| Remove Middle Man | Middleman |
| Inline Class / Collapse Hierarchy | Lazy Class, Speculative Generality |
| Replace Conditional with Polymorphism | Switch Statements |
| Replace Inheritance with Delegation | Parallel Inheritance, Refused Bequest |
| Push Down Field/Method | Refused Bequest |
| Pull Up Method | Duplicated Code (en subclases) |
| Introduce Parameter Object | Long Parameter List, Data Clumps |
| Replace Primitive with Object | Primitive Obsession |
| Replace Temp with Query | Temporary Field, Long Method |
| Rename Method + Extract Interface | Alternative Classes with Different Interfaces |
| Herencia / Decorador / Adaptador | Incomplete Library Class |
| Eliminar | Dead Code, Speculative Generality |


---
---

# Parte 2 — Catálogo de refactorizaciones con ejemplos

Cada refactorización tiene: **qué es**, **cuándo usarla**, un ejemplo **antes / después**, **qué smell resuelve** y **dónde verla en el proyecto** (si aparece).

Están agrupadas por tipo, como en el catálogo de Fowler:

| Grupo | Refactorizaciones |
|---|---|
| [A. Componer métodos](#a-componer-métodos) | Extract Method · Inline Method · Extract Variable · Inline Temp · Replace Temp with Query · Decompose Conditional · Replace Magic Number with Constant |
| [B. Mover responsabilidades entre clases](#b-mover-responsabilidades-entre-clases) | Move Method · Move Field · Extract Class · Inline Class · Hide Delegate · Remove Middle Man |
| [C. Organizar datos](#c-organizar-datos) | Encapsulate Field · Encapsulate Collection · Replace Primitive with Object · Introduce Parameter Object · Preserve Whole Object · Introduce Null Object |
| [D. Herencia y polimorfismo](#d-herencia-y-polimorfismo) | Pull Up · Push Down · Extract Superclass · Extract Interface · Collapse Hierarchy · Replace Inheritance with Delegation · Replace Conditional with Polymorphism · Form Template Method |
| [E. Nombres y firmas](#e-nombres-y-firmas) | Rename Method/Field · Remove Parameter |
| [F. Refactorizar en la práctica](#f-refactorizar-en-la-práctica) | Pasos seguros · Atajos de IntelliJ |

---

## A. Componer métodos

Refactorizaciones para que los métodos sean cortos, claros y con buenos nombres.

### A.1 Extract Method (extraer método)

**Qué es:** sacar un bloque de código a un método nuevo cuyo nombre diga qué hace.
**Cuándo:** el método es largo, un bloque necesita un comentario o el mismo bloque está repetido.

```java
// ❌ Antes
public void imprimirFactura() {
    System.out.println("**** FACTURA ****");
    System.out.println("Cliente: " + cliente.getNombre());

    // calcular total
    double total = 0;
    for (Item item : items) {
        total += item.getPrecio() * item.getCantidad();
    }
    System.out.println("Total: " + total);
}
```

```java
// ✅ Después
public void imprimirFactura() {
    imprimirEncabezado();
    System.out.println("Total: " + calcularTotal());
}

private void imprimirEncabezado() {
    System.out.println("**** FACTURA ****");
    System.out.println("Cliente: " + cliente.getNombre());
}

public double calcularTotal() {
    double total = 0;
    for (Item item : items) {
        total += item.getPrecio() * item.getCantidad();
    }
    return total;
}
```

**Resuelve:** Long Method, Comments, Duplicated Code.
**En el proyecto:** se podría aplicar a `mostrarDetallePedido()` de [`ejemplo13/refact/Pedido.java`](src/main/java/ar/edu/ubp/das/ejemplo13/refact/Pedido.java).

---

### A.2 Inline Method (método en línea)

**Qué es:** lo opuesto a Extract Method. Se reemplaza la llamada por el cuerpo del método y se borra el método.
**Cuándo:** el método es tan simple que su nombre no dice más que su contenido, o solo agrega un salto innecesario.

```java
// ❌ Antes
public int obtenerCalificacion() {
    return tieneMasDeCincoEntregasTarde() ? 2 : 1;
}

private boolean tieneMasDeCincoEntregasTarde() {
    return entregasTarde > 5;
}
```

```java
// ✅ Después
public int obtenerCalificacion() {
    return entregasTarde > 5 ? 2 : 1;
}
```

**Resuelve:** indirección innecesaria. Es la versión "método" de Lazy Class o Middleman.
**Ojo:** no lo apliques si el método se sobreescribe en subclases, o si su nombre explica algo que la expresión no dice.

---

### A.3 Extract Variable / Introduce Explaining Variable (introducir variable explicativa)

**Qué es:** guardar una parte de una expresión complicada en una variable con un nombre que explique qué significa.
**Cuándo:** una condición o cuenta es larga y difícil de leer.

```java
// ❌ Antes
if (pedido.getCliente().getAntiguedad() > 3
        && pedido.getTotal() > 50000
        && !pedido.getDireccion().getProvincia().equals("Tierra del Fuego")) {
    pedido.setEnvioGratis(true);
}
```

```java
// ✅ Después
boolean esClienteFiel = pedido.getCliente().getAntiguedad() > 3;
boolean superaMontoMinimo = pedido.getTotal() > 50000;
boolean esZonaConEnvio = !pedido.getDireccion().getProvincia().equals("Tierra del Fuego");

if (esClienteFiel && superaMontoMinimo && esZonaConEnvio) {
    pedido.setEnvioGratis(true);
}
```

**Resuelve:** Comments, Long Method.
**Alternativa:** si esas condiciones se usan en otros lugares, mejor convertirlas en métodos (ver *Decompose Conditional*).

---

### A.4 Inline Temp (incorporar variable temporal)

**Qué es:** eliminar una variable temporal que solo guarda una expresión simple y se usa una vez.
**Cuándo:** la variable no explica nada y solo agrega una línea, o molesta para aplicar otra refactorización.

```java
// ❌ Antes
double precioBase = pedido.getPrecioBase();
return precioBase > 1000;
```

```java
// ✅ Después
return pedido.getPrecioBase() > 1000;
```

**Ojo:** es lo opuesto a *Extract Variable*. Usá una u otra según qué se lea mejor. Si el nombre de la variable explica algo que la expresión no dice, dejala.

---

### A.5 Replace Temp with Query (reemplazar temporal con consulta)

**Qué es:** reemplazar una variable (o atributo) que guarda un cálculo por un método que lo calcula cuando se pide.
**Cuándo:** el mismo cálculo hace falta en varios métodos, o el valor guardado puede quedar desactualizado.

```java
// ❌ Antes
public double obtenerPrecio() {
    double precioBase = cantidad * precioUnitario;
    double descuento = precioBase > 1000 ? 0.95 : 0.98;
    return precioBase * descuento;
}
```

```java
// ✅ Después
public double obtenerPrecio() {
    return precioBase() * factorDescuento();
}

private double precioBase() {
    return cantidad * precioUnitario;
}

private double factorDescuento() {
    return precioBase() > 1000 ? 0.95 : 0.98;
}
```

**Resuelve:** Temporary Field, Long Method.
**En el proyecto:** [`ejemplo01`](src/main/java/ar/edu/ubp/das/ejemplo01/refact/Pedido.java) (se eliminó el atributo `totalConDescuento`).

---

### A.6 Decompose Conditional (descomponer condicional)

**Qué es:** extraer la condición y cada rama de un `if` complejo a métodos con nombre.
**Cuándo:** la condición o las ramas son difíciles de entender a simple vista.

```java
// ❌ Antes
double cargo;
if (fecha.isBefore(INICIO_TEMPORADA_ALTA) || fecha.isAfter(FIN_TEMPORADA_ALTA)) {
    cargo = noches * tarifaBaja + cargoServicio;
} else {
    cargo = noches * tarifaAlta;
}
```

```java
// ✅ Después
double cargo = esTemporadaBaja(fecha) ? cargoTemporadaBaja(noches) : cargoTemporadaAlta(noches);

private boolean esTemporadaBaja(LocalDate fecha) {
    return fecha.isBefore(INICIO_TEMPORADA_ALTA) || fecha.isAfter(FIN_TEMPORADA_ALTA);
}
private double cargoTemporadaBaja(int noches) { return noches * tarifaBaja + cargoServicio; }
private double cargoTemporadaAlta(int noches) { return noches * tarifaAlta; }
```

**Resuelve:** Long Method, Comments.

---

### A.7 Replace Magic Number with Symbolic Constant (reemplazar número mágico por constante)

**Qué es:** reemplazar números "sueltos" por constantes con nombre.
**Cuándo:** aparece un número cuyo significado no es obvio (`0.21`, `0.05`, `86400`), sobre todo si se repite.

```java
// ❌ Antes
double total = subtotal * 1.21;
double bonificacion = salario * 0.05 * anios;
```

```java
// ✅ Después
private static final double IVA = 0.21;
private static final double PORCENTAJE_BONIFICACION_ANUAL = 0.05;

double total = subtotal * (1 + IVA);
double bonificacion = salario * PORCENTAJE_BONIFICACION_ANUAL * anios;
```

**Resuelve:** Comments, Duplicated Code (si el número se repite), Shotgun Surgery.
**En el proyecto:** se podría aplicar al `0.05` de [`ejemplo04/refact/BonificacionesService.java`](src/main/java/ar/edu/ubp/das/ejemplo04/refact/BonificacionesService.java).

---

## B. Mover responsabilidades entre clases

Refactorizaciones para que cada cosa esté en la clase donde corresponde.

### B.1 Move Method (mover método)

**Qué es:** llevar un método a la clase cuyos datos usa más.
**Cuándo:** un método usa más datos de otra clase que de la suya.

```java
// ❌ Antes — el método está en Pedido pero solo le importa Cliente
public class Pedido {
    public double calcularDescuento() {
        if (cliente.getAntiguedad() > 5 && cliente.getEmail().contains(".edu")) {
            return montoTotal * 0.15;
        }
        return 0;
    }
}
```

```java
// ✅ Después — el método vive en Cliente
public class Cliente {
    public double calcularDescuento(double monto) {
        if (antiguedad > 5 && email.contains(".edu")) {
            return monto * 0.15;
        }
        return 0;
    }
}

public class Pedido {
    public double aplicarDescuento() {
        return cliente.calcularDescuento(montoTotal);
    }
}
```

**Resuelve:** Feature Envy, Data Class, Shotgun Surgery.
**En el proyecto:** [`ejemplo06`](src/main/java/ar/edu/ubp/das/ejemplo06/refact/Cliente.java), [`ejemplo05`](src/main/java/ar/edu/ubp/das/ejemplo05/refact/CuentaBancaria.java).

---

### B.2 Move Field (mover atributo)

**Qué es:** llevar un atributo a la clase que más lo usa.
**Cuándo:** un atributo lo usa más otra clase que la suya, o pertenece conceptualmente a otra.

```java
// ❌ Antes — la tasa depende del tipo de cuenta, pero está en Cuenta
public class Cuenta {
    private TipoCuenta tipo;
    private double tasaInteres;

    public double calcularInteres(double monto, int dias) {
        return tasaInteres * monto * dias / 365;
    }
}
```

```java
// ✅ Después — la tasa se mueve al tipo de cuenta
public class TipoCuenta {
    private double tasaInteres;
    public double getTasaInteres() { return tasaInteres; }
}

public class Cuenta {
    private TipoCuenta tipo;

    public double calcularInteres(double monto, int dias) {
        return tipo.getTasaInteres() * monto * dias / 365;
    }
}
```

**Resuelve:** Feature Envy, Shotgun Surgery (si todas las cuentas del mismo tipo repetían la tasa).

---

### B.3 Extract Class (extraer clase)

**Qué es:** crear una clase nueva y mover a ella un grupo de atributos y métodos relacionados.
**Cuándo:** una clase hace demasiado, o hay datos que siempre van juntos.

```java
// ❌ Antes
public class Persona {
    private String nombre;
    private String codigoArea;
    private String numero;

    public String getTelefonoCompleto() {
        return "(" + codigoArea + ") " + numero;
    }
}
```

```java
// ✅ Después
public class Telefono {
    private String codigoArea;
    private String numero;

    public String formatear() {
        return "(" + codigoArea + ") " + numero;
    }
}

public class Persona {
    private String nombre;
    private Telefono telefono;

    public String getTelefonoCompleto() {
        return telefono.formatear();
    }
}
```

**Resuelve:** Large Class, Divergent Change, Data Clumps, Shotgun Surgery.
**En el proyecto:** [`ejemplo03`](src/main/java/ar/edu/ubp/das/ejemplo03/refact/), [`ejemplo04`](src/main/java/ar/edu/ubp/das/ejemplo04/refact/), [`ejemplo08`](src/main/java/ar/edu/ubp/das/ejemplo08/refact/Direccion.java).

---

### B.4 Inline Class (integrar clase)

**Qué es:** lo opuesto a Extract Class. Se mueve todo el contenido de una clase a otra y se borra la primera.
**Cuándo:** una clase hace tan poco que no justifica existir.

```java
// ❌ Antes
public class CalculadoraIVA {
    public double calcular(double monto) { return monto * 0.21; }
}

public class Factura {
    private CalculadoraIVA calc = new CalculadoraIVA();
    public double getTotal() { return monto + calc.calcular(monto); }
}
```

```java
// ✅ Después
public class Factura {
    private static final double IVA = 0.21;
    public double getTotal() { return monto * (1 + IVA); }
}
```

**Resuelve:** Lazy Class, Speculative Generality.

---

### B.5 Hide Delegate (ocultar delegado)

**Qué es:** agregar un método en una clase para que quien la usa no tenga que pasar por un tercer objeto.
**Cuándo:** hay cadenas como `a.getB().getC()`.

```java
// ❌ Antes — Pedido conoce a Direccion a través de Cliente
String ciudad = cliente.getDireccion().getCiudad();
```

```java
// ✅ Después
public class Cliente {
    public String getCiudad() {
        return direccion.getCiudad();
    }
}

String ciudad = cliente.getCiudad();
```

**Resuelve:** Message Chains, Inappropriate Intimacy.
**En el proyecto:** [`ejemplo02`](src/main/java/ar/edu/ubp/das/ejemplo02/refact/Cliente.java).
**Ojo:** si la aplicás de más, la clase termina siendo un Middleman.

---

### B.6 Remove Middle Man (eliminar intermediario)

**Qué es:** lo opuesto a Hide Delegate. Se elimina una clase (o métodos) que solo delegan, y el cliente habla directo con la clase real.
**Cuándo:** una clase solo hace `return otro.algo()` y no agrega nada.

```java
// ❌ Antes
public class ClienteEngine {
    private Cliente cliente;
    public String getNombreCliente() { return cliente.getNombre(); }
    public String getEmailCliente()  { return cliente.getEmail(); }
}

System.out.println(clienteEngine.getNombreCliente());
```

```java
// ✅ Después — se borra ClienteEngine
System.out.println(cliente.getNombre());
```

**Resuelve:** Middleman.
**En el proyecto:** [`ejemplo09`](src/main/java/ar/edu/ubp/das/ejemplo09/refact/Pedido.java).

---

## C. Organizar datos

Refactorizaciones para que los datos estén protegidos y bien representados.

### C.1 Encapsulate Field (encapsular campo)

**Qué es:** hacer `private` un atributo y dar acceso solo por métodos.
**Cuándo:** un atributo es público o de paquete y otras clases lo leen o modifican directamente.

```java
// ❌ Antes
public class Cliente {
    String nombre;          // acceso de paquete
}
pedido.getCliente().nombre = "";   // cualquiera lo modifica
```

```java
// ✅ Después
public class Cliente {
    private String nombre;
    public String getNombre() { return nombre; }
    // sin setter: el nombre no se puede cambiar desde afuera
}
```

**Resuelve:** Inappropriate Intimacy, Data Class (junto con Move Method).
**En el proyecto:** [`ejemplo10`](src/main/java/ar/edu/ubp/das/ejemplo10/refact/Cliente.java), [`ejemplo05`](src/main/java/ar/edu/ubp/das/ejemplo05/refact/CuentaBancaria.java).
**Tip:** encapsular no significa poner un getter y un setter a todo. Poné **solo** los que hagan falta, y preferí métodos con significado (`depositar`) antes que un `setSaldo`.

---

### C.2 Encapsulate Collection (encapsular colección)

**Qué es:** no devolver la lista interna directamente. La clase ofrece métodos para agregar y quitar, y devuelve una copia de solo lectura.
**Cuándo:** un getter devuelve una `List`, `Set` o `Map` y otros la modifican desde afuera.

```java
// ❌ Antes
public class Curso {
    private List<Alumno> alumnos = new ArrayList<>();
    private int cupo = 30;

    public List<Alumno> getAlumnos() { return alumnos; }
}

curso.getAlumnos().add(nuevo);    // se saltea el cupo
curso.getAlumnos().clear();       // ¡borra todos los inscriptos!
```

```java
// ✅ Después
public class Curso {
    private List<Alumno> alumnos = new ArrayList<>();
    private int cupo = 30;

    public void inscribir(Alumno alumno) {
        if (alumnos.size() >= cupo) {
            throw new IllegalStateException("Curso completo");
        }
        alumnos.add(alumno);
    }

    public void darDeBaja(Alumno alumno) {
        alumnos.remove(alumno);
    }

    public List<Alumno> getAlumnos() {
        return Collections.unmodifiableList(alumnos);   // solo lectura
    }
}
```

**Resuelve:** Inappropriate Intimacy, Data Class (la lógica de la colección queda adentro).

---

### C.3 Replace Primitive with Object / Replace Data Value with Object (reemplazar primitivo por objeto)

**Qué es:** reemplazar un `String`, `int` o `double` que representa un concepto con reglas por una clase propia.
**Cuándo:** un dato tiene formato, validación o comportamiento (teléfono, email, CUIT, dinero).

```java
// ❌ Antes
public class Cliente {
    private String email;

    public Cliente(String email) {
        this.email = email;            // cualquier texto entra
    }
}
```

```java
// ✅ Después
public class Email {
    private final String valor;

    public Email(String valor) {
        if (valor == null || !valor.matches("^[\\w.+-]+@[\\w-]+\\.[\\w.]+$")) {
            throw new IllegalArgumentException("Email inválido: " + valor);
        }
        this.valor = valor;
    }

    public String getDominio() {
        return valor.substring(valor.indexOf('@') + 1);
    }

    public String getValor() { return valor; }
}

public class Cliente {
    private Email email;
    public Cliente(Email email) { this.email = email; }
}
```

**Resuelve:** Primitive Obsession, Duplicated Code (validaciones repetidas).
**En el proyecto:** [`ejemplo14`](src/main/java/ar/edu/ubp/das/ejemplo14/refact/Telefono.java), y `Producto` en [`ejemplo13`](src/main/java/ar/edu/ubp/das/ejemplo13/refact/Producto.java).

---

### C.4 Introduce Parameter Object (introducir objeto parámetro)

**Qué es:** agrupar varios parámetros que siempre van juntos en un objeto.
**Cuándo:** varios métodos reciben el mismo grupo de parámetros.

```java
// ❌ Antes
public List<Venta> ventasEntre(LocalDate desde, LocalDate hasta) { ... }
public double totalEntre(LocalDate desde, LocalDate hasta) { ... }
public int cantidadEntre(LocalDate desde, LocalDate hasta) { ... }
```

```java
// ✅ Después
public class RangoFechas {
    private final LocalDate desde;
    private final LocalDate hasta;

    public RangoFechas(LocalDate desde, LocalDate hasta) {
        if (hasta.isBefore(desde)) {
            throw new IllegalArgumentException("'hasta' no puede ser anterior a 'desde'");
        }
        this.desde = desde;
        this.hasta = hasta;
    }

    public boolean incluye(LocalDate fecha) {
        return !fecha.isBefore(desde) && !fecha.isAfter(hasta);
    }
}

public List<Venta> ventasEntre(RangoFechas rango) { ... }
public double totalEntre(RangoFechas rango) { ... }
public int cantidadEntre(RangoFechas rango) { ... }
```

Fijate que el objeto nuevo **ganó comportamiento** (`incluye`) y una validación que antes había que repetir en cada método.

**Resuelve:** Long Parameter List, Data Clumps.
**En el proyecto:** [`ejemplo13`](src/main/java/ar/edu/ubp/das/ejemplo13/refact/Pedido.java), [`ejemplo08`](src/main/java/ar/edu/ubp/das/ejemplo08/refact/Cliente.java).

---

### C.5 Preserve Whole Object (preservar el objeto entero)

**Qué es:** en vez de sacar varios valores de un objeto y pasarlos por separado, pasar el objeto entero.
**Cuándo:** se llama a un método con `obj.getA(), obj.getB(), obj.getC()`.

```java
// ❌ Antes
double costo = calculadora.costoEnvio(
        direccion.getCiudad(),
        direccion.getCodigoPostal(),
        direccion.getProvincia());
```

```java
// ✅ Después
double costo = calculadora.costoEnvio(direccion);
```

**Resuelve:** Long Parameter List, Data Clumps.
**Ojo:** crea dependencia con la clase del objeto. Si el método solo necesita un dato, pasá solo ese dato.

---

### C.6 Introduce Null Object (introducir objeto nulo)

**Qué es:** en vez de usar `null` y preguntar `if (x != null)` en todos lados, crear un objeto que represente "no hay" con un comportamiento por defecto.
**Cuándo:** hay muchos chequeos de `null` repetidos para el mismo tipo de objeto.

```java
// ❌ Antes — se repite en todo el sistema
String nombre = (pedido.getCliente() != null) ? pedido.getCliente().getNombre() : "Invitado";
double desc   = (pedido.getCliente() != null) ? pedido.getCliente().getDescuento() : 0;
```

```java
// ✅ Después
public class ClienteInvitado extends Cliente {
    @Override public String getNombre()    { return "Invitado"; }
    @Override public double getDescuento() { return 0; }
}

// Pedido nunca tiene cliente null: si no hay, se usa new ClienteInvitado()
String nombre = pedido.getCliente().getNombre();
double desc   = pedido.getCliente().getDescuento();
```

**Resuelve:** Duplicated Code (chequeos de null repetidos), Switch Statements (los `if` son condicionales sobre "tipo").
**Ojo:** es una forma de polimorfismo: el objeto nulo "sabe" comportarse como un cliente sin datos.

---

## D. Herencia y polimorfismo

Refactorizaciones para que las jerarquías de clases tengan sentido.

### D.1 Pull Up Method / Pull Up Field (subir método/atributo)

**Qué es:** mover a la clase padre un método o atributo que está repetido en varias subclases.
**Cuándo:** subclases hermanas tienen el mismo código.

```java
// ❌ Antes
public class Gerente extends Empleado {
    private String legajo;
    public String getLegajo() { return legajo; }
}
public class Vendedor extends Empleado {
    private String legajo;
    public String getLegajo() { return legajo; }
}
```

```java
// ✅ Después
public class Empleado {
    protected String legajo;
    public String getLegajo() { return legajo; }
}
public class Gerente extends Empleado { }
public class Vendedor extends Empleado { }
```

**Resuelve:** Duplicated Code (en subclases).

---

### D.2 Push Down Method / Push Down Field (bajar método/atributo)

**Qué es:** lo opuesto a Pull Up. Mover un método o atributo del padre a la(s) subclase(s) que realmente lo usan.
**Cuándo:** algo del padre solo tiene sentido para algunos hijos.

```java
// ❌ Antes
public class Persona {
    private double salario;          // ¿un Alumno tiene salario?
    public double getSalario() { return salario; }
}
```

```java
// ✅ Después
public class Persona { /* solo lo común a todos */ }

public class Empleado extends Persona {
    private double salario;
    public double getSalario() { return salario; }
}
```

**Resuelve:** Refused Bequest.
**En el proyecto:** [`ejemplo12`](src/main/java/ar/edu/ubp/das/ejemplo12/refact/Empleado.java) (lo llama "Pull Down Field").

---

### D.3 Extract Superclass (extraer superclase)

**Qué es:** crear una clase padre para dos clases que tienen datos y comportamiento en común.
**Cuándo:** dos clases sin relación repiten atributos y métodos.

```java
// ❌ Antes
public class Cliente {
    private String nombre;
    private String telefono;
    public String getContacto() { return nombre + " - " + telefono; }
    public double getLimiteCredito() { ... }
}

public class Proveedor {
    private String nombre;
    private String telefono;
    public String getContacto() { return nombre + " - " + telefono; }
    public int getDiasDePago() { ... }
}
```

```java
// ✅ Después
public abstract class Contacto {
    protected String nombre;
    protected String telefono;
    public String getContacto() { return nombre + " - " + telefono; }
}

public class Cliente extends Contacto {
    public double getLimiteCredito() { ... }
}

public class Proveedor extends Contacto {
    public int getDiasDePago() { ... }
}
```

**Resuelve:** Duplicated Code.
**Extract Superclass vs. Extract Interface:** si las clases comparten **código** (atributos y métodos ya implementados), superclase. Si solo comparten la **forma** de usarse (nombres de métodos) pero cada una lo hace distinto, interfaz.

---

### D.4 Extract Interface (extraer interfaz)

**Qué es:** crear una interfaz con los métodos comunes a varias clases para poder usarlas de forma intercambiable.
**Cuándo:** varias clases cumplen el mismo rol pero no comparten un tipo.

```java
// ❌ Antes
public class NotificadorMail { public void enviarMail(String msj) { ... } }
public class NotificadorSMS  { public void mandarSMS(String msj)  { ... } }
```

```java
// ✅ Después
public interface Notificador {
    void notificar(String mensaje);
}

public class NotificadorMail implements Notificador {
    public void notificar(String mensaje) { /* envía mail */ }
}

public class NotificadorSMS implements Notificador {
    public void notificar(String mensaje) { /* envía SMS */ }
}

// Ahora se pueden tratar igual
for (Notificador n : notificadores) {
    n.notificar("Su pedido fue despachado");
}
```

**Resuelve:** Alternative Classes with Different Interfaces, Switch Statements.
**En el proyecto:** [`ejemplo15`](src/main/java/ar/edu/ubp/das/ejemplo15/refact/ServicioEnvio.java), [`ejemplo07`](src/main/java/ar/edu/ubp/das/ejemplo07/refact/Operacion.java).

---

### D.5 Collapse Hierarchy (colapsar jerarquía)

**Qué es:** fusionar una subclase con su padre cuando ya no son lo bastante distintas.
**Cuándo:** una subclase no agrega nada, o una clase abstracta tiene un solo hijo.

```java
// ❌ Antes
public abstract class ExportadorBase {
    public abstract void exportar(Reporte r);
}
public class ExportadorPDF extends ExportadorBase {
    public void exportar(Reporte r) { ... }
}
```

```java
// ✅ Después
public class ExportadorPDF {
    public void exportar(Reporte r) { ... }
}
```

**Resuelve:** Lazy Class, Speculative Generality.

---

### D.6 Replace Inheritance with Delegation (reemplazar herencia por delegación)

**Qué es:** en vez de heredar de una clase, tener un atributo de esa clase y delegarle el trabajo ("tiene un" en vez de "es un").
**Cuándo:** la subclase usa solo una parte del padre, o hereda cosas que no tienen sentido para ella.

```java
// ❌ Antes — una Pila "es una" ArrayList
public class Pila<T> extends ArrayList<T> {
    public void apilar(T elem) { add(elem); }
    public T desapilar()       { return remove(size() - 1); }
}

Pila<String> pila = new Pila<>();
pila.add(0, "x");     // compila: rompe la regla de la pila (insertar abajo)
pila.remove(3);       // compila: saca un elemento del medio
```

```java
// ✅ Después — una Pila "tiene una" lista
public class Pila<T> {
    private final List<T> elementos = new ArrayList<>();

    public void apilar(T elem) { elementos.add(elem); }
    public T desapilar()       { return elementos.remove(elementos.size() - 1); }
    public boolean estaVacia() { return elementos.isEmpty(); }
}
// Ahora solo existen las operaciones que tienen sentido para una pila.
```

**Resuelve:** Refused Bequest, Parallel Inheritance Hierarchies.
**En el proyecto:** [`ejemplo11`](src/main/java/ar/edu/ubp/das/ejemplo11/refact/Empleado.java) (el empleado tiene una `EstrategiaPago`).

---

### D.7 Replace Conditional with Polymorphism (reemplazar condicional por polimorfismo)

**Qué es:** cada rama de un `switch`/`if` según el tipo pasa a ser una clase que implementa el mismo método.
**Cuándo:** hay un `switch` sobre un tipo, sobre todo si se repite en varios lugares.

```java
// ❌ Antes
public double calcularEnvio(String tipo, double peso) {
    switch (tipo) {
        case "ESTANDAR": return peso * 100;
        case "EXPRESS":  return peso * 100 + 2000;
        case "RETIRO":   return 0;
        default: throw new IllegalArgumentException(tipo);
    }
}
```

```java
// ✅ Después
public interface TipoEnvio {
    double calcular(double peso);
}

public class EnvioEstandar implements TipoEnvio {
    public double calcular(double peso) { return peso * 100; }
}
public class EnvioExpress implements TipoEnvio {
    public double calcular(double peso) { return peso * 100 + 2000; }
}
public class RetiroEnLocal implements TipoEnvio {
    public double calcular(double peso) { return 0; }
}

// Uso
double costo = pedido.getTipoEnvio().calcular(peso);
```

**Resuelve:** Switch Statements.
**En el proyecto:** [`ejemplo07`](src/main/java/ar/edu/ubp/das/ejemplo07/refact/).

---

### D.8 Form Template Method (formar método plantilla)

**Qué es:** cuando dos subclases tienen métodos con los **mismos pasos en el mismo orden** pero cada paso hecho distinto, se sube al padre el "esqueleto" y cada hijo implementa solo los pasos.
**Cuándo:** hay duplicación de **estructura**, aunque no de código exacto.

```java
// ❌ Antes — mismos pasos, distinto formato
public class ReporteTexto {
    public String generar() {
        return "VENTAS\n" + cuerpoTexto() + "\nFin del reporte";
    }
}
public class ReporteHTML {
    public String generar() {
        return "<h1>VENTAS</h1>" + cuerpoHTML() + "<footer>Fin del reporte</footer>";
    }
}
```

```java
// ✅ Después
public abstract class Reporte {
    public final String generar() {          // el esqueleto, igual para todos
        return encabezado() + cuerpo() + pie();
    }
    protected abstract String encabezado();
    protected abstract String cuerpo();
    protected abstract String pie();
}

public class ReporteTexto extends Reporte {
    protected String encabezado() { return "VENTAS\n"; }
    protected String cuerpo()     { return ...; }
    protected String pie()        { return "\nFin del reporte"; }
}

public class ReporteHTML extends Reporte {
    protected String encabezado() { return "<h1>VENTAS</h1>"; }
    protected String cuerpo()     { return ...; }
    protected String pie()        { return "<footer>Fin del reporte</footer>"; }
}
```

**Resuelve:** Duplicated Code (duplicación sutil, de estructura).
**Bonus:** un reporte nuevo (CSV, PDF) solo implementa los 3 pasos, y el orden queda garantizado por el padre.

---

## E. Nombres y firmas

### E.1 Rename Method / Rename Field (renombrar)

**Qué es:** cambiar el nombre de un método, atributo o variable para que diga lo que hace o lo que es.
**Cuándo:** el nombre es ambiguo, abreviado o engañoso.

```java
// ❌ Antes
public double calc(double a) { return a * 1.21; }
private int d;   // días desde el alta
```

```java
// ✅ Después
public double calcularPrecioConIVA(double precioNeto) { return precioNeto * 1.21; }
private int diasDesdeAlta;
```

**Resuelve:** Comments, Alternative Classes with Different Interfaces (unificar nombres).
**En IntelliJ:** `⇧F6` renombra en **todo** el proyecto a la vez, sin buscar a mano.

---

### E.2 Remove Parameter (quitar parámetro)

**Qué es:** eliminar un parámetro que el método ya no usa.
**Cuándo:** un parámetro se ignora o siempre llega con el mismo valor.

```java
// ❌ Antes
public double calcularEnvio(double peso, double distancia, boolean urgente) {
    return peso * 10 + distancia * 2;      // 'urgente' no se usa
}
```

```java
// ✅ Después
public double calcularEnvio(double peso, double distancia) {
    return peso * 10 + distancia * 2;
}
```

**Resuelve:** Speculative Generality, Dead Code, Long Parameter List.
**Lo opuesto:** *Add Parameter*, cuando un método realmente necesita un dato nuevo.

---

## F. Refactorizar en la práctica

### F.1 Pasos para refactorizar sin romper nada

1. **Tener tests que pasen antes de empezar.** Refactorizar = cambiar la estructura **sin cambiar el comportamiento**. Los tests son lo que demuestra que el comportamiento no cambió.
2. **Un cambio chico a la vez.** Una refactorización, compilar, correr los tests. Si algo falla, sabés exactamente qué lo rompió.
3. **No mezclar refactorizar con agregar funcionalidad.** Primero se refactoriza (los tests siguen pasando), después se agrega lo nuevo. Son dos "sombreros" distintos, como dice Fowler.
4. **Usar las herramientas del IDE.** Las refactorizaciones automáticas actualizan todos los usos sin errores de tipeo.
5. **Commitear seguido.** Si una refactorización sale mal, volvés al último commit.

### F.2 Atajos de IntelliJ IDEA (macOS, keymap por defecto)

| Refactorización | Atajo | Menú |
|---|---|---|
| **Menú de refactorizaciones** (todas) | `⌃T` | Refactor → Refactor This… |
| Rename | `⇧F6` | Refactor → Rename |
| Extract Method | `⌥⌘M` | Refactor → Extract/Introduce → Method |
| Extract Variable | `⌥⌘V` | Refactor → Extract/Introduce → Variable |
| Extract Constant | `⌥⌘C` | Refactor → Extract/Introduce → Constant |
| Extract Field | `⌥⌘F` | Refactor → Extract/Introduce → Field |
| Extract Parameter | `⌥⌘P` | Refactor → Extract/Introduce → Parameter |
| Inline (método, variable, clase) | `⌥⌘N` | Refactor → Inline |
| Move (método, clase) | `F6` | Refactor → Move |
| Change Signature (agregar/quitar/reordenar parámetros) | `⌘F6` | Refactor → Change Signature |
| Extract Interface / Superclass | — | Refactor → Extract/Introduce → Interface / Superclass |
| Pull Members Up / Push Members Down | — | Refactor → Pull Members Up / Push Members Down |
| Encapsulate Fields | — | Refactor → Encapsulate Fields |
| Find Usages (para detectar Dead Code) | `⌥F7` | Edit → Find Usages |

> En Windows/Linux los atajos cambian (`⌘` → `Ctrl`, `⌥` → `Alt`). Si alguno no coincide, `⌃T` (o `Ctrl+Alt+Shift+T` en Windows) muestra siempre la lista completa.


---
---

# Parte 3 — Lo que agrega el apunte de la cátedra

Fuente: *Apunte de Refactorización v1.5* (Lic. Mariela Pastarini, Diseño Avanzado de Software). Esta parte suma lo que está en el apunte y no estaba en las partes 1 y 2.

## 3.1 Tabla oficial: bad smell → refactorizaciones

Es la tabla del apunte (páginas 13–14 y 44), basada en el libro de Fowler. La columna de la derecha muestra lo que aplica el **código de ejemplo** del proyecto cuando es distinto.

> **Las dos columnas son válidas.** Un mismo smell se puede resolver de varias formas. En un examen conviene nombrar las del apunte y, si suma, la que se ve en el ejemplo.

| Bad smell | Refactorizaciones según el apunte | En el código de ejemplo |
|---|---|---|
| Atributo temporal | Extract Class · Introduce Null Object | Replace Temp with Query (ej. 1) |
| Cadena de mensajes | Hide Delegate | ✔ igual (ej. 2) |
| Cambio divergente | Extract Class | ✔ igual (ej. 3) |
| Cambio en cadena | Move Method · Move Field · Inline Class | Extract Class (ej. 4) |
| Clase de datos | Move Method · Encapsulate Field · Encapsulate Collection | Move Method + Encapsulate Field (ej. 5) |
| Código muerto | Inline Class · Collapse Hierarchy · Remove Parameter | — (se elimina) |
| Clase grande | Extract Class · Extract Subclass · Extract Interface · Replace Data Value with Object | — |
| Clase perezosa | Inline Class · Collapse Hierarchy | — |
| Comentarios | Extract Method · Introduce Assertion | — |
| Código duplicado | Extract Method · Extract Class · Pull Up Method · Form Template Method | — |
| Envidia de características | Move Method · Move Field · Extract Method | Move Method (ej. 6) |
| Switch statements | Replace Conditional with Polymorphism · Replace Type Code with Subclasses · Replace Type Code with State/Strategy · Replace Parameter with Explicit Methods · Introduce Null Object | Replace Conditional with Polymorphism (ej. 7) |
| Generalidad especulativa | Collapse Hierarchy · Inline Class · Remove Parameter · Rename Method | — |
| Grupo de datos | Extract Class · Introduce Parameter Object · Preserve Whole Object | Extract Class (ej. 8) |
| Intermediario | Remove Middle Man · Inline Method · Replace Delegation with Inheritance | Remove Middle Man (ej. 9) |
| Intimidad inadecuada | Move Method · Move Field · Change Bidirectional Association to Unidirectional · Replace Inheritance with Delegation · Hide Delegate | **Encapsulate Field** (ej. 10) |
| Jerarquías paralelas | Move Method · Move Field | **Replace Inheritance with Delegation** (ej. 11) |
| Legado rechazado | Replace Inheritance with Delegation | **Push Down Field** (ej. 12) |
| Lista de parámetros larga | Replace Parameter with Method · Introduce Parameter Object · Preserve Whole Object | Introduce Parameter Object + Replace Data Value with Object (ej. 13) |
| Método largo | Extract Method · Replace Temp with Query · Replace Method with Method Object · Decompose Conditional | — |
| Obsesión primitiva | Replace Data Value with Object · Extract Class · Introduce Parameter Object · Replace Array with Object · Replace Type Code with Class · Replace Type Code with Subclasses · Replace Type Code with State/Strategy | Replace Primitive with Object (ej. 14) |
| Clases alternativas con distintas interfaces | Rename Method · Move Method · Add Parameter · Parameterize Method · Extract Superclass | **Extract Interface** (ej. 15) |
| Biblioteca incompleta | Introduce Foreign Method · Introduce Local Extension | Herencia / Decorador / Adaptador (diapositivas) |

### ¿Por qué difieren? (para poder justificarlo)

- **Atributo temporal → Extract Class:** el atributo temporal y los métodos que lo usan se mueven a una clase propia, donde sí tienen sentido siempre. El ejemplo 1 elige algo más simple: eliminar el atributo y calcularlo cuando hace falta.
- **Jerarquías paralelas → Move Method / Move Field:** la idea de Fowler es que una jerarquía **referencie** a la otra (el empleado *tiene* su estrategia de pago) y después mover métodos y atributos hasta que una de las dos jerarquías desaparezca. El ejemplo 11 hace justamente el primer paso con delegación.
- **Legado rechazado → Replace Inheritance with Delegation:** el apunte apunta al caso fuerte, donde la subclase en realidad **no es** un tipo del padre. El ejemplo 12 es el caso leve: el alumno sí es una persona, solo sobraba un atributo, y alcanza con *Push Down*.
- **Intimidad inadecuada → Move Method / Move Field:** si dos clases se meten mucho una en la otra, se mueve el código hasta que cada una se ocupe de lo suyo. El ejemplo 10 es el caso más simple (atributos sin `private`) y se resuelve encapsulando.
- **Clases alternativas → Extract Superclass:** el apunte sigue la primera edición del libro de Fowler (1999). Hoy, si las clases no comparten código, lo habitual es *Extract Interface*, como en el ejemplo 15.
- **Biblioteca incompleta → Introduce Foreign Method / Local Extension:** son los nombres de Fowler para las soluciones de las diapositivas (ver 3.3).

---

## 3.2 Teoría del apunte que no estaba en la guía

**Origen y definición**
- El término *refactoring* lo introdujo **Opdyke en 1992**.
- Refactorizar **no es optimizar** (optimizar a veces hace el código menos claro), **ni corregir errores**, **ni mejorar algoritmos**.
- Es una forma de **mantenimiento preventivo**: baja la complejidad antes de que los cambios futuros la hagan crecer.

**Regla de los tres strikes (Fowler)**
> La primera vez que hacés algo, lo hacés. La segunda vez que hacés algo parecido, duplicás (con culpa). **A la tercera, refactorizás.**

**Momentos para refactorizar**
1. Al agregar funcionalidad (ayuda a entender el código sobre el que trabajás).
2. Al resolver una falla (si hubo un bug, el código no era lo bastante claro).
3. En revisiones de código (se relaciona con el *pair programming* de XP: revisión y refactorización continuas).

**Momentos para NO refactorizar**
1. Cuando el código **directamente no funciona** y estabilizarlo cuesta demasiado. Ahí conviene reescribir, o dividirlo en componentes y decidir componente por componente si se refactoriza o se reconstruye.
2. Cuando está **próxima una entrega**: la ganancia de refactorizar se vería recién después de la fecha.

**Refactorización continua**
- Refactorizar siempre que se pueda, después de cada funcionalidad nueva. Cuanto más se espera, más grande (y riesgosa) es la refactorización necesaria.
- Claves: que **todo el equipo** esté al tanto, que sepa **identificar** qué refactorizar y que comparta una **visión común de la arquitectura**.
- Riesgo: volverse demasiado exigente o aplicar criterios personales, y terminar refactorizando más de lo que se desarrolla.

**Pruebas automáticas**
- Sin pruebas automáticas, refactorizar es **de alto riesgo**: nunca sabés si rompiste algo.
- Orden: **probar → refactorizar → volver a probar**.

**Las 5 partes de una refactorización (formato de Fowler)**
1. **Nombre** (crea vocabulario común, como los patrones de diseño).
2. **Resumen** de qué hace y cuándo se necesita.
3. **Motivación**: por qué aplicarla y cuándo no.
4. **Mecanismo**: los pasos para hacerla.
5. **Ejemplo**.

**Preguntas para encontrar refactorizaciones**

| Nivel | Preguntas |
|---|---|
| Método | ¿El nombre es correcto? ¿Los parámetros tienen sentido? ¿Hay demasiadas variables temporales? ¿Hay código duplicado? ¿Convendría separar ese código? |
| Clase | ¿Este método debería estar en esta clase? ¿Hay muchos métodos parecidos? |
| Comunicación entre clases | ¿La clase A usa métodos de la clase B? Si es así, ¿por qué? |

**Proceso de refactorización (Wampler)**
1. Revisar código y diseño para identificar refactorizaciones.
2. Aplicar una refactorización por vez, sin cambiar la funcionalidad.
3. Correr las pruebas después de **cada** refactorización, sin excepción.
4. Repetir.

Heurísticas: no agregar funcionalidad mientras se refactoriza, usar las pruebas de forma estricta, y recordar que el valor está en **muchas refactorizaciones chicas** acumuladas.

**El mecanismo siempre termina igual.** En todas las refactorizaciones del apunte, el último paso (y muchos intermedios) es **"compilar y probar"**. Si te piden el mecanismo de una refactorización, la estructura típica es: crear lo nuevo → compilar → redirigir los usos → compilar y probar → borrar lo viejo → compilar y probar.

---

## 3.3 Refactorizaciones del apunte que faltaban en la Parte 2

### Split Temporary Variable (dividir variable temporal)
**Cuándo:** una misma variable se usa para guardar **dos cosas distintas**.

```java
// ❌ Antes
double temp = item.getPrecio() * item.getCantidad();
System.out.println("Total por línea: " + temp);
temp = pedido.getTotal() - pedido.getDescuento();
System.out.println("Monto adeudado: " + temp);

// ✅ Después
final double totalLinea = item.getPrecio() * item.getCantidad();
System.out.println("Total por línea: " + totalLinea);
final double montoAdeudado = pedido.getTotal() - pedido.getDescuento();
System.out.println("Monto adeudado: " + montoAdeudado);
```
**Mecanismo:** renombrar la variable en su primera asignación, declararla `final`, cambiar sus usos hasta la segunda asignación, declarar una variable nueva ahí, compilar y probar, repetir.

---

### Remove Assignments to Parameters (eliminar asignaciones a parámetros)
**Cuándo:** dentro del método se le asigna un valor nuevo a un parámetro. Confunde, porque el parámetro deja de representar lo que se recibió.

```java
// ❌ Antes
public void verificarStock(Item item, int deseado) {
    if (item.getStock() < deseado) {
        deseado = item.getStock();                 // reasigna el parámetro
        item = new Item(item.getIdAlternativo());  // reasigna el parámetro
        System.out.println("Sugiero " + item.getNombre());
    }
}

// ✅ Después
public void verificarStock(Item item, int deseado) {
    if (item.getStock() < deseado) {
        int disponible = item.getStock();
        Item alternativo = new Item(item.getIdAlternativo());
        System.out.println("Sugiero " + alternativo.getNombre());
    }
}
```
**Tip:** declarar los parámetros como `final` impide que esto pase.

---

### Replace Method with Method Object (reemplazar método por objeto método)
**Cuándo:** un método es largo y sus variables locales están tan entrelazadas que **no se puede aplicar Extract Method** (habría que pasar todo como parámetro).
**Idea:** el método se convierte en una **clase**; sus variables locales pasan a ser **atributos**, y entonces sí se puede partir en métodos chicos.

```java
// ❌ Antes
class Pedido {
    public double precio() {
        double precioBasePrimario;
        double precioBaseSecundario;
        double precioBaseTerciario;
        // ... 60 líneas de cálculo que usan las tres variables
    }
}

// ✅ Después
class CalculadorPrecio {
    private final Pedido pedido;
    private double precioBasePrimario;
    private double precioBaseSecundario;
    private double precioBaseTerciario;

    CalculadorPrecio(Pedido pedido) { this.pedido = pedido; }

    double calcular() {
        calcularBases();             // ahora se puede extraer en métodos
        aplicarAjustes();            // porque las variables son atributos
        return precioBasePrimario + precioBaseSecundario + precioBaseTerciario;
    }
}

class Pedido {
    public double precio() {
        return new CalculadorPrecio(this).calcular();
    }
}
```
**Resuelve:** Long Method (cuando Extract Method no alcanza).

---

### Substitute Algorithm (sustituir algoritmo)
**Cuándo:** existe una forma **más clara** de hacer lo mismo.

```java
// ❌ Antes
public String encontrarPersona(String[] personas) {
    for (String p : personas) {
        if (p.equals("Don"))  return "Don";
        if (p.equals("John")) return "John";
        if (p.equals("Kent")) return "Kent";
    }
    return "";
}

// ✅ Después
public String encontrarPersona(String[] personas) {
    List<String> candidatos = List.of("Don", "John", "Kent");
    for (String p : personas) {
        if (candidatos.contains(p)) return p;
    }
    return "";
}
```
**Mecanismo:** preparar el algoritmo nuevo, probarlo, y si los resultados difieren, usar el viejo como referencia para comparar.

---

### Consolidate Conditional Expression (consolidar expresión condicional)
**Cuándo:** varias condiciones distintas llevan **al mismo resultado**.

```java
// ❌ Antes
public double calcularEnvio() {
    if (esEmpleado) return 0;
    if (esClientePlatino) return 0;
    if (esClienteOro) return 0;
    if (tieneCupon) return 0;
    // cálculo del envío...
}

// ✅ Después
public double calcularEnvio() {
    if (tieneEnvioGratis()) return 0;
    // cálculo del envío...
}

private boolean tieneEnvioGratis() {
    return esEmpleado || esClientePlatino || esClienteOro || tieneCupon;
}
```
**Ojo:** solo si ninguna condición tiene efectos secundarios.

---

### Consolidate Duplicate Conditional Fragments (consolidar fragmentos duplicados en condicionales)
**Cuándo:** el **mismo código** aparece en **todas** las ramas de un `if`.

```java
// ❌ Antes
if (esPedidoGrande(pedido)) {
    envio = tarifaConDescuento(pedido);
    pedido.agregarCostoEnvio(envio);
} else {
    envio = tarifaNormal(pedido);
    pedido.agregarCostoEnvio(envio);
}

// ✅ Después
if (esPedidoGrande(pedido)) {
    envio = tarifaConDescuento(pedido);
} else {
    envio = tarifaNormal(pedido);
}
pedido.agregarCostoEnvio(envio);     // sale del if
```
**Regla:** si lo repetido está al principio, va antes del `if`; si está al final, va después.

---

### Replace Type Code with Subclasses (reemplazar código de tipo con subclases)
**Cuándo:** un atributo "tipo" (un `int` o `String`) **cambia el comportamiento** de la clase.

```java
// ❌ Antes
class Empleado {
    static final int INGENIERO = 0;
    static final int VENDEDOR = 1;
    private int tipo;

    double calcularBono() {
        if (tipo == INGENIERO) return 1000;
        if (tipo == VENDEDOR)  return ventas * 0.1;
        return 0;
    }
}

// ✅ Después
abstract class Empleado {
    abstract double calcularBono();
}
class Ingeniero extends Empleado {
    double calcularBono() { return 1000; }
}
class Vendedor extends Empleado {
    double calcularBono() { return ventas * 0.1; }
}
```
**Variantes del apunte:**
- **Replace Type Code with Class:** el tipo **no** cambia el comportamiento, solo es un dato → se reemplaza el `int` por una clase o un `enum` (más seguro que un número suelto).
- **Replace Type Code with State/Strategy:** el tipo cambia el comportamiento **y puede cambiar durante la vida del objeto** (un empleado que pasa de vendedor a ingeniero) → en vez de subclases, el objeto **tiene** un objeto estado/estrategia que se puede reemplazar. Es lo que hace el ejemplo 11 con `EstrategiaPago`.

**Resuelve:** Switch Statements, Primitive Obsession.

---

### Self Encapsulate Field (autoencapsular campo)
**Qué es:** usar los getters **incluso dentro de la propia clase**, en vez de acceder directo al atributo.
**Cuándo:** se quiere que una subclase pueda cambiar cómo se obtiene el valor (sobreescribiendo el getter), o el acceso directo dificulta otros cambios.

```java
// ❌ Antes
class RangoEntero {
    private int desde, hasta;
    boolean incluye(int valor) {
        return valor >= desde && valor <= hasta;
    }
}

// ✅ Después
class RangoEntero {
    private int desde, hasta;
    int getDesde() { return desde; }
    int getHasta() { return hasta; }
    boolean incluye(int valor) {
        return valor >= getDesde() && valor <= getHasta();
    }
}
```
**Diferencia con Encapsulate Field:** Encapsulate Field protege el atributo **de otras clases**. Self Encapsulate Field cambia cómo lo usa **la propia clase**.

---

### Add Parameter (agregar parámetro)
**Cuándo:** un método necesita un dato que hoy no recibe.

```java
// ❌ Antes                          // ✅ Después
cliente.getContacto();              cliente.getContacto(LocalDate fecha);
```
**Ojo:** antes de agregar un parámetro, preguntate si no conviene *Introduce Parameter Object* o *Preserve Whole Object*, para no alargar la lista.
**Lo opuesto:** Remove Parameter.

---

### Parameterize Method (parametrizar método)
**Cuándo:** varios métodos hacen **lo mismo con un valor distinto**.

```java
// ❌ Antes
void aumentoCincoPorCiento() { salario *= 1.05; }
void aumentoDiezPorCiento()  { salario *= 1.10; }

// ✅ Después
void aumentar(double porcentaje) { salario *= (1 + porcentaje / 100); }
```
> ⚠️ **Errata del apunte:** en la página 38 el "Resumen" de Parameterize Method dice *"Se elimina parámetro sin uso"*. Es un error de copiar y pegar de Remove Parameter. Lo correcto es: *varios métodos parecidos se reemplazan por uno solo que recibe el valor que cambia como parámetro*.

---

### Replace Parameter with Explicit Methods (reemplazar parámetro por métodos explícitos)
**Qué es:** lo **opuesto** a Parameterize Method.
**Cuándo:** un método hace cosas **completamente distintas** según el valor de un parámetro.

```java
// ❌ Antes
void setValor(String nombre, int valor) {
    if (nombre.equals("alto"))  alto = valor;
    else if (nombre.equals("ancho")) ancho = valor;
}

// ✅ Después
void setAlto(int valor)  { alto = valor; }
void setAncho(int valor) { ancho = valor; }
```
**Resuelve:** Switch Statements (el `if` sobre el parámetro), y evita errores de tipeo como `setValor("atlo", 5)`.

**¿Cuál de las dos usar?**
- Si el parámetro cambia **un valor** dentro de la misma lógica → **Parameterize Method**.
- Si el parámetro elige **qué lógica** ejecutar → **Replace Parameter with Explicit Methods**.

---

### Replace Parameter with Method (reemplazar parámetro por método)
**Cuándo:** quien llama calcula algo y lo pasa como parámetro, pero el método que lo recibe **podría calcularlo él mismo**.

```java
// ❌ Antes
double descuento = pedido.calcularDescuento();
double total = pedido.precioFinal(descuento);

// ✅ Después
double total = pedido.precioFinal();     // adentro llama a calcularDescuento()
```
**Resuelve:** Long Parameter List.

---

### Introduce Foreign Method (introducir método foráneo)
**Cuándo:** a una clase de una biblioteca le falta **un** método y no podés agregarlo.
**Idea:** se crea el método en **tu** clase, recibiendo el objeto de la biblioteca como parámetro.

```java
// En tu clase
private static boolean esDiaHabil(LocalDate fecha) {
    return fecha.getDayOfWeek() != DayOfWeek.SATURDAY
        && fecha.getDayOfWeek() != DayOfWeek.SUNDAY;
}
```
**Resuelve:** Incomplete Library Class (cuando falta **poco**).

---

### Introduce Local Extension (introducir extensión local)
**Cuándo:** a la clase de la biblioteca le faltan **varios** métodos.
**Idea:** crear **tu propia clase** que la extienda, ya sea con **herencia** (subclase) o con un **envoltorio** (wrapper). Es lo que en las diapositivas aparece como *Herencia* y *Decorador*.

```java
// Con herencia (si la clase no es final)
class ListaProductos extends ArrayList<Producto> {
    double calcularTotal() { ... }
}

// Con envoltorio (si la clase es final, como LocalDate)
class Fecha {
    private final LocalDate fecha;
    boolean esDiaHabil() { ... }
    boolean esFeriado()  { ... }
}
```
| Diapositivas | Apunte (Fowler) |
|---|---|
| Un método suelto en tu clase | **Introduce Foreign Method** |
| Herencia | **Introduce Local Extension** (subclase) |
| Decorador | **Introduce Local Extension** (envoltorio) |
| Adaptador | (no está en la tabla del apunte; es un patrón de diseño) |

---

### Introduce Assertion (introducir aserción)
**Cuándo:** una parte del código **supone** algo que no está escrito (por ejemplo, que un valor nunca es negativo).
**Idea:** hacer explícita esa suposición con una aserción, en vez de dejarla en un comentario.

```java
// ❌ Antes
// el gasto nunca puede ser negativo acá
double limite = gasto * factor;

// ✅ Después
assert gasto >= 0 : "El gasto no puede ser negativo";
double limite = gasto * factor;
```
**Resuelve:** Comments (el comentario pasa a ser una verificación real que falla si la suposición no se cumple).

---

### Extract Subclass (extraer subclase)
**Cuándo:** una clase tiene atributos o métodos que **solo se usan en algunos casos**.

```java
// ❌ Antes
class Trabajo {
    private boolean esConMateriales;
    private double costoMateriales;     // solo se usa si esConMateriales
    double costo() {
        return esConMateriales ? manoDeObra + costoMateriales : manoDeObra;
    }
}

// ✅ Después
class Trabajo {
    double costo() { return manoDeObra; }
}
class TrabajoConMateriales extends Trabajo {
    private double costoMateriales;
    @Override double costo() { return super.costo() + costoMateriales; }
}
```
**Resuelve:** Large Class.

---

### Replace Delegation with Inheritance (reemplazar delegación por herencia)
**Qué es:** lo **opuesto** a Replace Inheritance with Delegation.
**Cuándo:** una clase delega **todo** a otra con métodos simples (`return otro.x()`), y además **sí es** un tipo de esa otra clase.

```java
// ❌ Antes
class Empleado {
    private Persona persona;
    String getNombre()  { return persona.getNombre(); }
    String getDni()     { return persona.getDni(); }
    String getEmail()   { return persona.getEmail(); }
    // ... un método de delegación por cada método de Persona
}

// ✅ Después
class Empleado extends Persona { }
```
**Resuelve:** Middleman.
**Ojo:** solo si se usan **todos** los métodos del delegado. Si se usa una parte, heredarías cosas de más (Refused Bequest).

---

### Change Bidirectional Association to Unidirectional (cambiar asociación bidireccional a unidireccional)
**Cuándo:** dos clases se conocen mutuamente, pero **una no necesita a la otra**.

```java
// ❌ Antes — Pedido conoce a Cliente y Cliente conoce sus Pedidos
class Pedido  { private Cliente cliente; }
class Cliente { private Set<Pedido> pedidos; }   // nadie lo usa

// ✅ Después
class Pedido  { private Cliente cliente; }
class Cliente { }                                // se elimina la referencia
```
**Resuelve:** Inappropriate Intimacy (menos acoplamiento: si las dos clases se conocen, cualquier cambio en una afecta a la otra).
**Lo opuesto:** Change Unidirectional Association to Bidirectional, cuando las dos realmente se necesitan.

---

## 3.4 Resto del catálogo de Fowler (solo nombrado en el apunte)

El apunte lista estas refactorizaciones sin desarrollarlas. Basta con saber **qué hacen**:

| Refactorización | Se aplica cuando… |
|---|---|
| Change Reference to Value | Un objeto de referencia es chico, casi no cambia y no justifica manejar su ciclo de vida → pasa a ser un valor |
| Change Value to Reference | Hay muchas instancias idénticas de lo mismo → se usa un solo objeto compartido |
| Duplicate Observed Data | Datos del dominio guardados en clases de interfaz gráfica → se copian al dominio y se sincronizan |
| Encapsulate Downcast | Quien llama tiene que castear lo que devuelve un método → el cast se hace dentro del método |
| Hide Method | Un método no lo usa ninguna otra clase → se hace `private` |
| Pull Up Constructor Body | Constructores de subclases casi idénticos → lo común va al constructor del padre (`super(...)`) |
| Remove Control Flag | Una variable booleana controla el flujo de un ciclo → se usa `break`, `continue` o `return` |
| Remove Setting Method | Un atributo se fija al crear el objeto y nunca cambia → se quita el setter (y se lo hace `final`) |
| Replace Array with Object | Un array guarda datos distintos en cada posición (`fila[0]` = nombre, `fila[1]` = goles) → se crea una clase |
| Replace Constructor with Factory Method | El constructor hace algo más que asignar valores → se usa un método estático de creación |
| Replace Error Code with Exception | Un método devuelve un valor especial (`-1`) para indicar error → se lanza una excepción |
| Replace Exception with Test | Se lanza una excepción por algo que quien llama podría haber verificado antes → se verifica con un `if` |
| Replace Nested Conditional with Guard Clauses | `if` anidados que esconden el flujo normal → se usan cláusulas de guarda (`if (caso raro) return ...;` al principio) |
| Replace Record with Data Class | Se interactúa con una estructura tipo registro → se crea una clase de datos |
| Replace Subclass with Fields | Subclases que solo difieren en métodos que devuelven constantes → se reemplazan por atributos del padre |
