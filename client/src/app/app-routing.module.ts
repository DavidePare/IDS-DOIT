import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EspertoComponent } from './component/esperto-directory/esperto/esperto.component';
import { ProgettidavalutarelistComponent } from './component/esperto-directory/progettidavalutarelist/progettidavalutarelist.component';
import { ValutareprogettoValutaComponent } from './component/esperto-directory/valutareprogetto-valuta/valutareprogetto-valuta.component';
import { ValutareprogettoComponent } from './component/esperto-directory/valutareprogetto/valutareprogetto.component';
import { LoginComponent } from './component/login/login.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
import { AddcurriculumComponent } from './component/progettista-directory/addcurriculum/addcurriculum.component';
import { CurriculumAddlanguageComponent } from './component/progettista-directory/curriculum-addlanguage/curriculum-addlanguage.component';
import { CurriculumAddweComponent } from './component/progettista-directory/curriculum-addwe/curriculum-addwe.component';
import { CurriculumComponent } from './component/progettista-directory/curriculum/curriculum.component';
import { InvitilistDecisionComponent } from './component/progettista-directory/invitilist-decision/invitilist-decision.component';
import { InvitilistComponent } from './component/progettista-directory/invitilist/invitilist.component';
import { NotificheComponent } from './component/progettista-directory/notifiche/notifiche.component';
import { ProgettistaComponent } from './component/progettista-directory/progettista/progettista.component';
import { RemovecandidaturaListprogettiComponent } from './component/progettista-directory/removecandidatura-listprogetti/removecandidatura-listprogetti.component';
import { RemovecandidaturaRemoveComponent } from './component/progettista-directory/removecandidatura-remove/removecandidatura-remove.component';
import { SendcandidaturaInviaComponent } from './component/progettista-directory/sendcandidatura-invia/sendcandidatura-invia.component';
import { SendcandidaturaListprogettiComponent } from './component/progettista-directory/sendcandidatura-listprogetti/sendcandidatura-listprogetti.component';
import { CreaprogettoComponent } from './component/proponenteprogetto-directory/creaprogetto/creaprogetto.component';
import { GestirecandidatureAcceptdeclineComponent } from './component/proponenteprogetto-directory/gestirecandidature-acceptdecline/gestirecandidature-acceptdecline.component';
import { GestirecandidatureListcandidatiComponent } from './component/proponenteprogetto-directory/gestirecandidature-listcandidati/gestirecandidature-listcandidati.component';
import { GestirecandidatureListprogettiComponent } from './component/proponenteprogetto-directory/gestirecandidature-listprogetti/gestirecandidature-listprogetti.component';
import { InvitaprogettistaInvitaComponent } from './component/proponenteprogetto-directory/invitaprogettista-invita/invitaprogettista-invita.component';
import { InvitaprogettistaListprogettiComponent } from './component/proponenteprogetto-directory/invitaprogettista-listprogetti/invitaprogettista-listprogetti.component';
import { InvitaprogettistaListprogettistiComponent } from './component/proponenteprogetto-directory/invitaprogettista-listprogettisti/invitaprogettista-listprogettisti.component';
import { ProponenteprogettoPgestitiComponent } from './component/proponenteprogetto-directory/proponenteprogetto-pgestiti/proponenteprogetto-pgestiti.component';
import { ProponenteprogettoComponent } from './component/proponenteprogetto-directory/proponenteprogetto/proponenteprogetto.component';
import { RimuovereprogettistaListprogettoComponent } from './component/proponenteprogetto-directory/rimuovereprogettista-listprogetto/rimuovereprogettista-listprogetto.component';
import { RimuovereprogettistaProgettistiteamComponent } from './component/proponenteprogetto-directory/rimuovereprogettista-progettistiteam/rimuovereprogettista-progettistiteam.component';
import { RimuovereprogettistaRemoveprogettistaComponent } from './component/proponenteprogetto-directory/rimuovereprogettista-removeprogettista/rimuovereprogettista-removeprogettista.component';
import { SigninmainComponent } from './component/signin/signinmain/signinmain.component';
import { SigninprogettistaComponent } from './component/signin/signinprogettista/signinprogettista.component';
import { SigninpropprogettoComponent } from './component/signin/signinpropprogetto/signinpropprogetto.component';
import { SigninsponsorComponent } from './component/signin/signinsponsor/signinsponsor.component';
import { InvesteprogettoComponent } from './component/sponsor-directory/investeprogetto/investeprogetto.component';
import { ProgettilistComponent } from './component/sponsor-directory/progettilist/progettilist.component';
import { SponsorComponent } from './component/sponsor-directory/sponsor/sponsor.component';
import { TotalprogettiComponent } from './component/sponsor-directory/totalprogetti/totalprogetti.component';
import { ProgettistacurriculumComponent } from './component/user-directory/progettistacurriculum/progettistacurriculum.component';
import { UserComponent } from './component/user-directory/user/user.component';
import { UserprogettiDetailsComponent } from './component/user-directory/userprogetti-details/userprogetti-details.component';
import { UserprogettiComponent } from './component/user-directory/userprogetti/userprogetti.component';
import { UserprogettistiDetailsComponent } from './component/user-directory/userprogettisti-details/userprogettisti-details.component';
import { UserprogettistiComponent } from './component/user-directory/userprogettisti/userprogettisti.component';

const routes: Routes = [
  { path: '', redirectTo: '/user', pathMatch: 'full'},
  { path: 'user', component: UserComponent},
  { path: 'user/getProgetti', component: UserprogettiComponent},
  { path: 'user/getProgettisti', component: UserprogettistiComponent},
  { path: 'user/getProgetti/:id', component: UserprogettiDetailsComponent},
  { path: 'user/getProgettisti/:id', component: UserprogettistiDetailsComponent},
  { path: 'user/getProgettisti/:id/curriculum', component: ProgettistacurriculumComponent},
  { path: 'proponenteprogetto', component: ProponenteprogettoComponent},
  { path: 'proponenteprogetto/createprogetto', component: CreaprogettoComponent},
  { path: 'proponenteprogetto/pgestiti', component: ProponenteprogettoPgestitiComponent},
  { path: 'proponenteprogetto/progettigestiti', component: InvitaprogettistaListprogettiComponent},
  { path: 'proponenteprogetto/progettigestiti/:id/invite', component: InvitaprogettistaListprogettistiComponent},
  { path: 'proponenteprogetto/progettigestiti/:id/invite/:idp', component: InvitaprogettistaInvitaComponent},
  { path: 'proponenteprogetto/gestirecandidature', component: GestirecandidatureListprogettiComponent},
  { path: 'proponenteprogetto/gestirecandidature/:id/candidati', component: GestirecandidatureListcandidatiComponent},
  { path: 'proponenteprogetto/gestirecandidature/:id/candidati/:idc', component: GestirecandidatureAcceptdeclineComponent},
  { path: 'proponenteprogetto/removeprogettista', component: RimuovereprogettistaListprogettoComponent},
  { path: 'proponenteprogetto/removeprogettista/:id/getTeam', component: RimuovereprogettistaProgettistiteamComponent},
  { path: 'proponenteprogetto/removeprogettista/:id/getTeam/:idp', component: RimuovereprogettistaRemoveprogettistaComponent},
  { path: 'esperto', component: EspertoComponent},
  { path: 'esperto/progettidavalutare', component: ProgettidavalutarelistComponent},
  { path: 'esperto/valutaprogetto', component: ValutareprogettoComponent},
  { path: 'esperto/valutaprogetto/:id', component: ValutareprogettoValutaComponent},
  { path: 'progettista', component: ProgettistaComponent},
  { path: 'progettista/notifiche', component: NotificheComponent},
  { path: 'progettista/curriculum', component: CurriculumComponent},
  { path: 'progettista/curriculum/addlanguage', component: CurriculumAddlanguageComponent},
  { path: 'progettista/curriculum/addwe', component: CurriculumAddweComponent},
  { path: 'progettista/addcurriculum', component: AddcurriculumComponent},
  { path: 'progettista/inviti', component: InvitilistComponent},
  { path: 'progettista/inviti/:id', component: InvitilistDecisionComponent},
  { path: 'progettista/inviacandidatura', component: SendcandidaturaListprogettiComponent},
  { path: 'progettista/inviacandidatura/:id/sendCandidatura', component: SendcandidaturaInviaComponent},
  { path: 'progettista/removecandidatura', component: RemovecandidaturaListprogettiComponent},
  { path: 'progettista/removecandidatura/:id/rimuovi', component: RemovecandidaturaRemoveComponent},
  { path: 'sponsor', component: SponsorComponent},
  { path: 'sponsor/progetti', component: ProgettilistComponent},
  { path: 'sponsor/allprogetti', component: TotalprogettiComponent},
  { path: 'sponsor/allprogetti/:id', component: InvesteprogettoComponent},
  { path: 'login', component: LoginComponent},
  { path: 'signin', component: SigninmainComponent},
  // { path: 'signin/proponenteprogetto', component: SigninpropprogettoComponent},
  // { path: 'signin/progettista', component: SigninprogettistaComponent},
  // { path: 'signin/sponsor', component: SigninsponsorComponent},
  { path: "**", component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
