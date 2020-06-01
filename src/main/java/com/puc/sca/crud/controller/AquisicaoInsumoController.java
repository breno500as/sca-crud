package com.puc.sca.crud.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.puc.sca.crud.dto.InsumoFornecedorDTO;
import com.puc.sca.crud.entity.insumo.SubTipoInsumo;
import com.puc.sca.crud.enums.Fornecedor;

/**
 * Rest controller que integra com sistemas de terceiros para solicitar e acompanhar
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
	
	private static final Logger logger = LogManager.getLogger(AquisicaoInsumoController.class);

	 
	

	/**
	 * Solicita um insumo para um fornecedor, se disponível o sistema de aquisições
	 * pode retornar um número de solicitação, e armarzenar em uma tabela de
	 * solicitações.
	 * 
	 * @param insumoFornecedorDTO - {@link InsumoFornecedorDTO}.
	 * @return
	 */

	@PostMapping
	public void solitaAquisicaoInsumo(@RequestBody InsumoFornecedorDTO insumoFornecedorDTO) {

		switch (insumoFornecedorDTO.getFornecedor()) {

		
		case FURLAN:
			logger.info(Fornecedor.FURLAN);
			break;

		case BRASTORNO:
			logger.info(Fornecedor.BRASTORNO);
			break;

		case BERCAM:
			logger.info(Fornecedor.BERCAM);
			break;

		default:
			break;
		}
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
	public List<String> comparativoDePrecos(@PathVariable("idTipoDescricaoInsumo") Long tipoDescricaoInsumoId) {
		return Collections.emptyList();
	}

	/**
	 * Método que será invocado em caso de falha do microserviço.
	 * 
	 * @return
	 */

	public List<String> reliableInformacoes() {
		List<String> lista = new ArrayList<>();
		lista.add("Informações..");
		return lista;
	}

	/**
	 * API para saber detalhes do acompanhamento da solicitação do insumo, tais como
	 * previsão de entrega local físico em que o insumo se encontra, informações de
	 * deslocamento, etc.
	 * 
	 * @param numeroSolicitacao - número da solicitação de aquisição de insumo
	 *                          retornado pelo sistema de aquisição dos fornecedores
	 *                          pré cadastrados
	 * @return um objeto com as informações para criação de uma tela de
	 *         acompanhamento.
	 */

	@HystrixCommand(fallbackMethod = "reliableInformacoes")
	@GetMapping("informacoes-solicitacao/{numeroSolicitacao}")
	public List<String> informacoesSolicitacaoAquisicao(@PathVariable("numeroSolicitacao") String numeroSolicitacao) {
		return Collections.emptyList();
	}

}
