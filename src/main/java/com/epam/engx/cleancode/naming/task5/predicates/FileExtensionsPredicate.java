package com.epam.engx.cleancode.naming.task5.predicates;


import com.epam.engx.cleancode.naming.task5.thirdpartyjar.Predicate;

public class FileExtensionsPredicate implements Predicate<String> {
    private final String[] allowedExtensions;

    public FileExtensionsPredicate(String[] allowedExtensions) {
        this.allowedExtensions = allowedExtensions;
    }

    @Override
    public boolean test(String fileName) {
        for (String extension : allowedExtensions) {
            if (fileName.toLowerCase().endsWith(extension)) {
                return true;
            }
        }
        return false;
    }
}
