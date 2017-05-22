import {Component, OnInit, AfterViewInit} from '@angular/core';
import {ConstantsService} from './../services/constants.service';
import {HttpModule} from '@angular/http';
import {Location} from '@angular/common';
import {BlogService} from "../services/blog.service";
import {BlogArticle} from "../model/blogArticle";

@Component({
    selector: 'rest-get-example',
    template: `
        <router-outlet></router-outlet>
      <div class="row">
    <div class="col-md-9">
    <div class="text-center">
      <h3>List of posts about the Angular/Java stack</h3>
      <p>This site shows some code and is only for educational purposes. </p>
      </div>
      </div>
      
     </div>
      <br>
      <div class="row">
       <div class="col-md-9">
       <ul>
          <span *ngFor="let article of blogArticles">
          <div class="panel panel-default">
           <div class="panel-body">
           {{article.title}} <br>
             <a target="_blank" href="{{article.link}}">Link</a>
          
              </div>
              </div>
              
         </span>
      </ul>
      </div>
      <div class="col-md-2">
          <div class="LI-profile-badge"  data-version="v1" data-size="medium" data-locale="en_US" data-type="vertical" data-theme="light" data-vanity="javaee"><a class="LI-simple-link" href='https://www.linkedin.com/in/yehoshua-matamoros-valverde-19738137'>Yehoshua Matamoros Valverde</a></div>
      </div>
      <br>
    `,
    providers: [HttpModule, BlogService, ConstantsService, Location]
    })


export class BlogComponent implements OnInit, AfterViewInit{

    constructor(private _blogService : BlogService){}

    errorMessage: string;
    blogArticles : BlogArticle[];

    getArticleList(){

       /* this._davisService.getDavisCups().then(davis => this.davisCups = davis)*/
        this._blogService.getArticleList().subscribe(
            articleList => this.blogArticles = articleList,
            error =>  this.errorMessage = <any>error);
        console.log(this.blogArticles);
    }

    ngOnInit(){
        this.getArticleList();
    }

    ngAfterViewInit() {

    }

} // export -> create a module


