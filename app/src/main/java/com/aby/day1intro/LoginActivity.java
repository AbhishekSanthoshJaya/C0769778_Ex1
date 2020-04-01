package com.aby.day1intro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText edtName;
    private EditText edtPassword;
    private TextView txtMsg;
    private Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMsg = findViewById(R.id.txtMessage);
        edtName = findViewById(R.id.edtName);
        edtPassword = findViewById(R.id.edtPassword);
        Button btnSubmit = findViewById(R.id.btnLogin);
        aSwitch = findViewById(R.id.switch2);

        final AlertDialog.Builder builder;
        switchSettings();

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                if(b)
                {
                    Toast.makeText(LoginActivity.this, "RememberMe has been turned ON", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "RememberMe has been turned OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder = new AlertDialog.Builder(this);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String password = edtPassword.getText().toString();
                if(name.equals("admin@123") && password.equals("s3cr3t")){
                    txtMsg.setText(R.string.welcome);
                    txtMsg.setTextColor(getResources().getColor(R.color.rightColor));
                    Intent mIntent = new Intent(LoginActivity.this, InfoActivity.class);
                    mIntent.putExtra("Name", "Abhishek S J");
                    startActivity(mIntent);
                }
                else {
                    builder.setMessage("UserID/Password Invalid");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                }

            }
        });
    }
    private void switchSettings(){
        aSwitch.setTextOn("ON");
        aSwitch.setTextOff("OFF");
        aSwitch.setTextColor(getResources().getColor(R.color.errorColor));
    }
}
