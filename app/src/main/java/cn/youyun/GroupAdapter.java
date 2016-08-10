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
public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.GroupViewHolder> {

    private LayoutInflater inflater;
    private OnItemClickLitener onItemClickLitener;
    private List<String> groupList = new ArrayList<>();

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
    public void onBindViewHolder(final GroupViewHolder holder, int position) {
        holder.tv.setText(groupList.get(position));
//        holder.itemView.setBackgroundResource(R.drawable.recycler_bg);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickLitener != null) {
                    int position = holder.getLayoutPosition();
                    onItemClickLitener.onItemClick(holder.itemView, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return groupList.size();
    }

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickLitener(OnItemClickLitener onItemClickLitener) {
        this.onItemClickLitener = onItemClickLitener;
    }

    class GroupViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public GroupViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.id_num);
        }
    }
}
