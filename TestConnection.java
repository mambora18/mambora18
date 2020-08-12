package com.git.api;

import org.kohsuke.github.*;

import java.io.IOException;

public class TestConnection {
    public static void main(String[] srgs) throws IOException {
        //GitHub github = GitHub.connect();
        //github.getRepository("https://github.com/mambora18/mambora18");
        //GitHub github1 =  new GitHubBuilder().withPassword("mambora18","***").build();

        //System.out.println(github1.getUser("mambora18"));

        //System.out.println(github1.getConnector().connect("https://github.com/mambora18/mambora18").)

        //github1.getRepository("https://github.com/mambora18/mambora18").createPullRequest()



//        github1.getRepository("mambora18/mambora18")
//                .createPullRequest("first PR","head","base","body").isMerged();


        GitHub github = new GitHubBuilder().withPassword("mambora18","***").build();

        GHRepository gitRepo = github.getRepository("mambora18/mambora18");
        GHContentBuilder content = gitRepo.createContent().branch("master");
        content.content("testing again").path("files/testfile.txt").branch("master").message("committing to master again").commit();


    }
}
