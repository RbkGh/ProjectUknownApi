package com.swiftpot.projectuknown.repository;

import com.swiftpot.projectuknown.db.model.BusinessOrServiceDocEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at [rodney@swiftpot.com,rbk.unlimited@gmail.com]> on
 *         09-Sep-16 @ 11:09 PM
 */
public interface BusinessOrServiceDocEntityRepository extends MongoRepository<BusinessOrServiceDocEntity,String> {

}
