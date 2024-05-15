package com.example.spr15052024;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ArrayList<CharSequence> data = new ArrayList<>();
        Intent intent = new Intent(getBaseContext(), MainActivity2.class);
        ListView listView = findViewById(R.id.listView);
        TextView author = findViewById(R.id.authorName);
        TextView title = findViewById(R.id.bookTitle);
        Button addToList = findViewById(R.id.addBook);
        ArrayAdapter<CharSequence> adapterStart = new ArrayAdapter<CharSequence>(getBaseContext(), android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapterStart);
        addToList.setOnClickListener((View v) ->  {
            CharSequence readyData = "";
            CharSequence autrhorName = author.getText();
            CharSequence bookTitle = title.getText();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(autrhorName);
            stringBuilder.append(" ");
            stringBuilder.append(bookTitle);
            readyData = stringBuilder.toString();
            data.add(readyData);
            ArrayAdapter<CharSequence> adapterChanged = new ArrayAdapter<CharSequence>(getBaseContext(), android.R.layout.simple_list_item_1, data);
            listView.setAdapter(adapterChanged);
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CharSequence dataToSend =  data.get(position);
                intent.putExtra("data", dataToSend);
                setResult(Activity.RESULT_OK, intent);
                startActivity(intent);
            }
        });

    }
}