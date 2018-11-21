package hvcnbcvt_uddd.myapplication.data.source.local;

import java.util.ArrayList;
import java.util.List;

import hvcnbcvt_uddd.myapplication.data.model.Name;
import hvcnbcvt_uddd.myapplication.data.source.HomeDataSource;

public class HomeLocalDataSource implements HomeDataSource.Local {

    @Override
    public List<Name> getUserFromDatabase() {
        List<Name> listName = new ArrayList<>();
        for (int i = 0 ; i < 5; i++){
            Name name = new Name("ThanhPQ");
            listName.add(name);
        }
        return listName;
    }
}
