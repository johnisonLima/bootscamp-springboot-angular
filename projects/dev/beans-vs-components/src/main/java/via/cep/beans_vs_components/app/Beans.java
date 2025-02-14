package via.cep.beans_vs_components.app;

import org.springframework.context.annotation.Bean;

import com.google.gson.Gson;

public class Beans {
    @Bean
	public Gson gson() {
		return new Gson();
	}
}
