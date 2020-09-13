package global.citytech.pattern.builder;

import java.util.List;

/**
 * Concrete Builder build Geek component.
 **/
public class GeekBuilder implements Builder {

    private String type;
    private List<String> languages;
    private int experience;

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    @Override
    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Geek getResult() {
        // write your code here ...
        return new Geek(type, languages, experience);
    }
}
