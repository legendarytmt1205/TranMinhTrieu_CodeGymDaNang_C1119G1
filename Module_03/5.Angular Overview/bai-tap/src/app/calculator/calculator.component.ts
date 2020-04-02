import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  first: number;
  last: number;
  uotput: number;
  operrator = '+';
  constructor() { }
  updateNumber1(number1) {
    this.first = number1;
  }
  updateNumber2(number2) {
    this.last = number2;
  }
  onSelectChange(operrator) {
    this.operrator = operrator;
  }

  calculator() {
    switch (this.operrator) {
      case '+': this.uotput = this.first + this.last;
                break;
      case '-': this.uotput = this.first - this.last;
                break;
      case '*': this.uotput = this.first * this.last;
                break;
      case '/': this.uotput = this.first / this.last;
                break;
    }
  }
  ngOnInit(): void {
  }

}
