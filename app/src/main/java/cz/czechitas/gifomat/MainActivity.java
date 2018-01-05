package cz.czechitas.gifomat;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.kittinunf.fuel.Fuel;
import com.github.kittinunf.fuel.core.FuelError;
import com.github.kittinunf.fuel.core.Handler;
import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.fuel.core.Response;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

	private ImageView image;
    String url;
    CountDownTimer countDownTimer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        url = intent.getStringExtra(HomeActivity.EXTRA_URL);

		image = findViewById(R.id.main_image);
		image.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				downloadGif();
			}
		});

		downloadGif();
    }

	private void showGif(String url) {
            Glide.with(this)
                    .asGif()
                    .load(url)
                    .into(image);
	}

	private void downloadGif() {
		// URL: http://api.giphy.com/v1/gifs/random?api_key=a5zOX3vbxlVLo04L7EBBFvS9WliFUeUg
		// showGif(url);

        Fuel.get(url)
                .responseString(new Handler<String>() {
                    @Override
                    public void success(Request request, Response response, String s) {
                        Gson gson = new Gson();
                        Giphy giphy = gson.fromJson(s, Giphy.class);
                        showGif(giphy.gif.url);
                    }

                    @Override
                    public void failure(Request request, Response response, FuelError fuelError) {
                        Toast.makeText(MainActivity.this, "Nejde zobrazit GIF!", Toast
                                .LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    protected void onPostResume() {
	    super.onPostResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
/*
        countDownTimer = new CountDownTimer(99999999, 10000) {
            @Override
            public void onTick(long millisUntilFinished) {
                downloadGif();
            }

            @Override
            public void onFinish() {

            }
        }.start();
*/
    }

    @Override
    protected void onStop() {
        super.onStop();
        //countDownTimer.cancel();
    }
}


