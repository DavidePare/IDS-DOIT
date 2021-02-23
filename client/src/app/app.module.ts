import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavComponent } from './nav/nav.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { UserComponent } from './component/user-directory/user/user.component';
import { HttpClientModule } from '@angular/common/http';
import { UserprogettiComponent } from './component/user-directory/userprogetti/userprogetti.component';
import { UserprogettistiComponent } from './component/user-directory/userprogettisti/userprogettisti.component';
import { UserprogettiDetailsComponent } from './component/user-directory/userprogetti-details/userprogetti-details.component';
import { UserprogettistiDetailsComponent } from './component/user-directory/userprogettisti-details/userprogettisti-details.component';
import { ProponenteprogettoComponent } from './component/proponenteprogetto-directory/proponenteprogetto/proponenteprogetto.component';
import { ProponenteprogettoPgestitiComponent } from './component/proponenteprogetto-directory/proponenteprogetto-pgestiti/proponenteprogetto-pgestiti.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
import { InvitaprogettistaListprogettiComponent } from './component/proponenteprogetto-directory/invitaprogettista-listprogetti/invitaprogettista-listprogetti.component';
import { InvitaprogettistaListprogettistiComponent } from './component/proponenteprogetto-directory/invitaprogettista-listprogettisti/invitaprogettista-listprogettisti.component';
import { InvitaprogettistaInvitaComponent } from './component/proponenteprogetto-directory/invitaprogettista-invita/invitaprogettista-invita.component';
import { GestirecandidatureListprogettiComponent } from './component/proponenteprogetto-directory/gestirecandidature-listprogetti/gestirecandidature-listprogetti.component';
import { GestirecandidatureListcandidatiComponent } from './component/proponenteprogetto-directory/gestirecandidature-listcandidati/gestirecandidature-listcandidati.component';
import { GestirecandidatureAcceptdeclineComponent } from './component/proponenteprogetto-directory/gestirecandidature-acceptdecline/gestirecandidature-acceptdecline.component';
import { RimuovereprogettistaListprogettoComponent } from './component/proponenteprogetto-directory/rimuovereprogettista-listprogetto/rimuovereprogettista-listprogetto.component';
import { RimuovereprogettistaProgettistiteamComponent } from './component/proponenteprogetto-directory/rimuovereprogettista-progettistiteam/rimuovereprogettista-progettistiteam.component';
import { RimuovereprogettistaRemoveprogettistaComponent } from './component/proponenteprogetto-directory/rimuovereprogettista-removeprogettista/rimuovereprogettista-removeprogettista.component';
import { EspertoComponent } from './component/esperto-directory/esperto/esperto.component';
import { ProgettidavalutarelistComponent } from './component/esperto-directory/progettidavalutarelist/progettidavalutarelist.component';
import { ValutareprogettoComponent } from './component/esperto-directory/valutareprogetto/valutareprogetto.component';
import { ValutareprogettoValutaComponent } from './component/esperto-directory/valutareprogetto-valuta/valutareprogetto-valuta.component';
import { ProgettistaComponent } from './component/progettista-directory/progettista/progettista.component';
import { InvitilistComponent } from './component/progettista-directory/invitilist/invitilist.component';
import { InvitilistDecisionComponent } from './component/progettista-directory/invitilist-decision/invitilist-decision.component';
import { SendcandidaturaListprogettiComponent } from './component/progettista-directory/sendcandidatura-listprogetti/sendcandidatura-listprogetti.component';
import { SendcandidaturaInviaComponent } from './component/progettista-directory/sendcandidatura-invia/sendcandidatura-invia.component';
import { RemovecandidaturaListprogettiComponent } from './component/progettista-directory/removecandidatura-listprogetti/removecandidatura-listprogetti.component';
import { RemovecandidaturaRemoveComponent } from './component/progettista-directory/removecandidatura-remove/removecandidatura-remove.component';
import { SigninmainComponent } from './component/signin/signinmain/signinmain.component';
import { SigninprogettistaComponent } from './component/signin/signinprogettista/signinprogettista.component';
import { SigninsponsorComponent } from './component/signin/signinsponsor/signinsponsor.component';
import { LoginComponent } from './component/login/login.component';
import { SigninpropprogettoComponent } from './component/signin/signinpropprogetto/signinpropprogetto.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SponsorComponent } from './component/sponsor-directory/sponsor/sponsor.component';
import { CreaprogettoComponent } from './component/proponenteprogetto-directory/creaprogetto/creaprogetto.component';
import { CurriculumComponent } from './component/progettista-directory/curriculum/curriculum.component';
import { AddcurriculumComponent } from './component/progettista-directory/addcurriculum/addcurriculum.component';
import { CurriculumAddlanguageComponent } from './component/progettista-directory/curriculum-addlanguage/curriculum-addlanguage.component';
import { CurriculumAddweComponent } from './component/progettista-directory/curriculum-addwe/curriculum-addwe.component';
import { ProgettilistComponent } from './component/sponsor-directory/progettilist/progettilist.component';
import { InvesteprogettoComponent } from './component/sponsor-directory/investeprogetto/investeprogetto.component';
import { TotalprogettiComponent } from './component/sponsor-directory/totalprogetti/totalprogetti.component';
import { ProgettistacurriculumComponent } from './component/user-directory/progettistacurriculum/progettistacurriculum.component';
import { IonicModule } from '@ionic/angular';
import { NotificheComponent } from './component/progettista-directory/notifiche/notifiche.component';


@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    UserComponent,
    UserprogettiComponent,
    UserprogettistiComponent,
    UserprogettiDetailsComponent,
    UserprogettistiDetailsComponent,
    ProponenteprogettoComponent,
    ProponenteprogettoPgestitiComponent,
    PageNotFoundComponent,
    InvitaprogettistaListprogettiComponent,
    InvitaprogettistaListprogettistiComponent,
    InvitaprogettistaInvitaComponent,
    GestirecandidatureListprogettiComponent,
    GestirecandidatureListcandidatiComponent,
    GestirecandidatureAcceptdeclineComponent,
    RimuovereprogettistaListprogettoComponent,
    RimuovereprogettistaProgettistiteamComponent,
    RimuovereprogettistaRemoveprogettistaComponent,
    EspertoComponent,
    ProgettidavalutarelistComponent,
    ValutareprogettoComponent,
    ValutareprogettoValutaComponent,
    ProgettistaComponent,
    InvitilistComponent,
    InvitilistDecisionComponent,
    SendcandidaturaListprogettiComponent,
    SendcandidaturaInviaComponent,
    RemovecandidaturaListprogettiComponent,
    RemovecandidaturaRemoveComponent,
    SigninmainComponent,
    SigninprogettistaComponent,
    SigninsponsorComponent,
    LoginComponent,
    SigninpropprogettoComponent,
    SponsorComponent,
    CreaprogettoComponent,
    CurriculumComponent,
    AddcurriculumComponent,
    CurriculumAddlanguageComponent,
    CurriculumAddweComponent,
    ProgettilistComponent,
    InvesteprogettoComponent,
    TotalprogettiComponent,
    ProgettistacurriculumComponent,
    NotificheComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    LayoutModule,
    HttpClientModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    FormsModule,
    ReactiveFormsModule,
    IonicModule.forRoot(),
    IonicModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
