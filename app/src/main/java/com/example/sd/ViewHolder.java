package com.example.sd;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView textView;

    public ViewHolder(@NonNull View itemView) {
        super( itemView );
        textView = itemView.findViewById( R.id.result_text );
    }

    void onBind(String s){
        textView.setText( s );
    }
}
