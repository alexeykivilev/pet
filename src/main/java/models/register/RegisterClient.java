package models.register;
import utils.Endpoints;
import utils.Specifications;

import static io.restassured.RestAssured.*;

public class RegisterClient {
    public RegisterResponse registerUser(String email, String password) {
        RegisterRequest registerRequest = new RegisterRequest(email, password);

        return given()
                .spec(Specifications.requestSpec(Endpoints.BASE_URL))
                .body(registerRequest)
                .when()
                .post(Endpoints.REGISTER_USER)
                .then().log().all()
                .spec(Specifications.responseSpecOK200())
                .extract()
                .as(RegisterResponse.class);
    }

    public void deleteUser(int userId) {
        given()
                .spec(Specifications.requestSpec(Endpoints.BASE_URL))
                .when()
                .delete(Endpoints.DELETE_USER + userId)
                .then().log().all()
                .spec(Specifications.responseSpecOK204());
    }

    public RegisterResponse registerUserUnsuccess(String email) {
        RegisterRequest registerRequest = new RegisterRequest(email, null);
        return given()
                .spec(Specifications.requestSpec(Endpoints.BASE_URL))
                .body(registerRequest)
                .when()
                .post(Endpoints.REGISTER_USER)
                .then().log().all()
                .spec(Specifications.responseSpecError400())
                .extract()
                .as(RegisterResponse.class);
    }
}
