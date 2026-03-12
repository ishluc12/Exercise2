package constants;

public enum EndPoint {
    HOME("/"),
    LOGIN("/auth/login"),
    REGISTER("/auth/register");

    public final String path;
    EndPoint(String path) {
        this.path = path;
    }
}
