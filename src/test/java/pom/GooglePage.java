package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import util.Hook;
import util.Tools;

import java.util.List;

import static util.Tools.*;

public class GooglePage {
    public GooglePage() {
        PageFactory.initElements(Hook.getDriver(), this);
    }

    @FindBy(how = How.NAME, using = "q")
    private WebElement searchInput;

    @FindBy(how = How.ID, using = "hdtb-tls")
    private WebElement ferramentas;

    @FindBy(how = How.XPATH, using = "//*[@id='hdtbMenus']/div/div[@aria-label='Em qualquer data']")
    private WebElement menuDate;

    @FindBy(how = How.CLASS_NAME, using = "hdtb-mn-hd hdtb-tsel")
    private WebElement menuDateSelected;

    @FindBy(how = How.XPATH, using = "//*[@id='qdr_w']/a")
    private WebElement lastWeek;

    @FindBy(how = How.ID, using = "cdrlnk")
    private WebElement selectorIntervalo;

    @FindBy(how = How.ID, using = "hdtbMenus")
    private WebElement subMenus;

    @FindBy(how = How.ID, using = "cdr_min")
    private WebElement startDate;
    @FindBy(how = How.ID, using = "cdr_max")
    private WebElement endDate;
    @FindBy(how = How.XPATH, using = "//*[@id='cdr_frm']/input[@type='submit']")
    private WebElement submitIntervalo;
    @FindBy(how = How.XPATH, using = "//*[@id='hdtbMenus']/div/div[@class='hdtb-mn-hd hdtb-tsel']/div")
    private WebElement searchedDate;

    public WebElement inputSearch(String text){
        waitBy(searchInput).sendKeys(text);
        return searchInput;
    }
    private void clickInTools(){
        waitClickableBy(ferramentas).click();
    }
    public void clickInMenuDate(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitClickableBy(menuDate).click();
    }
    public void clickInLastWeek(){
        waitClickableBy(lastWeek).click();
    }
    public void selectIntervalo(){
        waitClickableBy(selectorIntervalo).click();
    }
    public void setIntervalo(String intervalo){
        List<String> dates = getDate(intervalo);
        waitBy(startDate).sendKeys(dates.get(0));
        waitBy(endDate).sendKeys(dates.get(1));
    }
    public void submitIntervalo() {
        waitBy(submitIntervalo).submit();
    }
    public String getSearchedDate(){
        return waitBy(searchedDate).getText();
    }

    public void accessMenuDate(){
        clickInTools();
        clickInMenuDate();
    }

}
