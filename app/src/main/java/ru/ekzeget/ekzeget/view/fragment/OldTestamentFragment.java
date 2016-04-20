package ru.ekzeget.ekzeget.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.ekzeget.ekzeget.R;
import ru.ekzeget.ekzeget.database.Books;
import ru.ekzeget.ekzeget.view.adapter.TestamentRecycleAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class OldTestamentFragment extends Fragment {

  private RecyclerView oldTestamentRecycleView;
  private TestamentRecycleAdapter testamentRecycleAdapter;

  private final String TAG = "OldTestamentFragment";

  public OldTestamentFragment() {

  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_old_testament, container, false);
    setRetainInstance(true);

    oldTestamentRecycleView = (RecyclerView) rootView.findViewById(R.id.oldTestamentRecyclerView);
    oldTestamentRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
    testamentRecycleAdapter = new TestamentRecycleAdapter(Books.getOldTestamentList());
    oldTestamentRecycleView.setAdapter(testamentRecycleAdapter);

    return rootView;
  }
}
