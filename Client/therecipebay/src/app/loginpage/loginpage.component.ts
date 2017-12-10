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


  userField : UserModel;

  onLogin() : void{
	  this.userField= this.user;
	  //this.loggedin = true;
	  this.tryLogin();
	  if (this.loggedin == false){
		  console.log("failed to login");
	  }
  }



	 tryLogin() : any {
		this.url = "/login";
		this.http.post(this.contextRoot+this.url, this.userField).subscribe(res => this.loggedin=(res.text()=="true") );

		}


  ngOnInit() {
  }

  constructor(private http: Http) {
	 this.loggedin = false;

  }
}
