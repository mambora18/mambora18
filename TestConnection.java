package com.git.api;

import org.kohsuke.github.*;

import java.io.*;

public class TestConnection {
    public static void main(String[] srgs) throws IOException {

        /*  code to push the file to git repository*/
        GitHub github = new GitHubBuilder().withPassword("mambora18","****#").build();

        GHRepository gitRepo = github.getRepository("mambora18/mambora18");
        GHContentBuilder content = gitRepo.createContent().branch("master");

        File file = new File ("C:\\MAMTA BORA\\testingBlob.txt");
        FileInputStream stream = new FileInputStream(file);
        byte[] bytes = stream.toString().getBytes();

        content.content(bytes).path("blobFiles/testingBlob2.txt").branch("master").message("committing to the blob files").commit();


    }
}
