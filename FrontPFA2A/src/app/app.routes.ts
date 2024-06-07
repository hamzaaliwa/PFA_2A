import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { AuthenticationComponent } from './components/authentication/authentication.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { StudentsComponent } from './components/students/students.component';
import { ProfessorsComponent } from './components/professors/professors.component';
import { InternshipsComponent } from './components/internships/internships.component';
import { CompaniesComponent } from './components/companies/companies.component';
import { TutorsComponent } from './components/tutors/tutors.component';
import { InternshipsDatesComponent } from './components/internships-dates/internships-dates.component';
import { SkillsComponent } from './components/skills/skills.component';
import { PromosComponent } from './components/promos/promos.component';
import {RegisterComponent} from "./components/register/register.component";



export const routes: Routes = [
  { path: 'authenticate', component: AuthenticationComponent} ,
  { path: 'dashboard', component: DashboardComponent },
  { path: '', component: HomeComponent },
  { path: 'fournisseurs', component: StudentsComponent },
  { path: 'produits', component: ProfessorsComponent },
  { path: 'stocks', component: PromosComponent },
  { path: 'entropots', component: InternshipsComponent },
  { path: 'lignedecommande', component: InternshipsDatesComponent },
  { path: 'clients', component: SkillsComponent },
  { path: 'ProdParEntropot/:id', component: CompaniesComponent },
  { path: 'commandes/:id', component: TutorsComponent },
  { path: 'register', component: RegisterComponent},
];

