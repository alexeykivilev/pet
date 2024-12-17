package models.register;

public class RegisterUnsuccess extends RegisterRequest {

    public RegisterUnsuccess(String email) {
        super(email, null);
    }

    public RegisterUnsuccess() {
        super();
    }
}
