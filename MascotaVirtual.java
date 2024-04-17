public class MascotaVirtual {
class MascotaVirtual {
    private String nombre;
    private float edad;
    private int salud;
    private int energia;
    private int felicidad;
    
    // Constructor
    public MascotaVirtual(String nombre, obtenerEstadoDeAnimo()) {
        this.nombre = nombre;// nombre
        this.edad = 0;
        this.salud = 100; //  salud máxima
        this.energia = 100; // energía máxima
        this.felicidad = 50; // felicidad neutr

    }
    
       
    // Método para verificar y ajustar los límites de los indicadores
    private void VerificarEstados() {
        if (salud > 100) {
            salud = 100;
        }
        if (salud < 0) {
            salud = 0;
        }
        if (energia > 100) {
            energia = 100;
        }
        if (energia < 0) {
            energia = 0;
        }
        if (felicidad > 100) {
            felicidad = 100;
        }
        if (felicidad < 0) {
            felicidad = 0;
        }
        // Condiciones adicionales
        if (salud <= 10) {
            felicidad -= 20;
        }
        if (salud <= 50 && edad > 5 && edad <= 10) {
            felicidad -= 20;
            energia -= 10;
        }
        if (salud <= 50 && edad > 10) {
            felicidad -= 30;
            energia -= 20;
        }
    }
    
    // Método para obtener el estado de ánimo de la mascota, IMPORTANTE: AGREGAR ESTO EN EL MAIN PARA QUE SE PRINTEE | System.out.println("estado: " + mascota.obtenerEstadoDeAnimo()); |
    public String obtenerEstadoDeAnimo() {
        String cara;
        if (salud <= 0 || energia <= 0 || edad >= 15) {
            cara = "(x_x) fin del juego";
        } else if (energia <= 15) {
            cara = "(=_=) zzzz....";
        } else if (edad > 5 && salud <= 30 && energia <= 30) {
            cara = "(ôwô) grrrr....";
        } else if (salud <= 20 && edad <= 5 || salud <= 50 && edad > 5 && edad <= 10) {
            cara = "(0o0)";
        } else if (felicidad >= 60) {
            cara = "\\(^_^)/ Weeeeeh!";
        } else if (felicidad <= 20) {
            cara = "(._.) snif.... ";
        } else {
            cara = "(-_-) Meh.... ";
        }
        return cara;
    }
    
  
    public String obtenerNombre() {
        return nombre;
    }
    
    public int obtenerEdad() {
        return edad;
    }
    
    public int obtenerSalud() {
        return salud;
    }
    
    public int obtenerEnergia() {
        return energia;
    }
    
    public int obtenerFelicidad() {
        return felicidad;
    }
}
}
