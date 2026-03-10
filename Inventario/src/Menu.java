import java.util.Scanner;
public class Menu {

    private final ServicioInventario servicio;
    private final Scanner scanner;

    public Menu(ServicioInventario servicio) {
        this.servicio = servicio;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;

        do {
            System.out.println("\n===== SISTEMA DE INVENTARIO =====");
            System.out.println("1. Agregar producto");
            System.out.println("2. Buscar producto");
            System.out.println("3. Mostrar todos los productos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    buscarProducto();
                    break;
                case 3:
                    mostrarProductos();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente de nuevo.");
            }

        } while (opcion != 4);
    }

    private void agregarProducto() {
        System.out.println("\n--- Agregar producto ---");

        System.out.print("Ingrese el codigo del producto: ");
        String codigo = scanner.nextLine();

        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el stock del producto: ");
        int stock = leerEntero();

        Producto producto = new Producto(codigo, nombre, stock);
        servicio.agregarProducto(producto);

        System.out.println("Producto agregado correctamente.");
    }

    private void buscarProducto() {
        System.out.println("\n--- Buscar producto ---");

        System.out.print("Ingrese el codigo del producto: ");
        String codigo = scanner.nextLine();

        Producto producto = servicio.buscarProducto(codigo);

        if (producto != null) {
            System.out.println("Producto encontrado:");
            System.out.println(producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private void mostrarProductos() {
        System.out.println("\n--- Lista de productos ---");

        if (servicio.obtenerProductos().isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (Producto producto : servicio.obtenerProductos()) {
                System.out.println(producto);
            }
        }
    }

    private int leerEntero() {
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada invalida. Ingrese un numero: ");
            scanner.next();
        }
        int numero = scanner.nextInt();
        scanner.nextLine();
        return numero;
    }
}