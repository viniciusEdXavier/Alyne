package br.com.tnhg.alyneapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class EventAdapter extends BaseAdapter {
    List<Event> lista;
    Context context;

    public EventAdapter(List<Event> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    public EventAdapter() {
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        Event event = this.lista.get(i);

        View v = layoutInflater.inflate(R.layout.listview_eventos, null);
        Button calendario = v.findViewById(R.id.image);
        TextView name = v.findViewById(R.id.name);
        TextView local = v.findViewById(R.id.local);
        TextView date = v.findViewById(R.id.date);
        TextView time = v.findViewById(R.id.time);
        calendario.setText("Baluba");
        name.setText(event.getName());
        local.setText(event.getLocation());
        date.setText(event.getDate().split("/T/g")[0]);
        time.setText(event.getDate().split("/T/g")[0]);
        return v;
    }
}
