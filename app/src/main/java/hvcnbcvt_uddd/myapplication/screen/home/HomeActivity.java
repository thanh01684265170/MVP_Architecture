package hvcnbcvt_uddd.myapplication.screen.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hvcnbcvt_uddd.myapplication.R;
import hvcnbcvt_uddd.myapplication.data.model.User;
import hvcnbcvt_uddd.myapplication.data.repository.HomeRepository;
import hvcnbcvt_uddd.myapplication.data.source.local.HomeLocalDataSource;
import hvcnbcvt_uddd.myapplication.data.source.remote.HomeRemoteDataSource;
import hvcnbcvt_uddd.myapplication.screen.base.BaseActivity;

public class HomeActivity extends BaseActivity implements HomeContract.View, View.OnClickListener {
    private HomePresenter mPresenter;
    private ArrayList<User> mUsers;
    private RecyclerView mRecyclerView;
    private HomeAdapter mHomeAdapter;


    @Override
    protected int getLayoutResource() {
        return R.layout.activity_home;
    }

    @Override
    protected void initComponent() {
        findViewById(R.id.button_data).setOnClickListener(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mUsers = new ArrayList<>();
        mHomeAdapter = new HomeAdapter(mUsers, this);
        RecyclerView.LayoutManager layoutManager = new
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mHomeAdapter);
    }

    @Override
    protected void initData() {
        mPresenter = new HomePresenter(new HomeRepository(new HomeLocalDataSource(), new HomeRemoteDataSource()));
        mPresenter.setView(this);
    }

    @Override
    public void onGetUserFromDatabaseSuccess(List<User> users) {
        mUsers.addAll(users);
        mHomeAdapter.notifyDataSetChanged();
        Toast.makeText(this, R.string.msg_success, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        mPresenter.getUserFromDatabase();
    }
}
