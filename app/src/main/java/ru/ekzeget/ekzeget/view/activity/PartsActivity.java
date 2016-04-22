package ru.ekzeget.ekzeget.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import com.annimon.stream.Stream;
import ru.ekzeget.ekzeget.R;
import ru.ekzeget.ekzeget.model.Book;
import ru.ekzeget.ekzeget.view.adapter.PartsRecycleAdapter;

public class PartsActivity extends AppCompatActivity {

  private RecyclerView recyclerView;
  private Toolbar toolbar;

  private Book book;
  private String[] parts;

  public PartsActivity() {

  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_parts);

    toolbar = (Toolbar) findViewById(R.id.partsToolbar);
    recyclerView = (RecyclerView) findViewById(R.id.partsRecyclerView);

    if (toolbar != null) {
      setSupportActionBar(toolbar);
    }

    getSupportActionBar().setDisplayShowTitleEnabled(false);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    book = getIntent().getExtras().getParcelable("book");
    parts = new String[book.getChapters()];

    Stream.range(1, book.getChapters() + 1).forEach(t -> parts[t - 1] = t.toString());
    recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    recyclerView.setAdapter(new PartsRecycleAdapter(parts));
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
}
