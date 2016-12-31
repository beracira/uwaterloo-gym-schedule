package me.beracira.uwgymschedule;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by beracira on 26/12/16.
 */

public class EventAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static class ViewHolder extends  RecyclerView.ViewHolder {
        public ViewHolder () {

        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position,
            List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }
}
