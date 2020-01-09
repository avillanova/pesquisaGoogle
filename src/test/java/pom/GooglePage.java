package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import util.Hook;
import util.Tools;

import java.util.List;

import static util.Tools.getDate;
import static util.Tools.waitBy;

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

    @FindBy(how = How.XPATH, using = "//*[@id='hdtbMenus']/div/ul[2]")
    private WebElement dateMenuDown;

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

    @FindBy(how = How.XPATH, using = "//*[@class='hdtb-mitem hdtb-msel hdtb-imb']")
    private WebElement hidenLabel;

    public WebElement inputSearch(String text){
        waitBy(searchInput).sendKeys(text);
        return searchInput;
    }
    private void clickInTools(){
        waitBy(ferramentas).click();
    }
    private void clickInMenuDate(){
        waitBy(subMenus);
        waitBy(menuDate).click();
    }
    public void clickInLastWeek(){
        waitBy(dateMenuDown);
        waitBy(lastWeek).click();
    }
    public void selectIntervalo(){
        waitBy(selectorIntervalo).click();
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
