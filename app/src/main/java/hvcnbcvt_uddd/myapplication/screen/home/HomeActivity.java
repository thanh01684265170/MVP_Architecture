package hvcnbcvt_uddd.myapplication.screen.home;


import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hvcnbcvt_uddd.myapplication.R;
import hvcnbcvt_uddd.myapplication.data.model.Name;
import hvcnbcvt_uddd.myapplication.data.repository.HomeRepository;
import hvcnbcvt_uddd.myapplication.data.source.local.HomeLocalDataSource;
import hvcnbcvt_uddd.myapplication.data.source.remote.HomeRemoteDataSource;
import hvcnbcvt_uddd.myapplication.screen.base.BaseActivity;

public class HomeActivity extends BaseActivity implements HomeContract.View, View.OnClickListener {
    private HomePresenter mPresenter;
    private ArrayAdapter<Name> mAdapter;
    private ArrayList<Name> mNames;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_home;
    }

    @Override
    protected void initComponent() {
        findViewById(R.id.btn_data).setOnClickListener(this);
        ListView listView = findViewById(R.id.listView);
        mNames = new ArrayList<>();
        mAdapter = new ArrayAdapter<Name>(this,android.R.layout.simple_list_item_1,mNames);
        listView.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        mPresenter = new HomePresenter(new HomeRepository(new HomeLocalDataSource(), new HomeRemoteDataSource()));
        mPresenter.setView(this);
    }

    @Override
    public void onGetUserFromDatabaseSuccess(List<Name> names) {
        mNames.addAll(names);
        mAdapter.notifyDataSetChanged();
        Toast.makeText(this, "Get data success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        mPresenter.getUserFromDatabase();
    }
}
