import {Component, OnInit, TemplateRef} from '@angular/core';
import {User} from "../model/user";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs/internal/Subscription";
import {UserService} from "../service/user.service";
import {Role} from "../model/role";
import {RoleService} from "../service/role.service";


@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  public editMode = false;
  public temp_id: string;
  public users: User[];
  public roles: Role[];
  public editableBa: User = new User();
  public modalRef: BsModalRef;
  public selectedRole: Role;

  private subscriptions: Subscription[] = [];

  constructor(private userService: UserService,
              private modalService: BsModalService,
              private roleService: RoleService) {

  }

  ngOnInit() {
    this.loadRoles();
    this.loadUsers();
  }


  _closeModal(): void {
    this.modalRef.hide();
  }


  _openModal(template: TemplateRef<any>, user: User): void {
    if (user) {
      this.editMode = true;
      this.editableBa = User.cloneBase(user);
    } else {
      this.refreshBa();
      this.editMode = false;
    }

    this.modalRef = this.modalService.show(template);
  }


  _addUser(): void {
    console.log(this.editableBa);
    this.subscriptions.push(this.userService.saveUser(this.editableBa).subscribe(() => {
      this._updateUsers();
      this.refreshBa();
      this._closeModal();
    }));
  }


  _updateUsers()
    :
    void {
    this.loadUsers();
  }


  _deleteUser(userId: string):
    void {
    this.subscriptions.push(this.userService.deleteUser(userId).subscribe(() => {
      this._updateUsers();
    }));
  }


  refreshBa(): void {
    this.editableBa = new User();
  }


  loadUsers(): void {
    this.subscriptions.push(this.userService.getUsers().subscribe(accounts => {
      this.users = accounts as User[];
      console.log(this.users);
    }));
  }


  loadRoles(): void {
    this.subscriptions.push(this.roleService.getRoles().subscribe(accounts => {
      this.roles = accounts as Role[];
      this.selectedRole = this.roles[0];
      console.log(this.roles);
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

}

