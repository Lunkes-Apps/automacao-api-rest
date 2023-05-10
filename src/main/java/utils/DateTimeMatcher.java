package utils;

import lombok.Builder;
import lombok.Data;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

@Data
@Builder
public class DateTimeMatcher extends TypeSafeMatcher<String> {

    private String format;

    @Override
    protected boolean matchesSafely(String dateTime) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(format);
        try {
            dateFormat.parse(dateTime);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("verifica se um texto corresponde a um formato de data");
    }

    public static Matcher<String> isDateTime(String format) {
        return DateTimeMatcher.builder().format(format).build();
    }
}
