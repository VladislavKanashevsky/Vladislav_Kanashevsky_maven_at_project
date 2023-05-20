package day21;

public class Search {

    public String user;

    boolean strict;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isStrict() {
        return strict;
    }

    public void setStrict(boolean strict) {
        this.strict = strict;
    }

    public Search(String user, boolean strict) {
        this.user = user;
        this.strict = strict;
    }
}
