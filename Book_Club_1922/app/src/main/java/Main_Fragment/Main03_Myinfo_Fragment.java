package Main_Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.book_club_1922.R;

import AppHelper.BaseFragment_Main;

public class Main03_Myinfo_Fragment extends BaseFragment_Main {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v  = inflater.inflate(R.layout.main03_myinfo_fragment,container,false);

        return v;
    }
}
