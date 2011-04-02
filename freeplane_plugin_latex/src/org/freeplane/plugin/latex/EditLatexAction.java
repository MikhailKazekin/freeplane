package org.freeplane.plugin.latex;

import java.awt.event.ActionEvent;

import org.freeplane.core.controller.Controller;
import org.freeplane.core.ui.AFreeplaneAction;
import org.freeplane.features.common.map.NodeModel;

/**
 * 
 * @author Stefan Ott
 *
 *This class is called when a Latex formula is edited
 */
public class EditLatexAction extends AFreeplaneAction {
	private static final long serialVersionUID = 1L;
	private final LatexNodeHook nodeHook;

	public EditLatexAction(final LatexNodeHook nodeHook) {
		super("LatexEditLatexAction");
		this.nodeHook = nodeHook;
	}

	public void actionPerformed(final ActionEvent e) {
		final NodeModel node = Controller.getCurrentModeController().getMapController().getSelectedNode();
		nodeHook.editLatexInEditor(node);
		Controller.getCurrentModeController().getMapController()
		    .nodeChanged(node, NodeModel.UNKNOWN_PROPERTY, null, null);
	}
}
