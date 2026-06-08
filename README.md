# Library Book Issue System (SCD Project)

A Java Swing desktop application for basic library operations with:
- user sign-up
- user login
- book issue form handling with validation

This project is implemented as an Eclipse Java project inside `SwingDemo/`.

## Project Structure

- `SwingDemo/src`
  - `LoginFrame.java` – login screen and email/required-field checks
  - `SignUpFrame.java` – account creation screen and validations
  - `LibraryIssueFrame.java` – main issue-book form, date/order checks, category selection
  - `*Exception.java` – custom validation exceptions
  - `LibraryIssueFrameTest.java` – JUnit test file for basic validation logic
- `Document`
  - test-case document (`.docx`)

## Features

- Clean multi-screen Swing UI (Login, Sign Up, Book Issue)
- Required-field validation for forms
- Email format validation (`@` and `.` checks)
- Roll-number numeric validation
- Book-category selection validation
- Date parsing and return-date-after-issue-date validation (`YYYY-MM-DD`)
- Reset and exit actions in issue form

## Requirements

- Java JDK 8+ (JDK 11+ recommended)
- Eclipse IDE (optional, but project files are Eclipse-based)
- JUnit 5 (only if you want to compile/run `LibraryIssueFrameTest.java`)

## How to Run

### Option 1: Eclipse (recommended)

1. Open Eclipse.
2. Import existing project from:
   - `SwingDemo/`
3. Run `LoginFrame.java` (or `LibraryIssueFrame.java`) as a Java Application.

### Option 2: Command Line

From project root:

```bash
cd SwingDemo
javac src/EmptyFieldException.java src/InvalidDateException.java src/InvalidEmailException.java src/NullSelectionException.java src/LoginFrame.java src/SignUpFrame.java src/LibraryIssueFrame.java -d out
java -cp out LoginFrame
```

## Testing

`LibraryIssueFrameTest.java` uses JUnit 5 APIs.

To run tests, add JUnit 5 to your classpath/build tool first, then execute the test class from your IDE or test runner.

## Validation Rules Implemented

- No empty required fields
- Valid email format for login/sign-up
- Numeric roll number
- Non-default book category selection
- Valid ISO date format (`YYYY-MM-DD`)
- Return date cannot be before issue date

## Notes

- This project currently uses local UI logic only (no database integration).
- Password fields are currently plain text fields in UI logic.
