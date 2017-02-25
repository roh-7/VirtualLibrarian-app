package com.example.virtuallibrarian.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.virtuallibrarian.R;
import com.example.virtuallibrarian.utils.Book;
import com.example.virtuallibrarian.utils.FetchUpdates;
import com.example.virtuallibrarian.utils.SessionManager;
import com.example.virtuallibrarian.utils.UpdatesAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rohitramaswamy on 25/02/17.
 */

public class UpdatesFragment extends Fragment {
    SessionManager session;
    Context context;
    private List<Book> bookList = new ArrayList<Book>();
    RecyclerView recyclerView;
    UpdatesAdapter updatesAdapter;


    public UpdatesFragment()
    {}

    public UpdatesFragment(Context ctx){
        context=ctx;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.v("t","u");
        View view = inflater.inflate(R.layout.fragment_updates, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        new FetchUpdates(context,recyclerView).execute();

       // bookList.add(new Book("hello","its me","i was"));
       //updatesAdapter= new UpdatesAdapter(context,bookList);
       // recyclerView.setAdapter(updatesAdapter);
        return view;
    }




}