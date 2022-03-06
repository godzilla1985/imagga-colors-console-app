package telran.java41.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ColorParentPercentageDto {

    @JsonAlias(value = "closest_palette_color")
    private String closestPaletteColor;

    @JsonAlias(value = "closest_palette_color_parent")
    private String closestPaletteColorParent;

    private Double percent;

}
