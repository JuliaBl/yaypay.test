package core.pages;

import com.codeborne.selenide.Condition;
import core.pages.component.GroupMenuPopUp;
import org.openqa.selenium.By;
import java.util.Arrays;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Condition.*;

public class WorkflowPage extends CollectionsWorkflowsPage {
    private static final By EDIT_TEMPLATE_BUTTON_LOCATOR = By.xpath("//div[@class='template-name js-template-name']//i");
    private static final By EDIT_TEMPLATE_INPUT_LOCATOR = By.xpath("//input[@type='text']");
    private static final By SAVE_TEMPLATE_BUTTON_LOCATOR = By.xpath("//i[@class='material-icons js-save-template-name']");
    private static final By SENDING_TIME_HOUR_DROPDOWN_LOCATOR = By.xpath("//div[@class='invoices-time']/span[contains(@class, 'js-invoice-hour-input')]");
    private static final By SENDING_TIME_INPUT_HOUR_INPUT_LOCATOR = By.xpath(".//div[@id='template-hour-list']//input[@class='k-textbox']");
    private static final By SENDING_TIME_INPUT_TIME_ZONE_LOCATOR = By.xpath(".//div[@id='template-timezone-list']//input[@class='k-textbox']");
    private static final By SENDING_TIME_ZONE_DROPDOWN_LOCATOR = By.xpath("//div[@class='invoices-time']/span[contains(@class, 'js-invoice-timezone-input')]");
    private static final By SENDING_TIME_OPTION_HOUR_LOCATOR = By.xpath("//ul[@id='template-hour_listbox']/li[@role='option']");
    private static final By SENDING_TIME_OPTION_ZONE_LOCATOR = By.xpath("//ul[@id='template-timezone_listbox']/li[@role='option']");
    private static final By REMAINDER_CREATION_BLOCK_LOCATOR = By.xpath("//div[@class='js-remainder-creation-block']//ul[contains(@class, 'add-menu')]");
    private static final By EMAIL_BLOCK_LOCATOR = By.xpath("//div[@class='wrap-action-block  creation type-email']");
    private static final By EMAIL_CALL_TIME_INPUT_LOCATOR = By.xpath("//input[@type='number']");
    private static final By CALL_BLOCK_LOCATOR = By.xpath("//div[@class='wrap-action-block  creation type-call']");
    private static final By REPEAT_OPTION_BLOCKS_LOCATOR = By.xpath("//input[@class='js-repeat']/following-sibling::i");
    private static final By REPEAT_INPUT_IN_BLOCK_LOCATOR = By.xpath("//input[@class='sub js-repeat-days add-numbers-max']");
    private static final By ATTACH_OPEN_INVOICE_PDF_CHECKBOX_LOCKATOR = By.xpath("//span[contains(text(), 'Attach open invoice PDFs')]/preceding-sibling::input[@class='js-attach-invoices']");
    private static final By SEND_EMAIL_PARAMS_BLOCK_LOCATOR = By.xpath("//div[@class='params-block js-params-block']");
    private static final By SEND_EMAIL_INPUT_LOCATOR = By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
    private static final By MULTI_SELECT_ROLE_LIST_EMAIL_BLOCK_LOCATOR = By.xpath("//ul[@id='js-multiselect-role_listbox']");
    private static final By EMAIL_TEMPLATE_DROPDOWN_LOCATOR = By.xpath("//span[contains(@class, 'js-email-template-select')]//span[contains(@class, 'k-dropdown-wrap k-state-default')]");
    private static final By SAVE_BUTTON_LOCATOR = By.xpath("//a[@class='save js-save-template-btn']");

    public WorkflowPage editWorflowsName(String option) {
        $(EDIT_TEMPLATE_BUTTON_LOCATOR).click();
        $(EDIT_TEMPLATE_INPUT_LOCATOR).val(option);
        $(SAVE_TEMPLATE_BUTTON_LOCATOR).click();
        $(SAVE_TEMPLATE_BUTTON_LOCATOR).shouldNot(visible);
        return this;
    }


    public WorkflowPage inputHourInSendingTime(String option) {
        $(SENDING_TIME_HOUR_DROPDOWN_LOCATOR).click();
        $(SENDING_TIME_INPUT_HOUR_INPUT_LOCATOR).waitUntil(visible, 1000).val(option);
        $$(SENDING_TIME_OPTION_HOUR_LOCATOR).find(text(option)).click();
        return this;
    }

    public WorkflowPage inputTimeZoneInSendingTime(String option) {
        $(SENDING_TIME_ZONE_DROPDOWN_LOCATOR).click();
        $(SENDING_TIME_INPUT_TIME_ZONE_LOCATOR).waitUntil(visible, 1000).val(option);
        $$(SENDING_TIME_OPTION_ZONE_LOCATOR).find(text(option)).click();
        return this;
    }

    public WorkflowPage addRemainderBlockByName(GroupMenuPopUp groupMenuPopUp) {
        $(REMAINDER_CREATION_BLOCK_LOCATOR).click();
        $(By.xpath("//li[contains(@class, '"+groupMenuPopUp.optionText().toLowerCase()+" k-item k-state-default')]")).waitUntil(Condition.visible, 1000).click();
        return this;
    }

    public WorkflowPage setSendingDateTimeInBlockByName(GroupMenuPopUp groupMenuPopUp, String option) {
        $(By.xpath("//div[@class='wrap-action-block  creation type-"+groupMenuPopUp.optionText().toLowerCase()+"']"))
                .find(EMAIL_CALL_TIME_INPUT_LOCATOR).val(option);
        return this;
    }

    public WorkflowPage setRepeatOptionInBlockByName(GroupMenuPopUp groupMenuPopUp) {
        $(By.xpath("//div[@class='wrap-action-block  creation type-"+groupMenuPopUp.optionText().toLowerCase()+"']"))
                .find(REPEAT_OPTION_BLOCKS_LOCATOR).click();
        $(By.xpath("//div[@class='wrap-action-block  creation type-"+groupMenuPopUp.optionText().toLowerCase()+"']"))
                .find(REPEAT_INPUT_IN_BLOCK_LOCATOR).shouldBe(visible);
        return this;
    }

    public WorkflowPage checkCheckboxAttachOpenInvoicePDFsInEmailBlock() {
        $(EMAIL_BLOCK_LOCATOR).find(ATTACH_OPEN_INVOICE_PDF_CHECKBOX_LOCKATOR).click();
        $(SEND_EMAIL_PARAMS_BLOCK_LOCATOR).waitUntil(Condition.visible, 500);
        return this;
    }

    public WorkflowPage inputSendEmailTo(String ...option) {
        Arrays.asList(option).stream()
                .forEach(el -> {
                    $(SEND_EMAIL_PARAMS_BLOCK_LOCATOR).find(SEND_EMAIL_INPUT_LOCATOR).click();
                    $(MULTI_SELECT_ROLE_LIST_EMAIL_BLOCK_LOCATOR).waitUntil(visible, 500);
                    $(MULTI_SELECT_ROLE_LIST_EMAIL_BLOCK_LOCATOR).find(By.xpath("//span[@data-text='" + el + "']")).click();
                    $(MULTI_SELECT_ROLE_LIST_EMAIL_BLOCK_LOCATOR).shouldNot(visible);
                });
        return this;
    }

    public WorkflowPage selectEmailTemplate(String option) {
        $(SEND_EMAIL_PARAMS_BLOCK_LOCATOR).$(EMAIL_TEMPLATE_DROPDOWN_LOCATOR).click();
        if($(By.xpath("//li[contains(text(), '"+option+"')]")).is(not(visible))){
            $(SEND_EMAIL_PARAMS_BLOCK_LOCATOR).$(EMAIL_TEMPLATE_DROPDOWN_LOCATOR).click();
        }
        $(By.xpath("//li[contains(text(), '"+option+"')]")).click();
        return this;
    }

    public WorkflowPage clickOnSaveButton() {
        $(SAVE_BUTTON_LOCATOR).click();
        $(SAVE_BUTTON_LOCATOR).shouldNot(visible);
        return this;
    }
}
