package ru.ekzeget.ekzeget.view.fragment;

import android.app.Dialog;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import ru.ekzeget.ekzeget.R;
import ru.ekzeget.ekzeget.model.Book;
import ru.ekzeget.ekzeget.view.activity.ChapterTextActivity;
import ru.ekzeget.ekzeget.view.activity.InterTextActivity;

/**
 * Created by NArtur on 25.04.2016.
 */
public class InterChooseFragment extends AppCompatDialogFragment {

  private static final String INTERS = "inters";
  private static final String POS = "pos";

  private String[] params;
  private Book book;
  private int position;

  public InterChooseFragment() {

  }

  public static InterChooseFragment newInstance(String[] params, int position, Book book) {
    InterChooseFragment interChooseFragment = new InterChooseFragment();
    Bundle args = new Bundle();
    args.putStringArray(INTERS, params);
    args.putInt(POS, position);
    args.putParcelable("book", book);
    interChooseFragment.setArguments(args);
    return interChooseFragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      params = getArguments().getStringArray(INTERS);
      book = getArguments().getParcelable("book");
      position = getArguments().getInt(POS, 0);
    }
  }

  @Override public Dialog onCreateDialog(Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    TextView title = new TextView(getActivity());
    title.setText(getString(R.string.interpretation));
    title.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
    title.setPadding(16, 16, 16, 16);
    title.setGravity(Gravity.CENTER);
    title.setTextColor(Color.WHITE);
    title.setTextSize(18);
    builder.setCustomTitle(title)
        .setItems(params, (dialog, which) -> {
          Bundle bundle = new Bundle();
          bundle.putParcelable("book", book);
          bundle.putInt("which", which);
          bundle.putInt(POS, position);
          Intent intent = new Intent(getActivity(), InterTextActivity.class);
          intent.putExtras(bundle);
          startActivity(intent);
        });
    return builder.create();
  }

}
