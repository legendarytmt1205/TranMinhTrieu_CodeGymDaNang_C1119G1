package Models.persons;

public class Employees {
    private String id;
    private String name;
    private String age;
    private String idCard;
    private String phone;
    private String email;
    private String education;
    private String position;
    private String salary;

    public Employees() {

    }

    public Employees(String id, String name, String age, String idCard, String phone, String email, String education, String position, String salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.education = education;
        this.position = position;
        this.salary = salary;
    }

    public Employees(String id, String name, String age, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String showInforFull() {
        return "id: " + this.getId()
                + "\t name: " + this.getName()
                + "\t age: " + this.getAge()
                + "\t idCard: " + this.getIdCard()
                + "\t phone: " + this.getPhone()
                + "\t email: " + this.getEmail()
                + "\t education: " + this.getEducation()
                + "\t position: " + this.getPosition()
                + "\t salary: " + this.getSalary();
    }

    public String showInfor() {
        return "id: " + this.getId()
                + "\t name: " + this.getName()
                + "\t age: " + this.getAge()
                + "\t phone: " + this.getPhone();
    }

    public String getIdEmployee() {
        return "";
    }
}
