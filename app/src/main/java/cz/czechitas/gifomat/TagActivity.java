package cz.czechitas.gifomat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class TagActivity extends AppCompatActivity {

    EditText tagEditText;
    Button goButton;
    public static final String EXTRA_TAG = "tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag);
        tagEditText = (EditText) findViewById(R.id.dialog_tag);
        goButton = (Button) findViewById(R.id.dialog_go_button);
        goButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(); //nemusím vědět, kam to posílám
                String tag = tagEditText.getText().toString(); //dala by se přidat validace, aby
                // data nebyla prázdná
                intent.putExtra(EXTRA_TAG, tag);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}

