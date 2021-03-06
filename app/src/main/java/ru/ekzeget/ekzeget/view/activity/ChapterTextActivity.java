package ru.ekzeget.ekzeget.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
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
import ru.ekzeget.ekzeget.view.fragment.InterChooseFragment;

/**
 * Created by NArtur on 25.04.2016.
 */
public class ChapterTextActivity extends AppCompatActivity {

  private RecyclerView recyclerView;
  private Toolbar toolbar;
  private TextView toolbarTextView;

  private DatabaseAccess databaseAccess;
  private Context context;

  private Book book;

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

    toolbar.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.back_button));

    book = getIntent().getExtras().getParcelable("book");
    context = getApplicationContext();

    databaseAccess = DatabaseAccess.getInstance(this);
    databaseAccess.open();

    toolbarTextView.setText(getString(R.string.chapter) + " " + book.getCurrentChapter());
    FragmentManager fm = getSupportFragmentManager();
    recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    recyclerView.setAdapter(new ChapterRecycleAdapter
        (databaseAccess.getPoemPartText(book.getTableName() + book.getCurrentChapter()),
            book, fm, context));
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
  }
}
