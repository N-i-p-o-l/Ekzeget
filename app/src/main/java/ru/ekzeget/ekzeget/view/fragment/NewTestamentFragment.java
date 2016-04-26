package ru.ekzeget.ekzeget.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.ekzeget.ekzeget.R;
import ru.ekzeget.ekzeget.database.Books;
import ru.ekzeget.ekzeget.view.adapter.TestamentRecycleAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewTestamentFragment extends BaseTestamentFragment {

  @Override protected void setRecycleAdapter() {
    testamentRecycleAdapter = new TestamentRecycleAdapter(Books.getNewTestamentList());
  }

}
