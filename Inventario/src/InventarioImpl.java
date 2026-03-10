import java.util.ArrayList;
import java.util.List;

public class InventarioImpl implements Inventario {

    private List<Producto> productos;

    public InventarioImpl() {
        productos = new ArrayList<>();
    }

    @Override
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    @Override
public void eliminarProducto(String codigo) {

    Producto producto = buscarProducto(codigo);

    if (producto != null) {
        productos.remove(producto);
        System.out.println("Producto eliminado correctamente.");
    } else {
        System.out.println("Producto no encontrado.");
    }
}

    @Override
    public Producto buscarProducto(String codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equalsIgnoreCase(codigo)) {
                return producto;
            }
        }
        return null;
    }

    @Override
public void mostrarProductos() {

    if (productos.isEmpty()) {
        System.out.println("No hay productos registrados.");
        return;
    }

    for (Producto producto : productos) {
        System.out.println(producto);
    }
}

    @Override
    public List<Producto> obtenerProductos() {
        return productos;
    }
}