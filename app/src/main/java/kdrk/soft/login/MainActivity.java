package kdrk.soft.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    SharedPreferences shPref;
    public static Boolean isLogin =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadInt();
        if(isLogin == true){
            Intent i = new Intent(MainActivity.this, ProfileActivity.class);
        startActivity(i); }

    }

    public void onClickEntry(View view) {
        if(isLogin == true){
            Intent i = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(i); }
        else {
        Intent i = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(i);}
}


    public void saveInt(String key, Boolean isLogin){
//        Bundle passedDate = getIntent().getExtras();
//        if(passedDate != null){
//            isLogin = passedDate.getBoolean("exit");}

        shPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = shPref.edit();
       // if(isLogin == true) {
        editor.putBoolean(key, isLogin);
        editor.commit();
        //}
//        else {
//            editor.putBoolean(key, false);
//            editor.commit();
//        }

    }

    public void loadInt() {
        shPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        isLogin = shPref.getBoolean("key3", isLogin);

    }



    @Override
    protected void onStop() {
        saveInt("key3", isLogin);
        super.onStop();
    }

    @Override
    protected void onPause() {
        saveInt("key3", isLogin);
        super.onPause();
    }
}