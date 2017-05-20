import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs/add/operator/toPromise'; // needed to transform the Observable in Promise

import {ConstantsService} from './constants.service';
import {JsonString} from '../model/JsonString';
// asynchronous observable
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import {  RequestOptions, URLSearchParams } from '@angular/http';
import any = jasmine.any;
// we store the service ressource in a constant
const LOGIN_API : string = '/rest/login';

@Injectable()
export class LoginService {


    constructor (private http: Http, private ConstantsService: ConstantsService) {}

    // this url is declared in the HelloWorldController.java
    private _loginUrl =  this.ConstantsService.BACKEND_URL + LOGIN_API;


    // return an observable and not a Promise
    getValidUser(user : string, password : string) : Observable<JsonString> {
       let params: URLSearchParams = new URLSearchParams();
        params.set('username', user);
        params.set('password', password);

        let requestOptions = new RequestOptions();
        requestOptions.search = params;

        console.log('calling : ' + this._loginUrl);
        return this.http
            .get(this._loginUrl, requestOptions) // return RxJS Observable
            .map((response: Response) => {

                console.log("REST response: " + response);
                console.log("REST response json: " + JSON.stringify(response.json()));

                return response.json();
            })
    }



}