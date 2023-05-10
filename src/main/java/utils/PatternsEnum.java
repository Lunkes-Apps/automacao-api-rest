package utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PatternsEnum {
    INSTANTE_DATE_TIME("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"),
    NUMBER("\\d+");

    String pattern;
}
