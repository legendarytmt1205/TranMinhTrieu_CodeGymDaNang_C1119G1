package vn.tmt.springboot_web_casestudy.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.tmt.springboot_web_casestudy.entity.AppRole;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<AppRole,Long> {

    @Query(value = "select r.name from role r \n" +
            "inner join user_role ur on ur.role_id = r.role_id\n" +
            "inner join user u on ur.user_id = u.user_id\n" +
            "where u.user_id = ?1", nativeQuery = true)
    List<String> getRoleNameByUserId(@Param("id") Long userId);
}
