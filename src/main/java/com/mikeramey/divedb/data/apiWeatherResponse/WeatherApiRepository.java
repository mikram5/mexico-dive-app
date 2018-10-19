package com.mikeramey.divedb.data.apiWeatherResponse;

import com.mikeramey.divedb.logic.model.Weather;
import com.mikeramey.divedb.logic.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.net.URI;

@Repository
@PropertySource("classpath:openWeatherApi.properties")
public class WeatherApiRepository implements WeatherRepository {

    @Value("${api.weather.baseurl}")
    private String BASE_URL;
    @Value("${api.weather.apikey.param}")
    private String APPID;
    @Value("${api.weather.apikey.value}")
    private String APP_KEY;

    private static final String PATH = "weather";
    private static final String QUERY = "q";

    private RestTemplate restTemplate;

    @Autowired
    public WeatherApiRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Weather getWeather(String location) {
        URI uri = new DefaultUriBuilderFactory()
                .uriString(BASE_URL)
                .path(PATH)
                .queryParam(QUERY, location)
                .queryParam(APPID, APP_KEY)
                .build();
        ApiWeatherResponse weather = restTemplate.getForObject(uri, ApiWeatherResponse.class);
        ApiWeatherMapper apiWeatherMapper = new ApiWeatherMapper();
        return apiWeatherMapper.apiWeatherMapper(weather);

    }
}
