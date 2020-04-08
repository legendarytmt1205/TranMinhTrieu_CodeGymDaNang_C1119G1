import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DictionaryDetailComponent } from './dictionary-detail/dictionary-detail.component';



const routes: Routes = [
  { path: "dictionary-detail", component: DictionaryDetailComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
