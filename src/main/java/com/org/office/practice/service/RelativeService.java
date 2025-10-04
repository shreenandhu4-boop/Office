
package com.org.office.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.office.practice.data.RelativeData;
import com.org.office.practice.repository.RelativeRepository;

@Service
public class RelativeService {
	@Autowired
	RelativeRepository relativeRepository;
	
	public long createRelativeData(RelativeData relativeDataObjectRequest) {

		String name = relativeDataObjectRequest.getName();
		String phoneNo =relativeDataObjectRequest.getPhoneNo();
		String relationship = relativeDataObjectRequest.getRelationship();

	   return relativeRepository.createRelativeData(name, phoneNo, relationship);
		
	}
	
	public long  updateRelativeData(RelativeData relativeDataObjectRequest) {
		int rId = relativeDataObjectRequest.getrId();
		String name = relativeDataObjectRequest.getName();
		String phoneNo = relativeDataObjectRequest.getPhoneNo();
		String relationship = relativeDataObjectRequest.getRelationship();

		
		return relativeRepository.updateRelativeData( name, phoneNo, relationship, rId);
}
	
	public long deleteRelativeData(int rId) {

		return relativeRepository.deleteRelativeData(rId);

	}
	public long deleteAllRelativeData() {
		
		return relativeRepository.deleteAllRelativeData();
	
}
	public  List<RelativeData> retriveAllRelativeData() {

	 return relativeRepository.retriveAllRelativeData();
}
	
		
	public RelativeData retriveRelativeData(int rId) {
		
		return relativeRepository.retriveRelativeData(rId);
	}
		
}	
	
	
	


