package telran.java41.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ColorsDto{

    @JsonAlias("colors")
    private BackForImageColorsDto backForImageColorsDto;

}
