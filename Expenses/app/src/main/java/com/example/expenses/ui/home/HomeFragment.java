package com.example.expenses.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.expenses.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    //private List<String> mListItem = new ArrayList<String>();
    private String[] mSummaryItems;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        // setup the listview
        ListView listView = (ListView)root.findViewById(R.id.summary_listview);
        mSummaryItems = getResources().getStringArray(R.array.summary_items);
        //final ArrayAdapter<String> adapter = new ArrayAdapter<String>(root.getContext(),android.R.layout.simple_list_item_1, android.R.id.text1, mSummaryItems);
        SummaryListAdapter adapter = new SummaryListAdapter(root.getContext(), Arrays.asList(mSummaryItems));
        listView.setAdapter(adapter);

        return root;
    }
}