package com.example.androidarshinsky92;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Locale locale;
    private Spinner spinnerMarg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Util.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        spinnerMarg = findViewById(R.id.spinnermarg);

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    locale = new Locale("ru");

                } else {
                    locale = new Locale("en");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Configuration config = new Configuration();
                config.setLocale(locale);

                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                //recreate();
                switch (spinnerMarg.getSelectedItemPosition()) {
                    case 0:
                        Util.changeToTheme(MainActivity.this, Util.THEME_LITTLE);
                        break;
                    case 1:
                        Util.changeToTheme(MainActivity.this, Util.THEME_MEDIUM);
                        break;
                    case 2:
                        Util.changeToTheme(MainActivity.this, Util.THEME_BIG);
                        break;
                }

            }
        });
    }
}