public class Mascota {
    private String nombre;
    private float edad;
    private int salud;
    private int energia;
    private int felicidad;

    public enum Estado {
        NEUTRO("(-_-) Meh...."),
        FELIZ("\\(^_^)/ Weeeeeh!"),
        TRISTE("(._.) snif...."),
        HAMBRIENTO("(0o0) hambre hambre!"),
        ENOJADO("(ôwô) grrrr...."),
        CANSADO("(=_=) zzzz...."),
        MUERTO("(x_x) fin del juego");

        private final String cara;

        Estado(String cara) {
            this.cara = cara;
        }

        @Override
        public String toString() {
            return this.cara;
        }
    }

    public Mascota(String nombre) {
        this.nombre = nombre;
        this.edad = 0.0f;
        this.salud = 100;
        this.energia = 100;
        this.felicidad = 50; 
    }

    private int asegurarRango(int valor) {
        if (valor > 100) {
            return 100;
        } else if (valor < 0) {
            return 0;
        }
        return valor;
    }

    public void setSalud(int salud) {
        this.salud = asegurarRango(salud);
    }

    public int getSalud() {
        return salud;
    }

    public void setEnergia(int energia) {
        this.energia = asegurarRango(energia);
    }

    public int getEnergia() {
        return energia;
    }

    public void setFelicidad(int felicidad) {
        this.felicidad = asegurarRango(felicidad);
    }

    public int getFelicidad() {
        return felicidad;
    }

    public void incrementarEdad(float incremento) {
        edad += incremento;
        if (edad > 15) { 
            edad = 15; // Fin del juego
        }
    }

    public float getEdad() {
        return edad;
    }

    public Estado getEstado() {
        if (salud <= 0 || energia <= 0 || edad >= 15) {
            return Estado.MUERTO;
        }

        if (energia <= 15) {
            return Estado.CANSADO;
        }

        if (edad > 5 && salud <= 30 && energia <= 30) {
            return Estado.ENOJADO;
        }

        if ((salud <= 20 && edad <= 5) || (salud <= 50 && edad > 5 && edad <= 10)) {
            return Estado.HAMBRIENTO;
        }

        if (felicidad >= 60) {
            return Estado.FELIZ;
        }

        if (felicidad <= 20) {
            return Estado.TRISTE;
        }

        return Estado.NEUTRO;
    }

    public void mostrarAtributos() {
        System.out.println("Atributos");
        System.out.println("---------");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Salud: " + salud);
        System.out.println("Energía: " + energia);
        System.out.println("Felicidad: " + felicidad);
        System.out.println("Estado: " + getEstado());
        System.out.println();
    }

    public void reducirIndicadores(int decremento) {
        this.salud = asegurarRango(this.salud - decremento);
        this.energia = asegurarRango(this.energia - decremento);
        this.felicidad = asegurarRango(this.felicidad - decremento);
    }
}
