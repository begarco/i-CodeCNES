/************************************************************************************************/
/* i-Code CNES is a static code analyzer. */
/* This software is a free software, under the terms of the Eclipse Public License version 1.0. */
/* http://www.eclipse.org/legal/epl-v10.html */
/************************************************************************************************/
package fr.cnes.analysis.tools.export;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import fr.cnes.analysis.tools.analyzer.datas.CheckResult;
import fr.cnes.analysis.tools.export.exception.NoContributorMatchingException;
import fr.cnes.analysis.tools.export.exception.NoExtensionIndicatedException;

/**
 * This class is an import and export service for i-Code CNES.
 * <p>
 * To use it, your plug-in must be dependent of the
 * {@link fr.cnes.analysis.tools.analyzer} plug-in.
 * </p>
 * 
 * <p>
 * The methods of this class throw <tt>NoContributorMatchingException</tt> when
 * a function could not retrieve or reach intended data of a contributor. It
 * also throw <tt>NoIndicatedFormatInFileException</tt> when the file to import
 * or export has no extension.
 * </p>
 * 
 * @since 3.0
 * 
 */
public class Export {

    /** Export extension point ID */
    public static final String EXPORT_EXTENSIONPOINT_ID = "fr.cnes.analysis.tools.export";
    /** Export extension point formatName attribute */
    public static final String EXPORT_EXTENSIONPOINT_ATTRIBUTE_FORMATNAME = "formatName";
    /** Export extension point formatExtension attribute */
    public static final String EXPORT_EXTENSIONPOINT_ATTRIBUTE_EXTENSION = "formatExtension";
    /** Export extension point attribute ExportClass */
    public static final String EXPORT_EXTENSIONPOINT_ATTRIBUTE_EXPORTCLASS = "ExportClass";
    /** Export extension point attribute ImportClass */
    public static final String EXPORT_EXTENSIONPOINT_ATTRIBUTE_IMPORTCLASS = "ImportClass";

    /** Logger **/
    private static final Logger LOGGER = Logger.getLogger(Export.class.getName());

    /**
     * This function return all available {@code formatName} and
     * {@code formatExtension} defined by {@link #EXPORT_EXTENSIONPOINT_ID}
     * contributors.
     * 
     * @return a Map with formatName as key and and formatExtension as value of
     *         every format handled by the contributor of the ExtensionPoint
     *         {@link Export_ExtensionPoint_ID}
     */
    public Map<String, String> getAvailableFormats() {
        final String method = "";
        LOGGER.entering(this.getClass().getName(), method);
        final Map<String, String> formats = new TreeMap<>();
        for (IConfigurationElement contribution : this.getContributions()) {
            formats.put(contribution.getAttribute(EXPORT_EXTENSIONPOINT_ATTRIBUTE_FORMATNAME),
                            contribution.getAttribute(EXPORT_EXTENSIONPOINT_ATTRIBUTE_EXTENSION));
        }
        LOGGER.exiting(this.getClass().getName(), method, formats);
        return formats;
    }

    /**
     * This function returns all {@link IConfigurationElement} contributing to
     * the {@code ExtensionPoint} {@value #EXPORT_EXTENSIONPOINT_ID}.
     * 
     * @return all configuration elements contributing to ExtensionPoint
     *         {@link #EXPORT_EXTENSIONPOINT_ID}
     */
    private IConfigurationElement[] getContributions() {
        final String method = "";
        LOGGER.entering(this.getClass().getName(), method);
        LOGGER.exiting(this.getClass().getName(), method);
        return Platform.getExtensionRegistry()
                        .getConfigurationElementsFor(EXPORT_EXTENSIONPOINT_ID);
    }

    /**
     * This function export each {@link CheckResult} of {@code checkResults}
     * parameter into the {@link File} parameter.
     * 
     * @param checkResults
     *            to export.
     * @param outputFile
     *            to use for the export.
     * @param parameters
     *            parameter required by the export plugin
     * @throws NoContributorMatchingException
     *             when a format can not be handled by the @link {@link Export}
     *             service.
     * @throws NoExtensionIndicatedException
     *             when the {@code outputFile} has no extension indicated.
     * @throws IOException
     *             when the export failed due to a {@link java.io.File}
     *             exception.
     * @throws CoreException
     *             when failing to create executable from contributor of
     *             {@link #EXPORT_EXTENSIONPOINT_ID}'s attribute
     *             {@link #EXPORT_EXTENSIONPOINT_ATTRIBUTE_EXPORTCLASS}.
     */
    public void export(List<CheckResult> checkResults, File outputFile,
                    Map<String, String> parameters) throws NoContributorMatchingException,
                    NoExtensionIndicatedException, IOException, CoreException {
        final String method = "";
        LOGGER.entering(this.getClass().getName(), method);
        final IExport exporter = this.getExportClass(
                        this.getExtensionFromFilePath(outputFile.getAbsolutePath()));
        exporter.export(checkResults, outputFile, parameters);
        LOGGER.exiting(this.getClass().getName(), method);
    }

    /**
     * 
     * @param formatExtension
     *            the extension to retrieve exporter plugin
     * @return the parameters of the plugin exporting the format requested
     * @throws NoContributorMatchingException
     *             when the indicated format has no exporter defined
     * @throws CoreException
     *             when failing to create executable from contributor of
     *             {@link #EXPORT_EXTENSIONPOINT_ID}'s attribute
     *             {@link #EXPORT_EXTENSIONPOINT_ATTRIBUTE_EXPORTCLASS}.
     */
    public Map<String, String> getParameters(String formatExtension)
                    throws NoContributorMatchingException, CoreException {
        final String method = "";
        LOGGER.entering(this.getClass().getName(), method);
        LOGGER.exiting(this.getClass().getName(), method);
        return this.getExportClass(formatExtension).getParameters();
    }

    /**
     * @param formatExtension
     *            the extension to retrieve from exporter plugin
     * @return if an exporter contributor requires parameters
     * @throws NoContributorMatchingException
     *             when the indicated format has no exporter defined.
     * @throws CoreException
     *             when failing to create executable from contributor of
     *             {@link #EXPORT_EXTENSIONPOINT_ID}'s attribute
     *             {@link #EXPORT_EXTENSIONPOINT_ATTRIBUTE_EXPORTCLASS}.
     */
    public boolean hasParameters(String formatExtension)
                    throws NoContributorMatchingException, CoreException {
        final String method = "";
        LOGGER.entering(this.getClass().getName(), method);
        LOGGER.exiting(this.getClass().getName(), method);
        return this.getExportClass(formatExtension).hasParameters();
    }

    /**
     * @param inputFile
     *            to realize the import on.
     * @return the list of {@link CheckResult} extracted from the
     *         {@code inputFile}.
     * @throws NoExtensionIndicatedException
     *             when the {@code inputFile} do not end with an extension.
     * @throws NoContributorMatchingException
     *             when the format of the {@code intputFile} is not handled by
     *             any contributor of the {@link #EXPORT_EXTENSIONPOINT_ID}
     *             contributors {@code ExtensionPoint}.
     */
    public List<CheckResult> importResults(File inputFile)
                    throws NoExtensionIndicatedException, NoContributorMatchingException {
        final String method = "importResults";
        LOGGER.entering(this.getClass().getName(), method, inputFile);
        List<CheckResult> checkResults = null;
        final IImport importer = this
                        .getImportClass(this.getExtensionFromFilePath(inputFile.getAbsolutePath()));
        checkResults = importer.importResults(inputFile);
        if (checkResults == null) {
            final NoContributorMatchingException exception = new NoContributorMatchingException();
            LOGGER.throwing(this.getClass().getName(), method, exception);
            throw exception;
        }
        LOGGER.exiting(this.getClass().getName(), method, checkResults);
        return checkResults;
    }

    /**
     * This function parse a {@link String} indicating the filePath of a file to
     * return it's format.
     * 
     * @param filePath
     *            to search for the extension.
     * @return the format extension of the file without ".".
     * @throws NoExtensionIndicatedException
     *             when there is no indicated format in the file's path.
     */
    private String getExtensionFromFilePath(final String filePath)
                    throws NoExtensionIndicatedException {
        final String method = "";
        LOGGER.entering(this.getClass().getName(), method);
        String extension = "";

        final int index = filePath.lastIndexOf('.');
        final int parents = Math.max(filePath.lastIndexOf('/'), filePath.lastIndexOf('\\'));

        if (index > parents) {
            extension = filePath.substring(index + 1);
        } else {
            final NoExtensionIndicatedException exception = new NoExtensionIndicatedException();
            LOGGER.throwing(this.getClass().getName(), method, exception);
            throw exception;
        }
        LOGGER.exiting(this.getClass().getName(), method, extension);
        return extension;
    }

    /**
     * This function browse {@value #EXPORT_EXTENSIONPOINT_ID} contributors and
     * return the first class implementing {@link IExport} based on the format
     * of {@literal formatExtension} parameter requested.
     * 
     * @param formatExtension
     *            The extension of the file (without ".")
     * @return The IImport class found in contribution to import the extension
     *         of this format.
     * @throws NoContributorMatchingException
     *             when the indicated format has no exporter contribution
     *             defined when failing to create executable from contributor of
     *             {@link #EXPORT_EXTENSIONPOINT_ID}'s attribute
     *             {@link #EXPORT_EXTENSIONPOINT_ATTRIBUTE_EXPORTCLASS}.
     */
    private IImport getImportClass(String formatExtension) throws NoContributorMatchingException {
        final String method = "";
        LOGGER.entering(this.getClass().getName(), method);
        IImport importClass = null;
        for (IConfigurationElement contribution : this.getContributions()) {
            if (contribution.getAttribute(EXPORT_EXTENSIONPOINT_ATTRIBUTE_EXTENSION)
                            .equals(formatExtension)) {
                try {
                    importClass = (IImport) contribution.createExecutableExtension(
                                    EXPORT_EXTENSIONPOINT_ATTRIBUTE_IMPORTCLASS);
                } catch (CoreException e) {
                    e.printStackTrace();
                }
            }
        }
        if (importClass == null) {
            final NoContributorMatchingException exception = new NoContributorMatchingException();
            LOGGER.throwing(this.getClass().getName(), method, exception);
            throw exception;
        }
        LOGGER.exiting(this.getClass().getName(), method, importClass);
        return importClass;
    }

    /**
     * This function browses {@value #EXPORT_EXTENSIONPOINT_ID} contributors and
     * return the first class implementing {@link IExport} set for the format
     * matching {@code formatExtension} parameter requested.
     * 
     * @param formatExtension
     *            extension requested (without ".").
     * @return {@link IExport} set by a contributor to export
     *         {@code formatExtension} requested.
     * @throws NoContributorMatchingException
     *             when there is no contributor of
     *             {@value #EXPORT_EXTENSIONPOINT_ID} able to export the
     *             requested format.
     * @throws CoreException
     *             when failing to create executable from contributor of
     *             {@link #EXPORT_EXTENSIONPOINT_ID}'s attribute
     *             {@link #EXPORT_EXTENSIONPOINT_ATTRIBUTE_EXPORTCLASS}.
     */
    private IExport getExportClass(String formatExtension)
                    throws NoContributorMatchingException, CoreException {
        final String method = "";
        LOGGER.entering(this.getClass().getName(), method);
        /*
         * The export class to return from the contributors of the Extension
         * Point.
         */
        IExport exportClass = null;
        for (IConfigurationElement contribution : this.getContributions()) {
            if (contribution.getAttribute(EXPORT_EXTENSIONPOINT_ATTRIBUTE_EXTENSION)
                            .equals(formatExtension)) {
                final Object o = contribution.createExecutableExtension(
                                EXPORT_EXTENSIONPOINT_ATTRIBUTE_EXPORTCLASS);
                if (o instanceof IExport) {
                    exportClass = (IExport) o;
                }
            }
        }

        if (exportClass == null) {
            final NoContributorMatchingException exception = new NoContributorMatchingException();
            LOGGER.throwing(this.getClass().getName(), method, exception);
            throw exception;
        }
        LOGGER.exiting(this.getClass().getName(), method, exportClass);
        return exportClass;
    }

}
