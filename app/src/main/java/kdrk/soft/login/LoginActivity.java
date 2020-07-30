package kdrk.soft.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {

    private EditText etName, etEmail, etPassword, etRpassword;
    private Button btOk, btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

    }

    public void init() {
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etRpassword = findViewById(R.id.etRpassword);

    }


    public void onClickOk(View view) {
        if(!etPassword.getText().toString().equals("") && etPassword.getText().toString().equals(etRpassword.getText().toString())) {
            Intent i = new Intent(LoginActivity.this, ProfileActivity.class);
            i.putExtra("etName", etName.getText().toString());
           // i.putExtra("etEmail", etEmail.getText().toString());
           // i.putExtra("etPassword", etPassword.getText().toString());
            startActivity(i);

        }

    }

    public void onClickBack(View view) {


        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(i);

    }


}
