# Ejercicios de práctica: Bad Smells (DAS)

4 simulacros de parcial con 2 ejercicios cada uno, armados con el mismo formato que las consignas de la profe. **Entre los 8 ejercicios aparecen los 23 bad smells del apunte**; algunos se repiten.

- Cada simulacro está pensado para **90 minutos**, como el parcial.
- El **ej1** es abierto: tenés que encontrar vos los smells.
- El **ej2** te dice cuál es el smell principal, igual que en el parcial.
- Cada ejercicio es un paquete aparte con su propio `Run`.

| Simulacro | ej1 (abierto) | ej2 (smell indicado) |
|---|---|---|
| 1 | `sim1.ej1`: alquiler de autos | `sim1.ej2`: envíos por correo |
| 2 | `sim2.ej1`: reservas de hotel | `sim2.ej2`: cuentas bancarias |
| 3 | `sim3.ej1`: farmacia | `sim3.ej2`: aseguradora de vehículos |
| 4 | `sim4.ej1`: app de delivery | `sim4.ej2`: centro de avisos |

> ⚠️ `SOLUCIONES-NO-ABRIR.md` tiene los smells de cada ejercicio. Abrilo recién cuando termines el simulacro.

## Cómo usarlo

1. En IntelliJ: **File → Open** → elegí la carpeta `ejerciciosDas`. Se abre como proyecto Maven.
2. Antes de tocar nada, **corré el `Run`** del ejercicio para ver qué imprime.
3. Escribí los smells en un archivo `BADSMELLS` dentro del paquete (dónde, por qué y qué refactorización aplicás), como venías haciendo.
4. Refactorizá.
5. Verificá que no cambiaste el comportamiento observable:

```bash
./verificar.sh 1 1
```

El script compila el paquete, lo corre y compara la salida con la del código original (están en `salidas-esperadas/`). Si te dice `OK`, la salida es idéntica.

Para volver un ejercicio a su versión original: `git checkout -- src/main/java/ar/edu/ubp/das/sim1/ej1`.

---

## Simulacro 1

**Ejercicio 1.** El código proporcionado dentro del paquete `ar.edu.ubp.das.sim1.ej1` requiere que:
- Se identifiquen los bad smells presentes en el código.
- Se refactorice el código para mejorar su diseño, asegurándose de mantener la funcionalidad original.
- Justifique las decisiones de diseño tomadas durante la refactorización.

**Ejercicio 2.** El código proporcionado dentro del paquete `ar.edu.ubp.das.sim1.ej2` contiene el bad smell **"Biblioteca de clases incompleta"**.
Se solicita que identifique el bad smell en el código y aplique las refactorizaciones necesarias para resolverlo, asegurándose de preservar la funcionalidad original del programa. Además, deberá justificar cada cambio realizado, explicando cómo la refactorización aplicada elimina el bad smell identificado y mejora el diseño del código.

## Simulacro 2

**Ejercicio 1.** El código proporcionado dentro del paquete `ar.edu.ubp.das.sim2.ej1` requiere que:
- Se identifiquen los bad smells presentes en el código.
- Se refactorice el código para mejorar su diseño, asegurándose de mantener la funcionalidad original.
- Justifique las decisiones de diseño tomadas durante la refactorización.

**Ejercicio 2.** El código proporcionado dentro del paquete `ar.edu.ubp.das.sim2.ej2` contiene el bad smell **"Legado rechazado"**.
Se solicita que identifique el bad smell en el código y aplique las refactorizaciones necesarias para resolverlo, asegurándose de preservar la funcionalidad original del programa. Además, deberá justificar cada cambio realizado, explicando cómo la refactorización aplicada elimina el bad smell identificado y mejora el diseño del código.

## Simulacro 3

**Ejercicio 1.** El código proporcionado dentro del paquete `ar.edu.ubp.das.sim3.ej1` requiere que:
- Se identifiquen los bad smells presentes en el código.
- Se refactorice el código para mejorar su diseño, asegurándose de mantener la funcionalidad original.
- Justifique las decisiones de diseño tomadas durante la refactorización.

**Ejercicio 2.** El código proporcionado dentro del paquete `ar.edu.ubp.das.sim3.ej2` contiene el bad smell **"Jerarquías paralelas"**.
Se solicita que identifique el bad smell en el código y aplique las refactorizaciones necesarias para resolverlo, asegurándose de preservar la funcionalidad original del programa. Además, deberá justificar cada cambio realizado, explicando cómo la refactorización aplicada elimina el bad smell identificado y mejora el diseño del código.

## Simulacro 4

**Ejercicio 1.** El código proporcionado dentro del paquete `ar.edu.ubp.das.sim4.ej1` requiere que:
- Se identifiquen los bad smells presentes en el código.
- Se refactorice el código para mejorar su diseño, asegurándose de mantener la funcionalidad original.
- Justifique las decisiones de diseño tomadas durante la refactorización.

**Ejercicio 2.** El código proporcionado dentro del paquete `ar.edu.ubp.das.sim4.ej2` contiene el bad smell **"Clases alternativas con diferentes interfaces"**.
Se solicita que identifique el bad smell en el código y aplique las refactorizaciones necesarias para resolverlo, asegurándose de preservar la funcionalidad original del programa. Además, deberá justificar cada cambio realizado, explicando cómo la refactorización aplicada elimina el bad smell identificado y mejora el diseño del código.

---

**NOTA (vale para todos):** No es necesario mantener la implementación actual del `main`, pero la refactorización no debe alterar el comportamiento observable del programa.
