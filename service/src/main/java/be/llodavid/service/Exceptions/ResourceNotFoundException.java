package be.llodavid.service.Exceptions;

public class ResourceNotFoundException extends FuniversityException {
    public ResourceNotFoundException(String field, String resource) {
        super(String.format("The %s could not be found based on the provided %s.", field, resource));
    }
}
