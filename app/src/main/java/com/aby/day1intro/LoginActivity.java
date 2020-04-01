package com.aby.day1intro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText edtName;
    private EditText edtPassword;
    private TextView txtMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMsg = findViewById(R.id.txtMessage);
        edtName = findViewById(R.id.edtName);
        edtPassword = findViewById(R.id.edtPassword);
        Button btnSubmit = findViewById(R.id.btnLogin);
        AlertDialog.Builder builder;
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
                    //edtName.setBackgroundColor(getResources().getColor(R.color.errorColor));
                    Intent mIntent = new Intent(LoginActivity.this, InfoActivity.class);
                    startActivity(mIntent);
                }
                else {
                    
                    txtMsg.setText(R.string.username_password);
                    txtMsg.setTextColor(getResources().getColor(R.color.errorColor));
                    //edtName.setBackgroundColor(getResources().getColor(R.color.errorColor));

                }

            }
        });
    }
}
