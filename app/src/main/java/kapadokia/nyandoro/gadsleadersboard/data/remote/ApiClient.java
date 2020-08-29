package kapadokia.nyandoro.gadsleadersboard.data.remote;

import android.content.Context;

import androidx.viewbinding.BuildConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static kapadokia.nyandoro.gadsleadersboard.data.remote.ApiEndPoint.BASE_URL;

public class ApiClient {

    // retrofit instance
    private Retrofit retrofit = null;
    // declare context
    private Context context;

    // empty constructor
    public ApiClient(){}

    //configure OkHttp Client
    private OkHttpClient.Builder okHttpClient(){

        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.callTimeout(3, TimeUnit.MINUTES);
        okHttpClient.readTimeout(3, TimeUnit.MINUTES);
        okHttpClient.writeTimeout(3, TimeUnit.MINUTES);

        if (BuildConfig.DEBUG){
            // interceptors used for monitoring, rewrite and retry calls.
            HttpLoggingInterceptor logging =new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient.addInterceptor(logging);

        }

      return okHttpClient;
    }

    //retrofit config
    public Retrofit getClient(){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit.Builder builder =new Retrofit.Builder();
        builder.baseUrl(BASE_URL);
        builder.addConverterFactory(GsonConverterFactory.create(gson));

        OkHttpClient.Builder okHttpClientBuilder =okHttpClient();
        builder.client(okHttpClientBuilder.build());

        retrofit =builder.build();

        return retrofit;
    }
}
