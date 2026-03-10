public interface Inventario {

    void agregarProducto(Producto producto);

    void eliminarProducto(String nombre);

    Producto buscarProducto(String nombre);

    void mostrarProductos();

}