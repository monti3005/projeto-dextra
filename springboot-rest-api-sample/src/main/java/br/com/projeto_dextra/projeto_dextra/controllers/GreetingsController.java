package br.com.projeto_dextra.projeto_dextra.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto_dextra.projeto_dextra.model.TesteTonho;
import br.com.projeto_dextra.projeto_dextra.model.Usuario;
import br.com.projeto_dextra.projeto_dextra.repository.TesteTonhoRepository;
import br.com.projeto_dextra.projeto_dextra.repository.UsuarioRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {

	@Autowired
	private TesteTonhoRepository testeTonhoRepository;
	
	@Autowired //injecao de dependencia
	private UsuarioRepository usuarioRepository;

    /**
     *
     * @param name the name to greet
     * @return greeting text
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {

    	TesteTonho testeTonho = new TesteTonho();
    	testeTonho.setTonho(name);

    	testeTonhoRepository.save(testeTonho);

        return "Salve " + name + "!";
    }
    
    @GetMapping(value = "listatodos")
    @ResponseBody  //retona os dados para o body
    public ResponseEntity<List<Usuario>> listaUsuario(){
    	
    	List <Usuario> usuarios = usuarioRepository.findAll();
    	
    	return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK); //retorna  lista em JSON
    }
    
    
    @PostMapping(value = "salvar")
    @ResponseBody
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){
    	
		Usuario user = usuarioRepository.save(usuario);
		
		return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
    }
    
}
