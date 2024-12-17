package models.user;
import utils.Endpoints;
import utils.Specifications;
import java.util.List;
import static io.restassured.RestAssured.*;

public class UserClient {
    public static User getUserById(int id) {
        return given()
                .spec(Specifications.requestSpec(Endpoints.BASE_URL))
                .when()
                .get(Endpoints.SINGLE_USER + id)
                .then().log().all()
                .spec(Specifications.responseSpecOK200())
                .extract()
                .as(SingleUserResponse.class)
                .getData();
    }

    public static PageResponse getUsersCountPerPage(int page) {
        return  given()
                .spec(Specifications.requestSpec(Endpoints.BASE_URL))
                .when()
                .queryParam("page", page)
                .get(Endpoints.LIST_USERS)
                .then().log().all()
                .extract()
                .as(PageResponse.class);
    }

    public static User getUserByIdError(int id) {
        try {
            SingleUserResponse response = given()
                    .spec(Specifications.requestSpec(Endpoints.BASE_URL))
                    .when()
                    .get(Endpoints.SINGLE_USER + id)
                    .then().log().all()
                    .spec(Specifications.responseSpecError404()) // Ожидаем 404
                    .extract()
                    .as(SingleUserResponse.class);

            return response != null ? response.getData() : null;

        } catch (Exception e) {
            System.err.println("Ошибка при получении пользователя: " + e.getMessage());
            return null;
        }
    }

    public static List<User> getUsersListData() {
        return given()
                .spec(Specifications.requestSpec(Endpoints.BASE_URL))
                .when()
                .get(Endpoints.LIST_USERS)
                .then().log().all()
                .spec(Specifications.responseSpecOK200())
                .extract()
                .body()
                .jsonPath()
                .getList("data", User.class);
    }

}
