package com.example.np.presto.Fragment;

import android.app.SearchManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.np.presto.Adapter.BookAdapter;
import com.example.np.presto.Adapter.InstrumentAdapter;
import com.example.np.presto.Model.BookModel;
import com.example.np.presto.Model.InstrumentModel;
import com.example.np.presto.Pojo.Book;
import com.example.np.presto.Pojo.Instrument;
import com.example.np.presto.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.SEARCH_SERVICE;

public class SearchFragment extends Fragment {

    private SearchView searchView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.search_layout, container, false);
        /*final RecyclerView bookRecView = (RecyclerView) inflater.inflate(R.layout.book, container, false);
        final RecyclerView instrRecView = (RecyclerView) inflater.inflate(R.layout.instr, container, false);
        final BookModel bookModel = new BookModel(getContext());
        final InstrumentModel instrumentModel = new InstrumentModel(getContext());
        List<Instrument> instrs = new ArrayList<>();
        List<Book> books = new ArrayList<>();
        Instrument firstInstr = new Instrument(getText(R.string.instr1).toString(), "D", R.drawable.bb,getText(R.string.instrprice1).toString());
        Instrument secondInstr = new Instrument(getText(R.string.instr2).toString(), "P132", R.drawable.p132,getText(R.string.instrprice4).toString());
        Instrument thirdInstr = new Instrument(getText(R.string.instr3).toString(), "H115", R.drawable.h115,getText(R.string.instrprice3).toString());
        Instrument fourthInstr = new Instrument(getText(R.string.instr4).toString(), "P132E", R.drawable.p132e,getText(R.string.instrprice4).toString());
        Instrument fifthInstr = new Instrument(getText(R.string.instr5).toString(), "M170", R.drawable.steinway,getText(R.string.instrprice5).toString());
        Instrument sixthInstr = new Instrument(getText(R.string.instr5).toString(), "O180", R.drawable.steinwayblack,getText(R.string.instrprice6).toString());
        Instrument seventhInstr = new Instrument(getText(R.string.instr5).toString(), "D Concert Grand", R.drawable.dconcertgrand,getText(R.string.instrprice7).toString());
        Instrument eighthInstr = new Instrument(getText(R.string.instr5).toString(), "A3", R.drawable.a3,getText(R.string.instrprice8).toString());
        instrumentModel.addInstrument(firstInstr);
        instrumentModel.addInstrument(secondInstr);
        instrumentModel.addInstrument(thirdInstr);
        instrumentModel.addInstrument(fourthInstr);
        instrumentModel.addInstrument(fifthInstr);
        instrumentModel.addInstrument(sixthInstr);
        instrs.add(firstInstr);
        instrs.add(secondInstr);
        instrs.add(thirdInstr);
        instrs.add(fourthInstr);
        instrs.add(fifthInstr);
        instrs.add(sixthInstr);
        Book firstBook = new Book(getText(R.string.book1).toString(),R.drawable.czerny599,getText(R.string.author1).toString(),getText(R.string.pricebook1).toString());
        Book secondBook = new Book(getText(R.string.book2).toString(), R.drawable.czerny299, getText(R.string.author1).toString(), getText(R.string.pricebook1).toString());
        Book thirdBook = new Book(getText(R.string.book3).toString(), R.drawable.czerny553, getText(R.string.author1).toString(), getText(R.string.pricebook1).toString());
        Book fourthBook = new Book(getText(R.string.book4).toString(), R.drawable.a, getText(R.string.author4).toString(), getText(R.string.pricebook4).toString());
        Book fifthBook = new Book(getText(R.string.book5).toString(), R.drawable.arta1, getText(R.string.author5).toString(), getText(R.string.pricebook5).toString());
        Book sixthBook = new Book(getText(R.string.book6).toString(), R.drawable.lemoin, getText(R.string.author6).toString(), getText(R.string.pricebook1).toString());
        Book seventhBook = new Book(getText(R.string.book7).toString(), R.drawable.arta2, getText(R.string.author5).toString(),getText(R.string.pricebook5).toString());
        Book eighthBook = new Book(getText(R.string.book8).toString(), R.drawable.scarlatti, getText(R.string.author8).toString(),getText(R.string.pricebook8).toString());
        Book ninthBook = new Book(getText(R.string.book9).toString(), R.drawable.scalesandchords, getText(R.string.author9).toString(),getText(R.string.pricebook9).toString());
        Book tenthBook = new Book(getText(R.string.book10).toString(), R.drawable.al, getText(R.string.author10).toString(),getText(R.string.pricebook10).toString());
        bookModel.addBook(firstBook);
        bookModel.addBook(secondBook);
        bookModel.addBook(thirdBook);
        bookModel.addBook(fourthBook);
        bookModel.addBook(fifthBook);
        bookModel.addBook(sixthBook);
        bookModel.addBook(seventhBook);
        bookModel.addBook(eighthBook);
        books.add(firstBook);
        books.add(secondBook);
        books.add(thirdBook);
        books.add(fourthBook);
        books.add(fifthBook);
        books.add(sixthBook);
        books.add(seventhBook);
        books.add(eighthBook);

        searchView = view.findViewById(R.id.search);
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                List<Book> books = bookModel.search(s);
                bookRecView.setAdapter(new BookAdapter(getContext(),books));
                bookRecView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                bookRecView.setVisibility(View.VISIBLE);

                List<Instrument> instruments = instrumentModel.search(s);
                instrRecView.setAdapter(new InstrumentAdapter(getContext(),instruments));
                instrRecView.setLayoutManager(new GridLayoutManager(instrRecView.getContext(), 2));
                instrRecView.setVisibility(View.VISIBLE);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                List<Book> books = bookModel.search(s);
                bookRecView.setAdapter(new BookAdapter(getContext(),books));
                bookRecView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                bookRecView.setVisibility(View.VISIBLE);

                List<Instrument> instruments = instrumentModel.search(s);
                instrRecView.setAdapter(new InstrumentAdapter(getContext(),instruments));
                instrRecView.setLayoutManager(new GridLayoutManager(instrRecView.getContext(), 2));
                instrRecView.setVisibility(View.VISIBLE);

                return false;
            }
        });*/

        return view;
    }
}
