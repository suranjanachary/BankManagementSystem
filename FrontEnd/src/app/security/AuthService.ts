import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { map } from "rxjs";
import { environment } from "../environments/environment";


@Injectable({
    providedIn : 'root'
})
export class AuthService {


    public username : string;
    public password : string;

    constructor(private httpClient : HttpClient){

    }

    login(username : string, password : string){
        return this.httpClient.get(environment.hostUrl + `/api/customers/all/customers`,
        { headers: { authorization: this.createBasicAuthToken(username, password) } }).pipe(map((res) => {
            this.username = username;
            this.password = password;
            this.registerSuccessfulLogin(username, password);
          }));
      }

      createBasicAuthToken(username: string, password: string) {
        return 'Basic ' + window.btoa(username + ":" + password);
      }
    
      registerSuccessfulLogin(username, password) {
        // save the username to session
      }
}