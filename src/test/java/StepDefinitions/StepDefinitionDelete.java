package StepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import org.ReqRest.Integrations.Api;
import org.apache.commons.lang3.RandomUtils;

import java.util.Random;

public class StepDefinitionDelete {
    @Given("Eliminar registro de empleado {int}")
    public void eliminarRegistroDeEmpleado(int int1) {
        OnStage.theActorInTheSpotlight().attemptsTo(Api.EliminarUsuario(int1));
    }
    @Then("validar codigo de status {int}")
    public void validarCodigoDeStatus(Integer code) {
        OnStage.theActorInTheSpotlight().should(ResponseConsequence.seeThatResponse(validatableResponse ->
                validatableResponse.statusCode(code)));
    }
}
