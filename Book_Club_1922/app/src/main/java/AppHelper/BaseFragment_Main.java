package AppHelper;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.illguee.book_club_1922.MainActivity;

import org.json.JSONObject;

public class BaseFragment_Main extends Fragment implements Response.ErrorListener{
    protected MainActivity main;
    protected RequestQueue requestQueue;
    protected JSONObject temp_json = new JSONObject();
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.main = (MainActivity) getActivity();
        requestQueue = Volley.newRequestQueue(main);
    }

    protected void Volley(String url,Response.Listener<JSONObject> listener){
        JsonObjectRequest json = new JsonObjectRequest
                (Request.Method.POST,url,temp_json, listener,this);
        requestQueue.add(json);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
}
