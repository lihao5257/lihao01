package scripting;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor{
	 // simply return the instantiated bean as-is
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
    	System.out.println("Before:  Bean '" + beanName + "' is being created : " + bean.toString());
        return bean; // we could potentially return any object reference here...
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("After:  Bean '" + beanName + "' created : " + bean.toString());
        return bean;
    }
}
