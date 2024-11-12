import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import Pusher from 'pusher-js'
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  username='username';
  message='';
  messages:any=[];
  constructor(private http:HttpClient){

  }
  ngOnInit(): void {
    Pusher.logToConsole = true;

    const pusher = new Pusher('e31c5a0d04cb7cafebe9', {
      cluster: 'mt1'
    });

    const channel = pusher.subscribe('chat');
    channel.bind('message', (data:any) => {
      this.messages.push(data);
    });
  }


  submit():void{
    this.http.post("http://localhost:8000/api/messages",{
      username:this.username,
      message:this.message
    }).subscribe(()=>this.message='');
    this.message=''
  }

  value1:any = "";
value2:any= "";  
 
handleInput(event: Event) {
   this.value1 = (<HTMLInputElement>event.target).value;
}

inputChange(event: Event){
  this.value1 = (<HTMLInputElement>event.target).value;
  this.message= this.value1;
}
}
