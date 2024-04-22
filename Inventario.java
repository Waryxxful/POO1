import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Item> items;

    public Inventario() {
        this.items = new ArrayList<>();
    }

    public void agregarItem(Item item) {
        items.add(item);
    }

    public void mostrarItems() {
        System.out.println("Acciones");
        System.out.println("--------");
        System.out.println("0: dormir");
        int index = 1;
        for (Item item : items) {
            System.out.printf("%d: %s, cantidad %d%n", index, item.getNombre(), item.getCantidad());
            index++;
        }
    }

    public Item obtenerItem(int index) {
        if (index >= 1 && index <= items.size()) {
            return items.get(index - 1);
        } else {
            return null;
        }
    }
}
