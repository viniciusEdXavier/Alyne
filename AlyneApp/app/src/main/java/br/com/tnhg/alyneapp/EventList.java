package br.com.tnhg.alyneapp;

import java.util.ArrayList;
import java.util.List;

public class EventList {
        public static List<Event> geraLista(){
                List<Event> lista = new ArrayList<>();
                lista.add(new Event(1, "Fazer vários nada", "lugar nenhum", "hoje"));
                lista.add(new Event(2, "Ir lá", "naquele lugar", "20191316"));
                lista.add(new Event(3, "mano e se", "nao hovesse nada", "no meio de tudo?"));
                return lista;
        }
}
