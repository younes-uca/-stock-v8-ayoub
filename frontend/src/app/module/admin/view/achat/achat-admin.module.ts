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

import { AchatCreateAdminComponent } from './achat-admin/create-admin/achat-create-admin.component';
import { AchatEditAdminComponent } from './achat-admin/edit-admin/achat-edit-admin.component';
import { AchatViewAdminComponent } from './achat-admin/view-admin/achat-view-admin.component';
import { AchatListAdminComponent } from './achat-admin/list-admin/achat-list-admin.component';
import { PaiementAchatCreateAdminComponent } from './paiement-achat-admin/create-admin/paiement-achat-create-admin.component';
import { PaiementAchatEditAdminComponent } from './paiement-achat-admin/edit-admin/paiement-achat-edit-admin.component';
import { PaiementAchatViewAdminComponent } from './paiement-achat-admin/view-admin/paiement-achat-view-admin.component';
import { PaiementAchatListAdminComponent } from './paiement-achat-admin/list-admin/paiement-achat-list-admin.component';
import { AvoirAchatCreateAdminComponent } from './avoir-achat-admin/create-admin/avoir-achat-create-admin.component';
import { AvoirAchatEditAdminComponent } from './avoir-achat-admin/edit-admin/avoir-achat-edit-admin.component';
import { AvoirAchatViewAdminComponent } from './avoir-achat-admin/view-admin/avoir-achat-view-admin.component';
import { AvoirAchatListAdminComponent } from './avoir-achat-admin/list-admin/avoir-achat-list-admin.component';
import { EtatPaiementAchatCreateAdminComponent } from './etat-paiement-achat-admin/create-admin/etat-paiement-achat-create-admin.component';
import { EtatPaiementAchatEditAdminComponent } from './etat-paiement-achat-admin/edit-admin/etat-paiement-achat-edit-admin.component';
import { EtatPaiementAchatViewAdminComponent } from './etat-paiement-achat-admin/view-admin/etat-paiement-achat-view-admin.component';
import { EtatPaiementAchatListAdminComponent } from './etat-paiement-achat-admin/list-admin/etat-paiement-achat-list-admin.component';

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

    AchatCreateAdminComponent,
    AchatListAdminComponent,
    AchatViewAdminComponent,
    AchatEditAdminComponent,
    PaiementAchatCreateAdminComponent,
    PaiementAchatListAdminComponent,
    PaiementAchatViewAdminComponent,
    PaiementAchatEditAdminComponent,
    AvoirAchatCreateAdminComponent,
    AvoirAchatListAdminComponent,
    AvoirAchatViewAdminComponent,
    AvoirAchatEditAdminComponent,
    EtatPaiementAchatCreateAdminComponent,
    EtatPaiementAchatListAdminComponent,
    EtatPaiementAchatViewAdminComponent,
    EtatPaiementAchatEditAdminComponent,
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
  AchatCreateAdminComponent,
  AchatListAdminComponent,
  AchatViewAdminComponent,
  AchatEditAdminComponent,
  PaiementAchatCreateAdminComponent,
  PaiementAchatListAdminComponent,
  PaiementAchatViewAdminComponent,
  PaiementAchatEditAdminComponent,
  AvoirAchatCreateAdminComponent,
  AvoirAchatListAdminComponent,
  AvoirAchatViewAdminComponent,
  AvoirAchatEditAdminComponent,
  EtatPaiementAchatCreateAdminComponent,
  EtatPaiementAchatListAdminComponent,
  EtatPaiementAchatViewAdminComponent,
  EtatPaiementAchatEditAdminComponent,
  ],
  entryComponents: [],
})
export class AchatAdminModule { }