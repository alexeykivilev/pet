package clients;
import models.PageResponse;
import models.SingleUserResponse;
import models.User;
import utils.Endpoints;
import utils.Specifications;

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

}
