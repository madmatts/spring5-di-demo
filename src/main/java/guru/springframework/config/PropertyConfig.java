package guru.springframework.config;

import guru.springframework.examplebeans.FakeDataSource;
import guru.springframework.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
//@PropertySource({"classpath:jms.properties", "classpath:datasource.properties"})
@PropertySources({
        @PropertySource("classpath:jms.properties"),
        @PropertySource("classpath:datasource.properties")
})
public class PropertyConfig {

    @Autowired
    Environment env;

    @Value("${guru.username}")
    String user;

    @Value("${guru.password}")
    String password;

    @Value("${guru.dbname}")
    String url;

    @Value("${guru.jms.username}")
    String jmsUser;

    @Value("${guru.jms.password}")
    String jmsPassword;

    @Value("${guru.jms.dbname}")
    String jmsUrl;

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(env.getProperty("USERNAME"));
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }

    @Bean
    public FakeJmsBroker fakeJmsSource() {
        FakeJmsBroker jmsBroker = new FakeJmsBroker();
        jmsBroker.setUser(jmsUser);
        jmsBroker.setPassword(jmsPassword);
        jmsBroker.setUrl(jmsUrl);
        return jmsBroker;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
