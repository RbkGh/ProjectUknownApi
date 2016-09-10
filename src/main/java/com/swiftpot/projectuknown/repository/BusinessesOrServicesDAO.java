package com.swiftpot.projectuknown.repository;


import com.google.gson.Gson;
import com.swiftpot.projectuknown.db.model.BusinessOrServiceDocEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
    Gson gson;

    public List<BusinessOrServiceDocEntity> findBusinessesOrServicesNearSpecificLocation(Point location,double maxDistanceInKM){
        //Point location = new Point(-73.99171, 40.738868);
        NearQuery query = NearQuery.near(location).maxDistance(new Distance(maxDistanceInKM, Metrics.KILOMETERS));
        GeoResults<BusinessOrServiceDocEntity> geoResults = mongoOperations.geoNear(query, BusinessOrServiceDocEntity.class);

        List<BusinessOrServiceDocEntity> businessOrServiceDocEntityList = new ArrayList<>(0);
        if (!geoResults.getContent().isEmpty()) {
            int i = 0;
            for (GeoResult<BusinessOrServiceDocEntity> businessOrServiceDocEntity : geoResults) {
                businessOrServiceDocEntityList.add(businessOrServiceDocEntity.getContent());
                log.info("GeoResult Number {},{}\n", i++, gson.toJson(businessOrServiceDocEntity));

            }

        }else{
            //add nothing to list since its empty,return empty list
        }

        return businessOrServiceDocEntityList;
    }
}
