package com.andrey7mel.test_app.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andrey7mel.test_app.R;
import com.andrey7mel.test_app.view.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.TextViewHolder> {

    private List<Message> list = new ArrayList<>();

    public List<Message> getList() {
        return list;
    }

    public void setList(List<Message> list){
        this.list = list;
    }

    private static final int VIEW_TYPE_LEFT = 0;
    private static final int VIEW_TYPE_RIGHT = 1;



    public void showMessage(Message message) {
        list.add(message);
        notifyDataSetChanged();
    }

    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        int res;
        switch (viewType) {
            case VIEW_TYPE_LEFT:
                res = R.layout.text_item_layout_left;
                break;
            case VIEW_TYPE_RIGHT:
                res = R.layout.text_item_layout_right;
                break;
            default:
                res = R.layout.text_item_layout_right;
                break;
        }

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(res, viewGroup, false);
        return new TextViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TextViewHolder holder, int position) {
        String text = list.get(position).getText();
        holder.text.setText(text);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        switch (list.get(position).getType()) {
            case BOT:
                return VIEW_TYPE_LEFT;
            case USER:
                return VIEW_TYPE_RIGHT;
            default:
                return VIEW_TYPE_LEFT;
        }
    }

    class TextViewHolder extends RecyclerView.ViewHolder {
        TextView text;

        public TextViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.textView);
        }
    }

}
