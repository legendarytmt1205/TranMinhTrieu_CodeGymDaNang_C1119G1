package vn.tmt.springboot_web_casestudy.repository;

import org.springframework.data.repository.CrudRepository;
import vn.tmt.springboot_web_casestudy.entity.AppUser;

public interface UserRepository extends CrudRepository<AppUser,Long> {
    AppUser findByUserName(String userName);
}
