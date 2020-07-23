package AppHelper;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.book_club_1922.LobbyActivity;
import com.example.book_club_1922.R;

public class BaseFragment_Lobby extends Fragment {
    protected LobbyActivity lobby;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.lobby = (LobbyActivity) getActivity();
    }
}
