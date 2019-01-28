package br.selftron.impinj.bridge.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.selftron.impinj.bridge.dto.ReaderConfigurationDTO;
import br.selftron.impinj.bridge.dto.TagsReadResultDTO;

@Controller
@Service
public class ImpinjController implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	@Qualifier("impinjTaskExecutor")
	private TaskExecutor taskExecutor;
	
	private Map<String, ImpinjReaderRunnable> readers = new HashMap<>();
	
	public ImpinjController() {
		System.out.println("Impinj instance created.");
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {		
	}
	
	@RequestMapping(value = "/configure", method = RequestMethod.POST)
    @ResponseBody
	public void configure(@RequestBody ReaderConfigurationDTO configuration) throws Exception {
		ImpinjReaderRunnable runnable = (ImpinjReaderRunnable) applicationContext.getBean(ImpinjReaderRunnable.class, configuration);
		readers.put("169.254.1.1", runnable);
		taskExecutor.execute(runnable);
    }
	
	@GetMapping("/list")
	public TagsReadResultDTO list() throws Exception {
        return null;
    }
	
	@PostMapping("/stop")
	public void stop(@PathVariable String readerAddress) throws Exception {
    }

}
