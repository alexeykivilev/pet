import models.user.UserClient;
import models.user.PageResponse;
import models.user.User;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import static models.user.UserClient.getUserByIdError;
import static models.user.UserClient.getUsersCountPerPage;

public class UserTest {

    @Test
    public void getSingleUserByIdSucessTest() {
        int expectedId = 1;
        User user = UserClient.getUserById(expectedId);
        Assert.assertEquals(user.getId().intValue(), expectedId);
    }

    @Test
    public void getUsersCountPerPageTest() {
        int expectedUserCountPerPage = 6;
        int page = 2;

        PageResponse response = getUsersCountPerPage(page);
        int actualUserCountPerPage = response.getPer_page();
        Assert.assertEquals(expectedUserCountPerPage, actualUserCountPerPage);
    }

    @Test
    public void getSingleUserByIdNotExistTest() {
        int nonExistentUserId = 13;
        User user = getUserByIdError(nonExistentUserId);
        Assert.assertNull("Пользователь существует", user);

    }

    @Test
    public void checkAvatarAndIdTest() {
        List<User> users = UserClient.getUsersListData();
        Assert.assertNotNull("Users data is not null", users);

        for (User user : users) {
            int userId = user.getId();
            String avatarUrl = user.getAvatar();
            Assert.assertTrue(avatarUrl.contains(String.valueOf(userId)));
        }

    }
}
