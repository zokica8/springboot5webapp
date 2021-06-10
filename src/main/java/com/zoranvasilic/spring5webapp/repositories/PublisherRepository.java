package com.zoranvasilic.spring5webapp.repositories;

import com.zoranvasilic.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
