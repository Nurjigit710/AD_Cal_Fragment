package com.example.sd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.sd.fragment.IonClickButton;

public class MainActivity extends AppCompatActivity implements IonClickButton {


    private TextView resultField, operationField;
    private EditText numberField;
    private Double operand = null;
    private String lastOperation = "",
            OPERATION = "operation",
            OPERAND = "operand";
    Button save, clear;
    static String INPUT_KEY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        onBindByID();

        onClickLister();

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.editFragment);
        assert fragment != null;
        resultField = fragment.getView().findViewById(R.id.resultField);

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState( outState );
        outState.putString( OPERATION, lastOperation );
        if (operand != null) {
            outState.putDouble( OPERAND, operand );
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState( savedInstanceState );
        lastOperation = savedInstanceState.getString( OPERATION );
        operand = savedInstanceState.getDouble( OPERAND );
        resultField.setText( operand.toString() );
        operationField.setText( lastOperation );
    }


    @Override
    public void onNumbers(View view) {

        Button button = (Button) view;
        numberField.append( button.getText() );

        if (lastOperation.equals( "=" ) && operand != null) {
            operand = null;
        }
    }

    @Override
    public void onOperation(View view) {

        Button button = (Button) view;
        String op = button.getText().toString();
        String number = numberField.getText().toString();
        if (number.length() > 0) {
            number = number.replace( ',', '.' );
            try {
                performOperation( Double.valueOf( number ), op );
            } catch (NumberFormatException ex) {
                numberField.setText( "" );
            }
        }
        lastOperation = op;
        operationField.setText( lastOperation );
    }


    private void performOperation(Double number, String operation) {

        if (operand == null) {
            operand = number;
        } else {
            if (lastOperation.equals( "=" )) {
                lastOperation = operation;
            }
            switch (lastOperation) {
                case "=":
                    operand = number;
                    break;
                case "/":
                    if (number == 0) {
                        operand = 0.0;
                    } else {
                        operand /= number;
                    }
                    break;
                case "*":
                    operand *= number;
                    break;
                case "+":
                    operand += number;
                    break;
                case "-":
                    operand -= number;
                    break;
            }
        }
        resultField.setText( operand.toString().replace( '.', ',' ) );
        numberField.setText( "" );

    }

    private void onBindByID() {
        resultField = findViewById( R.id.resultField );
        numberField = findViewById( R.id.numberField );
        operationField = findViewById( R.id.operationField );
        save = findViewById( R.id.save );
        clear = findViewById( R.id.clear );

    }

    private void onClickLister() {
        clear.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberField.setText( null );
                resultField.setText( null );
                operationField.setText( null );
            }
        } );


        save.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra( INPUT_KEY, operand );
                setResult( RESULT_OK, intent );
                finish();

            }
        } );
    }
}