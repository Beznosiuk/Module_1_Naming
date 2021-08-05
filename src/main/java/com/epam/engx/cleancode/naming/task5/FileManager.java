package com.epam.engx.cleancode.naming.task5;

import com.epam.engx.cleancode.naming.task5.predicates.FileExtensionsPredicate;
import com.epam.engx.cleancode.naming.task5.thirdpartyjar.InvalidDirectoryException;
import com.epam.engx.cleancode.naming.task5.thirdpartyjar.InvalidFileTypeException;
import com.epam.engx.cleancode.naming.task5.thirdpartyjar.PropertyUtil;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class FileManager {

    private static final String[] IMAGES_TYPES = {"jpg", "png"};
    private static final String[] DOCUMENT_TYPES = {"pdf", "doc"};

    private final String basePath = PropertyUtil.loadProperty("basePath");

    public File retrieveFile(String fileName) {
        validateFileType(fileName);
        final String directoryPath = basePath + File.separator;
        return Paths.get(directoryPath, fileName).toFile();
    }

    public List<String> images() {
        return getFilesByPath(basePath, IMAGES_TYPES);
    }

    public List<String> documentFiles() {
        return getFilesByPath(basePath, DOCUMENT_TYPES);
    }

    private void validateFileType(String fileName) {
        if (isInvalidFileType(fileName)) {
            throw new InvalidFileTypeException("File type not Supported: " + fileName);
        }
    }

    private boolean isInvalidFileType(String fileName) {
        return isInvalidImage(fileName) && isInvalidDocument(fileName);
    }

    private boolean isInvalidImage(String fileName) {
        FileExtensionsPredicate imageExtensionsPredicate = new FileExtensionsPredicate(IMAGES_TYPES);
        return !imageExtensionsPredicate.isValidFile(fileName);
    }

    private boolean isInvalidDocument(String fileName) {
        FileExtensionsPredicate documentExtensionsPredicate = new FileExtensionsPredicate(DOCUMENT_TYPES);
        return !documentExtensionsPredicate.isValidFile(fileName);
    }

    private List<String> getFilesByPath(String directoryPath, String[] allowedExtensions) {
        final FileExtensionsPredicate predicate = new FileExtensionsPredicate(allowedExtensions);
        return Arrays.asList(Objects.requireNonNull(getDirectoryFile(directoryPath).list(getFilenameFilterByPredicate(predicate))));
    }

    private FilenameFilter getFilenameFilterByPredicate(final FileExtensionsPredicate fileExtensionsPredicate) {
        return new FilenameFilter() {
            @Override
            public boolean accept(File directoryInstance, String fileName) {
                return fileExtensionsPredicate.isValidFile(fileName);
            }
        };
    }

    private File getDirectoryFile(String directoryPath) {
        File directoryInstance = new File(directoryPath);
        validateDirectory(directoryInstance);
        return directoryInstance;
    }

    private void validateDirectory(File directoryInstance) {
        if (isNotDirectory(directoryInstance)) {
            throw new InvalidDirectoryException("Invalid directory found: " + directoryInstance.getAbsolutePath());
        }
    }

    private boolean isNotDirectory(File directoryInstance) {
        return !directoryInstance.isDirectory();
    }

}