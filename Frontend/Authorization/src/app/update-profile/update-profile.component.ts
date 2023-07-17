import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StorageService } from '../services/storage.service';
import { UserprofieService } from '../services/userprofie.service';

@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css'],
})
export class UpdateProfileComponent implements OnInit {
  currentUser: any;
  profileDetails: any = {
    profileId: '',
    personalInfo: '',
    email: '',
    gender: '',
    mobileNo: '',
  };

  constructor(
    private userProfile: UserprofieService,
    private storageService: StorageService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.currentUser = this.storageService.getUser().username;
    this.profileDetails.profileId = this.currentUser;
    this.profileDetails.email = this.storageService.getUser().email;
    this.userProfile.getProfileById(this.profileDetails.profileId).subscribe((data) => {
      console.log(data);
      this.profileDetails = data;
    });
  }

  editprofile() {
    this.userProfile.updateProfile(this.profileDetails).subscribe((data) => {
      console.log(data);
      alert('saved');
    });
    this.router.navigate(['/profile']).then(() => {
      window.location.reload();
    });
  }
}
