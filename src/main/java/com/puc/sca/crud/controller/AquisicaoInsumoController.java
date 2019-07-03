package com.puc.sca.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puc.sca.crud.dto.InsumoFornecedorDTO;
import com.puc.sca.crud.entity.insumo.SubTipoInsumo;

/**
 * API que integra com sistemas de terceiros para solicitar e acompanhar
 * solicitações de insumos.
 * 
 * @author breno
 *
 */

@RestController
@RequestMapping("aquisicoes-insumo")
public class AquisicaoInsumoController {
	
	// Alguns possíveis fornecedores da mineiradora e suas APIs.

	@Value("${url.integracao.forlan}")
	private String forlanUrl;

	@Value("${url.integracao.brastorno}")
	private String brastorno;

	@Value("${url.integracao.bercam}")
	private String bercam;

	/**
	 * Solicita um insumo para um fornecedor, se disponível o sistema de aquisições
	 * pode retornar um número de solicitação, e armarzenar em uma tabela de
	 * solicitações.
	 * 
	 * @param insumoFornecedorDTO - {@link InsumoFornecedorDTO}.
	 * @return
	 */

	@PostMapping
	public String solitaAquisicaoInsumo(@RequestBody InsumoFornecedorDTO insumoFornecedorDTO) {

		switch (insumoFornecedorDTO.getFornecedor()) {

		// TODO - recuperar do profile o endereço dos sistemas de aquisições, tratar
		// exceções, criar tabela de acompanhamentos, etc.
		case FURLAN:

			break;

		case BRASTORNO:

			break;

		case BERCAM:

			break;

		default:
			break;
		}

		return "ok";
	}

	/**
	 * Um possível api que pesquisa nas APIs dos fornecedores retornando um objeto
	 * com uma lista de objetos separados por fornecedor e preço, para comparativo e
	 * futura aquisição.
	 * 
	 * @param tipoDescricaoInsumoId - {@link SubTipoInsumo}
	 * @return
	 */

	@GetMapping("comparativo-precos/{idTipoDescricaoInsumo}")
	public List<Object> comparativoDePrecos(@PathVariable("idTipoDescricaoInsumo") Long tipoDescricaoInsumoId) {
		return new ArrayList<Object>();
	}

	/**
	 * API para saber detalhes do acompanhamento da solicitação do insumo, tais como
	 * previsão de entrega local físico em que o insumo se encontra, informações de
	 * deslocamento, etc.
	 * 
	 * @param numeroSolicitacao - número da solicitação de aquisição de insumo
	 *                          retornado pelo sistema de aquisição dos fornecedores
	 *                          pré cadastrados
	 * @return um objeto com as informações para criação de uma tela de acompanhamento.
	 */

	@GetMapping("informacoes-solicitacao/{numeroSolicitacao}")
	public List<Object> informacoesSolicitacaoAquisicao(@PathVariable("numeroSolicitacao") String numeroSolicitacao) {
		return new ArrayList<Object>();
	}

}
