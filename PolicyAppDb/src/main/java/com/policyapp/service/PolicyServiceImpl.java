package com.policyapp.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.policyapp.dao.IpolicyDAO;
import com.policyapp.dao.PolicyDAOImpl;
import com.policyapp.exception.IdNotFoundException;
import com.policyapp.exception.PolicyNotFoundException;
import com.policyapp.model.Policy;

public class PolicyServiceImpl implements IPolicyService {
	IpolicyDAO policyDao = new PolicyDAOImpl();

	@Override
	public void addPolicy(Policy policy) {
		policyDao.addPolicy(policy);
	}

	@Override
	public void deletePolicy(int policyId) {
		policyDao.deletePolicy(policyId);
	}

	@Override
	public void updatePolicy(int policyId, String coverage) {
		policyDao.updatePolicy(policyId, coverage);
	}

	@Override
	public List<Policy> getAll() {
		List<Policy> policies = policyDao.findAll();
		return policies;

	}

	@Override
	public List<Policy> getByType(String type) throws PolicyNotFoundException {
		List<Policy> policies = policyDao.findByType(type);
		return policies;

	}

	@Override
	public List<Policy> getByCategory(String category) throws PolicyNotFoundException {
		List<Policy> policies = policyDao.findByCategory(category);
		return policies;
	}

	@Override
	public List<Policy> getByHighSumAssured(Double sumAssured) throws PolicyNotFoundException {
		List<Policy> policies = policyDao.findByHighSumAssured(sumAssured);
		return policies;
	}

	@Override
	public List<Policy> getByCoverage(String coverage) throws PolicyNotFoundException {
		List<Policy> policies = policyDao.findByCoverage(coverage);
		return policies;
	}

	@Override
	public List<Policy> getByLessPremium(double premium) throws PolicyNotFoundException {
		List<Policy> policies = policyDao.findByLessPremium(premium);
		return policies;
	}

	@Override
	public Policy getById(int policyId) throws IdNotFoundException {
		Policy policy =   policyDao.findById(policyId);
		return  policy;
	}

	@Override
	public List<Policy> getByBrand(String brand) throws PolicyNotFoundException {
		List<Policy> policies = policyDao.findByBrand(brand);
		return policies;
	}

}