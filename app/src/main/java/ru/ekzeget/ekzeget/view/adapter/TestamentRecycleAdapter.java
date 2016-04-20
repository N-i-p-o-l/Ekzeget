package ru.ekzeget.ekzeget.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import ru.ekzeget.ekzeget.R;
import ru.ekzeget.ekzeget.model.Book;

/**
 * Created by NArtur on 20.04.2016.
 */
public class TestamentRecycleAdapter extends RecyclerView.Adapter {

  private List<Book> testamentList;

  public TestamentRecycleAdapter(List<Book> testamentList) {
    this.testamentList = testamentList;
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View layoutView = LayoutInflater
        .from(parent.getContext())
        .inflate(R.layout.testament_item_layout, null);
    return new TestamentViewHolder(layoutView);
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    Book book = testamentList.get(position);
    TestamentViewHolder testamentViewHolder = (TestamentViewHolder) holder;
    testamentViewHolder.bookName.setText(book.getName());
  }

  @Override public int getItemCount() {
    return testamentList.size();
  }

  public class TestamentViewHolder extends RecyclerView.ViewHolder {

    public TextView bookName;

    public TestamentViewHolder(View itemView) {
      super(itemView);

      bookName = (TextView) itemView.findViewById(R.id.bookName);
    }
  }
}
