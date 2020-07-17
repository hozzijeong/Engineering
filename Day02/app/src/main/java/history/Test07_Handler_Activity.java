package history;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.day02.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Test07_Handler_Activity extends AppCompatActivity {

    Context context = this;
    @BindView(R.id.handler_timer)
    TextView timer;
    @BindView(R.id.handler_start)
    Button start;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test07__handler_);
        ButterKnife.bind(this);
        timer.setText(""+count);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0; i<100; i++){
                            try {
                                count++;
                                Message msg = handler.obtainMessage();
                                msg.arg1 = count;
                                handler.sendMessage(msg);
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



    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            timer.setText(""+count);
            if(count == 100){
                Toast.makeText(context,"완료",Toast.LENGTH_LONG).show();
            }
        }
    };
}
