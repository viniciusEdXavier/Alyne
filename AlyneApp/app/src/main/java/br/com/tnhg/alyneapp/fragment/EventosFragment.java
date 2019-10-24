package br.com.tnhg.alyneapp.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import br.com.tnhg.alyneapp.retrofit.EndpointInterface;
import br.com.tnhg.alyneapp.EventAdapter;
import br.com.tnhg.alyneapp.R;
import br.com.tnhg.alyneapp.retrofit.RetrofitClass;
import br.com.tnhg.alyneapp.wsentity.Event;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventosFragment extends Fragment {
    List<Event> eventList = new ArrayList<>();
    ListView eventListView;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.event_data_layout, container, false);

        SharedPreferences sp = getActivity().getPreferences(Context.MODE_PRIVATE);
        String header = "Bearer "+getActivity().getIntent().getStringExtra("token");
        Log.d("tag", header);
        EndpointInterface api = RetrofitClass.retrofit.create(EndpointInterface.class);

        api.getAllEventos(header).enqueue(new Callback<Event[]>() {
            @Override
            public void onResponse(Call<Event[]> call, Response<Event[]> response) {
                eventListView = root.findViewById(R.id.list_view_eventos);

                Log.d("tog", eventList.toString());
                for (int i = 0; i<response.body().length;i++)
                {
                    if(response.body()[i]!=null)
                       eventList.add(response.body()[i]);
                }
                Log.d("tog", eventList.toString());
                EventAdapter eventAdapter = new EventAdapter(eventList, getActivity());

                eventListView.setAdapter(eventAdapter);
            }

            @Override
            public void onFailure(Call<Event[]> call, Throwable t) {
                Log.d("tag", t.getMessage());
            }
        });

        return root;
    }

}
