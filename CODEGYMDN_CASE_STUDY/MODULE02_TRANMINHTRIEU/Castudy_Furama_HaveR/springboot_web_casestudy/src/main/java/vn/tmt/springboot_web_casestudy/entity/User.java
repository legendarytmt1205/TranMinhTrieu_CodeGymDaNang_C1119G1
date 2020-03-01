package vn.tmt.springboot_web_casestudy.entity;

    import javax.persistence.*;
    import java.io.Serializable;
    import java.util.Set;
//
//    @Entity
//    @Table(name = "users")
    public class User implements Serializable {

        private static final long serialVersionUID = 1L;

//        @Id
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
//        @Column(name = "user_id", nullable = false)
//        private Long id;
//
//        @Column(name = "user_email", nullable = false, unique = true)
//        private String email;
//
//        @Column(name = "user_password", nullable = false)
//        private String password;
//
//        @ManyToMany
//        @JoinTable(name = "user_role",
//                    joinColumns = @JoinColumn(name = "user_id"),
//                    inverseJoinColumns = @JoinColumn(name = "role_id"))
//        private Set<Role> roles;
//
//        public Long getId() {
//            return id;
//        }
//
//        public void setId(Long id) {
//            this.id = id;
//        }
//
//        public String getEmail() {
//            return email;
//        }
//
//        public void setEmail(String email) {
//            this.email = email;
//        }
//
//        public String getPassword() {
//            return password;
//        }
//
//        public void setPassword(String password) {
//            this.password = password;
//        }
//
//        public Set<Role> getRoles() {
//            return roles;
//        }
//
//        public void setRoles(Set<Role> roles) {
//            this.roles = roles;
//        }
    }