package tests;

import com.intuit.karate.junit5.Karate;

public class PetstoreTestRunner {
    @Karate.Test
    Karate testSample() {
        return Karate.run("Petstore").relativeTo(getClass());
    }
}