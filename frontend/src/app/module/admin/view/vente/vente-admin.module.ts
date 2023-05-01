import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {ToastModule} from 'primeng/toast';
import {ToolbarModule} from 'primeng/toolbar';
import {TableModule} from 'primeng/table';
import {DropdownModule} from 'primeng/dropdown';
import {InputSwitchModule} from 'primeng/inputswitch';
import {InputTextareaModule} from 'primeng/inputtextarea';

import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { DialogModule } from 'primeng/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CalendarModule} from 'primeng/calendar';
import {PanelModule} from 'primeng/panel';
import {InputNumberModule} from 'primeng/inputnumber';
import {BadgeModule} from 'primeng/badge';
import { MultiSelectModule } from 'primeng/multiselect';
import {TranslateModule} from '@ngx-translate/core';

import { InstrumentPaiementCreateAdminComponent } from './instrument-paiement-admin/create-admin/instrument-paiement-create-admin.component';
import { InstrumentPaiementEditAdminComponent } from './instrument-paiement-admin/edit-admin/instrument-paiement-edit-admin.component';
import { InstrumentPaiementViewAdminComponent } from './instrument-paiement-admin/view-admin/instrument-paiement-view-admin.component';
import { InstrumentPaiementListAdminComponent } from './instrument-paiement-admin/list-admin/instrument-paiement-list-admin.component';
import { PaiementVenteCreateAdminComponent } from './paiement-vente-admin/create-admin/paiement-vente-create-admin.component';
import { PaiementVenteEditAdminComponent } from './paiement-vente-admin/edit-admin/paiement-vente-edit-admin.component';
import { PaiementVenteViewAdminComponent } from './paiement-vente-admin/view-admin/paiement-vente-view-admin.component';
import { PaiementVenteListAdminComponent } from './paiement-vente-admin/list-admin/paiement-vente-list-admin.component';
import { AvoirVenteCreateAdminComponent } from './avoir-vente-admin/create-admin/avoir-vente-create-admin.component';
import { AvoirVenteEditAdminComponent } from './avoir-vente-admin/edit-admin/avoir-vente-edit-admin.component';
import { AvoirVenteViewAdminComponent } from './avoir-vente-admin/view-admin/avoir-vente-view-admin.component';
import { AvoirVenteListAdminComponent } from './avoir-vente-admin/list-admin/avoir-vente-list-admin.component';
import { EtatPaiementVenteCreateAdminComponent } from './etat-paiement-vente-admin/create-admin/etat-paiement-vente-create-admin.component';
import { EtatPaiementVenteEditAdminComponent } from './etat-paiement-vente-admin/edit-admin/etat-paiement-vente-edit-admin.component';
import { EtatPaiementVenteViewAdminComponent } from './etat-paiement-vente-admin/view-admin/etat-paiement-vente-view-admin.component';
import { EtatPaiementVenteListAdminComponent } from './etat-paiement-vente-admin/list-admin/etat-paiement-vente-list-admin.component';
import { VenteCreateAdminComponent } from './vente-admin/create-admin/vente-create-admin.component';
import { VenteEditAdminComponent } from './vente-admin/edit-admin/vente-edit-admin.component';
import { VenteViewAdminComponent } from './vente-admin/view-admin/vente-view-admin.component';
import { VenteListAdminComponent } from './vente-admin/list-admin/vente-list-admin.component';

import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TabViewModule} from 'primeng/tabview';
import { SplitButtonModule } from 'primeng/splitbutton';
import { MessageModule } from 'primeng/message';
import {MessagesModule} from 'primeng/messages';
import {PaginatorModule} from 'primeng/paginator';



@NgModule({
  declarations: [

    InstrumentPaiementCreateAdminComponent,
    InstrumentPaiementListAdminComponent,
    InstrumentPaiementViewAdminComponent,
    InstrumentPaiementEditAdminComponent,
    PaiementVenteCreateAdminComponent,
    PaiementVenteListAdminComponent,
    PaiementVenteViewAdminComponent,
    PaiementVenteEditAdminComponent,
    AvoirVenteCreateAdminComponent,
    AvoirVenteListAdminComponent,
    AvoirVenteViewAdminComponent,
    AvoirVenteEditAdminComponent,
    EtatPaiementVenteCreateAdminComponent,
    EtatPaiementVenteListAdminComponent,
    EtatPaiementVenteViewAdminComponent,
    EtatPaiementVenteEditAdminComponent,
    VenteCreateAdminComponent,
    VenteListAdminComponent,
    VenteViewAdminComponent,
    VenteEditAdminComponent,
  ],
  imports: [
    CommonModule,
    ToastModule,
    ToolbarModule,
    TableModule,
    ConfirmDialogModule,
    DialogModule,
    PasswordModule,
    InputTextModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    SplitButtonModule,
    BrowserAnimationsModule,
    DropdownModule,
    TabViewModule,
    InputSwitchModule,
    InputTextareaModule,
    CalendarModule,
    PanelModule,
    MessageModule,
    MessagesModule,
    InputNumberModule,
    BadgeModule,
    MultiSelectModule,
    PaginatorModule,
    TranslateModule,
  ],
  exports: [
  InstrumentPaiementCreateAdminComponent,
  InstrumentPaiementListAdminComponent,
  InstrumentPaiementViewAdminComponent,
  InstrumentPaiementEditAdminComponent,
  PaiementVenteCreateAdminComponent,
  PaiementVenteListAdminComponent,
  PaiementVenteViewAdminComponent,
  PaiementVenteEditAdminComponent,
  AvoirVenteCreateAdminComponent,
  AvoirVenteListAdminComponent,
  AvoirVenteViewAdminComponent,
  AvoirVenteEditAdminComponent,
  EtatPaiementVenteCreateAdminComponent,
  EtatPaiementVenteListAdminComponent,
  EtatPaiementVenteViewAdminComponent,
  EtatPaiementVenteEditAdminComponent,
  VenteCreateAdminComponent,
  VenteListAdminComponent,
  VenteViewAdminComponent,
  VenteEditAdminComponent,
  ],
  entryComponents: [],
})
export class VenteAdminModule { }