import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';


const routes: Routes = [
  
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'Welcome'
  },
  {
    path: 'Welcome',
    component: WelcomeComponent
  },
  {
    path: 'Login',
    component: LoginComponent
  },
  {
    path: 'Signup',
    component: SignupComponent
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
