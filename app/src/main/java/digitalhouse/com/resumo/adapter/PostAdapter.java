package digitalhouse.com.resumo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import digitalhouse.com.resumo.R;

import digitalhouse.com.resumo.models.Posts;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
        private List<Posts> postsList;

    public PostAdapter(List<Posts> postList){
        this.postsList = postList;
    }

    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutDaMinhaRecycler = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_recycler_main,parent,false);

        return new PostAdapter.PostViewHolder(layoutDaMinhaRecycler);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        holder.title.setText(postsList.get(position).getTitle());
        holder.author.setText(postsList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView author;

        public PostViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            author = (TextView) itemView.findViewById(R.id.author);
        }


    }


}

