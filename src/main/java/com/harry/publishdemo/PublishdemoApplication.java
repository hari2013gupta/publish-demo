package com.harry.publishdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PublishdemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PublishdemoApplication.class, args);

		RestTemplate template = (RestTemplate) context.getBean("restTemplate");
		System.out.println(template.getForObject("http://localhost:9090/api/content/message", String.class));

		// String jdbcUrl = "jdbc:postgresql://localhost:5432/ims_db";
		// try (Connection con = DriverManager.getConnection(jdbcUrl, "postgres",
		// "postgres")) {
		// if (con != null) {
		// System.out.println("Connection successful");
		// } else {
		// System.out.println("Connection failed");
		// System.exit(0);
		// }
		// PreparedStatement ps = con.prepareStatement("select * from company");
		// ResultSet rs = ps.executeQuery();
		// while (rs.next()) {
		// String title = rs.getString(2);
		// System.out.println(rs.getString(1));
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// System.out.println(jdbcUrl);
	}
}
