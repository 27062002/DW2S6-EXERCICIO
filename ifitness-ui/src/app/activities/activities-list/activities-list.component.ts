import { Component } from '@angular/core';

@Component({
  selector: 'app-activities-list',
  templateUrl: './activities-list.component.html',
  styleUrl: './activities-list.component.css'
})
export class ActivitiesListComponent {
  activities = [
    { type: 'CORRIDA', activity_date: '06/11/2024', distance: 8.0, duration: 42, user: 'Fernando Duarte' },
    { type: 'CORRIDA', activity_date: '07/11/2024', distance: 8.0, duration: 43, user: 'Fernando Duarte' },
    { type: 'CAMINHADA', activity_date: '07/11/2024', distance: 5.0, duration: 55, user: 'Gislaine Rosales' }
  ];
}
