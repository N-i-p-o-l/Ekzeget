package ru.ekzeget.ekzeget.view.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import ru.ekzeget.ekzeget.R;

/**
 * Created by NArtur on 25.04.2016.
 */
public class InterChooseFragment extends AppCompatDialogFragment {

  private static final String INTERS = "inters";

  private String[] params;

  public InterChooseFragment() {

  }

  public static InterChooseFragment newInstance(String[] params) {
    InterChooseFragment interChooseFragment = new InterChooseFragment();
    Bundle args = new Bundle();
    args.putStringArray(INTERS, params);
    interChooseFragment.setArguments(args);
    return interChooseFragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      params = getArguments().getStringArray(INTERS);
    }
  }

  @Override public Dialog onCreateDialog(Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setTitle(R.string.interpretation)
        .setItems(params, (dialog, which) -> {

        });
    return builder.create();
  }

}
