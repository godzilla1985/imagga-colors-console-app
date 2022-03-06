package telran.java41.dto;


import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@ToString
public class BackForImageColorsDto {

    @JsonAlias(value = "background_colors")
    private ArrayList<ColorParentPercentageDto> backgroundsColors;

    @JsonAlias(value = "foreground_colors")
    private ArrayList<ColorParentPercentageDto> foregroundColors;

    @JsonAlias(value = "image_colors")
    private ArrayList<ColorParentPercentageDto> imageColors;


}
