package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pom.GooglePage;
import util.Hook;
import util.Tools;
import static util.Tools.getDate;

public class PesquisaGoogleStep {
    GooglePage googlePage = new GooglePage();


    @Given("que estou na HomePage do Google")
    public void queEstouNaHomePageDoGoogle() {
        Assert.assertEquals("Google",
                Hook.getDriver().getTitle());
    }

    @When("pesquiso por {string}")
    public void pesquisoPor(String text) {
        googlePage.inputSearch(text).submit();
    }

    @And("seleciono intervalo {string}")
    public void selecionoIntervalo(String intervalo) {
        googlePage.accessMenuDate();
        if(intervalo.equals("Na última semana")){
            googlePage.clickInLastWeek();
        }else{

            googlePage.selectIntervalo();
            googlePage.setIntervalo(intervalo);
            googlePage.submitIntervalo();

        }
    }

    @Then("vejo o resultado com o intervalo {string}")
    public void vejoOResultadoComOIntervalo(String intervalo) {
        String actual = googlePage.getSearchedDate();
        String expected = intervalo;
        if(!intervalo.equals("Na última semana")){
            expected = "Antes de 9 de jan. de 2020";
        }

        Assert.assertEquals(expected, actual);
    }

}
