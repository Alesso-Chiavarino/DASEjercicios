# Soluciones: abrir solo después de terminar cada simulacro

Para cada ejercicio están los smells que puse a propósito, dónde están, qué refactorización corresponde y las trampas de comportamiento a cuidar. Si encontraste otro smell bien justificado, también vale.

---

## Simulacro 1, ej1: alquiler de autos

| Bad smell | Dónde | Refactorización |
|---|---|---|
| **Método largo** | `Agencia.imprimirResumen()`: encabezado, detalle de cada alquiler, km excedidos y totales en un solo método | Extract Method (`imprimirEncabezado`, `imprimirDetalle(a)`, `imprimirTotales`) |
| **Comentarios** | Cada bloque de `imprimirResumen` necesita un comentario para entenderse. Además, en `calcularTotal` el comentario dice **"$100 por km"** pero el código cobra **150**: el comentario quedó desactualizado y miente | Extract Method usando el comentario como nombre del método; Replace Magic Number with Symbolic Constant (`PRECIO_KM_EXCEDIDO`) |
| **Envidia de características** | `Agencia.calcularTotal(Alquiler a)` usa solo datos de `Alquiler` | Move Method → `alquiler.calcularTotal()` |
| **Clase de datos** | `Alquiler`: solo getters/setters y se arma con 5 `set` | Move Method (`calcularTotal`, `getKmExcedidos`, `esFueraDeProvincia`) + constructor; Remove Setting Method |
| **Cadena de mensajes** | `a.getCliente().getDireccion().getLocalidad().getProvincia()` (2 veces) y el armado del domicilio | Hide Delegate (`cliente.getProvincia()`, `direccion.toString()`). Ojo: si delegás todo, aparece Intermediario |
| **Código duplicado** | Los km excedidos y el "no es de Córdoba" se calculan en `calcularTotal` **y** en `imprimirResumen` | Extract Method en `Alquiler` y usarlo en los dos lados |
| Números mágicos | `200`, `150`, `8000`, `25000`, `"Córdoba"` | Replace Magic Number with Symbolic Constant |

**Trampas:** "Km excedidos" se imprime solo si es mayor a 0. Hay que mantener el orden de los mensajes y el formato `$129000.0`.

## Simulacro 1, ej2: envíos (Biblioteca de clases incompleta)

- **El smell**: `java.time.LocalDate` no tiene "es día hábil" ni "sumar N días hábiles", y no se puede modificar. Esa lógica se escribió a mano en **3 lugares**:
  - `Envio.getFechaEstimadaEntrega()`
  - `Reclamo.getFechaLimiteRespuesta()`
  - `Sucursal.despachar()` (el chequeo de sábado y domingo)
- **Refactorización**:
  - **Introduce Foreign Method**: una clase utilitaria con `static LocalDate sumarDiasHabiles(LocalDate fecha, int dias)` y `static boolean esDiaHabil(LocalDate fecha)`, que reciben la fecha como parámetro (así lo define el apunte). Es lo más rápido para el parcial.
  - **Introduce Local Extension**: ojo, `LocalDate` es `final`, así que **no se puede heredar**. La extensión local tendría que ser un *wrapper* (por ejemplo, `FechaHabil` que contiene un `LocalDate` y le delega). Conviene mencionarlo en la justificación.
- **Smells secundarios**: código duplicado (es la consecuencia del smell) y el número mágico `5` (plazo para responder un reclamo).
- **Distractor**: `Sucursal.formatear()` **no** es este smell, porque `LocalDate` sí trae `format(DateTimeFormatter.ofPattern("d/M/yyyy"))`. Ahí lo que pasa es que no se usó la librería.
- **Trampas**: se empieza a contar desde el día siguiente. `!(dia == SAT || dia == SUN)` equivale a `dia != SAT && dia != SUN` (De Morgan), así que dan lo mismo.

---

## Simulacro 2, ej1: hotel

| Bad smell | Dónde | Refactorización |
|---|---|---|
| **Atributo temporal** | `tipoCotizado`, `nochesCalculadas`, `tarifaPorNoche`, `descuentoAplicado`: solo tienen sentido después de llamar a `cotizar()`, y `imprimirUltimaCotizacion()` depende de eso | Extract Class `Cotizacion` (la devuelve `cotizar()` y sabe imprimirse) |
| **Lista de parámetros larga** | `reservar(...)` (9), constructor de `Reserva` (10), `listarReservasDe(...)` (4) | Introduce Parameter Object / Preserve Whole Object |
| **Grupos de datos** | `(nombre, apellido, dni, email)` y `(desde, hasta)` viajan siempre juntos | Extract Class `Huesped` y `Estadia`/`RangoFechas` (con `noches()` y `seSuperponeCon(otra)`) |
| **Obsesión primitiva** | `tipoHabitacion` como `String` (`"SIMPLE"`/`"DOBLE"`/`"SUITE"`) con `if` para la tarifa; `email` como `String` con validación suelta | Replace Type Code with Class (`enum TipoHabitacion` con su tarifa); Replace Data Value with Object (`Email`) |
| **Código duplicado** | El cálculo de noches, tarifa, adicional por persona y descuento está copiado en `cotizar()` y `reservar()` | Extract Method (o que `reservar` use la `Cotizacion`) |
| Números mágicos | Tarifas, `15000`, `7`, `0.10` | Constantes |

**Trampas:** en `reservar` primero se valida el email y después la disponibilidad, y ese orden se ve en la salida. La superposición de fechas es `desde < hasta2 && hasta > desde2`.

## Simulacro 2, ej2: cuentas (Legado rechazado)

- **El smell**: `CajaDeAhorro extends CuentaCorriente`, pero una caja de ahorro **no es** una cuenta corriente. Rechaza lo que hereda:
  - `emitirCheque` lo anula tirando una excepción.
  - `limiteDescubierto` queda forzado a `0`.
  - `chequesEmitidos` no aplica.
  - `calcularMantenimiento` lo pisa con `0`.
- **Síntomas extra**: `Banco` guarda cajas en una `List<CuentaCorriente>` y usa `instanceof` + cast para acreditar intereses.
- **Refactorización**:
  - **Extract Superclass** `Cuenta` (abstracta: titular, saldo, `depositar`, `extraer`, `resumen`, `calcularMantenimiento` abstracto), con `CuentaCorriente` y `CajaDeAhorro` como **hermanas**. Así cada una tiene solo lo suyo y `emitirCheque` queda solo en la corriente.
  - Alternativa del apunte: **Replace Inheritance with Delegation**.
  - Para sacar el `instanceof`: un `cierreDeMes()` polimórfico en cada cuenta (**Replace Conditional with Polymorphism**).
- **Trampas**:
  - En el cierre, primero se acreditan intereses y después se cobra mantenimiento.
  - La caja no imprime la línea de mantenimiento, porque es 0.
  - La caja no tiene descubierto, por eso `extraer(80000)` da `false`.

---

## Simulacro 3, ej1: farmacia

| Bad smell | Dónde | Refactorización |
|---|---|---|
| **Clase grande** | `Farmacia`: stock, ventas, reglas de obras sociales, ticket, reporte y exportación | Extract Class (`Inventario`, `ObraSocial`, `ImpresoraTicket`, `ReporteVentas`) |
| **Cambio divergente** | `Farmacia` cambia por motivos distintos: nueva obra social, cambio de formato del ticket o del reporte, política de stock mínimo | Extract Class (una clase por motivo de cambio) |
| **Estructuras de agrupación condicional** | Dos `switch` sobre el mismo código de obra social: el descuento en `vender()` y el nombre en `nombreObraSocial()` | `enum ObraSocial(nombre, porcentaje)` o Replace Conditional with Polymorphism |
| **Código muerto** | Atributo `sucursalAnterior`, parámetro `urgente` de `reponerStock`, variable `stockAnterior`, método `calcularDescuentoViejo()` | Eliminarlos / Remove Parameter |
| **Generalidad especulativa** | `ProductoBase` abstracta con una sola subclase (el comentario lo confiesa: "para cuando…"), `calcularPuntosFidelidad()` que nadie usa, `exportarXML`/`exportarJSON` que devuelven `null` | Collapse Hierarchy (`Medicamento` absorbe `ProductoBase`); quitar los métodos sin uso de la interfaz |
| Obsesión primitiva | `obraSocial` como `String` | Se resuelve con el `enum` del switch |
| Números mágicos | `5` (stock mínimo), porcentajes | Constantes |

**Trampas:**
- Si la venta es particular, no se imprime la línea de cobertura.
- La alerta de stock se imprime **después** del ticket.
- Las ventas rechazadas no generan ticket ni entran en el reporte.

## Simulacro 3, ej2: aseguradora (Jerarquías paralelas)

- **El smell**: `Vehiculo` (`Auto`, `Moto`, `Camion`) y `Poliza` (`PolizaAuto`, `PolizaMoto`, `PolizaCamion`) crecen en paralelo. Agregar `Camioneta` obliga a crear `Camioneta` + `PolizaCamioneta` + otro `else if` en `Aseguradora`.
- **Refactorización**:
  - **Move Method**: `calcularPrima()` y `descripcion()` pasan a cada subclase de `Vehiculo` (abstractos en `Vehiculo`).
  - `Poliza` queda como **una sola clase concreta** (`numero` + `Vehiculo`) que le delega al vehículo. Se borran `PolizaAuto`, `PolizaMoto` y `PolizaCamion` (una de las dos jerarquías desaparece).
  - `emitirPoliza` pasa a `new Poliza(numero, vehiculo)`: la cadena de `instanceof` y los casts desaparecen (Replace Conditional with Polymorphism).
- **Trampas**: la numeración arranca en 1001, y las fórmulas de prima tienen que dar exactamente igual.

---

## Simulacro 4, ej1: delivery

| Bad smell | Dónde | Refactorización |
|---|---|---|
| **Intimidad inadecuada** | Los atributos de `Pedido` y `Repartidor` no son privados. `Repartidor.tomar/entregar` le cambian `estado` y `repartidor` al pedido, y `Ticket`, `ReporteDiario`, `Despacho` y `Run` leen campos directo (`pedido.numero`, `repartidor.nombre`, `juan.ganancias`) | Encapsulate Field; Move Method (`pedido.asignarA(r)`, `pedido.marcarEntregado()`); Change Bidirectional Association to Unidirectional (`Repartidor.pedidos` nadie lo lee) |
| **Cambio en cadena** | El precio por km (`350`), el reparto 80%/20% y el IVA (`1.21`) están repetidos en `Pedido`, `Repartidor`, `Ticket` y `ReporteDiario`: si cambia el precio por km hay que tocar 4 clases | Move Method/Field: centralizar en `Pedido` (`calcularEnvio()` ya existe y nadie lo usa; agregar `calcularTotal()`, `gananciaRepartidor()`, `comisionPlataforma()`) + constantes |
| **Clase perezosa** | `ValidadorDistancia`: una clase entera para un `return km > 0 && km <= 15` que se usa una sola vez | Inline Class (pasa a `Despacho` o a `Pedido`) |
| **Intermediario** | `CentralPedidos`: todos sus métodos delegan en `Despacho`, `Ticket` o `ReporteDiario` | Remove Middle Man / Inline Class |
| Código duplicado | `distanciaKm * 350` repetido en vez de usar `calcularEnvio()` | Usar el método existente |
| Obsesión primitiva | `estado` como `String` | `enum EstadoPedido` |

**Trampas:**
- El pedido de Carla se rechaza (`null`) y no se le asigna número.
- El reporte suma solo los pedidos `ENTREGADO`: el de Diego está en camino.
- Hay que mantener el orden de la suma `subtotal * 1.21 + envio`.

## Simulacro 4, ej2: avisos (Clases alternativas con diferentes interfaces)

- **El smell**: `EnviadorEmail.enviarCorreo(direccion, asunto, cuerpo)`, `MensajeroSMS.mandar(texto, numero)` (que devuelve `boolean`) y `BotWhatsApp.notificarContacto(contacto, mensaje)` hacen lo mismo (avisar a un contacto) pero con nombres, parámetros, orden y tipo de retorno distintos.
- **Consecuencia**: `CentroDeAvisos` necesita un `if/else` sobre `canalPreferido` (`String`), y lo tiene **duplicado** en `enviarRecordatorio` y `enviarPromocion`.
- **Refactorización**:
  - **Rename Method** + **Add Parameter / Parameterize Method** para unificar la firma, por ejemplo `enviar(Contacto contacto, String asunto, String texto)`.
  - **Extract Interface/Superclass** `Canal`, implementada por las tres clases.
  - `Contacto` guarda un `Canal` en vez del `String` (Replace Type Code with State/Strategy), y `CentroDeAvisos` hace `contacto.getCanal().enviar(...)` sin `if`.
  - El mensaje "No se pudo enviar SMS a …" se mueve adentro del canal SMS.
- **Trampas**:
  - El email usa el asunto (`"Recordatorio"` / `"Promoción especial"`), mientras que SMS y WhatsApp lo ignoran.
  - El SMS recorta a 40 caracteres + `...`.
  - A Diego (teléfono corto) se le imprime el aviso de error.

---

## Cobertura: los 23 bad smells

| # | Bad smell | Dónde aparece |
|---|---|---|
| 1 | Atributo temporal | sim2-ej1 |
| 2 | Cadena de mensajes | sim1-ej1 |
| 3 | Cambio divergente | sim3-ej1 |
| 4 | Cambio en cadena | sim4-ej1 |
| 5 | Clase de datos | sim1-ej1 (también `Pedido` en sim4-ej1) |
| 6 | Código muerto | sim3-ej1 |
| 7 | Clase grande | sim3-ej1 |
| 8 | Clase perezosa | sim4-ej1 |
| 9 | Comentarios | sim1-ej1 |
| 10 | Código duplicado | sim2-ej1 (también sim1-ej1, sim1-ej2, sim4-ej2) |
| 11 | Envidia de características | sim1-ej1 |
| 12 | Estructuras de agrupación condicional | sim3-ej1 (también sim2-ej1, sim3-ej2, sim4-ej2) |
| 13 | Generalidad especulativa | sim3-ej1 |
| 14 | Grupos de datos | sim2-ej1 |
| 15 | Intermediario | sim4-ej1 |
| 16 | Intimidad inadecuada | sim4-ej1 |
| 17 | Jerarquías paralelas | sim3-ej2 |
| 18 | Legado rechazado | sim2-ej2 |
| 19 | Lista de parámetros larga | sim2-ej1 |
| 20 | Método largo | sim1-ej1 |
| 21 | Obsesión primitiva | sim2-ej1 (también sim3-ej1, sim4-ej1) |
| 22 | Clases alternativas con diferentes interfaces | sim4-ej2 |
| 23 | Biblioteca de clases incompleta | sim1-ej2 |
