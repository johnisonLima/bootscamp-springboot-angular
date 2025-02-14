package via.cep.beans_vs_components;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import via.cep.beans_vs_components.app.ConversorJson;
import via.cep.beans_vs_components.app.ViaCepResponse;

@SpringBootApplication
public class BeansVsComponentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeansVsComponentsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner run(ConversorJson conversorJson) throws Exception {
		return args -> {
			String json = "{\"cep\":\"01001-000\",\"logradouro\":\"Praça da Sé\",\"localidade\":\"São Paulo\"}";
			ViaCepResponse response = conversorJson.converter(json);
			System.out.println(response.toString());
		};
	}		
}
