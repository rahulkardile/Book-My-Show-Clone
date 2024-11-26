import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { LoginResponse } from '../../interface/types';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [FormsModule, RouterModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})

export class HeaderComponent {
  userInfo = localStorage.getItem("userInfo")

  constructor(private routes: Router) {
    console.log(this.token);

    if (this.userInfo) {
      console.log(JSON.parse(this.userInfo));
    }

  }

  logoPath = 'assets/images/logo.png';

  token: string | null = localStorage.getItem("token");


  logout(): void {
    localStorage.removeItem("token");
    localStorage.removeItem("userInfo");
    this.token = null;
    location.reload();
    setTimeout(() => {
      this.routes.navigate(["/"]);
    }, 100)

  }

}
