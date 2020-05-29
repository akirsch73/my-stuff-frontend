package de.telekom.sea.mystuff.frontend.android.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.telekom.sea.mystuff.frontend.android.R;
import de.telekom.sea.mystuff.frontend.android.databinding.MyStuffItemBinding;
import de.telekom.sea.mystuff.frontend.android.model.Item;


import lombok.Getter;


public class ItemListRecyclerViewAdapter extends RecyclerView.Adapter<ItemListRecyclerViewAdapter.ViewHolder> {

    @Getter
    private List<Item> itemList2;

    public ItemListRecyclerViewAdapter(List<Item> itemList) {
        this.itemList2 = itemList;
    }

    public void updateList(List<Item> newItemList) {
        itemList2.clear();
        itemList2.addAll(newItemList);
        notifyDataSetChanged();
    }

    public List<Item> getItemList() {
        return itemList2;
    }

    public void setType(List<Item> itemList) {
        this.itemList2 = itemList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyStuffItemBinding itemListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.my_stuff_item, parent, false);

        return new ViewHolder(itemListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListRecyclerViewAdapter.ViewHolder holder, int position) {
        Item item = getItemList().get(position);
        holder.getBinding().setItem(item);
    }

    @Override
    public int getItemCount() {
        return itemList2.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @Getter
        private MyStuffItemBinding binding;

        public ViewHolder(@NonNull MyStuffItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

 //      public MyStuffItemBinding getBinding() {
 //           return binding;

 //       }
    }
}


