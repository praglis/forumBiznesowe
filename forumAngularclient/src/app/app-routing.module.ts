import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {AdministratorPanelComponent} from './administrator-panel/administrator-panel.component';
import {AdminguardService} from './_guards/adminguard.service';
import {PostComponent} from './post/post.component';
import {CategoryAddComponent} from './category-add/category-add.component';

const routes: Routes = [
  {path: 'categories', component: HomeComponent},
  {path: 'categories/new', component: CategoryAddComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'admin_panel', component: AdministratorPanelComponent, canActivate: [AdminguardService]},
  {path: 'post/:id', component: PostComponent},
  {path: '', redirectTo: 'categories', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
