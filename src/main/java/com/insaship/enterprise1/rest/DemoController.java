package com.insaship.enterprise1.rest;


import com.insaship.enterprise1.dao.IOfferDao;
import com.insaship.enterprise1.dao.entity.OfferEntity;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Franck-Gravouil on 17/11/2016.
 */
@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//@Api(value = "Demo API", description = "Demo API allow to get company offers")
public class DemoController {

    @Autowired
    private IOfferDao offerDao;

    @RequestMapping(value = "/offers", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public ResponseEntity<OfferEntity> getOffers() {
        return new ResponseEntity(offerDao.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/offer", method = RequestMethod.GET)
    @ApiOperation(value = "Get a unique internship offer from its id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Internship found"), @ApiResponse(code = 404, message = "No internship found.") })
@Transactional(readOnly = true)
    public ResponseEntity<OfferEntity> getOneOffer(@RequestParam(value = "id") int id) {

        ResponseEntity<OfferEntity> responseEntity = null;
        OfferEntity offer = null;
        offer = offerDao.findOne(id);

        if(offer == null) {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            responseEntity = new ResponseEntity<>(offer, HttpStatus.OK);
        }

        return responseEntity;
    }

    @RequestMapping(value = "/search/offers", method = RequestMethod.GET)
    @ApiOperation(value = "Get the internship offers where keyword found in title or description")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Internship found"), @ApiResponse(code = 404, message = "No internship found.") })
    public ResponseEntity<List<OfferEntity>> getPersonCampaignResult(@RequestParam(value = "keyword") String keyword) {

        ResponseEntity<List<OfferEntity>> responseEntity = null;
        List<OfferEntity> offers;

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
