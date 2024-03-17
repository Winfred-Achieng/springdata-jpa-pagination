package com.winfred.pagination.repository;

import com.winfred.pagination.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person,Integer> {


}
