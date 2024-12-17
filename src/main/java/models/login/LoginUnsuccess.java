package models.login;

public class LoginUnsuccess extends LoginRequest {
    private String error;

    public LoginUnsuccess(String email) {
        super(email, null);
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
