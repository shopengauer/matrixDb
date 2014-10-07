/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managed;

import java.io.Serializable;
import java.util.Locale;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Vasiliy
 */
@Named(value = "localeBean")
@SessionScoped
public class LocaleBean implements Serializable{

    /**
     * Creates a new instance of AppSet
     */
     private String currentLanguge;
    
    public LocaleBean() {
    }
    
    public String englishAction(){
        FacesContext context = FacesContext.getCurrentInstance();
        context.getViewRoot().setLocale(Locale.ENGLISH);
        currentLanguge = "English";
       return null;    
    }
    public String russianAction(){
       FacesContext context = FacesContext.getCurrentInstance();
       context.getViewRoot().setLocale(new Locale("ru"));
       currentLanguge = "Russian"; 
       return null;    
    }
     
    public String getCurrentLanguge() {
         FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.ENGLISH);
        Locale locale= FacesContext.getCurrentInstance().getViewRoot().getLocale();
        return locale.getLanguage();
    }

    public void setCurrentLanguge(String currentLanguge) {
       
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("RU"));   
        
        this.currentLanguge = currentLanguge;
    }
    
}
