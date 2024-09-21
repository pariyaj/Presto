package com.example.np.presto.Activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioGroup;


import com.example.np.presto.Adapter.BookAdapter;
import com.example.np.presto.Adapter.InstrumentAdapter;
import com.example.np.presto.Fragment.InstrumentFragment;
import com.example.np.presto.Fragment.BookFragment;
import com.example.np.presto.Fragment.HomeFragment;
import com.example.np.presto.Fragment.SearchFragment;
import com.example.np.presto.Model.BookModel;
import com.example.np.presto.Model.InstrumentModel;
import com.example.np.presto.Pojo.Book;
import com.example.np.presto.Pojo.Instrument;
import com.example.np.presto.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private RadioGroup rdb, rdbLang;
    private Button continuee, changeLang;
    private BottomNavigationView bottomNavigation;
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    Fragment selected = null;

                    switch (menuItem.getItemId()){
                        /*case R.id.search:
                            selected = new SearchFragment();
                            break;*/
                        case R.id.book:
                            selected = new BookFragment();
                            break;
                        case R.id.home:
                            selected = new HomeFragment();
                            break;
                        case R.id.instrument:
                            selected = new InstrumentFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment,selected).commit();
                    return true;
                }
            };

    /*private FloatingActionButton.OnClickListener fabListener =
            new FloatingActionButton.OnClickListener(){

                @Override
                public void onClick(View v) {

                    AlertDialog.Builder addbuilder = new AlertDialog.Builder(MainActivity.this);
                    addbuilder.setCancelable(true);
                    LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                    assert inflater != null;
                    final View editView = inflater.inflate(R.layout.choose_builder_layout, null);
                    addbuilder.setView(editView);
                    final AlertDialog alertDialog = addbuilder.create();
                    alertDialog.show();
                    rdb = editView.findViewById(R.id.rdb);
                    continuee = editView.findViewById(R.id.continuee);
                    continuee.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            int id = rdb.getCheckedRadioButtonId();
                            switch (id) {
                                case R.id.rdb_instr:

                                    AlertDialog.Builder list = new AlertDialog.Builder(MainActivity.this);
                                    list.setCancelable(true);
                                    LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                                    assert inflater != null;
                                    final View editView = inflater.inflate(R.layout.instrlist_builder_layout, null);
                                    list.setView(editView);
                                    final AlertDialog alertDialog = list.create();
                                    alertDialog.show();
                                    RecyclerView listRecyclerView = editView.findViewById(R.id.instr_recview);
                                    registerForContextMenu(listRecyclerView);
                                    //listRecyclerView.setAdapter(instrAdapter);
                                    //listRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));

                                    break;
                                case R.id.rdb_book:

                                    AlertDialog.Builder booklist = new AlertDialog.Builder(MainActivity.this);
                                    booklist.setCancelable(true);
                                    LayoutInflater binflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                                    assert binflater != null;
                                    final View beditView = binflater.inflate(R.layout.booklist_builder_layout, null);
                                    booklist.setView(beditView);
                                    final AlertDialog balertDialog = booklist.create();
                                    balertDialog.show();
                                    RecyclerView blistRecyclerView = beditView.findViewById(R.id.book_recview);
                                    registerForContextMenu(blistRecyclerView);
                                    //blistRecyclerView.setAdapter(bookAdapter);
                                    //blistRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                                    break;
                            }

                            alertDialog.cancel();

                        }
                    });

                }
            };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new HomeFragment()).commit();
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navListener);
        //FloatingActionButton fab = findViewById(R.id.fab);
        //fab.setOnClickListener(fabListener);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case R.id.exit:
                finish();
                break;
            /*case R.id.cart:

                break;*/
            case R.id.lang:
                AlertDialog.Builder langBuilder = new AlertDialog.Builder(MainActivity.this);
                langBuilder.setCancelable(true);
                LayoutInflater langinflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                assert langinflater != null;
                final View langEditview = langinflater.inflate(R.layout.lang_layout, null);
                langBuilder.setView(langEditview);
                final AlertDialog langalertDialog = langBuilder.create();
                langalertDialog.show();
                rdbLang = langEditview.findViewById(R.id.rdblang);
                changeLang = langEditview.findViewById(R.id.changeBtn);
                changeLang.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       int langId = rdbLang.getCheckedRadioButtonId();
                        switch (langId){
                           case R.id.en:
                                setLocale("en");
                                break;
                            case R.id.fa:
                                setLocale("fa");
                                break;
                       }
                   }
                });
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("SelectedItemId", bottomNavigation.getSelectedItemId());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int selectedItemId = savedInstanceState.getInt("SelectedItemId");
        bottomNavigation.setSelectedItemId(selectedItemId);
    }

    public void setLocale(String lang){

        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);
        finish();
    }

}