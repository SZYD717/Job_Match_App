package edu.comp7506.jobMatchApp.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import android.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.job_match_app.R;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import edu.comp7506.jobMatchApp.VO.HomepageVO;
import edu.comp7506.jobMatchApp.adapter.HomepageJobListAdapter;
import edu.comp7506.jobMatchApp.model.Job;
import edu.comp7506.jobMatchApp.service.HomeService;

public class HomeFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        SearchView searchView = view.findViewById(R.id.home_search);
        SwipeRefreshLayout swipeRefreshLayout = view.findViewById(R.id.layout_swipe_refresh);
        RecyclerView recyclerView = view.findViewById(R.id.home_recyclerView);
        HomeService homeService = new HomeService();
        FutureTask<List<HomepageVO>> homeJobTask = new FutureTask<>(homeService);
        Thread t = new Thread(homeJobTask);
        t.start();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    FutureTask<List<HomepageVO>> temp_homeJobTask = new FutureTask<>(homeService);
                    Thread temp_t = new Thread(temp_homeJobTask);
                    temp_t.start();
                    HomepageJobListAdapter temp_adapter = new HomepageJobListAdapter(temp_homeJobTask.get());
                    recyclerView.setAdapter(temp_adapter);
                    temp_adapter.notifyDataSetChanged();
                    swipeRefreshLayout.setRefreshing(false);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        //滚动表单
        try {
            HomepageJobListAdapter adapter = new HomepageJobListAdapter(homeJobTask.get());
            recyclerView.setAdapter(adapter);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return view;
    }
}