package cn.youyun;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 卫彪 on 2016/8/9.
 */
public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.GroupViewHolder> implements View.OnClickListener{

    private LayoutInflater inflater;
    private List<String> groupList = new ArrayList<>();
    private ClickListener mCallback;

    public GroupAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void setGroupList(List<String> groupList) {
        this.groupList = groupList;
    }

    @Override
    public GroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.adapter_grouplist_item, parent, false);
        GroupViewHolder myViewHolder = new GroupViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(GroupViewHolder holder, int position) {
        holder.tv.setText(groupList.get(position));
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return groupList.size();
    }

    @Override
    public void onClick(View v) {
        if(v.getTag() != null){
            int index = (int)v.getTag();
            if(mCallback != null){
                mCallback.onClick(index);
            }
        }
    }

    public interface ClickListener{
        void onClick(int position);
    }

    public void setCallback(ClickListener mCallback) {
        this.mCallback = mCallback;
    }

    class GroupViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public GroupViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.id_num);
        }
    }
}
