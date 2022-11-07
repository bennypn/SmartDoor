package com.example.smartdoor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

// FirebaseRecyclerAdapter is a class provided by
// FirebaseUI. it provides functions to bind, adapt and show
// database contents in a Recycler View
public class historyAdapter extends FirebaseRecyclerAdapter<History,historyAdapter.HistorysViewholder> {

    public historyAdapter(
            @NonNull FirebaseRecyclerOptions<History> options)
    {
        super(options);
    }

    @Override
    protected void
    onBindViewHolder(@NonNull HistorysViewholder holder,
                     int position, @NonNull History model)
    {
        


    }

    // Function to tell the class about the Card view (here
    // "History.xml")in
    // which the data will be shown
    @NonNull
    @Override
    public HistorysViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new historyAdapter.HistorysViewholder(view);
    }

    // Sub Class to create references of the views in Crad
    // view (here "History.xml")
    class HistorysViewholder
            extends RecyclerView.ViewHolder {
        TextView epoch, buyPeraTV,buyPulenTV,sisaPeraTV,sisaPulenTV;
        public HistorysViewholder(@NonNull View itemView)
        {
            super(itemView);

        }
    }


}
