import com.xliu.mail.Email;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mail.xml");

        Email email = (Email) context.getBean("email");

        String senderEmailId = "550477200@qq.com";
        String receiverEmailId = "2254747307@qq.com";
        String subject = "123123";
        String message = "123123";

        email.sendEmail(senderEmailId,receiverEmailId,subject,message);
        System.out.println("6666");
    }
}
