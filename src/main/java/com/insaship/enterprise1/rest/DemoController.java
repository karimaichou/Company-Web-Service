package com.insaship.enterprise1.rest;


import com.insaship.enterprise1.dao.IOfferDao;
import com.insaship.enterprise1.dao.entity.OfferEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/oneOffer", method = RequestMethod.GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public ResponseEntity<OfferEntity> getOneOffer() {
        return new ResponseEntity(offerDao.findOne(3), HttpStatus.OK);
    }
}
