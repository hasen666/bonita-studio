package org.bonitasoft.studio.condition.validation;

import org.bonitasoft.studio.condition.conditionModel.ConditionModelPackage;
import org.bonitasoft.studio.condition.conditionModel.Expression;
import org.bonitasoft.studio.condition.conditionModel.Expression_Boolean;
import org.bonitasoft.studio.condition.conditionModel.Expression_ProcessRef;
import org.bonitasoft.studio.condition.conditionModel.Operation;
import org.bonitasoft.studio.condition.conditionModel.Operation_Compare;
import org.bonitasoft.studio.condition.conditionModel.util.ConditionModelSwitch;
import org.bonitasoft.studio.condition.i18n.Messages;
import org.bonitasoft.studio.model.parameter.Parameter;
import org.bonitasoft.studio.model.process.BooleanType;
import org.bonitasoft.studio.model.process.Data;
import org.bonitasoft.studio.model.process.DataType;
import org.bonitasoft.studio.model.process.DoubleType;
import org.bonitasoft.studio.model.process.EnumType;
import org.bonitasoft.studio.model.process.FloatType;
import org.bonitasoft.studio.model.process.IntegerType;
import org.bonitasoft.studio.model.process.JavaObjectData;
import org.bonitasoft.studio.model.process.LongType;
import org.bonitasoft.studio.model.process.StringType;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.RootNode;
import org.eclipse.xtext.validation.Check;

public class ConditionModelJavaValidator extends AbstractConditionModelJavaValidator {

    public static final String INVALID_EQUALITY_SIGN = "org.bonitasoft.studio.condition.quickfix.InvalidEqualitySign";

    @Check
    public void checkCompatibleTypes(final Operation_Compare operation) {
        final String errorMessage = new ConditionModelSwitch<String>() {
            @Override
            public String caseUnary_Operation(final org.bonitasoft.studio.condition.conditionModel.Unary_Operation object) {
                return validateUnaryOperation(object.getValue());
            }

            @Override
            public String caseOperation(final Operation object) {
                return compareExpressionsType(object.getLeft(), object.getRight());
            }
        }.doSwitch(operation.getOp());
        if (errorMessage != null) {
            error(errorMessage, operation.eContainingFeature());
        }
    }

    @Check
    public void checkComparatorSign(final Operation_Compare operation) {
        if (operation != null) {
            for (final Adapter adapter : operation.eAdapters()) {
                if (adapter instanceof RootNode) {
                    final RootNode r = (RootNode) adapter;
                    for (final INode iNode : r.getChildren()) {
                        if (iNode.getText().equals("=")) {
                            if (!(!iNode.getNextSibling().getText().equals("=") && iNode.getPreviousSibling().getText().equals("="))
                                    || iNode.getNextSibling().getText().equals("=") && !iNode.getPreviousSibling().getText().equals("=")) {
                                error(Messages.equalityError,  operation, operation.eContainingFeature() ,ConditionModelJavaValidator.INVALID_EQUALITY_SIGN, r.getCompleteContent());
                            }
                        }
                    }
                }
            }
        }
    }

    private String validateUnaryOperation(final Expression e) {
        if (!(e instanceof Expression_ProcessRef && ConditionModelPackage.Literals.EXPRESSION_BOOLEAN.getName().equals(
                getDataType((Expression_ProcessRef) e)))
                && !(e instanceof Expression_Boolean)) {
            return Messages.notBooleanType;
        }
        return null;
    }

    private String compareExpressionsType(final Expression e1, final Expression e2) {
        String e1Type = e1.eClass().getName();
        String e2Type = e2.eClass().getName();
        if (e1 instanceof Expression_ProcessRef) {
            final Expression_ProcessRef data1 = (Expression_ProcessRef) e1;
            e1Type = getDataType(data1);
        }
        if (e2 instanceof Expression_ProcessRef) {
            final Expression_ProcessRef data2 = (Expression_ProcessRef) e2;
            e2Type = getDataType(data2);
        }
        if (e1Type.equals(ConditionModelPackage.Literals.EXPRESSION_DOUBLE.getName())
                || e1Type.equals(ConditionModelPackage.Literals.EXPRESSION_INTEGER.getName())) {
            if (!e2Type.equals(ConditionModelPackage.Literals.EXPRESSION_DOUBLE.getName()) && !e2Type
                    .equals(ConditionModelPackage.Literals.EXPRESSION_INTEGER.getName())) {
                return Messages.incompatibleTypes;
            }
        } else {
            if (!e1Type.equals(e2Type)) {
                return Messages.incompatibleTypes;

            }
        }
        return null;
    }

    private String getDataType(final Expression_ProcessRef e) {
        final EObject data = resolveProxyReferenceOnCurrentResourceSet(e);
        if (data instanceof JavaObjectData) {
            final JavaObjectData javaData = (JavaObjectData) data;
            final String className = javaData.getClassName();
            if (className.equals(Boolean.class.getName())) {
                return ConditionModelPackage.Literals.EXPRESSION_BOOLEAN.getName();
            }
            if (className.equals(String.class.getName())) {
                return ConditionModelPackage.Literals.EXPRESSION_STRING.getName();
            }
            if (className.equals(Integer.class.getName())) {
                return ConditionModelPackage.Literals.EXPRESSION_INTEGER.getName();
            }
            if (className.equals(Long.class.getName())) {
                return ConditionModelPackage.Literals.EXPRESSION_INTEGER.getName();
            }
            if (className.equals(Float.class.getName())) {
                return ConditionModelPackage.Literals.EXPRESSION_DOUBLE.getName();
            }
            if (className.equals(Double.class.getName())) {
                return ConditionModelPackage.Literals.EXPRESSION_DOUBLE.getName();
            }
        } else {
            if (data instanceof Data) {
                final DataType type = ((Data) data).getDataType();
                if (type instanceof BooleanType) {
                    return ConditionModelPackage.Literals.EXPRESSION_BOOLEAN.getName();
                }
                if (type instanceof StringType) {
                    return ConditionModelPackage.Literals.EXPRESSION_STRING.getName();
                }
                if (type instanceof IntegerType) {
                    return ConditionModelPackage.Literals.EXPRESSION_INTEGER.getName();
                }
                if (type instanceof FloatType) {
                    return ConditionModelPackage.Literals.EXPRESSION_DOUBLE.getName();
                }
                if (type instanceof DoubleType) {
                    return ConditionModelPackage.Literals.EXPRESSION_DOUBLE.getName();
                }
                if (type instanceof LongType) {
                    return ConditionModelPackage.Literals.EXPRESSION_INTEGER.getName();
                }
                if (type instanceof EnumType) {
                    return ConditionModelPackage.Literals.EXPRESSION_STRING.getName();
                }
            } else if (data instanceof Parameter) {
                final String type = ((Parameter) data).getTypeClassname();
                if (Boolean.class.getName().equals(type)) {
                    return ConditionModelPackage.Literals.EXPRESSION_BOOLEAN.getName();
                }
                if (String.class.getName().equals(type)) {
                    return ConditionModelPackage.Literals.EXPRESSION_STRING.getName();
                }
                if (Integer.class.getName().equals(type)) {
                    return ConditionModelPackage.Literals.EXPRESSION_INTEGER.getName();
                }
                if (Float.class.getName().equals(type)) {
                    return ConditionModelPackage.Literals.EXPRESSION_DOUBLE.getName();
                }
                if (Double.class.getName().equals(type)) {
                    return ConditionModelPackage.Literals.EXPRESSION_DOUBLE.getName();
                }
                if (Long.class.getName().equals(type)) {
                    return ConditionModelPackage.Literals.EXPRESSION_INTEGER.getName();
                }
            }
        }
        return null;
    }


    protected EObject resolveProxyReferenceOnCurrentResourceSet(
            final Expression_ProcessRef e) {
        final EObject proxy = (EObject) e.eGet(ConditionModelPackage.Literals.EXPRESSION_PROCESS_REF__VALUE , false);
        final ResourceSet rSet = getCurrentResourceSet(proxy);
        final EObject data = EcoreUtil2.resolve(proxy, rSet);
        e.setValue(data);
        if (rSet != null) {
            rSet.getResources().remove(e.eResource());
        }
        return data;
    }


    private ResourceSet getCurrentResourceSet(final EObject proxy) {
        final ResourceSetImpl resourceSetImpl = new ResourceSetImpl();
        final URI uri = EcoreUtil.getURI(proxy);
        if (uri != null && uri.toString().contains(".proc")) {
            final Resource resource = resourceSetImpl.getResource(uri.trimFragment(), true);
            return resource.getResourceSet();
        }
        return null;
    }
}
