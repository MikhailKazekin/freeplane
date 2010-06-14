package org.freeplane.plugin.script;

import java.awt.event.ActionEvent;

import org.freeplane.core.controller.Controller;
import org.freeplane.core.ui.AMultipleNodeAction;
import org.freeplane.core.ui.ActionLocationDescriptor;
import org.freeplane.features.common.map.NodeModel;
import org.freeplane.features.mindmapmode.MModeController;

@ActionLocationDescriptor(locations = { "/menu_bar/extras/first/scripting" })
public class ExecuteScriptForSelectionAction extends AMultipleNodeAction {
	private static final long serialVersionUID = 1L;
	private boolean success;
	final private ScriptingEngine engine;

	public ExecuteScriptForSelectionAction(final Controller controller, final ScriptingEngine engine) {
		super("ExecuteScriptForSelectionAction", controller);
		this.engine = engine;
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		success = true;
		getController().getViewController().setWaitingCursor(true);
		try {
			super.actionPerformed(e);
		}
		finally {
			getController().getViewController().setWaitingCursor(false);
		}
	}

	@Override
	protected void actionPerformed(final ActionEvent e, final NodeModel node) {
		if (!success) {
			return;
		}
		success = engine.performScriptOperation((MModeController) getModeController(), node);
	}
}
