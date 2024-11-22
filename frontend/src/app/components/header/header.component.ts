import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})

export class HeaderComponent {

  constructor(private routes: Router) {
    console.log(this.token);
  }

  logoPath = 'assets/images/logo.png';

  token: string | null = localStorage.getItem("token");

  logout(): void {
    localStorage.removeItem("token");
    this.token = null;
    location.reload();
    setTimeout(() => {
      this.routes.navigate(["/"]);
    }, 100)

  }

}
