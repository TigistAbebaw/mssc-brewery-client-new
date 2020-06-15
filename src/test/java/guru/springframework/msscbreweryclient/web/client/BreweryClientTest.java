package test.java.guru.springframework.msscbreweryclient.web.client;

import main.java.guru.springframework.msscbreweryclient.web.client.BreweryClient;
import main.java.guru.springframework.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {
    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById() {
        BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }

    @Test
    void saveBeer(){
       URI uri = breweryClient.saveBeer(BeerDto.builder().beerName("new beer").build());
       assertNotNull(uri);
    }

    @Test
    void updateBeer(){
        breweryClient.updateBeerbyId(BeerDto.builder().beerName("new2 beer").build(), UUID.randomUUID());
    }

    @Test
    void deleteBeer(){
        breweryClient.deleteById(UUID.randomUUID());
    }
}