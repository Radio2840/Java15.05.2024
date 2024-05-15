package com.example.spr15052024;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle myData = getIntent().getExtras();
        TextView authorTitle = findViewById(R.id.titleAuthor);
        ImageView image = findViewById(R.id.imageView);
        int[] fotos = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5,R.drawable.a6, R.drawable.a7};
        Random randomizer = new Random();
        int randomInt = randomizer.nextInt(8);
        if(myData != null) {
            authorTitle.setText(myData.getCharSequence("data"));
            image.setImageResource(fotos[randomInt]);
        }

    }
}