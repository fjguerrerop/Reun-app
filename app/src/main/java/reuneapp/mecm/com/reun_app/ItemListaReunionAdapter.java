package reuneapp.mecm.com.reun_app;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ing. Soporte on 22/08/2016.
 */
public class ItemListaReunionAdapter extends RecyclerView.Adapter<ItemListaReunionAdapter.ItemListaReunionHolder> implements View.OnClickListener {
    private List<ItemListaReunion> items;
    private View.OnClickListener listener;

    public static class ItemListaReunionHolder extends RecyclerView.ViewHolder {

        public ImageView imagen;
        public TextView titulo, fecha, ciudad;

        public ItemListaReunionHolder(View itemView) {
            super(itemView);
            imagen = (ImageView) itemView.findViewById(R.id.imagen_item_reunion);
            titulo = (TextView) itemView.findViewById(R.id.txtTituloItemReunion);
            fecha = (TextView) itemView.findViewById(R.id.txtFechaItemReunion);
            ciudad = (TextView) itemView.findViewById(R.id.txtCiudadItemReunion);
        }
    }

    public ItemListaReunionAdapter(List<ItemListaReunion> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public ItemListaReunionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_reunion,parent,false);
        v.setOnClickListener(this);
        return new ItemListaReunionHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemListaReunionHolder holder, int position) {
        holder.imagen.setImageResource(items.get(position).getImagen());
        holder.titulo.setText(items.get(position).getTituloReunion());
        holder.fecha.setText(items.get(position).getFecha());
        holder.ciudad.setText(items.get(position).getCiudad());
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener= listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null) {
            listener.onClick(view);
        }
    }
}
