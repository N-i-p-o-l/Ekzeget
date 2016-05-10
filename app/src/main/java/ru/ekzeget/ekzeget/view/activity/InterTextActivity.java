package ru.ekzeget.ekzeget.view.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import java.util.List;
import org.w3c.dom.Text;
import ru.ekzeget.ekzeget.R;
import ru.ekzeget.ekzeget.database.DatabaseAccess;
import ru.ekzeget.ekzeget.model.Book;
import ru.ekzeget.ekzeget.model.Inter;

/**
 * Created by NArtur on 26.04.2016.
 */
public class InterTextActivity extends AppCompatActivity {

  private Toolbar toolbar;
  private TextView interTextView;
  private TextView interText;

  private Book book;
  private int position;
  private int which;

  private DatabaseAccess databaseAccess;
  private List<Inter> interList;

  public InterTextActivity() {
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.inter_text_layout);

    toolbar = (Toolbar) findViewById(R.id.interToolbar);
    interTextView = (TextView) findViewById(R.id.inter_toolbar_title);
    interText = (TextView) findViewById(R.id.inter_text);

    if (toolbar != null) {
      setSupportActionBar(toolbar);
    }

    getSupportActionBar().setDisplayShowTitleEnabled(false);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    toolbar.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.back_button));

    databaseAccess = DatabaseAccess.getInstance(this);
    book = getIntent().getExtras().getParcelable("book");
    position = getIntent().getExtras().getInt("pos");
    which = getIntent().getExtras().getInt("which");
    interList = databaseAccess.getIntersComments(book.getTableName() + book.getCurrentChapter(),
        String.valueOf(position));
    interTextView.setText(interList.get(which).getName());
    interText.setText(interList.get(which).getComment());
  }

  @Override protected void onDestroy() {
    super.onDestroy();
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
