package com.example.week3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PokemonAdapter extends ArrayAdapter<Pokemon> {

    public PokemonAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.pokemon_item, parent, false);
        }

        Pokemon pokemon = getItem(position);

        ImageView imageView = convertView.findViewById(R.id.imageView);
        imageView.setImageResource(pokemon.image);

        TextView textView = convertView.findViewById(R.id.textView);
        textView.setText(pokemon.name);

        return convertView;
    }
}
