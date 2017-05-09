package android.learnretrofit_lib;

import android.learnretrofit_lib.model.Example;
import android.learnretrofit_lib.model.Result;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by ideabubbles on 8/5/17.
 */

public class Rest {

    private static MyApiEndpointInterface apiInterface;
    public static final String BASE_URL = "http://www.happidoc.com";

    public static MyApiEndpointInterface getClient(){

        if (apiInterface == null){
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .create();

            Retrofit retrofit = new Retrofit.Builder()  // To make the network call we need Retrofit Builder
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            apiInterface = retrofit.create(MyApiEndpointInterface.class);
        }
        return apiInterface;
    }

    /*
        Endpoints are defined inside of an interface using special retrofits annotations to encode details about the
        parameters and request methods.
     */
    public interface MyApiEndpointInterface{

        @GET("/api/v2/allspecialties")    // this annotations always has HTTP type (GET,PUT,POST).
        Call<Example<Result>> getData();  // the return value is always a parameterized Call<T> objects.

    }

}
