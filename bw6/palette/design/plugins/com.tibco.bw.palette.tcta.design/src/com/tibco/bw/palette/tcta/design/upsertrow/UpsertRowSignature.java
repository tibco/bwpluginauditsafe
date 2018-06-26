package com.tibco.bw.palette.tcta.design.upsertrow;

import java.util.List;

import org.eclipse.xsd.XSDElementDeclaration;
import com.tibco.bw.design.api.BWActivitySignature;
import com.tibco.bw.palette.tcta.design.TctaExceptionsSchema;
import com.tibco.bw.model.activityconfig.Configuration;
import org.eclipse.xsd.XSDCompositor;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDSchema;
import com.tibco.bw.design.util.XSDUtility; 
public class UpsertRowSignature extends BWActivitySignature {
	public static final String TARGET_NS = "http://www.tibco.com/namespaces/tnt/plugins/upsertrow";

    @Override
    public boolean hasInput() {
        return true;
    }
   
    @Override
    public boolean hasOutput() {
        return true;
    }
     
    /**
	* <!-- begin-custom-doc -->
	* 
	* <!-- end-custom-doc -->
	* @generated
	*/
    @Override
    public XSDElementDeclaration getInputType(final Configuration config) {
        XSDElementDeclaration inputType = null;
        String namespace = createNamespace(new Object[] { TARGET_NS,"Input" });
        XSDSchema inputSchema = XSDUtility.createSchema(namespace);
        XSDModelGroup rootInput = XSDUtility.addComplexTypeElement(inputSchema,"ActivityInputType", "ActivityInputType",XSDCompositor.SEQUENCE_LITERAL);
        XSDUtility.addSimpleTypeElement(rootInput, "required", "string", 1, 1);
        XSDUtility.addSimpleTypeElement(rootInput, "optional", "string", 0, 1);
        inputSchema = compileSchema(inputSchema);
        inputType = inputSchema.resolveElementDeclaration(getInputTypeRootName());
        // begin-custom-code
        // end-custom-code
        return inputType;
    } 
    /**
	* <!-- begin-custom-doc -->
	* 
	* <!-- end-custom-doc -->
	* @generated
	*/
    @Override
    public XSDElementDeclaration getOutputType(final Configuration config) {
        XSDElementDeclaration outPutType = null;
        String namespace = createNamespace(new Object[] { TARGET_NS, "Output" }); //$NON-NLS-1$
        XSDSchema outPutSchema = XSDUtility.createSchema(namespace);
	    
        XSDModelGroup rootOutPut = XSDUtility.addComplexTypeElement(outPutSchema,"ActivityOutputType", "ActivityOutputType", XSDCompositor.SEQUENCE_LITERAL);
        XSDUtility.addSimpleTypeElement(rootOutPut, "output", "string", 1, 1);
        outPutSchema = compileSchema(outPutSchema);
        outPutType = outPutSchema.resolveElementDeclaration(getOutputTypeRootName());
        // begin-custom-code
        // end-custom-code
        return outPutType;
    }

    /**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 */
    @Override
    public List<XSDElementDeclaration> getFaultTypes(final Configuration config) {
    	List<XSDElementDeclaration> faultType = null;
        faultType =  TctaExceptionsSchema.getTCTAPluginFaultTypes();
        // begin-custom-code
        // end-custom-code
		return faultType;
    }
}
