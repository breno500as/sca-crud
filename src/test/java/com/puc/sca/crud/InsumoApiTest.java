package com.puc.sca.crud;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.puc.sca.crud.entity.insumo.CodigoEspecificoInsumo;
import com.puc.sca.crud.entity.insumo.Insumo;
import com.puc.sca.crud.entity.insumo.SubTipoInsumo;
import com.puc.sca.crud.entity.insumo.TipoInsumo;
import com.puc.sca.crud.entity.insumo.TipoMarcaModelo;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class InsumoApiTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	public void postInsumo() throws Exception {
		final Insumo insumo = new Insumo();

		insumo.setTipoInsumo(new TipoInsumo(1L));
		insumo.setSubTipoInsumo(new SubTipoInsumo(1L));
		insumo.setTipoMarcaModelo(new TipoMarcaModelo(1L));
		insumo.setObservacoes("abc");
		insumo.setLinkInformacoesTecnicasFornecedor("http://www.google.com");
		insumo.setQuantidade(2);

		List<CodigoEspecificoInsumo> codigos = new ArrayList<CodigoEspecificoInsumo>();
		codigos.add(new CodigoEspecificoInsumo(UUID.randomUUID().toString()));
		codigos.add(new CodigoEspecificoInsumo(UUID.randomUUID().toString()));
		insumo.setCodigosEspecificosInsumo(codigos);

		final String s = objectMapper.writeValueAsString(insumo);

		this.mvc.perform(post("/").contentType(MediaType.APPLICATION_JSON).content(s)).andExpect(status().isOk());

		System.out.println("braminha");

	}

}
