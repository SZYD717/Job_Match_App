package edu.comp7506.jobMatchApp.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.job_match_app.R;

import java.util.List;

import edu.comp7506.jobMatchApp.VO.HomepageVO;

public class HomepageJobListAdapter extends RecyclerView.Adapter<HomepageJobListAdapter.ViewHolder> {
    List<HomepageVO> jobList;
    public HomepageJobListAdapter(List<HomepageVO> jobs) {
        this.jobList = jobs;
    }

    @NonNull
    @Override
    public HomepageJobListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_home_job_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomepageJobListAdapter.ViewHolder holder, int position) {
        Log.i("adapter",jobList.get(position).toString());
        HomepageVO job = jobList.get(position);
        holder.getJobTitleText().setText(job.getJobName());
        String salary = "¥ "+Integer.toString(job.getJobMinSalary()/1000)+"K — "+
                Integer.toString(job.getJobMaxSalary()/1000)+"K";
        holder.getJobSalaryText().setText(salary);
        holder.getJobCityText().setText(job.getJobCity());
        holder.getJobYearText().setText(job.getJobYear().toString()+" Years Experience");
        String degree;
        switch (job.getJobDegree()){
            case "1": degree = "Bachelor"; break;
            case "2": degree = "Master"; break;
            case "3": degree = "Doctor"; break;
            case "0": degree = "No Degree"; break;
            default:
                throw new IllegalStateException("Unexpected value: " + job.getJobDegree());
        }
        holder.getJobDegreeText().setText(degree);

    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }
    //每个元素的结构
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView jobTitleText;
        private final TextView jobSalaryText;
        private final TextView jobCityText;
        private final TextView jobYearText;
        private final TextView jobDegreeText;
        public ViewHolder(View view) {
            super(view);
            this.jobTitleText = view.findViewById(R.id.jobTitleText);
            this.jobSalaryText = view.findViewById(R.id.jobSalaryText);
            this.jobCityText = view.findViewById(R.id.jobCityText);
            this.jobYearText = view.findViewById(R.id.jobYearText);
            this.jobDegreeText = view.findViewById(R.id.jobDegreeText);
        }

        public TextView getJobCityText() {
            return jobCityText;
        }

        public TextView getJobDegreeText() {
            return jobDegreeText;
        }

        public TextView getJobSalaryText() {
            return jobSalaryText;
        }

        public TextView getJobTitleText() {
            return jobTitleText;
        }

        public TextView getJobYearText() {
            return jobYearText;
        }
    }
}

