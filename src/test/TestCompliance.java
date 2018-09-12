package test;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.junit.Test;

public class TestCompliance {

    @Test
    public void verifyTestCoverage() throws Exception {

        List<Class> serviceClasses = getClassesForPackage("service");
        List<Class> testClasses = getClassesForPackage("test");
        
        for(Class c : serviceClasses) {
            System.out.println(c);
        }
        for(Class c : testClasses) {
            System.out.println(c);
        }
        
        for(Class serviceClass : serviceClasses) {
            long count = testClasses.stream().filter( testClass -> testClass.getSimpleName().equals(serviceClass.getSimpleName() + "Test") ).count();
            if(count == 0) {
                fail("Missing test for service class: " + serviceClass.getName());
            }
        }
    }

    private static List<Class> getClassesForPackage(String pckgname) throws ClassNotFoundException {
        // This will hold a list of directories matching the pckgname. There may be more
        // than one if a package is split over multiple jars/paths
        ArrayList<File> directories = new ArrayList<File>();
        String packageToPath = pckgname.replace('.', '/');
        try {
            ClassLoader cld = Thread.currentThread().getContextClassLoader();
            if (cld == null) {
                throw new ClassNotFoundException("Can't get class loader.");
            }

            // Ask for all resources for the packageToPath
            Enumeration<URL> resources = cld.getResources(packageToPath);
            while (resources.hasMoreElements()) {
                directories.add(new File(URLDecoder.decode(resources.nextElement().getPath(), "UTF-8")));
            }
        } catch (NullPointerException x) {
            throw new ClassNotFoundException(
                    pckgname + " does not appear to be a valid package (Null pointer exception)");
        } catch (UnsupportedEncodingException encex) {
            throw new ClassNotFoundException(
                    pckgname + " does not appear to be a valid package (Unsupported encoding)");
        } catch (IOException ioex) {
            throw new ClassNotFoundException("IOException was thrown when trying to get all resources for " + pckgname);
        }

        ArrayList<Class> classes = new ArrayList<Class>();
        // For every directoryFile identified capture all the .class files
        while (!directories.isEmpty()) {
            File directoryFile = directories.remove(0);
            if (directoryFile.exists()) {
                // Get the list of the files contained in the package
                File[] files = directoryFile.listFiles();

                for (File file : files) {
                    // we are only interested in .class files
                    if ((file.getName().endsWith(".class")) && (!file.getName().contains("$"))) {
                        // removes the .class extension
                        int index = directoryFile.getPath().indexOf(packageToPath);
                        String packagePrefix = directoryFile.getPath().substring(index).replace('/', '.');
                        ;
                        try {
                            String className = packagePrefix + '.'
                                    + file.getName().substring(0, file.getName().length() - 6);
                            classes.add(Class.forName(className));
                        } catch (NoClassDefFoundError e) {
                            // do nothing. this class hasn't been found by the loader, and we don't care.
                        }
                    } else if (file.isDirectory()) { // If we got to a subdirectory
                        directories.add(new File(file.getPath()));
                    }
                }
            } else {
                throw new ClassNotFoundException(
                        pckgname + " (" + directoryFile.getPath() + ") does not appear to be a valid package");
            }
        }
        return classes;
    }

}
