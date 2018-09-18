package com.tibco.bw.palette.tas.design;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDSchema;

import com.tibco.bw.design.api.BWExtensionActivitySchema;

public class TasExceptionsSchema extends BWExtensionActivitySchema {
   private static String SCHEMA_FILE_PATH = "/schema/TASExceptions.xsd"; //$NON-NLS-1$
   private static TasExceptionsSchema INSTANCE = new TasExceptionsSchema();
   private static final String[] TAS_PLUGIN_FAULT_TYPE_ELEMENT_NAMES = new String[] { "TASPluginException" }; //$NON-NLS-1$

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
      return getClass().getResourceAsStream(TasExceptionsSchema.SCHEMA_FILE_PATH);
   }
   
    /**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 */
   public static List<XSDElementDeclaration> getTASPluginFaultTypes() {
      // begin-custom-code
      // end-custom-code
      return getFaultElements(TasExceptionsSchema.TAS_PLUGIN_FAULT_TYPE_ELEMENT_NAMES);
   }

    /**
	 * <!-- begin-custom-doc -->
	 * 
	 * <!-- end-custom-doc -->
	 * @generated
	 */
   private static List<XSDElementDeclaration> getFaultElements(final String[] faultNames) {
      List<XSDElementDeclaration> faultTypeElements = new ArrayList<XSDElementDeclaration>();
      XSDSchema fileExceptionsSchema = TasExceptionsSchema.INSTANCE.loadSchema();  
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
