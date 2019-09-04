package com.program.codemobile.itunesapplication.ui.home;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.program.codemobile.itunesapplication.R;
import com.program.codemobile.itunesapplication.adapters.RecyclerAdapter;
import com.program.codemobile.itunesapplication.models.Results;
import com.program.codemobile.itunesapplication.models.SearchResult;

import java.util.Arrays;

public class HomeFragment extends Fragment {

    private static final String TAG ="HomeFragment";
    private HomeViewModel homeViewModel;
    private ProgressBar showProgress;
    private CardView showMsg;
    private TextView showWelcome;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        showProgress=(ProgressBar) root.findViewById(R.id.showProgress);
        showWelcome=(TextView) root.findViewById(R.id.showWelcome);
        showMsg= (CardView) root.findViewById(R.id.showMsg);
        showProgress.setVisibility(View.INVISIBLE);
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });

        setHasOptionsMenu(true);
        return root;
    }

    public void fetchList(String term, String mediaType, String limit) {
        homeViewModel.getSearchResult(term,mediaType,limit).observe(this, new Observer<SearchResult>() {
            @Override
            public void onChanged(SearchResult searchResult) {
                Log.i(TAG,"searchResult: " + searchResult);
                recyclerAdapter = new RecyclerAdapter(getContext(), Arrays.asList(searchResult.getResults()));
                recyclerAdapter.notifyDataSetChanged();
                recyclerView.setAdapter(recyclerAdapter);
                recyclerView.removeAllViews();
                showProgress.setVisibility(View.INVISIBLE);
                recyclerAdapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Results results) {
                        homeViewModel.insert(results);
                        Toast.makeText(getContext(), "Se agrego a la lista de favoritos", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu, menu);
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                showProgress.setVisibility(View.VISIBLE);
                fetchList(query,"music","20");
                showMsg.setVisibility(View.INVISIBLE);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                //Log.i(TAG,"Ejecutando onQueryTextChange::: " + newText);
                //fetchList(newText,"music","2");
                return false;
            }
        });
    }
}