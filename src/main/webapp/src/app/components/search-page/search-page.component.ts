import { Component, OnInit } from '@angular/core';
import { LookupService } from '../../services/lookup.service';
import { Profile } from '../../models/Profile';

@Component({
  selector: 'app-search-page',
  templateUrl: './search-page.component.html',
  styleUrls: ['./search-page.component.css']
})
export class SearchPageComponent implements OnInit {

  profile: Profile;

  constructor(private lookupService: LookupService) { }

  ngOnInit() {
    this.profile = null;
  }

  SearchSummoner(name){
    this.lookupService.SearchSummoner(name).subscribe(data => {
      console.log(data);
      if(data.summonerName){
        this.profile = data;
      }
    });
  }

}
