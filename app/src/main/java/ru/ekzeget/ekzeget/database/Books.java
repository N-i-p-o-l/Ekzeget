package ru.ekzeget.ekzeget.database;

import java.util.ArrayList;
import java.util.List;
import ru.ekzeget.ekzeget.model.Book;

/**
 * Created by NArtur on 20.04.2016.
 */
public class Books {

  public static List<Book> oldTestamentsList = new ArrayList<>(27);
  public static List<Book> newTestamentList = new ArrayList<>(50);

  public static List<Book> getOldTestamentList() {
    oldTestamentsList.add(new Book("От Матфея", "mf", 28));
    oldTestamentsList.add(new Book("От Марка", "mk", 16));
    oldTestamentsList.add(new Book("От Луки", "lk", 24));

    return oldTestamentsList;
  }

  public static List<Book> getNewTestamentList() {
    newTestamentList.add(new Book("Бытие", true, "byt", 50));
    newTestamentList.add(new Book("Исход", true, "is", 40));
    newTestamentList.add(new Book("Левит", true, "lev", 27));

    return newTestamentList;
  }

}
