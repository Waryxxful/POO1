public class Item {
    protected int id;
    protected int cantidad;
    protected String nombre;

    public Item(int id, int cantidad, String nombre) {
        this.id = id;
        this.cantidad = cantidad;
        this.nombre = nombre;
    }

    public void usar(Mascota mascota) {
    }
}

public class Comida extends Item {
    public Comida(int id, int cantidad, String nombre) {
        super(id, cantidad, nombre);
    }

    
    public void usar(Mascota mascota) {
        mascota.aumentarEnergia(20);
        mascota.aumentarSalud(20);
    }
}


public class Medicina extends Item {
    public Medicina(int id, int cantidad, String nombre) {
        super(id, cantidad, nombre);
    }

    public void usar(Mascota mascota) {
        mascota.aumentarSalud(40);
    }
}

public class Juguete extends Item {
    public Juguete(int id, int cantidad, String nombre) {
        super(id, cantidad, nombre);
    }

    public void usar(Mascota mascota) {
        mascota.aumentarFelicidad(30);
    }
}