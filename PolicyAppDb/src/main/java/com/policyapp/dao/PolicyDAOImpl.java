package com.policyapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.policyapp.exception.IdNotFoundException;
import com.policyapp.exception.PolicyNotFoundException;
import com.policyapp.model.Policy;
import com.policyapp.utill.DbConnection;

public class PolicyDAOImpl implements IpolicyDAO {

	@Override
	public void addPolicy(Policy policy) {
		String sql = "insert into policy(policy_Name,premium,type,duration,coverage,category,brand,sum_Assured) values (?,?,?,?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		connection = DbConnection.openConnection();

		try {
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, policy.getPolicyName());
			preparedstatement.setFloat(2, policy.getPremium());
			preparedstatement.setString(3, policy.getType());
			preparedstatement.setInt(4, policy.getDuration());
			preparedstatement.setString(5, policy.getCoverage());
			preparedstatement.setString(6, policy.getCategory());
			preparedstatement.setString(7, policy.getBrand());
			preparedstatement.setFloat(8, policy.getSumAssured());

			boolean result = preparedstatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("executed sucessfully");
		}

//		preparedstatement.execute();

	}

	@Override
	public void deletePolicy(int policyId) {
		String sql = "delete from policy where policy_id=" + policyId;
		Connection connection = null;
		connection = DbConnection.openConnection();

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("deleted succesfully");
		}
	}

	@Override
	public void updatePolicy(int policyId, String coverage) {

		String sql = "UPDATE policy SET coverage='" + coverage + "' WHERE policy_id=" + policyId;
		Connection connection = null;
		connection = DbConnection.openConnection();

		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	@Override
	public List<Policy> findAll() {
		Connection connection = DbConnection.openConnection();
		String sql = "select * from policy";
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<Policy> policies = new ArrayList<>();
		try {
			statement = connection.prepareStatement(sql);
			rs = statement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("policy_name");
				int policyid = rs.getInt("policy_id");
				float premium = rs.getFloat("premium");
				String type = rs.getString("type");
				int duration = rs.getInt("duration");
				String coverage = rs.getString("coverage");
				String brand = rs.getString("brand");
				String category = rs.getString("category");
				float sumassured = rs.getFloat("sum_assured");

				Policy policies1 = new Policy(name, policyid, premium, type, duration, coverage, brand, category,
						sumassured);
				policies.add(policies1);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return policies;
	}

	@Override
	public List<Policy> findByType(String ntype) throws PolicyNotFoundException {
		Connection connection = DbConnection.openConnection();
		String sql = "select * from policy where type=?";
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<Policy> policies = new ArrayList<>();
		try {

			statement = connection.prepareStatement(sql);
			statement.setString(1, ntype);

			rs = statement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("policy_name");
				int policyid = rs.getInt("policy_id");
				float premium = rs.getFloat("premium");
				String type = rs.getString("type");
				int duration = rs.getInt("duration");
				String coverage = rs.getString("coverage");
				String brand = rs.getString("brand");
				String category = rs.getString("category");
				float sumassured = rs.getFloat("sum_assured");

				Policy policies1 = new Policy(name, policyid, premium, type, duration, coverage, brand, category,
						sumassured);
				policies.add(policies1);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return policies;
	}

	@Override
	public List<Policy> findByCategory(String ncategory) throws PolicyNotFoundException {
		Connection connection = DbConnection.openConnection();
		String sql = "select * from policy where category=?";
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<Policy> policies = new ArrayList<>();
		try {

			statement = connection.prepareStatement(sql);
			statement.setString(1, ncategory);

			rs = statement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("policy_name");
				int policyid = rs.getInt("policy_id");
				float premium = rs.getFloat("premium");
				String type = rs.getString("type");
				int duration = rs.getInt("duration");
				String coverage = rs.getString("coverage");
				String brand = rs.getString("brand");
				String category = rs.getString("category");
				float sumassured = rs.getFloat("sum_assured");

				Policy policies1 = new Policy(name, policyid, premium, type, duration, coverage, brand, category,
						sumassured);
				policies.add(policies1);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return policies;
	}

	@Override
	public List<Policy> findByHighSumAssured(Double nsumAssured) throws PolicyNotFoundException {
		Connection connection = DbConnection.openConnection();
		String sql = "select * from policy where sum_assured>=?";
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<Policy> policies = new ArrayList<>();
		try {

			statement = connection.prepareStatement(sql);
			statement.setDouble(1, nsumAssured);

			rs = statement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("policy_name");
				int policyid = rs.getInt("policy_id");
				float premium = rs.getFloat("premium");
				String type = rs.getString("type");
				int duration = rs.getInt("duration");
				String coverage = rs.getString("coverage");
				String brand = rs.getString("brand");
				String category = rs.getString("category");
				float sumassured = rs.getFloat("sum_assured");

				Policy policies1 = new Policy(name, policyid, premium, type, duration, coverage, brand, category,
						sumassured);
				policies.add(policies1);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return policies;
	}

	@Override
	public List<Policy> findByCoverage(String ncoverage) throws PolicyNotFoundException {
		Connection connection = DbConnection.openConnection();
		String sql = "select * from policy where coverage=?";
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<Policy> policies = new ArrayList<>();
		try {

			statement = connection.prepareStatement(sql);
			statement.setString(1, ncoverage);

			rs = statement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("policy_name");
				int policyid = rs.getInt("policy_id");
				float premium = rs.getFloat("premium");
				String type = rs.getString("type");
				int duration = rs.getInt("duration");
				String coverage = rs.getString("coverage");
				String brand = rs.getString("brand");
				String category = rs.getString("category");
				float sumassured = rs.getFloat("sum_assured");

				Policy policies1 = new Policy(name, policyid, premium, type, duration, coverage, brand, category,
						sumassured);
				policies.add(policies1);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return policies;
	}

	@Override
	public List<Policy> findByLessPremium(double npremium) throws PolicyNotFoundException {
		Connection connection = DbConnection.openConnection();
		String sql = "select * from policy where premium<=?";
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<Policy> policies = new ArrayList<>();
		try {

			statement = connection.prepareStatement(sql);
			statement.setDouble(1, npremium);

			rs = statement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("policy_name");
				int policyid = rs.getInt("policy_id");
				float premium = rs.getFloat("premium");
				String type = rs.getString("type");
				int duration = rs.getInt("duration");
				String coverage = rs.getString("coverage");
				String brand = rs.getString("brand");
				String category = rs.getString("category");
				float sumassured = rs.getFloat("sum_assured");

				Policy policies1 = new Policy(name, policyid, premium, type, duration, coverage, brand, category,
						sumassured);
				policies.add(policies1);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return policies;
	}

	@Override
	public Policy findById(int npolicyId) throws IdNotFoundException {
		Connection connection = DbConnection.openConnection();
		String sql = "select * from policy where policy_id=?";
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		Policy policies = null;
		try {

			statement = connection.prepareStatement(sql);
			statement.setInt(1, npolicyId);

			rs = statement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("policy_name");
				int policyid = rs.getInt("policy_id");
				float premium = rs.getFloat("premium");
				String type = rs.getString("type");
				int duration = rs.getInt("duration");
				String coverage = rs.getString("coverage");
				String brand = rs.getString("brand");
				String category = rs.getString("category");
				float sumassured = rs.getFloat("sum_assured");

				policies = new Policy(name, policyid, premium, type, duration, coverage, brand, category,
						sumassured);
			

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return policies;
	}

	@Override
	public List<Policy> findByBrand(String nbrand) {
		Connection connection = DbConnection.openConnection();
		String sql = "select * from policy where brand=?";
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<Policy> policies = new ArrayList<>();
		try {

			statement = connection.prepareStatement(sql);
			statement.setString(1, nbrand);

			rs = statement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("policy_name");
				int policyid = rs.getInt("policy_id");
				float premium = rs.getFloat("premium");
				String type = rs.getString("type");
				int duration = rs.getInt("duration");
				String coverage = rs.getString("coverage");
				String brand = rs.getString("brand");
				String category = rs.getString("category");
				float sumassured = rs.getFloat("sum_assured");

				Policy policies1 = new Policy(name, policyid, premium, type, duration, coverage, brand, category,
						sumassured);
				policies.add(policies1);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return policies;
	}

}
