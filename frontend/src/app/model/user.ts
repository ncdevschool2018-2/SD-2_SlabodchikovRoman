import {Role} from "./role";

export class User {
  id: string;
  login: string;
  password: string;
  role: Role;

  static cloneBase(user: User): User {
    let clonedUser: User = new User();
    clonedUser.id = user.id;
    clonedUser.login = user.login;
    clonedUser.password = user.password;
    clonedUser.role.id=user.role.id;
    clonedUser.role.role_name=user.role.role_name;
    return clonedUser;
  }
}
