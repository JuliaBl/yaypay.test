package uiTests;

import core.pages.CollectionsWorkflowsPage;
import core.pages.LoginPage;
import core.pages.component.GroupMenuPopUp;
import core.pages.component.LeftMenuOption;
import core.utils.prop.Config;
import core.utils.DateFormat;
import core.utils.Listener;
import core.utils.prop.PropertiesLoader;
import io.qameta.allure.TmsLink;
import org.testng.annotations.*;
import static core.pages.component.LeftMenu.openMenuItem;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@Listeners(Listener.class)
public class CollectionWorkflowsTest extends BaseTest {
    private static final Config config = PropertiesLoader.getConfig();
    private LoginPage loginPage;
    private CollectionsWorkflowsPage collectionsWorkflowsPage;
    private String workflowName;

    @BeforeClass
    public void setUp() {
        loginPage = new LoginPage();
    }

    @BeforeMethod
    public void setUpForTest() {
        workflowName = "MyFlow_" + DateFormat.getDateFormatNow();
    }

    @AfterMethod
    public void cleanUpData() {
    openMenuItem(LeftMenuOption.COLLECTION_WORKFLOWS, CollectionsWorkflowsPage.class)
                .deleteWorkflowByName(workflowName);

    }

    @TmsLink("Jira-009")
    @Test
    public void testCanVerifyCollectionWorkflow() {
        loginPage
                .open()
                .tryLoginAs(config.getUserName(), config.getUserPassword());

        openMenuItem(LeftMenuOption.COLLECTION_WORKFLOWS, CollectionsWorkflowsPage.class)
                .clickOnNewWorkflow()
                .editWorflowsName(workflowName)
                .inputHourInSendingTime(DateFormat.getHourFormatNowHours())
                .inputTimeZoneInSendingTime(DateFormat.getTimeZone())
                .addRemainderBlockByName(GroupMenuPopUp.CALL)
                .setSendingDateTimeInBlockByName(GroupMenuPopUp.CALL, "5")
                .setRepeatOptionInBlockByName(GroupMenuPopUp.CALL)
                .addRemainderBlockByName(GroupMenuPopUp.EMAIL)
                .setSendingDateTimeInBlockByName(GroupMenuPopUp.EMAIL, "7")
                .checkCheckboxAttachOpenInvoicePDFsInEmailBlock()
                .inputSendEmailTo("Sales", "AR Manager")
                .selectEmailTemplate("Automated email reminder")
                .clickOnSaveButton();
        collectionsWorkflowsPage =
                openMenuItem(LeftMenuOption.COLLECTION_WORKFLOWS, CollectionsWorkflowsPage.class);
        assertThat(collectionsWorkflowsPage.isCustomWorkflowPresent(workflowName), equalTo(true));
    }
}
