package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import org.ReqRest.Integrations.Api;
import org.ReqRest.Questions.ValidoUsuarioCreado;
import org.ReqRest.Task.CrearEmpleadoRandom;

public class StepDefinitionsPost {
    @Given("crear usuario con data random")
    public void crearUsuarioConDataRandom() {
        OnStage.theActorInTheSpotlight().attemptsTo(CrearEmpleadoRandom.dataEmpleado());
    }
    @When("crear usuario")
    public void crearUsuario() {
        OnStage.theActorInTheSpotlight().attemptsTo(Api.createEmployee());
    }
    @Then("verifico que se cree usuario")
    public void verificoQueSeCreeUsuario() {
        OnStage.theActorInTheSpotlight().should(ValidoUsuarioCreado.ValidoUsuarioCreado());
    }
    @Then("se verifica codigo de respuesta {int}")
    public void seVerificaCodigoDeRespuesta(int codigo) {
        OnStage.theActorInTheSpotlight().should(ResponseConsequence.seeThatResponse
                (validatableResponse -> validatableResponse.statusCode(codigo)));
    }

}
