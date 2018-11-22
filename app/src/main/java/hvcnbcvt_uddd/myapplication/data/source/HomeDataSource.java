package hvcnbcvt_uddd.myapplication.data.source;

import java.util.List;

import hvcnbcvt_uddd.myapplication.data.model.User;

public interface HomeDataSource {
    interface Remote {
        void getUserFromServer();
    }

    interface Local {
        List<User> getUserFromDatabase();
    }
}
