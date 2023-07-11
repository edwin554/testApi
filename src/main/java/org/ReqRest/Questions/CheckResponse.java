package org.ReqRest.Questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import org.ReqRest.Models.CrearEmpleadoModels;

import static org.hamcrest.Matchers.*;

public class CheckResponse {

    public CheckResponse() {
    }
    public static Question<Boolean> statusCodeResponse(int statusCode) {
        return actor -> statusCode == SerenityRest.lastResponse().statusCode();
    }
    /*public static ResponseConsequence createEmployee() {
        CrearEmpleadoModels createEmployee = OnStage.theActorInTheSpotlight().recall("createObject");
        return ResponseConsequence.seeThatResponse(response -> response
                .statusCode(201));
    }*/
    public static ResponseConsequence checkName( ){
        String   nombreEmpleado = OnStage.theActorInTheSpotlight().recall("User");

        return ResponseConsequence.seeThatResponse(response -> response
                .body("data.first_name", equalTo(nombreEmpleado)));
    }
    public static ResponseConsequence checkId(){
        String   idUsuario = OnStage.theActorInTheSpotlight().recall("IdUser");
        System.out.println("idUsuario = " + idUsuario);
        return ResponseConsequence.seeThatResponse(response -> response
                .body("data.id",equalTo(Integer.parseInt(idUsuario))));
    }
}
