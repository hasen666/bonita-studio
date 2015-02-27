/**
 * Copyright (C) 2014 BonitaSoft S.A.
 * BonitaSoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2.0 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.bonitasoft.studio.migration.custom.migration.form;

import static com.google.common.collect.FluentIterable.from;

import org.bonitasoft.studio.model.process.ProcessPackage;
import org.eclipse.emf.edapt.migration.CustomMigration;
import org.eclipse.emf.edapt.migration.MigrationException;
import org.eclipse.emf.edapt.spi.migration.Instance;
import org.eclipse.emf.edapt.spi.migration.Metamodel;
import org.eclipse.emf.edapt.spi.migration.Model;

import com.google.common.base.Predicate;

/**
 * @author Romain Bioteau
 */
public class FormMappingCustomMigration extends CustomMigration {

    @Override
    public void migrateAfter(final Model model, final Metamodel metamodel) throws MigrationException {
        for (final Instance instance : from(model.getAllInstances("process.PageFlow")).filter(
                withoutFormMapping()).toList()) {
            instantiateFormMapping(instance, model);
        }
    }

    private Predicate<Instance> withoutFormMapping() {
        return new Predicate<Instance>() {

            @Override
            public boolean apply(final Instance input) {
                return !input.isSet(ProcessPackage.Literals.PAGE_FLOW__FORM_MAPPING);
            }
        };
    }

    private void instantiateFormMapping(final Instance input, final Model model) {
        input.set("formMapping", model.newInstance("process.FormMapping"));
    }

}
