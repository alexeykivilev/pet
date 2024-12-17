import models.register.RegisterClient;
import utils.Endpoints;
import utils.Specifications;
import org.junit.Assert;
import org.junit.Test;
import models.register.RegisterRequest;
import models.register.RegisterResponse;
import models.register.RegisterUnsuccess;

import static io.restassured.RestAssured.*;

public class RegisterTest {

    @Test
    public void registerSuccessTest() {
        Integer expectedId = 4;
        String expectedToken = "QpwL5tke4Pnpja7X4";
        RegisterClient client = new RegisterClient();
        RegisterResponse registerResponse = client.registerUser("eve.holt@reqres.in", "pistol");
        Assert.assertEquals(expectedId, registerResponse.getId());
        Assert.assertEquals(expectedToken, registerResponse.getToken());
    }

    @Test
    public void deleteUserSuccess() {
        int userId = 4;
        RegisterClient client = new RegisterClient();
        client.deleteUser(userId);
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
