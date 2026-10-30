package ar.edu.ubp.das.ej12_agrupacioncondicional.resolucion_enum;

// Un enum es una clase que tiene una cantidad fija de instancias: las constantes
// de la primera línea. No se puede hacer new TipoEntrada(...) desde afuera.
public enum TipoEntrada {

    // Cada constante llama al constructor con sus datos (los paréntesis) y, como
    // calcularPrecio es abstracto, cada una trae su propia implementación (las llaves).
    // Las constantes se separan con coma y la última termina con punto y coma.
    GENERAL("Sin beneficio", false) {
        @Override
        public double calcularPrecio(double precioBase) {
            return precioBase;
        }
    },
    ESTUDIANTE("30% de descuento", true) {
        @Override
        public double calcularPrecio(double precioBase) {
            return precioBase * 0.70;
        }
    },
    JUBILADO("50% de descuento", true) {
        @Override
        public double calcularPrecio(double precioBase) {
            return precioBase * 0.50;
        }
    },
    VIP("Butaca premium + combo", false) {
        @Override
        public double calcularPrecio(double precioBase) {
            return precioBase * 1.5 + 2000;
        }
    };

    private final String beneficio;
    private final boolean requiereDocumento;

    // El constructor de un enum es privado siempre (no hace falta escribirlo).
    TipoEntrada(String beneficio, boolean requiereDocumento) {
        this.beneficio = beneficio;
        this.requiereDocumento = requiereDocumento;
    }

    public String getBeneficio() {
        return beneficio;
    }

    public boolean requiereDocumento() {
        return requiereDocumento;
    }

    public abstract double calcularPrecio(double precioBase);

}
