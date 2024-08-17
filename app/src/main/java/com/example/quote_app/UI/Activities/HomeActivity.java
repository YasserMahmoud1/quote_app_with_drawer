package com.example.quote_app.UI.Activities;
import com.example.quote_app.UI.Fragments.*;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.quote_app.Data.Models.QuoteModel;
import com.example.quote_app.Data.Repos.QuoteRepo;
import com.example.quote_app.R;
import com.example.quote_app.UI.Adapters.QuoteAdapter;
import com.google.android.material.navigation.NavigationView;

import java.util.List;
import java.util.Objects;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
//    List<QuoteModel> quotesList;
//    ListView listView;
    TextView text;
    Button btn;
    Toolbar toolBar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
//        quotesList = QuoteRepo.getQuotes();
//        listView = findViewById(R.id.homeListView);

        btn = findViewById(R.id.loginBtn);
        text = findViewById(R.id.homeText);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


//        QuoteAdapter aa = new QuoteAdapter(this,R.layout.quote_item,R.id.textItem, quotesList);
//        listView.setAdapter(aa);

//        listView.setOnItemClickListener((parent, view, position, id) -> {
//            QuoteModel selectedQuote = quotesList.get(position);
//            Intent intent = new Intent(HomeActivity.this, QuoteActivity.class);
//            intent.putExtra("quote", selectedQuote); // Assuming QuoteModel implements Serializable or Parcelable
//            startActivity(intent);
//        });
        String name = Objects.requireNonNull(getIntent().getExtras()).getString("UserName");
        if(!Objects.equals(name, "NotSET")){
            text.setVisibility(View.VISIBLE);
            text.setText(String.format("Welcome %s", name));
            btn.setVisibility(View.INVISIBLE);
        }else{
            text.setVisibility(View.INVISIBLE);
            btn.setVisibility(View.VISIBLE);
        }

        toolBar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolBar);


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolBar,R.string.open_navigation_drawer,R.string.close_navigation_drawer);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new QuotesFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_quote_list);
        }

    }
    public void goToLogin(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.nav_quote_list){
            Log.d("HomeActivity","done");
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new QuotesFragment()).commit();
        }else if(item.getItemId() == R.id.nav_movie_character){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new CharacterFragment()).commit();
        }else if(item.getItemId() == R.id.nav_movie_list){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new MoviesFragment()).commit();
        }else if(item.getItemId() == R.id.nav_favourites){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new FavouriteFragment()).commit();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            QuoteModel updatedQuote = (QuoteModel) data.getSerializableExtra("updatedQuote");
        }
    }
}