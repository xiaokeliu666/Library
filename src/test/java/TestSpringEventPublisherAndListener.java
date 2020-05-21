import com.xliu.publisher.DepositEventPublisher;
import com.xliu.publisher.WithdrawEventPublisher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringEventPublisherAndListener {
    public static void main(String[] args) {
        // Initiate Spring application context.
        ApplicationContext springAppCtx = new ClassPathXmlApplicationContext("SpringEventBeanSettings.xml");

        // Get deposit event publisher bean to publish event.
        DepositEventPublisher depositEventPublisherBean = (DepositEventPublisher)springAppCtx.getBean("depositEventPublisherBean");
        depositEventPublisherBean.publishDepositEvent("BOC6666666", "2017/06/08");

        // Get withdraw event publisher bean to publish event.
        WithdrawEventPublisher withdrawEventPublisherBean = (WithdrawEventPublisher)springAppCtx.getBean("withdrawEventPublisherBean");
        withdrawEventPublisherBean.publishWithdrawEvent("BOA1111111", "2017/08/08");
    }
}
