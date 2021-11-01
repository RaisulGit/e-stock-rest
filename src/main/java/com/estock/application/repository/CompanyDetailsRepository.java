package com.estock.application.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.estock.application.model.CompanyDetails;

@Repository
public interface CompanyDetailsRepository extends JpaRepository<CompanyDetails, Long> {
	@Query("select cd FROM CompanyDetails cd WHERE cd.companyCode=?1")
	public CompanyDetails findCompanyDetailsById(Long companyCode);

	@Transactional
	@Modifying
	@Query("delete FROM CompanyDetails de WHERE de.companyCode=?1")
	public Integer deleteByCompanyCode(Long companyCode);
}
