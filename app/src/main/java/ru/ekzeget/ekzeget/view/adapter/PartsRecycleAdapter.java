package ru.ekzeget.ekzeget.view.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import ru.ekzeget.ekzeget.R;
import ru.ekzeget.ekzeget.model.Book;
import ru.ekzeget.ekzeget.view.activity.PartsActivity;

/**
 * Created by NArtur on 22.04.2016.
 */
public class PartsRecycleAdapter  extends RecyclerView.Adapter {

  private String[] parts;

  public PartsRecycleAdapter(String[] parts) {
    this.parts = parts;
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View layoutView = LayoutInflater
        .from(parent.getContext())
        .inflate(R.layout.parts_item_layout, null);
    return new PartsViewHolder(layoutView);
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    String part = parts[position];
    PartsViewHolder partsViewHolder = (PartsViewHolder) holder;
    partsViewHolder.partNumber.setText(part);
    holder.itemView.setOnClickListener((v) -> {
    });
  }

  @Override public int getItemCount() {
    return parts.length;
  }

  public class PartsViewHolder extends RecyclerView.ViewHolder {

    public TextView partNumber;

    public PartsViewHolder(View itemView) {
      super(itemView);

      partNumber = (TextView) itemView.findViewById(R.id.partNumber);
    }
  }
}