package reuneapp.mecm.com.reun_app;

import android.app.Application;

/**
 * Created by Ing. Soporte on 10/08/2016.
 */
public class CartasMenu {
    private int imagen;
    private String nombre;
    private int cantidadReuniones;
    private String destino;
    private Application app;

    public CartasMenu(int imagen, String nombre, String destino, int cant) {
        this.imagen = imagen;
        this.cantidadReuniones= cant;
        this.nombre = nombre;
        this.destino = destino;
    }

    /***
     * Hace referencia a la ubicación en R de la imagen del card
     * @return Entero correspondiente a la imagen
     */
    public int getImagen() {
        return imagen;
    }

    /***
     * Obtiene el nombre de la carta
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /***
     * Retorna la cantidad de reuniones disponibles.
     * @return
     */
    public int getCantidadReuniones() {
        return cantidadReuniones;
    }

    /***
     * Hace referencia a la reunion destino.
     * @return
     */
    public String getDestino() {
        return destino;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidadReuniones(int cantidadReuniones) {
        this.cantidadReuniones = cantidadReuniones;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
