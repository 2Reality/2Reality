import {Component, OnInit} from '@angular/core';
import {HumanService} from "../../service/human.service";
import {Recommendation} from "../../entities/recommendation";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-human',
  templateUrl: './human.component.html',
  styleUrls: ['./human.component.css']
})
export class HumanComponent implements OnInit {

  human: Recommendation
  username: string

  constructor(private humanService: HumanService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.route.url.subscribe(url => {
      this.username = url[0].path
      this.getHuman()
    })
  }


  getHuman() {
    this.humanService.getHuman(this.username).subscribe(response => {
      console.log(response)
      this.human = response
    })
  }
}
