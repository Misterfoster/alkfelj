import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecipetemplateComponent } from './recipetemplate.component';

describe('RecipetemplateComponent', () => {
  let component: RecipetemplateComponent;
  let fixture: ComponentFixture<RecipetemplateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecipetemplateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecipetemplateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
