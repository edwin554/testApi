package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import org.ReqRest.Integrations.Api;

public class StepDefinitionPut {


    @Given("actualizar data de empleados")
    public void actualizarDataDeEmpleados(io.cucumber.datatable.DataTable data) {
        OnStage.theActorInTheSpotlight().attemptsTo(Api.ActualizarUsuario(data));
    }
    @Then("se verifica codigos de respuesta {int}")
    public void seVerificaCodigosDeRespuesta(Integer int1) {
        OnStage.theActorInTheSpotlight().should(ResponseConsequence.seeThatResponse(
                validatableResponse -> validatableResponse.statusCode(int1)));
    }
}
