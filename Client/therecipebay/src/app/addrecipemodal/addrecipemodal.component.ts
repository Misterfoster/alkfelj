import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {fullRecipeModel} from "../models/fullRecipeModel";
import {ingredientModel} from "../models/ingredientModel";
import {Http} from "@angular/http";

@Component({
  selector: 'app-addrecipemodal',
  templateUrl: './addrecipemodal.component.html',
  styleUrls: ['./addrecipemodal.component.css']
})
export class AddrecipemodalComponent implements OnInit {
  @Output() hiderec: EventEmitter<boolean> = new EventEmitter<boolean>();
  contextRoot = 'http://localhost:8080/api'
  url: string;

  recipeModel: fullRecipeModel = {
    id: -1,
    name: "",
    directions: "",
    prepTime: "",
    cookTime: "",
    ownerName: "",
    cookTimeInSeconds: -1,
    prepTimeInSeconds: -1,
    fullTime: -1
  };

  availableIngredients: ingredientModel[] = [];

  usedIngredients: ingredientModel[] = [];
  selectedIngredient: string;
  selectedUnit: string;
  selectedAmount: number;
  newIngredientName: string;

  constructor(private http: Http) {
  }

  ngOnInit() {
    this.recipeModel.ownerName=document.getElementById("username").innerHTML;
    let self = this;
    this.url = "/getingredients";
    this.http.get(this.contextRoot + this.url).subscribe(res => {

      res.json().forEach(function (lines) {
        let actIng = {"name": "", "amount": 0.0, "unit": ""};
        actIng["name"] = lines;

        self.availableIngredients.push(actIng);
      })
    });

    console.log("available_ingredients:", this.availableIngredients);
  }

  onClose(): void {
    this.hiderec.emit(false);

  }

  onSubmitRecipe() {
    let self = this;
    console.log("submitting recipe: ", this.recipeModel
                ,"with ingredients: ",this.usedIngredients);

    this.url = "/addnewRecipe";
    this.http.post(this.contextRoot+this.url, self.recipeModel).subscribe(res =>{
      this.url = "/addIngredientsforRecipes";
      console.log("recipe created with id: ",res.text());

      this.http.post(this.contextRoot+this.url, {"id":res.text(),"ingredients":self.usedIngredients}).subscribe(res2 =>{

        console.log("response from addIngredientsforRecipes",res2.text());
        this.hiderec.emit(false);
      });
    });

  }

  onAddExistingIngredient() {
    let currentIngredient = {
      "name":this.selectedIngredient,
      "unit":this.selectedUnit,
      "amount":this.selectedAmount
    }
    console.log("akivalasztott",this.selectedIngredient);
    this.usedIngredients.push(currentIngredient);
  }

  onAddNewIngredient() {
    let isthereany = false;
    let self=this;
    this.availableIngredients.forEach(function(avi){
      if(self.newIngredientName==avi.name){
        isthereany=true;
      }
    });

    if(!isthereany){
      this.url = "/addnewingredient";
      this.http.post(this.contextRoot+this.url, self.newIngredientName).subscribe(res =>{
        if(res.text()=="true"){
          self.availableIngredients.push({"name":self.newIngredientName,"unit":"",amount:0.0});
        }
      });
    }

  }
}
