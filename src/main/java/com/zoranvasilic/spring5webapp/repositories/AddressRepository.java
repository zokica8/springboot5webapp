package com.zoranvasilic.spring5webapp.repositories;

import com.zoranvasilic.spring5webapp.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
