import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule, ɵValue} from '@angular/forms';
import { InternshipsDatesService } from '../../services/internships-dates.service';
import { TokenStorageService } from '../../services/token-storage.service';
import {ActivatedRoute, Router, RouterLink} from '@angular/router';
import { NavbarComponent } from '../shared/navbar/navbar.component';
import {ProfessorsService} from "../../services/professors.service";
import {AuthenticationService} from "../../services/authentication.service";
import {CompaniesService} from "../../services/companies.service";

@Component({
  selector: 'app-internships-dates',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule, NavbarComponent, RouterLink],
  templateUrl: './internships-dates.component.html',
  styleUrl: './internships-dates.component.css',
})
export class InternshipsDatesComponent implements OnInit {
  internshipForm = new FormGroup({
    id: new FormControl(''),
    commande: new FormGroup({
      id: new FormControl(''),
    }),
    produit: new FormGroup({
      id: new FormControl(''),
    }),
    quantite: new FormControl(''),
     });

  displayedColumns: string[] = [
    'Produit',
    'Quantité',
    'Action',
  ];

  companiesList: any[] = [];
  editMode = false;
  currentSiretNumber: number = 0;
  isLogged: boolean = false;

  constructor(
    private promoservice
      : InternshipsDatesService,
    private tokenStorageService: TokenStorageService,
    public router: Router,
    private route: ActivatedRoute,
    private authService: AuthenticationService,
    public companiservice: CompaniesService,
  ) {}

  ngOnInit(): void {
    this.checkAuthentication();
    this.isLogged = !!this.tokenStorageService.getToken();
    this.getCompanies();
  }

  getCompanies() {
    return this.promoservice
      .getInternships().subscribe({
        next: (data: any) => {
          this.companiesList = data;
        },
        error: (e: any) => {
          if (e.status === 403) {
            this.tokenStorageService.logout();
          }
        },
      });
  }

  handleSearch(event: any) {
    const keyWord = event.target.value.toString(); // Convert keyWord to a string

    if (keyWord) {
      this.companiesList = this.companiesList.filter((entreprise: any) => {
        return  entreprise.id.toString().includes(keyWord);
      });
    } else {
      this.getCompanies();
    }
  }



  getCompanyBySiretNumber(siretNumber: number) {
    return this.promoservice

      .getInternshipByInternshipId(siretNumber)
      .subscribe({
        next: (data: any) => console.log(data),
        error: (e: any) => {
          if (e.status === 403) {
            this.tokenStorageService.logout();
          }
        },
      });
  }



  handleCompanyForm() {
    if (this.editMode) {
      this.updateCompany();
    } else {
      this.addCompany();
    }
  }

  handleUpdateCompany(entreprise: any) {
    this.editMode = true;
    this.currentSiretNumber = entreprise.siretNumber;
    this.internshipForm.patchValue(entreprise);
  }

  addCompany() {
    if (this.internshipForm.valid) {
      this.promoservice
        .addInternship(this.internshipForm.value).subscribe({
        next: (data: any) => {
          this.getCompanies();
          this.misajourentrepots(data.produit.id,data.quantite);
          this.internshipForm.reset();
        },
        error: (e: any) => {
          if (e.status === 403) {
            this.tokenStorageService.logout();
          }
        },
      });
    } else {
      console.log('invalid form');
    }
  }

  updateCompany() {
    this.promoservice

      .updateInternship(this.internshipForm.value)
      .subscribe({
        next: (data: any) => {
          this.getCompanies();
          this.editMode = false;
          this.internshipForm.reset();
        },
        error: (e: any) => {
          if (e.status === 403) {
            this.tokenStorageService.logout();
          }
        },
      });
  }

  deleteCompany(siretNumber: number) {
    this.promoservice
      .deleteInternship(siretNumber).subscribe({
      next: () => {
        this.getCompanies();
      },
      error: (e: any) => {
        if (e.status === 403) {
          this.tokenStorageService.logout();
        }
      },
    });
  }
  checkAuthentication(): void {
    if (!this.authService.isAuthenticated()) {
      this.router.navigate(['/authenticate']);
    }
  }

  navigate(route: string): void {
    this.router.navigate([route], { relativeTo: this.route });
  }

  logout(): void {
    this.tokenStorageService.logout();
  }

  private misajourentrepots(id : number, qquantiteCommandee : number) {
      this.companiservice.getparproduit(id).subscribe({
        next: (data: any) => {
          let remainingQuantite = qquantiteCommandee;
          let updatedEntrepots: any[] = [];

          while (remainingQuantite > 0) {
            let allBelowMin = true;

            // Iterate through each produitEntopot entry
            for (let produitEntopot of data) {
              console.log(produitEntopot);
              if (remainingQuantite <= 0) break;

              // Only reduce quantity if above seuil_min
              if (produitEntopot.quantite > produitEntopot.seuil_min) {
                produitEntopot.quantite -= 1;
                remainingQuantite -= 1;
                allBelowMin = false;

                // Add to the list of updated entrepots to be updated in the backend later
                if (!updatedEntrepots.includes(produitEntopot)) {
                  updatedEntrepots.push(produitEntopot);
                }
              }
            }

            // If we can't reduce any further, break the loop
            if (allBelowMin) {
              console.log('dik dyal treu');
              console.warn('Not enough stock to fulfill the order.');
              break;
            }
          }

          if (remainingQuantite > 0) {
            console.log('here kbr 0');
            console.warn('Not enough stock to fulfill the order.');
          }

          // Update each updated produitEntopot in the backend
          for (let produitEntopot of updatedEntrepots) {
            this.updateProduitEntopot(produitEntopot);
          }
        },
        error: (e: any) => {
          if (e.status === 403) {
            this.tokenStorageService.logout();
          } else {
            console.error('Error fetching data:', e);
          }
        }
      });
  }
  private updateProduitEntopot(produitEntopot: any) {
    // Implement the logic to update the produitEntopot in the backend.
    // This can be another service method that makes an HTTP PUT or PATCH request.
    this.companiservice.updateCompany(produitEntopot).subscribe({
      next: (response) => {
        console.log('Updated produitEntopot:', response);
      },
      error: (error) => {
        console.error('Error updating produitEntopot:', error);
      }
    });
  }
}
