package com.insaship.enterprise1.dao;

import com.insaship.enterprise1.dao.entity.OfferEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Franck-Gravouil on 17/11/2016.
 */
public interface IOfferDao extends CrudRepository<OfferEntity, Integer> {

    @Query(nativeQuery = true)
    List<OfferEntity> findOfferByKeyWord(@Param("searchTerm") String searchTerm);
}
