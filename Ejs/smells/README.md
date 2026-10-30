# Un ejercicio por bad smell

23 ejercicios cortos, **uno por cada bad smell del apunte**, para practicar **cómo se resuelve** cada uno.
Cada ejercicio tiene un solo smell principal y te dice cuál es, como el ej2 del parcial. La idea es que practiques la refactorización, no la búsqueda.

- Cada uno es un paquete aparte con su `Run`. Son chicos: entre 10 y 15 minutos cada uno.
- **Del 01 al 10 están los smells que la profe tomó el año pasado** (peluquería y super). Arrancá por esos.
- La columna "Refactorizaciones del apunte" copia la tabla del final del apunte (págs. 44 y 45). No hace falta usarlas todas: elegí las que correspondan.

## Consigna (vale para todos)

El código proporcionado dentro del paquete `ar.edu.ubp.das.ejNN_...` contiene el bad smell indicado en la tabla.
Se solicita que identifique el bad smell en el código y aplique las refactorizaciones necesarias para resolverlo, asegurándose de preservar la funcionalidad original del programa. Además, deberá justificar cada cambio realizado, explicando cómo la refactorización aplicada elimina el bad smell identificado y mejora el diseño del código.

**NOTA:** No es necesario mantener la implementación actual del `main`, pero la refactorización no debe alterar el comportamiento observable del programa.

## Los 23 ejercicios

| # | Paquete | Bad smell | Refactorizaciones del apunte |
|---|---|---|---|
| 01 | `ej01_codigoduplicado` | Código duplicado | Extract method. Extract class. Pull up method. Form template method. |
| 02 | `ej02_metodolargo` | Método largo | Extract method. Replace temp with query. Replace method with method object. Decompose conditional. |
| 03 | `ej03_listaparametroslarga` | Lista de parámetros larga | Replace parameter with method. Introduce parameter object. Preserve whole object. |
| 04 | `ej04_gruposdedatos` | Grupos de datos | Extract class. Introduce parameter object. Preserve whole object. |
| 05 | `ej05_obsesionprimitiva` | Obsesión primitiva | Replace data value with object. Extract class. Introduce parameter object. Replace array with object. Replace type code with class / subclasses / state-strategy. |
| 06 | `ej06_atributotemporal` | Atributo temporal | Extract class. Introduce null object. (La profe, en super, los pasó a parámetros: *Add parameter*). |
| 07 | `ej07_envidiadecaracteristicas` | Envidia de características | Move method. Move field. Extract method. |
| 08 | `ej08_intermediario` | Intermediario | Remove middle man. Inline method. Replace delegation with inheritance. |
| 09 | `ej09_legadorechazado` | Legado rechazado | Replace inheritance with delegation. |
| 10 | `ej10_codigomuerto` | Código muerto | Inline class. Collapse hierarchy. Remove parameter. (Y borrar lo que no se usa). |
| 11 | `ej11_clasededatos` | Clase de datos | Move method. Encapsulate field. Encapsulate collection. |
| 12 | `ej12_agrupacioncondicional` | Estructuras de agrupación condicional | Replace conditional with polymorphism. Replace type code with subclasses. Replace type code with state/strategy. Replace parameter with explicit methods. Introduce null object. |
| 13 | `ej13_cadenademensajes` | Cadena de mensajes | Hide delegate. |
| 14 | `ej14_comentarios` | Comentarios | Extract method. Introduce assertion. |
| 15 | `ej15_claseperezosa` | Clase perezosa | Inline class. Collapse hierarchy. |
| 16 | `ej16_generalidadespeculativa` | Generalidad especulativa | Collapse hierarchy. Inline class. Remove parameter. Rename method. |
| 17 | `ej17_clasegrande` | Clase grande | Extract class. Extract subclass. Extract interface. Replace data value with object. |
| 18 | `ej18_cambiodivergente` | Cambio divergente | Extract class. |
| 19 | `ej19_cambioencadena` | Cambio en cadena | Move method. Move field. Inline class. |
| 20 | `ej20_intimidadinadecuada` | Intimidad inadecuada | Move method. Move field. Change bidirectional association to unidirectional. Replace inheritance with delegation. Hide delegate. |
| 21 | `ej21_jerarquiasparalelas` | Jerarquías paralelas | Move method. Move field. |
| 22 | `ej22_clasesalternativas` | Clases alternativas con diferentes interfaces | Rename methods. Move method. Add parameter. Parameterize method. Extract superclass. |
| 23 | `ej23_bibliotecaincompleta` | Biblioteca de clases incompleta | Introduce foreign method. Introduce local extension. |

## Cómo trabajar cada uno

1. Corré el `Run` original y mirá qué imprime.
2. Escribí en un archivo `BADSMELLS` dentro del paquete, como hacés en el parcial:
   - **Smell:** nombre en español (y en inglés).
   - **Dónde:** clase y método.
   - **Por qué es un problema:** con las palabras del apunte.
   - **Refactorización:** nombre del catálogo y qué hiciste concretamente.
3. Refactorizá.
4. Verificá que la salida no cambió:

```bash
./verificar.sh 07
```

Si dice `OK`, la salida es idéntica a la del original (están guardadas en `salidas-esperadas/`).

## Resoluciones

Cada ejercicio tiene una carpeta `resolucion/` con una forma de resolverlo:
- El código refactorizado, en el paquete `ar.edu.ubp.das.ejNN_....resolucion`, con su propio `Run`.
- Un archivo `BADSMELLS` con lo que escribirías en el parcial: el smell, dónde está, por qué es un problema, qué refactorización del apunte se aplicó y qué otras opciones había.

Conviene intentarlo primero y después comparar. No es la única solución válida: si usaste otra refactorización de la tabla del apunte y la salida da igual, también está bien.

Para comprobar que la resolución da la misma salida que el original:

```bash
./verificar.sh 07 resolucion
```

`./verificar.sh 07`, sin el segundo argumento, sigue verificando tu versión y no compila la carpeta `resolucion`.

Para volver un ejercicio a su versión original: `git checkout -- src/main/java/ar/edu/ubp/das/ej07_envidiadecaracteristicas`.

## Ojo con el comportamiento

- **03:** si pasás la fecha a `LocalDate`, tiene que seguir imprimiendo `3/3/2025` y no `2025-03-03`.
- **06:** en el `main`, las horas extra del caso 2 **se arrastran** al caso 3. Tu versión tiene que dar los mismos totales.
- **09:** el `main` usa `size()`. Si cambiás la herencia, ese dato lo tenés que seguir pudiendo mostrar.
- **14:** un `assert` no cambia la salida (Java los ignora salvo que corras con `-ea`).
- **En todos:** al mover cuentas a otro método, mantené el orden de las operaciones para que los `double` impresos no cambien.
