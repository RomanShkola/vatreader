package com.barclays.tools.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.barclays.tools.readers.VATReader;

@SpringBootApplication
@ComponentScan({ "com.barclays.tools.*" })
public class VATReaderApplication {
	
	private VATReader vatReader;

	public VATReaderApplication(VATReader vatReader) {
		this.vatReader = vatReader;
	}

	public void run() {
		vatReader.read();
	}

	public static void main(String[] args) {

		SpringApplication.run(VATReaderApplication.class, args);
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
		VATReaderApplication app = applicationContext.getBean("vatReaderApp", VATReaderApplication.class);
		app.run();
		applicationContext.close();
	}

}
