package scripting;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Boot {

    public static void main(final String[] args) throws Exception {
        @SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beaFactoryTest.xml");
        MessageDemo messenger = (MessageDemo) ctx.getBean("messenger");
        System.out.println(messenger.getMessage());
    }

}
