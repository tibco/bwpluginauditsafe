package com.tibco.bw.sharedresource.tcta.design;

import org.eclipse.emf.common.ui.EclipseUIPlugin;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class TCTAUIPlugin extends EclipseUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.tibco.bw.sharedresource.tcta.design"; //$NON-NLS-1$

	// The shared instance
	private static TCTAUIPlugin plugin;

	/**
	 * The constructor
	 */
	public TCTAUIPlugin() {
	}
	
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}
	
	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static TCTAUIPlugin getDefault() {
		return plugin;
	}
	
	public static ImageDescriptor getImageDescriptor(String path) {
		 return AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
	
    public synchronized Image getImage(String path) {
          Image image = plugin.getImageRegistry().get(path);
          if (image == null) {
                 ImageDescriptor desc = getImageDescriptor(path);
                 if (desc != null) {
                       image = desc.createImage();
                       plugin.getImageRegistry().put(path, image);
                 }
          }
          return image;
   }

   public static Image getSharedImage(String path) {
          return PlatformUI.getWorkbench().getSharedImages().getImage(path);
   }
}
