package com.example.quote_app.Data.Repos;
import com.example.quote_app.Data.Models.QuoteModel;
import com.example.quote_app.R;
import java.util.ArrayList;
import java.util.List;

public class QuoteRepo {
    private static  List<QuoteModel> quotesList = new ArrayList<>();
    public static void setQuotes() {
        quotesList.add(new QuoteModel(
                "To infinity and beyond!",
                "Toy Story",
                "1995",
                R.drawable.buzz,
                "Buzz Lightyear"
        ));
        quotesList.add(new QuoteModel(
                "Ohana means family. Family means nobody gets left behind or forgotten",
                "Lilo & Stitch",
                "2002",
                R.drawable.stitch,
                "Stutch"
        ));
        quotesList.add(new QuoteModel(
                "Just keep swimming",
                "Finding Nemo",
                "2003",
                R.drawable.dory,
                "Dory"
        ));
        quotesList.add(new QuoteModel(
                "Yo, rugman! Haven't seen you in a few millennia. Give me some tassel",
                "Aladdin",
                "1993",
                R.drawable.genie,
                "Genie"
        ));
        quotesList.add(new QuoteModel(
                "The past should not be feared for it guides our future",
                "Moana",
                "2016",
                R.drawable.moana,
                "Moana"
        ));quotesList.add(new QuoteModel(
                "Hakuna Matata! It means no worries",
                "Lion King",
                "1994",
                R.drawable.timon,
                "Timon and Pumba"
        ));
        quotesList.add(new QuoteModel(
                "Some people are worth melting for",
                "Frozen",
                "2013",
                R.drawable.olaf,
                "Olaf"
        ));
        quotesList.add(new QuoteModel(
                "The only thing that matters is what you choose to be now",
                "Kung Fu Panda",
                "2008",
                R.drawable.po,
                "Po"
        ));
        quotesList.add(new QuoteModel(
                "Well, there’s one thing: they can’t order me to stop dreaming",
                "Cinderella",
                "1950",
                R.drawable.cindrella,
                "Cinderella"
        ));
        quotesList.add(new QuoteModel(
                "I don’t want to survive. I want to live",
                "Wall-E",
                "2008",
                R.drawable.wall_e,
                "Wall-E"
        ));
    }

    public static List<QuoteModel> getQuotes() {
        return quotesList;
    }

    public static void updateQuote(QuoteModel quote, boolean isFavourite) {
        for (QuoteModel q : quotesList) {
            if (q.getQuote().equals(quote.getQuote())) {
                q.setFavourite(isFavourite);
            }
        }
    }

    public static List<QuoteModel> getFavouriteQuotes() {
        List<QuoteModel> favQuotes = new ArrayList<>();
        quotesList.forEach(quote -> {
            if (quote.isFavourite()) {
                favQuotes.add(quote);
            }
        });
        return favQuotes;
    }
}
