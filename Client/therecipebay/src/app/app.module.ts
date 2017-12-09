import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; 
import { HttpModule, Http, Response, Headers  } from '@angular/http';


import { AppComponent } from './app.component';
import { LoginpageComponent } from './loginpage/loginpage.component';
import { RecipesComponent } from './recipes/recipes.component';
import { RecipetemplateComponent } from './recipetemplate/recipetemplate.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginpageComponent,
    RecipesComponent,
    RecipetemplateComponent
  ],
  imports: [
    BrowserModule,
	FormsModule,
	HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
