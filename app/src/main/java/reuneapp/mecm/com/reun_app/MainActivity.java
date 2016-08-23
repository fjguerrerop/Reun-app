package reuneapp.mecm.com.reun_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Intent intento;
    private RecyclerView reciclador;
    private CartasMenuAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<CartasMenu> items = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_menu_inicio);

        reciclador = (RecyclerView) findViewById(R.id.reciclador);
        reciclador.setHasFixedSize(true);
// a partir de aqui esta el problema
        
        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, URLS.CANTIDAD_REUNIONES, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    items.add(new CartasMenu(R.drawable.vreun, "Ver reuniones", "listaReuniones", response.getInt("Cantidad")));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mensajeError(error);
            }
        });
        items.add(new CartasMenu(R.drawable.vreun1, "Personas destacadas", "actlistper", 0));
        AppController.getmInstancia().addToRequestQueue(jor);
        adapter = new CartasMenuAdapter(items);
        layoutManager = new LinearLayoutManager(this);
        reciclador.setLayoutManager(layoutManager);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (reciclador.getChildAdapterPosition(view) == 0) {
                    intento = new Intent(getApplicationContext(), ListaReuniones.class);
                } else if (reciclador.getChildAdapterPosition(view) == 1) {
                    intento = new Intent(getApplicationContext(), ListaPersonas.class);
                }
                startActivity(intento);
            }
        });

        reciclador.setAdapter(adapter);
        reciclador.refreshDrawableState();
    }

    /**
     * Controla los mensajes de error de forma rapida y personalizada
     *
     * @param e Error entrante
     */
    private void mensajeError(Throwable e) {
        Toast.makeText(getApplicationContext(), "Error de tipo: " + e.getCause().toString(), Toast.LENGTH_SHORT).show();
    }

}
