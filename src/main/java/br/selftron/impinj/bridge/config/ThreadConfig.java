package br.selftron.impinj.bridge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class ThreadConfig {
	
	@Bean(name = "impinjTaskExecutor")
    public TaskExecutor impinjTaskExecutor() {
        return new SimpleAsyncTaskExecutor();
    }
	
    @Bean
    public TaskExecutor threadPoolTaskExecutor() {
    	return new SimpleAsyncTaskExecutor();
    	
        /*ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(4);
        executor.setThreadNamePrefix("sgfgd");
        executor.initialize();
        return executor;*/
    }
}
