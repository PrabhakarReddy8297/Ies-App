package com.prabha.ies.ar.generators;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ARGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String prefix="AR";
		String suffix="";
		try {
			Connection connection = session.connection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select arNo_seq.nextval from dual");
			if(resultSet.next()) {
				int sequal = resultSet.getInt(1);
				 suffix = String.valueOf(sequal);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return prefix+suffix;
	}

}
