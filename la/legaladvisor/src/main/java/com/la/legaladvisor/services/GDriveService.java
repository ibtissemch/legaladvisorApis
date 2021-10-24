package com.la.legaladvisor.services;


import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

@Service
public class GDriveService {
    private static final String APPLICATION_NAME = "Google Drive API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE);
    private static final String CREDENTIALS_FILE_PATH = "credentials.json";
    private static final String FOLDER_TYPE = "application/vnd.google-apps.folder";
    final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
    // Build a new authorized API client service.
    Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
            .setApplicationName(APPLICATION_NAME)
            .build();

    public GDriveService() throws GeneralSecurityException, IOException {
    }

    /**
     * Creates an authorized Credential object.
     *
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = GCalenderService.class.getClassLoader().getResourceAsStream(CREDENTIALS_FILE_PATH);

        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8889).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    public List<File> getFiles(String FileName) throws IOException, GeneralSecurityException {

        // Print the names and IDs for up to 10 files.
        FileList result = service.files().list()
                .setPageSize(10)
                .setFields("nextPageToken, files(id, name)")
                .execute();
        List<File> files = result.getFiles();
        if (files == null || files.isEmpty()) {
            System.out.println("No files found.");
            return null;
        } else {
            System.out.println("Files:");
            for (File file : files) {
                System.out.printf("%s (%s)\n", file.getName(), file.getId());
            }
            return files;
        }
    }

    public List<File> getFilesOrFileByName(String FileName) throws IOException, GeneralSecurityException {

        // Print the names and IDs for up to 10 files.
        FileList result = service.files().list()
                .setPageSize(10)
                .setFields("nextPageToken, files(id, name)")
                .execute();
        List<File> files = result.getFiles();
        if (files == null || files.isEmpty()) {
            System.out.println("No files found.");
            return null;
        } else {
            System.out.println("Files:");
            for (File file : files) {
                System.out.printf("%s (%s)\n", file.getName(), file.getId());
            }
            return files;
        }
    }
    public List<File> getFilesOrFileByNameAndType(String FileName, String type) throws IOException, GeneralSecurityException {

        // Print the names and IDs for up to 10 files.
        FileList result = service.files().list()
                .setQ("mimeType='"+ type +"'")
                .setQ("name='"+ FileName +"'")
                .setPageSize(10)
                .setFields("nextPageToken, files(id, name)")
                .execute();
        List<File> files = result.getFiles();
        if (files == null || files.isEmpty()) {
            System.out.println("No files found.");
            return null;
        } else {
            System.out.println("Files:");
            for (File file : files) {
                System.out.printf("%s (%s)\n", file.getName(), file.getId());
            }
            return files;
        }
    }


    public void downloadFile(String fileId) throws IOException {
        OutputStream outputStream = new ByteArrayOutputStream();
        service.files().get(fileId)
                .executeMediaAndDownloadTo(outputStream);
    }

    public File UploadFile(MultipartFile fileinput,String folderId) throws IOException {
        java.io.File convFile = new java.io.File(this.getClass().getResource("/").getFile() +fileinput.getName());
        fileinput.transferTo(convFile);
        File gFile = new File();
        gFile.setName(fileinput.getName());
        gFile.setParents(Collections.singletonList(folderId));
        FileContent mediaContent = new FileContent("application/pdf", convFile);
        File file = service.files().create(gFile, mediaContent)
                .setFields("id")
                .execute();
        System.out.println("File ID: " + file.getId());
        return file;
    }

    public String createFolder(String numCase) throws Exception {
        List<File> files = getFilesOrFileByNameAndType(numCase,FOLDER_TYPE);
        if(files != null) {
            if(files.size() == 1) {
                return files.get(0).getId();
            }
            throw  new Exception(" on or more file or folders with same");
        }
        File fileMetadata = new File();
        fileMetadata.setName(numCase);
        fileMetadata.setMimeType(FOLDER_TYPE);

        File file = service.files().create(fileMetadata)
                .setFields("id")
                .execute();
        System.out.println("Folder ID: " + file.getId());
       return  file.getId();
    }
}