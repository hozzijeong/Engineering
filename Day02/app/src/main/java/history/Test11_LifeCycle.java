package history;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.day02.R;

public class Test11_LifeCycle extends AppCompatActivity {
    private final String Tag = "mood";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test11__life_cycle);
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
