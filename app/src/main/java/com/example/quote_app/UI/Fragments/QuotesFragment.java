package com.example.quote_app.UI.Fragments;

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

import com.example.quote_app.R;

import java.util.List;

public class QuotesFragment extends Fragment {
    ListView quotesListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quotes, container, false);

        quotesListView = view.findViewById(R.id.quotes_list);

        List<QuoteModel> quotesList = QuoteRepo.getQuotes();
        QuoteAdapter aa = new QuoteAdapter(getContext(),R.layout.quote_item,R.id.textItem, quotesList,"quotes");
        quotesListView.setAdapter(aa);
        quotesListView.setOnItemClickListener((parent, aview, position, id) -> {
            QuoteModel selectedQuote = quotesList.get(position);
            Intent intent = new Intent(getContext(), QuoteActivity.class);
            intent.putExtra("quote", selectedQuote); // Assuming QuoteModel implements Serializable or Parcelable
            startActivity(intent);
        });
        return view;
    }
}