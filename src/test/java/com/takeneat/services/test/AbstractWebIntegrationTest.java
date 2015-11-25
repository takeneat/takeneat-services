package com.takeneat.services.test;

import com.takeneat.services.Boot;
import com.takeneat.services.api.utils.ApiConstants;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @author paoesco
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Boot.class)
@WebIntegrationTest({"server.port=0", "management.port=0"})
public class AbstractWebIntegrationTest {

    @Value("${local.server.port}")
    private int port;

    protected RestTemplate restTemplate = new TestRestTemplate();

    private String getBaseurl() {
        return "http://localhost:" + port;
    }

    protected String getPathV1() {
        return getBaseurl() + ApiConstants.PATH_V1;
    }

}
