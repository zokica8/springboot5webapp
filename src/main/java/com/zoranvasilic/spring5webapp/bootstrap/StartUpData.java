package com.zoranvasilic.spring5webapp.bootstrap;

import com.zoranvasilic.spring5webapp.model.Address;
import com.zoranvasilic.spring5webapp.model.Author;
import com.zoranvasilic.spring5webapp.model.Book;
import com.zoranvasilic.spring5webapp.model.Publisher;
import com.zoranvasilic.spring5webapp.repositories.AddressRepository;
import com.zoranvasilic.spring5webapp.repositories.AuthorRepository;
import com.zoranvasilic.spring5webapp.repositories.BookRepository;
import com.zoranvasilic.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartUpData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final AddressRepository addressRepository;

    public StartUpData(AuthorRepository authorRepository, BookRepository bookRepository,
                       PublisherRepository publisherRepository, AddressRepository addressRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author bruce = new Author("Bruce", "Eckel");
        Author svetlana = new Author("Svetlana", "Isakova");
        Book onJava8 = new Book("On Java 8", "234000");
        Book atomicKotlin = new Book("Atomic Kotlin", "983321");
        Publisher publisher = new Publisher("MindView");
        Address address = new Address("10th Downing Street", "Denver",
                "Colorado", "83");

        addressRepository.save(address);
        publisherRepository.save(publisher);

        bruce.getBooks().add(onJava8);
        onJava8.getAuthors().add(bruce);
        onJava8.setPublisher(publisher);

        authorRepository.save(bruce);
        bookRepository.save(onJava8);
        publisherRepository.save(publisher);

        bruce.getBooks().add(atomicKotlin);
        svetlana.getBooks().add(atomicKotlin);
        atomicKotlin.getAuthors().add(svetlana);
        atomicKotlin.getAuthors().add(bruce);
        publisher.getAddresses().add(address);
        publisher.getBooks().add(atomicKotlin);
        publisher.getBooks().add(onJava8);
        atomicKotlin.setPublisher(publisher);

        authorRepository.save(svetlana);
        bookRepository.save(atomicKotlin);
        publisherRepository.save(publisher);

        System.out.println("Number of authors: " + authorRepository.count());
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("Number of addresses: " + addressRepository.count());
        System.out.printf("Number of books by publisher %s: %d.", publisher.getName(), publisher.getBooks().size());
    }
}
