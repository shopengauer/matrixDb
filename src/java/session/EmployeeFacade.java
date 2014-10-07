/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Employee;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import managed.EmployeeBean;

/**
 *
 * @author Vasiliy
 */
@Stateless
public class EmployeeFacade extends AbstractFacade<Employee> implements EmployeeFacadeLocal {
    
    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;

    @Inject
    EmployeeBean employeeBean; 
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeeFacade() {
        super(Employee.class);
    }

    @Override
    public Employee selectEmployeeByName(String employeeName) {
        Employee employee = null;
        
        try{ 
          employee =  em.createNamedQuery("Employee.findByUsername", Employee.class).setParameter("username", employeeName).getSingleResult();
        }catch(NoResultException e){
           
            e.getMessage();
           employeeBean.setName(employeeName);
        }
       
       return employee;
    }
}
