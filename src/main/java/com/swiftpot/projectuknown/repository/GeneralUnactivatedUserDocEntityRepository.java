package com.swiftpot.projectuknown.repository;

import com.swiftpot.projectuknown.db.model.GeneralUnactivatedUserDocEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at [rodney@swiftpot.com,rbk.unlimited@gmail.com]> on
 *         08-Sep-16 @ 10:32 AM
 */
@Repository
public interface GeneralUnactivatedUserDocEntityRepository extends MongoRepository<GeneralUnactivatedUserDocEntity,String> {
}
