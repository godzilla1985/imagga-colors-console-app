package telran.java41.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ResultDto {

    @JsonAlias(value = "result")
    private ColorsDto colorsDto;

}
