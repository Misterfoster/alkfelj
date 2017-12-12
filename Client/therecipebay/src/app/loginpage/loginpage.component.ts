import { Component, OnInit } from '@angular/core';
import { UserModel } from '../models/userModel';
import { HttpModule, Http, Response, Headers, RequestOptions  } from '@angular/http';

@Component({
  selector: 'app-loginpage',
  templateUrl: './loginpage.component.html',
  styleUrls: ['./loginpage.component.css']
})
export class LoginpageComponent implements OnInit {


user: UserModel = {
    username: '',
    password: ''
  };

  private contextRoot = 'http://localhost:8080/api'
  url : string;
  loggedin: boolean;
  registered: boolean;

  displayError : boolean = false;
  errorText : string ="";

  userField : UserModel;

  onLogin() : void{
	  this.userField= this.user;
	  this.tryLogin();
  }

  onRegister() : void{
    this.userField= this.user;
    this.tryRegister();
  }

  tryRegister() : void {
    this.url = "/register";
    this.http.post(this.contextRoot+this.url, this.userField).subscribe(res =>{
      this.registered=(res.text()=="true")
      if (this.registered==true) {
        this.loggedin = true;
        this.displayError=false;
        this.errorText="";
      } else {
        this.loggedin = false;
        this.displayError = true;
        this.errorText = "Failed to register. maybe you are already registered?"
      }

    });

  }



	 tryLogin() : void {
		this.url = "/login";
		this.http.post(this.contextRoot+this.url, this.userField).subscribe(res =>{
      this.loggedin=(res.text()=="true")
		  if (this.loggedin == false) {
      this.displayError = true;
      this.errorText = "Failed to login, maybe. Your username or password is invalid or something."
    } else {
      this.displayError=false;
      this.errorText="";
    }});

		}


  ngOnInit() {
  }

  constructor(private http: Http) {
	 this.loggedin = false;

  }
}
