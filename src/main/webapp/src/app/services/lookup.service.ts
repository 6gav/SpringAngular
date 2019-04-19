import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LookupService {

  GetSummonerUrl:string = '/api/Summoner?name=';
  GetMasteryUrl:string = '/api/Mastery?name=';

  constructor(private httpClient: HttpClient) { }

  SearchSummoner(name: string): Observable<any>{
    while(name.includes(" ")){
      name = name.replace(" ", "");
    }

    return this.httpClient.get(this.GetSummonerUrl + name);
  }

  SearchMastery(name: string, champion: number): Observable<any>{
    while(name.includes(" ")){
      name = name.replace(" ", "");
    }

    return this.httpClient.get(this.GetMasteryUrl + name + "&champion=" + champion); 
  }
}
