package br.com.lfmelo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "API Core - Fast Food [Tech Challeng]",
				version = "1.0",
				description = "API responsável pelo gerenciamento de produtos, pedidos, clientes e imagens em um sistema de fast food.",
				contact = @Contact(name = " - Luiz Fernando", email = "luiz123jfmg@gmail.com"),
				license = @License(name = "MIT", url = "https://opensource.org/licenses/MIT")
		),
		servers = {
				@Server(url = "http://localhost:8080", description = "Servidor local")
		}
)
@SpringBootApplication
public class TcFastFoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(TcFastFoodApplication.class, args);
	}

}
