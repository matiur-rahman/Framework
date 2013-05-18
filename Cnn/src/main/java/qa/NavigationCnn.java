package qa;

/**
 * Created with IntelliJ IDEA.
 * User: mrahman
 * Date: 4/26/13
 * Time: 11:28 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.Random;


import generic.BaseUtility;

import generic.SauceConnect;

public class NavigationCnn extends BaseUtility {

    public void clickOnMenu(String menuName){
        clickByCss("#nav-" + menuName);
    }

    public void newsItems(String locator){
        getWebElementsByCss(locator);
    }

    public void search(){
        typeByCss("#hdr-search-box", randomSearch());
        clickByCss(".ftr-search-sicon>input");
        //navigateBack();
    }

    public void search(String locator1){
        typeByCss(locator1, randomSearch());
        clickByCss(".search_icon");
        navigateBack();
    }

    public String randomSearch(){
        String[] words = new String[11];
        words[0] = "politics";
        words[1] = "Gap";
        words[2] = "Democrate";
        words[3] = "Money";
        words[4] = "like this topics";
        words[5] = "Africa";
        words[6] = "Sharing with my friends";
        words[7] = "Obama";
        words[8] = "Europe";
        words[9] = "World";
        words[10] = "Asia";
        String search = "";
        Random random = new Random();
        int randomWords = random.nextInt(10)+1;

        for(int index=0; index<11; index++){
            search = words[randomWords];
            randomWords = random.nextInt(10) + 1;
        }
        return search;
    }

}

