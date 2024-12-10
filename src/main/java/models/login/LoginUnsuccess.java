package models.login;

public class LoginUnsuccess extends Login {
    private String error;

    public LoginUnsuccess(String email, String password) {
        super(email, password);
    }

    public LoginUnsuccess() {
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
