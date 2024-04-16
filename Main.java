import java.util.Random;

// Clase que representa la mascota virtual
class MascotaVirtual {
    private String nombre;
    private int edad;
    private int salud;
    private int energia;
    private int felicidad;
    
    // Constructor
    public MascotaVirtual(String nombre) {
        this.nombre = nombre;
        this.edad = 0;
        this.salud = 100; // Empezamos con salud máxima
        this.energia = 100; // Empezamos con energía máxima
        this.felicidad = 50; // Empezamos con felicidad neutra
    }
    
       
    // Método para verificar y ajustar los límites de los indicadores
    private void verificarLimites() {
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
        edad++; // Incrementar la edad después de cada acción
        
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
    
    // Método para obtener el estado de ánimo de la mascota
    public String obtenerEstadoDeAnimo() {
        if (felicidad > 75) {
            return "feliz";
        } else if (felicidad > 50) {
            return "contento";
        } else if (felicidad > 25) {
            return "triste";
        } else {
            return "muy triste";
        }
    }
    
    // Otros métodos para obtener atributos de la mascota
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

// Clase principal que ejecuta el programa
public class Main {
    public static void main(String[] args) {
        MascotaVirtual mascota = new MascotaVirtual("Bobby");
        
        // Mostrar el estado de ánimo y los atributos de la mascota
        System.out.println("La mascota está " + mascota.obtenerEstadoDeAnimo());
        System.out.println("Edad: " + mascota.obtenerEdad());
        System.out.println("Salud: " + mascota.obtenerSalud());
        System.out.println("Energía: " + mascota.obtenerEnergia());
        System.out.println("Felicidad: " + mascota.obtenerFelicidad());
    }
}
