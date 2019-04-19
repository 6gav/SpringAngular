import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MasteryPageComponent } from './mastery-page.component';

describe('MasteryPageComponent', () => {
  let component: MasteryPageComponent;
  let fixture: ComponentFixture<MasteryPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MasteryPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MasteryPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
