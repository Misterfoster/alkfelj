import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import { RecipeModel } from '../models/recipeModel';
import {Http} from "@angular/http";
import {fullRecipeModel} from "../models/fullRecipeModel";

@Component({
  selector: '[recipetr]',
  templateUrl: './recipetemplate.component.html',
  styleUrls: ['./recipetemplate.component.css']
})
export class RecipetemplateComponent implements OnInit {


  private contextRoot = 'http://localhost:8080/api'
  url : string;

  @Input() showPopup;
  @Input() actrec;
  @Output() notify: EventEmitter<boolean> = new EventEmitter<boolean>();
  @Output() recipeDetailEvent: EventEmitter<any> = new EventEmitter<any>();
  @Output() reloadRecipes : EventEmitter<any> = new EventEmitter<any>();


  rm : fullRecipeModel ={
    id: 0,
    name: "",
    directions: "",
    prepTime: "",
    cookTime: "",
    ownerName: "",
    cookTimeInSeconds: 0,
    prepTimeInSeconds: 0,
    fullTime: 0
  };

  constructor(private http: Http) { }

  ngOnInit() {
    console.log(this.actrec);
    this.showPopup = false;
  }

  onExpand(event) : any {
    var target = event.target || event.srcElement || event.currentTarget;
    var idAttr = target.attributes.id;
    var value = idAttr.nodeValue;
    //console.log("id: ",value);

    this.url = "/getrecipebyid";
    this.http.post(this.contextRoot+this.url, value).subscribe(res => {
      //console.log(res.json());

      this.rm=res.json();
      //this.rm.id = res.json().id;
      console.log(this.rm);
      this.recipeDetailEvent.emit(this.rm);
      this.showPopup=true;
      this.notify.emit(this.showPopup);
    });


  }

  onDelete(event) : any {
    var target = event.target || event.srcElement || event.currentTarget;
    var idAttr = target.attributes.id;
    var value = idAttr.nodeValue;

    this.url = "/deleterecipe";
    this.http.post(this.contextRoot+this.url, value).subscribe(res => {
      //console.log(res.json());

      this.reloadRecipes.emit(true);
    });
  }
}
