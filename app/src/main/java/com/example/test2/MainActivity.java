package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static int LED_WHITE = 225;
    static int LED_RED = 12;
    static int LED_GREEN = 13;
    EditText pintext;
    EditText valuetext;
    TextView outputtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        pintext = findViewById(R.id.edit_pin);
        valuetext = findViewById(R.id.edit_value);
        outputtext = findViewById(R.id.tv_out);
      //  CommandExec.setPIN(LED_WHITE,0);
       // CommandExec.getPIN(LED_WHITE);

    }
    public void notification(String msg){
        Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }
    public void readClick(View view) {
        try{
            String value;
            Log.d("PIIN", pintext.getText().toString());
            value = CommandExec.getPIN(Integer.parseInt(pintext.getText().toString()));
            if (value != "") {
                outputtext.setText(value);
            }else{
                notification("Okuma Hatası");
            }

        } catch (Exception e) {
            notification("Pini Kontrol Et");
        }

    }

    public void writeClick(View view) {
        try{
            boolean res;
            int value =Integer.parseInt(valuetext.getText().toString());
            if (value >=0 && value<=1) {
                res = CommandExec.setPIN(Integer.parseInt(pintext.getText().toString()), Integer.parseInt(valuetext.getText().toString()));
                if (res != false) {
                    notification("Başarılı");
                } else {
                    notification("Yazma Hatası");
                }
            }else{
                notification("Yalnız 1 veya 0");
            }

        } catch (Exception e) {
            notification("Pini Kontrol Et");
        }

    }


   /* @Override
   protected void onDestroy() {
        super.onDestroy();
        releaseLed(); // Restore led read and write permissions
    }

    private void execLed() {
        CommandExec.execRedLed(LED_WHITE);
        CommandExec.execRedLed(LED_RED);
        CommandExec.execRedLed(LED_GREEN);
    }

    private void releaseLed() {

        CommandExec.releaseLed(LED_RED);
        CommandExec.releaseLed(LED_GREEN);
    }*/



}