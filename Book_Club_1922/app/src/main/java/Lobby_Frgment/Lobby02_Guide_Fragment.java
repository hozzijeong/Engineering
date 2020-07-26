package Lobby_Frgment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.illguee.book_club_1922.R;

import AppHelper.BaseFragment_Lobby;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Lobby02_Guide_Fragment extends BaseFragment_Lobby {

    @BindView(R.id.str) TextView str;
    public String text = "";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.lobby02_guide_fragment,container,false);
        ButterKnife.bind(this,v);
        str.setText(text);
        return v;
    }

}
