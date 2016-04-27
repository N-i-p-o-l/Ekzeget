package ru.ekzeget.ekzeget.model;

/**
 * Created by NArtur on 27.04.2016.
 */
public class SearchResult {

  private long id;
  private String st_no;
  private String st_text;
  private String tableName;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getSt_no() {
    return st_no;
  }

  public void setSt_no(String st_no) {
    this.st_no = st_no;
  }

  public String getSt_text() {
    return st_text;
  }

  public void setSt_text(String st_text) {
    this.st_text = st_text;
  }

  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }
}
