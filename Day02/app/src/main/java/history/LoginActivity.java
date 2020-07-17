package history;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.day02.BaseActivity;
import com.example.day02.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.id_et) EditText id;
    @BindView(R.id.pw_et) EditText pw;
    @BindView(R.id.auto_login) CheckBox auto;
    @BindView(R.id.find_info) Button find;
    @BindView(R.id.join_btn) Button join;
    @BindView(R.id.login_btn) Button login;
    @BindView(R.id.google_btn) Button google;
    @BindView(R.id.facebook_btn) Button facebook;
    @BindView(R.id.naver_btn) Button naver;
    @BindView(R.id.kakao_btn) Button kakao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View v) {

    }
}
