package fri.sidney.easyexpress.entity;

public class ExpressInfo {
    private int icon;
    private String name;
    private boolean achievement;

    public ExpressInfo(int icon, String name, boolean achievement) {
        this.icon = icon;
        this.name = name;
        this.achievement = achievement;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAchievement() {
        return achievement;
    }

    public void setAchievement(boolean achievement) {
        this.achievement = achievement;
    }

    @Override
    public String toString() {
        return "ExpressInfo{" +
                "icon=" + icon +
                ", name='" + name + '\'' +
                ", achievement=" + achievement +
                '}';
    }
}
