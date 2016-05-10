package ru.ekzeget.ekzeget.view.activity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.annimon.stream.Stream;
import java.util.ArrayList;
import java.util.List;
import ru.ekzeget.ekzeget.R;
import ru.ekzeget.ekzeget.database.Books;
import ru.ekzeget.ekzeget.database.DatabaseAccess;
import ru.ekzeget.ekzeget.model.Book;
import ru.ekzeget.ekzeget.model.SearchResult;
import ru.ekzeget.ekzeget.view.adapter.SearchResultAdapter;
import ru.ekzeget.ekzeget.view.adapter.TestamentRecycleAdapter;

public class SearchActivity extends AppCompatActivity {

  private final static String TAG = "SearchActivity";

  private RecyclerView recyclerView;
  private DatabaseAccess databaseAccess;
  private List<SearchResult> searchResultList;
  private List<Book> bookList;

  public SearchActivity() {

  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search);

    recyclerView = (RecyclerView) findViewById(R.id.searchRecyclerView);
    Toolbar toolbar = (Toolbar) findViewById(R.id.searchToolbar);

    if (toolbar != null) {
      setSupportActionBar(toolbar);
    }
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    toolbar.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.back_button));

    databaseAccess = DatabaseAccess.getInstance(this);
    databaseAccess.open();
    handleIntent(getIntent());
  }

  @Override
  protected void onNewIntent(Intent intent) {
    handleIntent(intent);
  }

  private void handleIntent(Intent intent) {

    if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
      String query = intent.getStringExtra(SearchManager.QUERY);
      Runnable searchTask = () -> {
        searchResultList = databaseAccess.runSearch(query);
        bookList = new ArrayList<>();
          for (SearchResult searchResult : searchResultList) {
            bookList.add(Books.getBookFromTableName(searchResult.getTableName()));
          }
      };
      searchTask.run();

      recyclerView.setLayoutManager(new LinearLayoutManager(this));
      recyclerView.setAdapter(new SearchResultAdapter(searchResultList, bookList));
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.options_menu, menu);
    SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
    SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
    searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

    return true;
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
