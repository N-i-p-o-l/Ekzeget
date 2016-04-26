package ru.ekzeget.ekzeget.view.fragment;

import ru.ekzeget.ekzeget.database.Books;
import ru.ekzeget.ekzeget.view.adapter.TestamentRecycleAdapter;

/**
 * Created by NArtur on 26.04.2016.
 */
public class OldTestamentFragment extends BaseTestamentFragment {

  @Override protected void setRecycleAdapter() {
    testamentRecycleAdapter = new TestamentRecycleAdapter(Books.getOldTestamentList());
  }
}
