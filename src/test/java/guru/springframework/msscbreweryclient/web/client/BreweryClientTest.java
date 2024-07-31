package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Autowired
    CustomerClient clientC;

    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());

        assertNotNull(dto);

        System.out.println(dto);
    }

    @Test
    void testSaveNewBeer() {
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();

        URI uri = client.saveNewBeer(beerDto);

        assertNotNull(uri);

        System.out.println(uri.toString());
    }

    @Test
    void testUpdateBeer() {
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();

        client.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void testDeleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    void testGetBeerById() {
        CustomerDto customer = clientC.getBeerById(3);

        assertNotNull(customer);

        System.out.println(customer);
    }

    @Test
    void testPostSaveNewBeer() {
        CustomerDto customer = CustomerDto.builder().name("Gino").surname("Blu").age(33).build();

        URI uri = clientC.saveNweCustomer(customer);

        assertNotNull(uri);

        System.out.println(uri.toString());
    }

    @Test
    void testUpdateCustomer() {
        CustomerDto customer = CustomerDto.builder().name("Gino").surname("Blu").age(33).build();

        clientC.updateCustomer(3, customer);
    }

    @Test
    void testDeleteCustomer() {
        clientC.deleteCustomer(3);
    }
}