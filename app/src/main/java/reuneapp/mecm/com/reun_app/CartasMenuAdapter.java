package reuneapp.mecm.com.reun_app;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ing. Soporte on 10/08/2016.
 */
public class CartasMenuAdapter extends RecyclerView.Adapter<CartasMenuAdapter.CartasMenuHolder> implements View.OnClickListener {
    private List<CartasMenu> items;
    private View.OnClickListener listener;

    public static class CartasMenuHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView imagen;
        public TextView nombre;
        public TextView cantidadReuniones;
        public ImageButton entrar;
        public Intent intento;

        /**
         * Constructor del holder de las cartas del menu de inicio
         *
         * @param v
         */
        public CartasMenuHolder(final View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.nombre);
            cantidadReuniones = (TextView) v.findViewById(R.id.cantidadReuniones);
            entrar = (ImageButton) v.findViewById(R.id.entrar);
        }

    }


    public CartasMenuAdapter(List<CartasMenu> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public CartasMenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.reunion_card, parent, false);
        v.setOnClickListener(this);
        return new CartasMenuHolder(v);
    }

    @Override
    public void onBindViewHolder(CartasMenuHolder holder, int position) {
        holder.imagen.setImageResource(items.get(position).getImagen());
        holder.nombre.setText(items.get(position).getNombre());
        holder.cantidadReuniones.setText("Diponibles: "+String.valueOf(items.get(position).getCantidadReuniones()));
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener= listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }
}
