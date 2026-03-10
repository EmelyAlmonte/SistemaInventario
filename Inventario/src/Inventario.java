import java.util.List;
public interface Inventario {

    void agregarProducto(Producto producto);

    void eliminarProducto(String codigo);

    Producto buscarProducto(String codigo);

    void mostrarProductos();

    List<Producto> obtenerProductos();

}