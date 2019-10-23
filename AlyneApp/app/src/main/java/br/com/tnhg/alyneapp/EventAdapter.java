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
        String dia = event.getDate()==null? "??": event.getDate().split("/")[2];
        calendario.setText(dia);
        String mes = event.getDate()==null? "": event.getDate().split("/")[1];
        switch (mes)
        {
            case "01":
                calendario.setBackgroundResource(R.drawable.mes1);
                break;
            case "02":
                calendario.setBackgroundResource(R.drawable.mes2);
                break;
            case "03":
                calendario.setBackgroundResource(R.drawable.mes3);
                break;
            case "04":
                calendario.setBackgroundResource(R.drawable.mes4);
                break;
            case "05":
                calendario.setBackgroundResource(R.drawable.mes5);
                break;
            case "06":
                calendario.setBackgroundResource(R.drawable.mes6);
                break;
            case "07":
                calendario.setBackgroundResource(R.drawable.mes7);
                break;
            case "08":
                calendario.setBackgroundResource(R.drawable.mes8);
                break;
            case "09":
                calendario.setBackgroundResource(R.drawable.mes9);
                break;
            case "10":
                calendario.setBackgroundResource(R.drawable.mes10);
                break;
            case "11":
                calendario.setBackgroundResource(R.drawable.mes11);
                break;
            case "12":
                calendario.setBackgroundResource(R.drawable.mes12);
                break;
            default:
                calendario.setBackgroundResource(R.drawable.mes0);
                break;
        }
        name.setText(event.getName());
        local.setText(event.getLocation());
        return v;
    }
}
