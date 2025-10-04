package com.org.office.practice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.org.office.practice.data.AddressData;
import com.org.office.practice.data.ContactData;
import com.org.office.practice.data.QualificationData;
import com.org.office.practice.data.ToppersData;
import com.org.office.practice.dto.ContactInformation;
import com.org.office.practice.dto.PersonContactResultSetDto;
import com.org.office.practice.dto.PersonPhoneAndAddressResponce;
import com.org.office.practice.dto.PersonQualificationResultSet;

import com.org.office.practice.repository.QualificationRepoository;

@Service
public class QualificationService {

	@Autowired
	QualificationRepoository qualificationRepository;

	public Long createQualificationData(QualificationData qualificationDataObjectRequest) {

		String gradeDegree = qualificationDataObjectRequest.getGradeDegree();
		String institute = qualificationDataObjectRequest.getInstitute();
		String yearOfComplition = qualificationDataObjectRequest.getYearOfComplition();
		double percentage = qualificationDataObjectRequest.getPercentage();
		String status = qualificationDataObjectRequest.getStatus();
		return qualificationRepository.createQualificationData(gradeDegree, institute, yearOfComplition, percentage,
				status);
	}

	public QualificationData retriveQualificationData(int qId) {

		return qualificationRepository.retriveQualificationData(qId);
	}

	public long updateQualificationData(QualificationData qualificationDataObjectRequest) {
		int qId = qualificationDataObjectRequest.getqId();
		String gradeDegree = qualificationDataObjectRequest.getGradeDegree();
		String institute = qualificationDataObjectRequest.getInstitute();
		String yearOfComplition = qualificationDataObjectRequest.getYearOfComplition();
		double percentage = qualificationDataObjectRequest.getPercentage();
		String status = qualificationDataObjectRequest.getStatus();
		
		return qualificationRepository.updateQualificationData(gradeDegree, institute, yearOfComplition, percentage,
				status, qId);

	}

	public long deleteQualificationData(int qId) {

		return qualificationRepository.deleteQualificationData(qId);
	}

	public long deleteAllQualificationData() {
		return qualificationRepository.deleteAllQualificationData();

	}

	public List<QualificationData> retriveAllQualificationData() {
		return qualificationRepository.retriveAllQualificationData();

	}

	public List<ToppersData> getTopersInTenthAndTwelfth() {
		return qualificationRepository.retriveTopersInTenthAndTwelfth();
	}

}
