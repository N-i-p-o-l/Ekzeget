package ru.ekzeget.ekzeget.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import java.util.List;
import ru.ekzeget.ekzeget.R;
import ru.ekzeget.ekzeget.database.DatabaseAccess;

/**
 * Created by NArtur on 22.04.2016.
 */
public class StartActivity extends AppCompatActivity {

  private final static String TAG = "StartActivity";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_start);

    Log.d(TAG, "Open Database");
    DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
    databaseAccess.open();
    Log.d(TAG, "Close Database");
    databaseAccess.close();
  }
}
