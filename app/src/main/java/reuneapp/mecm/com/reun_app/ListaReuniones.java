package reuneapp.mecm.com.reun_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ListaReuniones extends AppCompatActivity {
    private List items;
    private RecyclerView reciclador;
    private ItemListaReunionAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_reuniones);

        items = new ArrayList();
        items.add(new ItemListaReunion(R.drawable.magnifier, "Reunion de prueba 1", "12/03/2016", "Ibagué Tolima"));
        items.add(new ItemListaReunion(R.drawable.magnifier, "Reunion de prueba 2", "18/03/2016", "Bogotá DC"));
        items.add(new ItemListaReunion(R.drawable.magnifier, "Reunion de prueba 3", "12/06/2016", "Neiva Huila"));
        items.add(new ItemListaReunion(R.drawable.magnifier, "Reunion de prueba 4", "14/08/2016", "Cali Valle del Cauca"));

        reciclador = (RecyclerView)findViewById(R.id.recicladorReuniones);
        reciclador.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        reciclador.setLayoutManager(layoutManager);

        adapter= new ItemListaReunionAdapter(items);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(getApplicationContext(),Reunion.class);
                startActivity(intento);
            }
        });
        reciclador.setAdapter(adapter);

    }
}
