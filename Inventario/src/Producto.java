public class Producto {

    private String codigo;
    private String nombre;
    private int cantidad;
    private double precio;

    public Producto(String codigo, String nombre, int cantidad, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // GETTERS
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    // SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        if (cantidad >= 0) {
            this.cantidad = cantidad;
        }
    }

    public void setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        }
    }

    // Metodo para aumentar stock
    public void agregarStock(int cantidad) {
        if (cantidad > 0) {
            this.cantidad += cantidad;
        }
    }

    // Metodo para reducir stock
    public void reducirStock(int cantidad) {
        if (cantidad > 0 && this.cantidad >= cantidad) {
            this.cantidad -= cantidad;
        }
    }

    // Para imprimir el producto facilmente
    @Override
    public String toString() {
        return "Codigo: " + codigo +
               " | Nombre: " + nombre +
               " | Stock: " + cantidad +
               " | Precio: $" + precio;
    }
}