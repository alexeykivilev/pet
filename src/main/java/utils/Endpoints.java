package utils;

public class Endpoints {
    public static final String BASE_URL = "https://reqres.in/"; //GET
    public static final String SINGLE_USER = "/api/users/"; //GET
    public static final String LIST_USERS = "/api/users?page=2"; //GET
    public static final String SINGLE_USER_NOT_FOUND = "/api/users/23"; //GET
    public static final String CREATE_USER = "/api/users"; //POST
    public static final String UPDATE_USER = "/api/users/1"; //PUT
    public static final String DELETE_USER = "/api/users/1"; //DELETE
    public static final String REGISTER_USER = "/api/register"; //POST
    public static final String LOGIN = "/api/login"; //POST
}
