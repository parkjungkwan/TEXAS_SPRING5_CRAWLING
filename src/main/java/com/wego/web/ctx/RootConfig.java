package com.wego.web.ctx;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages= {"com.wego.web"})
@Import({
	ServletConfig.class
})
public class RootConfig {
	
	
	
}
