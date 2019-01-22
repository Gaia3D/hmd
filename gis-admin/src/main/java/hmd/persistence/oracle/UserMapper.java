package hmd.persistence.oracle;

import org.springframework.stereotype.Repository;

import hmd.domain.User;

@Repository
public interface UserMapper {

	Long getUserTotalCount(User user);

	int insertUser(User user);
}
