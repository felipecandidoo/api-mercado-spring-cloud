package br.com.mercado.produto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProdutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdutoApplication.class, args);
	}

}
