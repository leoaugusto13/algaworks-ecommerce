package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;
import org.junit.jupiter.api.*;

public class ConsultandoRegistrosTest extends EntityManagerTest {

    @Test
    public void searchById(){
        Produto produto = entityManager.getReference(Produto.class, 1);

        Assertions.assertNotNull(produto);
        Assertions.assertEquals("Kindle", produto.getNome());

    }

    @Test
    public void updateReferenceProduct(){
        Produto produto = entityManager.find(Produto.class, 1);
        produto.setNome("Processador Ryzen");

        entityManager.refresh(produto);

        Assertions.assertEquals("Kindle", produto.getNome());
    }


}
