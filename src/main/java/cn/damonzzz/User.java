package cn.damonzzz;

public class User {
    private String name;
    private String pwd;

    public User() {
    }

    ;

    public User(String Name, String Pwd) {
        name = Name;
        pwd = Pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return name + ":" + pwd;
    }
}
