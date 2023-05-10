package user.create;

import base.BaseTest;
import dto.User;
import org.testng.annotations.Test;

import java.io.File;

import static client.users.ClientCreateUser.PATH_CONTRACT_CREATE_USER;
import static client.users.ClientCreateUser.postCreateUser;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class CreateContractTest extends BaseTest {

    @Test
    public void whenSendUserThenReturnWithCorrectContract() {
        // Arrange
        User user = User.builder()
                .name("Alexandre")
                .job("Analista de Testes").build();

        // Act
        postCreateUser(user)

                // Assert
                .statusCode(201)
                .body(matchesJsonSchema(new File(PATH_CONTRACT_CREATE_USER)));
    }
}
