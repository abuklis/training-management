
import by.bsu.trainingmanagement.service.IWeatherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;

/**
 * Created by anyab on 21.12.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:dispatcher-servlet.xml"})
public class WeatherTest {

    @Autowired
    private IWeatherService weatherService;

    @Test
    public void shouldReturnNotEmptyWeatherInfo() throws IOException {
        assert weatherService.viewCurrentWeather().getWeatherText() != null;
    }

}
