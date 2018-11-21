package hvcnbcvt_uddd.myapplication.data.model;

public class Name {
    private String Name;

    public Name() {
    }

    public Name(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return  Name +'\n';
    }
}
