package org.ReqRest.Questions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import org.hamcrest.Matchers;

public class ValidarLista {
    public static ResponseConsequence ValidarCampos() {
        return ResponseConsequence.seeThatResponse(
                response -> response.statusCode(200).body("data.first_name", Matchers.hasItems("George","Eve"))
        );
    }
}
