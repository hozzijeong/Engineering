package history;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.day02.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Test06_Count_Activity extends AppCompatActivity {

    @BindView(R.id.start)
    Button start;
    @BindView(R.id.timer)
    TextView timer;
    Context context = this;
    int count = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test06__count_);
        ButterKnife.bind(this);
        timer.setText(""+count);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(count>0){
                            count--;
                            try {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        timer.setText(""+count);
                                        if(count == 0){
                                            Toast.makeText(context,"완료",Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });

                                Thread.sleep(1000);
                            }catch (Exception e){
                                e.printStackTrace();
                            }

                        }
                    }
                }).start();
            }
        });
    }
}
