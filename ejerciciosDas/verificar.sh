#!/bin/bash
# Compara la salida de tu versión con la del código original.
# Uso: ./verificar.sh <simulacro> <ejercicio>     ej: ./verificar.sh 1 2

if [ $# -ne 2 ]; then
    echo "Uso: ./verificar.sh <simulacro> <ejercicio>   (ej: ./verificar.sh 1 2)"
    exit 1
fi

cd "$(dirname "$0")" || exit 1
paquete="src/main/java/ar/edu/ubp/das/sim$1/ej$2"
esperada="salidas-esperadas/sim$1-ej$2.txt"
out=$(mktemp -d)
trap 'rm -rf "$out"' EXIT

if ! javac -d "$out" $(find "$paquete" -name '*.java'); then
    echo "NO COMPILA: revisá los errores de arriba"
    exit 1
fi

if diff <(java -cp "$out" "ar.edu.ubp.das.sim$1.ej$2.Run" 2>&1) "$esperada"; then
    echo "OK: la salida es igual a la del código original"
else
    echo "DISTINTA: las líneas con < son tu salida y las con > la original"
    exit 1
fi
