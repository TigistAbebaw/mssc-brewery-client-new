package main.java.guru.springframework.msscbreweryclient.web.client;

import main.java.guru.springframework.msscbreweryclient.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
@Component
public class BreweryClient {
    private final String BEER_PATH = "api/v1/beer/";
    private String apiHost;

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    public BeerDto getBeerById(UUID beerID){
        return restTemplate.getForObject(apiHost+BEER_PATH+beerID.toString(), BeerDto.class);
    }

    public URI saveBeer(BeerDto beerDto){
        return restTemplate.postForLocation(apiHost+BEER_PATH, beerDto);
    }

    public void updateBeerbyId(BeerDto beerDto, UUID ID){
        restTemplate.put(apiHost+BEER_PATH+ID, beerDto);
    }
    public void deleteById(UUID ID){
        restTemplate.delete(apiHost+BEER_PATH+ID);
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }
}
