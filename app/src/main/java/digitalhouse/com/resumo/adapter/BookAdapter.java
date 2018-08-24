package digitalhouse.com.resumo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import digitalhouse.com.resumo.R;
import digitalhouse.com.resumo.models.Book;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<Book> bookList;

    public BookAdapter(List<Book> bookList){
        this.bookList = bookList;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {
      public TextView title;
      public TextView author;

      public BookViewHolder(View itemView) {
          super(itemView);

          title = (TextView) itemView.findViewById(R.id.title);
          author = (TextView) itemView.findViewById(R.id.author);
      }
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutDaMinhaRecycler = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_recycler_main,parent,false);

        return new BookViewHolder(layoutDaMinhaRecycler);


    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        holder.title.setText(bookList.get(position).getTitle());
        holder.author.setText(bookList.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }
}
