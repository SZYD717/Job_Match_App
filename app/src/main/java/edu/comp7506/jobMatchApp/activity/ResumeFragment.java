package edu.comp7506.jobMatchApp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableRow;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.job_match_app.R;

public class ResumeFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resume, container, false);
//        Button resumeReviewButton = view.findViewById(R.id.create_resume_button);
        TableRow tableRow = view.findViewById(R.id.table_resume);
        tableRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resumeCreateIntent = new Intent(view.getContext(),ResumeCreateActivity.class);
                view.getContext().startActivity(resumeCreateIntent);
            }
        });
        return view;
    }
}
