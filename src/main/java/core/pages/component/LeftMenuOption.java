package core.pages.component;

public enum LeftMenuOption {
    SEARCH("Search"), DASHBOARD("Dashboard"), AGING_REPORT("Aging Report"), TODO("To-Do"),
    COLLECTION_WORKFLOWS("Collection Workflows"), COMMUNICATIONS("Communications"), SETTINGS("Settings"),
    TUTORIALS("Tutorials");

    private String optionText;

    LeftMenuOption(String optionText){
        this.optionText = optionText;
    }

    public String optionText() {
        return optionText;
    }
}
