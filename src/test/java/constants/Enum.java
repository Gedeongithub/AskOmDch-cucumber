package constants;

public enum Enum {
    STORE("/store"),
    ACCOUNT("/account");

    public final String url;

    Enum(String url) {
        this.url = url;
    }
}
