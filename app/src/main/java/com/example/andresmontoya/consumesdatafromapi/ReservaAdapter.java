package com.example.andresmontoya.consumesdatafromapi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by andres.montoya on 26/09/2016.
 */

public class ReservaAdapter extends RecyclerView.Adapter<ReservaAdapter.ViewHolder>{

    private List<Reserva> items;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reservas_card, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.asiento.setText(items.get(position).getAsiento());
        holder.cliente.setText(items.get(position).getCliente());
        holder.vuelo.setText(items.get(position).getVuelo());
        holder.fecha.setText(items.get(position).getFecha());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView vuelo;
        public TextView cliente;
        public TextView asiento;
        public TextView fecha;

        public ViewHolder(View itemView) {
            super(itemView);
            vuelo = (TextView) itemView.findViewById(R.id.text01);
            cliente = (TextView) itemView.findViewById(R.id.text02);
            asiento = (TextView) itemView.findViewById(R.id.text03);
            fecha = (TextView) itemView.findViewById(R.id.text04);
        }
    }

    public ReservaAdapter(List<Reserva> items) {
        this.items = items;
    }


}
