package com.back2reality;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Back2RealityApplication {

  private static final Logger logger = LoggerFactory.getLogger(Back2RealityApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(Back2RealityApplication.class, args);
    logger.info("time to get back 2 reality...");
  }

}
