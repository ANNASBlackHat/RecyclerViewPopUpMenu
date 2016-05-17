package com.developer.gits.listviewpopupmenu;

import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Sasha Grey on 5/16/2016.
 */
public class RecAdapter extends RecyclerView.Adapter<RecAdapter.ViewHolderItem> {

    @Override
    public ViewHolderItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolderItem(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderItem holder, int position) {
        holder.imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }


    class ViewHolderItem extends RecyclerView.ViewHolder{

        ImageView imgBtn;
        public ViewHolderItem(View itemView) {
            super(itemView);
            imgBtn = (ImageView) itemView.findViewById(R.id.img_button);
        }
    }

    public void showPopup(final View v) {
        PopupMenu popup = new PopupMenu(v.getContext(), v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_popup, popup.getMenu());

        popup.getMenu().findItem(R.id.action_edit).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(v.getContext(),"Edit Clicked,,,",Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        popup.show();
    }
}
