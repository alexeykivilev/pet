import models.login.LoginClient;
import models.login.LoginResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginTest {
    private LoginClient client;

    @Before
    public void setUp() {
        client = new LoginClient();
    }

    @Test
    public void loginSuccessTest() {
        String expectedToken = "QpwL5tke4Pnpja7X4";
        LoginResponse loginResponse = client.loginUser("eve.holt@reqres.in", "cityslicka");
        Assert.assertEquals(expectedToken, loginResponse.getToken());
    }

    @Test
    public void loginWrongPasswordTest() {
        String expectedError = "Missing password";
        LoginResponse loginResponse = client.loginUserWrongPassword("eve.holt@reqres.in");
        Assert.assertEquals(expectedError, loginResponse.getError());
    }

    @Test
    public void loginUnsuccessWrongEmailTest() {
        String error = "Missing email or username";
        LoginResponse loginResponse = client.loginUserWrongEmail("cityslicka");
        Assert.assertEquals(error, loginResponse.getError());
    }
}
