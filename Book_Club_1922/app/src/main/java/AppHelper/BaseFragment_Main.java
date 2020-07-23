package AppHelper;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.book_club_1922.LobbyActivity;
import com.example.book_club_1922.MainActivity;

public class BaseFragment_Main extends Fragment {
    protected MainActivity main;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.main = (MainActivity) getActivity();
    }

}
