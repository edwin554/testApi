package org.ReqRest.Utils;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;

import java.util.Locale;

public class GeneradorData {
    public GeneradorData() {
    }

    public static Person getPerson() {
        com.devskiller.jfairy.Fairy fairy = Fairy.create(Locale.forLanguageTag("es"));
        return fairy.person();
    }
}
