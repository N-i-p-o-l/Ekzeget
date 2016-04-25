package ru.ekzeget.ekzeget.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import ru.ekzeget.ekzeget.R;

/**
 * Created by NArtur on 25.04.2016.
 */
public class ChapterRecycleAdapter extends RecyclerView.Adapter {

  private List<String> poemList;

  public ChapterRecycleAdapter(List<String> poemList) {
    this.poemList = poemList;
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View layoutView = LayoutInflater
        .from(parent.getContext())
        .inflate(R.layout.chapter_item_layout, null);
    return new ChapterViewHolder(layoutView);
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
     String text = poemList.get(position);
    ChapterViewHolder chapterViewHolder = (ChapterViewHolder) holder;
    chapterViewHolder.chapterText.setText((position + 1) + " " + text);
    holder.itemView.setOnClickListener((v -> {
      //
    }));
  }

  @Override public int getItemCount() {
    return poemList.size();
  }

  public class ChapterViewHolder extends RecyclerView.ViewHolder {

    public TextView chapterText;

    public ChapterViewHolder(View itemView) {
      super(itemView);

      chapterText = (TextView) itemView.findViewById(R.id.chapterPoemText);
    }
  }
}
