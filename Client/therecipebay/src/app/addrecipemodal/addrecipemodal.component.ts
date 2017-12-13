import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {fullRecipeModel} from "../models/fullRecipeModel";

@Component({
  selector: 'app-addrecipemodal',
  templateUrl: './addrecipemodal.component.html',
  styleUrls: ['./addrecipemodal.component.css']
})
export class AddrecipemodalComponent implements OnInit {
  @Output() hiderec: EventEmitter<boolean> = new EventEmitter<boolean>();

  recipeModel : fullRecipeModel = {
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

  constructor() { }

  ngOnInit() {
  }
  onClose():void{
    this.hiderec.emit(false);
  }

  onSubmitRecipe() {
    console.log("submitting recipe: ",this.recipeModel);
  }
}
