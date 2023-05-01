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

import { ComptableTraitantCreateAdminComponent } from './comptable-traitant-admin/create-admin/comptable-traitant-create-admin.component';
import { ComptableTraitantEditAdminComponent } from './comptable-traitant-admin/edit-admin/comptable-traitant-edit-admin.component';
import { ComptableTraitantViewAdminComponent } from './comptable-traitant-admin/view-admin/comptable-traitant-view-admin.component';
import { ComptableTraitantListAdminComponent } from './comptable-traitant-admin/list-admin/comptable-traitant-list-admin.component';
import { ComptableValidateurCreateAdminComponent } from './comptable-validateur-admin/create-admin/comptable-validateur-create-admin.component';
import { ComptableValidateurEditAdminComponent } from './comptable-validateur-admin/edit-admin/comptable-validateur-edit-admin.component';
import { ComptableValidateurViewAdminComponent } from './comptable-validateur-admin/view-admin/comptable-validateur-view-admin.component';
import { ComptableValidateurListAdminComponent } from './comptable-validateur-admin/list-admin/comptable-validateur-list-admin.component';
import { TauxIsCreateAdminComponent } from './taux-is-admin/create-admin/taux-is-create-admin.component';
import { TauxIsEditAdminComponent } from './taux-is-admin/edit-admin/taux-is-edit-admin.component';
import { TauxIsViewAdminComponent } from './taux-is-admin/view-admin/taux-is-view-admin.component';
import { TauxIsListAdminComponent } from './taux-is-admin/list-admin/taux-is-list-admin.component';
import { DeclarationIsCreateAdminComponent } from './declaration-is-admin/create-admin/declaration-is-create-admin.component';
import { DeclarationIsEditAdminComponent } from './declaration-is-admin/edit-admin/declaration-is-edit-admin.component';
import { DeclarationIsViewAdminComponent } from './declaration-is-admin/view-admin/declaration-is-view-admin.component';
import { DeclarationIsListAdminComponent } from './declaration-is-admin/list-admin/declaration-is-list-admin.component';

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

    ComptableTraitantCreateAdminComponent,
    ComptableTraitantListAdminComponent,
    ComptableTraitantViewAdminComponent,
    ComptableTraitantEditAdminComponent,
    ComptableValidateurCreateAdminComponent,
    ComptableValidateurListAdminComponent,
    ComptableValidateurViewAdminComponent,
    ComptableValidateurEditAdminComponent,
    TauxIsCreateAdminComponent,
    TauxIsListAdminComponent,
    TauxIsViewAdminComponent,
    TauxIsEditAdminComponent,
    DeclarationIsCreateAdminComponent,
    DeclarationIsListAdminComponent,
    DeclarationIsViewAdminComponent,
    DeclarationIsEditAdminComponent,
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
  ComptableTraitantCreateAdminComponent,
  ComptableTraitantListAdminComponent,
  ComptableTraitantViewAdminComponent,
  ComptableTraitantEditAdminComponent,
  ComptableValidateurCreateAdminComponent,
  ComptableValidateurListAdminComponent,
  ComptableValidateurViewAdminComponent,
  ComptableValidateurEditAdminComponent,
  TauxIsCreateAdminComponent,
  TauxIsListAdminComponent,
  TauxIsViewAdminComponent,
  TauxIsEditAdminComponent,
  DeclarationIsCreateAdminComponent,
  DeclarationIsListAdminComponent,
  DeclarationIsViewAdminComponent,
  DeclarationIsEditAdminComponent,
  ],
  entryComponents: [],
})
export class IsAdminModule { }