package reuneapp.mecm.com.reun_app;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Ing. Soporte on 19/08/2016.
 */
public class AppController extends Application {
    public static final String ETIQUETA = AppController.class.getSimpleName(); // Obtiene el nombre de la clase
    private RequestQueue mRequestQueue; //Solicitud hecha a través de volley
    private static AppController mInstancia;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstancia = this;
    }

    /***
     * Retorna la instancia de la aplicación
     *
     * @return AppController Instancia de la aplicación
     */
    public static AppController getmInstancia() {
        return mInstancia;
    }

    /***
     * Retorna el RequestQueue que ejecuta la solicitud
     *
     * @return
     */
    public RequestQueue getmRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String etiqueta) {
        req.setTag(TextUtils.isEmpty(etiqueta) ? ETIQUETA : etiqueta);
        getmRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(ETIQUETA);
        getmRequestQueue().add(req);
    }

    public void cancelarSolicitudesPendientes(Object etiqueta) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(etiqueta);
        }
    }
}
