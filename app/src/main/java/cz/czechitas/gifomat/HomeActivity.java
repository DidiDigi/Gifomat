package cz.czechitas.gifomat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView catsTextView;
    TextView dogsTextView;
    TextView carsTextView;
    TextView sportTextView;
    TextView officeTextView;
    TextView emotionsTextView;
    TextView friendsTextView;
    TextView starwarsTextView;
    TextView babiesTextView;
    TextView othersTextView;
    public static String EXTRA_URL = "url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        catsTextView = (TextView) findViewById(R.id.home_cats);
        catsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGif(catsTextView.getText().toString());
            }
        });
        dogsTextView = (TextView) findViewById(R.id.home_dogs);
        dogsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGif(dogsTextView.getText().toString());
            }
        });
        carsTextView = (TextView) findViewById(R.id.home_cars);
        carsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGif(carsTextView.getText().toString());
            }
        });
        sportTextView = (TextView) findViewById(R.id.home_sport);
        sportTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGif(sportTextView.getText().toString());
            }
        });
        officeTextView = (TextView) findViewById(R.id.home_office);
        officeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGif(officeTextView.getText().toString());
            }
        });
        emotionsTextView = (TextView) findViewById(R.id.home_emotions);
        emotionsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGif(emotionsTextView.getText().toString());
            }
        });
        friendsTextView = (TextView) findViewById(R.id.home_friends);
        friendsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGif(friendsTextView.getText().toString());
            }
        });
        starwarsTextView = (TextView) findViewById(R.id.home_starwars);
        starwarsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGif(starwarsTextView.getText().toString());
            }
        });
        babiesTextView = (TextView) findViewById(R.id.home_babies);
        babiesTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGif(babiesTextView.getText().toString());            }
        });
        othersTextView = (TextView) findViewById(R.id.home_others);
        othersTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TagActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivityForResult(intent, REQUEST_CODE_GO);
            }
        });
    }

    public void showGif(String tag) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_URL,
                "http://api.giphy.com/v1/gifs/random?tag=" + tag +
                        "&api_key=a5zOX3vbxlVLo04L7EBBFvS9WliFUeUg");
        startActivity(intent);
    }

    static final int REQUEST_CODE_GO = 100;

    //zpracuje výsledek intentu, který čeká na result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if ((requestCode == REQUEST_CODE_GO) && (resultCode == RESULT_OK))
        {
            String tag = data.getStringExtra(TagActivity.EXTRA_TAG);
            showGif(tag);
        }
        super.onActivityResult(resultCode, resultCode, data);
    }


}
