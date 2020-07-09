package com.puc.sca.crud.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.puc.sca.crud.dto.InsumoDTO;
import com.puc.sca.crud.entity.insumo.CodigoEspecificoInsumo;
import com.puc.sca.crud.entity.insumo.Insumo;
import com.puc.sca.crud.entity.insumo.SubTipoInsumo;
import com.puc.sca.crud.entity.insumo.TipoInsumo;
import com.puc.sca.crud.entity.insumo.TipoMarcaModelo;
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
	public ResponseEntity<InsumoDTO> save(@RequestBody @Valid InsumoDTO insumoDTO) {
		
		final Insumo insumo = this.modelMapper.map(insumoDTO, Insumo.class);
		
		if (insumoDTO.getCodigosConcatenadosInsumo() != null && !insumoDTO.getCodigosConcatenadosInsumo().isEmpty()) {
			 this.saveCodigoEspecificoInsumo(insumo, insumoDTO);
		} 
		
		final Insumo insumoDb = this.insumoRepository.save(insumo);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.modelMapper.map(insumoDb, InsumoDTO.class));
	}
	
	
	@PostMapping("/upload")
	public ResponseEntity<Object> handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}
	

	@PutMapping("{id}")
	@Operation(summary = "Atualiza o insumo", description = "Recebe um insumo e o id do insumo para persistência", tags = { "insumos" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Insumo atualizado"),
			@ApiResponse(responseCode = "400", description = "Id inválido"),
			@ApiResponse(responseCode = "404", description = Insumo.NAO_ENCONTRADO) })
	public ResponseEntity<InsumoDTO> update(@PathVariable(value = "id") Long id, @RequestBody @Valid InsumoDTO insumoDTO) {
		 
		final Insumo insumoDB = this.insumoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Insumo.NAO_ENCONTRADO));
		
		// Verificar, pois com o model mapper não está updatando
		//this.modelMapper.map(insumoDTO, insumoDB);
		BeanUtils.copyProperties(insumoDTO, insumoDB);
		
		insumoDB.setSubTipoInsumo(insumoDTO.getSubTipoInsumo().getId() == null ? null : new SubTipoInsumo(insumoDTO.getSubTipoInsumo().getId()));
		insumoDB.setTipoMarcaModelo(insumoDTO.getTipoMarcaModelo().getId() == null ? null : new TipoMarcaModelo(insumoDTO.getTipoMarcaModelo().getId()));
		insumoDB.setTipoInsumo(insumoDTO.getTipoInsumo().getId() == null ? null : new TipoInsumo(insumoDTO.getTipoInsumo().getId()));
		
		this.insumoRepository.save(insumoDB);
   	
		if (insumoDTO.getCodigosConcatenadosInsumo() != null && !insumoDTO.getCodigosConcatenadosInsumo().isEmpty()) {
			 
			 List<CodigoEspecificoInsumo> codigosEspecificosDelete = this.codigoEspecificoInsumoRespository.findAllByInsumo(insumoDB);
			 if (codigosEspecificosDelete != null && !codigosEspecificosDelete.isEmpty()) {
				  this.codigoEspecificoInsumoRespository.deleteAll(codigosEspecificosDelete);
			 }
			
			 this.saveCodigoEspecificoInsumo(insumoDB, insumoDTO);
		}
		
		
		 
		return ResponseEntity.ok(this.modelMapper.map(insumoDB, InsumoDTO.class));
	}
	
	@DeleteMapping("{id}")
	@Operation(summary = "Deleta um insumo", description = "", tags = { "insumos" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "sucesso"),
			@ApiResponse(responseCode = "404", description = Insumo.NAO_ENCONTRADO) })
	public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id) {
		
		final Insumo insumo = this.insumoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Insumo.NAO_ENCONTRADO));
		
        this.insumoRepository.delete(insumo);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
	@GetMapping("{id}")
	@Operation(summary = "Encontra o insumo pelo id", description = "Returna um único insumo", tags = { "insumos" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "sucesso", content = @Content(schema = @Schema(implementation = Insumo.class))),
			@ApiResponse(responseCode = "404", description = Insumo.NAO_ENCONTRADO) })
	public ResponseEntity<InsumoDTO> findById(@PathVariable(value = "id") Long id) {

		final Insumo insumo = this.insumoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Insumo.NAO_ENCONTRADO));
		final InsumoDTO insumoDTO = this.modelMapper.map(insumo, InsumoDTO.class);

		if (insumo.getCodigosEspecificosInsumo() != null && !insumo.getCodigosEspecificosInsumo().isEmpty()) {
			insumoDTO.setCodigosConcatenadosInsumo(insumo.getCodigosEspecificosInsumo().stream().map(CodigoEspecificoInsumo::getCodigo).collect(Collectors.joining(",")));
		}

		return ResponseEntity.ok(insumoDTO);

	}
	

	@GetMapping
	@Operation(summary = "Recupera os insumos", description = "Retorna os insumos de acordo com o tamanho da página", tags = { "insumos" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "sucesso", content = @Content(schema = @Schema(implementation = Insumo.class))) })
	public ResponseEntity<Iterable<InsumoDTO>> findAll(@RequestParam("page") Integer page, 
			                        @RequestParam("size") Integer size,
			                        @RequestParam(value = "direction", defaultValue = "asc") String direction,
			                        @RequestParam(value = "tipoInsumo", required = false) Long tipoInsumo,
			                        @RequestParam(name = "sort", defaultValue = "id") String sort) {
		
		final Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		final Pageable pageable = PageRequest.of(page - 1, size, Sort.by(sortDirection,sort));

		Page<Insumo> result = null;

		if (tipoInsumo != null) {
			result = this.insumoRepository.findAllByTipoInsumo(new TipoInsumo(tipoInsumo), pageable);
		} else {
			result = this.insumoRepository.findAll(pageable);
		}

		final List<Insumo> insumos = result.get().collect(Collectors.toList());
	 
		final List<InsumoDTO> insumosDTO  = this.modelMapper.map(insumos, new TypeToken<List<InsumoDTO>>() {}.getType());
		
		if (!insumosDTO.isEmpty()) {
			insumosDTO.get(0).setTotalElementos(result.getTotalElements());
		}

		return ResponseEntity.ok(insumosDTO);
	}
	
	private void saveCodigoEspecificoInsumo(Insumo insumo, InsumoDTO insumoDTO) {
		 if (insumoDTO.getCodigosConcatenadosInsumo().contains(",")) {
			 insumo.setCodigosEspecificosInsumo((Arrays.asList(insumoDTO.getCodigosConcatenadosInsumo().split(",")).stream().map(codigo -> new CodigoEspecificoInsumo(insumo,codigo)).collect(Collectors.toList())));
		 } else {
			 insumo.setCodigosEspecificosInsumo(new ArrayList<CodigoEspecificoInsumo>());
			 insumo.getCodigosEspecificosInsumo().add(new CodigoEspecificoInsumo(insumo,insumoDTO.getCodigosConcatenadosInsumo()));
		 }	
	}
	
}
