package com.id20048076.democontextmenutranslation2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvHello;
    TextView tvBye;
    String textClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHello = findViewById(R.id.textViewTranslatedText);
        tvBye = findViewById(R.id.textViewTranslatedText2);

        registerForContextMenu(tvHello);
        registerForContextMenu(tvBye);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v==tvHello){
            textClicked = "hello";
        }else if(v==tvBye){
            textClicked = "bye";
        }
        getMenuInflater().inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(textClicked.equalsIgnoreCase("hello")){

            if(id==R.id.EnglishSelection){
                tvHello.setText("Hello");
            }else if(id==R.id.italianSelection){
                tvHello.setText("Ciao");
            }
        }else if(textClicked.equalsIgnoreCase("bye")){
            if(id==R.id.EnglishSelection){
                tvBye.setText("Bye");
            }else if(id==R.id.italianSelection){
                tvBye.setText("Addios");
            }
        }

        return super.onContextItemSelected(item);
    }

}