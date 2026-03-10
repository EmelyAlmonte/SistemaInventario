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

        Producto producto = new Producto(codigo, nombre, stock, precio);
        inventario.agregarProducto(producto);
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