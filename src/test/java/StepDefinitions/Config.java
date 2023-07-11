package StepDefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.core.annotations.events.AfterScenario;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static jdk.javadoc.doclet.DocletEnvironment.ModuleMode.API;

public class Config {
    static EnvironmentVariables environmentVariables;
    @Before
    public void init(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Cliente");
        String baseUrl = environmentVariables.optionalProperty("API.reqres").orElse("https://reqres.in/api");
        OnStage.theActorInTheSpotlight().whoCan(CallAnApi.at(baseUrl));
    }
    @AfterScenario
    public void printResponse() {
        SerenityRest.lastResponse().body().prettyPrint();
        SerenityRest.reset();
    }
}
