package hvcnbcvt_uddd.myapplication.data.source;

import java.util.List;
import hvcnbcvt_uddd.myapplication.data.model.Name;

public interface HomeDataSource {
    interface Remote {
        void getUserFromServer();
    }

    interface Local {
        List<Name> getUserFromDatabase();
    }
}
