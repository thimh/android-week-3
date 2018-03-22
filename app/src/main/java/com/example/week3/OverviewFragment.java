package com.example.week3;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class OverviewFragment extends Fragment {
    private OnItemSelectedListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.overview_fragment, container, false);
        final PokemonAdapter adapter = new PokemonAdapter(getActivity(), R.layout.pokemon_item);

        adapter.add(new Pokemon(R.drawable.bulbasaur, "Bulbasaur"));
        adapter.add(new Pokemon(R.drawable.dragonite, "Dragonite"));
        adapter.add(new Pokemon(R.drawable.pikachu, "Pikachu"));

        ListView listView = view.findViewById(R.id.list_view);
        listView.setAdapter(adapter);



        AdapterView.OnItemClickListener mPokemonClickedHandler = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
//                ((MainActivity)getActivity()).onItemSelected(adapter.getItem(position).name);
                listener.onItemSelected(adapter.getItem(position));
            }
        };
        listView.setOnItemClickListener(mPokemonClickedHandler);

        return view;
    }

    public interface OnItemSelectedListener {
        void onItemSelected(Pokemon pokemon);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getActivity() instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) getActivity();
        }
    }
}
