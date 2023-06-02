package board.main;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Slf4j
@SpringBootTest
class MainApplicationTests {

	@Autowired
	DataSource dataSource;

	@Test
	void DBConnection() {
		Connection con = null;
		try {
			con = dataSource.getConnection();
			log.info("connection = {}", con);
			PreparedStatement pstmt = con.prepareStatement("select * from User");
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				log.info("{} {}", rs.getInt("user_id"), rs.getInt("password"));
			}
		} catch (Exception e) {
			log.info("error = {}", e);
		} finally {
			JdbcUtils.closeConnection(con);
		}
	}

}
