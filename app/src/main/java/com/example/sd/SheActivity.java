package com.example.sd;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class SheActivity extends AppCompatActivity {
    private static final int MAIN_ACTIVITY1 = 1;
    ArrayList<String> list = new ArrayList<>();
    MainAdapter adapter = new MainAdapter( list );
    RecyclerView recyclerView;
    Button button, cal;
    String result;
    double result_Numbers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_she );
        button = findViewById( R.id.share );
        cal = findViewById( R.id.cal );

        recyclerView = findViewById( R.id.recycler );
        recyclerView.setAdapter( adapter );

        onClickShare();


    }

    private void onClickShare() {
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction( Intent.ACTION_SEND );
                intent.putExtra( Intent.EXTRA_TEXT, "Result: "+ result_Numbers);
                intent.setType( "numbers/plain" );

                if (intent.resolveActivity( getPackageManager() ) != null) {
                    startActivity( intent );
                }
            }
        } );

        cal.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( SheActivity.this, MainActivity.class );
                startActivityForResult( intent, MAIN_ACTIVITY1 );
            }
        } );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
        if (requestCode == MAIN_ACTIVITY1 && resultCode == RESULT_OK) {
            assert data != null;
            result_Numbers = data.getDoubleExtra( MainActivity.INPUT_KEY ,0);
            list.add( "Res: " + result_Numbers );
            adapter.notifyDataSetChanged();
        }
    }
}
