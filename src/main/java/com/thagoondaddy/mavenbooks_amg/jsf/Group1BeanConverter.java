
package com.thagoondaddy.mavenbooks_amg.jsf;

import com.thagoondaddy.mavenbooks_amg.model.Group1;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * Custom converter class specifically for Group1Bean class. Handles
 * all conversion and returning of the value depending what type 
 * passed in value is.
 * 
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
@FacesConverter(forClass = Group1.class)
public class Group1BeanConverter implements Converter {

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
        Group1Bean controller = (Group1Bean) facesContext.getApplication().getELResolver().
                getValue(facesContext.getELContext(), null, "group1Controller");
        return controller.getGroup1(getKey(value));
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
        if (object instanceof Group1) {
            Group1 o = (Group1) object;
            return getStringKey(o.getEntryID());
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Group1.class.getName());
        }
    }
}
