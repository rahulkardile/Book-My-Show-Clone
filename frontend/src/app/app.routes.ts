import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { HomeComponent } from './pages/home/home.component';

export const routes: Routes = [
    {path: "home", component: HomeComponent},
    { path: '', redirectTo: '/home', pathMatch: 'full' },
    {path: "login", component: LoginComponent},
    {path: "register", component: RegisterComponent},
];