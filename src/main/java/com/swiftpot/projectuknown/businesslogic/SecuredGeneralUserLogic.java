package com.swiftpot.projectuknown.businesslogic;

import com.swiftpot.projectuknown.db.model.BusinessOrServiceDocEntity;
import com.swiftpot.projectuknown.model.GeneralUserSearchRequest;
import com.swiftpot.projectuknown.model.OutgoingPayload;
import com.swiftpot.projectuknown.model.SuccessfulOutgoingPayload;
import com.swiftpot.projectuknown.repository.BusinessesOrServicesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at [rodney@swiftpot.com,rbk.unlimited@gmail.com]> on
 *         08-Sep-16 @ 11:52 PM
 */

@SuppressWarnings("SpringJavaAutowiringInspection")
@Service
public class SecuredGeneralUserLogic {

    @Autowired
    BusinessesOrServicesDAO businessesOrServicesDAO;

    public OutgoingPayload generalUserSearchRequestHandler(GeneralUserSearchRequest generalUserSearchRequest){

        double[] locationCoords = generalUserSearchRequest.getUserLocation();
        double longitude = locationCoords[0];
        double latitude = locationCoords[1];
        Point location = new Point(longitude,latitude);
        double maxDistanceInKM = generalUserSearchRequest.getMaxDistance();

        //We use GeoResult because we want to add each distance from businessLocation from user's location,also to not worry about deserializing into different object for responseObject
        List<GeoResult<BusinessOrServiceDocEntity>> businessOrServiceDocEntityList = businessesOrServicesDAO.findBusinessesUsingSearchQueryAndLocation(location, maxDistanceInKM,generalUserSearchRequest.getSearchQuery());
        OutgoingPayload outgoingPayload ;

        if((businessOrServiceDocEntityList.isEmpty()) || (businessOrServiceDocEntityList == null)){
            outgoingPayload = new SuccessfulOutgoingPayload("No businesses or services match the search criteria",null);
        }else{
            outgoingPayload = new SuccessfulOutgoingPayload(businessOrServiceDocEntityList);
        }
        return outgoingPayload;
    }
}
