package com.example.murilo.recyclertest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.lucasr.twowayview.widget.SpannableGridLayoutManager;
import org.lucasr.twowayview.widget.TwoWayView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment {

    private TwoWayView mRecyclerView;
    private ArrayList<TextView> mTextViews;


    public PageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRecyclerView = (TwoWayView) inflater.inflate(R.layout.grid_layout, container, false);

        mRecyclerView.setAdapter(new RecyclerAdapter());

        return mRecyclerView;
    }


    class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

        private ArrayList<MyCellView> mCellViews = new ArrayList<>();


        public class RecyclerViewHolder extends RecyclerView.ViewHolder
        {
            private TextView textView;

            public RecyclerViewHolder(View itemView) {
                super(itemView);

                this.textView = (TextView) itemView.findViewById(R.id.textView);
            }
        }

        RecyclerAdapter()
        {
            for (int i = 0; i < 300; i++)
            {
                MyCellView cellView;
                cellView = new MyCellView(getActivity(), (int)(Math.floor(Math.random() * 4)));
                cellView.setText(getResources().getString(R.string.loremIpsum));
                mCellViews.add(cellView);
            }
        }

        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout, parent, false);
            RecyclerViewHolder vh = new RecyclerViewHolder(view);

            return vh;
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position)
        {
            TextView textView = holder.textView;

            MyCellView currentCell = mCellViews.get(position);

            textView.setText(currentCell.getText() + " " + currentCell.getSize());

            View itemView = holder.itemView;

            buildLayoutParams(currentCell, itemView);
        }

        @Override
        public int getItemCount()
        {
            return mCellViews.size();
        }


        private void buildLayoutParams(MyCellView cellView, View itemView)
        {
            SpannableGridLayoutManager.LayoutParams lp = (SpannableGridLayoutManager.LayoutParams) itemView.getLayoutParams();

            int smallAdSize = cellView.getSize();

            switch (smallAdSize)
            {
                case 0:
                    lp.colSpan = 2;
                    lp.rowSpan = 2;
                    break;
                case 1:
                    lp.colSpan = 2;
                    lp.rowSpan = 1;
                    break;
                case 2:
                    lp.colSpan = 1;
                    lp.rowSpan = 2;
                    break;
                default:
                    lp.colSpan = 1;
                    lp.rowSpan = 1;
            }

            itemView.setLayoutParams(lp);
        }
    }
}
