package sjs.example.httpbasic;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    NetworkImageView imgV;
    RequestQueue queue;
    TextView tvId , tvName , tvAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.tvName);
        tvId = findViewById(R.id.tvId);
        tvAge = findViewById(R.id.tvAge);

        imgV = findViewById(R.id.imgV);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "http://101.101.211.66:8080/2021081048/test.json",
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    tvId.setText(response.getString("id"));
                    tvName.setText(response.getString("name"));
                    tvAge.setText(String.valueOf(response.getInt("age")));

                    String imgFile = response.getString("file");

                    if (imgFile != null && !imgFile.equals("")) {

                        ImageLoader imageLoader = new ImageLoader(queue, new ImageLoader.ImageCache() {
                            @Nullable
                            @Override
                            public Bitmap getBitmap(String url) {
                                return null;
                            }

                            @Override
                            public void putBitmap(String url, Bitmap bitmap) {

                            }
                        });

                        imgV.setImageUrl("http://101.101.211.66:8080/2021081048/" + imgFile, imageLoader);
                    }
                } catch (Exception e) {
                    Log.d("test", e.toString());
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("test" , error.toString());
            }

        });

        queue = Volley.newRequestQueue(this);
        queue.add(jsonObjectRequest);

    }



}