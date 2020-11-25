package com.gokings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gokings.Activity.Terms_Service;
import com.kaopiz.kprogresshud.KProgressHUD;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import soup.neumorphism.NeumorphButton;


public class ContactNumberActivity extends AppCompatActivity {
    private  NeumorphButton button;
    private EditText number;
    private CheckBox  checkbox;
    KProgressHUD pDialog;
TextView terms;

    protected SwipeRefreshLayout swipeView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_number);
        util.blackiteamstatusbar(ContactNumberActivity.this,R.color.light_background);

        initview();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               openActivity_o_t_p_screen();

            }
        });
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginByServer();
                showpDialog();

                startActivity(new Intent(ContactNumberActivity.this, Terms_Service.class));
             //   hidepDialog();

            }
        });
        
    }
    public   void initview()
    {
        button = (NeumorphButton) findViewById(R.id.button);
        number=findViewById(R.id.number);
        checkbox=findViewById(R.id.checkbox);
        terms=findViewById(R.id.terms);



    }
    public void openActivity_o_t_p_screen() {
       // Toast.makeText(this, "hey", Toast.LENGTH_SHORT).show();
       // util.showtoast(ContactNumberActivity.this,"please check Number");
        number_validation();


    }

    public void privacyPolicyClick(View view) {
        loginByServer();
        showpDialog();

        startActivity(new Intent(ContactNumberActivity.this, PrivacyPolicyActivity.class));
       // hidepDialog();

    }

    public void number_validation() {
        loginByServer();
        showpDialog();


        //  Toast.makeText(context, Devicetoken+"", Toast.LENGTH_SHORT).show();
      //  swipeView.setRefreshing(true);
        final String mobile= number.getText().toString().trim();
     //   final String passwordHolder = Password.getText().toString().trim();


        if (TextUtils.isEmpty(mobile)) {
            number.setError("Please enter Mobile Number");
            number.requestFocus();
            util.showtoast(ContactNumberActivity.this,"Please enter Mobile Number");

            hidepDialog();
        }else if(!checkbox.isChecked()){
            checkbox.setError("Please checked it");
            util.showtoast(ContactNumberActivity.this,"Please checked it");

            checkbox.requestFocus();
            hidepDialog();
        }
        else {



            Intent intent = new Intent(ContactNumberActivity.this, OTPScreen.class);
            startActivity(intent);
            hidepDialog();

        }


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


    @Override
    protected void onResume() {
        super.onResume();
        //check Internet Connection
        new CheckInternetConnection(this).checkConnection();
    }
}