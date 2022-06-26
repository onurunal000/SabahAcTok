package com.example.sabahaksamtok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.ListMenuItemView;

import java.util.List;

public class CanliHastaList extends ArrayAdapter<Hasta> {

    private Activity context;
    private List<Hasta> hastaList;

    public CanliHastaList(Activity context , List<Hasta> hastaList){
        super(context,R.layout.ilac_list_layout,hastaList);
        this.context=context;
        this.hastaList=hastaList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.ilac_list_layout,null,true);

        TextView textViewilacad = listViewItem.findViewById(R.id.text_view_ilacad);
        TextView textViewsabahaksam = listViewItem.findViewById(R.id.text_view_sabahaksam);
        TextView textViewactok = listViewItem.findViewById(R.id.text_view_actok);
        TextView textViewsaat = listViewItem.findViewById(R.id.text_view_saat);
        TextView textViewtarih = listViewItem.findViewById(R.id.text_view_tarih);

        Hasta insan = hastaList.get(position);

        textViewilacad.setText(insan.getHastailacad());
        textViewsabahaksam.setText(insan.getHastasabahaksam());
        textViewactok.setText(insan.getHastaactok());
        textViewsaat.setText(insan.getHastasaat());
        textViewtarih.setText(insan.getHastatarih());

        return listViewItem;

    }
}
