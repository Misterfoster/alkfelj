import {Component, Input, OnInit} from '@angular/core';
import { RecipeModel } from '../models/recipeModel';

@Component({
  selector: '[recipetr]',
  templateUrl: './recipetemplate.component.html',
  styleUrls: ['./recipetemplate.component.css']
})
export class RecipetemplateComponent implements OnInit {




  @Input() actrec;

  constructor() { }

  ngOnInit() {
    console.log(this.actrec);
  }

}
