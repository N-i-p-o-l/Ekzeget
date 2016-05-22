package ru.ekzeget.ekzeget.database;

import android.content.Context;

/**
 * Created by NArtur on 22.04.2016.
 */
public class DatabaseOpenHelper extends SQLiteAssetHelper {

  private static final String DATABASE_NAME = "ekzeget.db";
  private static final int DATABASE_VERSION = 1;

  public DatabaseOpenHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }
}
