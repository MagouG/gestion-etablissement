package isi.devops.gestion_etablissement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class GestionEtablissementApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionEtablissementApplication.class, args);
		acceuil() ;
	}
	@GetMapping("/")
	public static String acceuil(){
		return "index" ;
	}

}
