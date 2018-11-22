package hvcnbcvt_uddd.myapplication.data.source.local;

import java.util.ArrayList;
import java.util.List;

import hvcnbcvt_uddd.myapplication.data.model.User;
import hvcnbcvt_uddd.myapplication.data.source.HomeDataSource;

public class HomeLocalDataSource implements HomeDataSource.Local {

    @Override
    public List<User> getUserFromDatabase() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User("ThanhPQ");
            users.add(user);
        }
        return users;
    }
}
