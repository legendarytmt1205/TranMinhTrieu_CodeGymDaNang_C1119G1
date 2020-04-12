import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ContractDetailAddComponent } from './contract-detail-add.component';

describe('ContractDetailAddComponent', () => {
  let component: ContractDetailAddComponent;
  let fixture: ComponentFixture<ContractDetailAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ContractDetailAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ContractDetailAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
