package test.ban.com.test_recysleview;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by brander on 2017/5/5.
 */
public class MyRecycleView extends RecyclerView.Adapter<MyRecycleView.ViewHolder> {
    private List<MyImage> myImages;
    private Bitmap bitmap;
    private static final String TAG = "MyRecycleView";
    private Context context;

    public MyRecycleView(List<MyImage> myImages) {
        this.myImages = myImages;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_re);
            textView = (TextView) itemView.findViewById(R.id.tv_re);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_re, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MyImage myImage = myImages.get(position);

        Glide.with(context).load("http://tnfs.tngou.net/img"+myImage.getImg()).animate(R.anim.item_alpha_in).into(holder.imageView);
        Log.i(TAG, "onBindViewHolder: " + myImage.getTitle());
        holder.textView.setText(myImage.getTitle());
    }

    @Override
    public int getItemCount() {
        return myImages.size();
    }


}
