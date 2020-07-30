package kdrk.soft.login;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends Activity {

    private TextView tvName, tvEmail, tvPassword;
    String a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        init();
        a = getIntent().getStringExtra("etName");
        tvName.setText(a);
        //tvName.setText(getIntent().getStringExtra("etName"));
        //tvEmail.setText(getIntent().getStringExtra("etEmail"));
       // tvName.setText(getIntent().getStringExtra("etPassword"));

    }

    public void init () {
        tvName = findViewById(R.id.etName);
        tvEmail = findViewById(R.id.etEmail);
        tvPassword = findViewById(R.id.etPassword);
    }


}
