package ru.ekzeget.ekzeget.view.activity;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import ru.ekzeget.ekzeget.R;
import ru.ekzeget.ekzeget.view.adapter.MainViewPageAdapter;
import ru.ekzeget.ekzeget.view.fragment.NewTestamentFragment;
import ru.ekzeget.ekzeget.view.fragment.BaseTestamentFragment;
import ru.ekzeget.ekzeget.view.fragment.OldTestamentFragment;

/**
 * Created by NArtur on 20.04.2016.
 */
public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
    if (viewPager != null) {
      setupViewPager(viewPager);
    }

    TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
    tabLayout.setupWithViewPager(viewPager);
  }

  private void setupViewPager(ViewPager viewPager) {
    MainViewPageAdapter adapter = new MainViewPageAdapter(getSupportFragmentManager());
    adapter.addFragment(new OldTestamentFragment(), getString(R.string.OldTestament));
    adapter.addFragment(new NewTestamentFragment(), getString(R.string.NewTestament));
    viewPager.setAdapter(adapter);
    viewPager.setOffscreenPageLimit(2);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the options menu from XML
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.options_menu, menu);

    SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
    SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();

    ComponentName cn = new ComponentName(this, SearchActivity.class);
    searchView.setSearchableInfo(searchManager.getSearchableInfo(cn));

    return true;
  }
}
