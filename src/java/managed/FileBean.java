/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managed;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Vasiliy
 */
@Named(value = "fileBean")
@Dependent
public class FileBean {

    /**
     * Creates a new instance of FileBean
     */
    private UploadedFile uploadedFile;
    
    public FileBean() {
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
    
}
