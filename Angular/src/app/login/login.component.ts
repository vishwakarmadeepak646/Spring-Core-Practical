import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent {
 
  constructor(private router:Router){

  }
 
  form: any = {

    data: {},
    errorMsg: '',
    successMsg: ''
  
  }
   signIn() {
    
    if(this.form.loginId == 'admin' && this.form.password == 'admin') {

      this.router.navigateByUrl('/welcome');
    }else{
      this.form.errormsg='Invalid Login id or password';
    }

}
}
