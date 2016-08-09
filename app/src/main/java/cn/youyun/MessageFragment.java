package cn.youyun;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 卫彪 on 2016/8/9.
 */
public class MessageFragment extends Fragment {

    public MessageFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myview = inflater.inflate(R.layout.fragment_message, container, false);
        TextView textView = (TextView) myview.findViewById(R.id.text);
        textView.setText("Message");
        return myview;
    }

}
