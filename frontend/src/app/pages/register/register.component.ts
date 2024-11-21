import { Component } from '@angular/core';
import { FormsModule, NgModel } from '@angular/forms';
import { AuthServiceService } from '../../core/auth-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  user = {
    name: '',
    email: '',
    username: '',
    phone: '',
    location: '',
    password: ''
  };

  errorMessage: String = "";

  constructor(private authService: AuthServiceService, private router: Router){}

  onSubmit(){
    this.authService.register(this.user).subscribe({
      next: (req: any)=>{
        console.log(req);
        this.router.navigate(["/login"]);
      },
      error: (err: any)=>{
        this.errorMessage = err.message || 'Invalid credentials, please try again.';
        console.log(err);
      }
    })
  }

}
