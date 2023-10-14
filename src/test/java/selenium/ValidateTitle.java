package selenium;

import config.SetupDriver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidateTitle extends SetupDriver {
    @Test
    public void validateTitle() {
        assertEquals("Swag Labs", this.getCurrentTitle());
    }
}
