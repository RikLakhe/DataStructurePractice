package global.citytech.pattern.builder;

import java.util.ArrayList;

/**
 * Builder Director.
 */
public class GeekDirector {
    public void buildAdmin(Builder builder) {
        builder.setType("Admin");
        ArrayList<String> languages = new ArrayList<>();
        languages.add("Perl");
        languages.add("PowerShell");
        builder.setLanguages(languages);
        builder.setExperience(10);
    }

    public void buildRockstar(Builder builder) {
        builder.setType("Rockstar");
        ArrayList<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("Kotlin");
        languages.add("Scala");
        languages.add("Angular");
        builder.setLanguages(languages);
        builder.setExperience(20);
    }

    public void buildBackend(Builder builder) {
        builder.setType("Backend");
        ArrayList<String> languages = new ArrayList<>();
        languages.add("Python");
        languages.add("PHP");
        builder.setLanguages(languages);
        builder.setExperience(5);
    }
}
