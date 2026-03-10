public class ServicioInventario {
    private Inventario inventario;

    public ServicioInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public void registrarProducto(String codigo, String nombre, int stock, double precio) {
        if (stock < 0) {
            System.out.println("Error: el stock no puede ser negativo.");
            return;
        }
        if (precio < 0) {
            System.out.println("Error: el precio no puede ser negativo.");
            return;
        }
        if (inventario.buscarProducto(codigo) != null) {
            System.out.println("Error: ya existe un producto con ese codigo.");
            return;
        }

        Producto producto = new Producto(codigo, nombre, stock, precio);
        inventario.agregarProducto(producto);
        System.out.println("Producto registrado correctamente.");
    }

    public void consultarProducto(String codigo) {
        Producto producto = inventario.buscarProducto(codigo);

        if (producto != null) {
            System.out.println("\nProducto encontrado:");
            System.out.println(producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void listarProductos() {
        inventario.mostrarProductos();
    }
}