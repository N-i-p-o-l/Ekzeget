package ru.ekzeget.ekzeget.view.adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import ru.ekzeget.ekzeget.R;
import ru.ekzeget.ekzeget.database.DatabaseAccess;
import ru.ekzeget.ekzeget.model.Book;
import ru.ekzeget.ekzeget.view.fragment.InterChooseFragment;

/**
 * Created by NArtur on 25.04.2016.
 */
public class ChapterRecycleAdapter extends RecyclerView.Adapter {

  private final static String TAG = "ChapterRecycleAdapter";

  private List<String> poemList;
  private FragmentManager fm;
  private Context context;
  private Book book;

  public ChapterRecycleAdapter(List<String> poemList, Book book, FragmentManager fm, Context context) {
    this.poemList = poemList;
    this.context = context;
    this.book = book;
    this.fm = fm;
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
    chapterViewHolder.chapterText.setText((position + 1) + ". " + text);
    holder.itemView.setOnClickListener((v) -> {
      InterChooseFragment interChooseFragment = InterChooseFragment
          .newInstance(getIntersAuthors(position + 1), position + 1, book);
      interChooseFragment.show(fm, "fragmentInters");
    });
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

  private String[] getIntersAuthors(int position) {
    final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(context);
    List<String> list = databaseAccess.getIntersAuthors(book.getTableName() + book.getCurrentChapter(),
        String.valueOf(position));
    return list.toArray(new String[list.size()]);
  }

}
