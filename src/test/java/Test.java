import org.junit.runner.RunWith;
import org.springagg.service.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-redis.xml"})
public class Test {

    @Autowired
    private Sender redisServer;

    @org.junit.Test
    public void test(){

        redisServer.sendMessage("mqMessage","success sender");

    }


}
