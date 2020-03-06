package vn.tmt.springboot_web_casestudy.entity;

    import javax.persistence.*;
    import java.io.Serializable;
    import java.util.Set;

    @Entity
    @Table(name = "user")
    public class AppUser implements Serializable {

        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "user_id", nullable = false)
        private Long id;

        @Column(name = "email", nullable = false, unique = true)
        private String userName;

        @Column(name = "password", nullable = false)
        private String encrytedPassword;

        @ManyToMany
        @JoinTable(name = "user_role",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
        private Set<AppRole> appRoles;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getEncrytedPassword() {
            return encrytedPassword;
        }

        public void setEncrytedPassword(String encrytedPassword) {
            this.encrytedPassword = encrytedPassword;
        }

        public Set<AppRole> getAppRoles() {
            return appRoles;
        }

        public void setAppRoles(Set<AppRole> appRoles) {
            this.appRoles = appRoles;
        }
    }