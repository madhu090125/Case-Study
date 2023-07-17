import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserprofieService {

  constructor(private httpClient : HttpClient) { }

  getProfileById(id:any){
    return this.httpClient.get("http://localhost:8686/user/"+id);
  }

  addNewProfile(profile:{profileId:any,personalInfo:any,email:any,gender:any,mobileNo:any}){
    return this.httpClient.post("http://localhost:8686/add",profile);
  }

  updateProfile(profile:{profileId:any,personalInfo:any,email:any,mobile:any,gender:any,mobileNo:any}){
    return this.httpClient.put('http://localhost:8686/update',profile);
  }
}
