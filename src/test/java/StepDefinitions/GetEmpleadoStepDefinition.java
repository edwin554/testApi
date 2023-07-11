package StepDefinitions;

import freemarker.core.ReturnInstruction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import org.ReqRest.Integrations.Api;
import org.ReqRest.Questions.CheckResponse;

public class GetEmpleadoStepDefinition {
    @Given("deseo obtener datos de un empleado con id")
    public void deseoObtenerDatosDeUnEmpleadoConId(io.cucumber.datatable.DataTable data) {
        OnStage.theActorInTheSpotlight().attemptsTo(Api.obtenerEmpleado(data));

    }
    @Then("valido el codigo de status {int}")
    public void validoElCodigoDeStatus(Integer codStatus) {
        OnStage.theActorInTheSpotlight().should(ResponseConsequence.seeThatResponse
                (validatableResponse -> validatableResponse.statusCode(codStatus)));

    }
    @Then("Verifico ID")
    public void verificoID() {
        OnStage.theActorInTheSpotlight().should(CheckResponse.checkId());
    }
    @Then("Verifico nombre")
    public void verificoNombre() {
        OnStage.theActorInTheSpotlight().should(CheckResponse.checkName());
       // String FirstName = OnStage.theActorInTheSpotlight().recall("User");
    //    return ResponseConsequence.seeThatResponse(response -> response.body("").equals(FirstName));
    }

}
