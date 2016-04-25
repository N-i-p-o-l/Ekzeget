package ru.ekzeget.ekzeget.view.activity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import ru.ekzeget.ekzeget.R;
import ru.ekzeget.ekzeget.database.DatabaseAccess;
import ru.ekzeget.ekzeget.model.Book;
import ru.ekzeget.ekzeget.view.adapter.ChapterRecycleAdapter;
import ru.ekzeget.ekzeget.view.adapter.PartsRecycleAdapter;

/**
 * Created by NArtur on 25.04.2016.
 */
public class ChapterTextActivity extends AppCompatActivity {

  private RecyclerView recyclerView;
  private Toolbar toolbar;
  private TextView toolbarTextView;

  private DatabaseAccess databaseAccess;

  private Book book;
  private int position;

  public ChapterTextActivity() {

  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.chapter_text);

    toolbar = (Toolbar) findViewById(R.id.chapterToolbar);
    recyclerView = (RecyclerView) findViewById(R.id.chapterRecyclerView);
    toolbarTextView = (TextView) findViewById(R.id.chapter_toolbar_title);

    if (toolbar != null) {
      setSupportActionBar(toolbar);
    }

    getSupportActionBar().setDisplayShowTitleEnabled(false);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    book = getIntent().getExtras().getParcelable("book");
    position = getIntent().getIntExtra("pos", 0);
    databaseAccess = DatabaseAccess.getInstance(this);
    databaseAccess.open();

    toolbarTextView.setText(getString(R.string.chapter) + " " + position);
    recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    recyclerView.setAdapter(new ChapterRecycleAdapter
        (databaseAccess.getPoemPartText(book.getTableName() + position)));

  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        onBackPressed();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    databaseAccess.close();
  }
}
