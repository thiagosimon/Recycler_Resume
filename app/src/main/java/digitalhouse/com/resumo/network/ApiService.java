package digitalhouse.com.resumo.network;

import java.util.List;

import digitalhouse.com.resumo.models.Posts;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/posts")
    Call<List<Posts>> getAllPosts();


}
