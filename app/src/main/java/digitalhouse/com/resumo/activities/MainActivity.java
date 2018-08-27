package digitalhouse.com.resumo.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import digitalhouse.com.resumo.R;
import digitalhouse.com.resumo.adapter.BookAdapter;
import digitalhouse.com.resumo.adapter.PostAdapter;
import digitalhouse.com.resumo.helpers.RecycleViewClickListener;
import digitalhouse.com.resumo.helpers.RecyclerViewTouchListener;
import digitalhouse.com.resumo.models.Book;
import digitalhouse.com.resumo.models.Posts;
import digitalhouse.com.resumo.network.ApiService;
import digitalhouse.com.resumo.network.RetrofitClientInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Book> bookList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BookAdapter bookAdapter;
    private List<Posts> postsList = new ArrayList<Posts>();
    private PostAdapter postAdapter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("o que voce quiser");
        progressDialog.show();

        initRetrofit();
    }

    private void initRetrofit(){
            ApiService service = RetrofitClientInstance.getRetrofitInstance().create(ApiService.class);
            Call<List<Posts>> call = service.getAllPosts();

            call.enqueue((new Callback<List<Posts>>() {
                @Override
                public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                    progressDialog.dismiss();
                    generateDataList(response.body());
                }

                @Override
                public void onFailure(Call<List<Posts>> call, Throwable t) {

                    progressDialog.dismiss();
                }
            }));
        }

        private void generateDataList(final List<Posts> postList){
        recyclerView= (RecyclerView) findViewById(R.id.recycler_main);

        recyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(getApplicationContext(), recyclerView, new RecycleViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getApplicationContext(), bookList.get(position).getTitle() + " is clicked!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(getApplicationContext(), bookList.get(position).getTitle() + " is long pressed!", Toast.LENGTH_SHORT).show();

            }
        }));
    }


/*
        recyclerView = (RecyclerView) findViewById(R.id.recycler_main);
        bookAdapter = new BookAdapter(bookList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(bookAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(getApplicationContext(), recyclerView, new RecycleViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getApplicationContext(), bookList.get(position).getTitle() + " is clicked!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(getApplicationContext(), bookList.get(position).getTitle() + " is long pressed!", Toast.LENGTH_SHORT).show();

            }
        }));
        initBookData();
    }*/

    private void initBookData() {
        Book book = new Book("Hello Android", "Ed Burnette");
        bookList.add(book);

        book = new Book("Beginning Android 3", "Mark Murphy");
        bookList.add(book);

        book = new Book("Unlocking Android", " W. Frank Ableson");
        bookList.add(book);

        book = new Book("Android Tablet Development", "Wei Meng Lee");
        bookList.add(book);

        book = new Book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new Book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new Book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new Book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new Book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new Book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new Book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new Book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new Book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new Book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new Book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new Book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new Book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new Book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new Book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new Book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        bookAdapter.notifyDataSetChanged();
    }
}
