package au.com.ericliu.spring_helloworld.landom.data.repository;

import au.com.ericliu.spring_helloworld.landom.data.entity.Guest;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends PagingAndSortingRepository<Guest, Long> {

}