import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';
import {throwError as observableThrowError} from 'rxjs';
import { Progettista } from '../interface/progettista';
import { Curriculum } from '../interface/curriculum';
import { Notifica } from '../interface/notifica';

@Injectable({
  providedIn: 'root'
})
export class ProgettistaService {

  private urlGet: string = "http://localhost:8080/"
  private urlGetProgettistiPP: string = "http://localhost:8080/api/propProgetto/"
  private urlGetProgettista: string = "http://localhost:8080/api/progettista/"

  constructor(private http: HttpClient) { }

  getProgettistiUser(): Observable<Progettista[]>{
    return this.http.get<Progettista[]>(this.urlGet+'getprogettisti/')
                    .pipe(catchError(this.errorHandler));
  }

  getProgettistaById(id): Observable<Progettista> {
    return this.http.get<Progettista>(this.urlGet+'getprogettista/'+id)
              .pipe(catchError(this.errorHandler));
  }

  getProgettistiPPinvite(id,idPP,token): Observable<Progettista[]> {
    return this.http.get<Progettista[]>(this.urlGetProgettistiPP+'progettigestiti/'+id+'/invite?idProponente='+idPP+'&token='+token)
              .pipe(catchError(this.errorHandler));
  }

  addInvite(idProgetto,idProgettista,idPP,token): Observable<any> {
    return this.http.post<any>(this.urlGetProgettistiPP+'progettigestiti/'+idProgetto+'/invite/'+idProgettista+'?idProp='+idPP+'&token='+token, null)
      .pipe(catchError(this.errorHandler));   
  }

  acceptCandidato(idProgetto,idPP,idCandidato,token): Observable<any> {
    return this.http.post<any>(this.urlGetProgettistiPP+'progettigestiti/'+idProgetto+'/candidati/'+idCandidato+'/accept?idProponente='+idPP+'&token='+token, null)
      .pipe(catchError(this.errorHandler));   
  }

  declineCandidato(idProgetto,idPP,idCandidato,token): Observable<any> {
    return this.http.post<any>(this.urlGetProgettistiPP+'progettigestiti/'+idProgetto+'/candidati/'+idCandidato+'/decline?idProponente='+idPP+'&token='+token, null)
      .pipe(catchError(this.errorHandler));   
  }

  getCandidatiProgettoPP(id,idPP,token): Observable<Progettista[]> {
    return this.http.get<Progettista[]>(this.urlGetProgettistiPP+'progettigestiti/'+id+'/candidati?idProp='+idPP+'&token='+token)
              .pipe(catchError(this.errorHandler));
  }

  getProgettistiTeamPP(idP,idPP,token): Observable<Progettista[]> {
    return this.http.get<Progettista[]>(this.urlGetProgettistiPP+'progettigestiti/'+idP+'/getTeam/?idProponente='+idPP+'&token='+token)
              .pipe(catchError(this.errorHandler));
  }

  deliteProgettistaPP(idProgetto,idProgettista,idPP,token): Observable<any> {
    return this.http.delete<any>(this.urlGetProgettistiPP+'progettigestiti/'+idProgetto+'/getTeam/'+idProgettista+'/remove?idProponente='+idPP+'&token='+token)
      .pipe(catchError(this.errorHandler));   
  }

  getCurriculum(idP,token): Observable<Curriculum> {
    return this.http.get<Curriculum>(this.urlGetProgettista+idP+'/curriculum/?token='+token)
              .pipe(catchError(this.errorHandler));
  }

  addCurriculum(idP,token,phone,instruction,formaction,email): Observable<any> {
    return this.http.post<any>(this.urlGetProgettista+idP+'/addcurriculum/?phone='+phone+'&instruction='+instruction
                    +'&formaction='+formaction+'&email='+email+'&token='+token,{})
              .pipe(catchError(this.errorHandler));
  }

  addLanguage(idP,token,language): Observable<any> {
    return this.http.put<any>(this.urlGetProgettista+idP+'/curriculum/addlanguage/?language='+language+'&token='+token,{})
              .pipe(catchError(this.errorHandler));
  }

  addwe(idP,token,we): Observable<any> {
    return this.http.put<any>(this.urlGetProgettista+idP+'/curriculum/addworkingexperience/?experience='+we+'&token='+token,{})
              .pipe(catchError(this.errorHandler));
  }

  getNotifiche(idP,token): Observable<Notifica[]> {
    return this.http.get<Notifica[]>(this.urlGetProgettista+idP+'/getnotifiche/?token='+token)
              .pipe(catchError(this.errorHandler));
  }

  errorHandler(error: HttpErrorResponse){
    return observableThrowError(error.message || "Server error");
  }
}
