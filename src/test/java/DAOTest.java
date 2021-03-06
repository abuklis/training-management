import by.bsu.trainingmanagement.dao.ITrainingDAO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by anyab on 06.12.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dispatcher-servlet.xml"})
public class DAOTest {
    @Autowired
    private ITrainingDAO dao;

    @Test
    public void shouldReturnFirstTraining() {
        Assert.assertEquals(dao.findTraining(2).getAttendeesAmount(), 90);
    }
}
