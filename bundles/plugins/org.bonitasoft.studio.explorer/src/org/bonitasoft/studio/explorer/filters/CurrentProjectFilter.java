/**
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
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
package org.bonitasoft.studio.explorer.filters;

import java.util.Objects;

import org.bonitasoft.studio.common.repository.RepositoryAccessor;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class CurrentProjectFilter extends ViewerFilter {

    private RepositoryAccessor repositoryAccessor;

    public CurrentProjectFilter(RepositoryAccessor repositoryAccessor) {
        this.repositoryAccessor = repositoryAccessor;
    }

    @Override
    public boolean select(Viewer viewer, Object parentElement, Object element) {
        IProject currentProject = repositoryAccessor.getCurrentRepository().getProject();
        if (element instanceof JavaProject) {
            JavaProject project = (JavaProject) element;
            return Objects.equals(currentProject.getName(), project.getElementName());
        } else if (element instanceof IProject) {
            IProject project = (IProject) element;
            return Objects.equals(currentProject, project);
        }
        return true;
    }

}
