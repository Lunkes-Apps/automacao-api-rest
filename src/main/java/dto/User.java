package dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {
    String name;
    String job;
}
