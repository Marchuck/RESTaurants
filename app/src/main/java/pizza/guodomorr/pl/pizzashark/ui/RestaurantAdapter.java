package pizza.guodomorr.pl.pizzashark.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import pizza.guodomorr.pl.pizzashark.R;
import pizza.guodomorr.pl.pizzashark.model.restaurants.Restaurant;

/**
 * Created by lukasz on 18.10.15.
 * Adapter which represents list of nearby restaurants
 */
public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.VH> {
    private List<Restaurant> dataSet;

    public interface OnClickCallback {
        void onClick(int position, Restaurant restaurant);
    }

    private OnClickCallback callback;

    public RestaurantAdapter(@NonNull List<Restaurant> dataSet, OnClickCallback callback) {
        this.dataSet = dataSet;
        this.callback = callback;
    }

    public void updateData(List<Restaurant> list) {
        this.dataSet.clear();
        this.dataSet.addAll(list);
        notifyItemRangeChanged(0, getItemCount());
        notifyDataSetChanged();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = android.view.LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH vh, final int position) {
        final Restaurant rest = dataSet.get(position);
        vh.name.setText(rest.getName());
        vh.type.setText(rest.getRestaurantCategory());
        vh.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onClick(position, rest);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class VH extends RecyclerView.ViewHolder {
        public TextView name, type;
        public RelativeLayout parent;

        public VH(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.name);
            type = (TextView) v.findViewById(R.id.type);
            parent = (RelativeLayout) v.findViewById(R.id.parent);
        }
    }
}
