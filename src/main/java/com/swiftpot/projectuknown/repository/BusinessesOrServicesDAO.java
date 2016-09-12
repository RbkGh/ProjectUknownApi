package com.swiftpot.projectuknown.repository;


import com.google.gson.Gson;
import com.swiftpot.projectuknown.db.model.BusinessOrServiceDocEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at [rodney@swiftpot.com,rbk.unlimited@gmail.com]> on
 *         09-Sep-16 @ 8:19 PM
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Repository
public class BusinessesOrServicesDAO {

    Logger log = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    MongoOperations mongoOperations;
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    Gson gson;



    public List<GeoResult<BusinessOrServiceDocEntity>> findBusinessesUsingSearchQueryAndLocation(Point location,double maxDistanceInKM,String searchQuery){
        //List<BusinessOrServiceDocEntity> businessOrServiceDocEntityList = new ArrayList<>(0);

        String[] searchQueryDetokenizedArray = searchQuery.trim().split("\\s+"); //regexp equivalent for [ \\t\\n\\x0B\\f\\r],dodge all whitespaces

        log.info("Array of detokenized String = {}", gson.toJson(searchQueryDetokenizedArray));

        Query query = TextQuery.queryText(new TextCriteria().matchingAny(searchQueryDetokenizedArray)).sortByScore();

        List<BusinessOrServiceDocEntity> businessOrServiceDocEntitySearchQueryResultList;
        List<GeoResult<BusinessOrServiceDocEntity>> businessOrServiceDocEntityNearLocationResultList;

        List<GeoResult<BusinessOrServiceDocEntity>> businessOrServiceDocEntityFinallySortedList = new ArrayList<>(0);


        businessOrServiceDocEntitySearchQueryResultList = mongoTemplate.find(query, BusinessOrServiceDocEntity.class);

        businessOrServiceDocEntityNearLocationResultList = findBusinessesOrServicesNearSpecificLocation(location,maxDistanceInKM);

        //extra sort
        if(businessOrServiceDocEntitySearchQueryResultList.isEmpty()){
            //empty,forget about everything and return an empty List,remember u don't need to check both lists since when one is zero,the other is automatically useless
        }else{
            for(BusinessOrServiceDocEntity businessOrServiceDocEntitySearch : businessOrServiceDocEntitySearchQueryResultList){


                //search all location entities to get a match
               for(GeoResult<BusinessOrServiceDocEntity> businessOrServiceDocEntityLocation : businessOrServiceDocEntityNearLocationResultList){
                   if(businessOrServiceDocEntitySearch.getId().equalsIgnoreCase(businessOrServiceDocEntityLocation.getContent().getId())){
                       //present in both entities,do not remove from List
                       //add to new Fresh List since removing in else statement will lead to java.util.ConcurrentModificationException....
                       businessOrServiceDocEntityFinallySortedList.add(businessOrServiceDocEntityLocation);
                   }else{
                       //remove from SearchQueryList as the location is not within what user requested
                       //do not remove from List as this will lead to java.util.ConcurrentModificationException,since immediately an element is removed from list,the iteration breaks
                       //Simply put,do not add to finallySortedList instead

                   }

               }
            }
        }

        log.info("\n\n\nSearchQueryResultList ==== {},\n\n\nNearLocationResultList ==== {},\n\n\nFinallySortedResultList ==== {}",
                gson.toJson(businessOrServiceDocEntitySearchQueryResultList),
                gson.toJson(businessOrServiceDocEntityNearLocationResultList),
                gson.toJson(businessOrServiceDocEntityFinallySortedList));

        return businessOrServiceDocEntityFinallySortedList;
    }

    public List<GeoResult<BusinessOrServiceDocEntity>> findBusinessesOrServicesNearSpecificLocation(Point location,double maxDistanceInKM){
        //Point location = new Point(-73.99171, 40.738868);
        NearQuery query = NearQuery.near(location).maxDistance(new Distance(maxDistanceInKM, Metrics.KILOMETERS));

        GeoResults<BusinessOrServiceDocEntity> geoResults = mongoOperations.geoNear(query, BusinessOrServiceDocEntity.class);


        List<GeoResult<BusinessOrServiceDocEntity>> geoResultArrayList = new ArrayList<>(0);

        if (!geoResults.getContent().isEmpty()) {
            int i = 0;
            for (GeoResult<BusinessOrServiceDocEntity> businessOrServiceDocEntity : geoResults) {

                geoResultArrayList.add(businessOrServiceDocEntity);
                log.info("GeoResult Number {},{}\n", i++, gson.toJson(businessOrServiceDocEntity));

            }

        }else{
            //add nothing to list since its empty,return empty list
        }

        return geoResultArrayList;
    }
}
