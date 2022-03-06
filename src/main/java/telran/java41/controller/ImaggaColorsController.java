package telran.java41.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import telran.java41.dto.ColorParentPercentageDto;
import telran.java41.dto.ResultDto;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ImaggaColorsController {

    static RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {

        String imageUrlParam = "https://i.ytimg.com/vi/QAOBbPnI5-g/maxresdefault.jpg";
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("https").host("api.imagga.com").path("/v2/colors").queryParam("image_url", imageUrlParam).build();

        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Basic YWNjX2UzOTM5OGZmNWJjMWQ0MzoxNzQyZjI2ODM2M2U1NTYyNjE4MDg2NDg2NGU1NzZhNQ==");

        RequestEntity<String> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, URI.create(uriComponents.toUriString()));

        ResponseEntity<ResultDto> responseEntity = restTemplate.exchange(requestEntity, ResultDto.class);

        ResultDto resultDto = responseEntity.getBody();

        printResultColors(getSingleList(resultDto));

    }

    static List<ColorParentPercentageDto> getSingleList(ResultDto resultDto) {
        return Stream.of(resultDto.getColorsDto().getBackForImageColorsDto().getBackgroundsColors(),
                resultDto.getColorsDto().getBackForImageColorsDto().getForegroundColors(),
                resultDto.getColorsDto().getBackForImageColorsDto().getImageColors()).
                flatMap(Collection::stream).collect(Collectors.toList());
    }

    static void printResultColors(List<ColorParentPercentageDto> colors) {
        System.out.printf("%-10s%-10s%-10s%n%n", "Color name |", " Parent color name |", " Percentage |");
        for (ColorParentPercentageDto colorParentPercentageDto : colors) {
            System.out.printf("%-10s%-10s%-10s%n%n",
                    colorParentPercentageDto.getClosestPaletteColor(),
                    colorParentPercentageDto.getClosestPaletteColorParent(),
                    colorParentPercentageDto.getPercent());
        }
    }

}
