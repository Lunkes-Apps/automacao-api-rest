package user.create;

import base.BaseTest;
import dto.User;
import org.testng.annotations.Test;
import utils.PatternsEnum;

import static client.users.ClientCreateUser.postCreateUser;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.matchesPattern;
import static utils.DateTimeMatcher.isDateTime;

public class CreateFunctionalTest extends BaseTest {

    @Test
    public void whenSendUserThenReturn201WithBody() {
        // Arrange
        User user = User.builder()
                .name("Alexandre")
                .job("Analista de Testes").build();

        // Act
        postCreateUser(user)

        // Assert
                .statusCode(201)
                .body("name", is(user.getName()),
                        "job", is(user.getJob()),
                        "id", matchesPattern(PatternsEnum.NUMBER.getPattern()),
                        "createdAt", isDateTime(PatternsEnum.INSTANTE_DATE_TIME.getPattern())
                );
    }

}
