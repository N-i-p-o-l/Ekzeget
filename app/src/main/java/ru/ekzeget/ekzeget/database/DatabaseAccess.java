package ru.ekzeget.ekzeget.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {

  private final static String COLUMN_ST_TEXT = "st_text";

  private SQLiteOpenHelper openHelper;
  private SQLiteDatabase database;
  private static DatabaseAccess instance;

  /**
   * Private constructor to avoid object creation from outside classes.
   */
  private DatabaseAccess(Context context) {
    this.openHelper = new DatabaseOpenHelper(context);
  }

  /**
   * Return a singleton instance of DatabaseAccess.
   *
   * @param context the Context
   * @return the instance of DabaseAccess
   */
  public static DatabaseAccess getInstance(Context context) {
    if (instance == null) {
      instance = new DatabaseAccess(context);
    }
    return instance;
  }

  /**
   * Open the database connection.
   */
  public void open() {
    this.database = openHelper.getWritableDatabase();
  }

  /**
   * Close the database connection.
   */
  public void close() {
    if (database != null) {
      this.database.close();
    }
  }

  public List<String> getPoemPartText(String table) {
    List<String> list = new ArrayList<>();
    Cursor cursor = database.rawQuery("SELECT " + COLUMN_ST_TEXT + " FROM stih_" + table, null);
    cursor.moveToFirst();
    while (!cursor.isAfterLast()) {
      list.add(cursor.getString(cursor.getColumnIndex(COLUMN_ST_TEXT)));
      cursor.moveToNext();
    }
    cursor.close();
    return list;
  }

}