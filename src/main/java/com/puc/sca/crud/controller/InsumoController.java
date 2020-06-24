package com.puc.sca.crud.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.puc.sca.crud.entity.insumo.CodigoEspecificoInsumo;
import com.puc.sca.crud.entity.insumo.Insumo;
import com.puc.sca.crud.entity.insumo.TipoInsumo;
import com.puc.sca.crud.repository.CodigoEspecificoInsumoRepository;
import com.puc.sca.crud.repository.InsumoRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Rest controller para o crud de insumos.
 * @author breno
 *
 */

@RestController
@RequestMapping("insumos")
@Tag(name = "insumos", description = "API crud de insumos")
public class InsumoController {
	
	@Autowired
	private InsumoRepository insumoRepository;
	
	@Autowired
	private CodigoEspecificoInsumoRepository codigoEspecificoInsumoRespository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	@Operation(summary = "Salva o insumo", description = "Recebe um insumo para persistência", tags = { "insumos" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Insumo criado", content = @Content(schema = @Schema(implementation = Insumo.class))),
			@ApiResponse(responseCode = "400", description = "Invalid input"),
			@ApiResponse(responseCode = "409", description = "Insumo já existe") })
	public Insumo save(@RequestBody Insumo insumo) {
		
		if (insumo.getCodigosConcatenadosInsumo() != null && !insumo.getCodigosConcatenadosInsumo().isEmpty()) {
			 this.saveCodigoEspecificoInsumo(insumo);
		} 
		
		return this.insumoRepository.save(insumo);
	}
	
	
	@PostMapping("/upload")
	public void handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		// file.getBytes();
		redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");

	}
	

	@PutMapping("{id}")
	@Operation(summary = "Atualiza o insumo", description = "Recebe um insumo e o id do insumo para persistência", tags = { "insumos" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Insumo atualizado"),
			@ApiResponse(responseCode = "400", description = "Id inválido"),
			@ApiResponse(responseCode = "404", description = "Insumo não encontrado"),
			@ApiResponse(responseCode = "405", description = "Validation exception") })
	public Insumo update(@PathVariable(value = "id") Long id, @RequestBody Insumo insumo) {
		 
		Optional<Insumo> insumoOptional = this.insumoRepository.findById(id);
		
		Insumo insumoDB = null;
		
		if (insumoOptional.isPresent()) {
			insumoDB = insumoOptional.get();
		} else {
			 throw new HttpServerErrorException(HttpStatus.EXPECTATION_FAILED);
		}
		
		BeanUtils.copyProperties(insumo, insumoDB);
		insumoDB.setTipoMarcaModelo(insumo.getTipoMarcaModelo().getId() == null ? null : insumo.getTipoMarcaModelo());
   	
		if (insumo.getCodigosConcatenadosInsumo() != null && !insumo.getCodigosConcatenadosInsumo().isEmpty()) {
			 
			 List<CodigoEspecificoInsumo> codigosEspecificosDelete = this.codigoEspecificoInsumoRespository.findAllByInsumo(insumoDB);
			 if (codigosEspecificosDelete != null && !codigosEspecificosDelete.isEmpty()) {
				  this.codigoEspecificoInsumoRespository.deleteAll(codigosEspecificosDelete);
			 }
			
			 this.saveCodigoEspecificoInsumo(insumoDB);
		}
		
		return this.insumoRepository.save(insumoDB);
	}
	
	@DeleteMapping("{id}")
	@Operation(summary = "Deleta um insumo", description = "", tags = { "insumos" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "sucesso"),
			@ApiResponse(responseCode = "404", description = "insumo não encontrado") })
	public void delete(@PathVariable(value = "id") Long id) {
		Optional<Insumo> insumoOptional = this.insumoRepository.findById(id);
		
        Insumo insumo = null;
		
		if (insumoOptional.isPresent()) {
			insumo = insumoOptional.get();
		} else {
			 throw new HttpServerErrorException(HttpStatus.EXPECTATION_FAILED);
		}
		
		this.insumoRepository.delete(insumo);
	}
	
	
	
	@GetMapping("{id}")
	@Operation(summary = "Encontra o insumo pelo ID", description = "Returna um único insumo", tags = { "insumos" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "sucesso", content = @Content(schema = @Schema(implementation = Insumo.class))),
			@ApiResponse(responseCode = "404", description = "Insumo não encontrado") })
	public Insumo findById(@PathVariable(value = "id") Long id) {
	 
		Optional<Insumo> optional = this.insumoRepository.findById(id);

		if (optional.isPresent()) {
			Insumo insumo = optional.get();
			
			if (insumo.getCodigosEspecificosInsumo() != null && !insumo.getCodigosEspecificosInsumo().isEmpty()) {
				insumo.setCodigosConcatenadosInsumo(insumo.getCodigosEspecificosInsumo().stream().map(CodigoEspecificoInsumo :: getCodigo).collect(Collectors.joining(",")));
			}
			
			return insumo;
			
		}
		return null;
	}
	

	@GetMapping
	@Operation(summary = "Recupera os insumos", description = "Retorna os insumos de acordo com o tamanho da página", tags = { "insumos" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "sucesso", content = @Content(schema = @Schema(implementation = Insumo.class))),
			@ApiResponse(responseCode = "404", description = "Insumo não encontrado") })
	public Iterable<Insumo> findAll(@RequestParam("page") Integer page, 
			                        @RequestParam("size") Integer size,
			                        @RequestParam(value = "tipoInsumo", required = false) Long tipoInsumo,
			                        @RequestParam(name = "sort", defaultValue = "id") String sort) {
		Pageable pageable = PageRequest.of(page - 1, size, Sort.by(sort));

		Page<Insumo> result = null;

		if (tipoInsumo != null) {
			result = this.insumoRepository.findAllByTipoInsumo(new TipoInsumo(tipoInsumo), pageable);
		} else {
			result = this.insumoRepository.findAll(pageable);
		}

		List<Insumo> insumos = result.get().collect(Collectors.toList());
		if (!insumos.isEmpty()) {
			insumos.get(0).setTotalElementos(result.getTotalElements());
		}

		return insumos;
	}
	
	private void saveCodigoEspecificoInsumo(Insumo insumo) {
		 if (insumo.getCodigosConcatenadosInsumo().contains(",")) {
			 insumo.setCodigosEspecificosInsumo((Arrays.asList(insumo.getCodigosConcatenadosInsumo().split(",")).stream().map(codigo -> new CodigoEspecificoInsumo(insumo,codigo)).collect(Collectors.toList())));
		 } else {
			 insumo.setCodigosEspecificosInsumo(new ArrayList<CodigoEspecificoInsumo>());
			 insumo.getCodigosEspecificosInsumo().add(new CodigoEspecificoInsumo(insumo,insumo.getCodigosConcatenadosInsumo()));
		 }
		
	}
	

}
