import utils.Endpoints;
import utils.Specifications;
import org.junit.Assert;
import org.junit.Test;
import models.register.Register;
import models.register.RegisterResponse;
import models.register.RegisterUnsuccess;

import static io.restassured.RestAssured.*;

public class RegisterTest {

    @Test
    public void registerSuccessTest() {
        Specifications.installSpecification(Specifications.requestSpec(Endpoints.BASE_URL), Specifications.responseSpecOK200());
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Register user = new Register("eve.holt@reqres.in", "pistol");
        RegisterResponse registerResponse = given()
                .body(user)
                .when()
                .post(Endpoints.REGISTER_USER)
                .then().log().all()
                .extract().as(RegisterResponse.class);
        Assert.assertEquals(id, registerResponse.getId());
        Assert.assertEquals(token, registerResponse.getToken());
    }

    @Test
    public void deleteUserSuccess() {
        Specifications.installSpecification(Specifications.requestSpec(Endpoints.BASE_URL), Specifications.responseSpecOK204());
        given()
                .when()
                .delete("api/users/4")
                .then().log().all();
    }

    @Test
    public void registerUnsuccessTest() {
        Specifications.installSpecification(Specifications.requestSpec(Endpoints.BASE_URL), Specifications.responseSpecError400());
        String error = "Missing password";
        RegisterUnsuccess user = new RegisterUnsuccess("eve.holt@reqres.in");
        RegisterResponse registerResponse = given()
                .body(user)
                .when()
                .post(Endpoints.REGISTER_USER)
                .then().log().all()
                .extract().as(RegisterResponse.class);
        Assert.assertEquals(error, registerResponse.getError());

    }
}
