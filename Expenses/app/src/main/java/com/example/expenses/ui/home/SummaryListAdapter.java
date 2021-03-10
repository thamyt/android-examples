package com.example.expenses.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.expenses.R;

import java.util.List;

public class SummaryListAdapter extends ArrayAdapter<String> {
    private List<String> mData;
    private Context mContext;

    public SummaryListAdapter(@NonNull Context context, @NonNull List<String> objects) {
        super(context, R.layout.summary_item, objects);
        mData = objects;
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //View view = super.getView(position, convertView, parent);
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.summary_item, parent, false);
        //View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.title_textview);
        TextView totalAmtText = (TextView) rowView.findViewById(R.id.totalamt_textview);
        titleText.setText(mData.get(position));
        totalAmtText.setText("$XXXX.XX");

        return rowView;
    }
}
