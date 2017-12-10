import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecipedetailtemplateComponent } from './recipedetailtemplate.component';

describe('RecipedetailtemplateComponent', () => {
  let component: RecipedetailtemplateComponent;
  let fixture: ComponentFixture<RecipedetailtemplateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecipedetailtemplateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecipedetailtemplateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
