package com.example.testartimepicker;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatDialogFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CustomDialogTestarTimePicker extends Dialog implements View.OnClickListener {
    private Activity activity;
    private Button buttonOk;
    private TimePicker timePicker;
    private CustomDialogTestarTimePickerListener listener;

    public interface CustomDialogTestarTimePickerListener {
        void applyReturnTimePicker(String horaMinuto);
    }

    public CustomDialogTestarTimePicker(Activity activity) {
        super(activity);
        this.activity = activity;
        this.setCanceledOnTouchOutside(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custon_dialog_testar_time_picker);

        init();
    }

    private void init(){
        buttonOk = (Button)findViewById(R.id.buttonOk);
        buttonOk.setOnClickListener(this);
        timePicker = (TimePicker)findViewById(R.id.timePickerTempo);

        timePicker.setIs24HourView(true);
        timePicker.setHour(0);
        timePicker.setMinute(0);

        listener = (CustomDialogTestarTimePickerListener) activity;
    }

    @Override
    public void onClick(View v) {
        String horaMinuto = calcularHoraMinuto();

        listener.applyReturnTimePicker(horaMinuto);

        dismiss();
    }

    private String calcularHoraMinuto(){
        int hora, minuto;
        Calendar calendar = Calendar.getInstance();
        String horaMinuto;

        calendar.setTime(new Date(System.currentTimeMillis()));

        hora = timePicker.getHour();
        minuto = timePicker.getMinute();

        calendar.set(Calendar.HOUR_OF_DAY,hora);
        calendar.set(Calendar.MINUTE,minuto);

        horaMinuto = new SimpleDateFormat("HH:mm").format(calendar.getTime());

        return horaMinuto;
    }

}
