import { Component, OnInit } from '@angular/core';
import { RecipeModel } from '../models/recipeModel';
import { HttpModule, Http, Response, Headers, RequestOptions  } from '@angular/http';

@Component({
  selector: 'app-recipes',
  templateUrl: './recipes.component.html',
  styleUrls: ['./recipes.component.css']
})
export class RecipesComponent implements OnInit {

  recipeList : RecipeModel[] = [];
  contextRoot = 'http://localhost:8080/api'
  url : string;
  actR : RecipeModel;


  constructor(private http: Http) {  }

  ngOnInit() {

    let self = this;
    let actrecip = {"id": 0, "full_time":"","recipe_by":"","recipe_name":""};

    this.url = "/recipes";
    this.http.get(this.contextRoot+this.url).subscribe(res => {

      res.json().forEach(function (lines){
        console.log(lines);
        actrecip = {"id": 0, "full_time":"","recipe_by":"","recipe_name":""};
        actrecip["id"] = lines.id;
        actrecip["full_time"] = lines.fullTime;
        actrecip["recipe_by"] = lines.ownerName;
        actrecip["recipe_name"] = lines.name;

        self.actR = actrecip;
        self.recipeList.push(actrecip);
      })
    } );

    console.log("receptlistafromdb",this.recipeList);
  }
}
