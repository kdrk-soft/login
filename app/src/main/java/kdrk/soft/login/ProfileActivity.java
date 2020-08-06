package kdrk.soft.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static kdrk.soft.login.MainActivity.isLogin;

public class ProfileActivity extends Activity {

    private TextView tvName, tvEmail, tvPassword;
    private TextView tvResult;
    public int counter = 0;

    private TextView tvNumber;
    private EditText etPassword;
    private ArrayList<String> arrayPassword = new ArrayList<>();
    private Button btList;
    private Boolean aBoolean = false;
    private Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent i = new Intent(ProfileActivity.this, MainActivity.class);
       isLogin = true;
        // i.putExtra("exit1", true);
        init();

        tvName.setText(getIntent().getStringExtra("etName"));
        tvEmail.setText(getIntent().getStringExtra("etEmail"));
        tvPassword.setText(getIntent().getStringExtra("etPassword"));

    }

    public void init () {
        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvPassword = findViewById(R.id.tvPassword);

        tvResult = findViewById(R.id.tvResult);

        tvNumber = findViewById(R.id.textView);
        etPassword = findViewById(R.id.editText);
        btList = findViewById(R.id.button2);
        anim = AnimationUtils.loadAnimation(this, R.anim.my);
    }
    public void onClickCount(View view) {

        counter++;
        tvResult.setText(Integer.toString(counter));

    }

    public void passwordGener() {
        int n = 8;
        String set = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        for (int m = 10; m > 0; m--) {
            StringBuilder pass = new StringBuilder();
            for (int i = 0; i < n; i++) {
                int k = (int) (Math.random() * 62);
                pass.append(set.charAt(k));
            }
            arrayPassword.add(pass.toString());

        }
        for (int a = 0; a < arrayPassword.size() - 1; a++) {
            etPassword.append(arrayPassword.get(a) + "\n");
            tvNumber.append((a + 1) + ".     " + "\n");
        }
        etPassword.append(arrayPassword.get(9));
        tvNumber.append((10) + ".     ");
    }

    public void onClickGenerate(View view) {
        arrayPassword.clear();
        etPassword.setText("");
        tvNumber.setText("");
        passwordGener();

        btList.setText(R.string.hide);
        btList.setBackgroundResource(R.color.bt);
        tvNumber.setVisibility(View.VISIBLE);
        etPassword.setVisibility(View.VISIBLE);
        aBoolean=false;
    }
    public void onClickList(View view) {

        if (aBoolean == false) {
            btList.setText(R.string.show);
            tvNumber.startAnimation(anim);
            etPassword.startAnimation(anim);

            tvNumber.setVisibility(View.INVISIBLE);
            etPassword.setVisibility(View.INVISIBLE);
            aBoolean=true;
        }
        else {
            btList.setText(R.string.hide);

            tvNumber.setVisibility(View.VISIBLE);
            etPassword.setVisibility(View.VISIBLE);
            aBoolean=false;
        }
    }
    public void onClickExit(View view) {
        Intent i = new Intent(ProfileActivity.this, MainActivity.class);
        //i.putExtra("exit1", false);
        isLogin = false;
        startActivity(i);
    }


}
