/**
 * Created by yehoshuamatamorosvalverde on 26/2/17.
 */
// Component is a decorator imported from @angular/core
import {Component} from "@angular/core";
import {LoginService} from "../services/login.service";
import {JsonString} from "../model/JsonString";
import {Router} from "@angular/router";

// use of the decorator to register the component
@Component({
        selector : 'bootstrap-login', // <- separated by comma, not semicolomn like in Java
        templateUrl :'../html/login.html',
        providers: [LoginService] // the LoginService has to be declared as provider

    }
)
// name of the component, exported to be reusable
export class LoginComponent {

    isValid : boolean;
    password : string;
    username : string;

    constructor(private loginService : LoginService, public router : Router){
        // subscribe to the service response, we are using Observable
        /*loginService.getValidUser("","")
            .subscribe((data : JsonString) => {
                // we receive a json object, we have to extract the string
                this.isValid = true;
            });*/

    }
    ValidUser() : void {
        console.log('calling : ValidateUser');
        this.loginService.getValidUser(this.username, this.password)
            .subscribe((data : JsonString) => {
            // we receive a json object, we have to extract the string
            this.isValid = true;
        });
        //this.router.navigate(['app-blog']);
        this.router.navigateByUrl('app-blog');
    }
}