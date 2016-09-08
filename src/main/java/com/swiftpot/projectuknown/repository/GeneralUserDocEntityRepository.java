package com.swiftpot.projectuknown.repository;

import com.swiftpot.projectuknown.db.model.GeneralUserDocEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at [rodney@swiftpot.com,rbk.unlimited@gmail.com]> on
 *         03-Sep-16 @ 8:35 PM
 */
@Repository
public interface GeneralUserDocEntityRepository extends MongoRepository<GeneralUserDocEntity,Long> {
     GeneralUserDocEntity findByPhoneNumberAndPassWord(int phoneNumber,String passWord);
     GeneralUserDocEntity findById(String id);

}
