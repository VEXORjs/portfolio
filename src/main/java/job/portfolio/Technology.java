package job.portfolio;

public class Technology {
    private final String name;
    private final String color;
    private final String iconClass;

    public Technology(String name, String color, String iconClass) {
        this.color = color;
        this.name = name;
        this.iconClass = iconClass;
    }
    public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
    public String getIconClass() {
        return iconClass;
    }
}
