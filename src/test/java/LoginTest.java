import utils.Endpoints;
import utils.Specifications;
import models.login.Login;
import models.login.LoginResponse;
import models.login.LoginUnsuccess;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class LoginTest {

    @Test
    public void loginSuccessTest() {
        Specifications.installSpecification(Specifications.requestSpec(Endpoints.BASE_URL), Specifications.responseSpecOK200());
        String token = "QpwL5tke4Pnpja7X4";
        Login user = new Login("eve.holt@reqres.in", "cityslicka");
        LoginResponse loginResponse = given()
                .body(user)
                .when()
                .post(Endpoints.LOGIN)
                .then().log().all()
                .extract().as(LoginResponse.class);
        Assert.assertEquals(token, loginResponse.getToken());
    }

    @Test
    public void loginUnsuccessWrongPasswordTest() {
        Specifications.installSpecification(Specifications.requestSpec(Endpoints.BASE_URL), Specifications.responseSpecError400());
        String error = "Missing password";
        LoginUnsuccess user = new LoginUnsuccess("eve.holt@reqres.in", null);
        LoginResponse loginResponse = given()
                .body(user)
                .when()
                .post(Endpoints.LOGIN)
                .then().log().all()
                .extract().as(LoginResponse.class);
        Assert.assertEquals(error, loginResponse.getError());
    }

    @Test
    public void loginUnsuccessWrongEmailTest() {
        Specifications.installSpecification(Specifications.requestSpec(Endpoints.BASE_URL), Specifications.responseSpecError400());
        String error = "Missing email or username";
        LoginUnsuccess user = new LoginUnsuccess(null, "cityslicka");
        LoginResponse loginResponse = given()
                .body(user)
                .when()
                .post(Endpoints.LOGIN)
                .then().log().all()
                .extract().as(LoginResponse.class);
        Assert.assertEquals(error, loginResponse.getError());
    }
}
