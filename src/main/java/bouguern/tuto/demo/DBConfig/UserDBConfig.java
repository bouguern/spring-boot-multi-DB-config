package bouguern.tuto.demo.DBConfig;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;


@Configuration
@EnableJpaRepositories(
		entityManagerFactoryRef = "db1EntityManagerFactory", 
		transactionManagerRef = "db1TransactionManager",
		basePackages = { "bouguern.tuto.demo.user" })
@EnableTransactionManagement
public class UserDBConfig {
	
	@Primary
	@Bean(name = "dataSource1")
	@ConfigurationProperties(prefix = "spring.db1.datasource")
	DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "db1EntityManagerFactory")
	LocalContainerEntityManagerFactoryBean db1EntityManagerFactory(final EntityManagerFactoryBuilder builder,
			@Qualifier("dataSource1") DataSource dataSource) {
		
		final HashMap<String, String> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		//properties.put("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect");

		return builder.dataSource(dataSource)
					  .properties(properties)
					  .packages("bouguern.tuto.demo.user")
					  .persistenceUnit("user")
					  .build();
	}

	@Primary
	@Bean(name = "db1TransactionManager")
	PlatformTransactionManager db1TransactionManager(@Qualifier("db1EntityManagerFactory") final EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}
