package com.example.sd.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sd.R;


public class NumberFragment extends Fragment {
    IonClickButton clickButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        clickButton = (IonClickButton) getActivity();
        View view = inflater.inflate( R.layout.fragment_number, container, false );
        onClickNumbersTheOperation( view );
        return view;
    }

    private void onClickNumbersTheOperation(View v) {
        v.findViewById( R.id.btn_0 ).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton.onNumbers( v );
            }
        } );
        v.findViewById( R.id.btn_1 ).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton.onNumbers( v );
            }
        } );
        v.findViewById( R.id.btn_2 ).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton.onNumbers( v );
            }
        } );
        v.findViewById( R.id.btn_3 ).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton.onNumbers( v );
            }
        } );
        v.findViewById( R.id.btn_4 ).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton.onNumbers( v );
            }
        } );
        v.findViewById( R.id.btn_5 ).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton.onNumbers( v );
            }
        } );
        v.findViewById( R.id.btn_6 ).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton.onNumbers( v );
            }
        } );
        v.findViewById( R.id.btn_7 ).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton.onNumbers( v );
            }
        } );
        v.findViewById( R.id.btn_8 ).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton.onNumbers( v );
            }
        } );
        v.findViewById( R.id.btn_9 ).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton.onNumbers( v );
            }
        } );
        v.findViewById( R.id.btn_um ).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton.onOperation( v );
            }
        } );
        v.findViewById( R.id.btn_delit ).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton.onOperation( v );
            }
        } );
        v.findViewById( R.id.btn_pl ).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton.onOperation( v );
            }
        } );
        v.findViewById( R.id.btn_mi ).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton.onOperation( v );
            }
        } );
        v.findViewById( R.id.btn_ra ).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton.onOperation( v );
            }
        } );
        v.findViewById( R.id.btn_to ).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton.onOperation( v );
            }
        } );

    }

}
