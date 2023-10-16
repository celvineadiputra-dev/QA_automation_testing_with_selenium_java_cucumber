package config.utils;

public class ConvertStringToKebabCase {
    private final String text;

    public ConvertStringToKebabCase(String input) {
        input = input.toLowerCase();
        text = input.replaceAll(" ", "-");
    }

    public String convert() {
        return text;
    }
}
