package com.epam.engx.cleancode.naming.task5.predicates;


import com.epam.engx.cleancode.naming.task5.thirdpartyjar.Predicate;

public class FileExtensionsPredicate implements Predicate<String> {
    private final String[] extensions;

    public FileExtensionsPredicate(String[] extensions) {
        this.extensions = extensions;
    }

    @Override
    public boolean isValidFile(String fileName) {
        for (String extension : extensions) {
            if (fileName.toLowerCase().endsWith(extension)) {
                return true;
            }
        }
        return false;
    }
}
