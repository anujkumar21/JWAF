package auto.testcases;
/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 21-May-18
 */

import auto.pages.DragAndDropPage;
import auto.pages.WelcomePage;
import auto.utility.Init;
import org.testng.annotations.Test;

public class TestDragAndDrop extends Init {

    @Test
    public void testDragAndDrop() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
        welcomePage.clickOnLink("Drag and Drop");

        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
        dragAndDropPage.verifyDragAndDropPageHeader();
        dragAndDropPage.dragAtoB();
    }
}
