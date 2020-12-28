package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Cliente;

import com.algaworks.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;



public class PrimeiroCrudTest extends EntityManagerTest {

    @Test
    public void inserirCliente(){
        Cliente cliente = new Cliente();

        cliente.setId(3);
        cliente.setNome("Rafael Soares");

        entityManager.getTransaction().begin();

        entityManager.persist(cliente);

        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertNotNull(clienteVerificacao);
    }

    @Test
    public void removerCliente() {

        Cliente cliente = entityManager.find(Cliente.class, 2);


        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();

//        entityManager.clear(); Não é necessário na asserção para operação de remoção.

        Cliente clienteVerificacao = entityManager.find(Cliente.class, 2);
        Assert.assertNull(clienteVerificacao);
    }

    @Test
    public void buscarClientePorIdentificador(){
        Cliente cliente = entityManager.find(Cliente.class, 2);

        Assert.assertNotNull(cliente);
        Assert.assertEquals("Leonardo Augusto dos Santos Soares", cliente.getNome());

    }

    @Test
    public void atualizarClienteGerenciado(){
        Cliente cliente = entityManager.find(Cliente.class, 1);


        entityManager.getTransaction().begin();
        cliente.setNome("Miguel Soares");
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertEquals("Miguel Soares", clienteVerificacao.getNome());
    }

    @Test
    public void abrirEFecharATransacao(){


        entityManager.getTransaction().begin();



        entityManager.getTransaction().commit();
    }
}
