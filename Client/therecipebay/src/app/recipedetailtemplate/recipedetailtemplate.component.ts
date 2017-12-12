import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {RecipeModel} from "../models/recipeModel";
import {Http} from "@angular/http";
import {ingredientModel} from "../models/ingredientModel";


@Component({
  selector: 'app-recipedetailtemplate',
  templateUrl: './recipedetailtemplate.component.html',
  styleUrls: ['./recipedetailtemplate.component.css']
})
export class RecipedetailtemplateComponent implements OnInit {

  @Output() notify: EventEmitter<boolean> = new EventEmitter<boolean>();

  @Input() actualRecipe;
  private contextRoot = 'http://localhost:8080/api'
  url : string;
  constructor(private http: Http) { }
  ingredients : ingredientModel[] = [];

  ngOnInit() {
    console.log("got actual recipe:",this.actualRecipe);
    let self = this;
    this.url = "/getingredientsbyrecid";
    this.http.post(this.contextRoot+this.url, this.actualRecipe.id).subscribe(res => {
      console.log("response",res);
      let actIng = {"name": "", "amount":0.0,"unit":""};

      res.json().forEach(function (lines){
        console.log(lines);
        actIng = {"name": "", "amount":0.0,"unit":""};
        actIng["name"] = lines.name;
        actIng["amount"] = lines.amount;
        actIng["unit"] = lines.unit;

        self.ingredients.push(actIng);
      })

    } );


    console.log("ingsforrecip",this.ingredients);
  }

  onClose():void{
    this.notify.emit(false);
  }

}
