package history;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.example.day02.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Test11_LifeCycle extends AppCompatActivity {
    private final String Tag = "mood";
    @BindView(R.id.et)
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test11__life_cycle);
        ButterKnife.bind(this);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d(Tag,et.getText().toString());
            }
        });
        Log.d(Tag,"______________Create______________");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Tag,"______________Start______________");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Tag,"______________Resume______________");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(Tag,"______________Pause______________");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(Tag,"______________Stop______________");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(Tag,"______________Destroy______________");

    }
}
