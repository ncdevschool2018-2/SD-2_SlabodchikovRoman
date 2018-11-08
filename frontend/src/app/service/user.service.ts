import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../model/user";

@Injectable({
  providedIn: 'root'
})

export class UserService {

  constructor(private http: HttpClient) {
  }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>('/api/ba/users');
  }

  saveUser(user: User): Observable<User> {
    return this.http.post<User>('/api/ba/users', user);
  }

  deleteUser(userId: string): Observable<void> {
    return this.http.delete<void>('/api/ba/users/' + userId);
  }

  getUser(userId: string):Observable<User>{
    return this.http.get<User>('/api/ba/users/'+userId)
  }
}
