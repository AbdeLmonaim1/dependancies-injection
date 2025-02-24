# Practical Activity No. - Dependency Injection
## Overview
This practical activity aims to demonstrate dependency injection (DI) in Java by implementing interfaces and applying different injection techniques to achieve loose coupling. It covers static instantiation, dynamic instantiation using reflection, and Spring-based DI through XML configuration and annotations. The goal is to improve flexibility, maintainability, and scalability by decoupling components. By leveraging DI, the exercise highlights best practices in software design, making the system more modular and adaptable.
## Technologies Used

- <img src="https://upload.wikimedia.org/wikipedia/en/3/30/Java_programming_language_logo.svg" width="30" height="30"/> &nbsp;&nbsp;**Java**
- <img src="https://upload.wikimedia.org/wikipedia/commons/4/44/Spring_Framework_Logo_2018.svg" width="30" height="30"/>   **Spring Framework**
- <img src="https://resources.jetbrains.com/storage/products/company/brand/logos/IntelliJ_IDEA_icon.svg" width="30" height="30"/> &nbsp;&nbsp;**IntelliJ IDEA**
- <img src="https://git-scm.com/images/logos/downloads/Git-Icon-1788C.png" width="30" height="30"/> &nbsp;&nbsp;**Git**
- <img src="https://github.githubassets.com/images/modules/logos_page/GitHub-Mark.png" width="30" height="30"/> &nbsp;&nbsp;**GitHub**
## Practical Activity
### Part 1


This activity aims to understand and apply the principles of dependency injection in Java, transitioning from a manual approach to using the Spring framework. Below are the main steps covered:


1. **Creating the `IDao` interface**: This interface defines a `getData()` method, which will be implemented by different classes to provide data.

2. **Implementing the `IDao` interface**: A concrete class is created to provide a specific implementation of the `getData()` method.

3. **Creating the `IMetier` interface**: Another interface is defined with a `calcul()` method, which will perform processing based on the data obtained from `IDao`.

4. **Implementing `IMetier` with loose coupling**: The implementation of this interface must adhere to the principle of loose coupling, meaning the dependency on `IDao` will be injected rather than instantiated directly within the business class.

####  Dependency Injection

The objective is to integrate dependencies using different approaches:

#### a. **Static instantiation**
   - Here, objects are manually created in the code, leading to strong coupling.
     ```java
     //        dependency injection by static instantiation
        DaoImpl dao = new DaoImpl();
        MetierImpl metier = new MetierImpl();
        metier.setDao(dao);
        System.out.println("Result with static instantiation = "+metier.calcule());
     ```

#### b. **Dynamic instantiation**
   - Using Java reflection to instantiate objects dynamically at runtime, allowing greater flexibility.
     ```java
             //dependency injection by dynamic instantiation
        try {
            Scanner scanner = new Scanner(new File("config.txt"));
            String daoClassName = scanner.nextLine();
            Class daoClass = Class.forName(daoClassName);
            IDao daoImpl = (IDao) daoClass.getConstructor().newInstance();
            String metierClassName = scanner.nextLine();
            Class metierClass = Class.forName(metierClassName);
            IMetier metierImpl = (IMetier) metierClass.getConstructor().newInstance();
            Method setDao = metierClass.getDeclaredMethod("setDao", IDao.class);
            setDao.invoke(metierImpl, daoImpl);
            System.out.println("Result with dynamic instantiation = "+metierImpl.calcule());
        }catch (Exception e) {
            e.printStackTrace();
        }
     ```

#### c. **Using the Spring framework**
   - **XML Version**: Declaring beans and injecting dependencies via an XML configuration file.
```xml
     <?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
<bean id="d" class="ma.app.dao.DaoImpl"></bean>
    <bean id="metier" class="ma.app.metier.MetierImpl">
        <property name="dao" ref="d"></property>
    </bean>

</beans>
``` 

class Presentation:

```java
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationConfig.xml");
        IMetier metier = (IMetier) context.getBean("metier");
        System.out.println("Result Using XML file = "+metier.calcule());
```

   - **Annotations Version**: Using Spring annotations (`@Component`, `@Autowired`, etc.) to automatically manage dependency injection.
```java
@Component("metier")
@Service("metier")
public class MetierImpl implements IMetier{}
@Component("dao2")
@Repository("dao2")
public class DaoImplV2 implements IDao {}
@Component("dao")
@Repository("dao")
public class DaoImpl implements IDao{}
 public MetierImpl(@Qualifier("dao2") IDao dao) {
        this.dao = dao;
    }
```

This activity provides a better understanding of coupling, dependency injection, and the use of Spring for improved component and dependency management in a Java application.
#### Demonstration
##### Static and Dynamic instantiation
![image](https://github.com/user-attachments/assets/f77fd2d9-da08-4ccb-b78b-d4729a25ab55)
##### DI using Spring Framework with XML file
![image](https://github.com/user-attachments/assets/a7490aaa-0471-41c0-81e3-f70356d95914)
##### DI using Spring Framework annotations version
![image](https://github.com/user-attachments/assets/ec3662da-6554-4a0c-b6c0-e30bb46040dc)


