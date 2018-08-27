package digitalhouse.com.resumo.network;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

public class RetrofitClientInstance {

    public static Retrofit retrofit;
    private static final String BASE_URL="https://jsonplaceholder.typicode.com";

    public static Retrofit getRetrofitInstance(){
        //criacao do cliente do okhttp para log das requesicoes do retrofit
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        if(retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl()
                    .Client()
                    .addConvertFactory()
                    .Build();
        }

        return null;

    }

}
