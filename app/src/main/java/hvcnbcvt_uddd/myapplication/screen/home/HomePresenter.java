package hvcnbcvt_uddd.myapplication.screen.home;

import hvcnbcvt_uddd.myapplication.data.repository.HomeRepository;

public class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View mView;
    private HomeRepository mRepository;

    public HomePresenter(HomeRepository repository) {
        mRepository = repository;
    }

    @Override
    public void setView(HomeContract.View view) {
        mView = view;
    }

    @Override
    public void getUserFromDatabase() {
        mView.onGetUserFromDatabaseSuccess(mRepository.getUserFromDatabase());
    }
}
