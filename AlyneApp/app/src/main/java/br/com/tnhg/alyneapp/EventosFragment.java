package br.com.tnhg.alyneapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.List;

public class EventosFragment extends Fragment {
    List<Event> eventList;
    ListView eventListView;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.event_data_layout, container, false);
        eventList = EventList.geraLista();
        eventListView = root.findViewById(R.id.list_view_eventos);
        EventAdapter eventAdapter = new EventAdapter(eventList, getActivity());

        eventListView.setAdapter(eventAdapter);
        return root;
    }
}
