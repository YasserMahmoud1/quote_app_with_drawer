package com.example.quote_app.UI.Adapters;
import com.example.quote_app.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.example.quote_app.Data.Models.QuoteModel;
import com.example.quote_app.Data.Repos.QuoteRepo;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class QuoteAdapter extends ArrayAdapter<QuoteModel> {
    private String type;
    List<QuoteModel> quotes ;
    public QuoteAdapter(Context context, int resource, int textViewResourceID, List<QuoteModel> list, String type){
        super(context, resource, textViewResourceID, list);
        quotes = QuoteRepo.getQuotes();
        this.type = type;
    }

    @Override
    public int getCount(){
        return super.getCount();
    }

    @NonNull
    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent){
        View view;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.quote_item,null);
        TextView textView = view.findViewById(R.id.textItem);
        ImageView imageView = view.findViewById(R.id.imageItem);
        switch (type){
            case "movies":
                textView.setText(quotes.get(position).getMovieName());
                break;
            case "characters":
                textView.setText(quotes.get(position).getCharacterName());
                break;
            case "quotes":
                textView.setText(quotes.get(position).getQuote());
                break;
            default:
                textView.setText(quotes.get(position).getQuote());
                break;


        }
        imageView.setImageResource(quotes.get(position).getMoviePhoto());
        return view;
    }


}
