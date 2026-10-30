#!/bin/bash
# Compara la salida de tu versión (o de la resolución) con la del código original.
# Uso: ./verificar.sh <ejercicio>              ej: ./verificar.sh 07
#      ./verificar.sh <ejercicio> resolucion   ej: ./verificar.sh 07 resolucion

uso() {
    echo "Uso: ./verificar.sh <ejercicio>              (ej: ./verificar.sh 07)"
    echo "     ./verificar.sh <ejercicio> resolucion   (ej: ./verificar.sh 07 resolucion)"
    exit 1
}

if [ $# -lt 1 ] || [ $# -gt 2 ]; then
    uso
fi

cd "$(dirname "$0")" || exit 1
num=$(printf "%02d" "$((10#$1))")
paquete=$(ls -d src/main/java/ar/edu/ubp/das/ej${num}_* 2>/dev/null | head -1)
if [ -z "$paquete" ]; then
    echo "No existe el ejercicio $num"
    exit 1
fi
nombre=$(basename "$paquete")
esperada="salidas-esperadas/$nombre.txt"

if [ $# -eq 2 ]; then
    if [ "$2" != "resolucion" ]; then
        uso
    fi
    if [ ! -d "$paquete/resolucion" ]; then
        echo "El ejercicio $num todavía no tiene resolución"
        exit 1
    fi
    fuentes=$(find "$paquete/resolucion" -name '*.java')
    clase="ar.edu.ubp.das.$nombre.resolucion.Run"
else
    fuentes=$(find "$paquete" -name '*.java' -not -path '*/resolucion/*')
    clase="ar.edu.ubp.das.$nombre.Run"
fi

out=$(mktemp -d)
trap 'rm -rf "$out"' EXIT

if ! javac -d "$out" $fuentes; then
    echo "NO COMPILA: revisá los errores de arriba"
    exit 1
fi

if diff <(java -cp "$out" "$clase" 2>&1) "$esperada"; then
    echo "OK: la salida es igual a la del código original"
else
    echo "DISTINTA: las líneas con < son tu salida y las con > la original"
    exit 1
fi
