import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class LibraryIssueFrameTest {

    @Test
    void testValidRollNumber() {

        int rn = Integer.parseInt("123");

        assertEquals(123, rn);
    }

    @Test
    void testInvalidRollNumber() {

        assertThrows(NumberFormatException.class, () -> {

            Integer.parseInt("ABC");
        });
    }

    @Test
    void testValidDateOrder() {

        LocalDate issueDate =
                LocalDate.parse("2025-06-01");

        LocalDate returnDate =
                LocalDate.parse("2025-06-10");

        assertFalse(
                returnDate.isBefore(issueDate));
    }

    @Test
    void testInvalidDateOrder() {

        LocalDate issueDate =
                LocalDate.parse("2025-06-10");

        LocalDate returnDate =
                LocalDate.parse("2025-06-01");

        assertTrue(
                returnDate.isBefore(issueDate));
    }

    @Test
    void testValidEmail() {

        String email = "student@gmail.com";

        assertTrue(
                email.contains("@")
                && email.contains("."));
    }

    @Test
    void testInvalidEmail() {

        String email = "studentgmailcom";

        assertFalse(
                email.contains("@")
                && email.contains("."));
    }
}