export class Role {
  id: string;
  role_name: string;

  static cloneBase(role: Role): Role {
    let clonedRole: Role = new Role();
    clonedRole.role_name = role.role_name;
    clonedRole.id = role.id;
    return clonedRole;
  }
}
