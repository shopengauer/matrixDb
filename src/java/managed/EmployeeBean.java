/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managed;

import entity.Employee;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.transaction.UserTransaction;
import org.primefaces.context.RequestContext;
import session.EmployeeFacade;
import session.EmployeeFacadeLocal;

/**
 *
 * @author Vasiliy
 */
@Named//(value = "employeeBean")
@SessionScoped
public class EmployeeBean implements Serializable {

    /**
     * Creates a new instance of EmployeeBean
     */
      @EJB
      EmployeeFacadeLocal employeeFacade;
    
    private String name;
    private String firstname;
    private String lastname;
    private String password;
   
    private String jobTitle;
    private boolean isLogin;
    private String account;
    private String department;
    private List<SelectItem> selectItem;
    
    
    private List<String> departments;

    @PostConstruct
    void initDepartments(){
       
      // SelectItem[] selectItem = new SelectItem[]{new SelectItem("ПТО", "ПТО"),new SelectItem("Цех", "Цех")};
        
        selectItem = new ArrayList<>();
        selectItem.add(new SelectItem("PTO", "PTO"));
        selectItem.add(new SelectItem("Ceh", "Ceh"));
       
        
        this.departments = new ArrayList<>();
        departments.add("A");
        departments.add("B");
        departments.add("C");
        departments.add("ПТО");
        departments.add("E");
        departments.add("F");
    }

    public List<SelectItem> getSelectItem() {
        return selectItem;
    }
  
    
    public Collection<String> getDepartments() {
        return departments;
    }

    
    
    
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
   
    
    public boolean getLogin() {
        return isLogin;
    }

    public void setLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }
    
    public EmployeeBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String UserValidate(String name,String password){
       
       // String accountName = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("AccountName");
       // String accountPassword = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("AccountPassword");
      //  setLogin(false);
    //    RequestContext.getCurrentInstance().update("mainLayout");
  //      Employee emp =  employeeFacade.selectEmployeeByName(name);
     
//      if((emp != null)){
//          if ((name.equals(emp.getUsername())) && (password.equals(emp.getPassword()))){
//              this.name = emp.getUsername();
//              this.password = emp.getPassword();       
//            FacesContext facesContext =  FacesContext.getCurrentInstance();
//        //    Session session  = facesContext.getExternalContext()
//            //  setIsLogin(true);
//              return "welcome";
//          }
//      } 
      this.name = name;
      return "welcome";
      
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    
    
    
    
    public String createUser(String username,String password){
        
        Employee empl = new Employee(null, username, password,null);
        employeeFacade.create(empl);
        return "validate";
    }
    
    
    
    
    
}
