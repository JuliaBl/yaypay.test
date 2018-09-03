package core.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CollectionsWorkflowsPage {
    private static final By COLLECTION_WORKFLOWS_HEADER_LOCATOR = By.xpath("//div[@class='header']");
    private static final By REMOVE_TEMPLATE_POPUP_LOCATOR = By.xpath("//div[@class='kendo-popup k-window-content k-content']");
    private static final By REMOVE_TEMPLATE_REMOVE_BUTTON_LOCATOR = By.xpath("//a[@class='yaypay-btn js-remove-template']");
    private static final By NEW_WORKFLOW_LINK_LOCATOR = By.xpath("//a/span[contains(text(), 'New Workflow')]");

    public CollectionsWorkflowsPage() {
        $(COLLECTION_WORKFLOWS_HEADER_LOCATOR).shouldHave(Condition.text("Collection Workflows"));
    }

    public boolean isCustomWorkflowPresent(String option) {
        return $(By.xpath("//div[@class='template-header']//a[contains(text(), '" + option + "')]")).waitUntil(Condition.visible, 500).is(Condition.visible);
    }

    public WorkflowPage clickOnNewWorkflow() {
        $(NEW_WORKFLOW_LINK_LOCATOR).click();
        return new WorkflowPage();
    }

    public CollectionsWorkflowsPage deleteWorkflowByName(String option) {
        $(By.xpath("//a[@data-name='" + option + "']/i[contains(text(), 'delete')]")).click();
        $(REMOVE_TEMPLATE_POPUP_LOCATOR).waitUntil(visible, 500);
        $(REMOVE_TEMPLATE_POPUP_LOCATOR).find(REMOVE_TEMPLATE_REMOVE_BUTTON_LOCATOR).click();
        $(REMOVE_TEMPLATE_POPUP_LOCATOR).shouldNotBe(visible);
        $(By.xpath("//a[@data-name='" + option + "']")).shouldNotBe(visible);
        return this;
    }
}
