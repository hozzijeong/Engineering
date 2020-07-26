package Lobby_Frgment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.illguee.book_club_1922.R;

import AppHelper.BaseFragment_Lobby;

public class Lobby01_Splash_Fragment extends BaseFragment_Lobby {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.lobby01_splash_fragment,container,false);

        return v;
    }
}
