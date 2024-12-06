import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

import { MessageService } from 'primeng/api';

import { ErrorHandlerService } from './../../core/error-handler.service';
import { ActivityService } from './../activity.service';
import { Activity } from './../../core/model';
import { AuthService } from '../../security/auth.service';

@Component({
  selector: 'app-activity-register',
  templateUrl: './activity-register.component.html',
  styleUrls: ['./activity-register.component.css']
})
export class ActivityRegisterComponent {

  types = [
    { label: 'Caminhada', value: 'CAMINHADA' },
    { label: 'Ciclismo', value: 'CICLISMO' },
    { label: 'Corrida', value: 'CORRIDA' },
    { label: 'Natação', value: 'NATACAO' }
  ];

  activity = new Activity(this.auth.jwtPayload?.user_id);

  constructor(
    private activityService: ActivityService,
    private auth: AuthService,
    private errorHandler: ErrorHandlerService,
    private messageService: MessageService,
    private route: ActivatedRoute,
    private router: Router
  ){}

  ngOnInit(): void {
    const id = this.route.snapshot.params[`id`];
    if(id !== undefined){
      this.loadActivity(id);
    }
  }

  get editing(): boolean {
    return Boolean(this.activity.id);
  }

  loadActivity(id: number) {
    this.activityService.findById(id)
      .then(activity => {
        this.activity = activity;
      })
      .catch(error => this.errorHandler.handle(error));
  }

  save(activityForm: NgForm){
    if(this.editing){
      this.updateActivity(activityForm);
    }else{
      this.addActivity(activityForm);
    }
  }

  updateActivity(activityForm: NgForm) {
    this.activityService.update(this.activity)
      .then( activity => {
        this.messageService.add({ severity: 'success', detail: 'Atividade editada com sucesso!' });
        this.activity = activity;
      })
      .catch(error => this.errorHandler.handle(error));
  }

  addActivity(activityForm: NgForm) {
    this.activityService.add(this.activity)
      .then(addedActivity => {
        this.messageService.add({ severity: 'success', detail: 'Atividade adicionada com sucesso!' });
	this.loadActivity(addedActivity.id);
        this.router.navigate(['/activities', addedActivity.id]);
      })
      .catch(error => this.errorHandler.handle(error));
  }

  new(activityForm: NgForm){
    this.activity = new Activity(this.auth.jwtPayload?.user_id);
    activityForm.reset();
    this.router.navigate(['/activities/new']);
  }
}
