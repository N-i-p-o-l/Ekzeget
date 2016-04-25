package ru.ekzeget.ekzeget.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by NArtur on 20.04.2016.
 */
public class Book implements Parcelable {

  String name;
  boolean isNewTestament;
  String tableName;
  int chapters;

  protected Book(Parcel in) {
    name = in.readString();
    isNewTestament = in.readByte() != 0;
    tableName = in.readString();
    chapters = in.readInt();
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(name);
    dest.writeByte((byte) (isNewTestament ? 1 : 0));
    dest.writeString(tableName);
    dest.writeInt(chapters);
  }

  @Override public int describeContents() {
    return 0;
  }

  public static final Creator<Book> CREATOR = new Creator<Book>() {
    @Override public Book createFromParcel(Parcel in) {
      return new Book(in);
    }

    @Override public Book[] newArray(int size) {
      return new Book[size];
    }
  };

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isNewTestament() {
    return isNewTestament;
  }

  public void setNewTestament(boolean newTestament) {
    isNewTestament = newTestament;
  }

  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public int getChapters() {
    return chapters;
  }

  public void setChapters(int chapters) {
    this.chapters = chapters;
  }

  public Book(String name, String tableName, int chapters) {
    this.name = name;
    this.tableName = tableName;
    this.chapters = chapters;
  }

  public Book(String name, boolean isNewTestament, String tableName,
      int chapters) {

    this.name = name;
    this.isNewTestament = isNewTestament;
    this.tableName = tableName;
    this.chapters = chapters;
  }
}
