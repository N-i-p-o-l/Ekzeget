package ru.ekzeget.ekzeget.model;

/**
 * Created by NArtur on 20.04.2016.
 */
public class Book {
  String name;

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

  boolean isNewTestament;
  String tableName;
  int chapters;

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
