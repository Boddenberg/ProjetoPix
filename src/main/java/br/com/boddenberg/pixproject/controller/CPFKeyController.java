package br.com.boddenberg.pixproject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.boddenberg.pixproject.entity.CNPJKey;
import br.com.boddenberg.pixproject.entity.CPFKey;
import br.com.boddenberg.pixproject.response.Response;
import br.com.boddenberg.pixproject.service.CPFKeyService;

@RestController
@RequestMapping(path = "cpf/pix")
public class CPFKeyController {


	
		@Autowired
		CPFKeyService service;
		
		@GetMapping(path = "cpf/buscar")
		public ResponseEntity<Response<List<CPFKey>>> listarTodos() {
			return ResponseEntity.ok(new Response<List<CPFKey>>(this.service.listarTodos()));
			}
	

		@PostMapping(path = "cpf/cadastrar")
		public ResponseEntity<Response<CPFKey>> cadastrar(@Valid @RequestBody CPFKey cpfKey, BindingResult result){
			if (result.hasErrors()) {
				List<String> erros = new ArrayList<String>();
				result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
				return ResponseEntity.badRequest().body(new Response<CPFKey>(erros));
			}
		return ResponseEntity.ok(new Response<CPFKey>(this.service.cadastrar(cpfKey)));
		}
			
		
//		@PutMapping(path = "cpf/atualizar")
//		public ResponseEntity<Response<CPFKey>> atualizar(@PathVariable(name = "id") String id, @Valid @RequestBody CPFKey cpfKey, BindingResult result) {
//			if (result.hasErrors()) {
//				List<String> erros = new ArrayList<String>();
//				result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
//				return ResponseEntity.badRequest().body(new Response<CPFKey>(erros));
//			}
//			
//			cpfKey.setId(id);
//			return ResponseEntity.ok(new Response<CPFKey>(this.service.atualizar(cpfKey)));
//		}
		
		@PutMapping(path = "cpf/atualizar/{id}")
		public ResponseEntity<CPFKey> atualizar(@PathVariable(name = "id") String id, @RequestBody CPFKey cpfKey) {
			cpfKey.setId(id);
			return ResponseEntity.ok(this.service.atualizar(cpfKey));
		}

		

		@DeleteMapping(path = "cpf/{id}")
	    public ResponseEntity<Response<Integer>> remover(@PathVariable(name = "id") String id){
	        this.service.remover(id);
	        return ResponseEntity.ok(new Response<Integer>(1));
	    }
		

		
		
	}

	