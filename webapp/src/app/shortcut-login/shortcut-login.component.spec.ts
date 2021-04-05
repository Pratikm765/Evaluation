import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShortcutLoginComponent } from './shortcut-login.component';

describe('ShortcutLoginComponent', () => {
  let component: ShortcutLoginComponent;
  let fixture: ComponentFixture<ShortcutLoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShortcutLoginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShortcutLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
