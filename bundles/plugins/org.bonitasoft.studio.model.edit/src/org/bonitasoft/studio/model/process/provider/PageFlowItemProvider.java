/**
 * Copyright (C) 2009-2015 BonitaSoft S.A.
 * BonitaSoft, 32 rue Gustave Eiffel - 38000 Grenoble
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
package org.bonitasoft.studio.model.process.provider;


import java.util.Collection;
import java.util.List;

import org.bonitasoft.studio.model.expression.ExpressionFactory;

import org.bonitasoft.studio.model.form.FormFactory;

import org.bonitasoft.studio.model.process.PageFlow;
import org.bonitasoft.studio.model.process.ProcessFactory;
import org.bonitasoft.studio.model.process.ProcessPackage;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link org.bonitasoft.studio.model.process.PageFlow} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PageFlowItemProvider extends ConnectableElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageFlowItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addRegExpToHideDefaultFieldPropertyDescriptor(object);
			addUseRegExpToHideDefaultFieldPropertyDescriptor(object);
			addByPassFormsGenerationPropertyDescriptor(object);
			addConfirmationTemplatePropertyDescriptor(object);
			addEntryPageFlowTypePropertyDescriptor(object);
			addTransmitURLAsParameterPropertyDescriptor(object);
			addEntryRedirectionURLPropertyDescriptor(object);
			addConfirmationMessagePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Reg Exp To Hide Default Field feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRegExpToHideDefaultFieldPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractPageFlow_regExpToHideDefaultField_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractPageFlow_regExpToHideDefaultField_feature", "_UI_AbstractPageFlow_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ProcessPackage.Literals.ABSTRACT_PAGE_FLOW__REG_EXP_TO_HIDE_DEFAULT_FIELD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Use Reg Exp To Hide Default Field feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUseRegExpToHideDefaultFieldPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractPageFlow_useRegExpToHideDefaultField_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractPageFlow_useRegExpToHideDefaultField_feature", "_UI_AbstractPageFlow_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ProcessPackage.Literals.ABSTRACT_PAGE_FLOW__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the By Pass Forms Generation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addByPassFormsGenerationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PageFlow_byPassFormsGeneration_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_PageFlow_byPassFormsGeneration_feature", "_UI_PageFlow_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ProcessPackage.Literals.PAGE_FLOW__BY_PASS_FORMS_GENERATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Confirmation Template feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConfirmationTemplatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PageFlow_confirmationTemplate_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_PageFlow_confirmationTemplate_feature", "_UI_PageFlow_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ProcessPackage.Literals.PAGE_FLOW__CONFIRMATION_TEMPLATE,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Entry Page Flow Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEntryPageFlowTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PageFlow_entryPageFlowType_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_PageFlow_entryPageFlowType_feature", "_UI_PageFlow_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ProcessPackage.Literals.PAGE_FLOW__ENTRY_PAGE_FLOW_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Transmit URL As Parameter feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTransmitURLAsParameterPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PageFlow_transmitURLAsParameter_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_PageFlow_transmitURLAsParameter_feature", "_UI_PageFlow_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ProcessPackage.Literals.PAGE_FLOW__TRANSMIT_URL_AS_PARAMETER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Entry Redirection URL feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEntryRedirectionURLPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PageFlow_entryRedirectionURL_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_PageFlow_entryRedirectionURL_feature", "_UI_PageFlow_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ProcessPackage.Literals.PAGE_FLOW__ENTRY_REDIRECTION_URL,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Confirmation Message feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConfirmationMessagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PageFlow_confirmationMessage_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_PageFlow_confirmationMessage_feature", "_UI_PageFlow_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ProcessPackage.Literals.PAGE_FLOW__CONFIRMATION_MESSAGE,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ProcessPackage.Literals.PAGE_FLOW__TRANSIENT_DATA);
			childrenFeatures.add(ProcessPackage.Literals.PAGE_FLOW__PAGE_FLOW_CONNECTORS);
			childrenFeatures.add(ProcessPackage.Literals.PAGE_FLOW__PAGE_FLOW_TRANSITIONS);
			childrenFeatures.add(ProcessPackage.Literals.PAGE_FLOW__FORM);
			childrenFeatures.add(ProcessPackage.Literals.PAGE_FLOW__ENTRY_REDIRECTION_ACTIONS);
			childrenFeatures.add(ProcessPackage.Literals.PAGE_FLOW__FORM_MAPPING);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns PageFlow.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/PageFlow")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((PageFlow)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_PageFlow_type") : //$NON-NLS-1$
			getString("_UI_PageFlow_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(PageFlow.class)) {
			case ProcessPackage.PAGE_FLOW__REG_EXP_TO_HIDE_DEFAULT_FIELD:
			case ProcessPackage.PAGE_FLOW__USE_REG_EXP_TO_HIDE_DEFAULT_FIELD:
			case ProcessPackage.PAGE_FLOW__BY_PASS_FORMS_GENERATION:
			case ProcessPackage.PAGE_FLOW__CONFIRMATION_TEMPLATE:
			case ProcessPackage.PAGE_FLOW__ENTRY_PAGE_FLOW_TYPE:
			case ProcessPackage.PAGE_FLOW__TRANSMIT_URL_AS_PARAMETER:
			case ProcessPackage.PAGE_FLOW__ENTRY_REDIRECTION_URL:
			case ProcessPackage.PAGE_FLOW__CONFIRMATION_MESSAGE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ProcessPackage.PAGE_FLOW__TRANSIENT_DATA:
			case ProcessPackage.PAGE_FLOW__PAGE_FLOW_CONNECTORS:
			case ProcessPackage.PAGE_FLOW__PAGE_FLOW_TRANSITIONS:
			case ProcessPackage.PAGE_FLOW__FORM:
			case ProcessPackage.PAGE_FLOW__ENTRY_REDIRECTION_ACTIONS:
			case ProcessPackage.PAGE_FLOW__FORM_MAPPING:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(ProcessPackage.Literals.PAGE_FLOW__TRANSIENT_DATA,
				 ProcessFactory.eINSTANCE.createData()));

		newChildDescriptors.add
			(createChildParameter
				(ProcessPackage.Literals.PAGE_FLOW__TRANSIENT_DATA,
				 ProcessFactory.eINSTANCE.createJavaObjectData()));

		newChildDescriptors.add
			(createChildParameter
				(ProcessPackage.Literals.PAGE_FLOW__TRANSIENT_DATA,
				 ProcessFactory.eINSTANCE.createBusinessObjectData()));

		newChildDescriptors.add
			(createChildParameter
				(ProcessPackage.Literals.PAGE_FLOW__TRANSIENT_DATA,
				 ProcessFactory.eINSTANCE.createXMLData()));

		newChildDescriptors.add
			(createChildParameter
				(ProcessPackage.Literals.PAGE_FLOW__PAGE_FLOW_CONNECTORS,
				 ProcessFactory.eINSTANCE.createConnector()));

		newChildDescriptors.add
			(createChildParameter
				(ProcessPackage.Literals.PAGE_FLOW__PAGE_FLOW_CONNECTORS,
				 ProcessFactory.eINSTANCE.createActorFilter()));

		newChildDescriptors.add
			(createChildParameter
				(ProcessPackage.Literals.PAGE_FLOW__PAGE_FLOW_TRANSITIONS,
				 ProcessFactory.eINSTANCE.createPageFlowTransition()));

		newChildDescriptors.add
			(createChildParameter
				(ProcessPackage.Literals.PAGE_FLOW__FORM,
				 FormFactory.eINSTANCE.createForm()));

		newChildDescriptors.add
			(createChildParameter
				(ProcessPackage.Literals.PAGE_FLOW__FORM,
				 FormFactory.eINSTANCE.createViewForm()));

		newChildDescriptors.add
			(createChildParameter
				(ProcessPackage.Literals.PAGE_FLOW__ENTRY_REDIRECTION_ACTIONS,
				 ExpressionFactory.eINSTANCE.createOperation()));

		newChildDescriptors.add
			(createChildParameter
				(ProcessPackage.Literals.PAGE_FLOW__FORM_MAPPING,
				 ProcessFactory.eINSTANCE.createFormMapping()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == ProcessPackage.Literals.DATA_AWARE__DATA ||
			childFeature == ProcessPackage.Literals.PAGE_FLOW__TRANSIENT_DATA ||
			childFeature == ProcessPackage.Literals.CONNECTABLE_ELEMENT__CONNECTORS ||
			childFeature == ProcessPackage.Literals.PAGE_FLOW__PAGE_FLOW_CONNECTORS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2", //$NON-NLS-1$
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}