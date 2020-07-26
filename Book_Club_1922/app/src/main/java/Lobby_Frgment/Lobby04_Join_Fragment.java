package Lobby_Frgment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.illguee.book_club_1922.R;

import AppHelper.BaseFragment_Lobby;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Lobby04_Join_Fragment extends BaseFragment_Lobby implements View.OnClickListener {
    @BindView(R.id.join_join_btn) Button join;
    @BindView(R.id.join_quite_btn) Button quite;
    @BindView(R.id.join_domain) Spinner domain;
    @BindView(R.id.join_mail_et) EditText mail;
    @BindView(R.id.join_domain_write) EditText domain_myself;
    String self_domain;
    String my_email;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.lobby04_join_fragment,container,false);
        ButterKnife.bind(this,v);
        join.setOnClickListener(this);
        quite.setOnClickListener(this);

        domain.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position!=0){
                    if(position == 4){
                        domain_myself.setVisibility(View.VISIBLE);
                        domain.setVisibility(View.INVISIBLE);
                        self_domain = domain_myself.getText().toString();
                    }else{
                        self_domain = parent.getItemAtPosition(position).toString();
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return v;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.join_join_btn:
                my_email = mail+self_domain;
                break;

            case R.id.join_quite_btn:

                break;

        }
        lobby.change_fragment(R.id.lobby_fragment,lobby.login_fragment);
    }
}
