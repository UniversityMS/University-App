package lv.unversityManagementSystem.exception;

public class DataWithThisIdNotFoundException extends RuntimeException {
    public DataWithThisIdNotFoundException(String message) {
        super(message);
    }
}
