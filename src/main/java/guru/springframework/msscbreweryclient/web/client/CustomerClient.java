package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.customer", ignoreUnknownFields = false)
public class CustomerClient {

    public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    public final String CUSTOMER_PATH_V1_POST = "/api/v1/customer";
    private String apiHostCustomer;

    private final RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CustomerDto getBeerById(int customerId) {
        return restTemplate.getForObject(apiHostCustomer + CUSTOMER_PATH_V1 + customerId, CustomerDto.class);
    }

    public URI saveNweCustomer(CustomerDto customerDto) {
        return restTemplate.postForLocation(apiHostCustomer + CUSTOMER_PATH_V1_POST, customerDto);
    }

    public void updateCustomer(int customerId, CustomerDto customerDto) {
        restTemplate.put(apiHostCustomer + CUSTOMER_PATH_V1 + customerId, customerDto);
    }

    public void deleteCustomer(int customerId) {
        restTemplate.delete(apiHostCustomer + CUSTOMER_PATH_V1 + customerId);
    }

    public void setApihostCustomer(String apihostCustomer) {
        this.apiHostCustomer = apihostCustomer;
    }
}
