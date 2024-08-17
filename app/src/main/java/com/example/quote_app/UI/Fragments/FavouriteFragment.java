package com.example.quote_app.UI.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import com.example.quote_app.Data.Models.QuoteModel;
import com.example.quote_app.Data.Repos.QuoteRepo;
import com.example.quote_app.UI.Activities.*;
import com.example.quote_app.UI.Adapters.QuoteAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.quote_app.R;

import java.util.List;

public class FavouriteFragment extends Fragment {
    ListView quotesListView;
    TextView favText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourite, container, false);
        favText = view.findViewById(R.id.fav_text_id);

        quotesListView = view.findViewById(R.id.quotes_list);
        List<QuoteModel> quotesList = QuoteRepo.getFavouriteQuotes();
        if(quotesList.isEmpty()){
            favText.setVisibility(View.VISIBLE);
        }else{
            favText.setVisibility(View.INVISIBLE);
        }
        QuoteAdapter aa = new QuoteAdapter(getContext(),R.layout.quote_item,R.id.textItem, quotesList,"quotes");
        quotesListView.setAdapter(aa);

        return view;
    }
}