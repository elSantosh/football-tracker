package com.example.kvarnsen.footballtracker.teamhandlers;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;

import com.example.kvarnsen.footballtracker.globals.Globals;
import com.example.kvarnsen.footballtracker.MainActivity;
import com.example.kvarnsen.footballtracker.R;

/*
    Activity to handle Premier League team selections
 */
public class PremierActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premier);

        Toolbar toolbar = (Toolbar) findViewById(R.id.selector_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Football Tracker");

        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void onRadioButtonClicked(View v) {

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        boolean checked = ((RadioButton) v).isChecked();

        String message = "";

        switch(v.getId()) {
            case R.id.radio_arsenal:
                if (checked)
                    message = "arsenal";
                break;
            case R.id.radio_aston:
                if (checked)
                    message = "astonvilla";
                break;
            case R.id.radio_burnley:
                if (checked)
                    message = "burnley";
                break;
            case R.id.radio_chelsea:
                if (checked)
                    message = "chelsea";
                break;
            case R.id.radio_palace:
                if (checked)
                    message = "crystalpalace";
                break;
            case R.id.radio_everton:
                if (checked)
                    message = "everton";
                break;
            case R.id.radio_hull:
                if (checked)
                    message = "hull";
                break;
            case R.id.radio_leicester:
                if (checked)
                    message = "leicester";
                break;
            case R.id.radio_liverpool:
                if (checked)
                    message = "liverpool";
                break;
            case R.id.radio_city:
                if (checked)
                    message = "mancity";
                break;
            case R.id.radio_manu:
                if (checked)
                    message = "manutd";
                break;
            case R.id.radio_newcastle:
                if (checked)
                    message = "newcastle";
                break;
            case R.id.radio_qpr:
                if (checked)
                    message = "qpr";
                break;
            case R.id.radio_southampton:
                if (checked)
                    message = "southampton";
                break;
            case R.id.radio_stoke:
                if (checked)
                    message = "stoke";
                break;
            case R.id.radio_sunderland:
                if (checked)
                    message = "sunderland";
                break;
            case R.id.radio_swansea:
                if (checked)
                    message = "swansea";
                break;
            case R.id.radio_tottenham:
                if (checked)
                    message = "tottenham";
                break;
            case R.id.radio_westbrom:
                if (checked)
                    message = "westbrom";
                break;
            case R.id.radio_westham:
                if (checked)
                    message = "westham";
                break;
        }

        SharedPreferences preferences = getSharedPreferences(MainActivity.PREFS_NAME, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("curTeam", message);
        editor.putString("curId", "premier");
        editor.commit();

        ((Globals) this.getApplication()).setFixture(null);
        ((Globals) this.getApplication()).setHighlights(null);

        startActivity(intent);

    }


}

