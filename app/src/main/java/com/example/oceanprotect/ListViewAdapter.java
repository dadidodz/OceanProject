package com.example.oceanprotect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables

    Context mContext;
    LayoutInflater inflater;
    private List<NomsLieux> nomsLieuxListe = null;
    private ArrayList<NomsLieux> arraylist;

    public ListViewAdapter(Context context, List<NomsLieux> nomsLieuxListe) {
        mContext = context;
        this.nomsLieuxListe = nomsLieuxListe;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<NomsLieux>();
        this.arraylist.addAll(nomsLieuxListe);
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return nomsLieuxListe.size();
    }

    @Override
    public NomsLieux getItem(int position) {
        return nomsLieuxListe.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.list_view_items, null);
            // Locate the TextViews in listview_item.xml
            holder.name = (TextView) view.findViewById(R.id.nomville);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(nomsLieuxListe.get(position).getNomsLieux());
        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        nomsLieuxListe.clear();
        if (charText.length() == 0) {
            nomsLieuxListe.addAll(arraylist);
        } else {
            for (NomsLieux wp : arraylist) {
                if (wp.getNomsLieux().toLowerCase(Locale.getDefault()).contains(charText)) {
                    nomsLieuxListe.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
