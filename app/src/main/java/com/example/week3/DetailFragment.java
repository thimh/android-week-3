package com.example.week3;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailFragment extends Fragment {
    public View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
//        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.detail_fragment, container, false);
        rootView = view;

        return view;
    }

    public void setPokemon(Pokemon pokemon) {
        TextView textView = getView().findViewById(R.id.detailText);
        ImageView imageView = getView().findViewById(R.id.detailImage);
        textView.setText(pokemon.name);
        imageView.setImageResource(pokemon.image/*getResources().getIdentifier(pokemonName, "drawable", "com.example.week3")*/);
    }
}
