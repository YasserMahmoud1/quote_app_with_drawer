package com.example.quote_app.UI.Activities;
import com.example.quote_app.Data.Repos.QuoteRepo;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.quote_app.R;

public class MainActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        QuoteRepo.setQuotes();
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btn =  findViewById(R.id.homeBtn);
    }
    public void goToHome(View view){
        Intent intent;
        intent = new Intent(this, HomeActivity.class);
        intent.putExtra("UserName", "NotSET");
        startActivity(intent);
    }


}