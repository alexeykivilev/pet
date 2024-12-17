package models.register;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterUnsuccess extends RegisterRequest {

    public RegisterUnsuccess(String email) {
        super(email, null);
    }

    public RegisterUnsuccess() {
        super();
    }
}
