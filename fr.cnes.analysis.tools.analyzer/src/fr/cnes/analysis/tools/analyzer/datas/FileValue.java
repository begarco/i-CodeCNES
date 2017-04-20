/* 
 * i-Code CNES is a static code analyser. 
 * This software is a free software, under the terms of the Eclipse Public License version 1.0. 
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 */ 
package fr.cnes.analysis.tools.analyzer.datas;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IPath;

/**
 * This class store the metric value on a file, the name of the file and all
 * values inside the file (in a function, a subprogram, etc.) if T is a float,
 * else it stores the name of the file and all rules violations inside the file
 * if T is an integer. The value represents the number of violations inside the
 * file for a rule.
 * 
 */
public class FileValue {
    /** Id of metric. **/
    private String metricId;
    /** Metric's name. **/
    private String metricName;
    /** File's path. **/
    private IPath filePath;
    /** Value of the metric for the file. **/
    private Float value;
    /** List of values inside the file. **/
    private List<FunctionValue> functionValues;

    /**
     * Constructor of the class with file's path.
     * 
     * @param pFilePath
     *            the file's path
     */
    public FileValue(final IPath pFilePath) {
        this.metricName = "";
        this.metricId = "";
        this.filePath = pFilePath;
        this.value = Float.NaN;
        this.functionValues = new LinkedList<FunctionValue>();
    }

    /**
     * Constructor of the class with metric id, name and file's path.
     * 
     * @param pMetricId
     *            the metric id
     * @param pMetricName
     *            the metric name
     * @param pFilePath
     *            the file's path
     */
    public FileValue(final String pMetricId, final String pMetricName,
            final IPath pFilePath) {
        this.metricId = pMetricId;
        this.metricName = pMetricName;
        this.filePath = pFilePath;
        this.value = Float.NaN;
        this.functionValues = new LinkedList<FunctionValue>();
    }

    /**
     * Getter for metric's id.
     * 
     * @return the metricId
     */
    public String getMetricId() {
        return this.metricId;
    }

    /**
     * Getter for metric's name.
     * 
     * @return the metricName
     */
    public String getMetricName() {
        return this.metricName;
    }

    /**
     * Getter for file's path.
     * 
     * @return the filePath
     */
    public IPath getFilePath() {
        return this.filePath;
    }

    /**
     * Getter for the value.
     * 
     * @return the value
     */
    public Float getValue() {
        return this.value;
    }

    /**
     * Getter for the list of function values.
     * 
     * @return the functionValues
     */
    public List<FunctionValue> getFunctionValues() {
        return this.functionValues;
    }

    /**
     * Setter for metric's id.
     * 
     * @param pMetricId
     *            the metricId to set
     */
    public void setMetricId(final String pMetricId) {
        this.metricId = pMetricId;
    }

    /**
     * Setter for metric's name.
     * 
     * @param pMetricName
     *            the metricName to set
     */
    public void setMetricName(final String pMetricName) {
        this.metricName = pMetricName;
    }

    /**
     * Setter for file's path.
     * 
     * @param pFilePath
     *            the filePath to set
     */
    public void setFilePath(final IPath pFilePath) {
        this.filePath = pFilePath;
    }

    /**
     * @param pValue
     *            the value to set
     */
    public void setValue(final Float pValue) {
        this.value = pValue;
    }

    /**
     * Setter for list of function values with a list.
     * 
     * @param pFunctionValues
     *            the functionValues to set
     */
    public void setFunctionValues(final List<FunctionValue> pFunctionValues) {
        this.functionValues = pFunctionValues;
    }

    /**
     * Setter for list of function values with an array.
     * 
     * @param pFunctionValues
     *            the functionValues to set
     */
    public void setFunctionValues(final FunctionValue[] pFunctionValues) {
        this.functionValues = new LinkedList<FunctionValue>();
        for (final FunctionValue pValue : pFunctionValues) {
            this.functionValues.add(pValue);
        }
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object object) {
        boolean isEqual;
        if (object instanceof FileValue) {
            isEqual =
                    this.metricId.equals(((FileValue) object).getMetricId())
                            && this.filePath.equals(((FileValue) object)
                                    .getFilePath());
        } else {
            isEqual = false;
        }
        return isEqual;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        assert false : "hashCode not designed";
        return this.value.intValue();
    }
}
