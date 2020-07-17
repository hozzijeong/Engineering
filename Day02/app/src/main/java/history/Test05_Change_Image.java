package history;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.day02.BaseActivity;
import com.example.day02.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Test05_Change_Image extends BaseActivity {

    @BindView(R.id.upside_iv1)
    ImageView upside1;
    @BindView(R.id.downside_iv1)
    ImageView downside1;
    @BindView(R.id.upside_iv2)
    ImageView upside2;
    @BindView(R.id.downside_iv2)
    ImageView downside2;
    @BindView(R.id.ch_btn)
    Button change;

    boolean turn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test05__change__image);
        ButterKnife.bind(this);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                    visible / invisible 사용해서 이미지 구분하기
                 */

                if(!turn){
                    upside1.setVisibility(View.INVISIBLE);
                    upside2.setVisibility(View.VISIBLE);
                    downside1.setVisibility(View.VISIBLE);
                    downside2.setVisibility(View.INVISIBLE);
                    turn = false;
                }else{
                    upside1.setVisibility(View.VISIBLE);
                    upside2.setVisibility(View.INVISIBLE);
                    downside1.setVisibility(View.INVISIBLE);
                    downside2.setVisibility(View.VISIBLE);
                    turn = true;
                }

            }
        });

    }
}
