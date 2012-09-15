package org.freeplane.plugin.openmaps.mapelements;

import java.awt.Dimension;

import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MemoryTileCache;

/** Wrapper class around JMapViewer - stops adding default controller in constructor */

public class OpenMapsViewer extends JMapViewer {
	private static final long serialVersionUID = 1L;
	private static final int HEIGHT = 500;
	private static final int WIDTH = 800;

	public OpenMapsViewer () {
		 super(new MemoryTileCache(), 4);
		 this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}

}
