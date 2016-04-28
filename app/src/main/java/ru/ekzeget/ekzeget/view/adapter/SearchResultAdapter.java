package ru.ekzeget.ekzeget.view.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import ru.ekzeget.ekzeget.R;
import ru.ekzeget.ekzeget.model.Book;
import ru.ekzeget.ekzeget.model.SearchResult;
import ru.ekzeget.ekzeget.view.activity.ChapterTextActivity;

/**
 * Created by NArtur on 28.04.2016.
 */
public class SearchResultAdapter extends RecyclerView.Adapter {

  private List<SearchResult> searchResultList;
  private List<Book> bookList;

  public SearchResultAdapter(List<SearchResult> searchResultList, List<Book> bookList) {
    this.searchResultList = searchResultList;
    this.bookList = bookList;
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View layoutView = LayoutInflater
        .from(parent.getContext())
        .inflate(R.layout.testament_item_layout, null);
    return new SearchViewHolder(layoutView);
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    SearchResult searchResult = searchResultList.get(position);
    SearchViewHolder searchViewHolder = (SearchViewHolder) holder;
    searchViewHolder.bookName.setText(searchResult.getSt_text());
    holder.itemView.setOnClickListener((v) -> {
      Bundle bundle = new Bundle();
      bundle.putParcelable("book", bookList.get(position));
      Intent intent = new Intent(v.getContext(), ChapterTextActivity.class);
      intent.putExtras(bundle);
      v.getContext().startActivity(intent);
    });
  }

  @Override public int getItemCount() {
    return searchResultList.size();
  }

  public class SearchViewHolder extends RecyclerView.ViewHolder {

    public TextView bookName;

    public SearchViewHolder(View itemView) {
      super(itemView);

      bookName = (TextView) itemView.findViewById(R.id.bookName);
    }
  }
}
