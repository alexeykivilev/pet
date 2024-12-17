package models.login;

import utils.Endpoints;
import utils.Specifications;

import static io.restassured.RestAssured.*;

public class LoginClient {
    public LoginResponse loginUser(String email, String password) {
        LoginRequest loginRequest = new LoginRequest(email, password);

        return given()
                .spec(Specifications.requestSpec(Endpoints.BASE_URL))
                .body(loginRequest)
                .when()
                .post(Endpoints.LOGIN)
                .then().log().all()
                .spec(Specifications.responseSpecOK200())
                .extract()
                .as(LoginResponse.class);
    }

    public LoginResponse loginUserWrongPassword(String email) {
        LoginRequest loginRequest = new LoginRequest(email, null);

        return given()
                .spec(Specifications.requestSpec(Endpoints.BASE_URL))
                .body(loginRequest)
                .when()
                .post(Endpoints.LOGIN)
                .then().log().all()
                .spec(Specifications.responseSpecError400())
                .extract()
                .as(LoginResponse.class);
    }

    public LoginResponse loginUserWrongEmail(String password) {
        LoginRequest loginRequest = new LoginRequest(null,  password);

        return given()
                .spec(Specifications.requestSpec(Endpoints.BASE_URL))
                .body(loginRequest)
                .when()
                .post(Endpoints.LOGIN)
                .then().log().all()
                .spec(Specifications.responseSpecError400())
                .extract()
                .as(LoginResponse.class);
    }
}
