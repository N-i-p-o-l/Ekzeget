package ru.ekzeget.ekzeget.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.annimon.stream.Exceptional;
import java.util.List;
import ru.ekzeget.ekzeget.R;
import ru.ekzeget.ekzeget.database.DatabaseAccess;
import ru.ekzeget.ekzeget.model.Inter;

/**
 * Created by NArtur on 22.04.2016.
 */
public class StartActivity extends AppCompatActivity {

  private final static String TAG = "StartActivity";
  private final static String DATABASE_READY = "databaseReady";

  private SharedPreferences preferences;
  private ProgressBar progressBar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_start);

    progressBar = (ProgressBar) findViewById(R.id.databaseProgress);
    progressBar.setVisibility(View.VISIBLE);

    preferences  = PreferenceManager.getDefaultSharedPreferences(this);

    if (preferences.getBoolean(DATABASE_READY, false)) {
      startMainActivity();
      finish();
      return;
    }

    Runnable databasePrepare = this::prepareDatabase;
    databasePrepare.run();
  }

  private void prepareDatabase() {
    Exceptional.of(() -> {

      Log.d(TAG, "Open or Create Database");
      DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
      databaseAccess.open();

      Log.d(TAG, "Prepare FTS Table");
      databaseAccess.createFtsSearch();

      Log.d(TAG, "Close Database");
      databaseAccess.close();

      SharedPreferences.Editor editor = preferences.edit();
      editor.putBoolean(DATABASE_READY, true);
      editor.apply();

      startMainActivity();

      return true;
    }).ifException((e) -> {
      Log.d(TAG, e.toString());
      Toast.makeText(StartActivity.this, getString(R.string.error_database), Toast.LENGTH_SHORT).show();
    });
  }

  private void startMainActivity() {
    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);
  }

}
