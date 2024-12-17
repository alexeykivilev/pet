import models.register.RegisterClient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import models.register.RegisterResponse;

public class RegisterTest {
    private RegisterClient client;

    @Before
    public void setUp() {
        client = new RegisterClient();
    }

    @Test
    public void registerSuccessTest() {
        Integer expectedId = 4;
        String expectedToken = "QpwL5tke4Pnpja7X4";
        RegisterResponse registerResponse = client.registerUser("eve.holt@reqres.in", "pistol");
        Assert.assertEquals(expectedId, registerResponse.getId());
        Assert.assertEquals(expectedToken, registerResponse.getToken());
    }

    @Test
    public void deleteUserSuccess() {
        int userId = 4;
        client.deleteUser(userId);
    }

    @Test
    public void registerUnsuccessTest() {
        String expectedErrorText = "Missing password";
        RegisterResponse registerResponse = client.registerUserUnsuccess("eve.holt@reqres.in");
        Assert.assertEquals(expectedErrorText, registerResponse.getError());
    }
}
