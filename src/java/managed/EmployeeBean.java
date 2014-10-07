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
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
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
    private String password;
    private boolean isLogin;

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
    
    public String createUser(String username,String password){
        
        Employee empl = new Employee(null, username, password,null);
        employeeFacade.create(empl);
        return "validate";
    }
    
    
    
    
    
}
