import { Component } from '@angular/core';
import { AuthServiceService } from '../../core/auth-service.service';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { UserLogin } from '../../interface/types';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  user: UserLogin = {
    username: '',
    password: ''
  };

  errorMessage = '';

  constructor(private authService: AuthServiceService, private route: Router) { }

  onSubmit() {
    this.authService.login(this.user).subscribe({
      next: (response: any) => {
        localStorage.setItem("token", response.token),
          this.route.navigate(["/hello"])
      },
      error: (error: any) => {
        this.errorMessage = error.message || "Internal server error";
      }
    })
  }

}
