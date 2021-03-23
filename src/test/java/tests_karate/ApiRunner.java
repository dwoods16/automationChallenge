package tests_karate;

import com.intuit.karate.junit5.Karate;

public class ApiRunner {
    @Karate.Test
    Karate test() {
        return Karate.run("classpath:tests_karate").tags("@api").relativeTo(getClass());
    }
}
