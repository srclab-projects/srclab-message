package test.xyz.srclab.grpc.spring.boot.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import xyz.srclab.spring.boot.task.TaskExecutors;
import xyz.srclab.spring.boot.task.TaskPoolProperties;

@Configuration
public class ExecutorConfiguration {

    @Bean
    public TaskExecutor defaultExecutor() {
        TaskPoolProperties properties = new TaskPoolProperties();
        properties.setThreadNamePrefix("default-task-executor");
        return TaskExecutors.newTaskExecutor(properties);
    }

    @Bean
    public TaskExecutor client2Executor() {
        TaskPoolProperties properties = new TaskPoolProperties();
        properties.setThreadNamePrefix("client2-task-executor");
        return TaskExecutors.newTaskExecutor(properties);
    }
}
