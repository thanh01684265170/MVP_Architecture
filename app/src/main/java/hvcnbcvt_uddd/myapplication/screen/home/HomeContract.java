package hvcnbcvt_uddd.myapplication.screen.home;

import java.util.List;

import hvcnbcvt_uddd.myapplication.data.model.User;
import hvcnbcvt_uddd.myapplication.screen.base.BasePresenter;

public interface HomeContract {
    interface View {
        void onGetUserFromDatabaseSuccess(List<User> users);
    }

    interface Presenter extends BasePresenter<View> {
        void getUserFromDatabase();
    }
}
