package com.tibco.bw.palette.tcta.design;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDSchema;
import com.tibco.bw.design.api.BWExtensionActivitySchema;

public class TCTAExceptionsSchema extends BWExtensionActivitySchema {
   private static String SCHEMA_FILE_PATH = "/schema/TCTAExceptions.xsd"; //$NON-NLS-1$
   private static TCTAExceptionsSchema INSTANCE = new TCTAExceptionsSchema();
   private static final String[] TCTA_PLUGIN_FAULT_TYPE_ELEMENT_NAMES = new String[] { "TCTAPluginException" }; //$NON-NLS-1$

    /**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 */
   @Override
   protected InputStream getSchemaAsInputStream() {
      // begin-custom-code
      // end-custom-code
      return getClass().getResourceAsStream(TCTAExceptionsSchema.SCHEMA_FILE_PATH);
   }
   
    /**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 */
   public static List<XSDElementDeclaration> getTCTAPluginFaultTypes() {
      // begin-custom-code
      // end-custom-code
      return getFaultElements(TCTAExceptionsSchema.TCTA_PLUGIN_FAULT_TYPE_ELEMENT_NAMES);
   }

    /**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 */
   private static List<XSDElementDeclaration> getFaultElements(final String[] faultNames) {
      List<XSDElementDeclaration> faultTypeElements = new ArrayList<XSDElementDeclaration>();
      XSDSchema fileExceptionsSchema = TCTAExceptionsSchema.INSTANCE.loadSchema();  
      if(fileExceptionsSchema != null) {
         for (String faultElementName : faultNames) {
            XSDElementDeclaration faultTypesElement = fileExceptionsSchema.resolveElementDeclaration(faultElementName);
            if(faultTypesElement != null) {
               faultTypeElements.add(faultTypesElement);
            }
         }
      }
      // begin-custom-code
      // end-custom-code
      return faultTypeElements;
   }
}
