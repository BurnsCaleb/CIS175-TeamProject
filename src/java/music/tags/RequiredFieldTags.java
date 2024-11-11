/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package music.tags;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import javax.servlet.jsp.JspException;

//created custom jsp tag 
public class RequiredFieldTags extends SimpleTagSupport{
    private String fieldName;
    private String error;
//sets field name of the product page with the required field name
    public void setFieldName(String fieldName){
        this.fieldName = fieldName;
    }
    
     public void setError(String error) {
        this.error = error;
    }
    //checks to see if the fieldname is set and not empty then writes the field name followed by the asterisk on the required fields
    @Override
    public void doTag() throws JspException, IOException{
        if (fieldName != null && !fieldName.isEmpty()){
          getJspContext().getOut().write(fieldName);
        }
        if(error != null && !error.isEmpty()){
            getJspContext().getOut().write("<div class='error'> *" + error + "</div>");
        }
        
    }
}
