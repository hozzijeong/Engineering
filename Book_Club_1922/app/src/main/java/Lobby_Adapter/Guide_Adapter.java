package Lobby_Adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import Lobby_Frgment.Lobby02_Guide_Fragment;

public class Guide_Adapter extends FragmentStatePagerAdapter {
    Lobby02_Guide_Fragment guide;

    public Guide_Adapter(@NonNull FragmentManager fm) {
        super(fm);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        guide = new Lobby02_Guide_Fragment();
        guide.text = (position+1)+"번 설명";
        return guide;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
