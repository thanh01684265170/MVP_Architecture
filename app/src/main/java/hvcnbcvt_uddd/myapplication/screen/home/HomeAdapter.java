package hvcnbcvt_uddd.myapplication.screen.home;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import hvcnbcvt_uddd.myapplication.R;
import hvcnbcvt_uddd.myapplication.data.model.User;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private List<User> mUsers;
    private Context mContext;

    public HomeAdapter(List<User> lists, Context context) {
        mUsers = lists;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_home, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        User user = mUsers.get(i);
        viewHolder.mText_name.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        return mUsers != null ? mUsers.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mText_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mText_name = (TextView) itemView.findViewById(R.id.text_name);
        }
    }

}
