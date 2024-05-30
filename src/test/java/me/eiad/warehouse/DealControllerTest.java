package me.eiad.warehouse;

import me.eiad.warehouse.api.DealDTO;
import me.eiad.warehouse.repository.SpringDealRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class DealControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private SpringDealRepository springDealRepository;
    @Autowired
    private TestRestTemplate testRestTemplate;
    private DealDTO dealDTO1;

    @BeforeEach
    void setUp() {
        dealDTO1 = new DealDTO(1, "JOD", "JOD",
                LocalDate.now(), BigDecimal.ONE);
        springDealRepository.deleteAll();
    }

    @Test
    public void make_sure_that_the_response_is_equal_to_the_actual_deal() {
        ResponseEntity<DealDTO> response = testRestTemplate.postForEntity("http://localhost:" + port + "/deal",
                dealDTO1, DealDTO.class);

        DealDTO responseBody = response.getBody();
        assertNotNull(responseBody);

        Assertions.assertEquals(responseBody.getUniqueId(), dealDTO1.getUniqueId());
    }

    @Test
    public void the_status_for_the_request_must_be_created() {
        ResponseEntity<DealDTO> response = testRestTemplate.postForEntity("http://localhost:" + port + "/deal",
                dealDTO1, DealDTO.class);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.CREATED);

    }
}
