package com.example.quote_app.UI.Activities;
import com.example.quote_app.Data.Models.QuoteModel;
import com.example.quote_app.Data.Repos.QuoteRepo;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.quote_app.R;

public class QuoteActivity extends AppCompatActivity {
    TextView quote;
    TextView movie;
    TextView year;
    TextView character;
    ImageView imageView;
    boolean isFavourite;
    Button favouriteBtn;
    QuoteModel quoteModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.quote_detailed);

        Intent intent = getIntent();
        quoteModel = (QuoteModel) intent.getSerializableExtra("quote");

        quote = findViewById(R.id.detailsQuote);
        movie = findViewById(R.id.detailsMovie);
        year = findViewById(R.id.detailsYear);
        character = findViewById(R.id.detailsCharacter);
        imageView = findViewById(R.id.detailsImage);
        favouriteBtn = findViewById(R.id.detailsButton);

        assert quoteModel != null;
        isFavourite = quoteModel.isFavourite();

        // Set initial UI values
        quote.setText(quoteModel.getQuote());
        movie.setText(quoteModel.getMovieName());
        year.setText(quoteModel.getMovieYear());
        character.setText(quoteModel.getCharacterName());
        imageView.setImageResource(quoteModel.getMoviePhoto());

        // Update UI for the favourite button
        updateFavouriteUI(quoteModel);
        QuoteRepo.updateQuote(quoteModel, isFavourite);

        // Set OnClickListener to toggle favourite state
        favouriteBtn.setOnClickListener(view -> {
            isFavourite = !isFavourite;
            quoteModel.setFavourite(isFavourite);
            QuoteRepo.updateQuote(quoteModel, isFavourite);
            updateFavouriteUI(quoteModel);
        });
    }


    // Method to update UI based on favourite state
    private void updateFavouriteUI(QuoteModel quoteModel) {
        if (isFavourite) {
            favouriteBtn.setText("Remove from Favourites");
            favouriteBtn.setTextColor(getResources().getColor(R.color.black));
            favouriteBtn.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey)));
        } else {
            favouriteBtn.setText("Add to Favourites");
            favouriteBtn.setTextColor(getResources().getColor(R.color.white));
            favouriteBtn.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
        }
    }

    @Override
    public void onBackPressed() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("updatedQuote", quoteModel);
        setResult(RESULT_OK, resultIntent);
        super.onBackPressed();
    }
}