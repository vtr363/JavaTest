package sistemabancario;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de teste criada para garantir o funcionamento das principais operações
 * sobre clinetes, realizadas pela classe {@link GerenciadoraClientes}
 * 
 * @author Clayton Chagas
 * @date 18/08/2023
 * 
 */
public class GerenciadoraClientesTeste2 {

	private GerenciadoraClientes gerClientes;

	private int idCliente01 = 1;
	private int idCliente02 = 2;
	
	/*
	 * @Before: Anotação que roda a montagem de cenario antes da execução dos testes
	 */
	@Before
	public void setup() {
		/*=====Montagem do cenário de teste=====*/
		//criando alguns clientes
		
		Cliente cliente01 = new Cliente(idCliente01, "João da Silva", 20, "joaodasilva@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(idCliente02, "Maria da Silva", 18, "mariadasilva@gmail.com", 1, true);

		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<Cliente>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);

		gerClientes = new GerenciadoraClientes(clientesDoBanco);
	}

	@After
	public void tearDown() {
		gerClientes.limpa();
	}

	/**
	 * Teste basico da pesquisa de um cliente a partir do seu ID
	 * 
	 * @author Clayton Chagas
	 * @date 18/08/2023
	 */
	@Test
	public void testPesquisaCliente() {
		
		/*=====Execução do Teste=====*/
		Cliente cliente = gerClientes.pesquisaCliente(idCliente01);
		
		/*=====Verificação e Avaliação do Teste=====*/
		assertThat(cliente.getId(), is(idCliente01));
		
	}


	/**
	 * Teste básico da remoção de um cliente a partir do ID
	 * 
	 * @author Victor Miguel
	 * @date 25//08/2023
	 */
	@Test
	public void testRemoveCliente(){

		/*=============Execução da regra de negócio==========*/
		boolean resultadoRemocaoCliente = gerClientes.removeCliente(idCliente02);

		/*=============Execução da regra de negócio a ser testada=========*/
		assertThat(resultadoRemocaoCliente, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCliente02));
	}
	
	@Test
	public void testeRemoveClienteInexistente() {
		/********MOntagem do cenario é chamada automaticamente pelo @BEfore****************/
		boolean resultadoRemocaoCliente = gerClientes.removeCliente(10);

		assertFalse(resultadoRemocaoCliente);
		assertThat(gerClientes.getClientesDoBanco().size(), is(2));
	}


}