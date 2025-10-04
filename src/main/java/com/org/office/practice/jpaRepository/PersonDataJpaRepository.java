package com.org.office.practice.jpaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.org.office.practice.data.PersonData;
import com.org.office.practice.dto.PersonBornBetweenYearData;
@Repository
public interface PersonDataJpaRepository extends JpaRepository<PersonData, Integer> {

	//List<PersonBornBetweenYearData> getPersonBornbetweenYears(int fromYear, int toYear);
	@Query("SELECT new com.org.office.practice.dto.PersonBornBetweenYearData(p.personId, p.name, p.dob) " +
	           "FROM PersonData p WHERE FUNCTION('YEAR', p.dob) BETWEEN :fromYear AND :toYear")
	    List<PersonBornBetweenYearData> findPersonsBornBetweenYears(@Param("fromYear") int fromYear,
	                                                                 @Param("toYear") int toYear);
	
		PersonData findByName(String name);
	
	
}