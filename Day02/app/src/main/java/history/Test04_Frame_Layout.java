package history;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.day02.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Test04_Frame_Layout extends AppCompatActivity {

    @BindView(R.id.iv1)
    ImageView iv1;
    @BindView(R.id.iv2) ImageView iv2;
    @BindView(R.id.change_btn)
    Button btn;
    boolean turn = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test04__frame__layout);
        ButterKnife.bind(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(turn){
                    iv1.setVisibility(View.INVISIBLE);
                    iv2.setVisibility(View.VISIBLE);
                    turn = false;
                }else{
                    iv1.setVisibility(View.VISIBLE);
                    iv2.setVisibility(View.INVISIBLE);
                    turn = true;
                }
            }
        });
    }
}
