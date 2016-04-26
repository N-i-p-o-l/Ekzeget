package ru.ekzeget.ekzeget.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.ekzeget.ekzeget.R;
import ru.ekzeget.ekzeget.view.adapter.TestamentRecycleAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseTestamentFragment extends Fragment {

  protected RecyclerView testamentRecycleView;
  protected TestamentRecycleAdapter testamentRecycleAdapter;

  public BaseTestamentFragment() {}

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_base_testament, container, false);
    setRetainInstance(true);

    testamentRecycleView = (RecyclerView) rootView.findViewById(R.id.testamentRecyclerView);
    testamentRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
    setRecycleAdapter();
    testamentRecycleView.setAdapter(testamentRecycleAdapter);

    return rootView;
  }

  protected void setRecycleAdapter() {}
}
