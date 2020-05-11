package com.example.testartimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements CustomDialogTestarTimePicker.CustomDialogTestarTimePickerListener{

    private Button buttonOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    @Override
    public void applyReturnTimePicker(String horaMinuto) {
        CustomDialogMensagem customDialogMensagem = new CustomDialogMensagem(MainActivity.this, horaMinuto);
        customDialogMensagem.show();
    }

    class OnClickButtonOk implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            CustomDialogTestarTimePicker customDialogTestarTimePicker = new CustomDialogTestarTimePicker(MainActivity.this);
            customDialogTestarTimePicker.show();
        }

    }

    private void init(){
        buttonOk = (Button)findViewById(R.id.buttonOk);

        buttonOk.setOnClickListener(new OnClickButtonOk());
    }
}
