package com.petclinic;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.osgi.framework.Constants;

/**
 * Created with IntelliJ IDEA.
 * User: anarlawar
 * Date: 3/22/13
 * Time: 4:09 PM
 * To change this template use File | Settings | File Templates.
 */

@Component(immediate = true, metatype = true)
@Service(HelloPetService.class)
@Properties({
        @Property(name = Constants.SERVICE_VENDOR, value = "CQ PetService"),
        @Property(name = Constants.SERVICE_DESCRIPTION, value = "Provides a friendly farewell.")
})
public class HelloPetService {

    public String getMessage(String name) {
        return String.format("Hello pet Service %s!", name);
    }
}
