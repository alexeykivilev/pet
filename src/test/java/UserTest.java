import clients.UserClient;
import models.PageResponse;
import models.User;
import org.junit.Assert;
import org.junit.Test;
import static clients.UserClient.getUsersCountPerPage;

public class UserTest {

    @Test
    public void getSingleUserByIdSucessTest() {
        int expectedId = 1;
        User user = UserClient.getUserById(expectedId);
        Assert.assertEquals(user.getId().intValue(), (expectedId));
    }

    @Test
    public void getUsersCountPerPageTest() {
        int expectedUserCountPerPage = 6;
        int page = 2;

        PageResponse response = getUsersCountPerPage(page);
        int actualUserCountPerPage = response.getPer_page();
        Assert.assertEquals(expectedUserCountPerPage, actualUserCountPerPage);
    }
}
