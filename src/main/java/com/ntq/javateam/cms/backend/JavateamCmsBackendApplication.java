package com.ntq.javateam.cms.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavateamCmsBackendApplication {
    
    public static void main(String[] args) {
        try {
            SpringApplication.run(JavateamCmsBackendApplication.class, args);
        } catch (Exception e) {
            System.out.println("\nException starting the Javateam cms backend: " + e.getMessage());
            System.out.println("See more in file: log/spring/spring.log");
            throw e;
        }
        System.out.println(
            "      ##    ###    ##     ##    ###    ######## ########    ###    ##     ##     ######  ##     ##  ######     ########     ###     ######  ##    ## ######## ##    ## ########  \n" +
            "      ##   ## ##   ##     ##   ## ##      ##    ##         ## ##   ###   ###    ##    ## ###   ### ##    ##    ##     ##   ## ##   ##    ## ##   ##  ##       ###   ## ##     ## \n" +
            "      ##  ##   ##  ##     ##  ##   ##     ##    ##        ##   ##  #### ####    ##       #### #### ##          ##     ##  ##   ##  ##       ##  ##   ##       ####  ## ##     ## \n" +
            "      ## ##     ## ##     ## ##     ##    ##    ######   ##     ## ## ### ##    ##       ## ### ##  ######     ########  ##     ## ##       #####    ######   ## ## ## ##     ## \n" +
            "##    ## #########  ##   ##  #########    ##    ##       ######### ##     ##    ##       ##     ##       ##    ##     ## ######### ##       ##  ##   ##       ##  #### ##     ## \n" +
            "##    ## ##     ##   ## ##   ##     ##    ##    ##       ##     ## ##     ##    ##    ## ##     ## ##    ##    ##     ## ##     ## ##    ## ##   ##  ##       ##   ### ##     ## \n" +
            " ######  ##     ##    ###    ##     ##    ##    ######## ##     ## ##     ##     ######  ##     ##  ######     ########  ##     ##  ######  ##    ## ######## ##    ## ########  \n" +
            " :: Javateam cms backend Booted :: ");
    }
}
