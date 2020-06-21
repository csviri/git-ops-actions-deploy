package com.coderealms.gitopsactions.deploy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.kohsuke.github.GHPullRequest;
import org.kohsuke.github.GHRef;

import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GitHubServiceTest {

//  TODO proper integration testing
    private GitHubService gitHubService;

    @BeforeAll
    public void setup() {
        String token = System.getenv("GITOPS_ACTIONS_GITHUB_TOKEN");
        String testRepo = System.getenv("GITOPS_ACTIONS_TEST_REPO");
        gitHubService = new GitHubService(token, testRepo);
    }

    @Test
    public void handlesBasicWorkflow() throws IOException {
        String branch = "pr-branch";
        String version = "1.0.6";
        GHRef ref = gitHubService.createBranch(branch, "master");
        gitHubService.propagateVersionFile("service/version6", version, branch);
        GHPullRequest pr = gitHubService.createPullRequest(branch, "master", version);
        pr.merge("Merge PR");
        ref.delete();
    }


}
