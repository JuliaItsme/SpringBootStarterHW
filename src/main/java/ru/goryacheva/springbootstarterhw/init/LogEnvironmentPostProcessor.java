package ru.goryacheva.springbootstarterhw.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import ru.goryacheva.springbootstarterhw.exception.LogRequestException;

/**
 * читаем настройки стартера и проверяем
 */
public class LogEnvironmentPostProcessor implements EnvironmentPostProcessor {


    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        String value = environment.getProperty("logger.request-enabled");
        boolean isBoolValue = Boolean.TRUE.toString().equals(value) ||
                Boolean.FALSE.toString().equals(value);

        if (!isBoolValue) {
            throw new LogRequestException("Ошибка при проверки свойства 'logger.request-enabled' ");
        }
    }
}
