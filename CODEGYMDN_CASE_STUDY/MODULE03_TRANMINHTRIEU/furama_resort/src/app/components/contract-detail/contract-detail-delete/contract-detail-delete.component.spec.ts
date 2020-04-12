import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ContractDetailDeleteComponent } from './contract-detail-delete.component';

describe('ContractDetailDeleteComponent', () => {
  let component: ContractDetailDeleteComponent;
  let fixture: ComponentFixture<ContractDetailDeleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ContractDetailDeleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ContractDetailDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
