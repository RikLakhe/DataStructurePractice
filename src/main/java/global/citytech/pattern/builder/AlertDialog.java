package global.citytech.pattern.builder;

/*
adv
separates complex object construction from its representation
dis
It complicates the code due to the introduction of additional classes
 */
public class AlertDialog {
    private String title;
    private String text;
    private String applyButton;
    private String cancelButton;

    private AlertDialog(String title, String text, String applyButton, String cancelButton) {
        this.title = title;
        this.text = text;
        this.applyButton = applyButton;
        this.cancelButton = cancelButton;
    }

    public AlertDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public AlertDialog setText(String text) {
        this.text = text;
        return this;
    }

    public AlertDialog setApplyButton(String applyButton) {
        this.applyButton = applyButton;
        return this;
    }

    public AlertDialog setCancelButton(String cancelButton) {
        this.cancelButton = cancelButton;
        return this;
    }

    @Override
    public String toString() {
        String str = "";
        if (title != null) {
            str += "The title is: \"" + title + "\"\n";
        }
        if (text != null) {
            str += "The text is: \"" + text + "\"\n";
        }
        if (applyButton != null) {
            str += "The applyButton is: \"" + applyButton + "\"\n";
        }
        if (cancelButton != null) {
            str += "The cancelButton is: \"" + cancelButton + "\"\n";
        }

        return str;
    }

    static class Builder {
        private String title;
        private String text;
        private String applyButton;
        private String cancelButton;

        Builder() {}

        Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        Builder setText(String text) {
            this.text = text;
            return this;
        }

        Builder setApplyButton(String applyButton) {
            this.applyButton = applyButton;
            return this;
        }

        Builder setCancelButton(String cancelButton) {
            this.cancelButton = cancelButton;
            return this;
        }

        AlertDialog build() {
            return new AlertDialog(title, text, applyButton, cancelButton);
        }
    }
}