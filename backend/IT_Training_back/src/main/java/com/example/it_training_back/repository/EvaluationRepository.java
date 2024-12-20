package com.example.it_training_back.repository;

import com.example.it_training_back.entity.Evaluation;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import java.util.List;
import java.util.Optional;


public interface EvaluationRepository extends MongoRepository<Evaluation, String> {

    Optional<Evaluation> findByIdUserAndIdSession(long idUser, long idSession);
    List<Evaluation> findAllByOrderByValuationDateDesc();
    @Query(value = "{ 'readByAdmin': ?0 }", sort = "{ 'valuationDate': -1 }")
    List<Evaluation> findAllByReadByAdmin(boolean readByAdmin);

    @Modifying
    @Query("{ '_id': { $in: ?0 } }")
    @Update("{ '$set': { 'readByAdmin': true } } ")
    int updateListReadByAdmin(List<String> ids);
}
