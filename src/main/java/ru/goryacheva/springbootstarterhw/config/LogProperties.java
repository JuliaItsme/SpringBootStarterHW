package ru.goryacheva.springbootstarterhw.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Свойства конфигурации для логгирования
 */
@Data
@ConfigurationProperties(prefix = "logger")
public class LogProperties {
    private Boolean requestEnabled;
    private String level;
}
