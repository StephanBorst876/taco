package tacos;

import tacos.controller.DesignTacoController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TacoCloudApplication {

    public static final Logger log = LoggerFactory.getLogger(DesignTacoController.class);

    public static void main(String[] args) {

        
        SpringApplication.run(TacoCloudApplication.class, args);
    }
}
