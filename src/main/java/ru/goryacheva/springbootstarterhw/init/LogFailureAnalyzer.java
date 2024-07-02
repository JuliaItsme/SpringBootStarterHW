package ru.goryacheva.springbootstarterhw.init;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;
import ru.goryacheva.springbootstarterhw.exception.LogRequestException;

public class LogFailureAnalyzer extends AbstractFailureAnalyzer<LogRequestException> {

    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, LogRequestException cause) {
        return new FailureAnalysis(cause.getMessage(), "Укажите валидное значения для свойства", cause);
    }
}
