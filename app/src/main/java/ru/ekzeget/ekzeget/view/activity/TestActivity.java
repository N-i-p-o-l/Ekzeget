package ru.ekzeget.ekzeget.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import ru.ekzeget.ekzeget.R;
import ru.ekzeget.ekzeget.database.sqlite.SQLiteDatabase;
import ru.ekzeget.ekzeget.database.sqlite.SQLiteException;

public class TestActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_test);

    try {
      SQLiteDatabase sqLiteDatabase = new SQLiteDatabase("ekzeget_fts_search.db");
      sqLiteDatabase.execute("CREATE TABLE NEW (Id INTEGER PRIMARY KEY AUTOINCREMENT");
    } catch (SQLiteException e) {
      e.printStackTrace();
    }
  }
}
