package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

public class ConsultandoRegistrosTest {

    private static EntityManagerFactory entityManagerFactory;

    private static EntityManager entityManager;

    @BeforeAll()
    public static void setupBeforeAll(){
        entityManagerFactory = Persistence.createEntityManagerFactory("Ecommerce-PU");
    }

    @AfterAll
    public static void tearDownAfterAll(){
        entityManagerFactory.close();
    }

    @BeforeEach
    public void setUp(){
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterEach
    public void tearDown(){
        entityManagerFactory.close();
    }

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
