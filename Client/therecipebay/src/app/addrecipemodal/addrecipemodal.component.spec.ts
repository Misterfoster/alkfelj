import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddrecipemodalComponent } from './addrecipemodal.component';

describe('AddrecipemodalComponent', () => {
  let component: AddrecipemodalComponent;
  let fixture: ComponentFixture<AddrecipemodalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddrecipemodalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddrecipemodalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
