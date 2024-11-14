package org.example;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("libraryPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Author author = new Author("R.Kipling");
        Book bookOne = new Book(new BookId("1234567", "2nd"),"The Jungle Book", author);
        Book bookTwo = new Book(new BookId("7654321", "2nd"),"Just so Stories", author);
        author.setBooks(List.of(bookOne, bookTwo));

        em.persist(author);
        em.getTransaction().commit();

        //read data
       Author foundAuthor = em.find(Author.class, author.getId());
       System.out.println("Author: "+foundAuthor.getName());
       foundAuthor.getBooks().forEach(book -> {
           System.out.println("Book: "+book.getId().getIsbn()
                   +", "+book.getId().getEdition()
                   +", "+book.getTitle());
       });
    }
}