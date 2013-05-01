package generic;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import qa.NavigationCnn;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mrahman
 * Date: 4/28/13
 * Time: 2:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class CnnHomePageRunAtSaucelabs extends NavigationCnn{

    @Test
   public void topNavigation() {
        waitUntil(By.cssSelector("#us-menu"));
    List<String> menuBar = getListOfTextByCss("#us-menu", "li");
    for(int i=1; i<menuBar.size(); i++){
        System.out.println(menuBar.get(i));
        String check;
        if(i==1){
            check = "video";
            clickOnMenu(check);
            search(".search_hint");
        }else if(i==2){
            waitUntil(By.cssSelector("#nav-trends"));
            check = "trends";
            clickOnMenu(check);
            search();
            navigateBack();
        }else if(i==3){
            check = "us";
            clickOnMenu(check);
            search();
            navigateBack();
        }else{
            check = menuBar.get(i).toLowerCase();
            clickOnMenu(check);
            //getWebElementsByCss("#cnn_mtt1rgtarea .cnn_bulletbin li");
            //search();
            navigateBack();
        }
    }
}

}
