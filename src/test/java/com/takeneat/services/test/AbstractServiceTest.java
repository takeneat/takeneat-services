package com.takeneat.services.test;

import com.takeneat.services.Boot;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author paoesco
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Boot.class)
// Fixes Error creating bean with name 'documentationPluginsBootstrapper'
// https://github.com/springfox/springfox/issues/654
@WebAppConfiguration
public abstract class AbstractServiceTest {

}
