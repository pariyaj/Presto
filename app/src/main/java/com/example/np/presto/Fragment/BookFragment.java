package com.example.np.presto.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.np.presto.Adapter.BookAdapter;
import com.example.np.presto.Model.BookModel;
import com.example.np.presto.Pojo.Book;
import com.example.np.presto.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class BookFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        RecyclerView bookRecView = (RecyclerView) inflater.inflate(R.layout.book, container, false);
        BookModel bookModel = new BookModel(bookRecView.getContext());
        List<Book> books = new ArrayList<>();
        BookAdapter bookAdapter = new BookAdapter(bookRecView.getContext(),books);
        registerForContextMenu(bookRecView);


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

        books.add(firstBook);
        books.add(secondBook);
        books.add(thirdBook);
        books.add(fourthBook);
        books.add(fifthBook);
        books.add(sixthBook);
        books.add(seventhBook);
        books.add(eighthBook);
        books.add(ninthBook);
        books.add(tenthBook);

        bookModel.addBook(firstBook);
        bookModel.addBook(secondBook);
        bookModel.addBook(thirdBook);
        bookModel.addBook(fourthBook);
        bookModel.addBook(fifthBook);
        bookModel.addBook(sixthBook);
        bookModel.addBook(seventhBook);
        bookModel.addBook(eighthBook);
        bookModel.addBook(ninthBook);
        bookModel.addBook(tenthBook);



        bookRecView.setAdapter(bookAdapter);
        bookRecView.setLayoutManager(new LinearLayoutManager(getContext()));
        return bookRecView;

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case R.id.more:

                AlertDialog.Builder bookDetails = new AlertDialog.Builder(getContext());
                bookDetails.setCancelable(true);
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                assert inflater != null;
                final View editView = inflater.inflate(R.layout.bookmore_layout, null);
                bookDetails.setView(editView);
                final AlertDialog alertDialog = bookDetails.create();
                alertDialog.show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}
