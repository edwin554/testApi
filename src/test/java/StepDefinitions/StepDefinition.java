package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import org.ReqRest.Questions.ValidarLista;
import org.ReqRest.Task.Obtener;
import org.hamcrest.Matchers;

public class StepDefinition {
    @Given("quiero listar la informacion de usuarios")
    public void quieroListarLaInformacionDeUsuarios() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Obtener.listarUsuarios()
        );

    }

    @Then("verifico que se listen los usuarios")
    public void verificoQueSeListenLosUsuarios() {
        OnStage.theActorInTheSpotlight().should(ValidarLista.ValidarCampos());

    }
}
