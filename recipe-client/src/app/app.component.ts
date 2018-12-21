import '@ng-bootstrap/ng-bootstrap';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './auth.service';
import { RoutingModule } from './routing/routing.module';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'recipe-client';

  constructor(
    private router: Router,
    public authService: AuthService,
  ) { }

  
  changeTitle() {
    this.title += this.title;
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/']);
  }

}