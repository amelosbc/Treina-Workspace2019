package com.amelosbc.reservationdemo.data.repository;

import org.springframework.data.repository.CrudRepository;
import com.amelosbc.reservationdemo.data.entity.Guest;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {

	Guest findOne(long guestId);

}