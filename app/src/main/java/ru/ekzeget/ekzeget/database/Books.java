package ru.ekzeget.ekzeget.database;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import java.util.ArrayList;
import java.util.List;
import ru.ekzeget.ekzeget.model.Book;

/**
 * Created by NArtur on 20.04.2016.
 */
public class Books {

  public static List<Book> oldTestamentsList = new ArrayList<>(50);
  public static List<Book> newTestamentsList = new ArrayList<>(27);

  public static List<Book> getNewTestamentList() {
    newTestamentsList.add(new Book("От Матфея",   true,  "mf", 28));
    newTestamentsList.add(new Book("От Марка",    true,  "mk", 16));
    newTestamentsList.add(new Book("От Луки",     true,  "lk", 24));
    newTestamentsList.add(new Book("От Иоанна",   true,  "in", 21));
    newTestamentsList.add(new Book("Деяния",      true,  "deyan", 28));
    newTestamentsList.add(new Book("Иакова",      true,  "iak", 5));
    newTestamentsList.add(new Book("1 Петра",     true,  "1pet", 5));
    newTestamentsList.add(new Book("2 Петра",     true,  "2pet", 3));
    newTestamentsList.add(new Book("1 Иоанна",    true,  "1in", 5));
    newTestamentsList.add(new Book("2 Иоанна",    true,   "2in", 1));
    newTestamentsList.add(new Book("3 Иоанна",    true,   "3in", 1));
    newTestamentsList.add(new Book("Иуды",        true,   "iud", 1));
    newTestamentsList.add(new Book("Римлянам",    true,   "rim", 16));
    newTestamentsList.add(new Book("1 Коринфянам",true,   "1kor", 16));
    newTestamentsList.add(new Book("2 Коринфянам",true,   "2kor", 13));
    newTestamentsList.add(new Book("Галатам",     true,   "gal", 6));
    newTestamentsList.add(new Book("Ефсеням",     true,    "ef", 6));
    newTestamentsList.add(new Book("Филиппийцам", true,    "flp", 4));
    newTestamentsList.add(new Book("Колоссянам",  true,    "kol", 4));
    newTestamentsList.add(new Book("1 Фессалоник",true,    "1fes", 5));
    newTestamentsList.add(new Book("2 Фессалоник",true,    "2fes", 3));
    newTestamentsList.add(new Book("1 Тимофею",   true,    "1tim", 6));
    newTestamentsList.add(new Book("2 Тимофею",   true,    "2tim", 4));
    newTestamentsList.add(new Book("Титу",        true,    "tit", 3));
    newTestamentsList.add(new Book("Филимону",    true,    "flm", 1));
    newTestamentsList.add(new Book("Евреям",      true,    "evr", 13));
    newTestamentsList.add(new Book("Апокалипсис", true,    "otkr", 22));

    return newTestamentsList;
  }

  public static List<Book> getOldTestamentList() {
    oldTestamentsList.add(new Book("Бытие", "byt", 50));
    oldTestamentsList.add(new Book("Исход", "ish", 40));
    oldTestamentsList.add(new Book("Левит", "lev", 27));
    oldTestamentsList.add(new Book("Числа", "chis", 36));
    oldTestamentsList.add(new Book("Второзаконие", "vtor", 34));
    oldTestamentsList.add(new Book("Иисуса Навина", "nav", 24));
    oldTestamentsList.add(new Book("Судей", "sud", 21));
    oldTestamentsList.add(new Book("Руфь", "ruf", 4));
    oldTestamentsList.add(new Book("1 Царств", "1car", 31));
    oldTestamentsList.add(new Book("2 Царств", "2car", 24));
    oldTestamentsList.add(new Book("3 Царств", "3car", 22));
    oldTestamentsList.add(new Book("4 Царств", "4car", 25));
    oldTestamentsList.add(new Book("1 Паралипом", "1par", 29));
    oldTestamentsList.add(new Book("2 Паралипом", "2par", 36));
    oldTestamentsList.add(new Book("1 Ездры", "1ezd", 10));
    oldTestamentsList.add(new Book("Неемия", "neem", 13));
    oldTestamentsList.add(new Book("2 Ездры", "2ezd", 9));
    oldTestamentsList.add(new Book("Товит", "tov", 14));
    oldTestamentsList.add(new Book("Иудифь", "iudif", 16));
    oldTestamentsList.add(new Book("Есфирь", "esf", 10));
    oldTestamentsList.add(new Book("Иов", "iov", 42));
    oldTestamentsList.add(new Book("Псалтирь", "ps", 151));
    oldTestamentsList.add(new Book("Притчи", "pritch", 31));
    oldTestamentsList.add(new Book("Екклесиаст", "ekkl", 12));
    oldTestamentsList.add(new Book("Песнь Песней", "pesn", 8));
    oldTestamentsList.add(new Book("Прем. Соломона", "prem", 19));
    oldTestamentsList.add(new Book("Сирах", "sir", 51));
    oldTestamentsList.add(new Book("Исаия", "is", 66));
    oldTestamentsList.add(new Book("Иеремия", "ier", 52));
    oldTestamentsList.add(new Book("Плач Иеремии", "plach", 5));
    oldTestamentsList.add(new Book("Посл. Иеремии", "posl", 1));
    oldTestamentsList.add(new Book("Варух", "var", 5));
    oldTestamentsList.add(new Book("Иезекииль", "iez", 48));
    oldTestamentsList.add(new Book("Даниил", "dan", 14));
    oldTestamentsList.add(new Book("Осия", "os", 14));
    oldTestamentsList.add(new Book("Иоиль", "ioil", 3));
    oldTestamentsList.add(new Book("Амос", "am", 9));
    oldTestamentsList.add(new Book("Авдий", "avd", 1));
    oldTestamentsList.add(new Book("Иона", "ion", 4));
    oldTestamentsList.add(new Book("Михей", "mih", 7));
    oldTestamentsList.add(new Book("Наум", "naum", 3));
    oldTestamentsList.add(new Book("Аввакум", "avv", 3));
    oldTestamentsList.add(new Book("Софония", "sof", 3));
    oldTestamentsList.add(new Book("Аггей", "agg", 2));
    oldTestamentsList.add(new Book("Захария", "zah", 14));
    oldTestamentsList.add(new Book("Малахия", "mal", 4));
    oldTestamentsList.add(new Book("1 Маккавейская", "1mak", 16));
    oldTestamentsList.add(new Book("2 Маккавейская", "2mak", 15));
    oldTestamentsList.add(new Book("3 Маккавейская", "3mak", 7));
    oldTestamentsList.add(new Book("3 Ездры", "3ezd", 16));

    return oldTestamentsList;
  }

  public static List<Book> getAllBooks() {
    return Stream.concat(Stream.of(getNewTestamentList()), Stream.of(getOldTestamentList()))
        .distinct().collect(Collectors.toList());
  }

  public static Book getBookFromTableName(String tableName) {

    String table = tableName.replace("stih_", "");
    StringBuilder sb = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    sb.append(tableName).reverse();

    for (int i = 0; i < sb.length() - 1; i++) {
      if (Character.isDigit(sb.charAt(i))) {
        sb2.append(sb.charAt(i));
      } else {
        break;
      }
    }
    sb2.reverse();

    Book book = new Book();
    book.setCurrentChapter(sb2.length() > 0 ? Integer.parseInt(sb2.toString()) : 0);
    book.setTableName(table.substring(0, table.length() - sb2.length()));

    //Stream.of(getAllBooks()).findFirst().filter(t -> t.getTableName().equals(book.getTableName()));

    return book;
  }

}
