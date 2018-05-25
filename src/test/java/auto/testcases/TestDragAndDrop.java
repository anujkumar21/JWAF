package auto.testcases;
/**
 * Created by: Anuj Kumar Email: cdac.anuj@gmail.com Date: 21-May-18
 */

import org.testng.annotations.Test;
import auto.pages.DragAndDropPage;
import auto.pages.WelcomePage;
import auto.utility.Init;

public class TestDragAndDrop extends Init {

  @Test
  public void testDragAndDrop() throws InterruptedException {

    WelcomePage welcomePage = new WelcomePage(driver);
    welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("Drag and Drop");

    DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
    dragAndDropPage.verifyDragAndDropPageHeader();
    dragAndDropPage.dragAtoB();
  }



}
