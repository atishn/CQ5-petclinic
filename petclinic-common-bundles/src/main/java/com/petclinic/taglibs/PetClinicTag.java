package com.petclinic.taglibs;

import com.day.cq.wcm.api.WCMMode;
import com.petclinic.HelloPetService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: anarlawar
 * Date: 3/22/13
 * Time: 4:43 PM
 * To change this template use File | Settings | File Templates.
 */


public class PetClinicTag extends BodyTagSupport {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LoggerFactory.getLogger(PetClinicTag.class);
    private transient PageContext pc = null;

    public int doAfterBody() throws JspException {
        try {

            BundleContext bundleContext = FrameworkUtil.getBundle(HelloPetService.class).getBundleContext();
            HelloPetService petService = (HelloPetService) bundleContext.getService(bundleContext.getServiceReference(HelloPetService.class.getName()));

            JspWriter out = bodyContent.getEnclosingWriter();
            out.write(petService.getMessage("Hello I am in PetClinicTag"));

            BodyContent bodyContent = super.getBodyContent();
            String bodyString = bodyContent.getString();
            if (WCMMode.fromRequest(pc.getRequest()) == WCMMode.EDIT) {
//                JspWriter out = bodyContent.getEnclosingWriter();
//                bodyString = "<div style=\"border-width:1px;border-style:solid;border-color:blue\">" + bodyString + "</div>";
//                out.write(bodyString);
            }
        } catch (IOException e) {
            LOGGER.error("I/O error in authorbox tag: ", e);
        }
        return SKIP_BODY;

    }

    @Override
    public void setPageContext(PageContext p) {
        pc = p;
    }

    @Override
    public void release() {
        pc = null;
    }

}
