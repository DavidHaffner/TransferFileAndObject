/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransferObject;

import java.io.Serializable;

/**
 *
 * @author dhaffner
 */
public class CustomObject implements Serializable {
    
    private String text;
    
    public CustomObject (String message) {
        this.text = message;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }
    
    
   
}
