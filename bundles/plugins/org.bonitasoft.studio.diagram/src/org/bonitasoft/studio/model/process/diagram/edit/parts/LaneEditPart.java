/*
 * Copyright (C) 2009 BonitaSoft S.A.
 * BonitaSoft, 31 rue Gustave Eiffel - 38000 Grenoble
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2.0 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.bonitasoft.studio.model.process.diagram.edit.parts;

import org.bonitasoft.studio.common.diagram.ActivityCursorMouseMotionListener;
import org.bonitasoft.studio.common.diagram.ActivityNameCursorMouseMotionListener;
import org.bonitasoft.studio.common.diagram.tools.DragEditPartsTrackerExWithoutCopyWithModKeyPressed;
import org.bonitasoft.studio.common.gmf.tools.GMFTools;
import org.bonitasoft.studio.model.process.diagram.edit.policies.LaneItemSemanticEditPolicy;
import org.bonitasoft.studio.model.process.diagram.part.ProcessVisualIDRegistry;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class LaneEditPart extends ShapeNodeEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 3007;

	/**
	* @generated
	*/
	protected IFigure contentPane;

	/**
	* @generated
	*/
	protected IFigure primaryShape;

	/**
	* @generated
	*/
	public LaneEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new LaneItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	* @generated
	*/
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {

				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	* @generated
	*/
	protected IFigure createNodeShape() {
		return primaryShape = new LaneFigure();
	}

	/**
	* @generated
	*/
	public LaneFigure getPrimaryShape() {
		return (LaneFigure) primaryShape;
	}

	/*
	* @generated by BonitaSoft
	*/
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof LaneNameEditPart) {
			((LaneNameEditPart) childEditPart).setLabel(getPrimaryShape().getFigureLaneNameFigure());
			if (VISUAL_ID != 3007 && VISUAL_ID != 2007 && VISUAL_ID != 3015 && VISUAL_ID != 3058) {
				getPrimaryShape().getFigureLaneNameFigure()
						.addMouseMotionListener(new ActivityNameCursorMouseMotionListener(this));
			}
			return true;
		}
		if (childEditPart instanceof LaneLaneCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getFigureLaneContainerFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((LaneLaneCompartmentEditPart) childEditPart).getFigure());
			return true;
		}

		return false;
	}

	/**
	* @generated
	*/
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof LaneNameEditPart) {
			return true;
		}
		if (childEditPart instanceof LaneLaneCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getFigureLaneContainerFigure();
			pane.remove(((LaneLaneCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	* @generated
	*/
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	* @generated
	*/
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	* @generated
	*/
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof LaneLaneCompartmentEditPart) {
			return getPrimaryShape().getFigureLaneContainerFigure();
		}
		return getContentPane();
	}

	/**
	* @generated
	*/
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(975, 100);
		return result;
	}

	/**
	* @generated
	*/
	public EditPolicy getPrimaryDragEditPolicy() {
		EditPolicy result = super.getPrimaryDragEditPolicy();
		if (result instanceof ResizableEditPolicy) {
			ResizableEditPolicy ep = (ResizableEditPolicy) result;
			ep.setResizeDirections(PositionConstants.SOUTH | PositionConstants.EAST);
		}
		return result;
	}

	/**
	* Creates figure for this edit part.
	* 
	* Body of this method does not depend on settings in generation model
	* so you may safely remove <i>generated</i> tag and modify it.
	* 
	* @generated
	*/
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	* Default implementation treats passed figure as content pane.
	* Respects layout one may have set for generated figure.
	* @param nodeShape instance of generated figure class
	* @generated
	*/
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		if (VISUAL_ID != 3007 && VISUAL_ID != 2007) {
			getPrimaryShape().addMouseMotionListener(new ActivityCursorMouseMotionListener());
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	* @generated
	*/
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	* @generated
	*/
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	* @generated
	*/
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	* @generated
	*/
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	* @generated
	*/
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	* @generated
	*/
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(ProcessVisualIDRegistry.getType(LaneNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class LaneFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLaneNameFigure;
		/**
		 * @generated
		 */
		private RectangleFigure fFigureLaneContainerFigure;

		/**
		 * @generated
		 */
		public LaneFigure() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 2;
			layoutThis.makeColumnsEqualWidth = false;
			layoutThis.horizontalSpacing = 0;
			layoutThis.verticalSpacing = 0;
			layoutThis.marginWidth = 0;
			layoutThis.marginHeight = 0;
			this.setLayoutManager(layoutThis);

			this.setBackgroundColor(THIS_BACK);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(975), getMapMode().DPtoLP(100)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			RectangleFigure nameContainerFigure0 = new RectangleFigure();

			GridData constraintNameContainerFigure0 = new GridData();
			constraintNameContainerFigure0.verticalAlignment = GridData.FILL;
			constraintNameContainerFigure0.horizontalAlignment = GridData.BEGINNING;
			constraintNameContainerFigure0.horizontalIndent = 0;
			constraintNameContainerFigure0.horizontalSpan = 1;
			constraintNameContainerFigure0.verticalSpan = 1;
			constraintNameContainerFigure0.grabExcessHorizontalSpace = false;
			constraintNameContainerFigure0.grabExcessVerticalSpace = true;
			constraintNameContainerFigure0.widthHint = 20;
			constraintNameContainerFigure0.heightHint = 0;
			this.add(nameContainerFigure0, constraintNameContainerFigure0);

			GridLayout layoutNameContainerFigure0 = new GridLayout();
			layoutNameContainerFigure0.numColumns = 1;
			layoutNameContainerFigure0.makeColumnsEqualWidth = true;
			layoutNameContainerFigure0.horizontalSpacing = 0;
			layoutNameContainerFigure0.verticalSpacing = 0;
			layoutNameContainerFigure0.marginWidth = 0;
			layoutNameContainerFigure0.marginHeight = 0;
			nameContainerFigure0.setLayoutManager(layoutNameContainerFigure0);

			fFigureLaneNameFigure = new WrappingLabel();

			fFigureLaneNameFigure.setText("");

			GridData constraintFFigureLaneNameFigure = new GridData();
			constraintFFigureLaneNameFigure.verticalAlignment = GridData.FILL;
			constraintFFigureLaneNameFigure.horizontalAlignment = GridData.FILL;
			constraintFFigureLaneNameFigure.horizontalIndent = 2;
			constraintFFigureLaneNameFigure.horizontalSpan = 1;
			constraintFFigureLaneNameFigure.verticalSpan = 1;
			constraintFFigureLaneNameFigure.grabExcessHorizontalSpace = true;
			constraintFFigureLaneNameFigure.grabExcessVerticalSpace = true;
			nameContainerFigure0.add(fFigureLaneNameFigure, constraintFFigureLaneNameFigure);

			fFigureLaneContainerFigure = new RectangleFigure();

			GridData constraintFFigureLaneContainerFigure = new GridData();
			constraintFFigureLaneContainerFigure.verticalAlignment = GridData.FILL;
			constraintFFigureLaneContainerFigure.horizontalAlignment = GridData.FILL;
			constraintFFigureLaneContainerFigure.horizontalIndent = 0;
			constraintFFigureLaneContainerFigure.horizontalSpan = 1;
			constraintFFigureLaneContainerFigure.verticalSpan = 1;
			constraintFFigureLaneContainerFigure.grabExcessHorizontalSpace = true;
			constraintFFigureLaneContainerFigure.grabExcessVerticalSpace = true;
			this.add(fFigureLaneContainerFigure, constraintFFigureLaneContainerFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLaneNameFigure() {
			return fFigureLaneNameFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureLaneContainerFigure() {
			return fFigureLaneContainerFigure;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 246, 246, 237);

	/*
	* (non-Javadoc)
	* 
	* @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#getDragTracker(org.eclipse.gef.Request)
	*/
	@Override
	public DragTracker getDragTracker(Request request) {
		return new DragEditPartsTrackerExWithoutCopyWithModKeyPressed(this);
	}

	/**
	 * @Generated BonitaSoft
	 */
	@Override
	public Object getAdapter(Class key) {

		if (key == SnapToHelper.class) {
			EditPart parent = getParent();
			while (!(parent instanceof DiagramEditPart)) {
				parent = parent.getParent();
			}
			return GMFTools.getSnapHelper((GraphicalEditPart) parent);
		}

		return super.getAdapter(key);
	}
}
