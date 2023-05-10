package client.users;

import client.base.BaseClient;
import dto.User;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class ClientCreateUser extends BaseClient {

    public static String PATH_CONTRACT_CREATE_USER = "src/main/resources/contracts/user/contract-create-return.json";

    public static ValidatableResponse postCreateUser(User user) {
        return given()
                .spec(getSpec())
                .body(user)
                .post("/users")
                .then();
    }

}
