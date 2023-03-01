package zcorum;

public class DisplayNameMaker {

  private static final String DELIMITER = ", ";

  /**
   * Make display name as described below;
   * return lastName + ", " + first name - if both are available
   * return business name - if business name is available and firstname or last name is empty or null
   * return empty string - if all are empty or null
   */
  public String displayName(final String firstName, final String lastName, final String businessName) {

    if (isPresent(firstName) && isPresent(lastName)) {
      return lastName + DELIMITER + firstName;
    } else if (isPresent(businessName) && (!isPresent(firstName) || !isPresent(lastName))) {
      return businessName;
    }

    return "";
  }

  private boolean isPresent(final String param) {
    return param != null && !param.isBlank();
  }

}
