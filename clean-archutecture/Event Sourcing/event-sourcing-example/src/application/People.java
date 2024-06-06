package application;

public class People {
    private final String type;
    private final String data;

    public People(String type, String data) {
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public String getData() {
        return data;
    }
}

