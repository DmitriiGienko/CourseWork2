package Tasks;

public enum Type {
    WORK("Рабочая заметка"),
    PERSONAL("Личная заметка");
    private final String type;

    Type(String type) {
        this.type = type;
    }

    public String printType() {
        return type;
    }

}
