package com.insa.rest;


import com.insa.dao.IOfferDao;
import com.insa.dao.entity.OffreEntity;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Franck-Gravouil on 17/11/2016.
 */
@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OffersController {

    @Autowired
    private IOfferDao offerDao;

    @RequestMapping(value = "/offres", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public ResponseEntity<OffreEntity> getOffres() {
        return new ResponseEntity(offerDao.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/offre", method = RequestMethod.GET)
    @ApiOperation(value = "Recherche une offre pour un id donné")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Offre trouvée"), @ApiResponse(code = 404, message = "Aucune offre trouvée.") })
@   Transactional(readOnly = true)
    public ResponseEntity<OffreEntity> getUniqueOffre(@RequestParam(value = "id") int id) {

        ResponseEntity<OffreEntity> responseEntity;
        OffreEntity offer;
        offer = offerDao.findOne(id);

        if(offer == null) {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            responseEntity = new ResponseEntity<>(offer, HttpStatus.OK);
        }

        return responseEntity;
    }

    @RequestMapping(value = "/recherche/offre", method = RequestMethod.GET)
    @ApiOperation(value = "Recherche une offre de stage pour un mot clé donné ")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Offre trouvée"), @ApiResponse(code = 404, message = "Aucune offre trouvée.") })
    public ResponseEntity<List<OffreEntity>> getRechercheResult(@RequestParam(value = "key") String keyword) {

        ResponseEntity<List<OffreEntity>> responseEntity;
        List<OffreEntity> offers;

        offers = offerDao.findOfferByKeyWord(keyword);

        if(offers.isEmpty()) {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            responseEntity = new ResponseEntity<>(offers, HttpStatus.OK);
        }

        return responseEntity;
    }
}
