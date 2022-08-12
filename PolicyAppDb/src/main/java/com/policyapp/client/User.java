package com.policyapp.client;

import com.policyapp.exception.PolicyNotFoundException;
import com.policyapp.model.Policy;
import com.policyapp.service.IPolicyService;
import com.policyapp.service.PolicyServiceImpl;

public class User {
	public static void main(String[] args) {
		IPolicyService pol = new PolicyServiceImpl();
//		Policy policy=new Policy("Jevan Labh",1,10000,"retirement",10,"Family","LIC","guhg",200000);
//				pol.addPolicy(policy);

//		pol.deletePolicy(3);
//		pol.updatePolicy(1, "wife");
//		pol.getAll().forEach(System.out::println);
//		
//		try {
//			pol.getByType("Helth").forEach(System.out::println);
		//pol.getByCategory("LIC").forEach(System.out::println);
//		pol.getByBrand("LIC").forEach(System.out::println);
//		pol.getByCoverage("LIC").forEach(System.out::println);
//		pol.getByHighSumAssured("LIC").forEach(System.out::println);
//		pol.getById("LIC").forEach(System.out::println);
//		pol.getByLessPremium("LIC").forEach(System.out::println);
//		} catch (PolicyNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			pol.getByCategory("LIC").forEach(System.out::println);
		} catch (PolicyNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}
}
