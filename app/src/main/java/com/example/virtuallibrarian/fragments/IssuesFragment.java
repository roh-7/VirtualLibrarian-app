package com.example.virtuallibrarian.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.virtuallibrarian.R;
import com.example.virtuallibrarian.utils.Book;
import com.example.virtuallibrarian.utils.FetchIssue;
import com.example.virtuallibrarian.utils.SessionManager;
import com.example.virtuallibrarian.utils.UpdatesAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rohitramaswamy on 25/02/17.
 */

public class IssuesFragment extends Fragment {

    SessionManager session;
    Context context;
    private List<Book> bookList = new ArrayList<Book>();
    RecyclerView recyclerView;
    UpdatesAdapter updatesAdapter;
    View parentLayout;


    public IssuesFragment() {
    }

    public IssuesFragment(Context ctx) {
        context = ctx;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.v("t", "u");
        session = new SessionManager(context);
        String prn = session.getKeyPrn();
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        ActionBar actionBar = activity.getSupportActionBar();
        actionBar.setTitle("Issues");
        View view = inflater.inflate(R.layout.fragment_issue, container, false);
        parentLayout = view.findViewById(R.id.contentdetail);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_issue);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        new FetchIssue(context, recyclerView,prn,parentLayout).execute();

        // bookList.add(new Book("hello","its me","i was"));
        //updatesAdapter= new UpdatesAdapter(context,bookList);
        // recyclerView.setAdapter(updatesAdapter);
        return view;
    }
}
