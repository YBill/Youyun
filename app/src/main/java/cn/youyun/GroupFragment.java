package cn.youyun;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 卫彪 on 2016/8/9.
 */
public class GroupFragment extends Fragment {

    private RecyclerView recyclerView;
    private GroupAdapter adapter;
    private List<String> mDatas = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_group, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_group);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new GroupAdapter(getActivity());
        initData();
        adapter.setGroupList(mDatas);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter.setCallback(new GroupAdapter.ClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getActivity(), mDatas.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private void initData() {
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

}
