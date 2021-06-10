package com.zoranvasilic.spring5webapp.repositories;

import com.zoranvasilic.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
