package ru.ekzeget.ekzeget.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import ru.ekzeget.ekzeget.model.Inter;
import ru.ekzeget.ekzeget.model.SearchResult;

public class DatabaseAccess {

  private final String TAG = "DatabaseAccess";

  private final static String COLUMN_ST_TEXT = "st_text";
  private final static String COLUMN_ST_NO = "st_no";
  private final static String COLUMN_T_NAME = "t_name";
  private final static String COLUMN_COMMENTS = "comments";

  private final static String FTS_TABLE_NAME = "search";
  private final static String COLUMN_TABLE_NAME = "table_name";
  private final static String SEARCH_LIMIT = "LIMIT 100";

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

  public void createFtsSearch() {

    //CREATE VIRTUAL TABLE txt2 USING fts4(tokenize=unicode61 "remove_diacritics=1");

    database.execSQL("CREATE VIRTUAL TABLE " + FTS_TABLE_NAME + " using fts4" + "("
    +COLUMN_ST_NO + "," + COLUMN_ST_TEXT + "," + COLUMN_TABLE_NAME + ");");

    Cursor cursor = database
        .rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name like '%stih%';", null);

    database.beginTransaction();
    try {
      //
      cursor.moveToFirst();
      while (!cursor.isAfterLast()) {
        database.execSQL("INSERT INTO " + FTS_TABLE_NAME + "(" + COLUMN_ST_NO + "," + COLUMN_ST_TEXT
        + "," + COLUMN_TABLE_NAME + ") " + "SELECT " + COLUMN_ST_NO + "," + COLUMN_ST_TEXT + ","
        + "'" + cursor.getString(0) + "' " + "FROM " + cursor.getString(0));

        cursor.moveToNext();
      }
      cursor.close();

      database.setTransactionSuccessful();
    } catch(Exception e) {
      Log.d(TAG, "Error feel FTS Table");
    } finally {
      database.endTransaction();
    }

  }

  public List<SearchResult> runSearch(String query) {
    List<SearchResult> searchList = new ArrayList<>();
    Cursor cursor = database.rawQuery("SELECT * FROM " + FTS_TABLE_NAME + " WHERE " + COLUMN_ST_TEXT
    + " MATCH " + "'" + query + "' " + SEARCH_LIMIT, null);
    cursor.moveToFirst();
    while (!cursor.isAfterLast()) {
      SearchResult searchResult = new SearchResult();
      searchResult.setSt_no(cursor.getString(cursor.getColumnIndex(COLUMN_ST_NO)));
      searchResult.setSt_text(cursor.getString(cursor.getColumnIndex(COLUMN_ST_TEXT)));
      searchResult.setTableName(cursor.getString(cursor.getColumnIndex(COLUMN_TABLE_NAME)));
      searchList.add(searchResult);

      cursor.moveToNext();
    }
    cursor.close();

    return searchList;
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

  public List<String> getIntersAuthors(String table, String stNo) {
    List<String> list = new ArrayList<>();
    Cursor cursor = database.rawQuery("SELECT " + COLUMN_T_NAME + " FROM tolk_" + table
        + " WHERE " + COLUMN_ST_NO + "=" + stNo, null);
    cursor.moveToFirst();
    while (!cursor.isAfterLast()) {
      list.add(cursor.getString(cursor.getColumnIndex(COLUMN_T_NAME)));
      cursor.moveToNext();
    }
    cursor.close();
    return list;
  }

  public List<Inter> getIntersComments(String table, String stNo) {
    List<Inter> list = new ArrayList<>();
    Cursor cursor = database.rawQuery("SELECT " + COLUMN_T_NAME + ", " + COLUMN_COMMENTS + " FROM tolk_" + table
        + " WHERE " + COLUMN_ST_NO + "=" + stNo, null);
    cursor.moveToFirst();
    while (!cursor.isAfterLast()) {
      Inter inter = new Inter();
      inter.setName(cursor.getString(cursor.getColumnIndex(COLUMN_T_NAME)));
      inter.setComment(cursor.getString(cursor.getColumnIndex(COLUMN_COMMENTS)));
      list.add(inter);
      cursor.moveToNext();
    }
    cursor.close();
    return list;
  }

}