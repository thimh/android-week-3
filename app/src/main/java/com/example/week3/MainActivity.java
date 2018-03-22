package com.example.week3;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends Activity implements OverviewFragment.OnItemSelectedListener {
    public OverviewFragment _overviewFragment;
    public DetailFragment _detailFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main);
            _overviewFragment = (OverviewFragment) getFragmentManager().findFragmentById(R.id.overviewFragment);
        } else {
            setContentView(R.layout.activity_main);
            _overviewFragment = new OverviewFragment();
            getFragmentManager().beginTransaction().add(R.id.portrait, _overviewFragment, "list").commit();
        }
    }

    @Override
    public void onItemSelected(Pokemon item) {

        _detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detailFragment);
        if (_detailFragment != null && _detailFragment.isInLayout())
        {
            _detailFragment.setPokemon(item);
        }
        else
        {
            _detailFragment = new DetailFragment();

            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().replace(R.id.portrait, _detailFragment, "detail").addToBackStack("detailTag").commit();

            fm.executePendingTransactions();
            _detailFragment.setPokemon(item);
        }
    }
}
