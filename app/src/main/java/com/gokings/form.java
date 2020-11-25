package com.gokings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.gokings.Activity.MapsActivity;
import com.kaopiz.kprogresshud.KProgressHUD;

import soup.neumorphism.NeumorphButton;
import soup.neumorphism.NeumorphTextView;

public class form extends AppCompatActivity {

    NeumorphButton button;

    KProgressHUD pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        util.blackiteamstatusbar(form.this,R.color.light_background);



        //anyeca = findViewById(R.id.anyeca);

        button = (NeumorphButton) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginByServer();
                showpDialog();
                Intent in=new Intent(form.this,MapsActivity.class);
                startActivity(in);
                hidepDialog();

            }
        });


      /*  anyeca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time.setVisibility(View.VISIBLE);
                on.setVisibility(View.VISIBLE);
            }
        });*/



    }
    public void openActivity_create(){

        Intent intent = new Intent(this, create.class);
        startActivity(intent);
    }
    private void loginByServer() {
        pDialog = KProgressHUD.create(this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("Please wait.....")
                .setCancellable(false)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f)
                .show();
    }

    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}