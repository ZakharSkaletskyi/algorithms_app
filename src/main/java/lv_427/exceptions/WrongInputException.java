package lv_427.exceptions;

public class WrongInputException extends RuntimeException {

  public static final String WRONG_INPUT = "You can enter only numbers.";
  public static final String WRONG_LENGTH = "Your word too long";

  public WrongInputException(String message) {
    super(message);
  }
}
