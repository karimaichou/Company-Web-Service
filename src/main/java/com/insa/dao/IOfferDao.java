package com.insa.dao;

import com.insa.dao.entity.OffreEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Franck-Gravouil on 17/11/2016.
 */
public interface IOfferDao extends CrudRepository<OffreEntity, Integer> {

    @Query(nativeQuery = true)
    List<OffreEntity> findOfferByKeyWord(@Param("searchTerm") String searchTerm);
}
