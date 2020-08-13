package com.azure.function;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import org.kohsuke.github.*;

import java.io.*;

/**
 * Azure Functions with HTTP Trigger.
 */
public class HttpTriggerFunction {
    /**
     * This function listens at endpoint "/api/HttpTrigger-Java". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/HttpTrigger-Java
     * 2. curl {your host}/api/HttpTrigger-Java?name=HTTP%20Query
     */
    @FunctionName("HttpTriggerForGitPush")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", methods = {HttpMethod.GET, HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) throws IOException {
        context.getLogger().info("Java HTTP trigger processed a request.");

        // Parse query parameter
        String query = request.getQueryParameters().get("name");
        String name = request.getBody().orElse(query);

        //Logic to push code to git repo
        GitHub github = new GitHubBuilder().withPassword("mambora18","***").build();

        GHRepository gitRepo = github.getRepository("mambora18/mambora18");
        GHContentBuilder content = gitRepo.createContent().branch("master");

        File file = new File ("C:\\MAMTA BORA\\testingBlob.txt");
        FileInputStream stream = new FileInputStream(file);
        byte[] bytes = stream.toString().getBytes();

        content.content(bytes).path("blobFiles/testingBlob1.txt").branch("master").message("committing to the blob files").commit();

        if (name == null) {
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST).body("Please pass a name on the query string or in the request body").build();
        } else {
            return request.createResponseBuilder(HttpStatus.OK).body("Hello, " + name).build();
        }
    }
}
