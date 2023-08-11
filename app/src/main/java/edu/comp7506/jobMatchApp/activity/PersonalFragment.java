package edu.comp7506.jobMatchApp.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import com.example.job_match_app.R;
import edu.comp7506.jobMatchApp.VO.JobVO;
import edu.comp7506.jobMatchApp.model.Customer;
import edu.comp7506.jobMatchApp.service.JobInfoService;
import edu.comp7506.jobMatchApp.service.PersonalService;
import edu.comp7506.jobMatchApp.utils.JsonUtils;

import java.util.concurrent.FutureTask;

import static android.content.Context.MODE_PRIVATE;

public class PersonalFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal, container, false);
        EditText userName = view.findViewById(R.id.user_name);
        EditText telephoneNumber = view.findViewById(R.id.user_telephone);
        EditText email = view.findViewById(R.id.user_email);
        EditText oldPassword = view.findViewById(R.id.old_password);
        EditText newPassword = view.findViewById(R.id.new_password);
        Button modifyButton = view.findViewById(R.id.modify_button);
        Button resetButton = view.findViewById(R.id.reset_button);

        SharedPreferences sharedPreferences = view.getContext(). getSharedPreferences("cache", MODE_PRIVATE);
        String userString = sharedPreferences.getString("user", null);
        try {
            Customer user = JsonUtils.jsonToObject(userString,Customer.class);
            userName.setText(user.getCustomerName());
            telephoneNumber.setText(String.valueOf(user.getCustomerTele()));
            email.setText(user.getCustomerEmail());
            email.setText(user.getCustomerName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return view;
    }
}
