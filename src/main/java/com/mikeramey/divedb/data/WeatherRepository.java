package com.mikeramey.divedb.data;

import com.mikeramey.divedb.logic.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@PropertySource("classpath:application.properties")
public class WeatherRepository {

    @Autowired
    private RestTemplate restTemplate;


    @Value("${jdbc.port}")
    private String port;
    @Value("${jdbc.host}")
    private String host;
    @Value("${jdbc.schema}")
    private String schema;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    public Weather getWeather(String location) {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + location +
                "&APPID=d143984e51b6451dadfdf3f3b88859b2";
        Weather weather = restTemplate.getForObject(url, Weather.class);
        return weather;
    }
}
