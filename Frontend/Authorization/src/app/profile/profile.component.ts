import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { fromEvent, Subject, takeUntil } from 'rxjs';
import { StorageService } from '../services/storage.service';
import { UserprofieService } from '../services/userprofie.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit{
  currentUser: any;
  username:any;
  email:any;

  profileDetails:any={
    profileId:'',
    personalInfo:'',
    email:'',
    gender:'',
    mobileNo:''
  }

  constructor(private storageService: StorageService,private router:Router,
    private userProfile: UserprofieService) { }

  ngOnInit(): void {
    this.currentUser = this.storageService.getUser();
    console.log(this.currentUser);
    this.username = this.currentUser.username;
    this.profileDetails.profileId = this.currentUser.username;
    this.profileDetails.email = this.currentUser.email;
    console.log(this.username);
    this.userProfile.getProfileById(this.profileDetails.profileId).subscribe(data=>{
      console.log(data);
      this.profileDetails = data;
    });
  }


 addNewProfile(){
   this.userProfile.addNewProfile(this.profileDetails).subscribe(data=>{
    console.log(data);
    alert("Profile has been added successfully");
    this.getById();
   })
 }

 getById(){
  this.userProfile.getProfileById(this.profileDetails.profileId).subscribe(data=>{
    console.log(data);
  })
 }

 onClickEdit(){
   this.router.navigate(['update-profile'])
 }

 user:any = {
  firstName:'',
  lastName: '',
  userId:0,
  mobileNumber:0,
  email:'',
  password:'',
 };

}


