package br.com.projeto_dextra.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto_dextra.model.TesteTonho;
import br.com.projeto_dextra.model.Usuario;
import br.com.projeto_dextra.model.UsuarioDextra;
import br.com.projeto_dextra.repository.TesteTonhoRepository;
import br.com.projeto_dextra.repository.UsuarioDextraRepository;
import br.com.projeto_dextra.repository.UsuarioRepository;

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
	
	@Autowired
	private UsuarioDextraRepository usuarioDextraRepository;

    /**
     *
     * @param name the name to greet
     * @return greeting text
     */
	
//	@PostMapping(value = "http://us-central1-rh-challenges.cloudfunctions.net/potterApi/users")
//    @ResponseBody
//    public ResponseEntity<UsuarioDextra> salvar(@RequestBody UsuarioDextra usuarioDextra){
//    	
//		UsuarioDextra user = usuarioDextraRepository.save(usuarioDextra);
//		
//		return new ResponseEntity<UsuarioDextra>(user, HttpStatus.CREATED);
//    }
	
	
	
	
	
	//testes
	
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
    
    @PutMapping(value = "atualizar")
    @ResponseBody
    public ResponseEntity<?> atualizar(@RequestBody Usuario usuario){
    	
    	if(usuario.getId() == null) {
    		return new ResponseEntity<String>("id nao informado", HttpStatus.OK);
    	}
    	
		Usuario user = usuarioRepository.saveAndFlush(usuario);
		
		return new ResponseEntity<Usuario>(user, HttpStatus.OK);
    }
        
    @DeleteMapping(value = "delete")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long id){
    	
		usuarioRepository.deleteById(id);
		
		return new ResponseEntity<String>("Usuario deletado com sucesso", HttpStatus.OK);
    }
        
    
    @GetMapping(value = "buscarPorId")
    @ResponseBody
    public ResponseEntity<Usuario> buscarPorId(@RequestParam(name = "id") Long id){
    	
    	Usuario usuario = usuarioRepository.findById(id).get();
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }
    
    @GetMapping(value = "buscarPorNome")
    @ResponseBody
    public ResponseEntity<List<Usuario>> buscarPorNome(@RequestParam(name = "nome") String nome){
    	
    	List<Usuario> usuario = usuarioRepository.buscarPorNome(nome.trim().toUpperCase());
		
		return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.OK);
    }
    
}
