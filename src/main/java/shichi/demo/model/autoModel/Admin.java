package shichi.demo.model.autoModel;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class Admin {
    @NotEmpty
    @Pattern(regexp ="\\S{0,12}",message = "账号为小于12位的数字加字母")
    private String adminId;
    @NotEmpty
    @Pattern(regexp ="[\\u4e00-\\u9fa5]+",message = "姓名必须为中文")
    private String username;
    @NotEmpty
    @Pattern(regexp ="\\d{11}",message = "无效的手机号码")
    private String phone;
    @NotEmpty
    @Pattern(regexp ="\\S{0,12}",message = "密码为小于12位的数字加字母")
    private String password;

    private String role;
    @NotEmpty
    @Pattern(regexp ="[\\u4e00-\\u9fa5]+",message = "角色名称必须为中文")
    private String roleName;

    private Boolean state;

    public Admin(String adminId, String username, String phone, String password, String role, String roleName, Boolean state) {
        this.adminId = adminId;
        this.username = username;
        this.phone = phone;
        this.password = password;
        this.role = role;
        this.roleName = roleName;
        this.state = state;
    }

    public Admin() {
        super();
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId == null ? null : adminId.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}