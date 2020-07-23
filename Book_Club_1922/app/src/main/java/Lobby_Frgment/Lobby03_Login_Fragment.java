package Lobby_Frgment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.book_club_1922.MainActivity;
import com.example.book_club_1922.R;

import AppHelper.BaseFragment_Lobby;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Lobby03_Login_Fragment extends BaseFragment_Lobby implements View.OnClickListener {

    @BindView(R.id.login_id_et) EditText id;
    @BindView(R.id.login_pw_et) EditText pw;
    @BindView(R.id.login_login_btn) Button login;
    @BindView(R.id.login_join_btn) Button join;
    @BindView(R.id.auto_login) CheckBox auto;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.lobby03_login_fragment,container,false);
        ButterKnife.bind(this,v);
        login.setOnClickListener(this);
        join.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_login_btn:
                Intent intent = new Intent(lobby, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.login_join_btn:
                lobby.change_fragment(R.id.lobby_fragment,lobby.join_fragment);
                break;

        }
    }
}
