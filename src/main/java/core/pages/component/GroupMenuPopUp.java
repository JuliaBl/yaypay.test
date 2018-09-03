package core.pages.component;

public enum GroupMenuPopUp {
    CALL("Call"), EMAIL("Email");

    private String optionText;

    GroupMenuPopUp(String optionText){
     this.optionText = optionText;
    }

    public String optionText() {
        return optionText;
    }
}
