package models.register;

public class RegisterResponse {
    private Integer id;
    private String token;
    private String error;

    public RegisterResponse(String token, Integer id) {
        this.token = token;
        this.id = id;
    }

    public RegisterResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
