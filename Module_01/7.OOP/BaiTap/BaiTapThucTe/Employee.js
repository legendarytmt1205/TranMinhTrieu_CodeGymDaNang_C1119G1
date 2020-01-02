let Employee = function () {
    this.setSalary = function (salary) {
        this.salary = salary;
    };
    this.getSalary = function () {
        return this.salary;
    };
    this.setWorkDay = function (workDay) {
        this.workDay = workDay;
    };
    this.getWorkDay = function () {
        return this.workDay
    };
};