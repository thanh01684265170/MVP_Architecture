package hvcnbcvt_uddd.myapplication.data.repository;

import java.util.List;

import hvcnbcvt_uddd.myapplication.data.model.User;
import hvcnbcvt_uddd.myapplication.data.source.HomeDataSource;

public class HomeRepository implements HomeDataSource.Local, HomeDataSource.Remote {
    private HomeDataSource.Local mLocal;
    private HomeDataSource.Remote mRemote;

    public HomeRepository(HomeDataSource.Local local, HomeDataSource.Remote remote) {
        mLocal = local;
        mRemote = remote;
    }

    @Override
    public void getUserFromServer() {
        mRemote.getUserFromServer();
    }

    @Override
    public List<User> getUserFromDatabase() {
        return mLocal.getUserFromDatabase();
    }
}
