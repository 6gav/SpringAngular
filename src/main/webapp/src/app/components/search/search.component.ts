import { Component, OnInit, Output } from '@angular/core';
import { EventEmitter } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  @Output() EmitSummoner = new EventEmitter();
  SummonerName:string;

  constructor() { }

  ngOnInit() {
  }


  SubmitSearch(){
    this.EmitSummoner.emit(this.SummonerName);
  }

}
