/************************************************************************************************/
/* i-Code CNES is a static code analyzer. */
/* This software is a free software, under the terms of the Eclipse Public License version 1.0. */
/* http://www.eclipse.org/legal/epl-v10.html */
/************************************************************************************************/

package fr.cnes.analysis.tools.fortran77.rules;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.Path;
import org.junit.Test;

import fr.cnes.analysis.tools.analyzer.Analyzer;
import fr.cnes.analysis.tools.analyzer.datas.CheckResult;

public class TestGlobal_2 {

    /** This list contains all the violations when the analyse is executed **/
    public static List<CheckResult> list = new LinkedList<CheckResult>();
    List<File> listFiles = new LinkedList<File>();

    /**********************/
    /** PARAMS TO DEFINE **/
    /**********************/

    /** Folder where the function find files to execute the analyze **/
    final String resources = "/resources/f77_2";
    /** Extension of the files to be analyzed **/
    final String extension = "f";
    /** Id to execute the analysis **/
    final String ruleExtensionId = "fr.cnes.analysis.tools.fortran77.analyzer.rule";

    /**
     * Function test to validate global test. This function do - get all files
     * in /resources folder - run analysis in this files - export results to
     * globalTest.txt file - compare file with the last one
     * 
     * NOTE: to run this test in jUnit: Run As > jUnit PlugIn in test
     */
    @Test
    public void runGlobalTest() {
        try {
            /** File where to save the result of the execution **/
            File fileResult = new File("resources/globalTest_2.txt");
            fileResult.deleteOnExit();
            /**
             * File to compare with fileResult. This file is the verified
             * version of the execution
             **/
            File fileResultValidated = new File("resources/globalTestValidated_2.txt");

            /** Get resources file **/
            String resourcesPath = System.getProperty("user.dir") + resources;
            File folder = new File(resourcesPath);
            /** Save files into a list **/
            getFilesIntoFolder(folder);

            /** Create the analysis job **/
            Analyzer analysis = new Analyzer();
            List<String> extensionIds = new ArrayList<>();
            extensionIds.add(ruleExtensionId);

            TestGlobal_2.list = analysis.check(listFiles, extensionIds, null);

            /** Export values into file **/
            createExportFile(fileResult);

            /** Compare new test with last one **/
            assertTrue(compareFiles(fileResult, fileResultValidated));
        } catch (Exception e) {
            fail("Erreur d'analyse " + e.getMessage());
        }
    }

    private void getFilesIntoFolder(File folder) {
        if (folder.isDirectory()) {
            File[] listOfFiles = folder.listFiles();
            /** For each file, check the extension and save IPath into List **/
            for (File file : listOfFiles) {
                if (file.isDirectory())
                    getFilesIntoFolder(file);
                else {
                    int i = file.getAbsolutePath().lastIndexOf(".");
                    if (file.getAbsolutePath().substring(i + 1).equals(extension)) {

                        listFiles.add(file);
                    }
                }
            }
        }

    }

    /**
     * Function to create the error file. The file has the following: RuleName
     * FileName NumError
     */
    private void createExportFile(File fileResult) {
        try {
            /** Create result file **/
            BufferedWriter output = new BufferedWriter(new FileWriter(fileResult));

            /** If the list is bigger than one **/
            if (list.size() > 1) {
                String rule = list.get(0).getName();
                String file = new Path(list.get(0).getFile().getAbsolutePath()).lastSegment();
                int errors = 1;
                /** Iterate over the elements **/
                for (int i = 1; i < list.size(); i++) {
                    CheckResult violation = list.get(i);
                    /** If the is more errors in the same rule **/
                    if (violation.getName().equals(rule)) {
                        /**
                         * If there is more errors in the same file -> increase
                         * error
                         **/
                        if (new Path(violation.getFile().getAbsolutePath()).lastSegment()
                                        .equals(file)) {
                            errors++;
                        }
                        /** If the filename has change -> print error **/
                        else {
                            output.write(rule + " " + file + " " + errors + "\n");
                            file = new Path(violation.getFile().getAbsolutePath()).lastSegment();
                            errors = 1;
                        }
                    }
                    /** If rule has change -> print error **/
                    else {
                        output.write(rule + " " + file + " " + errors + "\n");
                        rule = violation.getName();
                        file = new Path(violation.getFile().getAbsolutePath()).lastSegment();
                        errors = 1;
                    }
                }
            }
            /** Only one error -> print directly **/
            else if (list.size() > 0) {
                output.write(list.get(0).getName() + " "
                                + new Path(list.get(0).getFile().getAbsolutePath()).lastSegment()
                                + " 1\n");
            }
            /** After run for all files: close file writer **/
            output.close();
        } catch (IOException e) {
            fail("Erreur d'analyse (IOException)");
        }
    }

    /**
     * Comparison between files
     * 
     * @param fileResult
     *            File generated by the analysis.
     * @param fileResultValidated
     *            file to compare the analysis with.
     * @return equals indicate the equality of the files
     */
    private boolean compareFiles(File fileResult, File fileResultValidated) {
        boolean equals = true;
        try (final BufferedReader testReader = new BufferedReader(new FileReader(fileResult));
                        final BufferedReader validatedReader = new BufferedReader(
                                        new FileReader(fileResultValidated));) {
            /** String for compare **/
            String testedLine = null;
            String validatedLine = null;

            /** Loop over the lines to find differences **/
            testedLine = testReader.readLine();
            validatedLine = validatedReader.readLine();
            while ((testReader.readLine() != null) && ((validatedReader.readLine()) != null)
                            && equals) {
                if (!testedLine.equalsIgnoreCase(validatedLine)) {
                    equals = false;
                }
                testedLine = testReader.readLine();
                validatedLine = validatedReader.readLine();
            }
            /**
             * Both documents should be at their last line at the end of the
             * test.
             */
            if (!(testedLine == null && validatedLine == null)) {
                equals = false;
            }

            testReader.close();
            validatedReader.close();
        } catch (

        FileNotFoundException exception) {
            fail("Erreur d'analyse (FileNotFoundException)");
            exception.printStackTrace();
        } catch (IOException exception) {
            fail("Erreur d'analyse (IOException)");
            exception.printStackTrace();
        }
        /** Return value **/
        return equals;
    }

}
