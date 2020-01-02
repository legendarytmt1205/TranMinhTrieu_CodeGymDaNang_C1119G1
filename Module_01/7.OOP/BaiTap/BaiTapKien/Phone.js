var Phone = function () {
    this.setPrice = function (price) {
        this.price = price;
    };
    this.getPrice = function () {
      return this.price;
    };
    this.setName = function (name) {
        this.name = name;
    };
    this.getName = function () {
        return this.name;
    };
    this.setDiscount = function (discount) {
        this.discount = discount;
    };
    this.getDiscount = function () {
        return this.discount;
    };
    this.getTotalPrice = function () {
        return this.discount * this.price;
    }
};