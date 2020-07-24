package Main_Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.book_club_1922.R;

import AppHelper.BaseFragment_Main;

public class Main04_Myinfo_Fragment extends BaseFragment_Main {


    /*
        클릭 했을때만 모습이 나오고 평소에는 모습이 나오지 않음.
        클릭했을때 background 가 변경.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v  = inflater.inflate(R.layout.main04_myinfo_fragment,container,false);

        return v;
    }
}
