package ru.ekzeget.ekzeget.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.ekzeget.ekzeget.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewTestamentFragment extends Fragment {

  private final String TAG = "NewTestamentFragment";

  public NewTestamentFragment() {
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootview = inflater.inflate(R.layout.fragment_new_testament, container, false);
    setRetainInstance(true);
    return rootview;
  }
}
