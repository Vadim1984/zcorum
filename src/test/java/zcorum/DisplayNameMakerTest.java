package zcorum;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

class DisplayNameMakerTest {

  private final DisplayNameMaker testInstance = new DisplayNameMaker();

  @ParameterizedTest
  @CsvSource({",,",
              "'','',''"})
  void testWhenAllParamsAreNotPopulatedThenReturnEmptyString(final String firstName, final String lastName, final String businessName) {

    String actualName = testInstance.displayName(firstName, lastName, businessName);

    assertThat(actualName).isBlank();
  }

  @ParameterizedTest
  @NullSource
  @EmptySource
  void testWhenFirstNameAndLastNameArePresentAndBusinessNameIsNotPresentReturnExpectedString(final String businessName) {
    String firstName = "firstName";
    String lastName = "lastName";
    String expectedName = "lastName, firstName";

    String actualName = testInstance.displayName(firstName, lastName, businessName);

    assertThat(actualName).isEqualTo(expectedName);
  }

  @ParameterizedTest
  @NullSource
  @EmptySource
  void testWhenFirstNameIsPresentAndLastNameIsNotPresentAndBusinessNameIsPresentReturnBusinessName(final String lastName) {
    String firstName = "firstName";
    String businessName = "businessName";

    String actualName = testInstance.displayName(firstName, lastName, businessName);

    assertThat(actualName).isEqualTo(businessName);
  }

  @ParameterizedTest
  @NullSource
  @EmptySource
  void testWhenFirstNameIsNotPresentAndLastNameIsPresentAndBusinessNameIsPresentReturnBusinessName(final String firstName) {
    String lastName = "lastName";
    String businessName = "businessName";

    String actualName = testInstance.displayName(firstName, lastName, businessName);

    assertThat(actualName).isEqualTo(businessName);
  }
}
