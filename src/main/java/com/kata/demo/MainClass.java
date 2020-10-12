package com.kata.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;


@ComponentScan({ "com.kata.demo.account"})
@EnableAutoConfiguration
public class MainClass {

      private static final Logger logger = LoggerFactory.getLogger(MainClass.class);

      public static void main(String[] args) throws UnknownHostException {
            Long initMem = Runtime.getRuntime().freeMemory();
            SpringApplication app = new SpringApplication(MainClass.class);
            Environment env = app.run(args).getEnvironment();
            logger.info("\n-------------------------------------------------------------------------\n\t"
                        + "Application '{}' is running! Access URLs:\n\t"
                        + "Local: \t\t\thttp://localhost:{}\n\t" + "External: \t\thttp:/{}:{}\n\t"
                        + "Host-Name: \t\t{}\n\t" + "Memory consume(MB):\t{} "
                        + "\n-------------------------------------------------------------------------\n\t",
                        env.getProperty("spring.application.name"), env.getProperty("server.port"),
                        InetAddress.getLocalHost().getHostAddress(), env.getProperty("server.port"),
                        InetAddress.getLocalHost().getHostName(),
                        (Runtime.getRuntime().freeMemory() - initMem) / (1024 * 1024));
      }
}
