package models.register;

public class RegisterUnsuccess extends Register {
    private String email;

    public RegisterUnsuccess(String email) {
        super(email, null);
    }

    public RegisterUnsuccess() {
        super();
    }
}
