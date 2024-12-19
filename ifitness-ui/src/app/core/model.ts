import moment from 'moment';
import { AuthService } from '../security/auth.service';

export class User {
  id!: number;
  name!: string;
  email!: string;
  date!: Date;
  password!: string;
  gender!: string;
  active = true;

  static toJson(user: User): any {
    return {
      id: user.id,
      name: user.name,
      email: user.email,
      password: user.password,
      date: moment(user.date).format('DD/MM/YYYY'),
      gender: user.gender,
      active: user.active
    }
  }
}

export class Activity {
  id!: number;
  type!: 'CAMINHADA';
  data!: Date;
  distance!: number;
  duration!: number;
  user: any;

  constructor(user_id: number){
    this.user = new User();
    this.user.id = user_id;
  }

  static toJson(activity: Activity): any {
    return {
      id: activity.id,
      type: activity.type,
      data: moment(activity.data).format('DD/MM/YYYY'),
      distance: activity.distance,
      duration: activity.duration,
      user: activity.user
    }
  }
}
