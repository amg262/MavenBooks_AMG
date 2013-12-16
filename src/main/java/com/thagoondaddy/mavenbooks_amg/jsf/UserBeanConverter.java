
package com.thagoondaddy.mavenbooks_amg.jsf;

import com.thagoondaddy.mavenbooks_amg.model.User;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * Custom converter class specifically for UserBean class. Handles
 * all conversion and returning of the value depending what type 
 * passed in value is.
 * 
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
@FacesConverter(forClass = User.class)
public class UserBeanConverter implements Converter {

    /**
     *
     * Converter implementation that handles value as object
     * 
     * @param facesContext
     * @param component
     * @param value
     * @return Object 
     */
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0) {
            return null;
        }
        UserBean controller = (UserBean) facesContext.getApplication().getELResolver().
                getValue(facesContext.getELContext(), null, "userController");
        return controller.getUser(getKey(value));
    }

    java.lang.Integer getKey(String value) {
        java.lang.Integer key;
        key = Integer.valueOf(value);
        return key;
    }

    String getStringKey(java.lang.Integer value) {
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        return sb.toString();
    }

    /**
     *
     * Get as String implementation for object passed in value
     * 
     * @param facesContext
     * @param component
     * @param object
     * @return String
     */
    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof User) {
            User o = (User) object;
            return getStringKey(o.getUserID());
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + User.class.getName());
        }
    }
}
