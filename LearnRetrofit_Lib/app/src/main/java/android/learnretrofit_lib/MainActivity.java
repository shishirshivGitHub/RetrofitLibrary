package android.learnretrofit_lib;

import android.learnretrofit_lib.model.Example;
import android.learnretrofit_lib.model.Result;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Rest.MyApiEndpointInterface apiEndpointInterface = Rest.getClient();
        Call<Example<Result>> call = apiEndpointInterface.getData();

        /*
            Asynchronously send the request and notify callback of its response or
            if an error occurred talking to the server,
            creating the request, or processing the response.
         */
        call.enqueue(new Callback<Example<Result>>() {
            @Override
            public void onResponse(Call<Example<Result>> call, Response<Example<Result>> response) {

                Toast.makeText(MainActivity.this,"reponse: " + response.code() ,Toast.LENGTH_LONG).show();

                if (response.code() == 200){
                    List<Result> arrayList = response.body().getResults();
                    Log.d("arrayList",arrayList.get(0).getName() + "");
                }
            }

            @Override
            public void onFailure(Call<Example<Result>> call, Throwable t) {

            }
        });
    }
}
