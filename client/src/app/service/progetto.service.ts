import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { Progetto } from '../interface/progetto';
import { Observable } from 'rxjs';
import {throwError as observableThrowError} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProgettoService {

  private urlGet: string = "http://localhost:8080/"
  private urlGetProgettiEsperto: string = "http://localhost:8080/api/esperto/"
  private urlGetProgettista: string = "http://localhost:8080/api/progettista/"
  private urlGetPP: string = "http://localhost:8080/api/propProgetto/"
  private urlGetSponsor: string = "http://localhost:8080/api/sponsor/" 

  constructor(private http: HttpClient) { }

  getProgettiUser(): Observable<Progetto[]>{
    return this.http.get<Progetto[]>(this.urlGet+'getprogetti/')
                    .pipe(catchError(this.errorHandler));
  }

  getProgettiApproved(): Observable<Progetto[]>{
    return this.http.get<Progetto[]>(this.urlGet+'getprogettiapprovati/')
                    .pipe(catchError(this.errorHandler));
  }

  getProgettoById(id): Observable<Progetto> {
    return this.http.get<Progetto>(this.urlGet+'getprogetto/'+id)
              .pipe(catchError(this.errorHandler));
  }

  getProgettiGestitiPP(id,token): Observable<Progetto[]> {
    return this.http.get<Progetto[]>(this.urlGetPP+'progettigestiti/'+'?idProponente='+id+'&token='+token)
              .pipe(catchError(this.errorHandler));
  }

  getProgettiDaValutare(idE,token): Observable<Progetto[]> {
    return this.http.get<Progetto[]>(this.urlGetProgettiEsperto+'getprogettidavalutare/?idEsperto='+idE+'&token='+token)
              .pipe(catchError(this.errorHandler));
  }

  postProgettiDaValutareConfirm(progettoId,espertoId,token): Observable<any> {
    return this.http.post<any>(this.urlGetProgettiEsperto+'getprogettidavalutare/'+progettoId+'/confirm?idEsperto='+espertoId+'&token='+token,{})
              .pipe(catchError(this.errorHandler));
  }

  postProgettiDaValutareDecline(progettoId,espertoId,token): Observable<any> {
    return this.http.post<any>(this.urlGetProgettiEsperto+'getprogettidavalutare/'+progettoId+'/decline?idEsperto='+espertoId+'&token='+token,{})
              .pipe(catchError(this.errorHandler));
  }

  getInvitiProgettista(id,token): Observable<Progetto[]> {
    return this.http.get<Progetto[]>(this.urlGetProgettista+id+'/inviti/?token='+token)
              .pipe(catchError(this.errorHandler));
  }

  putAcceptInvite(progettoId,progettistaId,token): Observable<any> {
    return this.http.put<any>(this.urlGetProgettista+progettistaId+'/inviti/accept/?idProgetto='+progettoId+'&token='+token,{})
              .pipe(catchError(this.errorHandler));
  }

  putRefuseInvite(progettoId,progettistaId,token): Observable<any> {
    return this.http.put<any>(this.urlGetProgettista+progettistaId+'/inviti/decline/?idProgetto='+progettoId+'&token='+token,{})
              .pipe(catchError(this.errorHandler));
  }

  postSendCandidatura(progettoId,progettistaId,token): Observable<any> {
    return this.http.post<any>(this.urlGetProgettista+progettistaId+'/getprogetti/'+progettoId+'/sendcandidatura/?token='+token,{})
              .pipe(catchError(this.errorHandler));
  }

  getCandidature(progettistaId,token): Observable<Progetto[]> {
    return this.http.get<Progetto[]>(this.urlGetProgettista+progettistaId+'/getcandidature/?token='+token)
              .pipe(catchError(this.errorHandler));
  }

  deleteRemoveCandidatura(progettoId,progettistaId,token): Observable<any> {
    return this.http.delete<any>(this.urlGetProgettista+progettistaId+'/getcandidature/'+progettoId+'/removecandidatura/?token='+token,{})
              .pipe(catchError(this.errorHandler));
  }

  createProgetto(idPP,name,nMaxProgettisti,token): Observable<any> {
    return this.http.post<any>(this.urlGetPP+'createProgetto/?idProponenteProgetto='+idPP+'&name='+name+'&nMaxProgettisti='+nMaxProgettisti+'&token='+token,{})
              .pipe(catchError(this.errorHandler));
  }

  getProgettiSponsor(idP,token): Observable<Progetto[]> {
    return this.http.get<Progetto[]>(this.urlGetSponsor+'progettisponsor/?id='+idP+'&token='+token)
              .pipe(catchError(this.errorHandler));
  }

  incrementAmount(idProgetto,idS,amount,token): Observable<any> {
    return this.http.put<any>(this.urlGetSponsor+'progettisponsor/'+idProgetto+'/increment?idSponsor='+idS+'&amount='+amount+'&token='+token,{})
              .pipe(catchError(this.errorHandler));
  }

  decrementAmount(idProgetto,idS,amount,token): Observable<any> {
    return this.http.put<any>(this.urlGetSponsor+'progettisponsor/'+idProgetto+'/decrement?idSponsor='+idS+'&amount='+amount+'&token='+token,{})
              .pipe(catchError(this.errorHandler));
  }

  amountProgetto(idProgetto,idS,token): Observable<number> {
    return this.http.post<number>(this.urlGetSponsor+'progettisponsor/'+idProgetto+'/?idSponsor='+idS+'&token='+token,{})
              .pipe(catchError(this.errorHandler));
  }

  errorHandler(error: HttpErrorResponse){
    return observableThrowError(error.message || "Server error");
  }
}