package org.bonitasoft.studio.importer.bos.operation;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

import org.bonitasoft.studio.common.repository.Repository;
import org.bonitasoft.studio.importer.bos.i18n.Messages;
import org.bonitasoft.studio.importer.bos.model.BosArchive;
import org.bonitasoft.studio.importer.bos.model.ImportArchiveModel;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.operation.IRunnableWithProgress;

public class ParseBosArchiveOperation implements IRunnableWithProgress {

    private IStatus status;
    private File archiveFile;
    private ImportArchiveModel archiveModel;
    protected Repository currentRepository;

    public ParseBosArchiveOperation(File archiveFile, Repository repository) {
        Objects.requireNonNull(archiveFile);
        Assert.isTrue(archiveFile.exists());
        Objects.requireNonNull(repository);
        this.archiveFile = archiveFile;
        currentRepository = repository;
    }

    @Override
    public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
        monitor.beginTask(Messages.importProcessProgressDialog, IProgressMonitor.UNKNOWN);
        ImportConflictsChecker parser = new ImportConflictsChecker(currentRepository);
        try {
            archiveModel = parser.checkConflicts(new BosArchive(archiveFile), monitor);
        } catch (IOException e) {
            throw new InvocationTargetException(e);
        }
    }

    public IStatus getStatus() {
        return status;
    }

    public ImportArchiveModel getImportArchiveModel() {
        return archiveModel;
    }
}