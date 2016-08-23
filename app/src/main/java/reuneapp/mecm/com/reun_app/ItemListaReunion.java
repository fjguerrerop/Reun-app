package reuneapp.mecm.com.reun_app;

/**
 * Created by Ing. Soporte on 22/08/2016.
 */
public class ItemListaReunion {
    private int imagen;
    private String tituloReunion;
    private String fecha;
    private String ciudad;

    public ItemListaReunion(int imagen, String tituloReunion, String fecha, String ciudad) {
        this.imagen = imagen;
        this.tituloReunion = tituloReunion;
        this.fecha = fecha;
        this.ciudad = ciudad;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getTituloReunion() {
        return tituloReunion;
    }

    public void setTituloReunion(String tituloReunion) {
        this.tituloReunion = tituloReunion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String lugar) {
        this.fecha = fecha;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
