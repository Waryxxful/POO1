public class Item {
    private int id;
    private String nombre;
    private int cantidad;

    public Item(int id, String nombre, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = 0; //al principio no hay iteme
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void usar() {
        if (cantidad > 0) {
            cantidad--;
        }
    }

    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}

class Comida extends Item {
    public Comida(int id, String nombre, int cantidad) {
        super(id, nombre, cantidad);
    }
}

class Medicina extends Item {
    public Medicina(int id, String nombre, int cantidad) {
        super(id, nombre, cantidad);
    }
}

class Juguete extends Item {
    public Juguete(int id, String nombre, int cantidad) {
        super(id, nombre, cantidad);
    }
}
